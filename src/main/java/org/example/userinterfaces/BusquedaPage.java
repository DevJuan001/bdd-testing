package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class BusquedaPage {

    public static final Target NAV_HOME =
            Target.the("enlace a inicio")
                    .located(By.cssSelector("[data-test='nav-home']"));

    public static final Target INPUT_BUSQUEDA =
            Target.the("campo de búsqueda")
                    .located(By.cssSelector("[data-test='search-query']"));

    public static final Target BTN_BUSQUEDA =
            Target.the("botón de buscar")
                    .located(By.cssSelector("[data-test='search-submit']"));

    public static final Target RESULTADO_PRODUCTO =
            Target.the("tarjeta de producto")
                    .located(By.cssSelector("[data-test='product-name']"));
}
