/**
 * 
 */
package Ejercicio_08;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class ConversorMonedaMejoradoApp extends JFrame {

    private JTextField cantidadTextField;
    private JLabel resultadoLabel;
    private JButton pesetasAEurosButton, eurosAPesetasButton, borrarButton;

    private static final double TASA_CAMBIO_EURO_PESETA = 166.386;

    public ConversorMonedaMejoradoApp() {
        setTitle("Conversor de Moneda Mejorado");
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

        borrarButton = new JButton("Borrar");
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadTextField.setText("");
                resultadoLabel.setText("");
            }
        });

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (e.getSource() == cantidadTextField) {
                        convertirPesetasAEuros();
                    } else if (e.getSource() == pesetasAEurosButton) {
                        convertirPesetasAEuros();
                    } else if (e.getSource() == eurosAPesetasButton) {
                        convertirEurosAPesetas();
                    } else if (e.getSource() == borrarButton) {
                        cantidadTextField.setText("");
                        resultadoLabel.setText("");
                    }
                }
            }
        };

        cantidadTextField.addKeyListener(keyAdapter);
        pesetasAEurosButton.addKeyListener(keyAdapter);
        eurosAPesetasButton.addKeyListener(keyAdapter);
        borrarButton.addKeyListener(keyAdapter);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(new JLabel("Cantidad:"));
        panel.add(cantidadTextField);
        panel.add(pesetasAEurosButton);
        panel.add(eurosAPesetasButton);
        panel.add(borrarButton);
        panel.add(resultadoLabel);

        getContentPane().add(panel);

        setVisible(true);
    }

    private void convertirPesetasAEuros() {
        try {
            double cantidadPesetas = Double.parseDouble(cantidadTextField.getText());
            double cantidadEuros = cantidadPesetas / TASA_CAMBIO_EURO_PESETA;
            resultadoLabel.setText(String.format("%.2f pesetas son %.2f euros", cantidadPesetas, cantidadEuros));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Introduce un número válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void convertirEurosAPesetas() {
        try {
            double cantidadEuros = Double.parseDouble(cantidadTextField.getText());
            double cantidadPesetas = cantidadEuros * TASA_CAMBIO_EURO_PESETA;
            resultadoLabel.setText(String.format("%.2f euros son %.2f pesetas", cantidadEuros, cantidadPesetas));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Introduce un número válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConversorMonedaMejoradoApp();
            }
        });
    }
}
