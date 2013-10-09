/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.FuncionarioJpaController;
import dao.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import modelo.Funcionario;
import util.EMF;
import util.FacesUtil;

/**
 *
 * @author daniel
 */
@ManagedBean
@RequestScoped
public class FuncionarioMB {

    private FuncionarioJpaController dao = new FuncionarioJpaController(EMF.getFactory());
    private Funcionario func;
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private String nomePesq;

    /**
     * Creates a new instance of FuncionarioMB
     */
    public FuncionarioMB() {
        func = new Funcionario();
        listarFuncionarios();
    }

    public void limpar(){
        setFunc(new Funcionario());
    }
    
    public void carregar(Funcionario func){
        setFunc(func);
    }
    
    public void inserir() {
        try {
            func.setId(null);
            dao.create(func);
            FacesUtil.adicionarMensagem("formCadFunc", "O funcionário foi cadastrado");
            func = new Funcionario();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void pesquisarPorNome(){
        funcionarios = new ArrayList<Funcionario>();
        for(Funcionario f : dao.findFuncionarioEntities()){
            if(f.getNome().toUpperCase().contains(getNomePesq().toUpperCase())){
                funcionarios.add(f);
            }
        }
        setNomePesq("");
    }

    public void alterar(){
        try {
            dao.edit(func);
            FacesUtil.adicionarMensagem("formCadFunc", "O funcionário foi alterado");
            func = new Funcionario();
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FuncionarioMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(Long id) {
        try {
            dao.destroy(id);
            FacesUtil.adicionarMensagem("formCadFunc", "O funcionário foi excluído");
            func = new Funcionario();
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FuncionarioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarFuncionarios() {
        funcionarios = dao.findFuncionarioEntities();
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

    /**
     * @return the nomePesq
     */
    public String getNomePesq() {
        return nomePesq;
    }

    /**
     * @param nomePesq the nomePesq to set
     */
    public void setNomePesq(String nomePesq) {
        this.nomePesq = nomePesq;
    }
}
