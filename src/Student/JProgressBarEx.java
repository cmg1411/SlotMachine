package Student;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class JProgressBarEx extends JFrame implements ActionListener,Runnable{
	private JProgressBar jBar=new JProgressBar(JProgressBar.HORIZONTAL,0,100);
	private JButton jbt1=new JButton("시작");
	private JButton jbt2=new JButton("멈춤");
	
	private boolean sign=true;
	private int check;
	
	public JProgressBarEx() {
		super("Test");
		
		jBar.setStringPainted(true);
		jBar.setString("0%");
		
		JPanel jp=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(jbt1);
		jp.add(jbt2);
		
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North",new JLabel("이것이 프로그래스바 이다"));
		con.add("Center",jBar);
		con.add("South",jp);
		
		super.setSize(300,150);
		super.setVisible(true);
		//-----------------------------------
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbt1) { //시작버튼
			sign=true;
			new Thread(this).start();
			jbt1.setEnabled(false);  //시작버튼(비활성화)
			jbt2.setEnabled(true);   //멈춤버튼(활성화)
		}else if(e.getSource()==jbt2){   //멈춤버튼
			sign=false;
			jbt1.setEnabled(true);
			jbt2.setEnabled(false);
		}
	}

	@Override
	public void run() {
		if(check==100) check=0;
		
		for(int i=check; i<=100; i++) {
			if(!sign)
				break;
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			jBar.setValue(i);
			check=i;
			jBar.setString(i+"%");
		}
		jbt1.setEnabled(true);
		jbt2.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new JProgressBarEx();
	}
}





