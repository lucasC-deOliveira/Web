<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/estilo.css" rel="stylesheet">
<title>Cadastro Medicamento</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>


	<form method="post" action="medicamentoController"
		class="form-horizontal">
		<div class="container">
			<div class="page-header">
				<h1>
					Medicamento <small>Cadastro</small>
				</h1>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Nome</label>
				<div class="col-sm-10">
					<input type="text" name="nomeMedicamento" class="form-control">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Tipo</label>
				<div class="col-sm-10">
					<select name="tipoMedicamento" class="form-control">
						<option value="">Selecione</option>
						<option value="1">Homeopático</option>
						<option value="2">Similar</option>
						<option value="3">Genérico</option>
						<option value="4">Referência</option>
						<option value="5">Manipulado</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Valor Custo</label>
				<div class="col-sm-10">
					<input type="text" name="valorCusto" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Valor Venda</label>
				<div class="col-sm-10">
					<input type="text" name="valorVenda" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2"></label>
				<div class="col-sm-10">
					<input type="submit" value="Salvar">
				</div>
			</div>

		</div>
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Inclui todos os plugins compilados (abaixo), ou inclua arquivos separadados se necessário -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>