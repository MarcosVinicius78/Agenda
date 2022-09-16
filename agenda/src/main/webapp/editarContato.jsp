<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Editar Contato</title>
		<link rel="stylesheet" type="text/css" href="resource/style.css">
	</head>
	<body>
		<main>
			<header>
				<h1>Editar Contato</h1>
			</header>
			<section class="tbNovoContato">
				<form action="EditarContato" method="post">
					<table>
						<tr>
							<td class="formularioTb">
								<label>ID: </label>
								<input type="text" name="idcon" readonly value="<%out.print(request.getAttribute("idcon"));%>"/>
							</td>
						</tr>
						
						<tr>
							<td class="formularioTb">
								<label>NOME: </label>
								<input type="text" name="nome" value="<%out.print(request.getAttribute("nome")); %>"/>
							</td>
						</tr>
						
						<tr>
							<td class="formularioTb">
								<label>TELEFONE: </label>
								<input type="text" name="fone" value="<%out.print(request.getAttribute("fone")); %>"/>
							</td>
						</tr>
						
						<tr>
							<td class="formularioTb">
								<label>E-MAIL: </label>
								<input type="text" name="email" value="<%out.print(request.getAttribute("email")); %>"/>
							</td>
						</tr>
					</table>
					<input type="submit" value="Salvar" class="enviar"/>
				</form>
			</section>
		</main>
	</body>
</html>