package starter.jobPage;

import org.openqa.selenium.By;

public class ElementField {

    public static By KEYWORD_FIELD = new By.ById("search_keywords");
    public static By LOCATION_FIELD = new By.ById("search_location");
    public static By SEARCH_BUTTON = new By.ByXPath("//*[@id=\"content\"]/div/div/div/div/div/section[8]/div/div/div/div/div/div[3]/div/div/div/form/div[1]/div[4]/input");
}
