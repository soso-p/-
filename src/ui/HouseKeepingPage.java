package ui;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import java.util.Calendar;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

class HouseKeepingPage extends JPanel {
	@SuppressWarnings({ "unused", "static-access" })
	
	int incomeTableNo = 0;
	int spendingTableNo = 0;
	Calendar today=Calendar.getInstance();
	
	public HouseKeepingPage() {
		// 각 위치마다 넣을 패널
		JPanel sub1 = new JPanel();
		JPanel sub2 = new JPanel();
		JPanel sub3 = new JPanel();

		sub1.setBackground(Color.white);
		sub2.setBackground(Color.white);
		sub3.setBackground(Color.white);
		
		sub2.setSize(300, 200);
		sub3.setSize(300, 200);
		
		GridBagConstraints gbc[] = new GridBagConstraints[4];
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		for(int i=0;i<gbc.length;i++) {
			gbc[i] = new GridBagConstraints();
			gbc[i].insets = new Insets(5, 10, 10, 5);
		}
		// 메인 패널에 위치에 맞게 요소가 들어갈 패널 넣기
		gbc[0].gridx=0;
		gbc[0].gridy=0;
		gbc[0].gridwidth=1;
		gbc[0].gridheight=2;
		gbc[0].weighty=1;
		gbc[0].insets = new Insets(5, 50, 10, 5);
		gbc[0].fill = GridBagConstraints.HORIZONTAL;
		add(sub1, gbc[0]);
		
		gbc[1].gridx=1;
		gbc[1].gridy=0;
		gbc[1].fill = GridBagConstraints.BOTH;
		gbc[1].gridwidth=1;
		gbc[1].gridheight=1;
		gbc[1].weightx=1;
		gbc[1].weighty=0.1;
		add(sub2, gbc[1]);
		
		gbc[2].gridx=1;
		gbc[2].gridy=1;
		gbc[2].gridwidth=1;
		gbc[2].gridheight=1;
		gbc[2].weightx=1;
		gbc[2].weighty=0.1;
		gbc[2].fill = GridBagConstraints.BOTH;
		add(sub3, gbc[2]);
		
		// 가계부 입력할 패널
		sub1.setLayout(new BorderLayout());
		// 날짜 선택 패널 (North)
		ImageIcon icon1 = new ImageIcon("img/tong.png");
		Image now1 = icon1.getImage();  //ImageIcon�쓣 Image濡� 蹂��솚.
		Image ne1 = now1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon calculator = new ImageIcon(ne1);
		
		JLabel jname = new JLabel("[가계부 입력]",calculator, SwingConstants.LEFT);
		jname.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Color color=new Color(40,54,146);
		jname.setForeground(color);
		jname.setBackground(Color.white);
		
		JPanel dayTextPanel = new JPanel();
		dayTextPanel.setBackground(Color.white);
		JPanel dayButtonPanel = new JPanel();
		dayButtonPanel.setBackground(Color.white);
		dayButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JButton dayButton = new JButton("확인");
		dayTextPanel.setLayout(new BorderLayout());
		dayTextPanel.setBackground(Color.white);
		JTextField yearText = new JTextField(15);
		
		dayButtonPanel.add(yearText);
		dayButtonPanel.add(dayButton);
		dayTextPanel.add(jname, BorderLayout.NORTH);
		dayTextPanel.add(dayButtonPanel, BorderLayout.SOUTH);
		
		// 가계부 입력 패널 (Center)
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.white);
		inputPanel.setLayout(new GridLayout(7, 2));
		JLabel names[] = new JLabel[7];
		names[0] = new JLabel("	- 날	     짜");
		names[1] = new JLabel(today.get(Calendar.YEAR)+"-"+(today.get(Calendar.MONTH)+1)+"-"+today.get(Calendar.DATE)); // 바꾸기
		names[2] = new JLabel("	- 구	     분");
		names[3] = new JLabel("	- 항	     목");
		names[4] = new JLabel("	- 내	     역");
		names[5] = new JLabel("	- 결제 수단");
		names[6] = new JLabel("	- 금	     액");
		String categorySpending[] = {"교통", "식비", "여가", "음료/간식"};
		JComboBox<String> categoryBox = new JComboBox<String>(categorySpending);
		JTextField contentText = new JTextField(20);
		JTextField costText = new JTextField(20);
		
		// 수입 지출을 구분할 패널
		ButtonGroup group1=new ButtonGroup();
		
		JPanel radioPanel1 = new JPanel();
		radioPanel1.setBackground(Color.white);
		JRadioButton incomeButton = new JRadioButton("수입", false);
		JRadioButton spendingButton = new JRadioButton("지출", true);
		
		group1.add(incomeButton);
		group1.add(spendingButton);
		
		radioPanel1.add(incomeButton);
		radioPanel1.add(spendingButton);
		incomeButton.setBackground(Color.white);
		spendingButton.setBackground(Color.white);
		
		// 결제 수단을 구분할 패널
		ButtonGroup group2=new ButtonGroup();
		
		JPanel radioPanel2 = new JPanel();
		radioPanel2.setBackground(Color.white);
		JRadioButton cashButton = new JRadioButton("현금", false);
		JRadioButton cardButton = new JRadioButton("카드", true);
		
		group2.add(cashButton);
		group2.add(cardButton);
		
		radioPanel2.add(cashButton);
		radioPanel2.add(cardButton);
		cashButton.setBackground(Color.white);
		cardButton.setBackground(Color.white);
		
		// 컴포넌트 추가
		for(int i=0;i<3;i++)
			inputPanel.add(names[i]);
		inputPanel.add(radioPanel1);
		inputPanel.add(names[3]);
		inputPanel.add(categoryBox);
		inputPanel.add(names[4]);
		inputPanel.add(contentText);
		inputPanel.add(names[5]);
		inputPanel.add(radioPanel2);
		inputPanel.add(names[6]);
		inputPanel.add(costText);
		
		// 입력, 삭제 버튼 (South)
		JPanel inDelButtonPanel = new JPanel();
		inDelButtonPanel.setBackground(Color.white);
		JButton inputButton = new JButton("입력");
		JButton savingButton = new JButton("저장");// 입력버튼 눌리면 테이블 읽어서 저장하고 파일에 추가된 내용이랑 쓰기, 테이블에 다시 쓰기 // 테이블 쓰기 메소드
		JButton deleteInButton = new JButton("수입 삭제");
		JButton deleteSpButton = new JButton("지출 삭제");// 삭제버튼 눌리면 파일아예 삭제하고 테이블 다시 받아서 쓰기
		inDelButtonPanel.add(inputButton);
		inDelButtonPanel.add(savingButton);
		inDelButtonPanel.add(deleteInButton);
		inDelButtonPanel.add(deleteSpButton);
		
		// sub1에 추가
		sub1.add(dayTextPanel, BorderLayout.NORTH);
		sub1.add(inputPanel, BorderLayout.CENTER);
		sub1.add(inDelButtonPanel, BorderLayout.SOUTH);
		sub1.setPreferredSize(new Dimension(350, 350));
		
		// 일별 내역
		// 수입 내역 패널 (sub2)
		JPanel incomeDetailPanel = new JPanel();
		incomeDetailPanel.setBackground(Color.white);
		incomeDetailPanel.setLayout(new BorderLayout());
		
		ImageIcon icon2 = new ImageIcon("img/money.png");
		Image now2 = icon2.getImage();
		Image ne2 = now2.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon money = new ImageIcon(ne2);
		
		JLabel incomeDetailLabel = new JLabel("[수입내역]",money, SwingConstants.LEFT);
		incomeDetailLabel.setFont(new Font("맑은 고딕",Font.BOLD,15));
		incomeDetailLabel.setForeground(color);
		
		String incomeHeader[] = {"NO", "항목", "내역", "결제수단", "금액"};
		String incomeContents[][] = {}; // 나중에 파일 입력으로 바꾸기
		DefaultTableModel model1=new DefaultTableModel(incomeContents,incomeHeader);
		JTable incomeTable = new JTable(model1);
		JScrollPane scrollpane = new JScrollPane(incomeTable);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(400, 200));
		incomeDetailPanel.add(incomeDetailLabel, BorderLayout.NORTH);
		incomeDetailPanel.add(scrollpane, BorderLayout.CENTER);
		sub2.add(incomeDetailPanel);
		
		// 지출 내역 패널 (sub3)
		ImageIcon icon3 = new ImageIcon("img/sad.png");
		Image now3 = icon3.getImage(); 
		Image ne3 = now3.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon sad = new ImageIcon(ne3); 
		
		JPanel spendingDetailPanel = new JPanel();
		spendingDetailPanel.setBackground(Color.white);
		spendingDetailPanel.setLayout(new BorderLayout());
		JLabel spendingDetailLabel = new JLabel("[지출내역]",sad, SwingConstants.LEFT);
		spendingDetailLabel.setFont(new Font("맑은 고딕",Font.BOLD,15));
		spendingDetailLabel.setForeground(color);
		
		String spendingHeader[] = {"NO", "항목", "내역", "결제수단", "금액"};
		String spendingContents[][] = {}; // 나중에 파일 입력으로 바꾸기, 전역변수로 바꾸고 파일에서 입력해온걸 계속 저장하기
		DefaultTableModel model2=new DefaultTableModel(spendingContents,spendingHeader);
		JTable spendingTable = new JTable(model2);
		JScrollPane scrollpane2 = new JScrollPane(spendingTable);
		scrollpane2.setPreferredSize(new Dimension(400, 200));
		scrollpane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spendingDetailPanel.add(spendingDetailLabel, BorderLayout.NORTH);
		spendingDetailPanel.add(scrollpane2, BorderLayout.CENTER);
		sub3.add(spendingDetailPanel);
		
		// 테이블 데이터 추가
		fileToTable(model1, model2, names[1].getText());
		
		// 메인 프레임에 넣기
		setBackground(Color.white);
		
		// 확인 버튼이랑 날짜 입력 텍스트 패널 이벤트
		dayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day = yearText.getText();
				names[1].setText(day);
				DefaultTableModel model=(DefaultTableModel)incomeTable.getModel();
				model.setNumRows(0);
				model = (DefaultTableModel)spendingTable.getModel();
				model.setNumRows(0);
				incomeTableNo = 0;
				spendingTableNo = 0;
				fileToTable(model1, model2, day);
			}
		});
		yearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day = yearText.getText();
				names[1].setText(day);
				DefaultTableModel model=(DefaultTableModel)incomeTable.getModel();
				model.setNumRows(0);
				model = (DefaultTableModel)spendingTable.getModel();
				model.setNumRows(0);
				incomeTableNo = 0;
				spendingTableNo = 0;
				fileToTable(model1, model2, day);
			}
		});
		
		// 가계부 입력 이벤트
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (incomeButton.isSelected()) {
					String data[] = new String[5];
					data[0] = Integer.toString(++incomeTableNo);
					data[1] = categoryBox.getSelectedItem().toString();
					data[2] = contentText.getText();
					if (data[2].equals(null))
						data[2]="";
					if (cashButton.isSelected())
						data[3] = cashButton.getText();
					else
						data[3] = cardButton.getText();
					data[4] = costText.getText();
					if (data[4].equals(null))
						data[4]="";
					model1.addRow(data);
				}
				else if (spendingButton.isSelected()) {
					String data[] = new String[5];
					data[0] = Integer.toString(++spendingTableNo);
					data[1] = categoryBox.getSelectedItem().toString();
					data[2] = contentText.getText();
					if (data[2].equals(null))
						data[2]="";
					if (cashButton.isSelected())
						data[3] = cashButton.getText();
					else
						data[3] = cardButton.getText();
					data[4] = costText.getText();
					if (data[4].equals(null))
						data[4]="";
					model2.addRow(data);
				}
			}
		});
		
		// 수입 삭제 버튼 이벤트
		deleteInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (incomeTable.getSelectedRow() != -1) {
					int rowCount = model1.getRowCount(); // getRowCount와 getSelectedRowCount는 1부터 시작하지만
					int selectRowCount = incomeTable.getSelectedRowCount();
					for (int i = selectRowCount;i<rowCount;i++) {
						incomeTable.setValueAt((i)+"", i, 0); // setValueAt는 행이 0번부터 시작
					}
					incomeTableNo--;
					model1.removeRow(incomeTable.getSelectedRow());
				}
			}
		});
		
		// 지출 삭제 버튼 이벤트
		deleteSpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (spendingTable.getSelectedRow() != -1) {
					int rowCount = model2.getRowCount(); // getRowCount와 getSelectedRowCount는 1부터 시작하지만
					int selectRowCount = spendingTable.getSelectedRowCount();
					for (int i = selectRowCount;i<rowCount;i++) {
						spendingTable.setValueAt((i)+"", i, 0); // setValueAt는 행이 0번부터 시작
					}
					spendingTableNo--;
					model2.removeRow(spendingTable.getSelectedRow());
				}
			}
		});
		
		// 저장 버튼 이벤트
		savingButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					File f= new File("TableData");
					if(!f.isDirectory()) f.mkdir(); // 폴더가 없으면 생성
					// 테이블에 데이터가 없으면 파일 삭제
					if (model1.getRowCount()!=0) {
						// 수입 테이블 파일 출력
						BufferedWriter out1 = new BufferedWriter(new FileWriter("TableData/"+names[1].getText()+"_Income.txt"));
						for(int i=0;i<model1.getRowCount();i++) {
							String input;
							for(int j=0;j<incomeTable.getColumnCount();j++) {
								input=(String)incomeTable.getValueAt(i, j); // 한 행의 한 열씩 받아옴
								
								out1.write(input); // 파일에 입력
								out1.write("\t"); // 구분자 입력
							}
							out1.write("\n");
						}
						out1.close();
					}
					else {
						File fI = new File("TableData/"+names[1].getText()+"_Income.txt");
						if (fI.exists())
							fI.delete();
					}
					// 지출 테이블 데이터가 없으면 파일 삭제
					if (model2.getRowCount()!=0) {
						// 지출 테이블 파일 출력
						BufferedWriter out2 = new BufferedWriter(new FileWriter("TableData/"+names[1].getText()+"_Spending.txt"));
						for(int i=0;i<model2.getRowCount();i++) {
							String input;
							
							for(int j=0;j<model2.getColumnCount();j++) {
								input=(String)spendingTable.getValueAt(i, j); // 한 행의 한 열씩 받아옴
						
								out2.write(input); // 파일에 입력
								out2.write("\t"); // 구분자 입력
							}
							out2.write("\n");
						}
						out2.close();
					}
					else {
						File fS = new File("TableData/"+names[1].getText()+"_Spending.txt");
						if (fS.exists())
							fS.delete();
					}
				} catch (IOException oe) {
					//System.out.println("입출력 오류..."); // 시간되면 새로 창 띄우는걸로
				}
			}					
		});
		
		// 수입 라디오 버튼 이벤트 // 콤보 박스 변경
		incomeButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String categoryIncome[] = {"급여", "금융수입", "기타"};
				categoryBox.removeAllItems();
				for (int i=0;i<categoryIncome.length;i++)
					categoryBox.addItem(categoryIncome[i]);
			}
		});
		
		// 지출 라디오 버튼 이벤트 // 콤보 박스 변경
		spendingButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				categoryBox.removeAllItems();
				for (int i=0;i<categorySpending.length;i++)
					categoryBox.addItem(categorySpending[i]);
			}
		});
	}
	
	public void fileToTable(DefaultTableModel modelIncome, DefaultTableModel modelSpending, String day) {
		// 수입 테이블 파일에서 읽어오기
		File f1 = new File("TableData/"+day+"_Income.txt");
		if (f1.exists()) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(f1));
				String data;
				while((data=in.readLine())!=null) { // 읽어온 데이터가 없을 때까지 반복
					StringTokenizer st = new StringTokenizer(data, "\t\n");
					String dataArray[] = new String[5];
					int i = 0;
					while (st.hasMoreTokens()) {
						dataArray[i] = st.nextToken();
						i++;
					}
					modelIncome.addRow(dataArray);
					incomeTableNo++;
				}
				in.close();
			}
			catch (IOException e) {}
		}
		
		// 지출 테이블 파일에서 읽어오기
		f1 = new File("TableData/"+day+"_Spending.txt");
		if (f1.exists()) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(f1));
				String data;
				while((data=in.readLine())!=null) { // 읽어온 데이터가 없을 때까지 반복
					StringTokenizer st = new StringTokenizer(data, "\t\n");
					String dataArray[] = new String[5];
					int i = 0;
					while (st.hasMoreTokens()) {
						dataArray[i] = st.nextToken();
						i++;
					}
					modelSpending.addRow(dataArray);
					spendingTableNo++;
				}
				in.close();
			}
			catch (IOException e) {}
		}
	}
}



