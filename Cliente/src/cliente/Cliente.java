package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cliente {

    public static void main(String[] args) {
        MarcoCliente mimarco = new MarcoCliente();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(600, 300, 280, 350);

        LaminaMarcoCliente milamina = new LaminaMarcoCliente();

        add(milamina);

        setVisible(true);
    }
}

class LaminaMarcoCliente extends JPanel {

    public LaminaMarcoCliente() {

        JLabel texto = new JLabel("CLIENTE");

        add(texto);

        campo1 = new JTextField(20);

        add(campo1);

        
        miboton = new JButton("Enviar");
        EnviaTexto mievento = new EnviaTexto();
        miboton.addActionListener(mievento);
        add(miboton);
    }

    private class EnviaTexto implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(campo1.getText());
            
            try {
                Socket misocket = new Socket("192.168.0.13",9999);
                
            } catch (IOException ex) {
               ex.printStackTrace();
               System.out.println(ex.getMessage());
            }
            
        }
    
    }
    
    private JTextField campo1;
    private JButton miboton;
}
