package motoresdebusqueda.dogpile;

import motoresdebusqueda.dogpile.steps.UsuarioDogPile;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CuandoBuscoResultadosConTexto {

    @Steps
    UsuarioDogPile juan;

    @Managed
    WebDriver driver;

    @Test
    public void resultado_wikipedia_con_datos_correctos()
    {
        juan.ingresar_a_dogpile();
        juan.busca_por_palabra_clave("rock nacional");
        juan.deberia_ver_resultado_wikipedia_texto_correcto("Argentine rock - Wikipedia","Argentine rock (known locally as rock nacional");

    }
}
