/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.FuncionarioJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import modelo.Funcionario;
import util.EMF;

/**
 *
 * @author daniel
 */
@ManagedBean
@RequestScoped
public class FuncionarioMB {

    private EntityManagerFactory emf = EMF.getFactory();
    private FuncionarioJpaController dao = new FuncionarioJpaController(emf);
    private Funcionario funcionario = new Funcionario();
    
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    /**
     * Creates a new instance of FuncionarioMB
     */
    public FuncionarioMB() {
    }
    
    public void inserir(){
        try{
            getDao().create(getFuncionario());
            funcionario = new Funcionario();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        try{
            dao.edit(funcionario);
            funcionario = new Funcionario();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete(){
        try{
            dao.destroy(funcionario.getId());
            funcionario = new Funcionario();
        }catch(NonexistentEntityException e){
            e.printStackTrace();
        }
    }

    public void listar(){
        funcionarios = dao.findFuncionarioEntities();
    }

    /**
     * @return the emf
     */
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
    public FuncionarioJpaController getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(FuncionarioJpaController dao) {
        this.dao = dao;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the funcionarios
     */
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
