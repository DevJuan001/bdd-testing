package org.example.tasks;

import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.models.CredencialesInicioSesion;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.example.userinterfaces.CarritoPage.BOTON_MODULO_INICIO;
import static org.example.userinterfaces.autenticacion.*;

public class Autenticarse implements Task {

    private List<CredencialesInicioSesion> credenciales;
    public Autenticarse(List<CredencialesInicioSesion> credenciales) {
        this.credenciales = credenciales;
    }


    public static Autenticarse aute(List<CredencialesInicioSesion> credenciales) {
        return Instrumented.instanceOf(Autenticarse.class)
                .withProperties(credenciales);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_MODULO_LOGIN),

                Click.on(INPUT_EMAIL),
                Enter.theValue(credenciales.get(0).getUsuario())
                        .into(INPUT_EMAIL),

                Click.on(INPUT_CLAVE),
                Enter.theValue(credenciales.get(0).getClave())
                        .into(INPUT_CLAVE),

                Click.on(BTN_INICIO_SESION),

                WaitUntil.the(MENU_USUARIO, isVisible())
                        .forNoMoreThan(15).seconds()
        );


        theActorInTheSpotlight().remember(SesionVariable.usuario.toString(),credenciales.get(0).getUsuario()
        );
    }
}