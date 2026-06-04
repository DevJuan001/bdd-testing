package co.com.test.stepsdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import org.example.questions.ValidacionAgregarCarrito;
import org.example.tasks.AgregarAlCarrito;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class agregarCarritoStepsDefinitions {

    @Cuando("^el usuario selecciona un producto y lo agrega al carrito$")
    public void elUsuarioSeleccionaUnProductoYLoAgregaAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.enLaTienda()
        );
    }

    @Entonces("^se debe verificar que el carrito tiene productos agregados$")
    public void seDebeVerificarQueElCarritoTieneProductosAgregados() {
        theActorInTheSpotlight().should(seeThat(
                ValidacionAgregarCarrito.validacionAgregarCarrito()
        ));
    }
}
