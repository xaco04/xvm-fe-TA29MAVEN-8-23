/**
 * 
 */
package Ejercicio_09;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoMemoriaApp extends JFrame {

    private JButton[] cartas;
    private JButton primeraCartaSeleccionada;
    private int parejasEncontradas = 0;

    private Color colorOriginal = Color.GRAY;
    private Color[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

    public JuegoMemoriaApp() {
        setTitle("Juego de Memoria");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 4));
        cartas = new JButton[16];

        for (int i = 0; i < 16; i++) {
            cartas[i] = new JButton();
            cartas[i].setBackground(colorOriginal);
            final int index = i;
            cartas[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cartaSeleccionada(index);
                }
            });
            panel.add(cartas[i]);
        }

        getContentPane().add(panel);
        setVisible(true);
    }

    private void cartaSeleccionada(int index) {
        if (primeraCartaSeleccionada == null) {
            primeraCartaSeleccionada = cartas[index];
            primeraCartaSeleccionada.setBackground(colores[index % 4]);
        } else if (primeraCartaSeleccionada != cartas[index]) {
            cartas[index].setBackground(colores[index % 4]);
            if (primeraCartaSeleccionada.getBackground() == cartas[index].getBackground()) {
                parejasEncontradas++;
                if (parejasEncontradas == 4) {
                    JOptionPane.showMessageDialog(this, "¡Has ganado!");
                    System.exit(0);
                }
                primeraCartaSeleccionada.setEnabled(false);
                cartas[index].setEnabled(false);
            } else {
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        primeraCartaSeleccionada.setBackground(colorOriginal);
                        cartas[index].setBackground(colorOriginal);
                        primeraCartaSeleccionada = null;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
            primeraCartaSeleccionada = null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JuegoMemoriaApp();
            }
        });
    }
}
