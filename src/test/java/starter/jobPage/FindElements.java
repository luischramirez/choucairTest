package starter.jobPage;

import org.openqa.selenium.By;

public class FindElements {

    //ruta para verificar que el texto se visualiza al cambiar de vista
    public static By TEXT_COMPARE = new By.ByXPath("//*[@id=\"content\"]/div/div/div/div/div/section[3]/div/div/div/div/div/div[2]/div/h2");

    //ruta de opción de lista de la sección de empleos
    public static By NAME_COMPARE = new By.ByXPath("//h3[contains(text(),'Analista de Pruebas Móviles')]");

}
