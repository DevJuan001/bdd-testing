package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class autenticacion extends PageObject {

    public static final Target MENU_USUARIO =
            Target.the("menú del usuario")
                    .located(By.cssSelector("[data-test='nav-menu']"));

    public static final Target BOTON_MODULO_LOGIN =
            Target.the("campo usuario")
                    .located(By.cssSelector("a[data-test='nav-sign-in']"));

    public static final Target INPUT_EMAIL =
            Target.the("campo correo")
                    .located(By.id("email"));

    public static final Target INPUT_CLAVE =
            Target.the("campo clave")
                    .located(By.id("password"));

    public static final Target BTN_INICIO_SESION =
            Target.the("botón iniciar sesión")
                    .located(By.cssSelector("input[data-test='login-submit']"));

    public static final Target MENSAJE_LOGIN =
            Target.the("")
                    .located(By.id("welcome-message"));

}
