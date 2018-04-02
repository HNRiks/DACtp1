<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona lembrete</title>
    </head>
    <body>
        <h1> Adicionar Lembrete </h1>
        <form action="guardalembrete" method="post">
            Usuário:<br>
            <input type="text" name="username"><br>
            Título do Lembrete:<br>
            <input type="text" name="title"><br>
            Mensagem:<br>
            <input type="text" name="body"><br><br>
            <input type="submit" value="Salvar Lembrete"> 
        </form>
    </body>
</html>
