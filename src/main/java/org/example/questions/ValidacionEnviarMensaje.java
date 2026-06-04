package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.ContactoPage.MENSAJE_EXITO;

public class ValidacionEnviarMensaje implements Question<Boolean> {
    private static final Logger logger =
            LoggerFactory.getLogger(ValidacionEnviarMensaje.class);

    public static ValidacionEnviarMensaje validacionEnviarMensaje() {
        return new ValidacionEnviarMensaje();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(MENSAJE_EXITO, isVisible())
                            .forNoMoreThan(20).seconds()
            );
            String texto = Text.of(MENSAJE_EXITO).viewedBy(actor).asString();
            logger.info("Texto obtenido: {}", texto);
            return texto != null && !texto.isEmpty();
        } catch (Exception e) {
            logger.error("Elemento no encontrado: {}", e.getMessage());
            return false;
        }
    }
}
