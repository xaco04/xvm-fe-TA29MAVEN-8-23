/**
 * 
 */
package Ejercicio_07;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMonedaApp extends JFrame {

    private JTextField cantidadTextField;
    private JLabel resultadoLabel;
    private JButton pesetasAEurosButton, eurosAPesetasButton;

    private static final double TASA_CAMBIO_EURO_PESETA = 166.386;

    public ConversorMonedaApp() {
        setTitle("Conversor de Moneda");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cantidadTextField = new JTextField(10);
        resultadoLabel = new JLabel("");

        pesetasAEurosButton = new JButton("Pesetas a Euros");
        pesetasAEurosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirPesetasAEuros();
            }
        });

        eurosAPesetasButton = new JButton("Euros a Pesetas");
        eurosAPesetasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirEurosAPesetas();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(new JLabel("Cantidad:"));
        panel.add(cantidadTextField);
        panel.add(pesetasAEurosButton);
        panel.add(eurosAPesetasButton);
        panel.add(resultadoLabel);

        getContentPane().add(panel);
    }

    private void convertirPesetasAEuros() {
        try {
            double cantidadPesetas = Double.parseDouble(cantidadTextField.getText());
            double cantidadEuros = cantidadPesetas / TASA_CAMBIO_EURO_PESETA;
            resultadoLabel.setText(String.format("%.2f pesetas son %.2f euros", cantidadPesetas, cantidadEuros));
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Error de entrada");
        }
    }

    private void convertirEurosAPesetas() {
        try {
            double cantidadEuros = Double.parseDouble(cantidadTextField.getText());
            double cantidadPesetas = cantidadEuros * TASA_CAMBIO_EURO_PESETA;
            resultadoLabel.setText(String.format("%.2f euros son %.2f pesetas", cantidadEuros, cantidadPesetas));
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Error de entrada");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConversorMonedaApp().setVisible(true);
            }
        });
    }
}
