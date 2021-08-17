# login-springMVC

# TEMA : login-SpringMVC

#PROYECTO JAVA WEB : Web Application

#CARPETA "WEB-INF" :
  
  - applicationContext.xml : Archivo de config.
  - dispatcher-Servlet.xml : Archivo de config.
  - web.xml : Archivo de config.  
  - jsp :   "index.jsp" / "registrar.jsp" / "menuBienvenida.jsp".
  
#PAQUETE "Config" : 
  
  - CLASE "Conexion" :   Conexion a la base de datos "check", mediante JDBC.
  
#PAQUETE "Entity" :   
  
  - CLASE "usuarios" :   Clase entidad, de la tabla "usuarios".
  
#PAQUETE "Controller" : 
  
  - CLASE "Controlador" :  Se encarga de atender los mensajes que manda
    el usuario desde el menu principal "index.htm" y selecciona las vistas
    "registrar.htm","menuBienvenida.htm", que son utilizadas para 
     mostrar el modelo (los datos manejados por la app).
  
