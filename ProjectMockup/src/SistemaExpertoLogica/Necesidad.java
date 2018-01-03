/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaExpertoLogica;

/**
 *
 * @author Cesar
 */
public class Necesidad implements Comparable<Necesidad> {
    private String componente;
    private byte prioridad;

    public Necesidad(String componente, byte prioridad) {
        this.componente = componente;
        this.prioridad = prioridad;
    }
    
    
    
    @Override
    public int compareTo(Necesidad o) {
        if(getPrioridad()>o.getPrioridad()){
            return 1;
        }else{
            return -1;
        }
       
    }

    /**
     * @return the componente
     */
    public String getComponente() {
        return componente;
    }

    /**
     * @param componente the componente to set
     */
    public void setComponente(String componente) {
        this.componente = componente;
    }

    /**
     * @return the prioridad
     */
    public byte getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(byte prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
}
