package co.com.test.stepsdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import org.example.models.EditarPerfilModelo;
import org.example.questions.ValidacionEditarPerfil;
import org.example.tasks.EditarPerfil;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class editarPerfilStepsDefinitions {

    @Cuando("^el usuario navega al módulo de perfil y edita su información personal$")
    public void elUsuarioNavegaAlModuloDePerfilYEditaSuInformacionPersonal(List<EditarPerfilModelo> datos) {
        theActorInTheSpotlight().attemptsTo(
                EditarPerfil.editarPerfil(datos)
        );
    }

    @Entonces("^se debe verificar que el perfil fue actualizado correctamente$")
    public void seDebeVerificarQueElPerfilFueActualizadoCorrectamente() {
        theActorInTheSpotlight().should(seeThat(
                ValidacionEditarPerfil.validacionEditarPerfil()
        ));
    }
}
