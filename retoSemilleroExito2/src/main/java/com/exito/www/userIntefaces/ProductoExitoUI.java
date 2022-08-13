package com.exito.www.userIntefaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductoExitoUI {
    public final Target BTN_PRODUCTOS = Target.the("Boton para clickear en productos")
            .locatedBy("(//a[@class='vtex-product-summary-2-x-clearLink vtex-product-summary"+
                    "-2-x-clearLink--productDefaultDescription h-100 flex flex-column'])[1]");

    public final Target LBL_TITULO_DE_PRODUCTOS = Target.the("Nombre de productos")
            .locatedBy("//span[@class='vtex-store-components-3-x-productBrand ']");

    public final Target BTN_PRODUCTO_LAVADORA_ALEATORIO = Target.the("boton para seleccionar un"+
            "producto alaeatorio").locatedBy("//a[@class='vtex-product-summary-2-x-clearLink vtex"+
            "-product-summary-2-x-clearLink--productDefaultDescription h-100 flex flex-column']");

    public final Target BTN_BOTON_CATEGORIA_LAVADORA = Target.the("boton a categoria lavadora")
            .locatedBy("//a[@href='/367?map=productClusterIds']");
}
