package MouseTest;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ImageMove extends JFrame implements ActionListener{
	private int x=150, y=150;
	JTextField xT,yT;
	JButton leftB,upB,downB,rightB,newB;
	
	public ImageMove(String title) {
		init();
		super.setTitle(title);
		super.setBounds(250, 80, 500, 500);
		super.setVisible(true);
		super.addWindowListener(new WindowExit());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image img=Toolkit.getDefaultToolkit().getImage("pinkpink.png");
		g.drawImage(img, x, y, this);
	}

	public void init() {
		//좌표 출력------------------------------------------
		JLabel xL=new JLabel("X: ");
		JLabel yL=new JLabel("Y: ");
		
		xT=new JTextField(Integer.toString(x), 10);
		yT=new JTextField(Integer.toString(y), 10);
		
		JPanel north=new JPanel();
		north.add(xL);
		north.add(xT);
		north.add(yL);
		north.add(yT);
		
		//방향 출력-----------------------------------------
		leftB=new JButton("←");
		upB=new JButton("↑");
		downB=new JButton("↓");
		rightB=new JButton("→");
		newB=new JButton("초기화");
		
		JPanel south=new JPanel();
		south.add(leftB);
		south.add(upB);
		south.add(downB);
		south.add(rightB);
		south.add(newB);
		
		super.add(north, "North");
		super.add(south, "South");
		
		leftB.addActionListener(this);
		rightB.addActionListener(this);
		upB.addActionListener(this);
		downB.addActionListener(this);
		newB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==leftB)  x-=10;
		else if(e.getSource()==rightB)  x+=10;
		else if(e.getSource()==upB)  y-=10;
		else if(e.getSource()==downB)  y+=10;
		else if(e.getSource()==newB)  x=y=150;
		
		xT.setText(Integer.toString(x));
		yT.setText(Integer.toString(y));
		repaint();
	}
}

public class ImageMoveEx {
	public static void main(String[] args) {
		new ImageMove("핑크 이동하기");
	}
}













