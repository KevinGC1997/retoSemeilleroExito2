package com.exito.www.tasks;

import com.exito.www.userIntefaces.ExitoHomeUI;
import com.exito.www.userIntefaces.ProductoExitoUI;
import com.exito.www.util.Excel;
import com.exito.www.util.VariableGlobal;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarProductoExitoE implements Task {

    Random random = new Random();

    VariableGlobal variableGlobal = new VariableGlobal();
    ProductoExitoUI productoExitoUI = new ProductoExitoUI();

    ExitoHomeUI exitoHomeUI = new ExitoHomeUI();
    private static ArrayList<Map<String, String>> leerExcel = new ArrayList<Map<String, String>>();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            leerExcel = Excel.readExcel("exitoreto2.xlsx", "terminos de busquesa");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numRandom1 = random.nextInt(2);
        variableGlobal.numRamdom =numRandom1;
            actor.attemptsTo(
                    Enter.keyValues(leerExcel.get(variableGlobal.numRamdom).get("buscar")).into(exitoHomeUI.TXT_BARRA_DE_EXITO),
                    Click.on(exitoHomeUI.BTN_BOTON_BUSCAR),
                    WaitUntil.the(productoExitoUI.BTN_PRODUCTOS, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(productoExitoUI.BTN_PRODUCTOS)
            );
        }
    public static Performable enExito() {
        return Instrumented.instanceOf(BuscarProductoExitoE.class).withProperties();
    }
}
