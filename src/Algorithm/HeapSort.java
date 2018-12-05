
package Algorithm;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;


public class HeapSort {
    private int num;
    private int[] array;
    private JLabel[] lbArrays;
    private boolean isIncrease = true;
    private Thread[] threads = new Thread[1000000];
    private int curT = -1;
    private int time = 50;
    public void moveToLocation(JLabel lb1, int x, int y) {
        curT++;
        
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lb1.setBackground(Color.red);
                    int x1 = lb1.getX();
                    int y1 = lb1.getY();
                    if (x1 < x && y1 < y) {
                        while (lb1.getX() < x) {
                            lb1.setLocation(lb1.getX() + 10, y1);
                            Thread.sleep(time);
                        }
                        while(lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }
                    }
                    else if (x1 >= x && y1 < y) {
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y1);
                            Thread.sleep(time);
                        }   
                        while(lb1.getY() < y) {
                            lb1.setLocation(x, lb1.getY() + 10);
                            Thread.sleep(time);
                        }       
                    }
                    else if (x1 < x && y1 >= y) {
                        while (lb1.getY() > y) {
                            lb1.setLocation(x1, lb1.getY() -10);
                            Thread.sleep(time);
                        }   
                        while (lb1.getX() < x) {
                             lb1.setLocation(lb1.getX() + 10, y);
                             Thread.sleep(time);
                        }   
                    }
                    else if (x1 >= x && y1 >= y) {
                        while (lb1.getY() > y) {
                            lb1.setLocation(x1, lb1.getY() -10);
                            Thread.sleep(time);
                        }
                        while (lb1.getX() > x) {
                            lb1.setLocation(lb1.getX() - 10, y);
                            Thread.sleep(time);
                        }
                    }
                    lb1.setBackground(SystemColor.inactiveCaption);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }
    
    public void HeapLocationInit() {
        int i, j = 0;
        int row = 1;
        int maxirow = 0;
        int[] xi = {300, 200, 400, 100, 300, 240, 340, 70, 170, 270};
        int[] yi = {200, 250, 300, 400};
        moveToLocation(lbArrays[0], xi[0], yi[0]);
        for (i = 0; i <= (num - 1) / 2; i ++) {
            if (i > maxirow) {
                row ++;
                maxirow = maxirow * 2 + 2;
            }
            j = i * 2 + 1;
            while (j <= i * 2 + 2 && j < num) {
                if (j == i * 2 + 1) {
                    moveToLocation(lbArrays[j], xi[j], yi[row]);
                } else {
                    moveToLocation(lbArrays[j], xi[j], yi[row]);
                }
                j ++;
            }
        }
    }
    
    public void swapInHeap(JLabel lb1, JLabel lb2) {
        setBackgroundMoving(lb1, lb2);
        curT ++;
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur-1].join();
                    }
                    int x1 = lb1.getX();
                    int y1 = lb1.getY();
                    int x2 = lb2.getX();
                    int y2 = lb2.getY();

                    while (lb2.getY() > y1) {
                        if (lb1.getY() > y1 - 40)
                            lb1.setLocation(lb1.getX(), lb1.getY() - 10);
                        lb2.setLocation(lb2.getX(), lb2.getY() - 10);
                        Thread.sleep(time);

                    }

                    if (x2 < x1) {
                        while (lb2.getX() < x1) {
                            lb1.setLocation(lb1.getX() - 10, lb1.getY());
                            lb2.setLocation(lb2.getX() + 10, lb2.getY());
                            Thread.sleep(time);
                        }
                    } else {
                        while (lb2.getX() > x1) {
                            lb1.setLocation(lb1.getX() + 10, lb1.getY());
                            lb2.setLocation(lb2.getX() - 10, lb2.getY());
                            Thread.sleep(time);
                        }
                    }
                    while (lb1.getY() < y2) {
                        lb1.setLocation(lb1.getX(), lb1.getY() + 10);
                        Thread.sleep(time);
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    lb1.setLocation(x1, y1);
                    lb2.setLocation(x2, y2);
                    setBackgroundDone(lb1, lb2);
                } catch (Exception e) {
                    
                }
            }
        });
        threads[cur].start();
    }
    
    public void SwapHeapEnd(JLabel lb1, JLabel lb2, int xend) {
                    moveToLocation(lb1, xend, 260);
                    moveToLocation(lb2, 200, 60);
                    SwapwithoutMoving(lb1, lb2);
    }
    
    public void SwapwithoutMoving(JLabel lb1, JLabel lb2) {
        curT ++;
        System.out.println(curT);
        int cur = curT;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    String txtLb1 = lb1.getText();
                    lb1.setText(lb2.getText());
                    lb2.setText(txtLb1);
                    int x = lb1.getX();
                    int y = lb1.getY();
                    lb1.setLocation(lb2.getX(), lb2.getY());
                    lb2.setLocation(x, y);
                } catch (Exception e) {
                    
                }
            }
        });
        threads[cur].start();
    }
    
    public void Shift(int l, int r) {
        int x, i ,j;
        i = l;
        j = i * 2 + 1;

        x = array[i];
        if (isIncrease) {
            while (j <= r) {
                if (j < r) {
                    if (array[j] < array[j + 1]) {
                        j++;
                    }
                }
                if (array[j] <= x) {
                    return;
                } else {
                    array[i] = array[j];
                    array[j] = x;
                    swapInHeap(lbArrays[i], lbArrays[j]);
                    i = j;
                    j = i * 2 + 1;
                    x = array[i];
                }
            }
        } else {
            while (j <= r) {
                if (j < r) {
                    if (array[j] > array[j + 1]) {
                        j ++;
                    }
                }
                if (array[j] >= x) {
                    return;
                } else {
                    array[i] = array[j];
                    array[j] = x;
                    swapInHeap(lbArrays[i], lbArrays[j]);
                    i = j;
                    j = i * 2 + 1;
                    x = array[i];
                }
            }
        }
    }
    
    public void CreateHeap() {
        int l;
        l = num / 2 - 1;
        while (l >= 0) {
            Shift(l, num - 1);
            l --;
        }
    }
    
    public HeapSort(int num, JLabel[] lbArrays, int[] array) {
        this.num = num;
        this.array = array;
        this.lbArrays = lbArrays;
        int r;
        int xend = ((int) ((18 - num) * 0.5) * 40) + (num - 1) * 40 - 70;
        HeapLocationInit();
        Delay();
        CreateHeap();
        r = num - 1;
        while (r > 0) {
            
            int x = array[0];
            array[0] = array[r];
            array[r] = x;
            SwapHeapEnd(lbArrays[0], lbArrays[r], xend);
            xend -= 50;
            r --;
            if (r > 0) {
                Shift(0, r);
            }
        }
        SwapHeapEnd(lbArrays[0], null, xend);
    }
    public void Delay() {
        curT++;
		
		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	try {
		    		if (cur != 0) {
			    		threads[cur-1].join();
			    	}
		    		
		    		Thread.sleep(50);
		    	} catch (Exception e) {
		    		
		    	}
		    }
		});
		threads[cur].start();
    }
    public void setBackgroundMoving(JLabel lb1, JLabel lb2) {
    	lb1.setOpaque(true);
    	lb2.setOpaque(true);
    	
    	lb1.setBackground(Color.RED);
    	lb2.setBackground(Color.RED);
    }
    
    public void setBackgroundDone(JLabel lb1, JLabel lb2) {
    	lb1.setOpaque(true);
    	lb2.setOpaque(true);
    	
    	lb1.setBackground(SystemColor.inactiveCaption);
    	lb2.setBackground(SystemColor.inactiveCaption);
    }
   
    
}
