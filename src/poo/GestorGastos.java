
package poo;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class GestorGastos {

    private ArrayList<Gasto> gastos;

    public GestorGastos() {
        gastos = new ArrayList<>();
    }

    // 1. Registrar un gasto
    public void agregarGasto(Gasto gasto) {
        if (gasto == null) {
            throw new IllegalArgumentException("El gasto no puede ser nulo");
        }
        gastos.add(gasto);
    }

    // 2. Mostrar todos los gastos
    public List<Gasto> listarGastos() {
        return new ArrayList<>(gastos);
    }

    // 3. Calcular el total acumulado
    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Gasto gasto : gastos) {
            total = total.add(gasto.getMonto());
        }

        return total;
    }

    // 4. Obtener el gasto de mayor valor
    public Gasto obtenerMayorGasto() {
        if (gastos.isEmpty()) {
            return null;
        }

        Gasto mayor = gastos.get(0);

        for (Gasto gasto : gastos) {
            if (gasto.getMonto().compareTo(mayor.getMonto()) > 0) {
                mayor = gasto;
            }
        }

        return mayor;
    }

    // 5. Filtrar gastos mayores a un monto
    public List<Gasto> filtrarPorMonto(BigDecimal montoMinimo) {
        List<Gasto> resultado = new ArrayList<>();

        for (Gasto gasto : gastos) {
            if (gasto.getMonto().compareTo(montoMinimo) > 0) {
                resultado.add(gasto);
            }
        }

        return resultado;
    }

    // 6. Buscar gastos por concepto
    public List<Gasto> buscarPorConcepto(String palabra) {
        List<Gasto> resultado = new ArrayList<>();

        String busqueda = normalizar(palabra);

        for (Gasto gasto : gastos) {
            if (normalizar(gasto.getConcepto()).contains(busqueda)) {
                resultado.add(gasto);
            }
        }

        return resultado;
    }

    private String normalizar(String texto) {
        String limpio = Normalizer.normalize(
            texto.toLowerCase(), Normalizer.Form.NFD
        );

        return limpio.replaceAll("\\p{M}", "");
    }
}
