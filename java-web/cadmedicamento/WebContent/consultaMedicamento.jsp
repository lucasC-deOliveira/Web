<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CadMedicamento</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/estilo.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<form action="cadastroMedicamento.jsp" method="post"
		class="form-horizontal">
		<div class="container">
			<div class="page-header">
				<h1>
					Medicamento <small>consulta</small>
				</h1>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Nome</label>
				<div class="col-sm-10">
					<input type="text" name="txtNomeMedicamento" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" aria-label="..."></label>
				<div class="col-sm-10">
					<input type="submit" value="Cadastrar Medicamento"
						class="btn space" /> <input type="button" value="Consultar"
						class="btn space" />
				</div>
			</div>

			<span>
				<div class="panel panel-success">
					<div class="panel-heading">Resultado da consulta</div>
					<div class="table-responsive">
						<table class="table table-striped table hover">
							<thead>
								<tr>
									<th scope="col">Nome</th>
									<th scope="col">Valor Custo</th>
									<th scope="col">Valor Venda</th>
									<th class="width100" scope="col">Ação</th>
								</tr>
							</thead>
							<tbody>
							  <c:forEach var="medicamento" items="${medicamentos}">
								<tr>
									<td>${medicamento.nome}</td>
									<td>${medicamento.valorCusto}</td>
									<td>${medicamento.valorVenda}</td>
									<td>
										<div class="btn-group btn-group-xs">
											<em class="glyphicon glyphicon-pencil"></em> <em
												class="glyphicon glyphicon-trash"></em>
										</div>

									</td>
								</tr>
							 </c:forEach>
							</tbody>

						</table>

					</div>
				</div>



			</span>




		</div>




	</form>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Inclui todos os plugins compilados (abaixo), ou inclua arquivos separadados se necessário -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>