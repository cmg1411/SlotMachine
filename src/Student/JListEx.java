package Student;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class JListEx extends JFrame {
	
	public JListEx() {
		super("JList");
		init();
		
		super.setBounds(300,200,500,400);
		super.setVisible(true);
	}
	public void init() {
		//1-----------
		String[] listData= {"사과","배","딸기","바나나","오렌지"};
		JList<String> list1=new JList<>(listData);
		list1.setSelectedIndex(1);
		
		//2-----------
		JList<String> list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model = (DefaultListModel<String>)list2.getModel();
		JScrollPane scroll = new JScrollPane(list2);
		model.addElement("사과");	model.addElement("배");
		model.addElement("딸기");	model.addElement("바나나");
		model.addElement("오렌지");
		model.addElement("메론");
		model.addElement("수박");
		model.addElement("참외");
		model.addElement("토마토");
		list2.setSelectedIndex(1);

		//3------------
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll2 = new JScrollPane(list3);
		vListData.add("축구");	vListData.add("야구");
		vListData.add("농구");	vListData.add("배구");
		vListData.add("테니스");	vListData.add("수영");	
		vListData.add("육상");	vListData.add("태권도");
		vListData.add("유도");

		//4------------
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		model2.addElement(new Student("100", "홍길동", "전산과"));
		model2.addElement(new Student("200", "손오공", "건축과"));
		model2.addElement(new Student("300", "사오정", "토목과"));
		model2.addElement(new Student("400", "저팔계", "경영학"));
		list4.setSelectedIndex(1);

		
		super.setLayout(new FlowLayout());
		super.add(list1);		
		super.add(scroll);
		super.add(scroll2);
		super.add(list4);
	}
	
	public static void main(String[] args) {
		new JListEx();
	}
}




