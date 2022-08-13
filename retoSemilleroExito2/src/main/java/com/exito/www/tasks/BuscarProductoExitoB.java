package com.exito.www.tasks;

import com.exito.www.userIntefaces.ExitoHomeUI;
import com.exito.www.userIntefaces.ProductoExitoUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;


public class BuscarProductoExitoB implements Task {

    private String producto;

    public BuscarProductoExitoB(String producto) {
        this.producto = producto;
    }

    ProductoExitoUI productoExitoBUI = new ProductoExitoUI();
    ExitoHomeUI exitoHomeUI = new ExitoHomeUI();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(producto).into(exitoHomeUI.TXT_BARRA_DE_EXITO),
                Click.on(exitoHomeUI.BTN_BOTON_BUSCAR),
                Click.on(productoExitoBUI.BTN_PRODUCTOS)
        );

    }
    public static Performable enExito(String producto) {
        return Instrumented.instanceOf(BuscarProductoExitoB.class).withProperties(producto);
    }
}
