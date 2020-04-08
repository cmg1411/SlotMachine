package Memo;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPane extends JMenuBar{
	JMenu file, edit, help;
	JMenuItem fNew, fOpen, fSave, fExit;
	JMenuItem eCut,eCopy,ePaste;
	JMenuItem hInfo, hVer;  //메모장 정보, 버전정보
	
	public MenuPane() {
		file=new JMenu("파일");
		edit=new JMenu("편집");
		help=new JMenu("도움말");
		
		fNew=new JMenuItem("새로만들기");
		fOpen=new JMenuItem("열기");
		fSave=new JMenuItem("저장");
		fExit=new JMenuItem("종료");
		
		eCut=new JMenuItem("잘라내기");
		eCopy=new JMenuItem("복사하기");
		ePaste=new JMenuItem("붙여넣기");
		
		hInfo=new JMenuItem("메모장 정보");
		hVer=new JMenuItem("버전정보");
		
		file.add(fNew);  file.add(fOpen);  file.add(fSave);  file.addSeparator();  file.add(fExit);  
		edit.add(eCut);  edit.add(eCopy);  edit.add(ePaste);
		help.add(hInfo); help.add(hVer);
		
		super.add(file);
		super.add(edit);
		super.add(help);
	}
}














