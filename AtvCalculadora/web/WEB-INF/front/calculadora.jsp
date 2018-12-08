<%-- 
    Document   : calculadora
    Created on : 04/12/2018, 19:46:37
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/CalcJava/css/estilos.css" type="text/css" rel="stylesheet"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <h1 class="titulo">CalcMetinha</h1>
        </nav>
        <div class="container2"> 
            <div class="box">
                <h1 class="tituloCalc">Digite sua expressão</h1>
                <form class="navbar-form navbar-left" method="GET" action="/CalcJava/Resposta">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="expressão" name="expressao">
                    </div>
                    <button type="submit" class="btn btn-default">Calcular</button>
                </form>
            </div>
        </div>
    </body>
</html>
