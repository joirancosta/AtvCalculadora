<%-- 
    Document   : resposta
    Created on : 04/12/2018, 21:19:57
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
            <div class="box2">
                <div class="panel panel-primary">
                    <div class="panel-heading">Resultado</div>
                    <div  class="panel-body">
                    <%=
                     request.getAttribute("resultado")
                    %>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
