package slotM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameRule extends JDialog implements ActionListener {
	JButton btn;

	public GameRule(JFrame parent, String title, boolean mode) {
		super(parent, title, false);
		this.setResizable(false);

		
		JPanel pn1 = new JPanel();
		JLabel lb1 = new JLabel("1.기본값은 2000으로 한다");
		JLabel lb2 = new JLabel("2.한줄 맞으면 +200 하나도 안맞으면 -500으로 함");
		JLabel lb3 = new JLabel("3.코인이 0개면 메세지박스를 띄워서 종료를 알림");

		pn1.setLayout(null);
		lb1.setBounds(30, 0, 300, 50);
		lb2.setBounds(30, 15, 300, 50);
		lb3.setBounds(30, 30, 300, 50);
		pn1.add(lb1);
		pn1.add(lb2);
		pn1.add(lb3);

		
		JPanel pn2 = new JPanel();
		btn = new JButton("확인");
		pn2.add(btn);

		
		super.add("Center", pn1);
		super.add("South", pn2);

		
		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn)
			this.dispose();
	}
}
