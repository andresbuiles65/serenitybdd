package co.com.automation.task;

import co.com.automation.ui.LoginClienteUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {
    private final String username;
    private final String password;

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginClienteUI.TXT_NOMBRE_USUARIO),
                Enter.theValue(password).into(LoginClienteUI.TXT_PASSWORD),
                Click.on(LoginClienteUI.BUTTON_LOGIN)
        );

    }
}
