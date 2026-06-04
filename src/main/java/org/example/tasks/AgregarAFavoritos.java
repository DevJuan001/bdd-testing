package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.CarritoPage.BOTON_MODULO_INICIO;
import static org.example.userinterfaces.FavoritosPage.*;

public class AgregarAFavoritos implements Task {

    public static AgregarAFavoritos elProducto() {
        return new AgregarAFavoritos();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(BOTON_MODULO_INICIO, isVisible())
                    .forNoMoreThan(15).seconds(),
            Click.on(BOTON_MODULO_INICIO),

            // Paso 2: Navegar al detalle del primer producto
            WaitUntil.the(PRIMER_PRODUCTO, isVisible())
                    .forNoMoreThan(15).seconds(),
            Click.on(PRIMER_PRODUCTO),

            // Paso 3: Esperar la página de detalle y agregar a favoritos
            WaitUntil.the(NOMBRE_PRODUCTO, isVisible())
                    .forNoMoreThan(15).seconds(),

            WaitUntil.the(BOTON_AGREGAR_FAVORITOS, isVisible())
                    .forNoMoreThan(10).seconds(),
            Click.on(BOTON_AGREGAR_FAVORITOS)
        );
    }
}
