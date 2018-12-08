/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import parcels.Celula;
import parcels.Operador;
import parcels.TipoOperador;
import parcels.Valor;

/**
 *
 * @author aluno
 */
public class Test {
    
    public static void main(String[] args) {
        String expressao = JOptionPane.showInputDialog("Informe a expressao");
        List<Celula> list = extract(expressao);
        if (list != null) {            
            for (Celula c : list) {
                System.out.print(c);
            }
            System.out.println("");
            double resultado = getResultado(list);
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("ERRO");
        }        
    }
    
    private static double getResultado(List<Celula> celulas) {
        double resultado = 0;
        for (int i=0; i<celulas.size(); i++) {
            Celula celula = celulas.get(i);
            if (celula instanceof Valor)
                resultado = ((Valor)celula).getValor();
            else if (celula instanceof Operador) {                
                switch (((Operador)celula).getOperador()) {
                    case SOMA:
                        resultado = resultado + ((Valor)celulas.get(i+1)).getValor();
                        i++;
                        break;
                    case SUBTRACAO:
                        resultado = resultado - ((Valor)celulas.get(i+1)).getValor();
                        i++;
                        break;
                    case MULTIPLICACAO:
                        resultado = resultado * ((Valor)celulas.get(i+1)).getValor();
                        i++;
                        break;
                    case DIVISAO:
                        resultado = resultado / ((Valor)celulas.get(i+1)).getValor();
                        i++;
                        break;
                }
            }
        }        
        return resultado;
    }    
    
    private static List<Celula> extract(String expressao) {
        if (expressao == null)
            return null;
        char lastChar = expressao.charAt(expressao.length()-1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/')
            return null;                
        List<Celula> list = new ArrayList<>();
        TipoOperador ultimoOperador = null;
        StringBuilder value = new StringBuilder();        
        for (char c : expressao.toCharArray()) {
            switch (c) {
                case '+':
                    if (ultimoOperador == null) {
                        list.add(new Valor(Double.parseDouble(value.toString())));
                        value = new StringBuilder();
                        ultimoOperador = TipoOperador.SOMA;
                        list.add(new Operador(TipoOperador.SOMA));
                    } else
                        return null;
                    break;
                case '-':
                    if (ultimoOperador == null) {
                        list.add(new Valor(Double.parseDouble(value.toString())));
                        value = new StringBuilder();
                        ultimoOperador = TipoOperador.SUBTRACAO;
                        list.add(new Operador(TipoOperador.SUBTRACAO));
                    } else
                        return null;
                    break;
                case '*':
                    if (ultimoOperador == null) {
                        list.add(new Valor(Double.parseDouble(value.toString())));
                        value = new StringBuilder();
                        ultimoOperador = TipoOperador.MULTIPLICACAO;
                        list.add(new Operador(TipoOperador.MULTIPLICACAO));
                    } else
                        return null;
                    break;
                case '/':
                    if (ultimoOperador == null) {
                        list.add(new Valor(Double.parseDouble(value.toString())));
                        value = new StringBuilder();
                        ultimoOperador = TipoOperador.DIVISAO;
                        list.add(new Operador(TipoOperador.DIVISAO));
                    } else
                        return null;                    
                    break;
                case ' ':
                    break;
                default:
                    ultimoOperador = null;
                    value.append(c);
                    break;
            }                        
        }
        list.add(new Valor(Double.parseDouble(value.toString())));
        return list;
    }
    
}
