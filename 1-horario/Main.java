public class Main{

	public static void main(String[] args){
		System.out.println("Ok!");
		try{
			Horario h = new Horario(0,0,0);
			System.out.println("Horário inicial: " + h);	
			h.setHoras(0);
			h.setMinutos(0);
			h.setSegundos(0);
			System.out.println("Horário modificado: " + h);
			System.out.println("Horas: " + h.getHoras());
			System.out.println("Minutos: " + h.getMinutos());
			System.out.println("Segundos: " + h.getSegundos());
			h.adiante(3600 * 4);
			System.out.println("Horário adiantado: " + h);
			h.atrase(3600 * 3);
			System.out.println("Horário atrasado: " + h);		
		}catch(Exception erro){
			System.out.println("Erro ao criar horário: " + erro.getMessage());
		}
	}

}		