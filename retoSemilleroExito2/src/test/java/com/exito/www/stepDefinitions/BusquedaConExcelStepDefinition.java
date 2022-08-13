package com.exito.www.stepDefinitions;

import com.exito.www.tasks.BuscarProductoExitoE;
import com.exito.www.userIntefaces.ProductoExitoUI;
import com.exito.www.util.Excel;
import com.exito.www.util.VariableGlobal;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class BusquedaConExcelStepDefinition {

    ProductoExitoUI productoExitoUI = new ProductoExitoUI();
    VariableGlobal variableGlobal = new VariableGlobal();
    private static ArrayList<Map<String, String>> leerExcel = new ArrayList<Map<String, String>>();

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^quiero buscar tres productos en la pagina del exito$")
    public void quieroBuscarTresProductosEnLaPaginaDelExito() {
        OnStage.theActorInTheSpotlight().attemptsTo(BuscarProductoExitoE.enExito());

    }

    @Then("^valido el nombre de los tres productos$")
    public void validoElNombreDeLosTresProductos() {
        try {
            leerExcel = Excel.readExcel("exitoreto2.xlsx", "validacion");
        } catch (IOException e) {
            e.printStackTrace();
        }
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(WebElementQuestion
                .the(productoExitoUI.LBL_TITULO_DE_PRODUCTOS.of()),WebElementStateMatchers
                .containsText(leerExcel.get(variableGlobal.numRamdom).get("palabra"))));
    }
}
