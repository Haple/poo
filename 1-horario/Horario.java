public class Horario{

	private int horas, minutos, segundos;

	public Horario(int horas, int minutos, int segundos) throws Exception{
		valida(horas,minutos,segundos);
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	private void valida(int horas, int minutos, int segundos) throws Exception{
		if(horas < 0 || horas > 24){
			throw new Exception("Hora \""+horas+"\" é inválida!");
		}
		if(minutos < 0 || minutos > 59){
			throw new Exception("Minutos \""+minutos+"\" são inválidos!");
		}
		if(segundos < 0 || segundos > 59){
			throw new Exception("Segundos \""+segundos+"\" são inválidos!");
		}
	}

	public int getHoras(){
		return this.horas;
	}
	
	public void setHoras(int horas) throws Exception{
		valida(horas,this.minutos,this.segundos);
		this.horas = horas;
	}

	public int getMinutos(){
		return this.minutos;
	}
	
	public void setMinutos(int minutos) throws Exception{
		valida(this.horas,minutos,this.segundos);
		this.minutos = minutos;
	}

	public int getSegundos(){
		return this.segundos;
	}
	
	public void setSegundos(int segundos) throws Exception{
		valida(this.horas,this.minutos,segundos);
		this.segundos = segundos;
	}
	
	private int emSegundos(){
		return this.segundos
			+ (this.minutos * 60)
			+ (this.horas * 3600);
	}

	public static Horario segundosEmHorario(int qtdSegundos) throws Exception{
		if(qtdSegundos < 0){
			throw new Exception("Quantidade de segundos inválida!");
		}
		int seg,min,h;
		seg = qtdSegundos;
		min = seg/60;
		seg %= 60;
		h = min/60;
		min %= 60; 
		h %= 24;
		return new Horario(h,min,seg);
	}
	
	public void adiante(int qtdSegundos) throws Exception{
		if(qtdSegundos < 0){
			throw new Exception("Quantidade de segundos inválida!");
		}
		Horario h = segundosEmHorario(this.emSegundos() + qtdSegundos);
		this.horas = h.getHoras();
		this.minutos = h.getMinutos();
		this.segundos = h.getSegundos();
		// Implementação procedural
		// this.segundos += qtdSegundos;
		// this.minutos += this.segundos/60;
		// this.segundos %= 60;
		// this.horas += this.minutos/60;
		// this.minutos %= 60; 
		// this.horas %= 24;
	}

	public void atrase(int qtdSegundos) throws Exception{
		if(qtdSegundos < 0){
			throw new Exception("Quantidade de segundos inválida!");
		}
		int dia = 86400;
		int atraso = this.emSegundos() - (qtdSegundos%dia);
		atraso = atraso < 0 ? dia - atraso : atraso;
		Horario h = segundosEmHorario(atraso);
		this.horas = h.getHoras();
		this.minutos = h.getMinutos();
		this.segundos = h.getSegundos();
		// Implementação procedural
		// this.segundos -= qtdSegundos%60;
		// this.segundos = this.segundos < 0 ? 60 + this.segundos : this.segundos;
		// this.minutos -= (this.segundos + qtdSegundos)/60;
		// this.minutos %= 60;
		// this.minutos = this.minutos < 0 ? 60 + this.minutos : this.minutos;
		// this.horas -= (this.minutos + ((this.segundos + qtdSegundos)/60))/60;
		// this.horas %= 24;
		// this.horas = this.horas < 0 ? 24 + this.horas : this.horas;
	}


	public String toString(){
		return (horas < 10 ? "0"+horas:horas)
			+":"+
			(minutos < 10 ? "0"+minutos:minutos)
			+":"+
			(segundos < 10 ? "0"+segundos:segundos);
	}

}