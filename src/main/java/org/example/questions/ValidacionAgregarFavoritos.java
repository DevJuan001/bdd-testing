package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.FavoritosPage.MENSAJE_EXITO_TOAST;

public class ValidacionAgregarFavoritos implements Question<Boolean> {
    private static final Logger logger =
            LoggerFactory.getLogger(ValidacionAgregarFavoritos.class);

    public static ValidacionAgregarFavoritos validacionAgregarFavoritos() {
        return new ValidacionAgregarFavoritos();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(MENSAJE_EXITO_TOAST, isVisible())
                            .forNoMoreThan(20).seconds()
            );
            String texto = Text.of(MENSAJE_EXITO_TOAST).viewedBy(actor).asString();
            logger.info("Texto del toast obtenido: {}", texto);
            return texto != null && !texto.isEmpty();
        } catch (Exception e) {
            logger.error("Toast de éxito no encontrado: {}", e.getMessage());
            return false;
        }
    }
}
