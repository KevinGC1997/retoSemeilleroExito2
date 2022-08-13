#language: en
  Feature: seleccion aleatoria de un producto dentro de una categoria
    Background:
      Given que me encuentro en la pagina del Exito https://www.exito.com/
    Scenario: seleccionar de manera aleatoria un producto de la categoria nevera
      When selecciono uno de los productos de forma aleatoria
      Then valido el nombre del producto seleccionado
