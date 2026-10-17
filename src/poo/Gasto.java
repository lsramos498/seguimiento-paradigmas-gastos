
package poo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Gasto {

    private String concepto;
    private BigDecimal monto;
    private String categoria;

    public Gasto(String concepto, BigDecimal monto, String categoria) {

        // Validar que el concepto no este vacio
        if (concepto == null || concepto.trim().isEmpty()) {
            throw new IllegalArgumentException("El concepto no puede estar vacio");
        }

        // Validar que el monto sea mayor a cero
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }

        // Categorias permitidas
        List<String> categorias = Arrays.asList(
            "Alimentación",
            "Transporte",
            "Servicios",
            "Entretenimiento",
            "Otros"
        );

        // Validar que la categoria este permitida
        if (categoria == null || !categorias.contains(categoria)) {
            throw new IllegalArgumentException("Categoria no permitida");
        }

        // Asignar los datos al objeto
        this.concepto = concepto.trim();
        this.monto = monto;
        this.categoria = categoria;
    }

    // Obtener el concepto del gasto
    public String getConcepto() {
        return concepto;
    }

    // Obtener el monto del gasto
    public BigDecimal getMonto() {
        return monto;
    }

    // Obtener la categoria del gasto
    public String getCategoria() {
        return categoria;
    }
}
