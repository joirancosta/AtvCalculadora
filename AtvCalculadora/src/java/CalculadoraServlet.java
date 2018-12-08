/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import parcels.Operador;
import parcels.Celula;
import parcels.TipoOperador;
import parcels.Valor;

/**
 *
 * @author aluno
 */
@WebServlet(urlPatterns = {"/Calculadora"})
public class CalculadoraServlet extends HttpServlet {  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                              
        request.getRequestDispatcher("/WEB-INF/front/calculadora.jsp").forward(request, response);
    }        

}
