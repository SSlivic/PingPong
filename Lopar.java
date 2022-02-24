import java.awt.*;
public class Lopar {
private final int y=330;

private final int SIRINA=60;
private final int VISINA=20;

private int x=120;//mesto odakle poène
private int xPremik=0;
private Igra igra;
public  Lopar (Igra igra) {
	this.igra=igra;
}
	
public void narisi(Graphics2D g2d) {
	g2d.fillRect(this.x,y,SIRINA,VISINA);
	
}
public void nastaviPremikanje(int smerPremikanja) {
	this.xPremik=smerPremikanja;
}


public void premakni() {
	if(this.x+xPremik>0 &&this.x+xPremik<igra.getWidth()- SIRINA) {
	this.x+=xPremik;}
}



public void ustaviPremikanje() {
	this.xPremik=0;
}

public Rectangle getMejeLoparja() {
	Rectangle lopar=new Rectangle(this.x,y,SIRINA,VISINA);
	
	 return lopar;
}
}
