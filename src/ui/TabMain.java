package ui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import ui.CalendarTab;
import ui.HouseKeepingPage;

public class TabMain extends JFrame{

	   JTabbedPane t = new JTabbedPane();  //JTabbedPane����
	        
	   public TabMain() {  //������
	       setTitle("���� ������ �����");
	       
	       t.add("Ķ����", new CalendarTab()); 
	       
	       t.add("�����", new HouseKeepingPage());
	       add(t);
	       
	       
	       setSize(1000, 600);
	       setLocationRelativeTo(null);
	       setVisible(true);
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         
	   }
	   public static void main(String[] args){
			new TabMain();
			//new HouseKeepingPage();
		}
}