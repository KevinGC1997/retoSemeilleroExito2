#language: en
Feature: Busqueda de cinco productos en la barra de busqueda del exito

  Scenario Outline:<url><productos><validaciones>
    Given que me encuentro en la pagina del Exito <url>
    When quiero buscar cinco productos en la pagina del exito <producto>
    Then valido el nombre de los cinco producto <validaciones>

    Examples:
      | Caso                  | producto  | url                    | validaciones                                              |
      | Bucar producto exito  | consola   | https://www.exito.com/ | CONSOLA SERIES S XBOX RRS00004                          |
      | Buscar producto exito | estufa    | https://www.exito.com/ | Estufa piso con horno Gas 4Pts ABBA AT1015N             |
      | Buscar producto exito | televisor | https://www.exito.com/ | Televisor LG 65 Pulgadas Uhd4K Smart TV OLED65A1PSA.AWC |
      | Buscar producto exito | celular   | https://www.exito.com/ | Celular SAMSUNG Galaxy M32 128 GB Negro                 |
      | Buscar producto exito | nevera    | https://www.exito.com/ | Nevera HACEB No Frost 243 9002257                       |