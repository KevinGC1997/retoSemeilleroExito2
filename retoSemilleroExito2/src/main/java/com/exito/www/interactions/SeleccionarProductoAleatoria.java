package com.exito.www.interactions;

import com.exito.www.userIntefaces.ProductoExitoUI;
import com.exito.www.util.VariableGlobalNevera;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.List;
import java.util.Random;

public class SeleccionarProductoAleatoria implements Task {

    ProductoExitoUI productoExitoUI = new ProductoExitoUI();
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
        Random random = new Random();
        List<WebElementFacade> listaBtnProductos = productoExitoUI.BTN_PRODUCTO_LAVADORA_ALEATORIO.resolveAllFor(actor);
        List<WebElementFacade> listaLblProductos = productoExitoUI.LBL_TITULO_DE_PRODUCTOS.resolveAllFor(actor);
        int numRandom = random.nextInt(listaBtnProductos.size());
        VariableGlobalNevera.productoAleatorio =listaLblProductos.get(numRandom).getText();
        listaBtnProductos.get(numRandom).click();
        try {Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
    }
    public static Performable enCategoriaLavadoraExito(){
        return Instrumented.instanceOf(SeleccionarProductoAleatoria.class).withProperties();
    }
}
