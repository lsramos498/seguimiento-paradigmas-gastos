import java.util.Locale;
import java.util.Scanner;

/**
 * Sistema de Control de Gastos Personales.
 * Implementacion mediante el paradigma estructurado.
 * Utiliza arreglos paralelos, variables estaticas,
 * funciones independientes, ciclos y condicionales.
 */
public class Main {

    private static final int CAPACIDAD = 1000;
    private static final Scanner ENTRADA = new Scanner(System.in);

    // Arreglos paralelos: la posicion identifica cada gasto.
    private static final String[] conceptos = new String[CAPACIDAD];
    private static final double[] montos = new double[CAPACIDAD];
    private static final String[] categorias = new String[CAPACIDAD];

    private static int cantidad = 0;

    private static final String[] CATEGORIAS_VALIDAS = {
        "Alimentación",
        "Transporte",
        "Servicios",
        "Entretenimiento",
        "Otros"
    };

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarGasto();
                    break;
                case 2:
                    listarGastos();
                    break;
                case 3:
                    mostrarTotal();
                    break;
                case 4:
                    mostrarGastoMayor();
                    break;
                case 5:
                    filtrarPorMonto();
                    break;
                case 6:
                    buscarPorConcepto();
                    break;
                case 7:
                    cargarDatosPrueba();
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

            System.out.println();

        } while (opcion != 0);

        ENTRADA.close();
    }

    private static void mostrarMenu() {
        System.out.println("======================================");
        System.out.println("  SISTEMA DE CONTROL DE GASTOS");
        System.out.println("======================================");
        System.out.println("1. Registrar gasto");
        System.out.println("2. Mostrar todos los gastos");
        System.out.println("3. Calcular total acumulado");
        System.out.println("4. Mostrar el gasto de mayor valor");
        System.out.println("5. Filtrar gastos por monto minimo");
        System.out.println("6. Buscar por concepto");
        System.out.println("7. Cargar datos de prueba");
        System.out.println("0. Salir");
    }

    private static void registrarGasto() {
        if (cantidad >= CAPACIDAD) {
            System.out.println("No hay capacidad para mas gastos.");
            return;
        }

        String concepto;

        do {
            System.out.print("Ingrese el concepto: ");
            concepto = ENTRADA.nextLine().trim();

            if (concepto.isEmpty()) {
                System.out.println("Error: el concepto no puede estar vacio.");
            }
        } while (concepto.isEmpty());

        double monto = leerMontoPositivo();
        String categoria = seleccionarCategoria();

        conceptos[cantidad] = concepto;
        montos[cantidad] = monto;
        categorias[cantidad] = categoria;
        cantidad++;

        System.out.println("Gasto registrado correctamente.");
    }

    private static double leerMontoPositivo() {
        double monto;

        do {
            monto = leerNumero("Ingrese el monto (mayor que cero): ");

            if (monto <= 0) {
                System.out.println("Error: el monto debe ser mayor que cero.");
            }
        } while (monto <= 0);

        return monto;
    }

    private static String seleccionarCategoria() {
        System.out.println("Seleccione la categoria:");

        for (int i = 0; i < CATEGORIAS_VALIDAS.length; i++) {
            System.out.println((i + 1) + ". " + CATEGORIAS_VALIDAS[i]);
        }

        int opcion;

        do {
            opcion = leerEntero("Categoria: ");

            if (opcion < 1 || opcion > CATEGORIAS_VALIDAS.length) {
                System.out.println("Seleccione una categoria valida.");
            }
        } while (opcion < 1 || opcion > CATEGORIAS_VALIDAS.length);

        return CATEGORIAS_VALIDAS[opcion - 1];
    }

    private static void listarGastos() {
        if (cantidad == 0) {
            System.out.println("No hay gastos registrados.");
            return;
        }

        System.out.println("LISTADO DE GASTOS");

        for (int i = 0; i < cantidad; i++) {
            mostrarGasto(i);
        }
    }

    private static void mostrarGasto(int indice) {
        System.out.println(
            (indice + 1) + ". Concepto: " + conceptos[indice]
            + " | Monto: " + formatearMonto(montos[indice])
            + " | Categoria: " + categorias[indice]
        );
    }

    private static double calcularTotal() {
        double total = 0.0;

        for (int i = 0; i < cantidad; i++) {
            total += montos[i];
        }

        return total;
    }

    private static void mostrarTotal() {
        if (cantidad == 0) {
            System.out.println("No hay gastos registrados.");
        }

        System.out.println("Total acumulado: " + formatearMonto(calcularTotal()));
    }

    private static void mostrarGastoMayor() {
        if (cantidad == 0) {
            System.out.println("No hay gastos registrados.");
            return;
        }

        int indiceMayor = 0;

        for (int i = 1; i < cantidad; i++) {
            // Se usa >, no >=, para conservar el primero si hay empate.
            if (montos[i] > montos[indiceMayor]) {
                indiceMayor = i;
            }
        }

        System.out.println("Gasto de mayor valor:");
        mostrarGasto(indiceMayor);
    }

    private static void filtrarPorMonto() {
        if (cantidad == 0) {
            System.out.println("No hay gastos registrados.");
            return;
        }

        double minimo = leerNumero("Mostrar gastos estrictamente mayores a: ");
        boolean encontrado = false;

        for (int i = 0; i < cantidad; i++) {
            if (montos[i] > minimo) {
                mostrarGasto(i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay gastos superiores a ese monto.");
        }
    }

    private static void buscarPorConcepto() {
        if (cantidad == 0) {
            System.out.println("No hay gastos registrados.");
            return;
        }

        System.out.print("Ingrese el concepto o palabra que desea buscar: ");
        String busqueda = ENTRADA.nextLine().trim();

        if (busqueda.isEmpty()) {
            System.out.println("Error: la busqueda no puede estar vacia.");
            return;
        }

        boolean encontrado = false;
        String busquedaNormalizada = busqueda.toLowerCase(Locale.ROOT);

        for (int i = 0; i < cantidad; i++) {
            String conceptoNormalizado = conceptos[i].toLowerCase(Locale.ROOT);

            if (conceptoNormalizado.contains(busquedaNormalizada)) {
                mostrarGasto(i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron gastos que coincidan con la busqueda.");
        }
    }

    private static void cargarDatosPrueba() {
        // Esta opcion reemplaza los datos actuales por los siete ejemplos.
        cantidad = 0;

        agregarDatoPrueba("Almuerzo", 12.50, "Alimentación");
        agregarDatoPrueba("Bus", 3.00, "Transporte");
        agregarDatoPrueba("Internet", 45.00, "Servicios");
        agregarDatoPrueba("Cine", 18.50, "Entretenimiento");
        agregarDatoPrueba("Mercado", 80.00, "Alimentación");
        agregarDatoPrueba("Gasolina", 50.00, "Transporte");
        agregarDatoPrueba("Recibo de luz", 65.50, "Servicios");

        System.out.println("Se cargaron los siete gastos de prueba.");
        System.out.println("Total esperado: " + formatearMonto(calcularTotal()));
    }

    private static void agregarDatoPrueba(
            String concepto, double monto, String categoria) {

        if (cantidad < CAPACIDAD) {
            conceptos[cantidad] = concepto;
            montos[cantidad] = monto;
            categorias[cantidad] = categoria;
            cantidad++;
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = ENTRADA.nextLine().trim();

            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero entero valido.");
            }
        }
    }

    private static double leerNumero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = ENTRADA.nextLine().trim();

            try {
                double numero = Double.parseDouble(texto);

                if (Double.isFinite(numero)) {
                    return numero;
                }

                System.out.println("Error: ingrese un numero finito.");
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero valido. Ejemplo: 12.50");
            }
        }
    }

    private static String formatearMonto(double monto) {
        return String.format(Locale.US, "$%.2f", monto);
    }
}