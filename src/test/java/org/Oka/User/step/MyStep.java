package org.Oka.User.step;

import net.thucydides.core.steps.ScenarioSteps;
import org.Oka.User.page.MyPage;

import static org.junit.Assert.assertTrue;

public class MyStep extends ScenarioSteps {

    private MyPage myPage;

    @net.thucydides.core.annotations.Step
    public void queElUsuarioAccedeALaPlataforma() {
        myPage.open();
    }

    @net.thucydides.core.annotations.Step
    public void seIngresaElUsuarioYContraseña(String usuario, String contraseña) {
        myPage.autenticarse(usuario, contraseña);
    }

    @net.thucydides.core.annotations.Step
    public void seAccedeAlDashboard() {
        myPage.validarAccesoAlDashboard();
    }

    @net.thucydides.core.annotations.Step
    public void seleccionaLaOpciónAdmin() {
        myPage.seleccionOpciónAdmin();
    }

    @net.thucydides.core.annotations.Step
    public void validaQueSeEncuentraEnLaPantallaGestiónDeUsuarios() {
        myPage.validarAccesoALaGestiónDeUsuarios();
    }

    @net.thucydides.core.annotations.Step
    public void queSeleccionaElRolDelUsuario(String role) {
        myPage.seleccionarRolDeUsuario(role);
    }

    @net.thucydides.core.annotations.Step
    public void pulsaElBotónSearch() {
        myPage.pulsarSearch();
    }

    @net.thucydides.core.annotations.Step
    public void seMuestraLosUsuariosAdmin() {
        assertTrue("No se muestran usuarios con rol ", myPage.validarFiltrado());
    }

    @net.thucydides.core.annotations.Step
    public void validoQueSeMuestrenLasAccionesEditarYEliminar() {
        assertTrue("Las acciones Editar y Eliminar no están visibles", myPage.accionesVisibles());
    }

    @net.thucydides.core.annotations.Step
    public void queSeAgregaElCampoNombreDeUsuario(String userName) {
        myPage.ingresarNombreUsuario(userName);
    }

    @net.thucydides.core.annotations.Step
    public void agregaElNombreDeEmpleado(String employeeName) {
        myPage.ingresarNombreEmpleado(employeeName);
    }

    @net.thucydides.core.annotations.Step
    public void seleccionaElEstatus(String status) {
        myPage.seleccionarStatus(status);
    }

    @net.thucydides.core.annotations.Step
    public void muestraElMensajeDeError(String msjError) {
        myPage.validarMensajeError(msjError);
    }

    @net.thucydides.core.annotations.Step
    public void quePulsaSobreElBotónAdd() {
        myPage.pulsarBotónAdd();
    }

    @net.thucydides.core.annotations.Step
    public void seEncuentraEnLaPantallaAgregarUsuario() {
        myPage.validarPantallaAgregarUsuario();
    }

    @net.thucydides.core.annotations.Step
    public void seleccionaElRolDelNuevoUsuario(String role) {
        myPage.seleccionarRolDeUsuario(role);
    }

    @net.thucydides.core.annotations.Step
    public void agregaElNombreDeEmpleadoDelNuevoUsuario(String employeeName) {
        myPage.ingresarNombreEmpleado(employeeName);
    }

    @net.thucydides.core.annotations.Step
    public void seleccionaElEstatusDelNuevoUsuario(String status) {
        myPage.seleccionarStatus(status);
    }

    @net.thucydides.core.annotations.Step
    public void ingresaElNuevoNombreDelUsuario(String userName) {
        myPage.ingresarNombreUsuario(userName);
    }

    @net.thucydides.core.annotations.Step
    public void ingresaElNuevoPasswordDelUsuario(String newPass) {
        myPage.ingresarPassword(newPass);
    }

    @net.thucydides.core.annotations.Step
    public void ingresaLaConfirmaciónDelPassword(String confPass) {
        myPage.ingresarConfirmaciónPassword(confPass);
    }

    @net.thucydides.core.annotations.Step
    public void pulsaElBotónSave() {
        myPage.pulsarBotónSave();
    }

    @net.thucydides.core.annotations.Step
    public void muestraElMensajeDeÉxito(String mensajeExito) {
        myPage.mostrarMensajeÉxito(mensajeExito);
    }

    @net.thucydides.core.annotations.Step
    public void enviaALaPantallaDeGestiónDeUsuarios() {
        myPage.validarPantallaGestiónUsuario();
    }

    @net.thucydides.core.annotations.Step
    public void filtroElUsuarioRegistrado() {
        myPage.buscarNuevoUsuario();
    }

    @net.thucydides.core.annotations.Step
    public void seMuestraElNuevoUsuarioEnLaTablaDeUsuarios() {
        assertTrue("No se muestran usuarios nuevo ", myPage.validarFiltradoDeNuevoUsuario());
    }

    @net.thucydides.core.annotations.Step
    public void seMuestranMensajesDeErrorEnTodosLosCamposObligatorios(String msjObligatoriedad) {
        myPage.mostrarLaObligatoriedadDeLosCampos(msjObligatoriedad);
    }

    @net.thucydides.core.annotations.Step
    public void seMuestraElMensajeDeErrorEnCadaCampoDelFormulario(String mensajeError) {
        assertTrue(myPage.validarMensajeDeRestricciones().contains(mensajeError));
    }
}
