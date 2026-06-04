package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.models.MensajeContactoModelo;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.ContactoPage.*;

public class EnviarMensajeContacto implements Task {
    private List<MensajeContactoModelo> datos;

    public EnviarMensajeContacto(List<MensajeContactoModelo> datos) {
        this.datos = datos;
    }

    public static EnviarMensajeContacto enviarMensajeContacto(List<MensajeContactoModelo> datos) {
        return new EnviarMensajeContacto(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        MensajeContactoModelo contacto = datos.get(0);
        Random random = new Random();
        int sufijo = random.nextInt(9999);

        String asunto = contacto.getAsunto();
        String mensaje = contacto.getMensaje() + " " + sufijo;

        actor.attemptsTo(
            // Paso 1: Navegar al módulo de contacto
            WaitUntil.the(LINK_CONTACTO, isVisible())
                    .forNoMoreThan(15).seconds(),
            Click.on(LINK_CONTACTO),

            // Paso 2: Llenar el formulario de contacto
            WaitUntil.the(CAMPO_ASUNTO, isVisible())
                    .forNoMoreThan(10).seconds(),
            SelectFromOptions.byValue(asunto).from(CAMPO_ASUNTO),

            Enter.theValue(mensaje).into(CAMPO_MENSAJE),

            // Paso 3: Enviar el formulario
            WaitUntil.the(BOTON_ENVIAR, isVisible())
                    .forNoMoreThan(10).seconds(),
            Click.on(BOTON_ENVIAR)
        );
    }
}
