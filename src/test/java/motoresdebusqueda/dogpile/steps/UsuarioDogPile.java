package motoresdebusqueda.dogpile.steps;

import motoresdebusqueda.dogpile.pageobject.DogPilePaginaResultado;
import motoresdebusqueda.dogpile.pageobject.DogpilePaginaPrincipal;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UsuarioDogPile {
    String actor;

    DogpilePaginaPrincipal paginaPrincipal;
    DogPilePaginaResultado paginaResultado;

    @Step("#actor ingresa a la pagina principal de dogpile")
    public void ingresar_a_dogpile() {
        paginaPrincipal.open();
    }

    @Step("#actor realiza una búsqueda de: {0}")
    public void busca_por_palabra_clave(String palabraClave) {
        paginaPrincipal.ingresarPalabraClave(palabraClave);
        paginaPrincipal.realizarBusqueda();
    }


    @Step("#actor deberia poder ver resultados que contengan la palabra {0}")
    public void deberia_ver_resutlados_con_palabra(String palabraEsperada) {
        List<String> resultados = paginaResultado.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }

        assertThat(resultados, Matchers.everyItem(containsString(palabraEsperada)));
    }

    @Step("#actor deberia ver el texto esperado: {1} en el resultado del título: {0}")
    public void deberia_ver_resultado_wikipedia_texto_correcto(String titulodeResultado, String textoDeResultadoEsperado) {
        String texto=paginaResultado.obtenerTextodeTituloResultado(titulodeResultado);
        System.out.println(texto);
        System.out.println(textoDeResultadoEsperado);
        assertThat(texto, containsString(textoDeResultadoEsperado));
    }
}
