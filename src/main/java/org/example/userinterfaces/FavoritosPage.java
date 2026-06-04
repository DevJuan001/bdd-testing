package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class FavoritosPage {
    public static final Target MENU_USUARIO =
            Target.the("menú desplegable del usuario")
                    .located(By.cssSelector("[data-test='nav-menu']"));

    public static final Target PRIMER_PRODUCTO =
            Target.the("primer producto de la lista")
                    .located(By.cssSelector("a[data-test='product-01KTA3HW114QVBQYPS8RSEDW93']"));

    public static final Target NOMBRE_PRODUCTO =
            Target.the("nombre del producto en detalle")
                    .located(By.cssSelector("[data-test='product-name']"));

    public static final Target BOTON_AGREGAR_FAVORITOS =
            Target.the("botón agregar a favoritos")
                    .located(By.cssSelector("[data-test='add-to-favorites']"));

    public static final Target MENSAJE_EXITO_TOAST =
            Target.the("mensaje toast de éxito al agregar a favoritos")
                    .located(By.cssSelector(".toast-message"));
}
