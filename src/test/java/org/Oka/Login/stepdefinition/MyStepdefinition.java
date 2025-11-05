package org.Oka.Login.stepdefinition;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.thucydides.core.annotations.Steps;
import org.Oka.Login.step.MyStep;

public class MyStepdefinition {
    @Steps
    private MyStep myStep;

    @Dado("que el usuario ingresa a la plataforma OrangeHRM")
    public void queElUsuarioIngresaALaPlataformaOrangeHRM() {
        myStep.queElUsuarioIngresaALaPlataformaOrangeHRM();
    }

    @Cuando("ingresa credenciales válidas {string},{string}")
    public void ingresaCredencialesVálidas(String usuario, String contraseña) {
        myStep.ingresaCredencialesVálidas(usuario,contraseña);
    }

    @Y("pulsa el botón Login")
    public void pulsaElBotónLogin() {
        myStep.pulsaElBotónLogin();
    }

    @Entonces("se accede al Dashboard correctamente")
    public void seAccedeAlDashboardCorrectamente() {
        myStep.seAccedeAlDashboardCorrectamente();
    }

    @Cuando("ingresa credenciales inválidas {string},{string}")
    public void ingresaCredencialesInválidas(String usuarioIncorrecto, String contraseñaIncorrecta) {
        myStep.ingresaCredencialesInválidas(usuarioIncorrecto, contraseñaIncorrecta);

    }

    @Entonces("se muestra el mensaje de error {string}")
    public void seMuestraElMensajeDeError(String mensaje) {
        myStep.seMuestraElMensajeDeError(mensaje);
    }

}
