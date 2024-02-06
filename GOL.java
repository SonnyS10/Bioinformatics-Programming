import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myinterface implements ActionListener
{
    JFrame jfrm = new JFrame("This is my Frame");
    JLabel jlab;
    public static boolean[][] matrix = new boolean[20][20];
    myPanel panel = new myPanel();
    public static boolean[][] matrix2 = new boolean[20][20];

    myinterface()
    {//contructor 
        jfrm.setSize(800,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jbtnStep = new JButton("Step");
        jfrm.add(jbtnStep,BorderLayout.WEST);
        JButton jbtnReset = new JButton("Reset");
        jfrm.add(jbtnReset,BorderLayout.EAST);
        jfrm.add(panel,BorderLayout.CENTER);
        jbtnStep.addActionListener(this);
        jbtnReset.addActionListener(this);
        jfrm.setVisible(true);
        for(int x = 0; x <= 19; x++)
        {
            for(int y = 0; y <= 19; y++)
            {
                matrix[x][y] = false;
            }
        
        }   
        matrix[5][5] = true;
        matrix[6][5] = true; 
        matrix[7][5] = true; 
        matrix[7][4] = true; 
        matrix[6][3] = true; 
    }//constructor 

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Step"))
        {
            boolean cellState;
            int aliveCells; 
            for(int x = 0; x < 20; x++)
            {
                for(int y = 0; y < 20; y++)
                {
                    matrix2[x][y] = false; 
                    aliveCells = 0; 
                    if(matrix[x][y] == true)
                    {
                        cellState = true; 
                    }
                    else
                    {
                        cellState = false; 
                    }
                    for(int r = -1; r < 2; r++)
                    {
                        for(int c = -1; c < 2; c++)
                        {
                            int nr = x + r; 
                            int nc = y + c; 
                            if(nr == -1)
                            {
                                nr = 19;
                            }
                            if(nr == 20)
                            {
                                nr = 0; 
                            }
                            if(nc == -1)
                            {
                                nc = 19;
                            }
                            if(nc == 20)
                            {
                                nc = 0; 
                            }
                            if(matrix[nr][nc] == true)
                            {
                                aliveCells++; 
                            }
                        }
                    }
                    if(cellState == true)
                    {
                        aliveCells -= 1;
                        switch(aliveCells)
                        {
                            case 0:
                                matrix2[x][y] = false; 
                                break;
                            case 1: 
                                matrix2[x][y] = false;
                                break;
                            case 2: 
                                matrix2[x][y] = true;
                                break;
                            case 3:
                                matrix2[x][y] = true; 
                                break;
                            default:
                                matrix2[x][y] = false; 
                                break; 
                        }
                    }
                    else
                    {
                        if(aliveCells == 3)
                            {
                                matrix2[x][y] = true; 
                            }
                    }
                }
            }
            for(int x = 0; x < 20; x++)
            {
                for(int y = 0; y < 20; y++)
                {
                    matrix[x][y] = matrix2[x][y];
                }
            }
            jfrm.revalidate();
            jfrm.repaint();
        }
        if(ae.getActionCommand().equals("Reset"))
        {
            for(int x = 0; x <= 19; x++)
            {
                for(int y = 0; y <= 19; y++)
                {
                    matrix[x][y] = false;
                }
        
            }   
        matrix[5][5] = true;
        matrix[6][5] = true; 
        matrix[7][5] = true; 
        matrix[7][4] = true; 
        matrix[6][3] = true; 
            jfrm.revalidate();
            jfrm.repaint();
        }
    }
    public static void main(String args[])
    {//main
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run(){new myinterface();}
        });  
    }//main

    class myPanel extends JPanel
    {//panel
        public myPanel()
        {
            setBorder(BorderFactory.createLineBorder(Color.black) );
        }
        public Dimension getPreferredSize()
        { return new Dimension(400,400);}
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            int cellpixels = 20;
            for(int x = 0; x < 20; x++)
            {//drawing black panel 
                for(int y = 0; y < 20; y++)
                {
                    if(matrix[x][y] == false)
                    {//if matrix position is false make it a black square. 
                        int x2 = x*20;
                        int y2 = y*20;
                        g.setColor(Color.black);
                        g.fillRect(x2,y2,cellpixels,cellpixels);
                        g.setColor(Color.black);
                        g.drawRect(x2,y2,cellpixels,cellpixels);
                    }//if matrix position is false make it a black square.
                    else
                    {
                        int x2 = x*20;
                        int y2 = y*20;
                        g.setColor(Color.white);
                        g.fillRect(x2,y2,cellpixels,cellpixels);
                        g.setColor(Color.white);
                        g.drawRect(x2,y2,cellpixels,cellpixels);
                    }
                }
            }//drawing black panel 
        }
    }//panel
}