package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.autenticacion.MENU_USUARIO;


public class ValidacionLogin implements Question<Boolean> {
    private static final Logger logger =
            LoggerFactory.getLogger(ValidacionLogin.class);

    public static ValidacionLogin validacionLogin() {
        return new ValidacionLogin();
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(MENU_USUARIO, isVisible())
                            .forNoMoreThan(15).seconds()
            );
            boolean isVisible = MENU_USUARIO.resolveFor(actor).isVisible();
            logger.info("El menú de usuario es visible: {}", isVisible);
            return isVisible;
        } catch (Exception e) {
            logger.error("Elemento no encontrado: {}", e.getMessage());
            return false;
        }
    }
}