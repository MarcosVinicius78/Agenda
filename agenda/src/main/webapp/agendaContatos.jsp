<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.Contato"%>
    <%@ page import="java.util.ArrayList"%>

    <%
    ArrayList<Contato> lista = (ArrayList<Contato>) request.getAttribute("contatos");
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Contatos</title>
		<link rel="stylesheet" type="text/css" href="resource/style.css">
	</head>
	<body>
		<main>
			<header>
				<h1>Lista de contatos</h1>
				<nav>
					<a href="novoContato.html">NOVO CONTATO</a>
				</nav>
			</header>
			
			<section>
				<table id="tabela">
					<thead>
						<tr>
							<th>Id</th>
							<th class="th">nome</th>
							<th class="th">Telefone</th>
							<th class="th">E-mail</th>
							<th>Opção</th>
						</tr>
					</thead>
					
					<tbody>
						<%for(Contato listar : lista){ %>
							<tr>
								<td><%=listar.getIdcon()%></td>
								<td><%=listar.getNome()%></td>
								<td><%=listar.getFone()%></td>
								<td><%=listar.getEmail()%></td>
								<td>
									<a href="EditarContato?idcon=<%=listar.getIdcon()%>" class="editar-contato">EDITAR</a>
									<a href="DeletarContato?idcon=<%=listar.getIdcon()%>" class="editar-contato">EXCLUIR</a>
								</td>
							</tr>
						<%}%>
					</tbody>
				</table>
			</section>
		</main>
	</body>
</html>