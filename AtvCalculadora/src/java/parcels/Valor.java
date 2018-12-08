/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcels;

/**
 *
 * @author aluno
 */
public class Valor extends Celula {
    
    private double valor;

    public Valor(double valor) {
        this.valor = valor;
    }        

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {          
        return String.valueOf(valor);
    }
    
}
