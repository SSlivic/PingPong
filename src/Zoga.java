import java.awt.Graphics2D;
import java.awt.*;
public class Zoga {
private final int PREMER=30;
private int x = 50;
private int y=50;
private int xPremik =1;
private int yPremik=1;
private Igra igra;

public Zoga(Igra igra) {
	this.igra=igra;
}

public void narisi(Graphics2D g2d) {
	g2d.fillOval(x,y,PREMER,PREMER);
}
public void premakni() {

	if(this.x+1>igra.getWidth()-PREMER) {
		this.xPremik=-1;
		igra.zvocnik.odboj();
	}
	if(this.y+1>igra.getHeight()-PREMER) {
		/*igra.konecIgre();
		igra.zvocnik.konec();*/
		this.yPremik=1;
	}
	if(this.y>igra.getHeight()-PREMER) {
		igra.zvocnik.konec();
		igra.konecIgre();
		
		//this.yPremik=-1;
	}
	if(this.x==0) {
		this.xPremik=1;
			igra.zvocnik.odboj();
	}
	if(this.y==0) {
		//this.yPremik=1;
	
		igra.zvocnik.konec();
		igra.konecIgre();
	}
	if(this.trkZLoparjem()) {
		if(yPremik==1){
			igra.povecajTocke();
			igra.zvocnik.trk();
		}
		this.yPremik=-1;

	}
	if(this.trkZLoparjem2()) {
		if(yPremik==-1){
			igra.povecajTocke2();
			igra.zvocnik.trk();
		}
		this.yPremik=1;

	}
	
	this.x+=xPremik;
	this.y+=yPremik;//to spusta pod 45 stepeni ugao
}
private Rectangle getMejeZoge() {
	return new Rectangle(this.x,this.y,PREMER,PREMER);
}
private boolean trkZLoparjem() {
	return igra.lopar.getMejeLoparja().intersects(this.getMejeZoge());//intersekt povrne boolean da li se seku ili ne.da li su  u istoj povrsini
}
private boolean trkZLoparjem2() {
	return igra.lopar2.getMejeLoparja2().intersects(this.getMejeZoge());//intersekt povrne boolean da li se seku ili ne.da li su  u istoj povrsini
	}

}
