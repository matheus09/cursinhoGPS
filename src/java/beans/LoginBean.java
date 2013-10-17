/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

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
    private String username;  
      
    private String password;
     
    boolean loggedIn = false; 
    
    public LoginBean() {
    }
    
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
          
        if(username != null  && username.equals("admin") && password != null  && password.equals("admin")) {  
            loggedIn = true;  
            //msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem-vindo", username);
            
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
        username = null;
        password = null;
        return "login.xhtml";
    }
}
