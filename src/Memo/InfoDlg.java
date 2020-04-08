package Memo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InfoDlg extends JDialog implements ActionListener{
	JButton ok;
	
	public InfoDlg(JFrame parent, String title, boolean model) {
		super(parent,title,model);
		this.setResizable(false);
		
		//중앙패널
		JPanel pn1=new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Toolkit t=Toolkit.getDefaultToolkit();
				Image img=t.getImage("pinkpink.png");
				g.drawImage(img,20,15,this);
			}
		};		
		//아래패널
		JPanel pn2=new JPanel();
		ok=new JButton("확인");
		pn2.add(ok);
		
		//배치
		super.add(pn1,"Center");
		super.add(pn2,"South");
		
		//이벤트 등록
		ok.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok) {
			this.dispose();  //현재창 닫기
		}
	}
}
