
package funcional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFuncional {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        List<GastoFuncional> gastos = new ArrayList<>();
        int opcion = -1;

        do {
            System.out.println("\n===== CONTROL DE GASTOS FUNCIONAL =====");
            System.out.println("1. Registrar gasto");
            System.out.println("2. Mostrar listado de gastos");
            System.out.println("3. Calcular gasto total");
            System.out.println("4. Mostrar gasto mayor");
            System.out.println("5. Filtrar gastos por monto");
            System.out.println("6. Buscar gasto por concepto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {

                    case 1:
                        System.out.print("Concepto: ");
                        String concepto = teclado.nextLine();

                        System.out.print("Monto: ");
                        BigDecimal monto = new BigDecimal(teclado.nextLine());

                        System.out.println("1. Alimentación");
                        System.out.println("2. Transporte");
                        System.out.println("3. Servicios");
                        System.out.println("4. Entretenimiento");
                        System.out.print("Seleccione categoria: ");

                        int numeroCategoria = Integer.parseInt(teclado.nextLine());
                        String categoria;

                        switch (numeroCategoria) {
                            case 1: categoria = "Alimentación"; break;
                            case 2: categoria = "Transporte"; break;
                            case 3: categoria = "Servicios"; break;
                            case 4: categoria = "Entretenimiento"; break;
                            default: categoria = "";
                        }

                        GastoFuncional nuevo = new GastoFuncional(
                            concepto, monto, categoria
                        );

                        gastos = OperacionesFuncionales.agregarGasto(
                            gastos, nuevo
                        );

                        System.out.println("Gasto registrado correctamente.");
                        break;

                    case 2:
                        mostrarGastos(
                            OperacionesFuncionales.listarGastos(gastos)
                        );
                        break;

                    case 3:
                        System.out.println("Total: $" +
                            OperacionesFuncionales.calcularTotal(gastos));
                        break;

                    case 4:
                        GastoFuncional mayor =
                            OperacionesFuncionales.obtenerMayorGasto(gastos);

                        if (mayor == null) {
                            System.out.println("No hay gastos registrados.");
                        } else {
                            System.out.println("Mayor gasto: " +
                                mayor.getConcepto() + " - $" + mayor.getMonto());
                        }
                        break;

                    case 5:
                        System.out.print("Mostrar gastos mayores a: ");
                        BigDecimal minimo = new BigDecimal(teclado.nextLine());

                        mostrarGastos(
                            OperacionesFuncionales.filtrarPorMonto(gastos, minimo)
                        );
                        break;

                    case 6:
                        System.out.print("Concepto a buscar: ");
                        String busqueda = teclado.nextLine();

                        mostrarGastos(
                            OperacionesFuncionales.buscarPorConcepto(
                                gastos, busqueda
                            )
                        );
                        break;

                    case 0:
                        System.out.println("Hasta pronto.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);

        teclado.close();
    }

    public static void mostrarGastos(List<GastoFuncional> gastos) {

        if (gastos.isEmpty()) {
            System.out.println("No se encontraron gastos.");
            return;
        }

        System.out.println("\n--- LISTADO DE GASTOS ---");

        gastos.forEach(gasto ->
            System.out.println(
                gasto.getConcepto() + " | $" +
                gasto.getMonto() + " | " +
                gasto.getCategoria()
            )
        );
    }
}

