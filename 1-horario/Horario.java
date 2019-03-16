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

	public String toString(){
		return (horas < 10 ? "0"+horas:horas)
			+":"+
			(minutos < 10 ? "0"+minutos:minutos)
			+":"+
			(segundos < 10 ? "0"+segundos:segundos);
	}

	public void adiante(int qtdSegundos){
		this.segundos += qtdSegundos;
		this.minutos += this.segundos/60;
		this.segundos %= 60;
		this.horas += this.minutos/60;
		this.minutos %= 60; 
		this.horas %= 24;
	}

	public void atrase(int qtdSegundos){
		this.segundos -= qtdSegundos;
		this.minutos -= this.segundos/60;
		this.segundos %= 60;
		this.horas -= this.minutos/60;
		this.minutos %= 60; 
		this.horas %= 24;
	}

}