package br.edu.puccampinas.data;

public class Data {
  private int dia, mes, ano;

  private static boolean bissexto(int ano) {
    if (ano % 400 == 0)
      return true;
    if (ano % 4 == 0 && ano % 100 != 0)
      return true;
    return false;
  }

  private static boolean valida(int dia, int mes, int ano) {
    if (dia < 1 || dia > 31)
      return false;
    if (mes < 1 || mes > 12)
      return false;
    if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30)
      return false;
    if (dia > 29 && mes == 2)
      return false;
    if (dia > 28 && mes == 2 && !Data.bissexto(ano))
      return false;
    return true;
  }

  public Data(int dia, int mes, int ano) throws Exception {
    if (!Data.valida(dia, mes, ano))
      throw new Exception("Data invalida");
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  public void setDia(int dia) throws Exception {
    if (!Data.valida(dia, this.mes, this.ano))
      throw new Exception("Data invalida");

    this.dia = dia;
  }

  public void setMes(int mes) throws Exception {
    if (!Data.valida(this.dia, mes, this.ano))
      throw new Exception("Data invalida");

    this.mes = mes;
  }

  public void setAno(int ano) throws Exception {
    if (!Data.valida(this.dia, this.mes, ano))
      throw new Exception("Data invalida");

    this.ano = ano;
  }

  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  public Data proxima() {
    try {
      Data d = new Data(this.dia + 1, mes, ano);
      return d;
    } catch (Exception e) {
    }
    try {
      Data d = new Data(1, mes + 1, ano);
      return d;
    } catch (Exception e) {
    }
    try {
      Data d = new Data(1, 1, ano + 1);
      return d;
    } catch (Exception e) {
      return null;
    }
  }

  public Data anterior() {
    try {
      Data d = new Data(this.dia - 1, mes, ano);
      return d;
    } catch (Exception e) {
    }
    try {
      Data d = new Data(31, mes - 1, ano);
      return d;
    } catch (Exception e) {
    }
    try {
      Data d = new Data(30, mes - 1, ano);
      return d;
    } catch (Exception e) {
    }
    try {
      Data d = new Data(29, mes - 1, ano);
      return d;
    } catch (Exception e) {
    }
    try {
      Data d = new Data(28, mes - 1, ano);
      return d;
    } catch (Exception e) {
    }
    try {
      Data d = new Data(31, 12, ano - 1);
      return d;
    } catch (Exception e) {
      return null;
    }
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (this.getClass() != obj.getClass())
      return false;
    Data other = (Data) obj;
    if (this.getAno() != other.getAno())
      return false;
    if (this.getDia() != other.getDia())
      return false;
    if (this.getMes() != other.getMes())
      return false;
    return true;
  }

  public String toString() {
    return (this.dia < 10 ? "0" : "") + this.dia + "/" + (this.mes < 10 ? "0" : "") + this.mes + "/"
        + (this.ano < 0 ? -this.ano : this.ano) + (this.ano < 0 ? "AC" : "");
  }
}

