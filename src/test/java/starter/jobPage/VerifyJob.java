package starter.jobPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class VerifyJob implements Question<String> {

    public static Question<String> value(){
        return new VerifyPage();
    }

    //método que se encarga de obtener el valor del objeto por el que se pregunta
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(FindElements.NAME_COMPARE).getText().trim();
    }

}
