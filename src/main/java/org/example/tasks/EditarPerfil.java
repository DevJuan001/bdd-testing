package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.models.EditarPerfilModelo;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.example.userinterfaces.PerfilPage.*;

public class EditarPerfil implements Task {
    private List<EditarPerfilModelo> datos;

    public EditarPerfil(List<EditarPerfilModelo> datos) {
        this.datos = datos;
    }

    public static EditarPerfil editarPerfil(List<EditarPerfilModelo> datos) {
        return new EditarPerfil(datos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        EditarPerfilModelo perfil = datos.get(0);
        Random random = new Random();
        int sufijo = random.nextInt(9999);

        String nombre = perfil.getNombre() + sufijo;
        String apellido = perfil.getApellido() + sufijo;
        String telefono = String.format("%010d", Math.abs(random.nextLong() % 10000000000L));
        String direccion = perfil.getDireccion() + " " + sufijo;
        String ciudad = perfil.getCiudad() + sufijo;
        String estado = perfil.getEstado() + sufijo;
        String pais = perfil.getPais() + sufijo;
        String codigoPostal = String.format("%06d", random.nextInt(999999));

        actor.attemptsTo(
            // Paso 1: Navegar al módulo de perfil
            WaitUntil.the(MENU_USUARIO, isVisible())
                    .forNoMoreThan(15).seconds(),
            Click.on(MENU_USUARIO),

            WaitUntil.the(LINK_MI_PERFIL, isVisible())
                    .forNoMoreThan(10).seconds(),
            Click.on(LINK_MI_PERFIL),

            // Paso 2: Editar campos del perfil con datos random
            WaitUntil.the(CAMPO_NOMBRE, isVisible())
                    .forNoMoreThan(10).seconds(),

            Clear.field(CAMPO_NOMBRE),
            Enter.theValue(nombre).into(CAMPO_NOMBRE),

            Clear.field(CAMPO_APELLIDO),
            Enter.theValue(apellido).into(CAMPO_APELLIDO),

            Clear.field(CAMPO_TELEFONO),
            Enter.theValue(telefono).into(CAMPO_TELEFONO),

            Clear.field(CAMPO_DIRECCION),
            Enter.theValue(direccion).into(CAMPO_DIRECCION),

            Clear.field(CAMPO_CODIGO_POSTAL),
            Enter.theValue(codigoPostal).into(CAMPO_CODIGO_POSTAL),

            Clear.field(CAMPO_CIUDAD),
            Enter.theValue(ciudad).into(CAMPO_CIUDAD),

            Clear.field(CAMPO_ESTADO),
            Enter.theValue(estado).into(CAMPO_ESTADO),

            Clear.field(CAMPO_PAIS),
            Enter.theValue(pais).into(CAMPO_PAIS),

            // Paso 3: Guardar
            WaitUntil.the(BOTON_ACTUALIZAR, isClickable())
                    .forNoMoreThan(10).seconds(),
            Click.on(BOTON_ACTUALIZAR)
        );
    }
}
