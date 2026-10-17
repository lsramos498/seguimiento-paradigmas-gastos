# Sistema de Control de Gastos Personales

Proyecto académico desarrollado en Java para comparar cuatro paradigmas de programación mediante la gestión de gastos personales.

## Paradigmas desarrollados

- Estructurado.
- Orientado a objetos (POO).
- Orientado a eventos.
- Funcional.

La versión seleccionada para `main` es la implementación estructurada. Las demás versiones se encuentran en sus respectivas ramas y en la rama de integración `develop`.

## Funcionalidades

1. Registrar gastos con concepto, monto y categoría.
2. Mostrar el listado de gastos.
3. Calcular el total acumulado.
4. Identificar el gasto de mayor valor.
5. Filtrar gastos estrictamente superiores a un monto.
6. Buscar gastos por subcadena del concepto, sin distinguir mayúsculas y minúsculas.

## Requisitos

- JDK 17 o superior.
- Git para consultar el repositorio.

## Compilar y ejecutar la versión estructurada

Desde la raíz del proyecto:

```bash
javac --release 17 -encoding UTF-8 -d out src/estructurado/Main.java
java -cp out Main
```

## Datos de prueba

| Concepto | Monto |
|---|---:|
| Almuerzo | $12.50 |
| Bus | $3.00 |
| Internet | $45.00 |
| Cine | $18.50 |
| Mercado | $80.00 |
| Gasolina | $50.00 |
| Recibo de luz | $65.50 |
| **Total** | **$274.50** |

El gasto de mayor valor es Mercado por $80.00. Al filtrar por un monto superior a $50, deben aparecer Mercado y Recibo de luz.

## Estructura y colaboración

- `src/estructurado/`: implementación estructurada.
- `src/poo/`: implementación orientada a objetos.
- `src/eventos/`: implementación orientada a eventos.
- `src/funcional/`: implementación funcional.
- `docs/`: documentación de los paradigmas.

Las ramas `feature/paradigma-*` se utilizan para trabajar en cada versión. `develop` integra los cambios revisados y `main` conserva la versión seleccionada para la entrega.

## Equipo de trabajo

- Laura Ramos: paradigma estructurado y coordinación.
- Stefanía: paradigma orientado a eventos.
- Valeria: paradigmas orientado a objetos y funcional.

La evidencia de commits, revisiones y Pull Requests se conserva en el historial del repositorio.

## Consulta bibliográfica

**Biblioteca consultada:** eLibro, mediante la biblioteca digital institucional de la Corporación Universitaria Empresarial Alexander von Humboldt.

**Término de búsqueda:** Programación funcional.

**Fuente bibliográfica localizada:**

Chacón Sartori, C. (2021). *Computación y programación funcional*. Marcombo.

**Tema de consulta:** Programación funcional.

**Relación con el proyecto:**

Se seleccionó esta fuente por su relación directa con el paradigma funcional, una de las cuatro versiones desarrolladas en el Sistema de Control de Gastos Personales. La consulta bibliográfica complementa el análisis del código y permite relacionar el enfoque funcional con el procesamiento de datos mediante operaciones como `map`, `filter`, `reduce` y expresiones lambda.


