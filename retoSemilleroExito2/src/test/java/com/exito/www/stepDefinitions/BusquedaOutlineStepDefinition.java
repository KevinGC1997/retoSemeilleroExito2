package com.exito.www.stepDefinitions;

import com.exito.www.tasks.BucarProductoExtitoO;
import com.exito.www.tasks.BuscarProductoExitoB;
import com.exito.www.userIntefaces.ProductoExitoUI;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;

public class BusquedaOutlineStepDefinition {

    ProductoExitoUI productoExitoUI = new ProductoExitoUI();

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^quiero buscar cinco productos en la pagina del exito (.*)$")
    public void quieroBuscarCincoProductosEnLaPaginaDelExito(String arg1) {
        OnStage.theActorInTheSpotlight().attemptsTo(BucarProductoExtitoO.enExito(arg1));
    }

    @Then("^valido el nombre de los cinco producto (.*)$")
    public void validoElNombreDeLosCincoProducto(String arg1) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion
                .the(productoExitoUI.LBL_TITULO_DE_PRODUCTOS.of()), WebElementStateMatchers
                .containsText(arg1)));

    }
}
