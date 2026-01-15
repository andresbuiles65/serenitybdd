package co.com.automation.stepdefinitions;

import co.com.automation.task.AñadirTransaccionTask;
import co.com.automation.task.CheckNewTransactionWasAdded;
import co.com.automation.task.Login;
import co.com.automation.ui.AñadirTransaccionUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AñadirTransaccion {
    @Managed(driver = "chrome")
    WebDriver driver;

    Actor usuario = Actor.named("usuario");

    @Dado("que el usuario está logueado y en la pagina de transacciones")
    public void usuarioLogueadoEnTransacciones(DataTable userLogin) {
        List<List<String>> rows = userLogin.asLists(String.class);
        String username = "";
        String password = "";
        for(List<String> columns: rows){
            username = columns.get(0);
            password = columns.get(1);
        }
        usuario.can(BrowseTheWeb.with(driver));
        driver.get("http://127.0.0.1:5500/login.html");

        usuario.attemptsTo(
                new Login(username, password)
        );
        if (!driver.getCurrentUrl().contains("transactions")) {
            throw new AssertionError("No se redirigió a la página de transacciones");
        }
    }

    @Cuando("da clic en el boton Añadir transacción")
    public void clicEnBotonAñadirTransaccion() {

        usuario.attemptsTo(
                Click.on(AñadirTransaccionUI.BUTTON_TRANSACCION)
        );
    }

    @Cuando("llena la información correctamente")
    public void llenarInformacionCorrectamente(DataTable llenarInfo) {
        List<List<String>> rows = llenarInfo.asLists(String.class);
        String fecha = "";
        String monto ="";
        String descripcion = "";
        for (List<String> columns:rows){
            fecha = columns.get(0);
            monto = columns.get(1);
            descripcion = columns.get(2);
        }
        usuario.attemptsTo(
                AñadirTransaccionTask.conDatos(fecha, monto, descripcion)
        );
    }
    @Entonces("se debe almacenar correctamente la transaccion")
    public void  seDebeAlmacenarCorrectamenteLaTransaccion() {
        usuario.attemptsTo(
                new CheckNewTransactionWasAdded()
        );
    }



}
