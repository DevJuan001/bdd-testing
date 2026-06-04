# language: es
# author: Juan

Característica: Editar perfil de usuario
  El usuario debe estar autenticado para poder editar su información de perfil.

  Antecedentes:
    Dado que el usuario está en la página de inicio de sesión
    Cuando el usuario ingresa credenciales válidas
      | usuario                              | clave     |
      | customer@practicesoftwaretesting.com | welcome01 |

  @editarPerfil
  Esquema del escenario: Edición de perfil exitosa
    Cuando el usuario navega al módulo de perfil y edita su información personal
      | nombre   | apellido   | telefono   | direccion   | ciudad   | estado   | pais   | codigo_postal   |
      | <nombre> | <apellido> | <telefono> | <direccion> | <ciudad> | <estado> | <pais> | <codigo_postal> |
    Entonces se debe verificar que el perfil fue actualizado correctamente

    Ejemplos:
      | nombre | apellido | telefono   | direccion       | ciudad | estado       | pais     | codigo_postal |
      | Jane   | Doe      | 1234567890 | Calle 123 #45-6 | Bogota | Cundinamarca | Colombia | 110111        |
