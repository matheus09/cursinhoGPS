package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Curso;
import dao.CursoJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;
import util.EMF;
import util.FacesUtil;

/**
 * UFRN - GESTÃO DE PROJETOS
 * @author Monnalisa Christina
 * data: 10.10.2013
 */
@ManagedBean
@SessionScoped
public class CursoMB {

    private CursoJpaController dao = new CursoJpaController(EMF.getEntityManagerFactory());
    private Curso curso = new Curso();
    private List<Curso> listaCurso = new ArrayList<Curso>();
    private String pesqCurso;

    public CursoMB() {
        pesquisar();
    }

    /**
     * @return the ListaCurso
     */
    public List<Curso> getListaCurso() {
        return listaCurso;
    }

    /**
     * @param ListaCurso the ListaCurso to set
     */
    public void setListaCurso(List<Curso> ListaCurso) {
        this.listaCurso = ListaCurso;
        pesquisar();

    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the pesqCurso
     */
    public String getPesqCurso() {
        return pesqCurso;
    }

    /**
     * @param pesqCurso the pesqCurso to set
     */
    public void setPesqCurso(String pesqCurso) {
        this.pesqCurso = pesqCurso;
    }

    public void inserir() {
        try {
            dao.create(curso);
            curso = new Curso();
            FacesUtil.adicionarMensagem("formularioCurso", "O Curso foi cadastrado");
        } catch (EntityExistsException e) {
            FacesUtil.adicionarMensagem("formularioCurso", "Este Curso já está cadastrado");
        } catch (RollbackException e) {
            FacesUtil.adicionarMensagem("formularioCurso", "Erro: Algo deu errado " + "no cadastro");
        }
        pesquisar();
    }

   
    public void alterarCurso() {
        try {
            dao.edit(curso);
            curso = new Curso();
            FacesUtil.adicionarMensagem("formularioCurso", "O Curso foi alterado");
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMensagem("formularioCurso", "Erro: O Curso não foi " + "cadastrado ou já havia sido excluído");
        } catch (Exception ex) {
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMensagem("formularioCurso", "Erro: Algo deu errado " + "na alteração");
        }
        pesquisar();
    }

    public void excluirTabela(Long id) {
        try {
            dao.destroy(id);
            FacesUtil.adicionarMensagem("formularioCurso", "O Curso foi excluído");
            curso = new Curso();
        } catch (NonexistentEntityException ex) {
            FacesUtil.adicionarMensagem("formularioCurso", "Erro: O Curso não foi " + "cadastrado ou já havia sido excluído");
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    public void cancelar() {
        setCurso(new Curso());

    }

    public void pesquisar() {
        listaCurso = dao.findCursoEntities();

    }

    public void pesquisarCursos() {
        listaCurso = new ArrayList<Curso>();
        for (Curso cr : dao.findCursoEntities()) {
            if ((cr.getNome().toLowerCase().contains(pesqCurso) || (cr.getDuracao().toLowerCase().contains(pesqCurso)))) {
                listaCurso.add(cr);
            }
        }
        setPesqCurso("");
    }
}
