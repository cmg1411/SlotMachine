package clock;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Random;

public class DigitalClock extends Frame implements Runnable{
	
	public DigitalClock(String title) {
		super(title);
		Thread th = new Thread(this);
		super.setBackground(Color.LIGHT_GRAY);
		super.setBounds(150, 150, 300, 150);
		super.setVisible(true);
		th.start();
		
		super.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		Random r = new Random();
		
		int x = r.nextInt(this.getWidth());
		int y = r.nextInt(this.getHeight());
		
		int cr = r.nextInt(256);
		int cg = r.nextInt(256);
		int cb = r.nextInt(256);
		int sh = r.nextInt(2);
		
		g.setColor(new Color(cr, cg, cb));
		if(sh==0) {
			g.fillRect(x, y, r.nextInt(60), r.nextInt(60));
		}else {
			g.fillOval(x, y, r.nextInt(60), r.nextInt(60));
		}
		
		
		//----------------------------------------------------
		Calendar cal = Calendar.getInstance();
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH)+1;
		int dd = cal.get(Calendar.DAY_OF_MONTH);
		int hh = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		
		
		String date = "[³¯Â¥] " + yy + " / " + mm + " / " + dd;
		String time = "[½Ã°£] " + hh + " : " + mi + " : " + ss;
		
		g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 20));
		g.setColor(Color.WHITE);
		
		g.drawString(date, 90, 70);
		g.drawString(time, 90, 100);
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				repaint();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
