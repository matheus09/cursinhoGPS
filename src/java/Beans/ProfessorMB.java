/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ProfessorJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;
import modelo.Professor;
import util.EMF;
import util.FacesUtil;

/**
 *
 * @author Helismara
 */
@ManagedBean
@RequestScoped
public class ProfessorMB {

    private Professor prof = new Professor();
    private ProfessorJpaController dao = new ProfessorJpaController(EMF.getEntityManagerFactory());
    private List<Professor> profs;
    private String pesquisa;

    /**
     * Creates a new instance of ProfessorMB
     */
    public ProfessorMB() {
        pesquisar();
    }

    public void carregar(Professor pf) {
        setProf(pf);
    }

    public void cadastrar() {
        
        if (dao.pesquisarPorLogin(pesquisa) != true) {
            try {

                dao.create(prof);
                FacesUtil.adicionarMensagem("formulario", "O professor foi cadastrado");
                prof = new Professor();

            } catch (EntityExistsException e) {
                FacesUtil.adicionarMensagem("formulario", "Este aluno já está cadastrado");
            } catch (RollbackException e) {
                FacesUtil.adicionarMensagem("formulario", "Erro: Algo deu errado "
                        + "no cadastro");
            }
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", "Testing");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            pesquisar();
        } else {
            FacesUtil.adicionarMensagem("formulario", "Erro:  O login já existe no sistema!");
        }

    }

    /*
     public void alterar(Long id){
        
     try {
     FacesUtil.adicionarMensagem("formulario", "Chegou em alterar!!!");
     if(id != 0)
     {
     dao.edit(dao.findProfessor(id));
     FacesUtil.adicionarMensagem(getProf().getNome() + "formulario", "O professor foi alterado");
     }
     else {
     FacesUtil.adicionarMensagem("formulario", "Nenhum professor foi "
     + "selecionado. Clique em um professor para alterá-lo.");
     }
            
     } catch (NonexistentEntityException ex) {
     Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
     FacesUtil.adicionarMensagem("formulario", "Erro: O professor não foi "
     + "cadastrado ou já havia sido excluído");
     } catch (Exception ex) {
     Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
     FacesUtil.adicionarMensagem("formulario", "Erro: Algo deu errado "
     + "na alteração");
     }
        
        
     FacesContext context = FacesContext.getCurrentInstance();
     //context.addMessage(null, new FacesMessage("Erro no banco de dados"));
     context.addMessage("formulario:nomeDoFunc", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Alterado"));  
        
     pesquisar();
     }  
     * //
     * 
     * 
     * 
    
    
     /**
     * Limpa o formulário de cadastro de alunos.
     * Apenas atribui um novo Aluno para este bean.
     */
    public void alterar() {
        try {
            if (prof.getId() != null) {
                dao.edit(prof);
                prof = new Professor();
                FacesUtil.adicionarMensagem("formulario", "O professor foi alterado");
            } else {
                FacesUtil.adicionarMensagem("formulario", "Nenhum professor foi "
                        + "selecionado. Clique em um professor para alterá-lo.");
            }

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMensagem("formulario", "Erro: O professor não foi "
                    + "cadastrado ou já havia sido excluído");
        } catch (Exception ex) {
            Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMensagem("formulario", "Erro: Algo deu errado "
                    + "na alteração");
        }
        pesquisar();
    }

    public void cancelar() {
        setProf(new Professor());
    }

    public void excluir(Long id) {

        try {
            dao.destroy(id);
            FacesUtil.adicionarMensagem("formulario", "O professor foi excluído");
        } catch (NonexistentEntityException ex) {
            FacesUtil.adicionarMensagem("formulario", "Erro: O professor não foi "
                    + "cadastrado ou já havia sido excluído");
            Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    /**
     * Pesquisa os alunos por nome de acordo com o atributo pesquisa. Não
     * retorna nada. Para acessar os resultados, utilize o atributo alunos deste
     * bean.
     */
    public void pesquisar() {
        profs = dao.findProfessorEntities();
    }

    public void pesquisarPorNome() {
        profs = dao.pesquisarPorNome(pesquisa);
    }

    public boolean pesquisarPorLogin() {
        return dao.pesquisarPorLogin(pesquisa);
    }

    /**
     * Limpa a pesquisa e pega todos os alunos. Não retorna nada. Para acessar
     * os resultados, utilize o atributo alunos deste bean.
     */
    public void getTodos() {
        pesquisa = "";
        getProfs();
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    /**
     * @return the prof
     */
    public Professor getProf() {
        return prof;
    }

    /**
     * @param prof the prof to set
     */
    public void setProf(Professor prof) {
        this.prof = prof;
    }

    /**
     * @return the profs
     */
    public List<Professor> getProfs() {
        return profs;
    }

    /**
     * @param profs the profs to set
     */
    public void setProfs(List<Professor> profs) {
        this.profs = profs;
    }
}
