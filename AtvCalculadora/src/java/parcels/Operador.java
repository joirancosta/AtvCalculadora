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
public class Operador extends Celula{
        
    private TipoOperador operador; 

    public Operador(TipoOperador operador) {
        this.operador = operador;
    }                      

    public TipoOperador getOperador() {
        return operador;
    }

    public void setOperador(TipoOperador operador) {
        this.operador = operador;
    }        
    
    @Override
    public String toString() {
        switch (operador) {
            case SOMA:
                return "+";
            case SUBTRACAO:
                return "-";
            case MULTIPLICACAO:
                return "*";
            case DIVISAO:
                return "/";
        }       
        return "";
    }
    
}
