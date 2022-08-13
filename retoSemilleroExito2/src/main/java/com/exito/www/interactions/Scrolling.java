package com.exito.www.interactions;

import com.exito.www.driver.DriverScreenplay;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class Scrolling implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        DriverScreenplay.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor) DriverScreenplay.driver;
        jse.executeScript("window.scrollBy(0,600)");
        try{Thread.sleep(6000);}catch(InterruptedException e){Thread.currentThread().interrupt();}

    }
    public static Performable enExito(){
        return Instrumented.instanceOf(Scrolling.class).withProperties();
    }
}
