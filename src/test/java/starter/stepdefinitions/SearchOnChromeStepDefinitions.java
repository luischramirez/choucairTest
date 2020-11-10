package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.changePage.ChangePage;
import starter.jobPage.VerifyPage;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class SearchOnChromeStepDefinitions {

    String name;

    //metodo encargando de crear el actor
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    //método donde comienza a realizarse el feature
    @Given("(.*) ingresa a la pagina principal de Choucair")
    public void ingresa_a_la_pagina_principal_de_choucair(String name){
        this.name = name;
    }

    //método que realiza los pasos de acción del feature
    @When("el selecciona la opcion de Empleos")
    public void el_selecciona_la_opcion_de_empleos(){

        theActorCalled(name).attemptsTo(
                NavigateTo.choucairPage(),
                Click.on(ChangePage.OPTION_CHANGE)
                );
    }

    //método que se encarga de realizar la valicación del feature
    @Then("el puede visualizar la vista de Empleos")
    public void el_puede_visualizar_la_vista_de_empleos(){

        theActorInTheSpotlight().should(
                seeThat("En la página se encuentra el título", VerifyPage.value(), equalTo("SER CHOUCAIR"))
        );
    }

}
