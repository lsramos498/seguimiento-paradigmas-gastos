# Sistema de Control de Gastos Personales

Proyecto académico desarrollado en Java para comparar cinco paradigmas de programación mediante un mismo problema: la gestión de gastos personales.

## Funcionalidades requeridas

1. Registrar gastos con concepto, monto y categoría.
2. Mostrar los gastos registrados.
3. Calcular el total acumulado.
4. Identificar el gasto de mayor valor.
5. Filtrar gastos superiores a un monto indicado.
6. Buscar gastos por concepto o palabra clave.

## Paradigmas de programación

- Estructurado
- Orientado a objetos (POO)
- Orientado a eventos mediante una interfaz gráfica
- Declarativo mediante consultas SQL o expresiones declarativas
- Funcional mediante funciones puras y transformaciones de colecciones

## Estructura del proyecto

- `docs/`: documentación general y específica de cada paradigma.
- `src/`: código fuente de las cinco implementaciones.

## Flujo de trabajo con Git y GitHub

- `main`: versión estable para la entrega.
- `develop`: integración de los avances.
- `feature/paradigma-estructurado`
- `feature/paradigma-poo`
- `feature/paradigma-eventos`
- `feature/paradigma-declarativo`
- `feature/paradigma-funcional`

Los cambios se integrarán mediante Pull Requests revisados y aprobados por otra integrante del equipo.

## Equipo de trabajo

Proyecto colaborativo académico. Cada integrante debe contribuir mediante commits propios, respetando las ramas y el proceso de revisión.

## Estado

Repositorio inicial preparado. Las implementaciones, pruebas y evidencias se incorporarán durante el desarrollo.

## Paradigma funcional

### Descripción

El paradigma funcional es un enfoque de programación que permite procesar información mediante funciones y transformaciones de datos, procurando evitar modificaciones innecesarias del estado.

Para desarrollar el Sistema de Control de Gastos Personales se utilizó Java y su API Stream, aplicando inmutabilidad, funciones puras, funciones de orden superior y expresiones lambda.

### Archivos implementados

**GastoFuncional.java:** representa cada gasto mediante los atributos `concepto`, `monto` y `categoria`. Los atributos se declararon privados y finales (`private final`) para evitar su reasignación después de crear el objeto. También se implementaron validaciones y se utilizó `BigDecimal` para representar los valores monetarios.

**OperacionesFuncionales.java:** contiene las funciones encargadas de registrar gastos sin modificar la lista original, consultar registros, calcular el total acumulado, encontrar el mayor gasto y realizar filtros y búsquedas.

**MainFuncional.java:** contiene el menú interactivo que permite utilizar las seis funcionalidades solicitadas desde la consola.

### Características del paradigma aplicadas

- **Inmutabilidad:** los objetos `GastoFuncional` mantienen sus datos sin modificaciones después de crearse. Al registrar un gasto se devuelve una nueva lista, conservando la original.
- **Funciones puras:** las operaciones de cálculo y filtrado reciben datos, producen resultados y no modifican la colección recibida.
- **Funciones de orden superior:** el método `filtrar()` recibe un `Predicate<GastoFuncional>`, que representa una condición utilizada para seleccionar registros.
- **Expresiones lambda:** se utilizan para indicar cómo extraer montos, comparar gastos y aplicar condiciones.
- **API Stream:** permite procesar colecciones mediante operaciones de filtrado, transformación y reducción para obtener los resultados.

## Paradigma orientado a objetos

### Descripción

La programación orientada a objetos (POO) es un paradigma que permite organizar un programa mediante clases y objetos. Cada objeto contiene información y puede realizar operaciones relacionadas con sus responsabilidades.

Para el Sistema de Control de Gastos Personales se implementó este paradigma utilizando Java, mediante tres clases que trabajan conjuntamente.

### Clases implementadas

**Gasto.java:** representa un gasto individual mediante los atributos privados `concepto`, `monto` y `categoria`. Utiliza un constructor para inicializar los datos, métodos getters para consultarlos y validaciones para evitar registros incorrectos. El dinero se representa mediante `BigDecimal`.

**GestorGastos.java:** administra una colección de objetos `Gasto` mediante un `ArrayList`. Contiene los métodos necesarios para registrar, listar, sumar, obtener el mayor gasto, filtrar y buscar registros.

**MainPOO.java:** contiene el método `main` y un menú interactivo que permite al usuario seleccionar las diferentes operaciones desde la consola.

### Características del paradigma aplicadas

- **Encapsulamiento:** los atributos de la clase `Gasto` son privados y se consultan mediante métodos getters.
- **Objetos:** cada gasto registrado es una instancia de la clase `Gasto`.
- **Métodos de instancia:** `GestorGastos` contiene métodos que operan sobre su colección de gastos.
- **Composición:** `GestorGastos` contiene y administra objetos de tipo `Gasto`.
- **Validación de datos:** el programa rechaza conceptos vacíos, montos iguales o inferiores a cero y categorías no permitidas.

### Funcionalidades implementadas

1. Registrar gastos con concepto, monto y categoría.
2. Mostrar el listado completo de gastos registrados.
3. Calcular el gasto total acumulado.
4. Identificar el gasto de mayor valor.
5. Filtrar los gastos superiores a un monto específico.
6. Buscar gastos por concepto mediante coincidencias parciales, ignorando mayúsculas, minúsculas y acentos.

### Ejecución

Desde la raíz del repositorio, compilar mediante:

```powershell
javac -encoding UTF-8 -d out src/poo/Gasto.java src/poo/GestorGastos.java src/poo/MainPOO.java
```

Ejecutar mediante:

```powershell
java -cp out poo.MainPOO
```

### Resultados de las pruebas

Se realizaron pruebas utilizando los ocho gastos establecidos para el equipo.

| Prueba | Resultado |
|---|---|
| Listado completo | 8 gastos registrados |
| Total acumulado | $410.000 |
| Gasto de mayor valor | Internet hogar: $95.000 |
| Gastos mayores a $50.000 | Mercado semanal, Internet hogar y Factura de energía |
| Búsqueda por "mercado" | Mercado semanal y Mercado de frutas |
| Monto igual a cero | Registro rechazado |
| Concepto vacío | Registro rechazado |
| Categoría no permitida | Registro rechazado |
| Búsqueda sin coincidencias | Informa que no se encontraron gastos |
| Colección vacía | Total de $0 y mensajes cuando no hay resultados |

### Conclusión

La implementación orientada a objetos permitió distribuir las responsabilidades del programa entre diferentes clases, aplicar el encapsulamiento y demostrar la colaboración entre objetos. Esta organización facilita la comprensión y el mantenimiento del código.