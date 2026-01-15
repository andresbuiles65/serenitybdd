package co.com.automation.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;

public class CheckNewTransactionWasAdded implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(By.xpath("//tbody[@id='transactions-list']"))
                        .text().contains("example")
        );


    }
}
