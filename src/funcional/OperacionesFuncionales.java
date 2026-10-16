
package funcional;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OperacionesFuncionales {

    // 1. Registrar un gasto sin modificar la lista original
    public static List<GastoFuncional> agregarGasto(
            List<GastoFuncional> gastos, GastoFuncional nuevo) {

        if (nuevo == null) {
            throw new IllegalArgumentException("El gasto no puede ser nulo");
        }

        return java.util.stream.Stream.concat(
            gastos.stream(),
            java.util.stream.Stream.of(nuevo)
        ).collect(Collectors.toList());
    }

    // 2. Obtener el listado de gastos
    public static List<GastoFuncional> listarGastos(
            List<GastoFuncional> gastos) {

        return gastos.stream().collect(Collectors.toList());
    }

    // 3. Calcular el total usando map y reduce
    public static BigDecimal calcularTotal(
            List<GastoFuncional> gastos) {

        return gastos.stream()
            .map(gasto -> gasto.getMonto())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 4. Encontrar el gasto de mayor valor
    public static GastoFuncional obtenerMayorGasto(
            List<GastoFuncional> gastos) {

        return gastos.stream()
            .max((a, b) -> a.getMonto().compareTo(b.getMonto()))
            .orElse(null);
    }

    // 5. Filtrar gastos mayores a un monto
    public static List<GastoFuncional> filtrarPorMonto(
            List<GastoFuncional> gastos, BigDecimal minimo) {

        return filtrar(gastos,
            gasto -> gasto.getMonto().compareTo(minimo) > 0);
    }

    // 6. Buscar gastos por concepto
    public static List<GastoFuncional> buscarPorConcepto(
            List<GastoFuncional> gastos, String palabra) {

        String busqueda = normalizar(palabra);

        return filtrar(gastos,
            gasto -> normalizar(gasto.getConcepto()).contains(busqueda));
    }

    // Funcion de orden superior
    public static List<GastoFuncional> filtrar(
            List<GastoFuncional> gastos,
            Predicate<GastoFuncional> condicion) {

        return gastos.stream()
            .filter(condicion)
            .collect(Collectors.toList());
    }

    // Ignorar mayusculas y acentos
    private static String normalizar(String texto) {

        String limpio = Normalizer.normalize(
            texto.toLowerCase(), Normalizer.Form.NFD
        );

        return limpio.replaceAll("\\p{M}", "");
    }
}

