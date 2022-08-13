package com.exito.www.userIntefaces;

import net.serenitybdd.screenplay.targets.Target;

public class ExitoHomeUI {

    public final Target TXT_BARRA_DE_EXITO = Target.the("Barra de busqueda de exito")
            .locatedBy("//input[@class='vtex-styleguide-9-x-input ma0 border-box vtex-"+
                    "styleguide-9-x-hideDecorators vtex-styleguide-9-x-noAppearance br2  br-0 br--left "+
                    " w-100 bn outline-0 bg-base c-on-base b--muted-4 hover-b--muted-3 t-body pl5 ']");

    public final Target BTN_BOTON_CATEGORIA_HOME = Target.the("boton a categoria electrodomestivos ")
            .locatedBy("//a[@href='/electrodomesticos']");

    public final Target BTN_BOTON_BUSCAR = Target.the("boton de buscar")
            .locatedBy("//button[@class=' vtex-store-components-3-x-searchBarIcon vtex-store"+
                    "-components-3-x-searchBarIcon--search flex items-center pointer bn bg-transparent outline"+
                    "-0 pv0 pl0 pr3']");
}
