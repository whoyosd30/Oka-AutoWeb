#language: es
@User
Característica: Gestión de usuarios
  Como administrador de la plataforma
  Quiero acceder al sistema
  Para gestionar los usuarios de la plataforma

  Antecedentes:
    Dado que el usuario accede a la plataforma
    Cuando se ingresa el usuario "Admin" y contraseña "admin123"
    Y se accede al Dashboard
    Cuando selecciona la opción Admin
    Entonces valida que se encuentra en la pantalla Gestión de usuarios

  @FiltrarUser
  Esquema del escenario: Filtrar usuario por rol y validar acciones
    Dado que selecciona el rol del usuario "<UserRole>"
    Cuando pulsa el botón Search
    Entonces se muestra los usuarios Admin
    Y valido que se muestren las acciones Editar y Eliminar

    Ejemplos:
      | UserRole |
      | Admin    |

  @FiltrarUserInválido
  Esquema del escenario: Filtrar usuario inválido
    Dado que se agrega el campo nombre de usuario "<UserName>"
    Cuando selecciona el rol del usuario "<UserRole>"
    Y agrega el nombre de empleado "<EmployeeName>"
    Y selecciona el estatus "<Status>"
    Cuando pulsa el botón Search
    Entonces muestra el mensaje de error "<msjError>"

    Ejemplos:
      | UserName | UserRole | EmployeeName  | Status  | msjError         |
      | Prueba   | Admin    | Ranga Akunuri | Enabled | No Records Found |

  @AgregarUser
  Esquema del escenario: Agregar nuevo usuario
    Dado que pulsa sobre el botón Add
    Cuando se encuentra en la pantalla agregar usuario
    Y selecciona el rol del nuevo usuario "<UserRole>"
    Y agrega el nombre de empleado del nuevo usuario "<EmployeeName>"
    Y selecciona el estatus del nuevo usuario "<Status>"
    Y ingresa el nuevo nombre del usuario "<UserName>"
    Y ingresa el nuevo password del usuario "<Password>"
    Y ingresa la confirmación del password "<ConfPassword>"
    Cuando pulsa el botón Save
    Entonces muestra el mensaje de éxito "<mensajeExito>"
    Y envia a la pantalla de gestión de usuarios
    Cuando filtro el usuario registrado
    Entonces se muestra el nuevo usuario en la tabla de usuarios

    Ejemplos:
      | UserRole | EmployeeName | Status  | UserName     | Password        | ConfPassword    | mensajeExito       |
      | Admin    | John Doe     | Enabled | HappyTesting | HappyTesting123 | HappyTesting123 | Successfully Saved |

  @ValidarObligatoriedad
  Esquema del escenario: Validar campos obligatorios del formulario Agregar usuario
    Dado que pulsa sobre el botón Add
    Cuando se encuentra en la pantalla agregar usuario
    Y pulsa el botón Save
    Entonces se muestran mensajes de error "<msjObligatoriedad>" en todos los campos obligatorios
    Ejemplos:
      | msjObligatoriedad |
      | Required          |


  @ValidaciónAgregarUser
  Esquema del escenario: Validar las restricciones en los campos del formulario Agregar usuario
    Dado que pulsa sobre el botón Add
    Cuando se encuentra en la pantalla agregar usuario
    Y selecciona el rol del nuevo usuario "<UserRole>"
    Y agrega el nombre de empleado del nuevo usuario "<EmployeeName>"
    Y selecciona el estatus del nuevo usuario "<Status>"
    Y ingresa el nuevo nombre del usuario "<UserName>"
    Y ingresa el nuevo password del usuario "<Password>"
    Y ingresa la confirmación del password "<ConfPassword>"
    Y pulsa el botón Save
    Entonces se muestra el mensaje de error en cada campo del formulario "<mensajeError>"

    Ejemplos:
      | UserRole | EmployeeName  | Status  | UserName | Password        | ConfPassword    | mensajeError                                |
      | Admin    | Ranga Akunuri | Enabled | JP       | Happy1234       | Happy1234       | Should be at least 5 characters             |
      | Admin    | Ranga Akunuri | Enabled | QAUser   | passTestQA      | passTestQA      | Your password must contain minimum 1 number |
      | Admin    | Ranga Akunuri | Enabled | QAUser   | QATest123       | QATest12        | Passwords do not match                      |
      | Admin    | Ranga Akunuri | Enabled | Admin    | HappyTesting123 | HappyTesting123 | Already exists                              |
