package co.com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AñadirTransaccionUI {

    public static final  Target BUTTON_TRANSACCION = Target.the("Añadir Transaccion").locatedBy("//button[contains(., 'Añadir transacción')]");
    public static final Target INPUT_FECHA = Target.the("Fecha").locatedBy("//input[@type='date']");
    public static final Target INPUT_MONTO = Target.the("Monto").located(By.id("amount"));
    public static final Target INPUT_DESCRIPCION = Target.the("Descripción").located(By.id("description"));
    public static final Target BUTTON_GUARDAR = Target.the("Guardar").locatedBy("//button[contains(., 'Guardar')]");
    // public static final Target REGISTRO_GUARDADO = Target.the("Registro en la tabla").located(By.xpath("//td[contains(text(),'ejemplo')]"));

}
