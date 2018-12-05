/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import Graphic.Point;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;

/**
 *
 * @author pc
 */
public class QuickSort {
    private int num;
    private int[] array;
    private JLabel[] lbArrays;
    private boolean isIncrease = true;
    private Thread[] threads = new Thread[1000000];
    private int curT = -1;
    private int time = 100;
    private int step = 0;	
    private int[] lbI = new int[50];
    private int[] lbJ = new int[50];
    private int[] oriLocat = new int[15];
    private int[] lbL = new int[50];
    private int[] lbR = new int[50];
    private Point point;
    
    public QuickSort(int num, JLabel[] lbArrays, int[] array, Point point, boolean isIncrease) {
        this.num = num;
        this.array = array;
        this.lbArrays = lbArrays;
        this.point = point;
        this.isIncrease = isIncrease;
        QuickSortAl(0, num - 1);
        QuickSortAnimation();
        step = 0;
    }
    
    public void Coloring(JLabel lb1, Color c) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    lb1.setBackground(c);
                    Thread.sleep(time);
                } catch (Exception e) {}
            }
        });
        threads[cur].start();
    }
    
    public void Coloring(int left, int right, Color c) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0)
                        threads[cur - 1].join();
                    int i = left;
                    while (i <= right) {
                        if (i != (left + right) / 2)
                            lbArrays[i].setBackground(c);
                        i ++;
                    }
                    Thread.sleep(time);
                } catch (Exception e) {}
            }
        });
        threads[cur].start();
    }

    public void QuickSortAnimation() {
        int s, i, j;
        for (s = 0; s < step; s ++) {
            i = lbI[s];
            j = lbJ[s];
            setlbPoint(point.lbPoint1, i, "i = ");
            setlbPoint(point.lbPoint2, j, "j = ");
            if (i != j) {
                Coloring(lbArrays[(lbL[s] + lbR[s]) / 2], Color.GREEN);
                Coloring(lbL[s], lbR[s], Color.YELLOW);
                Swap(lbArrays[i], lbArrays[j]);
            }
            if (lbL[s + 1] + lbR[s + 1] != lbL[s] + lbR[s]) {
                Coloring(lbArrays[(lbL[s] + lbR[s]) / 2], SystemColor.inactiveCaption);
                Coloring(lbL[s], lbR[s], SystemColor.inactiveCaption);
            }
        }
    }
    
    public void QuickSortAl(int left, int right) {
            if (isIncrease) {
	    	int i, j, x;
	        x = array[(left + right) / 2];
	        i = left; j = right;
	        while (i < j) {
	            while (array[i] < x) {
                        i ++;
                    }
	            while (array[j] > x) {
                        j --;
                    }
	            if (i <= j) {
                        if (array[i] != array[j]) {
	                    int temp = array[i];
	                    array[i] = array[j];
	                    array[j] = temp;
	                    if (i != j) {
                                lbL[step] = left; lbR[step] = right;
	                        lbI[step] = i; lbJ[step] = j;
	                        step ++;
	                    }
                        }
	                i ++; j --;
	            }
	        }
	        if (left < j)
	            QuickSortAl(left, j);
	        if (i < right)
	            QuickSortAl(i, right);
        }
        else {
        	int i, j, x;
	        x = array[(left + right) / 2];
	        i = left; j = right;
	        while (i < j) {
	            while (array[i] > x) {
                        i ++;
                    }
	            while (array[j] < x) {
                        j --;
                    }
	            if (i <= j) {
                        if (array[i] != array[j]) {
	                    int temp = array[i];
	                    array[i] = array[j];
	                    array[j] = temp;
	                    if (i != j) {
                                lbL[step] = left; lbR[step] = right;
	                        lbI[step] = i; lbJ[step] = j;
	                        step ++;
	                    }
                        }
	                i ++; j --;
	            }
	        }
	        if (left < j)
	            QuickSortAl(left, j);
	        if (i < right)
	            QuickSortAl(i, right);
        }
    }
    public void Swap(JLabel lb1, JLabel lb2) {
		int x1 = lb1.getX();
		int x2 = lb2.getX();
		curT ++;
		
		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
			    		threads[cur-1].join();
			    	}
                                Color processingColor = Color.RED;
		    		
		    		lb1.setBackground(processingColor);
		    		lb2.setBackground(processingColor);
			        while (lb1.getY() > 100) {
			        	lb1.setLocation(lb1.getX(), lb1.getY() - 10);
			        	lb2.setLocation(lb2.getX(), lb2.getY() + 10);
                                        point.lbPointM.setLocation(x2, point.lbPointM.getY() + 10);
			        	Thread.sleep(time);
			        }
			        while (lb1.getX() < x2) {
			        	lb1.setLocation(lb1.getX() + 10, lb1.getY());
			        	lb2.setLocation(lb2.getX() - 10, lb2.getY());
                                        point.lbPointM.setLocation(lb2.getX(), 250);
			        	Thread.sleep(time);
			        }
			        while (lb1.getY() < 140) {
			        	lb1.setLocation(lb1.getX(), lb1.getY() + 10);
			        	lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                                        point.lbPointM.setLocation(x1, point.lbPointM.getY() - 10);
			        	Thread.sleep(time);
			        }
			        String txtLb1 = lb1.getText();
			        lb1.setText(lb2.getText());
			        lb2.setText(txtLb1);
			        lb1.setLocation(x1, 150);
		        	lb2.setLocation(x2, 150);
		        	lb1.setBackground(SystemColor.inactiveCaption);
		        	lb2.setBackground(SystemColor.inactiveCaption);
		    	} catch (Exception e) {
		    	}
		    }
		});
		threads[cur].start();
	}
    
    public void setlbPoint(JLabel lbPoint, int i, String s) {
            curT ++;
            System.out.println(curT);
            int cur = curT;
            threads[cur] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (cur != 0)
                            threads[cur - 1].join();
                        if (i == -1) {
                            lbPoint.setText("");
                            return;
                        }
                        if (s.charAt(0) == 'm') {
                            lbPoint.setLocation(lbArrays[i].getX(), 200);
                            lbPoint.setText(s);
                        } else if (s.charAt(0) == 'k') {
                            lbPoint.setLocation(oriLocat[i], 200);
                            lbPoint.setText(s + i);
                        } else {
                            lbPoint.setLocation(lbArrays[i].getX(), 275);
                            lbPoint.setText(s + i);
                        }
                    } catch (Exception e){}
                }
            });
            threads[cur].start();
        }
        
    // </editor-fold>

    public void setIsIncrease(boolean isIncrease) {
        this.isIncrease = isIncrease;
    }

    public QuickSort() {
    }
    
}
