/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
<<<<<<< HEAD
 * @author Hyago Brendoll
=======
 * @author ciro
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
 */
@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String telefone;
<<<<<<< HEAD
=======
    
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    private String email;
    private String endereco;
<<<<<<< HEAD

=======
    
    
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
<<<<<<< HEAD
    }   

=======
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /*public boolean maioridade(){
        Date a = new Date();
       
    }*/
    
    @Override
    public String toString() {
        return "modelo.Pessoa[ id=" + id + " ]";
    }

    /**
     * @return the nome
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public String getNome() {
        return nome;
    }

<<<<<<< HEAD
=======
    /**
     * @param nome the nome to set
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public void setNome(String nome) {
        this.nome = nome;
    }

<<<<<<< HEAD
=======
    /**
     * @return the telefone
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public String getTelefone() {
        return telefone;
    }

<<<<<<< HEAD
=======
    /**
     * @param telefone the telefone to set
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

<<<<<<< HEAD
=======
    /**
     * @return the dataNascimento
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public Date getDataNascimento() {
        return dataNascimento;
    }

<<<<<<< HEAD
=======
    /**
     * @param dataNascimento the dataNascimento to set
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

<<<<<<< HEAD
=======
    /**
     * @return the email
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public String getEmail() {
        return email;
    }

<<<<<<< HEAD
=======
    /**
     * @param email the email to set
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
=======
    /**
     * @return the endereco
     */
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
    public String getEndereco() {
        return endereco;
    }

<<<<<<< HEAD
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
=======
    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
>>>>>>> 640561fc873cba26a2af79e154eeb5da414f20f4
}
