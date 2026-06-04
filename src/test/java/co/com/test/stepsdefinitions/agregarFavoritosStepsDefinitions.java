package co.com.test.stepsdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import org.example.questions.ValidacionAgregarFavoritos;
import org.example.tasks.AgregarAFavoritos;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class agregarFavoritosStepsDefinitions {

    @Cuando("^el usuario selecciona un producto y lo agrega a favoritos$")
    public void elUsuarioSeleccionaUnProductoYLoAgregaAFavoritos() {
        theActorInTheSpotlight().attemptsTo(
                AgregarAFavoritos.elProducto()
        );
    }

    @Entonces("^se debe verificar que el producto fue agregado a favoritos correctamente$")
    public void seDebeVerificarQueElProductoFueAgregadoAFavoritosCorrectamente() {
        theActorInTheSpotlight().should(seeThat(
                ValidacionAgregarFavoritos.validacionAgregarFavoritos()
        ));
    }
}
