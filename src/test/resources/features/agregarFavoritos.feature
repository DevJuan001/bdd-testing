# language: es
# author: Juan

Característica: Agregar producto a favoritos
  El usuario debe estar autenticado para poder agregar un producto a su lista de favoritos.

  Antecedentes:
    Dado que el usuario está en la página de inicio de sesión
    Cuando el usuario ingresa credenciales válidas
      | usuario                              | clave     |
      | customer@practicesoftwaretesting.com | welcome01 |

  @agregarFavoritos
  Escenario: Agregar un producto a la lista de favoritos exitosamente
    Cuando el usuario selecciona un producto y lo agrega a favoritos
    Entonces se debe verificar que el producto fue agregado a favoritos correctamente
