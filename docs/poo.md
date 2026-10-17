# Paradigma orientado a objetos (POO)

## Descripción

Se desarrolló un Sistema de Control de Gastos Personales utilizando programación orientada a objetos en Java.

La implementación permite registrar gastos, consultar los registros, calcular el total acumulado, identificar el gasto mayor, filtrar por monto y buscar gastos por concepto.

## Clases implementadas

**Gasto.java:** representa cada gasto mediante los atributos privados `concepto`, `monto` y `categoria`. Utiliza un constructor, métodos getters y validaciones para garantizar que los datos sean correctos.

**GestorGastos.java:** administra una colección `ArrayList<Gasto>` y contiene los métodos para registrar, listar, sumar, filtrar y buscar gastos.

**MainPOO.java:** contiene el menú interactivo que permite al usuario utilizar las seis funcionalidades desde la consola.

## Conceptos de POO aplicados

- **Encapsulamiento:** los atributos de los gastos son privados y se consultan mediante métodos getters.
- **Objetos:** cada gasto registrado es una instancia de la clase `Gasto`.
- **Composición:** `GestorGastos` contiene y administra una colección de objetos `Gasto`.
- **Métodos de instancia:** las operaciones se ejecutan a través de un objeto `GestorGastos`.

## Funcionalidades

1. Registrar gastos con concepto, monto y categoría.
2. Mostrar todos los gastos registrados.
3. Calcular el total acumulado.
4. Identificar el gasto de mayor valor.
5. Filtrar gastos estrictamente mayores a un monto indicado.
6. Buscar por concepto mediante coincidencias parciales, ignorando mayúsculas y minúsculas.

## Categorías disponibles

Alimentación, Transporte, Servicios, Entretenimiento y Otros.

## Validaciones

El programa rechaza conceptos vacíos, montos no numéricos, montos iguales o inferiores a cero y categorías no permitidas. También impide realizar búsquedas vacías.

Los montos se presentan con el signo `$` y dos decimales.

## Ejecución

Desde la raíz del repositorio, compilar:

```powershell
javac -encoding UTF-8 -d out src/poo/Gasto.java src/poo/GestorGastos.java src/poo/MainPOO.java
```

Ejecutar:

```powershell
java -cp out poo.MainPOO
```

## Datos de prueba

| Concepto | Monto | Categoría |
|---|---:|---|
| Almuerzo | $12.50 | Alimentación |
| Bus | $3.00 | Transporte |
| Internet | $45.00 | Servicios |
| Cine | $18.50 | Entretenimiento |
| Mercado | $80.00 | Alimentación |
| Gasolina | $50.00 | Transporte |
| Recibo de luz | $65.50 | Servicios |

## Resultados de las pruebas

| Prueba | Resultado |
|---|---|
| Listado completo | 7 gastos |
| Total acumulado | $274.50 |
| Gasto mayor | Mercado, $80.00 |
| Gastos mayores a $50.00 | Mercado y Recibo de luz |
| Buscar `luz` | Recibo de luz |
| Buscar `INTERNET` | Internet |
| Buscar `xyz` | Sin resultados |
| Búsqueda vacía | Rechazada |
| Categoría Otros | Aceptada |
| Monto no numérico | Rechazado |

## Conclusión

La programación orientada a objetos permitió organizar el sistema en clases con responsabilidades definidas. El encapsulamiento y la composición facilitaron la administración de los gastos, mientras que las validaciones contribuyeron a mantener la integridad de los datos.