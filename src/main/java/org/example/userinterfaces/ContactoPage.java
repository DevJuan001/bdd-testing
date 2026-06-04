package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ContactoPage {

    public static final Target LINK_CONTACTO =
            Target.the("enlace de navegación a contacto")
                    .located(By.cssSelector("[data-test='nav-contact']"));

    public static final Target CAMPO_ASUNTO =
            Target.the("campo asunto del formulario de contacto")
                    .located(By.cssSelector("[data-test='subject']"));

    public static final Target CAMPO_MENSAJE =
            Target.the("campo mensaje del formulario de contacto")
                    .located(By.cssSelector("[data-test='message']"));

    public static final Target BOTON_ENVIAR =
            Target.the("botón enviar mensaje de contacto")
                    .located(By.cssSelector("[data-test='contact-submit']"));

    public static final Target MENSAJE_EXITO =
            Target.the("mensaje de éxito al enviar contacto")
                    .located(By.cssSelector(".alert-success"));
}
