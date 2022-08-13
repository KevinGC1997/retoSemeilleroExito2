package com.exito.www.stepDefinitions;

import com.exito.www.driver.DriverScreenplay;
import com.exito.www.tasks.BuscarProductoExitoB;
import com.exito.www.userIntefaces.ProductoExitoUI;
import com.exito.www.util.Models;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.List;

public class BusquedaBackgroundStepDefinition {

    ProductoExitoUI productoExitoBUI = new ProductoExitoUI();

    @Before
    public void before() throws IOException{
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que me encuentro en la pagina del Exito (.*)$")
    public void queMeEncuentroEnLaPaginaDelExitoHttpsWwwExitoCom(String url) {
        OnStage.theActorCalled("Abrir la pagina del exito").can(BrowseTheWeb.with(DriverScreenplay
                .chromeDriver(url)));
    }

    @When("^quiero buscar productos en la pagina del exito$")
    public void quieroBuscarProductosEnLaPaginaDelExito(List<Models> arg1) {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoExitoB.enExito(arg1.get(0).getProductosExito()));

    }

    @Then("^valido el nombre de mi producto$")
    public void validoElNombreDeMiProducto(List<Models> arg1) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion
                .the(productoExitoBUI.LBL_TITULO_DE_PRODUCTOS.of()),WebElementStateMatchers
                .containsText(arg1.get(0).getValidacion())));
    }
}
