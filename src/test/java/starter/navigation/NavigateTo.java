package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable choucairPage() {
        return Task.where("{0} opens the Choucair home page",
                Open.browserOn().the(ChoucairPage.class)
        );
    }
}