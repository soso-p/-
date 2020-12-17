package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ui.MemoCalendar;

class CalendarTab extends JPanel{
	public CalendarTab() {
		
		MemoCalendar mc=new MemoCalendar();
		
		setLayout(new BorderLayout());
		//add(mc.frameSubPanelWest, BorderLayout.WEST);
		add(mc.calOpPanel, BorderLayout.NORTH);
		add(mc.calPanel, BorderLayout.CENTER);
		
		//c.add(mc.frameSubPanelEast, BorderLayout.CENTER);
		JPanel subPanel = new JPanel();
		add(mc.memoPanel, BorderLayout.EAST);
		add(mc.frameBottomPanel, BorderLayout.SOUTH);
		   
		setVisible(true);
		
		
		
	}
	
	
}
