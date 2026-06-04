package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.CarritoPage.*;

public class ValidacionAgregarCarrito implements Question<Boolean> {
    private static final Logger logger =
            LoggerFactory.getLogger(ValidacionAgregarCarrito.class);

    public static ValidacionAgregarCarrito validacionAgregarCarrito() {
        return new ValidacionAgregarCarrito();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(BADGE_CANTIDAD_CARRITO, isVisible())
                            .forNoMoreThan(15).seconds()
            );

            String cantidadTexto = Text.of(BADGE_CANTIDAD_CARRITO).viewedBy(actor).asString();
            logger.info("Cantidad en el carrito: {}", cantidadTexto);

            return cantidadTexto != null
                    && !cantidadTexto.trim().isEmpty()
                    && !cantidadTexto.trim().equals("0");
        } catch (Exception e) {
            logger.error("Error al validar el carrito: {}", e.getMessage());
            return false;
        }
    }
}
