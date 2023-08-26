/**
 * 
 */
package Ejercicio_01;

/**
 * 
 */
import javax.swing.*;

public class VentanaBasicaApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                crearVentana();
            }
        });
    }

    private static void crearVentana() {
        JFrame ventana = new JFrame("Xavi");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel etiqueta = new JLabel("Hola soc el Xavier Jordi Vico Martí");
        ventana.add(etiqueta);

        ventana.setVisible(true);
    }
}
