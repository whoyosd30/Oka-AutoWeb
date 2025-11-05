package org.Oka.Login.step;

import net.thucydides.core.steps.ScenarioSteps;
import org.Oka.Login.page.MyPage;
import static org.junit.Assert.assertEquals;

public class MyStep extends ScenarioSteps {

    private MyPage myPage;

    @net.thucydides.core.annotations.Step
    public void queElUsuarioIngresaALaPlataformaOrangeHRM() {
        myPage.open();
    }

    @net.thucydides.core.annotations.Step
    public void ingresaCredencialesVálidas(String usuario, String contraseña) {
        myPage.ingresarCredencialesVálidas(usuario,contraseña);
    }

    @net.thucydides.core.annotations.Step
    public void pulsaElBotónLogin() {
        myPage.pulsarBotónLogin();
    }

    @net.thucydides.core.annotations.Step
    public void seAccedeAlDashboardCorrectamente() {
        myPage.validarAccesoAlDashboard();
    }

    @net.thucydides.core.annotations.Step
    public void ingresaCredencialesInválidas(String usuarioIncorrecto, String contraseñaIncorrecta) {
        myPage.ingresarCredencialesInválidas(usuarioIncorrecto, contraseñaIncorrecta);
    }

    @net.thucydides.core.annotations.Step
    public void seMuestraElMensajeDeError(String mensaje) {
        myPage.validarMensajeDeError(mensaje);
    }
}
