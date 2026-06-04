package org.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.userinterfaces.BusquedaPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.BusquedaPage.RESULTADO_PRODUCTO;

public class ValidacionBuscarProducto implements Question<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionBuscarProducto.class);

    public static ValidacionBuscarProducto validacionBuscarProducto() {
        return new ValidacionBuscarProducto();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            actor.attemptsTo(
                    WaitUntil.the(RESULTADO_PRODUCTO, isVisible()).forNoMoreThan(10).seconds()
            );
            boolean isVisible = RESULTADO_PRODUCTO.resolveFor(actor).isVisible();
            logger.info("Resultado visible: {}", isVisible);
            return isVisible;
        } catch (Exception e) {
            logger.error("No se encontraron resultados: {}", e.getMessage());
            return false;
        }
    }
}
