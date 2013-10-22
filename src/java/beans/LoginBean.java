/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.PessoaJpaController;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import modelo.Pessoa;
import org.primefaces.context.RequestContext;
import util.EMF;

/**
 *
 * @author Anderson
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    PessoaJpaController daoPessoa = new PessoaJpaController(EMF.getEntityManagerFactory());
    
    private Pessoa pessoa;
    boolean loggedIn = false; 
    
    public LoginBean() {
        pessoa = new Pessoa();
    }
  
    public void login(ActionEvent actionEvent) {
        
        pessoa = daoPessoa.findUsuario(this.pessoa);
        
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
          
        if(pessoa != null) {  
            loggedIn = true;  
            
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro no Login", "Credenciais inválidas");
            FacesContext.getCurrentInstance().addMessage(null, msg);  
            context.addCallbackParam("loggedIn", loggedIn);
            
        }  
        
    }
    
    public String logado()
    {
        if(loggedIn)
        {
            return "index.xhtml";
        }
        pessoa = new Pessoa();
        return "login.xhtml";
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
}
