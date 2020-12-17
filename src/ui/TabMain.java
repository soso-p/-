package ui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import ui.CalendarTab;
import ui.HouseKeepingPage;

public class TabMain extends JFrame{

	   JTabbedPane t = new JTabbedPane();  //JTabbedPane생성
	        
	   public TabMain() {  //생성자
	       setTitle("나의 일정과 가계부");
	       
	       t.add("캘린더", new CalendarTab()); 
	       
	       t.add("가계부", new HouseKeepingPage());
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