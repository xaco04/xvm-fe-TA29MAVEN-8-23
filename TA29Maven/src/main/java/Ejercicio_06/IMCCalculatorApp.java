/**
 * 
 */
package Ejercicio_06;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculatorApp extends JFrame {

    private JTextField pesoTextField, alturaTextField, resultadoTextField;
    private JButton calcularButton;

    public IMCCalculatorApp() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pesoTextField = new JTextField(10);
        alturaTextField = new JTextField(10);
        resultadoTextField = new JTextField(10);
        resultadoTextField.setEditable(false);

        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Peso (kg):"));
        panel.add(pesoTextField);
        panel.add(new JLabel("Altura (m):"));
        panel.add(alturaTextField);
        panel.add(new JLabel("Resultado:"));
        panel.add(resultadoTextField);
        panel.add(new JLabel());
        panel.add(calcularButton);

        getContentPane().add(panel);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double altura = Double.parseDouble(alturaTextField.getText());

            double imc = peso / (altura * altura);
            resultadoTextField.setText(String.format("%.2f", imc));
        } catch (NumberFormatException ex) {
            resultadoTextField.setText("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IMCCalculatorApp().setVisible(true);
            }
        });
    }
}
