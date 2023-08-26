/**
 * 
 */
package Ejercicio_05;

/**
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosRatonApp extends JFrame {

    private JTextArea areaTexto;
    private JButton botonLimpiar;

    public EventosRatonApp() {
        setTitle("Eventos de Ratón");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText("");
            }
        });

        areaTexto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                areaTexto.append("Evento: Clic en (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                areaTexto.append("Evento: Mouse presionado en (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                areaTexto.append("Evento: Mouse liberado en (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                areaTexto.append("Evento: Mouse entró en el área de texto\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                areaTexto.append("Evento: Mouse salió del área de texto\n");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        panel.add(botonLimpiar, BorderLayout.SOUTH);

        getContentPane().add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EventosRatonApp();
            }
        });
    }
}
