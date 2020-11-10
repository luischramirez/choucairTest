package starter.jobPage;

import net.bytebuddy.asm.Advice;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoSearch implements Task {

    private final String keyword;
    private final String location;

    public DoSearch(String keyword, String location) {
        this.keyword = keyword;
        this.location = location;
    }

    //permite hacer la invocación del constructor y permite realizar la manipulación de las variables con el nombre del método
    public static Performable withData (String keyword, String location){
        return instrumented(DoSearch.class, keyword, location);
    }

    //método que realiza las acciones o tareas que realizará el actor
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(keyword).into(ElementField.KEYWORD_FIELD),
                Enter.theValue(location).into(ElementField.LOCATION_FIELD),
                Click.on(ElementField.SEARCH_BUTTON)
        );
    }
}
