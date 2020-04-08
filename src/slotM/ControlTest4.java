package slotM;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/*프로그래스바 만들기*/
public class ControlTest4 extends JFrame implements ActionListener, Runnable {
	ImageIcon image_slot;
	JButton btn_lever;
	ImageIcon image_up, image_down;

	JPanel btnpan;
	JButton start1, stop1, exit;
	Random rd = new Random();
	ImageIcon image[] = new ImageIcon[7];
	ImageIcon icon;
	Thread aa;
	boolean machine = false;
	boolean progress = false;

	MenuPan mBar = null;

	JProgressBar prog; // 프로그래스바
	int cnt = 0; // 값증가

	ControlTest4(String title) {
		windowMain();
		init();
		setTitle(title);
		setSize(282, 470);
		setVisible(true);
		// 익명중첩클래스-----------------------------------------------
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// -------------------------------------------------------------
	}

	public void init() {
		mBar = new MenuPan();
		super.setJMenuBar(mBar);

		mBar.exit.addActionListener(this);
		mBar.hRule.addActionListener(this);
		mBar.hInfo.addActionListener(this);
	}

	public void windowMain() {
		image_slot = new ImageIcon("slot.jpg");
		image_up = new ImageIcon("up.gif");
		image_down = new ImageIcon("down.gif");
		btn_lever = new JButton(image_up);
		//slotIcon(); // 랜덤하게 이미지 찾기

		JPanel pic = new JPanel() {
			public void paint(Graphics g) {
				// --------------슬롯 이미지 넣기----------------
				g.drawImage(image_slot.getImage(), 0, 0, this);
				if(machine) {
					slotIcon();
					g.drawImage(icon.getImage(), 60, 50, this);
					slotIcon();
					g.drawImage(icon.getImage(), 110, 50, this);
					slotIcon();
					g.drawImage(icon.getImage(), 165, 50, this);
					slotIcon();
					g.drawImage(icon.getImage(), 60, 95, this);
					slotIcon();
					g.drawImage(icon.getImage(), 110, 95, this);
					slotIcon();
					g.drawImage(icon.getImage(), 165, 95, this);
					slotIcon();
					g.drawImage(icon.getImage(), 60, 140, this);
					slotIcon();
					g.drawImage(icon.getImage(), 110, 140, this);
					slotIcon();
					g.drawImage(icon.getImage(), 165, 140, this);
				}
			}
		};
		// 시작,정지,종료버튼만들기---------------------------------------
		btnpan = new JPanel();
		start1 = new JButton("시작");
		stop1 = new JButton("정지");
		exit = new JButton("초기화");
		start1.addActionListener(this);
		stop1.addActionListener(this);
		exit.addActionListener(this);
		btnpan.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnpan.add(start1);
		btnpan.add(stop1);
		btnpan.add(exit);

		// 이미지버튼만들기------------------------------------------------
		btn_lever.setBorder(null);
		btn_lever.addActionListener(this);
		// 레버에 마우스를 클릭하면 이미지가변함(레버가 내려감)
		btn_lever.setPressedIcon(image_down);

		// 프로그래스바-----------------------------------------------------
		prog = new JProgressBar();
		prog.setMinimum(0); // 범위 0~100
		prog.setMaximum(100);
		prog.setValue(0); // 현재위치 : 0

		// 배치하기-------------------------------------------------------
		setLayout(null);
		pic.setBounds(0, 0, 270, 300);
		btn_lever.setBounds(220, 230, 42, 42);
		btnpan.setBounds(30, 350, 300, 100);
		prog.setBounds(7, 278, 250, 20);

		add(btn_lever);
		add(pic);
		add(btnpan);
		add(prog);
	}

	public void slotIcon() {
		image[0] = new ImageIcon("icon1.gif");
		image[1] = new ImageIcon("icon2.gif");
		image[2] = new ImageIcon("icon3.gif");
		image[3] = new ImageIcon("icon4.gif");
		image[4] = new ImageIcon("icon5.gif");
		image[5] = new ImageIcon("icon6.gif");
		image[6] = new ImageIcon("icon7.gif");

		icon = image[rd.nextInt(7)];
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		
		if (e.getSource() == mBar.exit) {
			int n=JOptionPane.showConfirmDialog(this, 
				    "종료하시겠습니까?",
				    "종료",
				    JOptionPane.YES_NO_OPTION,
				    JOptionPane.QUESTION_MESSAGE);
			if(n==JOptionPane.YES_OPTION){
				System.exit(0);
			}
		} else if (e.getSource() == mBar.hRule) {
			GameRule gr=new GameRule(this,"게임 규칙",true);
			gr.setBounds(300,300,400,150);
			gr.setVisible(true);
		} else if (e.getSource() == mBar.hInfo) {
			VerDlg vd = new VerDlg(this,"업데이트 정보",true);
        	vd.setBounds(300,300,200,150);
        	vd.setVisible(true);
		} else {
			if (ob == start1) {
				if (machine == false) {
					machine = true;
					aa = new Thread(this);
					aa.start();
				}
				aa.resume(); // 재가동
			}
			if (ob == stop1) {
				aa.suspend(); // 일시정지
			}
			if(ob == exit) {
				cnt = 0;
				machine = false;
				aa.suspend();
				prog.setValue(0);
			}
			if (ob == btn_lever) {
				cnt = 0;
				if (machine == false) {
					machine = true;
					aa = new Thread(this);
					aa.start();
				}
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public void run() {
		// 프로그래스바-----------------------------------
		while (machine == true) {
			if (cnt < 100) {
				cnt++;
				prog.setValue(cnt);
				slotIcon(); // 이미지 회전-----------------------------------
				repaint(); //paint()메소드호출
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}

	public static void main(String[] args) {
		new ControlTest4("슬롯머신");
	}
}
