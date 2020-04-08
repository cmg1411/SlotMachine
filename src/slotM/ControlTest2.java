package slotM;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*이미지 버튼 만들기*/
public class ControlTest2 extends JFrame implements ActionListener{
	ImageIcon image_slot;
	JButton btn_lever;
	ImageIcon image_up, image_down;
	
	public ControlTest2() {
		windowMain();
		setSize(500,500);
		setVisible(true);	
	}
	
	public void windowMain() {
		image_slot = new ImageIcon("slot.jpg");
		image_up = new ImageIcon("up.gif");
		image_down = new ImageIcon("down.gif");
		btn_lever = new JButton(image_up);
		
		
		JPanel pic = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(image_slot.getImage(), 0, 0, this);
			}
		};
		btn_lever.setBorder(null);
		add(btn_lever);
		add(pic);
		
		btn_lever.addActionListener(this);
		btn_lever.setPressedIcon(image_down);
		btn_lever.setBounds(400,300,42,42);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new ControlTest2();
	}
}
