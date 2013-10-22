/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ciro
 */
@Entity
public class Aluno extends Pessoa implements Serializable {
    private String responsavel;
    private String respParentesco;
    private String respTelefone;
    
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
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Aluno[ id=" + id + " ]";
    }

    /**
     * @return the responsavel
     */
    public String getResponsavel() {
        return responsavel;
    }

    /**
     * @param responsavel the responsavel to set
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * @return the respParentesco
     */
    public String getRespParentesco() {
        return respParentesco;
    }

    /**
     * @param respParentesco the respParentesco to set
     */
    public void setRespParentesco(String respParentesco) {
        this.respParentesco = respParentesco;
    }

    /**
     * @return the respTelefone
     */
    public String getRespTelefone() {
        return respTelefone;
    }

    /**
     * @param respTelefone the respTelefone to set
     */
    public void setRespTelefone(String respTelefone) {
        this.respTelefone = respTelefone;
    }
}
