/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.PessoaJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Pessoa;
import modelo.Sala;
import util.EMF;

/**
 *
 * @author Anderson
 */
@ManagedBean
@RequestScoped
public class PessoaMB {

    /**
     * Creates a new instance of PessoaMB
     */
    PessoaJpaController daoPessoa = new PessoaJpaController(EMF.getEntityManagerFactory());
    
    private Pessoa pessoa = new Pessoa();
    private String id;
    
    public PessoaMB() {
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    public void inserirPessoa(){
        try{
            daoPessoa.create(pessoa);
            pessoa = new Pessoa();
        }catch(Exception ex){
            Logger.getLogger(SalaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
