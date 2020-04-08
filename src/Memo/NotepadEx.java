package Memo;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

class NotePad extends JFrame implements ActionListener{
	MenuPane mBar=null;
	JTextArea note=null;
	
	String filePath, fileName;  //파일경로,파일이름
	
	public NotePad(String title) {
		super(title);
		init();
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void init() {
		mBar=new MenuPane();
		super.setJMenuBar(mBar);
		
		note=new JTextArea();
		JScrollPane scroll=new JScrollPane(note,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//or super.add(scroll,"Center");
		super.getContentPane().add("Center",scroll);
		
		super.setBounds(400,80,600,500);
		super.setVisible(true);
		
		//이벤트 등록---------------------------
		mBar.fExit.addActionListener(this);
		mBar.fNew.addActionListener(this);
		mBar.fOpen.addActionListener(this);
		mBar.fSave.addActionListener(this);
		
		mBar.eCut.addActionListener(this);
		mBar.eCopy.addActionListener(this);
		mBar.ePaste.addActionListener(this);
		
		mBar.hInfo.addActionListener(this);
		mBar.hVer.addActionListener(this);
		
		//단축키(Accelerator)----------------------------
		mBar.eCut.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.ALT_DOWN_MASK)); //ALT+X
		mBar.eCopy.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.ALT_DOWN_MASK)); //ALT+C
		mBar.ePaste.setAccelerator(KeyStroke.getKeyStroke('V',InputEvent.ALT_DOWN_MASK)); //ALT+V
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mBar.fExit) {
			if(!note.getText().equals("")) {
				int n=JOptionPane.showConfirmDialog(this, 
									    "저장 할까요?",
									    "종료",
									    JOptionPane.YES_NO_OPTION,
									    JOptionPane.QUESTION_MESSAGE);
				if(n==JOptionPane.YES_OPTION){
					//System.out.println("저장 작업 진행");
					saveDialog();
				}else {
					System.exit(0);
				}
			}else {
				System.exit(0);
			}
		}
		//-----------------------------------------------------
		if(e.getSource()==mBar.fNew) {
			note.setText("");
			super.setTitle("제목없음 - 메모장");
		}else if(e.getSource()==mBar.fOpen) {
			openDialog();
		}else if(e.getSource()==mBar.fSave) {
			saveDialog();
		}
		//-----------------------------------------------------
		if(e.getSource()==mBar.eCut) {
			note.cut();
		}
        if(e.getSource()==mBar.eCopy) {
			note.copy();
		}
        if(e.getSource()==mBar.ePaste) {
			note.paste();
		}
        //-----------------------------------------------------
        if(e.getSource()==mBar.hInfo) {
        	//모달다이얼로그(Modal Dialog):true
        	InfoDlg infoDlg=new InfoDlg(this,"정보확인",true);
        	infoDlg.setBounds(300,300,200,250);
        	infoDlg.setVisible(true);
        	
        }else if(e.getSource()==mBar.hVer) {
        	//모덜리스다이얼로그(Modeless Dialog):false
        	//JDialog verDlg=new JDialog(this,"버전정보",false);
        	//verDlg.setBounds(300,300,150,150);
        	//verDlg.setVisible(true);
        	
        	VerDlg verDlg=new VerDlg(this,"버전정보",true);
        	verDlg.setBounds(300,300,150,150);
        	verDlg.setVisible(true);
        }
	}
	public void openDialog() {
		//공통 다이얼로그(common dialog-FileDialog)
		FileDialog fdlg=new FileDialog(this,"열기",FileDialog.LOAD);
		fdlg.setVisible(true);

//		JOptionPane.showMessageDialog(this,
//				     fdlg.getDirectory()+fdlg.getFile()); //경로+파일	
		filePath=fdlg.getDirectory();
		fileName=fdlg.getFile();
		
		if(filePath != null && fileName != null) {
			note.setText("");
			
			try {
				File file=new File(filePath+fileName);
				super.setTitle(fileName+" - 메모장");
				BufferedInputStream bis= new BufferedInputStream(
				                         new FileInputStream(file));
				
				byte[] buf=new byte[(int)file.length()];
				bis.read(buf,0,buf.length);
				note.append(new String(buf));
				bis.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void saveDialog() {
		FileDialog fdlg=new FileDialog(this,"다른이름으로 저장",FileDialog.SAVE);
		fdlg.setVisible(true);
		
		filePath=fdlg.getDirectory();  //파일경로
		fileName=fdlg.getFile();       //파일이름
		
		if(filePath != null && fileName != null) {
			try {
				FileWriter fw=new FileWriter(new File(filePath,fileName+".txt"));
				super.setTitle(fileName + ".txt - 메모장");
				
				String buf=note.getText();
				fw.write(buf);
				fw.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
public class NotepadEx {
	public static void main(String[] args) {
		new NotePad("제목없음 - 메모장");
	}
}





