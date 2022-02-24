import java.awt.Graphics2D;
import java.awt.Rectangle;
public class Lopar2 {

private final int y2=20;
private final int SIRINA=60;
private final int VISINA=20;

private int x=120;//mesto odakle poène
private int xPremik2=0;
private Igra igra;
public  Lopar2 (Igra igra) {
	this.igra=igra;
}
	
public void narisi(Graphics2D g2d) {
	
	g2d.fillRect(this.x,y2,SIRINA,VISINA);
}

public void nastaviPremikanje2(int smerPremikanja) {
	this.xPremik2=smerPremikanja;
}


public void premakni2() {
	if(this.x+xPremik2>0 &&this.x+xPremik2<igra.getWidth()- SIRINA) {
	this.x+=xPremik2;}
}



public void ustaviPremikanje2() {
	this.xPremik2=0;
}

public Rectangle getMejeLoparja2() {
Rectangle lopar2= new Rectangle(this.x,y2,SIRINA,VISINA);
return lopar2;
}}

