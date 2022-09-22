package assignment;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.*;

public class GUI {
		
	public static void main(String[] args) {
		ArrayList<String> orderList = new ArrayList<String>();
		JFrame frame = new JFrame("Restaurant GUI");
		JTextArea textArea = new JTextArea("Welcome to Star Restaurant, see our menu below\n"
				+ "\nSpicy Chicken Wings - Portion of 6 - €7 "
				+ "\nBBQ Ribs - Portion of 8 - €5 "
				+ "\nQuarter Pounder Beef Burger served with chips - €10 "
				+ "\n \n");
		textArea.setEditable(false);
		frame.add(textArea);

		JMenu newOrder = new JMenu("Place New Order");
		
		JCheckBoxMenuItem chick = new JCheckBoxMenuItem("Chicken Wings");
		newOrder.add(chick);
		newOrder.addSeparator();
		JCheckBoxMenuItem ribs = new JCheckBoxMenuItem("BBQ Ribs");
		newOrder.add(ribs);
		newOrder.addSeparator();
		JCheckBoxMenuItem beef = new JCheckBoxMenuItem("Beef Burger");
		newOrder.add(beef);
		newOrder.addSeparator();
		
		orderList.add(chick.getText());
		orderList.add(ribs.getText());
		orderList.add(beef.getText());

		
		
		for (int x =0; x<=newOrder.getItemCount()-1; x++)
		{
			JCheckBoxMenuItem nextMI = (JCheckBoxMenuItem) newOrder.getItem(x);
			if (nextMI != null)	// To discard the separator
			{
				//System.out.println(nextMI.getText());
				
				nextMI.addItemListener(new ItemListener() {
			        public void itemStateChanged(ItemEvent e) {
			          //System.out.println("Checked? " + nextMI.isSelected());
			          textArea.append(nextMI.getText()+" has been "+
			        		  (nextMI.isSelected()?"selected":"unselected")+"\n");
			        }
			      });
			}
		}
		
		JMenu ordersMenu = new JMenu("Orders");
		JMenuItem place = new JMenuItem("Place an Order with selected item");
		ordersMenu.add(place);
		
		//Random letter
		Random rnd = new Random();
		final String AB = "abcdefghijklmnopqrstuvwxyz"; 
		StringBuilder alphabat = new StringBuilder();
		for (int i = 0; i < 7; i++){
			alphabat.append(AB.charAt(rnd.nextInt(AB.length())));
		}

		//Random letter2
		Random rnd2 = new Random();
		final String AB2 = "mnopqrstuvwxyzabcdefghijkl"; 
		StringBuilder alphabat2 = new StringBuilder();
		for (int i = 0; i < 7; i++){
			alphabat2.append(AB.charAt(rnd.nextInt(AB.length())));
		}

		//Random letter3
		Random rnd3 = new Random();
		final String AB3 = "mnopqrstdefghijkluvwxyzabc"; 
		StringBuilder alphabat3 = new StringBuilder();
		for (int i = 0; i < 7; i++){
			alphabat3.append(AB.charAt(rnd.nextInt(AB.length())));
		}

		//Random Numbers
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);
		int rand_int2 = rand.nextInt(5000);
		int rand_int3 = rand.nextInt(9000);
		place.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chick.isSelected())
				{
					JOptionPane.showMessageDialog(frame, "Order has been placed, please wait");
					textArea.append("\nStore ID is : " + alphabat.toString() + "\n");
					textArea.append("and Order ID is : " + rand_int1 + "\n");
					textArea.append("The price of the order is " + "€7" + "\n");


				}else if (ribs.isSelected())
				{
					JOptionPane.showMessageDialog(frame, "Order has been placed, please wait");
					textArea.append("\nStore ID is : " + alphabat2.toString() + "\n");
					textArea.append("and Order ID is : " + rand_int2 + "\n");
					textArea.append("The price of the order is " + "€5" + "\n");

				}else if (beef.isSelected())
				{
					JOptionPane.showMessageDialog(frame, "Order has been placed, please wait");
					textArea.append("\nStore ID is : " + alphabat3.toString() + "\n");
					textArea.append("and Order ID is : " + rand_int3 + "\n");
					textArea.append("The price of the order is " + "€10" + "\n");

				}else

					textArea.append("No food was selected, please try again" + "\n" );

			}
		});
		
		
		//Admin
		JMenu admin = new JMenu("Admin");
		admin.setMnemonic('T');
		
		//Close GUI
		JMenuItem logoff = new JMenuItem("Close System");
		admin.add(logoff);
		logoff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.VK_ESCAPE));
		logoff.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				int close = JOptionPane.showConfirmDialog(null, "Do you want to close the system?",
						"System", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
				if (close == JOptionPane.YES_OPTION)
				
					frame.dispose();
					else {
						textArea.append("System close cancelled " + "\n");
					}

		}
		});

		
		// create a menu bar and use 
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(newOrder);
		menuBar.add(ordersMenu);
		menuBar.add(admin);
		frame.setJMenuBar(menuBar);
		
		// Final JFrame methods 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,400);
		frame.setVisible(true);
	}
	}

				
