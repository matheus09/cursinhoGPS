/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AlunoJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Aluno;
import util.EMF;

/**
 *
 * @author ciro
 */
@ManagedBean
@RequestScoped
public class AlunoMB {
    private Aluno aluno = new Aluno();
    
    private AlunoJpaController dao = new AlunoJpaController(EMF.getEntityManagerFactory());
    
    public void carregar(Aluno aluno){
        setAluno(aluno);
    }
    
    public void limpar(){
        setAluno(new Aluno());
    }
    
    public void excluir(Long id){
        try {
            dao.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cadastrar(){
        dao.create(aluno);
        aluno = new Aluno();
    }
    
    public void alterar(){
        try {
            dao.edit(aluno);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates a new instance of AlunoMB
     */
    public AlunoMB() {
    }

    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public List<Aluno> getTodos(){
        return dao.findAlunoEntities();
    }
}
