/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.ProfessorJpaController;
import Dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import Modelo.Professor;
import Util.EMF;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Helismara
 */
@ManagedBean
@RequestScoped
public class ProfessorMB {

    private EntityManagerFactory emf = EMF.getFactory();
    private ProfessorJpaController dao = new ProfessorJpaController(emf);
    private Professor professor = new Professor();
    
    private List<Professor> listProfessores = new ArrayList<Professor>();
    /**
     * Creates a new instance of FuncionarioMB
     */
    
    private String mensagem;
    private String pesqProf;
    //private Object ex;
    
    
    public ProfessorMB() {
        listar();
    }
    
    public void inserir(){
        try{
            getDao().create(professor);
            this.setMensagem(this.getProfessor().getNome()+ " cadastrado com sucesso!");
            professor = new Professor();
        }catch(Exception ex){
            setMensagem(this.getProfessor().getNome() + "cadastro não realizado!");
            Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
            //e.printStackTrace();
        }
        listar();
    }
    
    public void alterar() throws Exception {
        try {
            dao.edit(professor);
            setMensagem(this.getProfessor().getNome() + " alterado com sucesso!");
            professor = new Professor();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("id não existe");
            Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        listar();
    }

    public void excluir() {
        try {
            dao.destroy(professor.getId());
            setMensagem(this.getProfessor().getNome() + " excluído com sucesso!");
            professor = new Professor();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("id não existe");
            Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        listar();
    }
    
     public void excluirTabela(Long id) {
        try {
            dao.destroy(id);
            setMensagem("Excluído com sucesso!");
            professor = new Professor();
        } catch (NonexistentEntityException ex) {
            this.setMensagem("Cadastro não pode ser excluído");
            Logger.getLogger(ProfessorMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        listar();
    }
    
     public void cancelar(){
        professor = new Professor();
    }
     
     

    public void listar(){
        listProfessores = dao.findProfessorEntities();
    }
    
    public void pesquisarProfessores(){
        listProfessores = new ArrayList<Professor>();
        for(Professor pf : dao.findProfessorEntities()){
            if ((pf.getNome().toLowerCase().contains(pesqProf))) {
                listProfessores.add(pf);
            }
        }
        setPesqProf("");
    }
    
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * @return the dao
     */
    public ProfessorJpaController getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(ProfessorJpaController dao) {
        this.dao = dao;
    }

    /**
     * @return the funcionario
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return the funcionarios
     */
    public List<Professor> getProfessores() {
        return listProfessores;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setProfessores(List<Professor> professores) {
        this.listProfessores = professores;
    }

    /**
     * @return the mensagem
     */
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
     * @return the pesqProf
     */
    public String getPesqProf() {
        return pesqProf;
    }

    /**
     * @param pesqProf the pesqProf to set
     */
    public void setPesqProf(String pesqProf) {
        this.pesqProf = pesqProf;
    }
}
