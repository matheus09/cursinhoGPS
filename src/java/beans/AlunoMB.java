/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AlunoJpaController;
import dao.PessoaJpaController;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Aluno;
import modelo.Pessoa;
import util.EMF;

/**
 *
 * @author ciro
 */
@ManagedBean
@RequestScoped
public class AlunoMB {
    private Aluno aluno = new Aluno();
    
    private AlunoJpaController daoAluno = new AlunoJpaController(EMF.getEntityManagerFactory());
    
    public void cadastrar(){
        daoAluno.create(aluno);
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
        return daoAluno.findAlunoEntities();
    }
}
