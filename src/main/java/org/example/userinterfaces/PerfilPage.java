package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PerfilPage {

    public static final Target MENU_USUARIO =
            Target.the("menú desplegable del usuario")
                    .located(By.cssSelector("[data-test='nav-menu']"));

    public static final Target LINK_MI_CUENTA =
            Target.the("enlace a mi cuenta")
                    .located(By.cssSelector("[data-test='nav-my-account']"));

    public static final Target LINK_MI_PERFIL =
            Target.the("enlace a mi perfil")
                    .located(By.cssSelector("[data-test='nav-my-profile']"));

    public static final Target CAMPO_NOMBRE =
            Target.the("campo nombre del perfil")
                    .located(By.cssSelector("[data-test='first-name']"));

    public static final Target CAMPO_APELLIDO =
            Target.the("campo apellido del perfil")
                    .located(By.cssSelector("[data-test='last-name']"));

    public static final Target CAMPO_TELEFONO =
            Target.the("campo teléfono del perfil")
                    .located(By.cssSelector("[data-test='phone']"));

    public static final Target CAMPO_DIRECCION =
            Target.the("campo dirección del perfil")
                    .located(By.cssSelector("[data-test='street']"));

    public static final Target CAMPO_CIUDAD =
            Target.the("campo ciudad del perfil")
                    .located(By.cssSelector("[data-test='city']"));

    public static final Target CAMPO_ESTADO =
            Target.the("campo estado del perfil")
                    .located(By.cssSelector("[data-test='state']"));

    public static final Target CAMPO_PAIS =
            Target.the("campo país del perfil")
                    .located(By.cssSelector("[data-test='country']"));

    public static final Target CAMPO_CODIGO_POSTAL =
            Target.the("campo código postal del perfil")
                    .located(By.cssSelector("[data-test='postal_code']"));

    public static final Target BOTON_ACTUALIZAR =
            Target.the("botón actualizar perfil")
                    .located(By.cssSelector("[data-test='update-profile-submit']"));

    public static final Target MENSAJE_EXITO =
            Target.the("mensaje de éxito al actualizar perfil")
                    .located(By.cssSelector(".alert-success"));
}
