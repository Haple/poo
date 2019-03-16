package br.edu.puccampinas.horario;

public class Horario {

  private int horas, minutos, segundos;

  /**
   * Constrói um horário baseado nas horas, minutos e segundos específicados, fazendo as devidas
   * validações.
   * 
   * @param horas Horas a serem validadas - de 0 até 23
   * @param minutos Minutos a serem validados - de 0 até 59
   * @param segundos Segundos a serem validados - de 0 até 59
   * @throws Exception Caso alguma parte do horário esteja fora da faixa permitida
   */
  public Horario(int horas, int minutos, int segundos) throws Exception {
    valida(horas, minutos, segundos);
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
  }

  /**
   * Verifica se um horário é válido
   * 
   * @param horas Horas a serem validadas - de 0 até 23
   * @param minutos Minutos a serem validados - de 0 até 59
   * @param segundos Segundos a serem validados - de 0 até 59
   * @throws Exception Caso alguma parte do horário esteja fora da faixa permitida
   */
  private void valida(int horas, int minutos, int segundos) throws Exception {
    if (horas < 0 || horas > 23) {
      throw new Exception("Hora \"" + horas + "\" é inválida!");
    }
    if (minutos < 0 || minutos > 59) {
      throw new Exception("Minutos \"" + minutos + "\" são inválidos!");
    }
    if (segundos < 0 || segundos > 59) {
      throw new Exception("Segundos \"" + segundos + "\" são inválidos!");
    }
  }

  public int getHoras() {
    return this.horas;
  }

  public void setHoras(int horas) throws Exception {
    valida(horas, this.minutos, this.segundos);
    this.horas = horas;
  }

  public int getMinutos() {
    return this.minutos;
  }

  public void setMinutos(int minutos) throws Exception {
    valida(this.horas, minutos, this.segundos);
    this.minutos = minutos;
  }

  public int getSegundos() {
    return this.segundos;
  }

  public void setSegundos(int segundos) throws Exception {
    valida(this.horas, this.minutos, segundos);
    this.segundos = segundos;
  }

  private int emSegundos() {
    return this.segundos + (this.minutos * 60) + (this.horas * 3600);
  }

  /**
   * Transforma uma quantidade de segundos em um horário equivalente
   * 
   * @param qtdSegundos Segundos a serem transformados. Observe que caso os segundos ultrapassem o
   *        equivalente a 86400 segundos, será criado um horário baseado-se na exclusão dos períodos
   *        de 24 horas
   * @return Devolve o horário que a quantidade de segundos representa
   * @throws Exception Caso a quantidade de segundos seja negativa
   */
  public static Horario segundosEmHorario(int qtdSegundos) throws Exception {
    if (qtdSegundos < 0) {
      throw new Exception("Quantidade de segundos inválida!");
    }
    int seg, min, h;
    seg = qtdSegundos % 60;
    min = (qtdSegundos / 60) % 60;
    h = (qtdSegundos / 3600) % 24;
    return new Horario(h, min, seg);
  }

  /**
   * Adianta o horário na quantidade de segundos especificada
   * 
   * @param qtdSegundos Quantidade de segundos a adiantar
   * @throws Exception Caso a quantidade de segundos seja negativa
   */
  public void adiante(int qtdSegundos) throws Exception {
    if (qtdSegundos < 0) {
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

  /**
   * Atrasa o horário na quantidade de segundos especificada
   * 
   * @param qtdSegundos Quantidade de segundos a atrasar
   * @throws Exception Caso a quantidade de segundos seja negativa
   */
  public void atrase(int qtdSegundos) throws Exception {
    if (qtdSegundos < 0) {
      throw new Exception("Quantidade de segundos inválida!");
    }
    final int dia = 86400;
    int atraso = this.emSegundos() - (qtdSegundos % dia);
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


  public String toString() {
    return (horas < 10 ? "0" + horas : horas) + ":" + (minutos < 10 ? "0" + minutos : minutos) + ":"
        + (segundos < 10 ? "0" + segundos : segundos);
  }

}
