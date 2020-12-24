package LifeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;

public class ui extends JFrame implements ActionListener {
	private Container contentPane;
	private JButton[][] btns;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JPanel p1,p2,p3;
	private JLabel label1;
	private int num;
	private int sum;
	cell mycell;
	public ui(int a,int b) {
		 mycell = new cell();
		 mycell.row=a;
		 mycell.col=b;
		 mycell.cellArray=new int[mycell.row+2][mycell.col+2];
		 contentPane = getContentPane();
		 
		 //上半部分
		 p1=new JPanel();
		 btn1=new JButton("开始");
		 btn1.addActionListener(this);
         btn2=new JButton("迭代");
         btn2.addActionListener(this);
         btn3=new JButton("结束");
         btn3.addActionListener(this);
         p1.add(btn1);
         p1.add(btn2);
         p1.add(btn3);
         contentPane.add(p1,BorderLayout.NORTH);
         //中半部分
         p2=new JPanel();
         p2.setLayout(new GridLayout(mycell.row,mycell.col,0,0));
         btns=new JButton[mycell.row][mycell.col];
         for(int i=0;i<mycell.row;i++){
        	 for(int j=0;j<mycell.col;j++){
        		 btns[i][j]=new JButton();
        		 //btns[i][j].setMargin(new Insets(0,0,0,0));
        		 //btns[i][j].setFont(null);
        		 btns[i][j].setBackground(Color.white);
        		 btns[i][j].addActionListener(this);
        		 p2.add(btns[i][j]);
        	             }
        	         }
        contentPane.add(p2,BorderLayout.CENTER);
        //下半部分
        p3=new JPanel();
        p3.setLayout(new FlowLayout());
        label1=new JLabel("这是第0代，当前共有0个活细胞          ");
        btn4=new JButton("设置");
		btn4.addActionListener(this);
        p3.add(label1);
        p3.add(btn4);
        contentPane.add(p3,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setTitle("生命游戏");
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1)
		{
			num=0;
			sum=0;
			for(int i=1;i<mycell.row+1;i++)
			{
	        	 for(int j=1;j<mycell.col+1;j++)
	        	 {
	        			btns[i-1][j-1].setBackground(Color.white);
	        	 }
	       }
			mycell.init();
			for(int i=1;i<mycell.row+1;i++)
			{
	        	 for(int j=1;j<mycell.col+1;j++)
	        	 {
	        		if(mycell.cellArray[i][j]==1)
	        		{
	        			btns[i-1][j-1].setBackground(Color.black);
	        			sum++;
	        		}

	        	 }
	       }
			label1.setText("这是第"+num+"代，当前共有"+sum+"个活细胞          ");
		}
		if(e.getSource()==btn2)
		{
			num++;
			sum=0;
			for(int i=1;i<mycell.row+1;i++)
			{
				for(int j=1;j<mycell.col+1;j++)
				{
						btns[i-1][j-1].setBackground(Color.white);
				}
			}
			mycell.change();
			for(int i=1;i<mycell.row+1;i++)
			{
				for(int j=1;j<mycell.col+1;j++)
				{
					if(mycell.cellArray[i][j]==1)
					{
						btns[i-1][j-1].setBackground(Color.black);
						sum++;
					}

				}
			}
			label1.setText("这是第"+num+"代，当前共有"+sum+"个活细胞          ");
		}
		if(e.getSource()==btn3)
		{
			this.setVisible(false);
		}
		if(e.getSource()==btn4)
		{
			new SetUp();
		}

	}
	public static void main(String args[])
	{
		new ui(10,10);
	}
	
}
