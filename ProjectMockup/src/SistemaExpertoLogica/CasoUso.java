/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaExpertoLogica;

import java.util.ArrayList;
import java.util.TreeSet;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author Cesar
 */
public class CasoUso {
    
    
    private TreeSet<Necesidad> necesidades; 
    private String marca;

    public CasoUso(String marca) {
        this.marca=marca;
        necesidades = new TreeSet<>();
    }
    
    public void addNecesidad(Necesidad necesidad){
        necesidades.add(necesidad);
    }
    

    /**
     * @return the necesidades
     */
    public TreeSet<Necesidad> getNecesidades() {
        return necesidades;
    }

    /**
     * @param necesidades the necesidades to set
     */
    public void setNecesidades(TreeSet<Necesidad> necesidades) {
        this.necesidades = necesidades;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
    
   
    
    
    
    
    
    
}
