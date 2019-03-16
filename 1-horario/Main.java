public class Main{

	public static void main(String[] args){
		try{
			Horario h = new Horario(13,15,58);
			System.out.println("Horário inicial: " + h);	
			System.out.println("Horas: " + h.getHoras());
			System.out.println("Minutos: " + h.getMinutos());
			System.out.println("Segundos: " + h.getSegundos());
			h.setHoras(6);
			h.setMinutos(30);
			h.setSegundos(5);
			System.out.println("Horário modificado: " + h);
			h.adiante(3600*5 + 1800 - 5);
			System.out.println("Horário adiantado: " + h);
			h.atrase(400000);
			System.out.println("Horário atrasado: " + h);		
		}catch(Exception erro){
			System.out.println("Erro ao criar horário: " + erro.getMessage());
		}
	}

}		