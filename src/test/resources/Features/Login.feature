#language: es
@login
Característica: Validación del Login en OrangeHRM
  Como usuario de la plataforma
  Quiero validar los diferentes tipos de acceso
  Para asegurar que el sistema responda correctamente a cada caso

  @loginExitoso
  Esquema del escenario: Validar login exitoso
    Dado que el usuario ingresa a la plataforma OrangeHRM
    Cuando ingresa credenciales válidas "<usuario>","<contraseña>"
    Y pulsa el botón Login
    Entonces se accede al Dashboard correctamente

    Ejemplos:
      | usuario | contraseña |
      | Admin   | admin123   |

  @loginFallido
  Esquema del escenario: Validar login fallido
    Dado que el usuario ingresa a la plataforma OrangeHRM
    Cuando ingresa credenciales inválidas "<usuario>","<contraseña>"
    Y pulsa el botón Login
    Entonces se muestra el mensaje de error "<Msjerror>"

    Ejemplos:
      | usuario       | contraseña | Msjerror            |
      | Administrador | admin123   | Invalid credentials |
      | Admin         | admin12356 | Invalid credentials |
      | Administrador | admin12356 | Invalid credentials |
      |               |            | Required            |

