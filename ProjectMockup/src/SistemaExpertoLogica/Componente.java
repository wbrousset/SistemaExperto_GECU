/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaExpertoLogica;

/**
 *
 * @author Cesar
 */
public class Componente {
    private String marca;
    private byte prioridad;
    private String referencia;

    public Componente(String marca, byte prioridad,String referencia) {
        this.marca = marca;
        this.referencia=referencia;
        this.prioridad=prioridad;
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

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
   
    
    
}
