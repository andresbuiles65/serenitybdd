package co.com.automation.stepdefinitions;

import co.com.automation.models.LoginModel;
import co.com.automation.task.Login;
import co.com.automation.util.GetInfoFromTable;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginStepDefinitions {
    @Managed(driver = "chrome")
    WebDriver driver;
    Actor usuario = Actor.named("usuario");

    @Dado("que el usuario abre la pagina del login")
    public void abrirPagina(){
        usuario.can(BrowseTheWeb.with(driver));
        driver.get("http://127.0.0.1:5500/login.html");
    }

    @Cuando("ingrese las correctas credenciales")
    public void ingresarCredenciales(DataTable userLogin){

        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin);

        usuario.attemptsTo(
              new Login(loginModel.getUsername(), loginModel.getPassword())
        );
    }
    @Entonces("redirigir a pagina transacciones")
    public void redirigirPaginaTransacciones(){
        String urlActual = driver.getCurrentUrl();
        if(!urlActual.contains("transactions")){
            throw new AssertionError("No se redirigio a la pagina de transacciones ");
        }
    }

}
