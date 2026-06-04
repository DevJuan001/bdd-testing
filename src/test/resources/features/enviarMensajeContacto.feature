# language: es
# author: Juan

Característica: Enviar mensaje de contacto
  El usuario debe estar autenticado para enviar un mensaje de contacto desde el formulario.

  Antecedentes:
    Dado que el usuario está en la página de inicio de sesión
    Cuando el usuario ingresa credenciales válidas
      | usuario                              | clave     |
      | customer@practicesoftwaretesting.com | welcome01 |

  @enviarMensajeContacto
  Esquema del escenario: Envío de mensaje de contacto exitoso
    Cuando el usuario navega al módulo de contacto y envía un mensaje
      | asunto   | mensaje   |
      | <asunto> | <mensaje> |
    Entonces se debe verificar que el mensaje de contacto fue enviado correctamente

    Ejemplos:
      | asunto           | mensaje           |
      | customer-service | Mensaje de prueba para probar si prueba la prueba para probar |
