package co.edu.udea.certificacion.calidad.stepdefinitions;

import com.calidad.calidadautomation.questions.*;
import com.calidad.calidadautomation.tasks.*;
import com.calidad.calidadautomation.userinterfaces.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RequirementsFailureStepDefinitions {
    @Managed(driver = "chrome")
    public WebDriver driver;
    private final Actor estudiante = Actor.named("Carlitos");

    @Given("me encuentro en la pagina del home")
    public void meEncuentroPaginaHome(){
        driver.manage().window().maximize();
        estudiante.can(BrowseTheWeb.with(driver));
    }
    @When("digito un documento incorrecto")
    public void digitoNumeroIncorrecto(){
        estudiante.attemptsTo(HomePageFailure.Browser(new UsuarioPage()));
    }


    @Then("puedo ver una alerta con un mensaje de error al buscar el documento")
    public void puedoVerLaAlerta() {
        estudiante.should(seeThat(ValidationRequirementsFailure.theRequirementsFailure(driver), equalTo(true)));
    }


}
