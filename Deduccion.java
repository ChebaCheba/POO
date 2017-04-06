//Diego Armando Gracia Hinojosa A01229716 50%
//Sebastián Cedeño González A01227809 50%
public class Deduccion {
	private double ingresoA,
				   aguinaldoE,
				   aguinaldoG,
				   pvE,
				   pvG,
				   tiG,
				   mdC,
				   mdR,
				   tD,
				   dP,
				   mISR,
				   cuotaFija,
				   limiteInf,
				   porcentajeLI,
				   totalPagar;
	private Persona usuario;
	
	public Deduccion(Persona persona){
		this.usuario=persona;
		this.ingresoA=ingresoA;
		this.aguinaldoE=aguinaldoE;
		this.aguinaldoG=aguinaldoG;
		this.pvE=pvE;
		this.pvG=pvG;
		this.tiG=tiG;
		this.mdC=mdC;
		this.mdR=mdR;
		this.tD=tD;
		this.dP=dP;
		this.mISR=mISR;
		this.cuotaFija=cuotaFija;
		this.porcentajeLI=porcentajeLI;
		this.limiteInf=limiteInf;
		this.totalPagar=totalPagar;
	}
	
	public double SaldoAnual(){
		this.ingresoA=usuario.getSaldo()*12;
		return this.ingresoA;
	}
	
	public double AguinaldoExento(){
		if((usuario.getSaldo()/2)>usuario.getAguinaldo()){
			this.aguinaldoE=usuario.getAguinaldo();
		}
		else{
			this.aguinaldoE=usuario.getSaldo()/2;
		}
		return this.aguinaldoE;
	}
	public double AguinaldoGravado(){
		if((usuario.getAguinaldo()-this.aguinaldoE)<0.0){
			this.aguinaldoG=0.0;
		}
		else{
			this.aguinaldoG=usuario.getAguinaldo()-this.aguinaldoE;
		}
		return this.aguinaldoG;
	}
	public double PVacacionalExenta(){
		this.pvE=80.04*15;
		return this.pvE;
	}
	public double PVacacionalGravada(){
		if((usuario.getpVacacional()-this.pvE)<0){
			this.pvG=0.0;
		}
		else{
			this.pvG=usuario.getpVacacional()-this.pvE;	
		}
		return this.pvG;
	}
	public double TIngresosGravan(){
		this.tiG=this.ingresoA+this.aguinaldoG+this.pvG;
		return tiG;
	}
	public double MDeducirColegiatura(){
		if(usuario.getnEducativo().equals("Preescolar")){
			this.mdC=14200.00;
		}
		else if(usuario.getnEducativo().equals("Primaria")){
			this.mdC=12900.00;
		}
		else if(usuario.getnEducativo().equals("Secundaria")){
			this.mdC=19900.00;
		}
		else if(usuario.getnEducativo().equals("Profesional técnico")){
			this.mdC=17100.00;
		}
		else if(usuario.getnEducativo().equals("Preparatoria")){
			this.mdC=24500.00;
		}
		else{
			this.mdC=0.0;
		}
		return this.mdC;
	}
	public double MReducirRetiro(){
		if(usuario.getsRetiro()>(this.tiG/10)){
			this.mdR=this.tiG/10;
		}
		else{
			this.mdR=usuario.getsRetiro();
		}
		return this.mdR;
	}
	public double TDeducciones(){
		this.tD=(usuario.getgMedicos()+usuario.getgFunerarios()+usuario.getsGMM()+usuario.getHipotecarios()+usuario.getDonativos()+usuario.gettEscolar()+usuario.getColegiatura());
		return this.tD;
	}
	public double DPermitidas(){
		double diezP,
			   diezPR;
		if(this.mdR<=this.tiG*0.10){
			diezP=this.mdR;
		}
		else{
			diezP=this.tiG*10;
		}
		if(this.tD<=this.tiG*0.10){
			diezPR=this.tD;
		}
		else{
			diezPR=this.tiG*0.10;
		}
		this.dP=diezP+diezPR;
		return this.dP;
	}
	public double MontoISR(){
		this.mISR=(this.tiG-this.dP);
		return this.mISR;
	}
	public double CuotaFija(){
		if (this.mISR>3000000.01){
			this.cuotaFija = 940850.81;
		}
		else if (this.mISR>1000000.01 && this.mISR<3000000){
			this.cuotaFija = 260850.81;
		}
		else if (this.mISR>750000.01 && this.mISR<1000000){
			this.cuotaFija = 180850.82;
		}
		else if (this.mISR>392841.97 && this.mISR<750000){
			this.cuotaFija = 73703.41;
		}
		else if (this.mISR>249243.48 && this.mISR<392841.96){
			this.cuotaFija = 39929.05;
		}
		else if (this.mISR>123580.21 && this.mISR<249243.48){
			this.cuotaFija = 13087.37;
		}
		else if (this.mISR>103218.01 && this.mISR<123580.2){
			this.cuotaFija = 9438.47;
		}
		else if (this.mISR>88793.05 && this.mISR<103218){
			this.cuotaFija = 7130.48;
		}
		else if (this.mISR>50524.93 && this.mISR<88793.04){
			this.cuotaFija = 2966.91;
		}
		else if (this.mISR>5952.85 && this.mISR<50524.92){
			this.cuotaFija = 114.29;
		}
		else if(MontoISR()< 5952.84){
			this.cuotaFija = 0;
		}
		return this.cuotaFija;
	}
	public double PorcentajeLimInf(){
		if (this.mISR>3000000.01){
			this.porcentajeLI=35.00;
		}
		else if (this.mISR>1000000.01 && this.mISR<3000000){
			this.porcentajeLI=34.00;
		}
		else if (this.mISR>750000.01 && this.mISR<1000000){
			this.porcentajeLI=32.00;
		}
		else if (this.mISR>392841.97 && this.mISR<750000){
			this.porcentajeLI=30.00;
		}
		else if (this.mISR>249243.48 && this.mISR<392841.96){
			this.porcentajeLI=23.52;
		}
		else if (this.mISR>123580.21 && this.mISR<249243.48){
			this.porcentajeLI=21.36;
		}
		else if (this.mISR>103218.01 && this.mISR<123580.2){
			this.porcentajeLI=17.92;
		}
		else if (this.mISR>88793.05 && this.mISR<103218){
			this.porcentajeLI=16.00;
		}
		else if (this.mISR>50524.93 && this.mISR<88793.04){
			this.porcentajeLI=10.88;
		}
		else if (this.mISR>5952.85 && this.mISR<50524.92){
			this.porcentajeLI=6.4;
		}
		else if(this.mISR< 5952.84){
			this.porcentajeLI=1.92;
		}
		return this.porcentajeLI;
	}
	public double LimiteInferior(){
		if(this.porcentajeLI==35){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-3000000.01);
		}
		else if(this.porcentajeLI==34){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-1000000.01);
		}
		else if(this.porcentajeLI==32){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-750000.01);
		}
		else if(this.porcentajeLI==30){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-392841.97);
		}
		else if(this.porcentajeLI==23.52){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-249243.49);
		}
		else if(this.porcentajeLI==21.36){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-123580.21);
		}
		else if(this.porcentajeLI==17.92){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-103218.01);
		}
		else if(this.porcentajeLI==16){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-88793.05);
		}
		else if(this.porcentajeLI==10.88){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-50524.93);
		}
		else if(this.porcentajeLI==6.4){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-5952.85);
		}
		else if (this.porcentajeLI==1.92){
			this.limiteInf=(this.porcentajeLI/100)*(this.mISR-0.01);
		}
		return this.limiteInf;
	}
	public double TotalPagar(){
		this.totalPagar=this.cuotaFija+this.limiteInf;
		return this.totalPagar;
	}

	public String toString(){
		
		return "Nombre: "+usuario.getNombre()+",\n"+
				"RFC: "+usuario.getrFC()+",\n"+
				"Ingreso Anual: $"+SaldoAnual() + ",\n" +
			   " Aguinaldo Exento: $"+AguinaldoExento() +",\n "+
			   "Aguinaldo Gravado: $"+AguinaldoGravado() + ",\n "+
			   "Prima Vacacional Exenta: $"+PVacacionalExenta() +",\n "+
			   "Prima Vacacional Gravada: $"+PVacacionalGravada()+",\n " +
			   "Total de ingresos Gravados: $"+TIngresosGravan()+ ",\n " +
			   "Maximo a deducir Escuela: $"+MDeducirColegiatura() + ",\n " +
			   "Maximo a deducir Retiro: $"+MReducirRetiro() + ",\n " +
			   "Deducciones Totales: $"+TDeducciones() + ",\n " + 
			   "Deducciones Permitidas: $"+DPermitidas() + ",\n " +
			   "Monto a calcular ISR $"+MontoISR() + ",\n " +
			   "Cuota Fija: $"+CuotaFija()+ ",\n " +
			   "Porcentaje de Excedente "+PorcentajeLimInf()+"% ,\n"+
			   "Total a pagar de Excedente: $"+LimiteInferior() + ",\n" +
			   "Total a pagar de Impuestos: $"+TotalPagar() + " ."
			   ;
	}
}
