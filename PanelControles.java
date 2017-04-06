import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//Diego Armando Gracia Hinojosa A01229716 50%
//Sebastián Cedeño González A01227809 50%


public class PanelControles extends JPanel{
	private Persona usuario;
	private Deduccion deduccion;
	private JRadioButton pre,
						 pri,
						 sec,
						 prepa,
						 tec;
	private JButton btArchivo,
					btDeducir; 
	
	private JTextField tfArchivo,
					   			tfnombre,
					   			tfrFC,
					   			tfsMensual,
					   			tfaguinaldo,
					   			tfpVacacional,
					   			tfgMedicos,
					   			tfgFunerarios,
					   			tfsGMM,
					   			tfhipoteca,
					   			tfdonativos,
					   			tfretiro,
					   			tftEscolar,
					   			tfcolegiatura;
	private JLabel lNombre,
				   lRFC,
				   lSaldo,
				   lAguinaldo,
				   lPV,
				   lMedicos,
				   lFunerarios,
				   lSGMM,
				   lHipoteca,
				   lDonativos,
				   lRetiro,
				   lTransporte,
				   lColegiatura;
	private JFileChooser fcArchivo;
	
	public PanelControles(){
		super();
		this.setPreferredSize(new Dimension(300, 440));
		this.usuario=new Persona();
		this.deduccion=new Deduccion(this.usuario);
		
		this.fcArchivo=new JFileChooser();
		this.tfArchivo=new JTextField(12);
		
		this.btArchivo=new JButton("Seleccionar Archivo");
		this.btArchivo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int resp=PanelControles.this.fcArchivo.showOpenDialog(null);
				if(resp==JFileChooser.APPROVE_OPTION){
					String rutaArchivo=PanelControles.this.fcArchivo.getSelectedFile().toString();
					System.out.println(rutaArchivo);
					try{
						BufferedReader bf=new BufferedReader(new FileReader(rutaArchivo));
						String linea=bf.readLine();
						StringTokenizer st = new StringTokenizer(linea, ",");
		
						usuario.setNombre(st.nextToken());
						usuario.setrFC(st.nextToken());
						usuario.setSaldo(Double.parseDouble(st.nextToken()));
						usuario.setAguinaldo(Double.parseDouble(st.nextToken()));
						usuario.setpVacacional(Double.parseDouble(st.nextToken()));
						usuario.setgMedicos(Double.parseDouble(st.nextToken()));
						usuario.setgFunerarios(Double.parseDouble(st.nextToken()));
						usuario.setsGMM(Double.parseDouble(st.nextToken()));
						usuario.setHipotecarios(Double.parseDouble(st.nextToken()));
						usuario.setDonativos(Double.parseDouble(st.nextToken()));
						usuario.setsRetiro(Double.parseDouble(st.nextToken()));
						usuario.settEscolar(Double.parseDouble(st.nextToken()));
						usuario.setnEducativo(st.nextToken());
						usuario.setColegiatura(Double.parseDouble(st.nextToken()));

						
						while(linea != null){
							JOptionPane.showMessageDialog(PanelControles.this, deduccion.toString());
							linea=bf.readLine();
						}
						bf.close();
					}
					catch(FileNotFoundException ex){
						System.out.println("Raios"+ex);
					}
					catch(IOException ex){
						System.out.println("Doble Raios"+ex);
					}
				}
			}
		});
		this.add(this.btArchivo);
		this.add(this.tfArchivo);
		this.lNombre=new JLabel("Nombre:");
		this.add(this.lNombre);
		this.tfnombre=new JTextField(20);
		this.add(this.tfnombre);
		this.lRFC=new JLabel("RFC:       ");
		this.add(this.lRFC);
		this.tfrFC=new JTextField(20);
		this.add(this.tfrFC);
		this.lSaldo=new JLabel("Saldo Mensual:");
		this.add(this.lSaldo);
		this.tfsMensual=new JTextField(16);
		this.add(this.tfsMensual);
		this.lAguinaldo=new JLabel("Aguinaldo:");
		this.add(this.lAguinaldo);
		this.tfaguinaldo=new JTextField(18);
		this.add(this.tfaguinaldo);
		this.lPV=new JLabel("Prima Vacacional:");
		this.add(this.lPV);
		this.tfpVacacional=new JTextField(14);
		this.add(this.tfpVacacional);
		this.lMedicos=new JLabel("Gastos Médicos:");
		this.add(this.lMedicos);
		this.tfgMedicos=new JTextField(15);
		this.add(this.tfgMedicos);
		this.lFunerarios=new JLabel("Gastos Funerarios:");
		this.add(this.lFunerarios);
		this.tfgFunerarios=new JTextField(14);
		this.add(this.tfgFunerarios);
		this.lSGMM=new JLabel("SGMM:");
		this.add(this.lSGMM);
		this.tfsGMM=new JTextField(20);
		this.add(this.tfsGMM);
		this.lHipoteca=new JLabel("Gastos Hipotecarios:");
		this.add(this.lHipoteca);
		this.tfhipoteca=new JTextField(13);
		this.add(this.tfhipoteca);
		this.lDonativos=new JLabel("Donativos:");
		this.add(this.lDonativos);
		this.tfdonativos=new JTextField(18);
		this.add(this.tfdonativos);
		this.lRetiro=new JLabel("Retiro:");
		this.add(this.lRetiro);
		this.tfretiro=new JTextField(20);
		this.add(this.tfretiro);
		this.lTransporte=new JLabel("Transporte Escolar:");
		this.add(this.lTransporte);
		this.tftEscolar=new JTextField(13);
		this.add(this.tftEscolar);
		this.pre=new JRadioButton("Preescolar");
		this.pri=new JRadioButton("Primaria",true);
		this.sec=new JRadioButton("Secundaria");
		this.prepa=new JRadioButton("Preparatoria");
		this.tec=new JRadioButton("Profesional Técnico");
		ButtonGroup bg=new ButtonGroup();
		
		bg.add(this.pri);
		bg.add(this.sec);
		bg.add(this.prepa);
		
		
		this.add(this.pri);
		this.add(this.sec);
		this.add(this.prepa);
		
		this.lColegiatura=new JLabel("Colegiatura:");
		this.add(this.lColegiatura);
		this.tfcolegiatura=new JTextField(17);
		this.add(this.tfcolegiatura);
		
		this.btDeducir=new JButton("Deducir");
		this.btDeducir=new JButton("Deducir");
		this.btDeducir=new JButton("Deducir");
		this.btDeducir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				usuario.setNombre(tfnombre.getText());
				usuario.setrFC(tfrFC.getText());
				usuario.setSaldo(Double.parseDouble(tfsMensual.getText()));
				usuario.setAguinaldo(Double.parseDouble(tfaguinaldo.getText()));
				usuario.setpVacacional(Double.parseDouble(tfpVacacional.getText()));
				usuario.setgMedicos(Double.parseDouble(tfgMedicos.getText()));
				usuario.setgFunerarios(Double.parseDouble(tfgFunerarios.getText()));
				usuario.setsGMM(Double.parseDouble(tfsGMM.getText()));
				usuario.setHipotecarios(Double.parseDouble(tfhipoteca.getText()));
				usuario.setDonativos(Double.parseDouble(tfdonativos.getText()));
				usuario.setsRetiro(Double.parseDouble(tfretiro.getText()));
				usuario.settEscolar(Double.parseDouble(tftEscolar.getText()));
				usuario.setColegiatura(Double.parseDouble(tfcolegiatura.getText()));
				
				if(pri.isSelected()){
					usuario.setnEducativo("Primaria");
				}
				if(sec.isSelected()){
					usuario.setnEducativo("Secundaria");
				}
				if(prepa.isSelected()){
					usuario.setnEducativo("Preparatoria");
				}
				JOptionPane.showMessageDialog(PanelControles.this, deduccion.toString());
			}
		});
		this.add(btDeducir);
		
	}	
}
