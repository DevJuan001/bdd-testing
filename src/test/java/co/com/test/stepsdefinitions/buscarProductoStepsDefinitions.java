package co.com.test.stepsdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import org.example.models.BuscarProductoModelo;
import org.example.questions.ValidacionBuscarProducto;
import org.example.tasks.BuscarProducto;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class buscarProductoStepsDefinitions {

    @Cuando("^el usuario navega a la página principal y busca un producto por su término$")
    public void elUsuarioBuscaUnProducto(List<BuscarProductoModelo> datos) {
        theActorInTheSpotlight().attemptsTo(
                BuscarProducto.buscarProducto(datos)
        );
    }

    @Entonces("^se debe verificar que al menos un resultado de producto es visible$")
    public void seDebeVerificarQueAlMenosUnResultadoEsVisible() {
        theActorInTheSpotlight().should(seeThat(
                ValidacionBuscarProducto.validacionBuscarProducto()
        ));
    }
}
