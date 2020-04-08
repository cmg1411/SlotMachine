package slotM;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPan extends JMenuBar{
	JMenu file, help;
	JMenuItem exit, hRule, hInfo;
	
	public MenuPan() {
		file = new JMenu("파일");
		help = new JMenu("도움말");
		
		exit = new JMenuItem("종료");
		hRule = new JMenuItem("게임규칙");
		hInfo = new JMenuItem("slot 정보");
		
		file.add(exit);
		help.add(hRule);
		help.add(hInfo);
		
		super.add(file);
		super.add(help);
	}
}
