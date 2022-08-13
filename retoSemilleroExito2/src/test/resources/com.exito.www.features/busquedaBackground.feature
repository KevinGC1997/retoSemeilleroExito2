#language: en
Feature: Busqueda de tres productos en la barra de busqueda del exito

  Background:
    Given que me encuentro en la pagina del Exito https://www.exito.com/

  Scenario: Buscar productos en la pagina del exito
    When quiero buscar productos en la pagina del exito
      | productosExito |
      | televisor      |
    Then valido el nombre de mi producto
      | validacion                                              |
      | Televisor LG 65 Pulgadas Uhd4K Smart TV OLED65A1PSA.AWC |

  Scenario: Buscar productos en la pagina del exito
    When quiero buscar productos en la pagina del exito
      | productosExito |
      | celular        |
    Then valido el nombre de mi producto
      | validacion                              |
      | Celular SAMSUNG Galaxy M32 128 GB Negro |


  Scenario: Buscar productos en la pagina del exito
    When quiero buscar productos en la pagina del exito
      | productosExito |
      | nevera         |
    Then valido el nombre de mi producto
      | validacion                        |
      | Nevera HACEB No Frost 243 9002257 |