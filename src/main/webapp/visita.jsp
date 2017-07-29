<%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if(session.getAttribute("nome") != null) {
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <!-- iCheck -->
    <link href="vendors/iCheck/skins/flat/green.css" rel="stylesheet">      
    <!-- bootstrap-daterangepicker -->
    <link href="vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="css/custom.min.css" rel="stylesheet">	       
     
  </head>
  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
  		<c:import url="menu.jsp" /> 
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
                      <h2>Visita</h2>
                      <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                      </ul>
                      <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                   <form class="form-horizontal form-label-left" data-toggle="validator" method="post" action="visita">				 
                            <p>Atenção aos campos requeridos<code>*</code></p>
                                    <!-- <span class="section">Dados do Agente</span>-->					  
                           <!--IDbanco Input-->
                              <div class="form-group">
                                        <div class="col-md-2 col-xs-12">
                                            <input  type="hidden" readonly="readonly" type="text" id="idvisita" name="idvisita" value="${visita.idvisita}" class="form-control input-md">
                                        </div>
                              </div>
                          <!--Nome Input-->
                                    <div class="form-group">
                                      <label class="control-label col-md-3" for="agente">Agente <span class="required">*</span></label>
                                      <div class="col-lg-6 col-xs-12">
                                        <input type="text"   id="agente" readonly="readonly" name="agente" value="${visita.agente}" placeholder="ex: Joao da Silva" required="required" class="form-control input-md">                                        
                                        <div class="help-block with-errors"></div>
                                      </div>
                                    </div>
                          <!--data Input-->
                                    <div class="form-group">
                                      <label class="control-label col-md-3" for="data_visita">Data da visita <span class="required">*</span></label>
                                      <div class="col-lg-2 col-xs-12">
                                        <input type="text" id="data_visita" name="data_visita" value="<fmt:formatDate value="${visita.data_visita}" pattern="dd/MM/yyyy HH:mm:ss"/>" required="required" class="form-control input-md">
                                         <div class="help-block with-errors"></div>
                                      </div>
                                    </div>
                        <!--Rua Input-->
                                    <div class="form-group">
                                      <label class="control-label col-md-3" for="rua">Rua <span class="required">*</span></label>
                                      <div class="col-lg-5 col-xs-12">
                                        <input type="text" id="rua" name="rua" value="${visita.rua}"required="required" class="form-control input-md">
                                        <div class="help-block with-errors"></div>
                                      </div>
                                    </div>
                          <!--Quadra Lote Numero Input-->
                                    <div class="form-group">
                                      <label class="control-label col-md-3" for="quadra">Quadra <span class="required">*</span></label>
                                      <div class="col-lg-1 col-xs-12">
                                        <input type="text" id="quadra" name="quadra" value="${visita.quadra}"required="required" class="form-control input-md">
                                        <div class="help-block with-errors"></div>
                                      </div>
                                      <label class="control-label col-md-1" for="lote">Lote <span class="required">*</span></label>
                                      <div class="col-lg-1 col-xs-12">
                                        <input type="text" id="lote" name="lote" value="${visita.lote}"required="required" class="form-control input-md">
                                      </div>
                                      <label class="control-label col-md-1" for="numero">Nº <span class="required">*</span></label>
                                      <div class="col-lg-1 col-xs-12">
                                        <input type="text" id="numero" name="numero" value="${visita.numero}"required="required" class="form-control input-md">
                                      </div>
                                    </div>            
                            <!--Bairro Input-->
                                    <div class="form-group">
                                      <label class="control-label col-md-3" for="bairro">Bairro/Setor <span class="required">*</span></label>
                                      <div class="col-lg-3 col-xs-12">
                                        <input type="text" id="bairro" name="bairro" value="${visita.bairro}" required="required" class="form-control input-md">
                                         <div class="help-block with-errors"></div>
                                      </div>
                                    </div>
                            <!--Cep Input-->
                                    <div class="form-group">
                                      <label class="control-label col-md-3" for="cep">CEP <span class="required">*</span></label>
                                      <div class="col-lg-2 col-xs-12">
                                        <input type="tel" id="cep" name="cep" value="${visita.cep}" required="required" class="form-control input-md" pattern="[0-9]+$" 
                                         data-error="Informe um CEP somente com numeros.">
                                         <div class="help-block with-errors"></div>
                                      </div>
                                    </div>
                        <!--Cidade select-->
                          <div class="form-group">
                          <label class="control-label col-md-3" for="cidade">Cidade <span class="required">*</span></label>
                            <div class="col-lg-3 col-xs-12">
                            <select required id="cidade" name="cidade" title="Selecione item" class="form-control input-md selectpicker" data-live-search="true">
                              <option selected="selected">${visita.cidade}</option>
                              <option value="Goiânia">Goiânia</option>
                              <option value="Aparecida de Goiânia">Aparecida de Goiânia</option>
                              <option value="Senador Canedo">Senador Canedo</option>
                              <option value="Trindade">Trindade</option>
                            </select>
                             <div class="help-block with-errors"></div>
                            </div>
                          </div> 
                        <!--Coordenadas-->
                                    <div class="form-group">
                                      <label class="control-label col-md-3" for="coordenadas">Coordenadas <span class="required">*</span></label>
                                      <div class="col-lg-2 col-xs-12">
                                        <input type="text" id="latitude" name="latitude" value="${visita.latitude}"required="required" class="form-control input-md">
                                        <div class="help-block with-errors"></div>
                                        <div class="help">Latitude</div>
                                      </div>
                                      <div class="col-lg-2 col-xs-12">
                                        <input type="text" id="longitude" name="longitude" value="${visita.longitude}"required="required" class="form-control input-md">
                                        <div class="help-block with-errors"></div>
                                        <div class="help">Longitude</div>
                                      </div>                     
                                    </div>                        
                        <!--Tipo_Imovel select-->
                          <div class="form-group">
                          <label class="control-label col-md-3" for="tipo">Tipo do Imovel <span class="required">*</span></label>
                            <div class="col-lg-3 col-xs-12">
                            <select required id="tp_imovel" name="tp_imovel"  title="Selecione item" class="form-control input-md selectpicker" data-live-search="true">
                              <option selected="selected">${visita.tp_imovel}</option>
                              <option value="Lote">Lote</option>
                              <option value="Casa">Casa</option>
                              <option value="Apartamento">Apartamento</option>
                              <option value="Deposito">Depósito</option>
                              <option value="Loja">Loja</option>
                              <option value="Sala">Sala comercial</option>
                            </select>
                            <div class="help-block with-errors"></div>
                            </div>
                          </div>
                        <!--Estagio select-->
                          <div class="form-group">
                          <label class="control-label col-md-3" for="estagio">Estagio do Ciclo </label>
                            <div class="col-lg-3 col-xs-12">
                            <select  id="estagio" name="estagio" title="Selecione item" class="form-control input-md selectpicker" data-live-search="true">
                              <option selected="selected">${visita.estagio}</option>
                              <option value="Ovo">Ovo</option>
                              <option value="Larva">Larva</option>
                              <option value="Pupa">Pupa</option>
                              <option value="Mosquito">Mosquito</option>							  
                            </select>
                            </div>
                          </div>	
                          <!--Larvicida select-->
                          <div class="form-group">
                          <label class="control-label col-md-3" for="tp_larvicida">Larvicida </label>
                            <div class="col-lg-3 col-xs-12">
                            <select  id="tp_larvicida" name="tp_larvicida" title="Selecione item" class="form-control input-md selectpicker" data-live-search="true">
                              <option selected="selected">${visita.tp_larvicida}</option>
                              <option value="Tipo 1">Tipo 1</option>
                              <option value="Tipo 2">Tipo 2</option>
                              <option value="Tipo 3">Tipo 3</option>
                            </select>
                            </div>
                          </div>
                          <!--Ação select-->
                          <div class="form-group">
                          <label class="control-label col-md-3" for="ac_corretiva">Ação Corretiva </label>
                            <div class="col-lg-3 col-xs-12">
                            <select  id="ac_corretiva" name="ac_corretiva" title="Selecione item" class="form-control input-md selectpicker" data-live-search="true">            
                              <option selected="selected">${visita.ac_corretiva}</option>
                              <option value="Nebolização">Nebolização</option>
                              <option value="Borrifação">Borrifação</option>
                            </select>
                            </div>
                          </div>						  
                          <!--Local input-->
                                    <div class="form-group">
                                      <label class="control-label col-md-3" for="local_foco">Local do Foco </label>
                                      <div class="col-lg-6 col-xs-12">
                                        <input type="text" id="local_foco" name="local_foco" value="${visita.local_foco}" placeholder="ex: caixa d'agua,vaso sanitário" class="form-control input-md">
                                      </div>
                                    </div>				 
                        <!--Botões-->    
                            <div class="ln_solid"></div>
                            <div class="form-group">
                              <div class="col-md-6 col-md-offset-3">
                                <!-- <button id="send" type="submit" class="btn btn-info" data-toggle="modal" data-target="#confirma">Gravar</button> -->
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
    <!-- bootstrap-daterangepicker -->
    <script src="vendors/moment/min/moment.min.js"></script>
    <script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-VALIDATOR -->
    <script src="js/validator.min.js"></script>
    
    <script type="text/javascript">
    $(function() {
        $('input[name="data_visita"]').daterangepicker({
            singleDatePicker: true,
            timePicker: true,
            timePickerIncrement: 1,
            showMeridian:false,
            timePicker24Hour:true,
            locale: {
                format: 'DD/MM/YYYY HH:mm'
            }
        });
    });
    </script>
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
