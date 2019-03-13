package oyes;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class JChartEx extends JFrame
   {
	private JMenuItem   open, exit, about, random, deletefile, resize, save, saveas;
    private JMenuItem   fullscreen, delete, previous, next, linearreg;
    
    
    private JTable jTable1 ;
    JTable rowTable;
    int x = 0;
    
   	public JChartEx()
		   {
			JFrame frame = new JFrame();
			setJMenuBarAndMenuBarItems();
			//JChartEx myframe=new JChartEx();
			
		
		   DefaultTableModel model;	  	  
		   
		   model = new DefaultTableModel(0,8);
		   
		   jTable1=new JTable(model);
		   
		   for(int x = 0; x < 100; x++) insertRow();
		   
		   
		   
		   jTable1.setRowHeight(20);
		   JScrollPane scroll = new JScrollPane(jTable1);
		   
		   //rowTable = new RowNumberTable(jTable1);
		   
		   //scroll.setRowHeaderView(rowTable);
		   //scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER,  rowTable.getTableHeader());
		   
		   TableRowUtilities tru = new TableRowUtilities();
		   tru.addNumberColumn(jTable1, 0, false);
		   
		   
		   // turn off auto resize
           jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
           
           this.add(scroll);
           
           // set preferred column widths
           int index = 0;
           while (index < 8) {
               TableColumn a = jTable1.getColumnModel().getColumn(index);
               a.setPreferredWidth(150);
               index++;
           }

           //this.pack();

		   
		   
		   this.setTitle("Excel Lent JTABLE");
		   
		   this.setBackground(Color.white);
		   	   // This is the line that does all the magic!
		   //ExcelAdapter myAd = new ExcelAdapter(jTable1);
		   
		   this.setSize(new Dimension(750,550));
		   this.setVisible(true);
		   
		   
		   jTable1.addKeyListener(new KeyListener() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	                
	            }
	 
	            @Override
	            public void keyPressed(KeyEvent e) {
	            	if (jTable1.getSelectedRow()+1 == jTable1.getModel().getRowCount()) {
	                //
	             	// insert row when something was entered at the last row
	            		insertRow();
	            	}
	            }

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
		   });
		  
		 //Hook up listener to vertical scroll bar
		 scroll.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){ 
		     @Override
		     public void adjustmentValueChanged(AdjustmentEvent e) {
		         // Check if user has done dragging the scroll bar
		         if(!e.getValueIsAdjusting()){
		             JScrollBar scrollBar = (JScrollBar) e.getAdjustable();
		             int extent = scrollBar.getModel().getExtent();
		             int maximum = scrollBar.getModel().getMaximum();
		             if(extent + e.getValue() == maximum){
		                // fetchMoreData();
		            	//JOptionPane.showMessageDialog(null, null);
		            	 insertRow();
		            	 
		             }
		         }

		     }
		     
		 });
		   
		   }
   	
   	
   	public void insertRow()
    {
      ((DefaultTableModel)jTable1.getModel()).addRow(new java.util.Vector<String>(java.util.Arrays.asList(new String[]{"","",""})));
    }
   	
   	public static void main(String args[])
	   {
		//JFrame frame = new JFrame();
		JChartEx myframe=new JChartEx();
		
	   }
   	void setJMenuBarAndMenuBarItems()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1    = new JMenu("File");
        menu1.setMnemonic('F');
        
        ImageIcon icon_open = new ImageIcon(getClass().getResource("res/folder.png"));
        open     = new JMenuItem("Open Folder", icon_open);

        menu1.add(open);
        menuBar.add(menu1);
        open     = new JMenuItem("Open");
        menuBar.add(menu1);
        open.setMnemonic('O');
        menu1.add(open);
        
        save     = new JMenuItem("Save");
        save.setMnemonic('S');
        menu1.add(save);
        
        
        saveas     = new JMenuItem("Save As");
        saveas.setMnemonic('A');
        menu1.add(saveas);
        
        
     //   ImageIcon icon_exit = new ImageIcon(getClass().getResource("res/exit.png"));
      //  exit     = new JMenuItem("Exit", icon_exit);
        exit     = new JMenuItem("Exit");
        exit.setMnemonic('X');
        menu1.add(exit);
        
        
        JMenu menu2    = new JMenu("Edit");
        
            
        
        menuBar.add(menu2);
        menu2.setMnemonic('E');
        
        deletefile     = new JMenuItem("Delete File");
        menu2.add(deletefile);
        
        resize     = new JMenuItem("Resize");
        menu2.add(resize);
        
       
        JMenu menu3    = new JMenu("View");
        menu3.setMnemonic('V');
        
        
        menuBar.add(menu3);
        
        fullscreen     = new JMenuItem("Full Screen");
        menu3.add(fullscreen);
        
        JMenu menu5    = new JMenu("Plot");
        menu5.setMnemonic('P');
        
        linearreg     = new JMenuItem("Linear Regression");
        menu5.add(linearreg);
        menuBar.add(menu5);
        
        JMenu menu4    = new JMenu("Help");
        menu4.setMnemonic('H');
        about     = new JMenuItem("About");
        about.setMnemonic('A');
        menu4.add(about);
        
        menuBar.add(menu4);
        
        setJMenuBar(menuBar);
    }
   
		
  }