
<%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if (session.getAttribute("nome") != null) {
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Sistema de Controle de Endemias</title>

<!-- Bootstrap -->
<link href="vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap select -->
<link href="css/bootstrap-select.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- Datatables -->
<link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<c:import url="menu.jsp" />
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="row">
					<br />
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										Denúncias <small>Endemic Sys</small>
									</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<form class="form-horizontal form-label-left"
										data-toggle="validator" method="post" action="buscadenuncia">

										<div class="form-group  col-lg-3 col-xs-12">
											<label>Denunciante </label> <input type="text"
												name="txtpesquisa1" class="form-control input-md">
										</div>
										<div class="form-group  col-lg-3 col-xs-12">
											<label>Bairro </label> <input type="text" name="txtpesquisa2"
												class="form-control input-md">
										</div>
										<div class="form-group  col-lg-3 col-xs-12">
											<label>Cidade </label> <select name="txtpesquisa3" title=""
												class="form-control input-md selectpicker"
												data-live-search="true">
												<option selected="selected"></option>
												<option value="Goiânia">Goiânia</option>
												<option value="Aparecida de Goiânia">Aparecida de
													Goiânia</option>
												<option value="Senador Canedo">Senador Canedo</option>
												<option value="Trindade">Trindade</option>
											</select>
										</div>

										<div class="form-group  col-lg-3 col-xs-12">
											<label>Tipo de Imovel </label> <select name="txtpesquisa4"
												title="" class="form-control input-md selectpicker"
												data-live-search="true">
												<option selected="selected"></option>
												<option value="Lote">Lote</option>
												<option value="Casa">Casa</option>
												<option value="Apartamento">Apartamento</option>
												<option value="Deposito">Depósito</option>
												<option value="Loja">Loja</option>
												<option value="Sala">Sala comercial</option>
											</select>
										</div>
										<div class="x_content">
											<div class="row">
												<c:if test="${not empty message}">
													<div class="col-lg-12 col-xs-12">
														<c:if test="${fn:contains(message, 'Erro')}">
															<div class="alert alert-danger fade in">
																<a href="#" class="close" data-dismiss="alert">&times;</a>
																<p>${message}</p>
															</div>
														</c:if>
														<c:if test="${fn:contains(message, 'pesquisa')}">
															<div class="alert alert-warning fade in">
																<a href="#" class="close" data-dismiss="alert">&times;</a>
																<p>${message}</p>
															</div>

														</c:if>
														<c:if test="${fn:contains(message, 'Sucesso')}">
															<div class="alert alert-info fade in">
																<a href="#" class="close" data-dismiss="alert">&times;</a>
																<p>${message}</p>
															</div>

														</c:if>
													</div>
												</c:if>
											</div>
											<p class="text-muted font-13 m-b-30">
												<a href="denuncia.jsp">
													<button type="button" class="btn btn-success"
														data-container="body" data-toggle="popover"
														data-placement="bottom" title="Incluir Nova Denúncia">
														<i class="fa fa-plus-circle"></i>
													</button>
												</a> <a href="c_denuncia.jsp">
													<button type="button" class="btn btn-primary"
														data-container="body" data-toggle="popover"
														data-placement="bottom" title="Limpar Listagem">
														<i class="fa fa-refresh"></i>
													</button>
												</a>
												<button type="submit" class="btn btn-info"
													data-container="body" data-toggle="popover"
													data-placement="bottom" title="Buscar">
													<i class="fa fa-search"></i>
												</button>
											</p>

											<table id="datatable-buttons"
												class="table table-striped table-bordered">
												<thead>
													<tr>
														<th>Denunciante</th>
														<th>Data</th>
														<th>Ações</th>
													</tr>
												</thead>


												<tbody>
													<c:forEach var="denuncia" items="${listadenuncia}">
														<tr>
															<td>${denuncia.denunciante}</td>
															<td><fmt:formatDate
																	value="${denuncia.data_denuncia}" type="both"
																	pattern="dd/MM/yyyy" dateStyle="full" /></td>
															<td><div class="btn-group">
																	<button type="button"
																		class="btn dropdown-toggle btn btn-info btn-sm"
																		data-toggle="dropdown">
																		Opções <span class="caret"></span>
																	</button>
																	<ul class="dropdown-menu">
																		<li><a
																			href="buscadenuncia?acao=Consultar&iddenuncia=${denuncia.iddenuncia}"><span
																				class="glyphicon glyphicon-pencil"></span> Editar</a></li>
																		<li><a
																			onclick="confirmaexclusao(${denuncia.iddenuncia})"><span
																				class="glyphicon glyphicon-trash"></span> Excluir</a></li>

																	</ul>
																</div></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<footer>
				<div class="pull-center">
					Trabalho PW2017-1 - Sistema de Controle de Endemias <a
						href="https://github.com/dougfalves/UFG-PW-TRABALHO">GitHub</a>
				</div>
				<div class="clearfix"></div>
			</footer>
		</div>
		<script>
		    function confirmaexclusao(id) {
		   	     var resposta = confirm("Deseja remover o registro?");
		   	 
		   	     if (resposta == true) {
		   	          window.location.href = "buscadenuncia?acao=Excluir&iddenuncia="+id;
		   	     }
		   	}
    </script>
		<!-- jQuery -->
		<script src="vendors/jquery/dist/jquery.min.js"></script>
		<!-- Bootstrap -->
		<script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
		<!-- Datatables -->
		<script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
		<script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
		<script
			src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
		<script
			src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
		<script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
		<script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
		<script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
		<script
			src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
		<script
			src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
		<script
			src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
		<script
			src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
		<script
			src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
		<script src="vendors/jszip/dist/jszip.min.js"></script>
		<script src="vendors/pdfmake/build/pdfmake.min.js"></script>
		<script src="vendors/pdfmake/build/vfs_fonts.js"></script>
		<!-- Bootstrap select -->
		<script src="js/bootstrap-select.min.js"></script>
		<!-- Custom Theme Scripts -->
		<script src="build/js/custom.min.js"></script>
</body>
</html>
<%
	// se não existir um login na sessao, 
		// vai enviar para a página de login novamente
	} else {
%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
	}
%>
