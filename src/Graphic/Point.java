/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * Point để lưu các label chứa các phần tử đang được đổi chỗ cho nhau
 */
public class Point {
    public JLabel lbPoint1 = new JLabel();
    public JLabel lbPoint2 = new JLabel();
    public JLabel lbPointM = new JLabel();
    JPanel pnImitiate ;

    public Point(JPanel pnImitiate) {
                this.pnImitiate = pnImitiate;
                lbPoint1.setSize(40, 25);
                lbPoint1.setOpaque(true);
                lbPoint1.setLocation(50, 50);
                lbPoint1.setFont(new Font("Helvetica", Font.BOLD, 17));
                lbPoint1.setBackground(SystemColor.menu);
                lbPoint1.setHorizontalAlignment(SwingConstants.CENTER);
                lbPoint1.setVerticalAlignment(SwingConstants.CENTER);
                pnImitiate.add(lbPoint1);
                pnImitiate.add(lbPoint2);
                lbPoint2.setSize(40, 25);
                lbPoint2.setOpaque(true);
                lbPoint2.setLocation(50, 50);
                lbPoint2.setFont(new Font("Helvetica", Font.BOLD, 17));
                lbPoint2.setBackground(SystemColor.menu);
                lbPoint2.setHorizontalAlignment(SwingConstants.CENTER);
                lbPoint2.setVerticalAlignment(SwingConstants.CENTER);
                pnImitiate.add(lbPointM);
                lbPointM.setSize(40, 25);
                lbPointM.setOpaque(true);
                lbPointM.setLocation(50, 50);
                lbPointM.setFont(new Font("Helvetica", Font.BOLD, 17));
                lbPointM.setBackground(SystemColor.menu);
                lbPointM.setHorizontalAlignment(SwingConstants.CENTER);
                lbPointM.setVerticalAlignment(SwingConstants.CENTER);
    }
    
                
}
