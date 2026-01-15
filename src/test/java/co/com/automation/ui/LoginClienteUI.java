package co.com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginClienteUI {
    public static final Target TXT_NOMBRE_USUARIO = Target.the("Nombre de usuario").located(By.id("username"));
    public static final Target TXT_PASSWORD = Target.the("password").located(By.id("password"));
    public static final Target BUTTON_LOGIN = Target.the("iniciar sesion").located(By.cssSelector(".btn.btn-primary"));
}
