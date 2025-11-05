package org.Oka.User.stepdefinition;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.thucydides.core.annotations.Steps;
import org.Oka.User.step.MyStep;

public class MyStepdefinition {
    @Steps
private MyStep myStep;

    @Dado("que el usuario accede a la plataforma")
    public void queElUsuarioAccedeALaPlataforma() {
        myStep.queElUsuarioAccedeALaPlataforma();
    }

    @Cuando("se ingresa el usuario {string} y contraseña {string}")
    public void seIngresaElUsuarioYContraseña(String usuario, String contraseña) {
        myStep.seIngresaElUsuarioYContraseña(usuario, contraseña);
    }

    @Y("se accede al Dashboard")
    public void seAccedeAlDashboard() {
        myStep.seAccedeAlDashboard();
    }

    @Cuando("selecciona la opción Admin")
    public void seleccionaLaOpciónAdmin() {
        myStep.seleccionaLaOpciónAdmin();
    }

    @Entonces("valida que se encuentra en la pantalla Gestión de usuarios")
    public void validaQueSeEncuentraEnLaPantallaGestiónDeUsuarios() {
        myStep.validaQueSeEncuentraEnLaPantallaGestiónDeUsuarios();
    }

    @Dado("que selecciona el rol del usuario {string}")
    public void queSeleccionaElRolDelUsuario(String role) {
        myStep.queSeleccionaElRolDelUsuario(role);
    }

    @Cuando("pulsa el botón Search")
    public void pulsaElBotónSearch() {
        myStep.pulsaElBotónSearch();
    }

    @Entonces("se muestra los usuarios Admin")
    public void seMuestraLosUsuariosAdmin() {
        myStep.seMuestraLosUsuariosAdmin();
    }

    @Y("valido que se muestren las acciones Editar y Eliminar")
    public void validoQueSeMuestrenLasAccionesEditarYEliminar() {
        myStep.validoQueSeMuestrenLasAccionesEditarYEliminar();
    }

    @Dado("que se agrega el campo nombre de usuario {string}")
    public void queSeAgregaElCampoNombreDeUsuario(String userName) {
        myStep.queSeAgregaElCampoNombreDeUsuario(userName);
    }

    @Cuando("selecciona el rol del usuario {string}")
    public void seleccionaElRolDelUsuario(String userRole) {
        myStep.queSeleccionaElRolDelUsuario(userRole);
    }

    @Y("agrega el nombre de empleado {string}")
    public void agregaElNombreDeEmpleado(String employeeName) {
        myStep.agregaElNombreDeEmpleado(employeeName);
    }

    @Y("selecciona el estatus {string}")
    public void seleccionaElEstatus(String status) {
        myStep.seleccionaElEstatus(status);
    }

    @Entonces("muestra el mensaje de error {string}")
    public void muestraElMensajeDeError(String msjError) {
        myStep.muestraElMensajeDeError(msjError);
    }

    @Dado("que pulsa sobre el botón Add")
    public void quePulsaSobreElBotónAdd() {
        myStep.quePulsaSobreElBotónAdd();
    }

    @Cuando("se encuentra en la pantalla agregar usuario")
    public void seEncuentraEnLaPantallaAgregarUsuario() {
        myStep.seEncuentraEnLaPantallaAgregarUsuario();
    }

    @Y("selecciona el rol del nuevo usuario {string}")
    public void seleccionaElRolDelNuevoUsuario(String role) {
        myStep.seleccionaElRolDelNuevoUsuario(role);
    }

    @Y("agrega el nombre de empleado del nuevo usuario {string}")
    public void agregaElNombreDeEmpleadoDelNuevoUsuario(String employeeName) {
        myStep.agregaElNombreDeEmpleadoDelNuevoUsuario(employeeName);
    }

    @Y("selecciona el estatus del nuevo usuario {string}")
    public void seleccionaElEstatusDelNuevoUsuario(String status) {
        myStep.seleccionaElEstatusDelNuevoUsuario(status);
    }

    @Y("ingresa el nuevo nombre del usuario {string}")
    public void ingresaElNuevoNombreDelUsuario(String userName) {
        myStep.ingresaElNuevoNombreDelUsuario(userName);
    }

    @Y("ingresa el nuevo password del usuario {string}")
    public void ingresaElNuevoPasswordDelUsuario(String newPass) {
        myStep.ingresaElNuevoPasswordDelUsuario(newPass);
    }

    @Y("ingresa la confirmación del password {string}")
    public void ingresaLaConfirmaciónDelPassword(String confPass) {
        myStep.ingresaLaConfirmaciónDelPassword(confPass);
    }

    @Cuando("pulsa el botón Save")
    public void pulsaElBotónSave() {
        myStep.pulsaElBotónSave();
    }

    @Entonces("muestra el mensaje de éxito {string}")
    public void muestraElMensajeDeÉxito(String mensajeExito) {
        myStep.muestraElMensajeDeÉxito(mensajeExito);
    }

    @Y("envia a la pantalla de gestión de usuarios")
    public void enviaALaPantallaDeGestiónDeUsuarios() {
        myStep.enviaALaPantallaDeGestiónDeUsuarios();
    }

    @Cuando("filtro el usuario registrado")
    public void filtroElUsuarioRegistrado() {
        myStep.filtroElUsuarioRegistrado();
    }

    @Entonces("se muestra el nuevo usuario en la tabla de usuarios")
    public void seMuestraElNuevoUsuarioEnLaTablaDeUsuarios() {
        myStep.seMuestraElNuevoUsuarioEnLaTablaDeUsuarios();
    }

    @Entonces("se muestran mensajes de error {string} en todos los campos obligatorios")
    public void seMuestranMensajesDeErrorEnTodosLosCamposObligatorios(String msjObligatoriedad) {
        myStep.seMuestranMensajesDeErrorEnTodosLosCamposObligatorios(msjObligatoriedad);

    }

    @Entonces("se muestra el mensaje de error en cada campo del formulario {string}")
    public void seMuestraElMensajeDeErrorEnCadaCampoDelFormulario(String mensajeError) {
        myStep.seMuestraElMensajeDeErrorEnCadaCampoDelFormulario(mensajeError);
    }


}
