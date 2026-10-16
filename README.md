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

**GastoFuncional.java:** representa cada gasto mediante los atributos `concepto`, `monto` y `categoria`. Los atributos se declararon privados y finales (`private final`) para garantizar que sus valores no puedan modificarse después de crear el objeto. También se implementaron validaciones y se utilizó `BigDecimal` para representar los valores monetarios.

**OperacionesFuncionales.java:** contiene las funciones encargadas de registrar gastos sin modificar la lista original, consultar registros, calcular el total acumulado, encontrar el mayor gasto y realizar filtros y búsquedas.

**MainFuncional.java:** contiene el menú interactivo que permite utilizar las seis funcionalidades solicitadas desde la consola.

### Características del paradigma aplicadas

- **Inmutabilidad:** los objetos `GastoFuncional` mantienen sus datos sin modificaciones después de crearse. Al registrar un gasto se devuelve una nueva lista, conservando la original.
- **Funciones puras:** las operaciones de cálculo y filtrado reciben datos, producen resultados y no modifican la colección recibida.
- **Funciones de orden superior:** el método `filtrar()` recibe un `Predicate<GastoFuncional>`, que representa una condición utilizada para seleccionar registros.
- **Expresiones lambda:** se utilizan para indicar cómo extraer montos, comparar gastos y aplicar condiciones.
- **API