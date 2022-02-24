import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Igra extends JPanel{
	Zoga zoga= new Zoga(this);
	Lopar lopar=new Lopar(this);
	Lopar2 lopar2=new Lopar2(this);
	Zvocnik zvocnik=new Zvocnik();
	private int tocke=0;
	private int tocke2=0;

	public Igra() {
		addKeyListener(new KeyListener() {


			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					lopar.nastaviPremikanje(1);
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					lopar.nastaviPremikanje(-1);
			}
				if(e.getKeyCode()==KeyEvent.VK_Q) {
					lopar2.nastaviPremikanje2(1);
				}
				if(e.getKeyCode()==KeyEvent.VK_W) {
					lopar2.nastaviPremikanje2(-1);
			}	
			
			}
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_RIGHT|| e.getKeyCode()==KeyEvent.VK_LEFT) {
						lopar.ustaviPremikanje();}
					
						if(e.getKeyCode()==KeyEvent.VK_W|| e.getKeyCode()==KeyEvent.VK_Q) {
							lopar2.ustaviPremikanje2();
						}
				
				

		}
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}});
		setFocusable(true);
	}

public void paint(Graphics g) {
	super.paint(g);

	Graphics2D g2d=(Graphics2D) g;

	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

zoga.narisi(g2d);
lopar.narisi(g2d);
lopar2.narisi(g2d);
g2d.setColor(Color.RED);
g2d.setFont(new Font("Verdana",Font.BOLD,30));
g2d.drawString(String.valueOf(this.tocke),10,350);
g2d.drawString(String.valueOf(this.tocke2),10,30);
}
public void konecIgre() {
	
	JOptionPane.showMessageDialog(this,"Konec igre!");
	System.exit(0);
}
public void povecajTocke(){
	this.tocke++;
	
}
public void povecajTocke2(){
	this.tocke2++;
	
}
	public static void main(String[] args) {
		JFrame okvir=new JFrame("Igra");
		Igra igra=new Igra();
				okvir.add(igra);
				okvir.setSize(300,400);
				okvir.setVisible(true);
				okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				while(true) {
					igra.zoga.premakni();
					igra.lopar.premakni();
					igra.lopar2.premakni2();
				igra.repaint();
				try {
					Thread.sleep(10);//brzina
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				}

	}

}
