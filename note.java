import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class note extends JFrame implements ActionListener {
JTextArea area;
JScrollPane pane;
String text;
String createfont="Arial";
int fontsize=20;
JButton fontcolor;
Font TimesNewRoman,Arial,ArialBlack;
note(){
	//this.setfont("Arial");
	//fontformate(16);

	this.setTitle("Notepad");
		
	setBounds(0, 0, 1050, 1050);
		
		JMenuBar menubar=new JMenuBar();
		JMenu file=new JMenu("File");
		JMenuItem newdoc=new JMenuItem("New");
		newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		newdoc.addActionListener(this);

		JMenuItem open=new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		open.addActionListener(this);
		
		JMenuItem close=new JMenuItem("Close");
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
		close.addActionListener(this);
		
		JMenuItem save=new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		
		JMenuItem print=new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		print.addActionListener(this);
		
		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(close);

		JMenu edit=new JMenu("Edit");
		
		JMenuItem copy=new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		copy.addActionListener(this);
		
		JMenuItem paste=new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		paste.addActionListener(this);
		
		JMenuItem cut=new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		cut.addActionListener(this);
		
		JMenuItem selectall=new JMenuItem("Select All");
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		selectall.addActionListener(this);
		edit.add(copy);
		edit.add(paste);
		edit.add(cut);
		edit.add(selectall);
		
		JMenu formate=new JMenu("Formate");

		JMenu font=new JMenu("Font.....");
		font.addActionListener(this);
		formate.add(font);
		
		JMenuItem font1=new JMenuItem("Arial Black");
		font1.addActionListener(this);
		font.add(font1);
	
		JMenuItem font2=new JMenuItem("Arial");
		font2.addActionListener(this);
		font.add(font2);
		JMenuItem font3=new JMenuItem("Times New Roman");
		font3.addActionListener(this);
		font.add(font3);
	//	JMenuItem font4=new JMenuItem("Arieal");
		//font1.addActionListener(this);
		//font.add(font4);
	
//	String[] fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();	
	 fontcolor=new JButton("color");
	 fontcolor.addActionListener(this);
	 formate.add(fontcolor);
	JMenu fontSize=new JMenu("Font Size");
		fontSize.addActionListener(this);
		formate.add(fontSize);
		
		JMenuItem fontsize1=new JMenuItem("6");
		fontsize1.addActionListener(this);
		fontSize.add(fontsize1);

		JMenuItem fontsize2=new JMenuItem("8");
		fontsize2.addActionListener(this);
		fontSize.add(fontsize2);

		JMenuItem fontsize3=new JMenuItem("10");
		fontsize3.addActionListener(this);
		fontSize.add(fontsize3);

		JMenuItem fontsize4=new JMenuItem("12");
		fontsize4.addActionListener(this);
		fontSize.add(fontsize4);

		JMenuItem fontsize5=new JMenuItem("14");
		fontsize5.addActionListener(this);
		fontSize.add(fontsize5);

		JMenuItem fontsize6=new JMenuItem("16");
		fontsize6.addActionListener(this);
		fontSize.add(fontsize6);

		JMenuItem fontsize7=new JMenuItem("18");
		fontsize7.addActionListener(this);
		fontSize.add(fontsize7);
	
		JMenuItem fontsize8=new JMenuItem("20");
		fontsize8.addActionListener(this);
		fontSize.add(fontsize8);
	
		
		JMenu help=new JMenu("Help");

		JMenuItem about=new JMenuItem("About the Note++");
		about.addActionListener(this);
		help.add(about);
	
		
		
	menubar.add(file);
	menubar.add(edit);
	menubar.add(formate);
	menubar.add(help);
	setJMenuBar(menubar);

	area=new JTextArea();
	area.setFont(new Font("SAN_SERIF", Font.PLAIN,20));
	area.setLineWrap(true);
	area.setWrapStyleWord(true);
	pane=new JScrollPane(area);
	pane.setBorder(BorderFactory.createEmptyBorder());
	add(pane,BorderLayout.CENTER);
	}

	public void fontformate(int fontSize) {
		fontsize=fontSize;
		TimesNewRoman=new Font("Times New Roman",Font.PLAIN, fontSize);
	Arial=new Font("Arial",Font.PLAIN, fontSize);	
	ArialBlack=new Font("Arial Black",Font.PLAIN, fontSize);
	setfont(createfont);
	}
	

public void setfont(String font) {
	createfont=font;
	//area.setText(font);
	switch(createfont) {
	case "Arial":
	area.setFont(new Font(createfont,Font.PLAIN,fontsize)); 
	break;
	case "Times New Roman":
		area.setFont(new Font(createfont,Font.PLAIN,fontsize));
	break;
	case "Arial Black":
		area.setFont(new Font(createfont,Font.PLAIN,fontsize));
	break;

	
	
	
	
	
	}
	
}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Save")) {
			JFileChooser saveAs=new JFileChooser();
			saveAs.setApproveButtonText("Save");
			int action =saveAs.showOpenDialog(this);
			if(action!=JFileChooser.APPROVE_OPTION) {
				return;
			}
			File filename=new File(saveAs.getSelectedFile()+".txt");
			BufferedWriter outFile=null;
			try {
				outFile=new BufferedWriter(new FileWriter(filename));
				area.write(outFile);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}else if(ae.getActionCommand().equals("New")) {
			area.setText("");
			
		}else if(ae.getActionCommand().equals("Open")) {
			JFileChooser open=new JFileChooser();
			open.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter restrict=new FileNameExtensionFilter("only .txt files", "txt");
			open.addChoosableFileFilter(restrict);
			open.setApproveButtonText("Open");
			int action =open.showOpenDialog(this);
			if(action!=JFileChooser.APPROVE_OPTION) {
				return;
			}
			File file=open.getSelectedFile();
			try {
				BufferedReader reder=new BufferedReader(new FileReader(file));
				area.read(reder, null);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(ae.getActionCommand().equals("Close")) {
			System.exit(0);
			
		}else if(ae.getActionCommand().equals("Print")) {
			try {
				area.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(ae.getActionCommand().equals("Copy")) {
			text=area.getSelectedText();
			
		}else if(ae.getActionCommand().equals("Paste")) {
			area.insert(text, area.getCaretPosition());
			
		}else if(ae.getActionCommand().equals("Cut")) {
			text=area.getSelectedText();
			area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
			
		}else if(ae.getActionCommand().equals("Select All")) {
			area.selectAll();
			
		}else if(ae.getSource()==fontcolor) {
			JColorChooser colochooser=new JColorChooser();
			Color color =colochooser.showDialog(null, "choose color", Color.black);
			area.setForeground(color);
			
		}
		
//		String command=ae.getActionCommand();
//		switch(command) {
//		case "Times New Roman":setfont(command);
//		break;
//		case "Arial":setfont(command);
//		break;
//		case "Arial Black":setfont(command);
////		break;
//		}
			
			
		//}//else if(ae.getActionCommand().equals("Font Size")) {
			//area.selectAll();	}
		String command=ae.getActionCommand();
		switch(command) {
		case "Times New Roman":setfont(command);
		break;
		case "Arial":setfont(command);
		break;
		case "Arial Black":setfont(command);
		break;
		case "6":fontformate(6);
		break;
		case "8":fontformate(8);
		break;
		case "10":fontformate(10);
		break;
		case "12":fontformate(12);
		break;
		case "14":fontformate(14);
		break;
		case "16":fontformate(16);
		break;
		case "18":fontformate(18);
		break;
		case "20":fontformate(20);
		break;
		}
	}

	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new note().setTitle("notepad");
		new note().setVisible(true);
	
	
	}


	
}
