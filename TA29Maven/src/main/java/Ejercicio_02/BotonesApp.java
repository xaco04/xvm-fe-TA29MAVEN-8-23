/**
 * 
 */
package Ejercicio_02;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonesApp extends JFrame {

    private JLabel etiqueta;
    private JButton botonA, botonB;

    private String ultimoBotonClicado = "Ninguno";

    public BotonesApp() {
        setTitle("Aplicación con Botones");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        etiqueta = new JLabel("Has pulsado: " + ultimoBotonClicado);

        botonA = new JButton("Botón 1");
        botonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ultimoBotonClicado = "Botón 1";
                actualizarEtiqueta();
            }
        });

        botonB = new JButton("Botón 2");
        botonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ultimoBotonClicado = "Botón 2";
                actualizarEtiqueta();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(etiqueta);
        panel.add(botonA);
        panel.add(botonB);

        getContentPane().add(panel);
    }

    private void actualizarEtiqueta() {
        etiqueta.setText("Último botón clicado: " + ultimoBotonClicado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BotonesApp().setVisible(true);
            }
        });
    }
}
