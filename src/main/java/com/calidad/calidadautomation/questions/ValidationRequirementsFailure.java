package com.calidad.calidadautomation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidationRequirementsFailure implements Question<Boolean> {
    private final WebDriver driver;

    public ValidationRequirementsFailure(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return isAlertPresent();
    }

    private boolean isAlertPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public static ValidationRequirementsFailure theRequirementsFailure(WebDriver driver) {
        return new ValidationRequirementsFailure(driver);
    }
}
