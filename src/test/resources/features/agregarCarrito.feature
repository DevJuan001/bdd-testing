# language: es
# author: Juan

Característica: Agregar producto al carrito
  El usuario autenticado puede agregar un producto al carrito de compras.

  Antecedentes:
    Dado que el usuario está en la página de inicio de sesión
    Cuando el usuario ingresa credenciales válidas
      | usuario                              | clave     |
      | customer@practicesoftwaretesting.com | welcome01 |

  @agregarCarrito
  Escenario: Agregar un producto al carrito exitosamente
    Cuando el usuario selecciona un producto y lo agrega al carrito
    Entonces se debe verificar que el carrito tiene productos agregados
