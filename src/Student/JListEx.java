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
		String[] listData= {"���","��","����","�ٳ���","������"};
		JList<String> list1=new JList<>(listData);
		list1.setSelectedIndex(1);
		
		//2-----------
		JList<String> list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model = (DefaultListModel<String>)list2.getModel();
		JScrollPane scroll = new JScrollPane(list2);
		model.addElement("���");	model.addElement("��");
		model.addElement("����");	model.addElement("�ٳ���");
		model.addElement("������");
		model.addElement("�޷�");
		model.addElement("����");
		model.addElement("����");
		model.addElement("�丶��");
		list2.setSelectedIndex(1);

		//3------------
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll2 = new JScrollPane(list3);
		vListData.add("�౸");	vListData.add("�߱�");
		vListData.add("��");	vListData.add("�豸");
		vListData.add("�״Ͻ�");	vListData.add("����");	
		vListData.add("����");	vListData.add("�±ǵ�");
		vListData.add("����");

		//4------------
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		model2.addElement(new Student("100", "ȫ�浿", "�����"));
		model2.addElement(new Student("200", "�տ���", "�����"));
		model2.addElement(new Student("300", "�����", "����"));
		model2.addElement(new Student("400", "���Ȱ�", "�濵��"));
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




