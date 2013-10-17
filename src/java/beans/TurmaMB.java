/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.TurmaJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;
import modelo.Turma;
import util.EMF;
import util.FacesUtil;

/**
 *
 * @author Hyago Brendoll
 */
@ManagedBean
@RequestScoped
public class TurmaMB {
    private TurmaJpaController dao;
    private Turma turma;
    private List<Turma> turmas;
    private String nomePesquisa;

    /**
     * Creates a new instance of TurmaMB
     */
    public TurmaMB() {
        dao = new TurmaJpaController(EMF.getEntityManagerFactory());
        turma = new Turma();
        turmas = new ArrayList<Turma>();
    }
    
    public void inserirTurma(){
        try{
            turma.setId(null);
            dao.create(turma);
            FacesUtil.adicionarMensagem("formTurma", "Turma cadastrada com sucesso");
            novaTurma();
        }catch (EntityExistsException e){
            FacesUtil.adicionarMensagem("formTurma", "Erro, turma já cadastrada");
        }catch (RollbackException e){
            FacesUtil.adicionarMensagem("formTurma", "Erro inesperado, tente novamente");
        }
        pesquisarTodos();
    }
    
    public void alterarTurma(){
        try {
            dao.edit(turma);
            FacesUtil.adicionarMensagem("formTurma", "Turma alterada com sucesso");
            novaTurma();
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMensagem("formTurma", "Erro, turma não existe");
        } catch (Exception ex) {
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMensagem("formTurma", "Erro inesperado, tente novamente");
        }
        pesquisarTodos();
    }
    
    public void excluirTurma(Long id){
        try {
            dao.destroy(id);
            FacesUtil.adicionarMensagem("formTurma", "Turma excluída com sucesso");
            novaTurma();
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CursoMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.adicionarMensagem("formTurma", "Erro, turma não existe");
        }
        pesquisarTodos();
    }
    
    public void pesquisarEspecifico(){
        turmas = new ArrayList<Turma>();
        for(Turma t: dao.findTurmaEntities()){
            if(t.getNome().toLowerCase().contains(getNomePesquisa().toUpperCase())){
                turmas.add(t);
            }
        }
    }
    
    public void pesquisarTodos(){
        turmas = dao.findTurmaEntities();
    }
    
    public void novaTurma(){
        setTurma(new Turma());
    }

    public void carregar(Turma turma){
        setTurma(turma);
    }
    
    // Get's e Set's
    
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }
}
