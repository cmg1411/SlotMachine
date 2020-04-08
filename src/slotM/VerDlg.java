package slotM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VerDlg extends JDialog implements ActionListener {
	JButton btn;

	public VerDlg(JFrame parent, String title, boolean mode) {
		super(parent, title, false);
		this.setResizable(false); // 사이즈 고정

		// 중앙 패널
		JPanel pn1 = new JPanel();
		JLabel lb1 = new JLabel("Version 1.0");
		JLabel lb2 = new JLabel("제작자 : 김민걸");
		JLabel lb3 = new JLabel("2020 / 03 / 29");

		pn1.setLayout(null);
		lb1.setBounds(30, 0, 100, 50);
		lb2.setBounds(30, 15, 100, 50);
		lb3.setBounds(30, 30, 100, 50);
		pn1.add(lb1);
		pn1.add(lb2);
		pn1.add(lb3);

		// 아래 패널
		JPanel pn2 = new JPanel();
		btn = new JButton("확인");
		pn2.add(btn);

		// 배치
		super.add("Center", pn1);
		super.add("South", pn2);

		// 이벤트 처리
		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn)
			this.dispose();
	}
}
