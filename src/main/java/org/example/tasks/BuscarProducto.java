package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.models.BuscarProductoModelo;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.BusquedaPage.*;

public class BuscarProducto implements Task {
    private List<BuscarProductoModelo> datos;

    public BuscarProducto(List<BuscarProductoModelo> datos) {
        this.datos = datos;
    }

    public static BuscarProducto buscarProducto(List<BuscarProductoModelo> datos) {
        return new BuscarProducto(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BuscarProductoModelo busqueda = datos.get(0);

        actor.attemptsTo(
                WaitUntil.the(NAV_HOME, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(NAV_HOME),

                WaitUntil.the(INPUT_BUSQUEDA, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(busqueda.getTermino()).into(INPUT_BUSQUEDA),
                Click.on(BTN_BUSQUEDA)
        );
    }
}
