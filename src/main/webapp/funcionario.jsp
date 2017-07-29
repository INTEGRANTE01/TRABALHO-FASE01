<%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if(session.getAttribute("nome") != null) {
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap select -->
  	<link href="css/bootstrap-select.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">    
    <!-- Custom Theme Style -->
    <link href="css/custom.min.css" rel="stylesheet">	
    
  </head>
  <body class="nav-md">
  <div class="container body">
      <div class="main_container">
  		<c:import url="menu.jsp"/>  
  	<!-- page content -->
        <div class="right_col" role="main">
          <!-- top tiles -->
          <div class="row tile_count">
          </div>
          <!-- /top tiles -->
  		<div class="row">             
          <br />		    
              <div class="row">			  
                <!-- Start to do list -->
                <div class="col-md-12 col-sm-12 col-xs-12">
                  <div class="x_panel">
                    <div class="x_title">
                      <h2>Funcionário</h2>
                      <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                      </ul>
                      <div class="clearfix"></div>
                    </div>
                    <div class="x_content">					
                <form class="form-horizontal form-label-left" data-toggle="validator" method="post" action="funcionario">				 
                            <p>Atenção aos campos requeridos<code>*</code></p>
                            <!-- <span class="section">Dados do Agente</span>-->
                  
                  <!--IDbanco Input-->
                  <div class="form-group">
                             <div class="col-md-2 col-xs-12">
                                <input type="hidden" readonly="readonly" type="text" id="idfuncionario" name="idfuncionario" value="${funcionario.idfuncionario}" class="form-control input-md">
                            </div>
                  </div>	
                  <!--Matricula Input-->
                  <div class="form-group">
                              <label class="control-label col-md-3" for="matricula">Matrícula <span class="required">*</span></label>
                              <div class="col-md-2 col-xs-12">
                                <input type="text" id="matricula" name="matricula" value="${funcionario.matricula}" placeholder="ex: 710001" required="required" class="form-control input-md"
                                 data-error="Informe um Nº de matricula vlido.">                                
                                <div class="help-block with-errors"></div>
                              </div>
                            </div>			  					  
                  <!--Nome Input-->
                            <div class="form-group">
                              <label class="control-label col-md-3" for="nome">Nome <span class="required">*</span></label>
                              <div class="col-lg-6 col-xs-12">
                                <input type="text" id="nome" name="nome" value="${funcionario.nome}"  placeholder="ex: Joao da Silva" required="required" class="form-control input-md">
                                <div class="help-block with-errors"></div>
                              </div>
                              </div>					  
                    <!--Função select-->
                    <div class="form-group">
                    <label class="control-label col-md-3" for="funcao">Função <span class="required">*</span></label>
                      <div class="col-lg-4 col-xs-12">
                      <select required id="funcao" name="funcao" title="Selecione item" class="form-control input-md selectpicker" data-live-search="true">
                        <option selected="selected">${funcionario.funcao}</option>
                        <option value="Administrador">Administrador</option>
                        <option value="Atendente">Atendente</option>
                        <option value="Agente">Agente</option>
                      </select>
                      <div class="help-block with-errors"></div>
                      </div>
                    </div>
                  <!--Email Input-->
                    <div class="item form-group">
                        <label class="control-label col-md-3" for="email">Email</label>
                      <div class="col-lg-6 col-xs-12">
                        <input type="email" id="email" name="email" value="${funcionario.email}" placeholder="ex: fulano@detal.com" class="form-control input-md">
                      </div>
                    </div>            
                  <!--senha Input-->
                    <div class="item form-group">
                      <label for="senha" class="control-label col-md-3">Senha <span class="required">*</span></label>
                      <div class="col-lg-6 col-xs-12">
                        <input id="senha" type="password" name="senha" value="${funcionario.senha}"  placeholder="ex: #s3nh4*" class="form-control input-md" required="required">                        
                         <div class="help-block with-errors"></div>
                      </div>
                    </div>
                <!--Confirmação senha Input-->  
                    <div class="item form-group">
                      <label for="senha2" class="control-label col-md-3">Confirmar Senha <span class="required">*</span></label>
                      <div class="col-lg-6 col-xs-12">
                        <input id="senha2" type="password" name="senha2" value="${funcionario.senha}" placeholder="ex: #s3nh4*"  class="form-control input-md" required="required" 
                        data-match="#senha" data-match-error="As senhas não são equivalentes!">
                        <div class="help-block with-errors"></div>
                      </div>
                    </div>	
					 <c:if test="${not empty message}">
						<div class="container">
							<label class="control-label col-md-3"></label>
								<div class="col-lg-4 col-xs-12">
									<div class="alert alert-success fade in">
											<a href="#" class="close" data-dismiss="alert">&times;</a>
									<strong>${message}</strong>
									</div>
								</div>			
						</div>		
					</c:if>
						
                <!--Botões-->    
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button id="send" type="submit" class="btn btn-info">Gravar</button>
                          <button type="reset" class="btn btn-warning">Limpar</button>                          
                        </div>
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
            Trabalho PW2017-1 - Sistema de Controle de Endemias <a href="https://github.com/dougfalves/UFG-PW-TRABALHO">GitHub</a>
          </div>
          <div class="clearfix"></div>
        </footer>
 </div>
 </div>
    <!-- jQuery -->
    <script src="vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Bootstrap select -->
    <script src="js/bootstrap-select.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="build/js/custom.min.js"></script> 
    <!-- bootstrap-VALIDATOR -->
    <script src="js/validator.min.js"></script>	
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
