/**
 * 
 */
package Ejercicio_03;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorClicksApp extends JFrame {

    private JLabel etiqueta1, etiqueta2;
    private JButton boton1, boton2;

    private int contadorClicks1 = 0;
    private int contadorClicks2 = 0;

    public ContadorClicksApp() {
        setTitle("Contador de Clicks");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        etiqueta1 = new JLabel("Botón 1: " + contadorClicks1 + " clics");
        etiqueta2 = new JLabel("Botón 2: " + contadorClicks2 + " clics");

        boton1 = new JButton("Botón 1");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorClicks1++;
                actualizarEtiquetas();
            }
        });

        boton2 = new JButton("Botón 2");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorClicks2++;
                actualizarEtiquetas();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(boton1);
        panel.add(boton2);

        getContentPane().add(panel);
    }

    private void actualizarEtiquetas() {
        etiqueta1.setText("Botón 1: " + contadorClicks1 + " clics");
        etiqueta2.setText("Botón 2: " + contadorClicks2 + " clics");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContadorClicksApp().setVisible(true);
            }
        });
    }
}
