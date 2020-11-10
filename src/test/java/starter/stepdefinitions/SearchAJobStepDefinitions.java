package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.changePage.ChangePage;
import starter.jobPage.DoSearch;
import starter.jobPage.VerifyJob;
import starter.navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class SearchAJobStepDefinitions {

    String name;

    //metodo encargando de crear el escenario de actuación
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    //método donde comienza a realizarse el feature
    @Given("(.*) observa la sección de empleos")
    public void observa_la_seccion_de_empleos(String name){
        this.name = name;
    }

    //método que realiza los pasos de acción del feature
    @When("el ingresa los criterios de busqueda")
    public void el_ingresa_los_criterios_de_busqueda(){

        theActorCalled(name).attemptsTo(
                NavigateTo.choucairPage(),
                Click.on(ChangePage.OPTION_CHANGE),
                DoSearch.withData("pruebas", "bogota")
        );

    }

    //método que se encarga de realizar la valicación del feature
    @Then("observa los empleos relacionados a la busqueda")
    public void empleos_relacionados_a_la_busqueda(){

        theActorInTheSpotlight().should(
                seeThat("En la lista de empleos", VerifyJob.value(), equalTo("Analista de Pruebas Móviles"))
        );

    }
}
