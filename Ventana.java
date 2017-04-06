import java.awt.BorderLayout;

import javax.swing.JFrame;
//Diego Armando Gracia Hinojosa A01229716 50%
//Sebastián Cedeño González A01227809 50%
public class Ventana extends JFrame{
	public Ventana(){
		super("Cálculo de ISR");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelControles pc=new PanelControles();
		this.add(pc, BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		Ventana ven=new Ventana();
	}
}
