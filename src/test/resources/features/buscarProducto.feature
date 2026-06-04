# language: es
# author: Juan

Característica: Buscar producto
  El usuario busca un producto en la tienda.

  Antecedentes:
    Dado que el usuario está en la página de inicio de sesión
    Cuando el usuario ingresa credenciales válidas
      | usuario                              | clave     |
      | customer@practicesoftwaretesting.com | welcome01 |

  @buscarProducto
  Esquema del escenario: Búsqueda de producto exitosa
    Cuando el usuario navega a la página principal y busca un producto por su término
      | termino   |
      | <termino> |
    Entonces se debe verificar que al menos un resultado de producto es visible

    Ejemplos:
      | termino |
      | Pliers  |
