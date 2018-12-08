import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import parcels.Celula;
import parcels.Operador;
import parcels.TipoOperador;
import parcels.Valor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
@WebServlet(urlPatterns = {"/Resposta"})
public class ResultadoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                      
        try {
            List<Celula> list = extract(request.getParameter("expressao"));
            double resultado = getResultado(list);
            request.setAttribute("resultado", resultado);
        } catch (Exception e) {
            request.setAttribute("resultado", "Erro na expressão D:");
        }        
        request.getRequestDispatcher("/WEB-INF/front/resposta.jsp").forward(request, response);
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
