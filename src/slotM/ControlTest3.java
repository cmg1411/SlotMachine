package slotM;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*아이콘 랜덤하게 돌리기*/
public class ControlTest3 extends JFrame implements ActionListener, Runnable {
	ImageIcon image_slot;
	JButton btn_lever;
	ImageIcon image_up, image_down;

	JPanel btnpan;
	JButton start1, stop1, exit;
	Random ran = new Random();
	ImageIcon image[] = new ImageIcon[7];
	ImageIcon icon;
	Thread aa = new Thread(this);
	boolean machine = false;

	ControlTest3() {
		windowMain();
		setSize(282, 450);
		setVisible(true);
	}

	public void windowMain() {
		image_slot = new ImageIcon("slot.jpg");
		image_up = new ImageIcon("up.gif");
		image_down = new ImageIcon("down.gif");
		btn_lever = new JButton(image_up);
		slotIcon(); // 랜덤하게 이미지고르기

		JPanel pic = new JPanel() {
			public void paint(Graphics g) {
				// ---------- 슬롯 이미지 넣기 ----------------
				g.drawImage(image_slot.getImage(), 0, 0, this);
				g.drawImage(icon.getImage(), 150, 200, this);
			}
		};

		// 시작,정지,종료버튼만들기-----------------
		btnpan = new JPanel();
		start1 = new JButton("시작");
		stop1 = new JButton("정지");
		exit = new JButton("종료");

		btnpan.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnpan.add(start1);
		btnpan.add(stop1);
		btnpan.add(exit);

		start1.addActionListener(this);
		stop1.addActionListener(this);
		exit.addActionListener(this);

		// 이미지버튼만들기------------------------
		btn_lever.setBorder(null);
		btn_lever.addActionListener(this);
		// 레버에 마우스 클릭하면 이미지 변함(레버 내려간 이미지)
		btn_lever.setPressedIcon(image_down);

		// 배치하기-------------------------------------------------------
		setLayout(null);
		pic.setBounds(0, 0, 270, 300);
		btn_lever.setBounds(220, 230, 42, 42);
		btnpan.setBounds(30, 350, 300, 100);

		add(btn_lever);
		add(pic);
		add(btnpan);
	}

	public void slotIcon() {
		image[0] = new ImageIcon("icon1.gif");
		image[1] = new ImageIcon("icon2.gif");
		image[2] = new ImageIcon("icon3.gif");
		image[3] = new ImageIcon("icon4.gif");
		image[4] = new ImageIcon("icon5.gif");
		image[5] = new ImageIcon("icon6.gif");
		image[6] = new ImageIcon("icon7.gif");

		icon = image[ran.nextInt(7)];
	}

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == start1) {
			if (machine == false) {
				machine = true;
				aa.start();
			}
			aa.resume();
		}
		if (ob == stop1) {
			aa.suspend();
		}
	}

	public void run() {
		while (machine == true) {
			slotIcon();
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		new ControlTest3();
	}
}
