/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author felix_5bh1a4y
 */
public class DibujoJPanel extends JPanel{
    JPanel fondo;
    Graphics2D grafico;
    public DibujoJPanel(){
        
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
    }
    public void dibujarCirculos(){
        Graphics a = getGraphics();
        a.drawLine(50, 50, 200, 200);
    }
}
