/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.FuncionarioJpaController;
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
    private FuncionarioJpaController dao = new FuncionarioJpaController(EMF.getFactory());
    private Funcionario func = new Funcionario();
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    /**
     * Creates a new instance of FuncionarioMB
     */
    public FuncionarioMB() {
        listarFuncionarios();
    }
    
    public void inserir(){
        getDao().create(getFunc());
        setFunc(new Funcionario());
    }

    public void listarFuncionarios(){
        setFuncionarios(dao.findFuncionarioEntities());
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
     * @return the func
     */
    public Funcionario getFunc() {
        return func;
    }

    /**
     * @param func the func to set
     */
    public void setFunc(Funcionario func) {
        this.func = func;
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
