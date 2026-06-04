package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.PerfilPage.MENSAJE_EXITO;

public class ValidacionEditarPerfil implements Question<Boolean> {
    private static final Logger logger =
            LoggerFactory.getLogger(ValidacionEditarPerfil.class);

    public static ValidacionEditarPerfil validacionEditarPerfil() {
        return new ValidacionEditarPerfil();
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
            return texto.contains("¡Tu perfil se ha actualizado");
        } catch (Exception e) {
            logger.error("Elemento no encontrado: {}", e.getMessage());
            return false;
        }
    }
}
