package co.com.test.stepsdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import org.example.models.MensajeContactoModelo;
import org.example.questions.ValidacionEnviarMensaje;
import org.example.tasks.EnviarMensajeContacto;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class enviarMensajeContactoStepsDefinitions {

    @Cuando("^el usuario navega al módulo de contacto y envía un mensaje$")
    public void elUsuarioNavegaAlModuloDeContactoYEnviaUnMensaje(List<MensajeContactoModelo> datos) {
        theActorInTheSpotlight().attemptsTo(
                EnviarMensajeContacto.enviarMensajeContacto(datos)
        );
    }

    @Entonces("^se debe verificar que el mensaje de contacto fue enviado correctamente$")
    public void seDebeVerificarQueElMensajeDeContactoFueEnviadoCorrectamente() {
        theActorInTheSpotlight().should(seeThat(
                ValidacionEnviarMensaje.validacionEnviarMensaje()
        ));
    }
}
