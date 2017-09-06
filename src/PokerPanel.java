import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;

public class PokerPanel extends JPanel {

	private final int PANEL_WIDTH = 800;
	private final int PANEL_HEIGHT = 600;
	private ImageIcon blank = new ImageIcon("cards/blank.jpg");// default image at the start
	private ArrayList<ImageIcon> icons = new ArrayList<ImageIcon>();// images to display for the cards
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();// labels to display card images on
	private ArrayList<Card> cards = new ArrayList<Card>();// the cards themselves
	private boolean[] held = new boolean[5];//			determines if the cards are held or not
	private JButton deal = new JButton("Deal");//		button to deal cards
	private boolean firstDeal = true;
	private Deck deck1;//					deck to hold cards, randomly generated
	
	public PokerPanel() {	//constructor for PokerPanel
		setBackground(Color.BLUE);
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		
		deal.addActionListener(new DealListener());//setup the deal button
		
		for (int i = 0; i < 5; i++) {// create the cards, labels, and set their defaults
			labels.add(new JLabel(blank));
			labels.get(i).addMouseListener(new CardListener());
			add(labels.get(i));
			held[i] = false;
		}// end for
		
		add(deal);
		
		this.revalidate();

	}// end constructor
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
	}// end paintComponent
	
	private class DealListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Card temp;
			Point cur;// hold the coordinates of a label
			
			if (firstDeal) {// if it's the initial deal
				deck1 = new Deck();// create a new deck
				cards.clear();// get rid of old cards
				icons.clear();// get rid of old icons
				
				for (int i = 0; i < 5; i++) {// create a new card, icon, label, and set the held status to false
					cards.add(new Card(deck1.drawCard()));
					icons.add(new ImageIcon("cards/c" + cards.get(i).getMasterValue() + ".jpg"));
					labels.get(i).setIcon(icons.get(i));
					if (held[i] == true) {// make sure the card is dispalyed properly if it was previously held
						cur = labels.get(i).getLocation();
						labels.get(i).setLocation((int)cur.getX(), (int)cur.getY() - 20);
					}// end if
					held[i] = false;
				}// end for
				firstDeal = false;// it's no longer the first deal
			}// end if
			else {// not the first deal
				for (int i = 0; i < 5; i++) {// scan through the cards
					if (held[i] == false) {// if a card was not held
						temp = new Card(deck1.drawCard());// generate a new card
						cards.remove(i);// remove the old card
						cards.add(i, temp);// add the new card in it's place
						icons.remove(i);// remove the old icon
						icons.add(new ImageIcon("cards/c" + cards.get(i).getMasterValue() + ".jpg"));
						// add a new icon in it's place
						labels.get(i).setIcon(icons.get(i));// set the label's icon
					}// end if
				}// end for
				firstDeal = true;// it's now the first deal again
			}// end else

		}// end actionPerformed
	}// end DealListener
	
	private class CardListener implements MouseListener {
		public void mouseClicked(MouseEvent event) {
			JLabel card = (JLabel)event.getSource();// card that called the listener
			Point cur = new Point(card.getLocation());// Point that card is located at
			
			for (int i = 0; i < 5; i++) {// scan through to see which card called the listener
				if (card == labels.get(i))
					if (held[i] == true) {// when that cards index is found, check to see it's held status
						held[i] = false;
						card.setLocation((int)cur.getX(), (int)cur.getY() - 20);
					}// end if
					else {
						held[i] = true;
						card.setLocation((int)cur.getX(), (int)cur.getY() + 20);
					}// end else
			}// end for
		}// end mouseClicked
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
	}// end CardListener
	
}// end PokerPanel
