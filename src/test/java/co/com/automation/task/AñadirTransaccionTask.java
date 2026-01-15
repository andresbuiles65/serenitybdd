package co.com.automation.task;

import co.com.automation.stepdefinitions.AñadirTransaccion;
import co.com.automation.ui.AñadirTransaccionUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Date;

import static co.com.automation.ui.AñadirTransaccionUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AñadirTransaccionTask implements Task {

    private final String fecha;
    private final String monto;
    private final String descripcion;

    public AñadirTransaccionTask(String fecha, String monto, String descripcion){
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(fecha).into(INPUT_FECHA),
                Enter.theValue(monto).into(INPUT_MONTO),
                Enter.theValue(descripcion).into(INPUT_DESCRIPCION),
                Click.on(BUTTON_GUARDAR)
        );

    }
    public static AñadirTransaccionTask conDatos(String fecha, String monto, String descripcion){
        return instrumented(AñadirTransaccionTask.class, fecha, monto,descripcion);
    }
}
