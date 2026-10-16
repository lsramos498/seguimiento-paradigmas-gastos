
package funcional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class GastoFuncional {

    private final String concepto;
    private final BigDecimal monto;
    private final String categoria;

    public GastoFuncional(String concepto, BigDecimal monto, String categoria) {

        if (concepto == null || concepto.trim().isEmpty()) {
            throw new IllegalArgumentException("El concepto no puede estar vacio");
        }

        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }

        List<String> categorias = Arrays.asList(
            "Alimentación",
            "Transporte",
            "Servicios",
            "Entretenimiento"
        );

        if (categoria == null || !categorias.contains(categoria)) {
            throw new IllegalArgumentException("Categoria no permitida");
        }

        this.concepto = concepto.trim();
        this.monto = monto;
        this.categoria = categoria;
    }

    public String getConcepto() {
        return concepto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getCategoria() {
        return categoria;
    }
}

