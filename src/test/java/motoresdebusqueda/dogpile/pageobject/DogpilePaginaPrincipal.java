package motoresdebusqueda.dogpile.pageobject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.dogpile.com/")
public class DogpilePaginaPrincipal extends PageObject {

    @FindBy(xpath = "//input[@id='q']")
    WebElementFacade cajaDeBusqueda;

    @FindBy(xpath = "//div[@class='txt']")
    WebElementFacade botonDeBusqueda;

    public void ingresarPalabraClave(String palabraClave) {
        cajaDeBusqueda.type(palabraClave);
    }

    public void realizarBusqueda() {
        botonDeBusqueda.click();
    }
}
