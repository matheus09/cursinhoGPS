/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.FuncionarioJpaController;
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
    
    
    /**
     * Creates a new instance of FuncionarioMB
     */
    public FuncionarioMB() {
    }
    
    public void inserir(){
        getDao().create(getFunc());
        setFunc(new Funcionario());
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
    
}
