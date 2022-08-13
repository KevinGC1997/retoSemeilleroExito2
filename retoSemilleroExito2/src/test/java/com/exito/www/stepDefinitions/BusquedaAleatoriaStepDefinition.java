package com.exito.www.stepDefinitions;

import com.exito.www.tasks.SeleccionDeProductoExitoAlea;
import com.exito.www.userIntefaces.ProductoExitoUI;
import com.exito.www.util.VariableGlobalNevera;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;

public class BusquedaAleatoriaStepDefinition {

    ProductoExitoUI productoExitoUI = new ProductoExitoUI();

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }
    @When("^selecciono uno de los productos de forma aleatoria$")
    public void seleccionoUnoDeLosProductosDeFormaAleatoria() {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionDeProductoExitoAlea.enExito());
    }

    @Then("^valido el nombre del producto seleccionado$")
    public void validoElNombreDelProductoSeleccionado() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion
                .the(productoExitoUI.LBL_TITULO_DE_PRODUCTOS), WebElementStateMatchers
                .containsText(VariableGlobalNevera.productoAleatorio)));
    }
}
