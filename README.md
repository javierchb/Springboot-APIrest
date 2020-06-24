API-REST con Springboot
Para inicializar el proyecto, debe tener instalado MYSQL opcionalmente para un mejor manejo de datos
puede utilizar MYSQL Workbench. 
### IMPORTANTE CAMBIO DE PUERTO PARA CORRER EL API REST CON LA BD: ###
Dentro de la carpeta:

src/
...main/
........java/
............resource/

Se encuentra el archivo appication.yml
En este archivo debe modificar esta línea del código:
  url: jdbc:mysql://localhost:3306/products?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC
  Indicando el puerto que ocupa MYSQL que en este caso es el 3306 y el nombre de la base de datos que en este caso es 'products'
### ############################################################## ###


### DATOS PRESENDIBLES ###
La base de datos, contiene una tabla llamada products la cual contiene los siguientes atributos:
  id foreign key integer auto_increment
  name varchar(30) not null
### ################## ###
  
En caso contrario si desea agregar más columnas se deberá modificar la clase Product.java, ya que es la encargada de establecer
las Entidades de la BD, al correr el APIrest se crean automaticamente esta tablas en la BD products, lo cual es IMPORTANTE CREAR PRIMERO
LA BASE DATOS.

En caso de correr el APIrest, sin un IDE se recomienda utilizar IntellIj Comunity, debe de ir al directorio raiz de la aplicación
y escribir el siguiente comando: mvnw spring-boot:run

Para una mejor visualización de los datos, utilice Google Chrome e instale la extensión Talend API Tester - Free Edition, para visualizar
en formato json y poder realizar pruebas mediante los métodos de HTTP (POST, GET, PUT, DELETE) y comprobar el correcto funcionamiento de la API.
