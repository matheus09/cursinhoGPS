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
import util.EMF;

/**
 *
 * @author Monnalisa Christina
 */
@ManagedBean
@SessionScoped
public class CursoMB {

    private CursoJpaController dao = new CursoJpaController(EMF.getEntityManagerFactory());
    private Curso curso = new Curso();
    private List<Curso> listaCurso = new ArrayList<Curso>();
    private String mensagem;
    private String pesqCurso;
    
    public CursoMB() {
        pesquisar();
    }

    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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
            this.setMensagem(this.getCurso().getNome() + " cadastrado com sucesso!");
            curso = new Curso();
        } catch (Exception ex) {
            setMensagem(this.getCurso().getNome() + "cadastro não realizado!");
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    public void alterar() throws Exception {
        try {
            dao.edit(curso);
            setMensagem(this.getCurso().getNome() + " alterado com sucesso!");
            curso = new Curso();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("id não existe");
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }

    public void excluir() {
        try {
            dao.destroy(curso.getId());
            setMensagem(this.getCurso().getNome() + " excluído com sucesso!");
            curso = new Curso();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("id não existe");
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }
    
    public void excluirTabela(Long id) {
        try {
            dao.destroy(id);
            setMensagem(this.getCurso().getNome() + " excluído com sucesso!");
            curso = new Curso();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("Cadastro não pode ser excluído");
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pesquisar();
    }
    
     public void cancelar(){
        curso = new Curso();
    }

    public void pesquisar() {
        listaCurso =  dao.findCursoEntities();
        
    }
    
     public void pesquisarPorNomeDeCurso(){
        listaCurso = new ArrayList<Curso>();
        for(Curso cr : dao.findCursoEntities()){
            if(cr.getNome().toUpperCase().contains(getPesqCurso().toUpperCase())){
                listaCurso.add(cr);
            }
        }
        setPesqCurso("");
    }
     
}

