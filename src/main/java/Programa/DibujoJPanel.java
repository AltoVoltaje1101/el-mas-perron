/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author felix_5bh1a4y
 */
public class DibujoJPanel extends JPanel{
    JPanel fondo;
    public DibujoJPanel(JPanel panel){
        fondo = panel;
        fondo.setBackground(Color.red);
        ponerFondo();
        fondo.repaint();
    }
    public void ponerFondo(){
        //ImageIcon imagen = new ImageIcon("src\\main\\java\\Imagenes\\fondoPrincipal.jpg");
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(new File("src\\main\\java\\Imagenes\\fondoPrincipal.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(DibujoJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(imagen == )
        System.out.println("");
        fondo.getGraphics().drawImage(imagen, 200, 400, this);
    }
}
