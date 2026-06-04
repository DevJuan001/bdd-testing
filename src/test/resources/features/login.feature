# language: es
# author: Rigoberto Vargas

Característica: Inicio de sesión
  Como usuario registrado
  quiero iniciar sesión en la aplicación
  para poder acceder a mi cuenta

  @autenticacion
  Escenario: Verificar autenticación exitosa en la pagina de test
    Dado que el usuario está en la página de inicio de sesión
    Cuando el usuario ingresa credenciales válidas
      | usuario                              | clave     |
      | customer@practicesoftwaretesting.com | welcome01 |
    Entonces el usuario debería estar en la pagina de bienvenida

