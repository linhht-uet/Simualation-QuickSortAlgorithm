
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class RunScreen {
    private static JLabel[] arr;
    private int num;

    public RunScreen() {  
    }
    public void creatArray(int num, JPanel panel, int a[] ) {
        //deleteArray(num, panel, a);
        arr = new JLabel[num];
        for (int i=0; i<num; i++) {
            arr[i] = new JLabel("0");
            panel.add(arr[i]);
            arr[i].setText(String.valueOf(a[i]));
            //set size label
            arr[i].setSize(40,40);
            arr[i].setOpaque(true);
            arr[i].setForeground(Color.blue);
            //set location label
		if (i == 0)
                    arr[i].setLocation(((int) ((18 - num) * 0.5) *1+ 5), 150);
		else
                    arr[i].setLocation(arr[i-1].getX() + 50, 150);
			
            //set fonts
            arr[i].setFont(new Font("Tahoma", Font.PLAIN, 30));
			
            //set background color
            arr[i].setBackground(SystemColor.inactiveCaption);
            //set text alignment center
            arr[i].setHorizontalAlignment(SwingConstants.CENTER); 
            arr[i].setVerticalAlignment(SwingConstants.CENTER);
        }
        panel.setVisible(true);
        panel.validate();
        panel.repaint();
    
   }
    public void deleteArray(int num, JPanel panel, int a[]) {
        for (int i = 0; i < num; i++) {
            arr[i].setText("0");
            a[i] = 0;
            arr[i].setVisible(false);
            panel.remove(arr[i]);
	}
        panel.revalidate();
	panel.repaint();
    }

    public static JLabel[] getArr() {
        return arr;
    }
    
}
