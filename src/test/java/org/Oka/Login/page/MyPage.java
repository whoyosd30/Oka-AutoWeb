package org.Oka.Login.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@DefaultUrl("/web/index.php/auth/login")
public class MyPage extends PageObject {
    @FindBy(name = "username")
    private WebElementFacade campoUsername;

    @FindBy(name = "password")
    private WebElementFacade campoPassword;

    @FindBy(xpath = "//button[contains(normalize-space(),'Login')]")
    private WebElementFacade btnLogin;

    @FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
    private WebElementFacade msjObligatorio;

    @FindBy(css = ".oxd-alert-content-text")
    private WebElementFacade msjError;

    public void ingresarCredencialesVálidas(String usuario, String contraseña) {
        campoUsername.sendKeys(usuario);
        campoPassword.sendKeys(contraseña);
    }

    public void pulsarBotónLogin() {
        btnLogin.waitUntilClickable();
        btnLogin.click();
    }

    public void validarAccesoAlDashboard() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"oxd-layout-container\"]")));
        WebElement encabezado = getDriver().findElement(By.tagName("h6"));
        assertEquals("Dashboard", encabezado.getText());
    }

    public void ingresarCredencialesInválidas(String usuarioIncorrecto, String contraseñaIncorrecta) {
        campoUsername.sendKeys(usuarioIncorrecto);
        campoPassword.sendKeys(contraseñaIncorrecta);
    }

    public void validarMensajeDeError(String mensaje) {
        if (msjError.isVisible()) {
            assertEquals(mensaje, msjError.getText());
        } else if (msjObligatorio.isVisible()) {
            assertEquals(mensaje, msjObligatorio.getText());
        } else {
            Assert.fail("No arroja ningún mensaje de error");
        }
    }
}
