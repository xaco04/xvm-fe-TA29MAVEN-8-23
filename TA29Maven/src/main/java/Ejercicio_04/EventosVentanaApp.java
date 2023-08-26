/**
 * 
 */
package Ejercicio_04;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosVentanaApp extends JFrame {

    private JTextArea areaTexto;

    public EventosVentanaApp() {
        setTitle("Eventos de Ventana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                areaTexto.append("Evento: Ventana abierta\n");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                areaTexto.append("Evento: Ventana cerrándose\n");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                areaTexto.append("Evento: Ventana cerrada\n");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                areaTexto.append("Evento: Ventana minimizada\n");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                areaTexto.append("Evento: Ventana restaurada\n");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                areaTexto.append("Evento: Ventana activada\n");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                areaTexto.append("Evento: Ventana desactivada\n");
            }
        });

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventosVentanaApp();
            }
        });
    }
}
