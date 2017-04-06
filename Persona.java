//Diego Armando Gracia Hinojosa A01229716 50%
//Sebastián Cedeño González A01227809 50%

public class Persona {
	private String rFC,
	   			   nombre,
	   			   nEducativo;
	private double saldo,
 		       	   aguinaldo,
 		       	   pVacacional,
 		       	   gMedicos,
 		       	   gFunerarios,
 		       	   sGMM,
 		       	   hipotecarios,
 		       	   donativos,
 		       	   sRetiro,
 		       	   tEscolar,
 		       	   colegiatura;
	public Persona(){
		this.rFC=null;
		this.nombre=null;
		this.nEducativo=null;
		this.saldo=0.0;
		this.aguinaldo=0.0;
		this.pVacacional=0.0;
		this.gMedicos=0.0;
		this.gFunerarios=0.0;
		this.sGMM=0.0;
		this.hipotecarios=0.0;
		this.donativos=0.0;
		this.sRetiro=0.0;
		this.tEscolar=0.0;
		this.colegiatura=0.0;
		
	}
	public String getrFC() {
		return rFC;
	}
	public void setrFC(String rFC) {
		this.rFC = rFC;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getnEducativo() {
		return nEducativo;
	}
	public void setnEducativo(String nEducativo) {
		this.nEducativo = nEducativo;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getAguinaldo() {
		return aguinaldo;
	}
	public void setAguinaldo(double aguinaldo) {
		this.aguinaldo = aguinaldo;
	}
	public double getpVacacional() {
		return pVacacional;
	}
	public void setpVacacional(double pVacacional) {
		this.pVacacional = pVacacional;
	}
	public double getgMedicos() {
		return gMedicos;
	}
	public void setgMedicos(double gMedicos) {
		this.gMedicos = gMedicos;
	}
	public double getgFunerarios() {
		return gFunerarios;
	}
	public void setgFunerarios(double gFunerarios) {
		this.gFunerarios = gFunerarios;
	}
	public double getsGMM() {
		return sGMM;
	}
	public void setsGMM(double sGMM) {
		this.sGMM = sGMM;
	}
	public double getHipotecarios() {
		return hipotecarios;
	}
	public void setHipotecarios(double hipotecarios) {
		this.hipotecarios = hipotecarios;
	}
	public double getDonativos() {
		return donativos;
	}
	public void setDonativos(double donativos) {
		this.donativos = donativos;
	}
	public double getsRetiro() {
		return sRetiro;
	}
	public void setsRetiro(double sRetiro) {
		this.sRetiro = sRetiro;
	}
	public double gettEscolar() {
		return tEscolar;
	}
	public void settEscolar(double tEscolar) {
		this.tEscolar = tEscolar;
	}
	public double getColegiatura() {
		return colegiatura;
	}
	public void setColegiatura(double colegiatura) {
		this.colegiatura = colegiatura;
	}
}
