package org.Oka.User.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.util.List;

import static org.junit.Assert.assertEquals;

@DefaultUrl("/web/index.php/auth/login")
public class MyPage extends PageObject {
    @FindBy(name = "username")
    private WebElementFacade campoUsername;

    @FindBy(name = "password")
    private WebElementFacade campoPassword;

    @FindBy(xpath = "//button[contains(normalize-space(),'Login')]")
    private WebElementFacade btnLogin;

    @FindBy(xpath = "//span[contains(@class,'oxd-main-menu-item--name') and text()='Admin']")
    private WebElementFacade opciónAdmin;

    @FindBy(xpath = "(//div[@class=\"oxd-select-text oxd-select-text--active\"])[1]")
    private WebElementFacade selectRole;

    @FindBy(xpath = "//button[contains(@class,'oxd-button--secondary orangehrm-left-space') and normalize-space()='Search']")
    private WebElementFacade btnSearch;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private WebElementFacade campoName;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElementFacade campoEmpleado;

    @FindBy(xpath = "//div[@role='listbox']//span")
    private WebElementFacade listaEmpleados;

    @FindBy(xpath = "//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]")
    private WebElementFacade selectStatus;

    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text\"]")
    private WebElementFacade popupError;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElementFacade btnAdd;

    @FindBy(xpath = "//label[text()='Password']/following::input[1]")
    private WebElementFacade campoPassw;

    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
    private WebElementFacade campoConfiPassw;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElementFacade btnSave;

    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text\"]")
    private WebElementFacade popupHappy;


    private String Role;
    private String UserName;

    public void autenticarse(String usuario, String contraseña) {
        campoUsername.sendKeys(usuario);
        campoPassword.sendKeys(contraseña);
        btnLogin.waitUntilClickable();
        btnLogin.click();
    }

    public void validarAccesoAlDashboard() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"oxd-layout-container\"]")));
        WebElement encabezado = getDriver().findElement(By.tagName("h6"));
        assertEquals("Dashboard", encabezado.getText());
    }

    public void seleccionOpciónAdmin() {
        opciónAdmin.waitUntilClickable();
        opciónAdmin.click();
    }

    public void validarAccesoALaGestiónDeUsuarios() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module') and text()='Admin']")));
        WebElement encabezado = getDriver().findElement(By.xpath("//h6[2]"));
        assertEquals("User Management", encabezado.getText());
    }

    public void seleccionarRolDeUsuario(String role) {
        selectRole.waitUntilClickable();
        selectRole.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement adminOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option' and normalize-space()='" + role + "']")));
        adminOption.click();
        this.Role = role;
    }

    public void pulsarSearch() {
        btnSearch.waitUntilClickable();
        btnSearch.click();
    }

    public boolean validarFiltrado() {
        List<WebElement> filas = getDriver().findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));
        if (filas.isEmpty()) {
            System.out.println("No se encontraron registros tras filtrar.");
            return false;
        }

        for (WebElement fila : filas) {
            String rol = fila.findElement(By.xpath(".//div[@role='cell'][3]")).getText().trim();
            if (!rol.equalsIgnoreCase(Role)) {
                System.out.println("Se encontró un usuario con rol diferente: " + rol);
                return false;
            }
        }

        System.out.println("Todos los usuarios mostrados tienen el rol: " + Role);
        return true;
    }

    public boolean accionesVisibles() {
        List<WebElement> filas = getDriver().findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));
        if (filas.isEmpty()) {
            System.out.println("No hay registros en la tabla para verificar acciones.");
            return false;
        }

        for (WebElement fila : filas) {
            boolean tieneEditar = !fila.findElements(By.xpath(".//i[contains(@class,'bi-pencil-fill')]")).isEmpty();
            boolean tieneEliminar = !fila.findElements(By.xpath(".//i[contains(@class,'bi-trash')]")).isEmpty();

            if (!tieneEditar || !tieneEliminar) {
                System.out.println("Fila sin ambas acciones");
                return false;
            }
        }

        System.out.println("Todas las filas contienen las acciones: Editar y Eliminar");
        return true;

    }


    public void ingresarNombreUsuario(String userName) {
        campoName.sendKeys(userName);
        this.UserName = userName;
    }

    public void ingresarNombreEmpleado(String employeeName) {
        campoEmpleado.clear();
        campoEmpleado.sendKeys(employeeName);
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']//span")));
        List<WebElement> opciones = getDriver().findElements(By.xpath("//div[@role='listbox']//span"));
        for (WebElement opcion : opciones) {
            if (opcion.getText().equalsIgnoreCase(employeeName)) {
                opcion.click();
                return;
            }
        }

    }

    public void seleccionarStatus(String status) {
        selectStatus.waitUntilClickable();
        selectStatus.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option' and normalize-space()='" + status + "']")));
        statusOption.click();
    }

    public void validarMensajeError(String msjError) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id=\"oxd-toaster_1\"]//div)[1]")));
        if (popupError.isVisible()) {
            assertEquals(msjError, popupError.getText());
        } else {
            Assert.fail("No arroja ningún mensaje de error");
        }
    }

    public void pulsarBotónAdd() {
        btnAdd.waitUntilClickable();
        btnAdd.click();
    }

    public void validarPantallaAgregarUsuario() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Add User']")));
        WebElement titulo = getDriver().findElement(By.xpath("(//h6)[2]"));
        assertEquals("Add User", titulo.getText());
    }


    public void ingresarPassword(String newPass) {
        campoPassw.sendKeys(newPass);
    }

    public void ingresarConfirmaciónPassword(String confPass) {
        campoConfiPassw.sendKeys(confPass);
    }

    public void pulsarBotónSave() {
        btnSave.waitUntilClickable();
        btnSave.click();
    }

    public void mostrarMensajeÉxito(String mensajeExito) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text\"]")));
        if (popupHappy.isVisible()) {
            assertEquals(mensajeExito, popupHappy.getText());
        } else {
            Assert.fail("No arroja ningún mensaje de error");
        }
    }

    public void validarPantallaGestiónUsuario() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"oxd-form-row\"]")));
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module') and text()='Admin']")));
        WebElement apartado = getDriver().findElement(By.tagName("h5"));
        assertEquals("System Users", apartado.getText());
    }

    public void buscarNuevoUsuario() {
        campoName.waitUntilClickable();
        campoName.sendKeys(UserName);
        btnSearch.click();
    }


    public boolean validarFiltradoDeNuevoUsuario() {
        List<WebElement> filas = getDriver().findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));
        if (filas.isEmpty()) {
            System.out.println("No se encontraron registros tras filtrar.");
            return false;
        }

        for (WebElement fila : filas) {
            String user = fila.findElement(By.xpath(".//div[@role='cell'][2]")).getText().trim();
            if (!user.equalsIgnoreCase(UserName)) {
                System.out.println("Se encontró un usuario con UserName diferente: " + UserName);
                return false;
            }
        }

        System.out.println("El usuario mostrado tienen el UserName: " + UserName);
        return true;
    }

    public void mostrarLaObligatoriedadDeLosCampos(String msjObligatoriedad) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")));

        List<WebElement> msgsObligatorio = getDriver().findElements(By.xpath("//span[contains(@class,'oxd-input-field-error-message oxd-input-group__message') and normalize-space()='Required']"));
        if (msgsObligatorio.size() == 5) {
            for (WebElement msg : msgsObligatorio) {
                String actual = msg.getText().trim();
                assertEquals(msjObligatoriedad, actual);
            }
        } else {
            Assert.fail("Se esperaban 5 mensajes de obligatoriedad pero se encontraron: " + msgsObligatorio.size());
        }
    }


    public String validarMensajeDeRestricciones() {
        return getDriver().findElement(By.xpath("//span[contains(@class,'oxd-input-field-error-message')]")).getText();
    }
}
