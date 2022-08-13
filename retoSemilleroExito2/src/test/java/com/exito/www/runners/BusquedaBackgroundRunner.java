package com.exito.www.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/com.exito.www.features/busquedaBackground.feature",
        glue ="com.exito.www.stepDefinitions",
        snippets = SnippetType.CAMELCASE
)
public class BusquedaBackgroundRunner {
}
