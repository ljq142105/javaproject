package LifeGame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetUp extends JFrame implements ActionListener{
	private JTextField row;
	private JTextField col;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btn1;
	public SetUp() {
		setBounds(new Rectangle(0, 0, 450, 300));
		setTitle("\u8BBE\u7F6E\u754C\u9762");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 24, 393, 202);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u884C\u53F7\uFF1A");
		lblNewLabel.setBounds(80, 46, 77, 29);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5217\u53F7\uFF1A");
		lblNewLabel_1.setBounds(80, 110, 77, 29);
		panel.add(lblNewLabel_1);
		
		row = new JTextField();
		row.setBounds(183, 50, 102, 21);
		panel.add(row);
		row.setColumns(10);
		
		col = new JTextField();
		col.setBounds(183, 114, 102, 21);
		panel.add(col);
		col.setColumns(10);
		
		btn1 = new JButton("\u786E\u5B9A");
		btn1.setBounds(150, 169, 97, 23);
		btn1.addActionListener(this);
		panel.add(btn1);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1)
		{
			int a1 = 0;
			int a2 = 0;
			try {
			String a=row.getText();
			String b=col.getText();
			a1=Integer.parseInt(a);
			a2=Integer.parseInt(b);
			}catch(Exception er) {
				JOptionPane.showMessageDialog(null,"请输入正确的数字");
				//er.printStackTrace();
			}
			this.setVisible(false);
			if(a1<=0||a2<=0)
				JOptionPane.showMessageDialog(null,"请输入正确的数字");
			else
			new ui(a1,a2);
		}
		
	}
}
