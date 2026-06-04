package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.CarritoPage.*;

public class AgregarAlCarrito implements Task {

    public static AgregarAlCarrito enLaTienda() {
        return new AgregarAlCarrito();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(BOTON_MODULO_INICIO, isVisible())
                    .forNoMoreThan(15).seconds(),
            Click.on(BOTON_MODULO_INICIO),

            // Paso 2: Seleccionar el primer producto de la tienda
            WaitUntil.the(PRIMER_PRODUCTO, isVisible())
                    .forNoMoreThan(15).seconds(),
            Click.on(PRIMER_PRODUCTO),

            // Paso 3: Esperar a que cargue el detalle del producto
            WaitUntil.the(NOMBRE_PRODUCTO, isVisible())
                    .forNoMoreThan(15).seconds(),

            // Paso 4: Hacer clic en agregar al carrito
            WaitUntil.the(BOTON_AGREGAR_CARRITO, isVisible())
                    .forNoMoreThan(10).seconds(),
            Click.on(BOTON_AGREGAR_CARRITO)
        );
    }
}
