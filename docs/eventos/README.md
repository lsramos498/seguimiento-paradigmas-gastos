
# Programación orientada a eventos

## 1. Descripción

Este módulo implementa un sistema de control de gastos personales utilizando el paradigma de programación orientada a eventos en Java.

La aplicación cuenta con una interfaz gráfica desarrollada con Java Swing que permite registrar gastos y realizar operaciones mediante las acciones del usuario sobre los botones.

## 2. Objetivo

Aplicar el paradigma orientado a eventos mediante una interfaz gráfica que responda a las acciones del usuario, permita gestionar gastos personales y procese la información registrada.

## 3. Tecnologías utilizadas

- Lenguaje de programación: Java.
- Interfaz gráfica: Java Swing.
- Entorno de desarrollo: IntelliJ IDEA.
- Control de versiones: Git y GitHub.

## 4. Archivo principal

`src/eventos/VentanaGastos.java`

La clase `VentanaGastos` extiende `JFrame` y contiene la interfaz gráfica, la lista de gastos y los métodos que ejecutan las operaciones solicitadas.

Cada gasto almacena:
- Concepto.
- Monto.
- Categoría.

Los gastos se almacenan temporalmente en una lista durante la ejecución del programa.

## 5. Eventos implementados

La aplicación utiliza `addActionListener` para asociar una acción a cada botón. Cuando el usuario hace clic, se ejecuta el método correspondiente.

| Botón | Método | Función |
|---|---|---|
| Registrar Gasto | `registrarGasto()` | Valida y registra un gasto. |
| Mostrar Listado | `mostrarListado()` | Muestra los gastos registrados. |
| Calcular Total | `calcularTotal()` | Suma los montos de todos los gastos. |
| Gasto de Mayor Valor | `mostrarMayor()` | Identifica el gasto de mayor monto. |
| Filtrar por Monto Mínimo | `filtrarPorMonto()` | Muestra los gastos mayores al monto indicado. |
| Buscar por Concepto | `buscarPorConcepto()` | Busca gastos por coincidencia en el concepto. |

## 6. Manejo de eventos

El programa responde a las acciones del usuario mediante listeners asociados a los botones.

Por ejemplo:

`btnRegistrar.addActionListener(e -> registrarGasto());`

Cuando el usuario pulsa el botón Registrar Gasto, se ejecuta el método `registrarGasto()`.

La expresión lambda `e -> registrarGasto()` define la acción que se ejecutará cuando ocurra el evento de clic.

## 7. Validaciones

La aplicación incluye las siguientes validaciones:

- El concepto no puede estar vacío.
- El monto debe ser numérico y mayor que cero.
- Se informa cuando no hay gastos registrados.
- Se controlan los errores al ingresar montos no numéricos.
- La búsqueda ignora diferencias entre mayúsculas, minúsculas y acentos.

## 8. Pruebas funcionales

Se realizaron pruebas manuales con ocho gastos de ejemplo.

| Prueba | Resultado esperado | Resultado observado |
|---|---|---|
| Registrar gastos | Registrar los ocho gastos | Correcto |
| Calcular total | $410.000 | Correcto |
| Gasto de mayor valor | Internet hogar, $95.000 | Correcto |
| Filtrar por monto mínimo de $50.000 | Tres gastos mayores a $50.000 | Correcto |
| Buscar el concepto "mercado" | Dos coincidencias | Correcto |
| Mostrar listado | Mostrar los ocho gastos | Correcto |

## 9. Datos de prueba

| Concepto | Monto | Categoría |
|---|---:|---|
| Mercado semanal | $80.000 | Alimentación |
| Bus a la universidad | $12.500 | Transporte |
| Internet hogar | $95.000 | Servicios |
| Cine | $35.000 | Entretenimiento |
| Almuerzo universitario | $22.000 | Alimentación |
| Taxi nocturno | $48.000 | Transporte |
| Factura de energía | $67.500 | Servicios |
| Mercado de frutas | $50.000 | Alimentación |
| **Total** | **$410.000** | |

## 10. Ejecución

El archivo principal es `src/eventos/VentanaGastos.java`.

Desde la raíz del proyecto, se puede compilar y ejecutar con:

```powershell
javac -d out src/eventos/VentanaGastos.java
java -cp out eventos.VentanaGastos
```

También puede ejecutarse desde IntelliJ IDEA mediante el método `main`.

## 11. Limitaciones

- Los gastos se almacenan en memoria y se pierden al cerrar la aplicación.
- No se implementó persistencia en una base de datos.
- Las pruebas documentadas corresponden a los datos utilizados durante la validación manual.

## 12. Conclusión

La implementación permite observar el funcionamiento del paradigma orientado a eventos mediante una interfaz gráfica. Las acciones realizadas por el usuario activan métodos específicos que registran, consultan, filtran y procesan los gastos personales.
