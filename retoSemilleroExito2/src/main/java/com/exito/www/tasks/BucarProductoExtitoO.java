package com.exito.www.tasks;

import com.exito.www.userIntefaces.ExitoHomeUI;
import com.exito.www.userIntefaces.ProductoExitoUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BucarProductoExtitoO implements Task {

    ProductoExitoUI productoExitoUI = new ProductoExitoUI();
    ExitoHomeUI exitoHomeUI = new ExitoHomeUI();

    private String producto;

    public BucarProductoExtitoO(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(producto).into(exitoHomeUI.TXT_BARRA_DE_EXITO),
                Click.on(exitoHomeUI.BTN_BOTON_BUSCAR),
                WaitUntil.the(productoExitoUI.BTN_PRODUCTOS, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(productoExitoUI.BTN_PRODUCTOS)
        );
    }
    public static Performable enExito(String producto) {
        return Instrumented.instanceOf(BuscarProductoExitoB.class).withProperties(producto);
    }
}
