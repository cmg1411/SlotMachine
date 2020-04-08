package MouseTest;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

class MouseMove extends JFrame implements MouseListener, MouseMotionListener{
	private int x=50,y=50;
	
	public MouseMove() {
		super("���콺 �����ϱ�");
		
		super.setBounds(250, 150, 300, 400);
		super.setVisible(true);
		
		super.addMouseListener(this);
		super.addMouseMotionListener(this);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		super.addWindowListener(new WindowExit());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("X��ǥ:"+x +"\t   Y��ǥ:" + y, 50,50);
	}

	// MouseListener---------------------------------------
	@Override
	public void mouseClicked(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		
		repaint();   // update() --> repaint()
		             // ��ȿȭ                 ����
		
		System.out.println("MOUSE CLICKED");
		System.out.println(x+"  "+y);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("MOUSE IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("MOUSE OUT");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("MOUSE PRESS");   // ���콺�� Ŭ��
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("MOUSE RELEASE"); // ���콺 Ŭ������ ���� �� ����
	}

	// MouseMotionListener---------------------------------------
	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.println("MOUSE CLICK DRAG"); // ���콺�� Ŭ���� ���¿��� �巡��
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//x=e.getX();
		//y=e.getY();
		
		repaint();
		
		//System.out.println("MOUSE DRAG");       // ���콺 �巡��		
	}
}
public class MouseEx {
	public static void main(String[] args) {
		new MouseMove();
	}
}

