package slotM;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*슬롯머신 이미지 붙이기*/
public class ControlTest1 extends JFrame{
	ImageIcon image_slot;
	
	public ControlTest1() {
		windowMain();
		setSize(500,500);
		setVisible(true);
	}
	
	public void windowMain() {
		image_slot = new ImageIcon("slot.jpg");
		JPanel pic = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(image_slot.getImage(),0,0,this);
			}
		};
		add(pic);
	}
	
	public static void main(String[] args) {
		new ControlTest1();
	}
}

