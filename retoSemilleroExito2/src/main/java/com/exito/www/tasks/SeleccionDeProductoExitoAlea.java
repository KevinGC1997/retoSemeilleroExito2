package com.exito.www.tasks;

import com.exito.www.interactions.Scrolling;
import com.exito.www.interactions.SeleccionarProductoAleatoria;
import com.exito.www.userIntefaces.ExitoHomeUI;
import com.exito.www.userIntefaces.ProductoExitoUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionDeProductoExitoAlea implements Task {

    ProductoExitoUI  productoExitoUI = new ProductoExitoUI();
    ExitoHomeUI exitoHomeUI = new ExitoHomeUI();


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scrolling.enExito(),
                Click.on(exitoHomeUI.BTN_BOTON_CATEGORIA_HOME),
                Click.on(productoExitoUI.BTN_BOTON_CATEGORIA_LAVADORA),
                SeleccionarProductoAleatoria.enCategoriaLavadoraExito()
        );

    }
    public static Performable enExito() {
        return Instrumented.instanceOf(SeleccionDeProductoExitoAlea.class).withProperties();
    }
}
