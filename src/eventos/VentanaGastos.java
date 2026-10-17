
package eventos;

import javax.swing.*;
import java.awt.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class VentanaGastos extends JFrame {

    // Representa cada gasto registrado.
    private static class Gasto {
        String concepto;
        double monto;
        String categoria;

        public Gasto(String concepto, double monto, String categoria) {
            this.concepto = concepto;
            this.monto = monto;
            this.categoria = categoria;
        }

        @Override
        public String toString() {
            return concepto + " | $" + String.format("%,.0f", monto)
                    + " | " + categoria;
        }
    }

    // Lista donde se almacenan los gastos.
    private final List<Gasto> gastos = new ArrayList<>();

    private final JTextField txtConcepto = new JTextField(15);
    private final JTextField txtMonto = new JTextField(10);

    private final JComboBox<String> cmbCategoria = new JComboBox<>(
            new String[]{
                    "Alimentación",
                    "Transporte",
                    "Servicios",
                    "Entretenimiento"
            }
    );

    private final JTextArea areaResultados = new JTextArea(15, 45);

    public VentanaGastos() {
        setTitle("Sistema de Control de Gastos Personales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550);
        setLocationRelativeTo(null);

        // Formulario para registrar los gastos.
        JPanel formulario = new JPanel(new GridLayout(2, 3, 8, 8));
        formulario.setBorder(
                BorderFactory.createTitledBorder("Registrar gasto")
        );

        formulario.add(new JLabel("Concepto:"));
        formulario.add(new JLabel("Monto:"));
        formulario.add(new JLabel("Categoría:"));

        formulario.add(txtConcepto);
        formulario.add(txtMonto);
        formulario.add(cmbCategoria);

        // Botones de las operaciones.
        JButton btnRegistrar = new JButton("Registrar Gasto");
        JButton btnListado = new JButton("Mostrar Listado");
        JButton btnTotal = new JButton("Calcular Total");
        JButton btnMayor = new JButton("Gasto de Mayor Valor");
        JButton btnFiltrar =
                new JButton("Filtrar por Monto Mínimo");
        JButton btnBuscar = new JButton("Buscar por Concepto");

        JPanel panelBotones = new JPanel(
                new GridLayout(2, 3, 8, 8)
        );

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnListado);
        panelBotones.add(btnTotal);
        panelBotones.add(btnMayor);
        panelBotones.add(btnFiltrar);
        panelBotones.add(btnBuscar);

        areaResultados.setEditable(false);
        areaResultados.setFont(
                new Font(Font.MONOSPACED, Font.PLAIN, 13)
        );

        JPanel panelSuperior = new JPanel(new BorderLayout(8, 8));
        panelSuperior.add(formulario, BorderLayout.NORTH);
        panelSuperior.add(panelBotones, BorderLayout.CENTER);

        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(areaResultados), BorderLayout.CENTER);

        // Eventos y callbacks: cada botón ejecuta su operación.
        btnRegistrar.addActionListener(e -> registrarGasto());
        btnListado.addActionListener(e -> mostrarListado());
        btnTotal.addActionListener(e -> calcularTotal());
        btnMayor.addActionListener(e -> mostrarMayor());
        btnFiltrar.addActionListener(e -> filtrarPorMonto());
        btnBuscar.addActionListener(e -> buscarPorConcepto());
    }

    // 1. Registrar un gasto.
    private void registrarGasto() {
        String concepto = txtConcepto.getText().trim();
        String textoMonto = txtMonto.getText().trim();
        String categoria = (String) cmbCategoria.getSelectedItem();

        if (concepto.isEmpty()) {
            mostrarMensaje("El concepto no puede estar vacío.");
            return;
        }

        try {
            double monto = Double.parseDouble(
                    textoMonto.replace(",", ".")
            );

            if (monto <= 0) {
                mostrarMensaje("El monto debe ser mayor que cero.");
                return;
            }

            gastos.add(new Gasto(concepto, monto, categoria));

            mostrarMensaje(
                    "Gasto registrado correctamente:\n"
                            + gastos.get(gastos.size() - 1)
            );

            txtConcepto.setText("");
            txtMonto.setText("");

        } catch (NumberFormatException ex) {
            mostrarMensaje("Ingresa un monto numérico válido.");
        }
    }

    // 2. Mostrar todos los gastos.
    private void mostrarListado() {
        if (gastos.isEmpty()) {
            mostrarMensaje("La lista de gastos está vacía.");
            return;
        }

        StringBuilder resultado =
                new StringBuilder("LISTADO DE GASTOS\n\n");

        for (Gasto gasto : gastos) {
            resultado.append(gasto).append("\n");
        }

        areaResultados.setText(resultado.toString());
    }

    // 3. Calcular el total acumulado.
    private void calcularTotal() {
        double total = 0;

        for (Gasto gasto : gastos) {
            total += gasto.monto;
        }

        mostrarMensaje(
                "Total acumulado: $"
                        + String.format("%,.0f", total)
        );
    }

    // 4. Mostrar el gasto de mayor valor.
    private void mostrarMayor() {
        if (gastos.isEmpty()) {
            mostrarMensaje("No hay gastos registrados.");
            return;
        }

        Gasto mayor = gastos.get(0);

        for (Gasto gasto : gastos) {
            if (gasto.monto > mayor.monto) {
                mayor = gasto;
            }
        }

        mostrarMensaje("Gasto de mayor valor:\n" + mayor);
    }

    // 5. Filtrar gastos estrictamente mayores al monto indicado.
    private void filtrarPorMonto() {
        String texto = JOptionPane.showInputDialog(
                this,
                "Ingresa el monto mínimo:"
        );

        if (texto == null) {
            return;
        }

        try {
            double minimo = Double.parseDouble(
                    texto.trim().replace(",", ".")
            );

            StringBuilder resultado = new StringBuilder(
                    "GASTOS MAYORES A $"
                            + String.format("%,.0f", minimo)
                            + "\n\n"
            );

            int encontrados = 0;

            for (Gasto gasto : gastos) {
                if (gasto.monto > minimo) {
                    resultado.append(gasto).append("\n");
                    encontrados++;
                }
            }

            if (encontrados == 0) {
                resultado.append("No se encontraron gastos.");
            }

            areaResultados.setText(resultado.toString());

        } catch (NumberFormatException ex) {
            mostrarMensaje("Ingresa un monto válido.");
        }
    }

    // 6. Buscar por una parte del concepto, ignorando
    // mayúsculas, minúsculas y diferencias de acentos.
    private void buscarPorConcepto() {
        String texto = JOptionPane.showInputDialog(
                this,
                "Escribe el concepto que deseas buscar:"
        );

        if (texto == null || texto.trim().isEmpty()) {
            mostrarMensaje("Debes escribir un concepto para buscar.");
            return;
        }

        String buscado = normalizar(texto);
        StringBuilder resultado =
                new StringBuilder("RESULTADOS DE BÚSQUEDA\n\n");

        int encontrados = 0;

        for (Gasto gasto : gastos) {
            if (normalizar(gasto.concepto).contains(buscado)) {
                resultado.append(gasto).append("\n");
                encontrados++;
            }
        }

        if (encontrados == 0) {
            resultado.append("No se encontraron gastos.");
        }

        areaResultados.setText(resultado.toString());
    }

    // Normaliza el texto para facilitar la búsqueda.
    private String normalizar(String texto) {
        return Normalizer.normalize(
                        texto.toLowerCase(),
                        Normalizer.Form.NFD
                )
                .replaceAll("\\p{M}", "");
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Punto de entrada de la aplicación.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaGastos ventana = new VentanaGastos();
            ventana.setVisible(true);
        });
    }
}
