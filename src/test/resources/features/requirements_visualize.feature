#Autor:Equipo grados y reportes - Calidad

Feature: Visualizacion de cumplimiento de requisitos para graduación.
  Como estudiante activo de la universidad
  Quiero conocer si cumplo los requisitos para graduarme
  Para conocer mi estado actual ante la universidad

  Scenario: Ingresar numero de documento en el home de la pagina y lograr ver los requisitos para graduarme
    Given me encuentro en la pagina de home
    When digito mi numero de cedula
    Then puedo ver la pagina donde se observan los requisitos

  Scenario: Ingresar numero de documento erroneo y poder ver una alerta de que el usuario no existe
        Given me encuentro en la pagina del home
        When digito un documento incorrecto
        Then puedo ver una alerta con un mensaje de error al buscar el documento
