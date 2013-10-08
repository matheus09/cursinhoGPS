/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author jucylene
 */
@MappedSuperclass
public class Pessoa implements Serializable {
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String endereco;
    
    /**
     * (Não implementado) Testa se a Pessoa é maior de idade.
     * @return (está retornando false, por enquanto) indica true se for maior de idade ou false, caso contrário.
     */
    public boolean maioridade(){
        Calendar nasc = Calendar.getInstance();
        nasc.setTime(dataNascimento);
        Calendar agora = Calendar.getInstance();
        agora.setTime(new Date());
        agora.roll(Calendar.YEAR, -18);
        
        if (agora.after(nasc)) {
            return true;
        } else {
            return false;
        }
        
        /*
        if ((agora.YEAR - nasc.YEAR) > 18) {
            return true;
        } else if ((agora.YEAR - nasc.YEAR) < 18) {
            return false;
        } else {
            if (agora.MONTH > nasc.MONTH) {
                return true;
            } else if (agora.MONTH < nasc.MONTH) {
                return false;
            } else {
                if (agora.DAY_OF_MONTH > nasc.DAY_OF_MONTH) {
                    return true;
                } else {
                    return false;
                }
            }
        }*/
    }
    
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento a data de nascimento da pessoa.
     */
    public void setDataNascimento(Date dataNascimento) {
        SimpleDateFormat df = new SimpleDateFormat("DD/MM/yyyy");
        df.format(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "modelo.Pessoa[ id=" + id + " ]";
    }
}