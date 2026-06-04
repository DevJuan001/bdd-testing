package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {
    public static final Target BOTON_MODULO_INICIO =
            Target.the("primer producto de la tienda")
                    .located(By.cssSelector("a[data-test='nav-home']"));

    public static final Target MENU_USUARIO =
            Target.the("primer producto de la tienda")
                    .located(By.id("menu"));

    public static final Target PRIMER_PRODUCTO =
            Target.the("primer producto de la tienda")
                    .located(By.cssSelector(".card[data-test^='product-']"));

    public static final Target NOMBRE_PRODUCTO =
            Target.the("nombre del producto en detalle")
                    .located(By.cssSelector("[data-test='product-name']"));

    public static final Target CAMPO_CANTIDAD =
            Target.the("campo de cantidad del producto")
                    .located(By.cssSelector("[data-test='quantity']"));

    public static final Target BOTON_AGREGAR_CARRITO =
            Target.the("botón agregar al carrito")
                    .located(By.cssSelector("[data-test='add-to-cart']"));

    public static final Target ICONO_CARRITO =
            Target.the("icono del carrito en la barra de navegación")
                    .located(By.cssSelector("[data-test='nav-cart']"));

    public static final Target BADGE_CANTIDAD_CARRITO =
            Target.the("badge de cantidad de productos en el carrito")
                    .located(By.cssSelector("[data-test='cart-quantity']"));
}
