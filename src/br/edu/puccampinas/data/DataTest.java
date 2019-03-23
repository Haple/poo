package br.edu.puccampinas.data;

public class DataTest {
  public static void main(String[] args) throws Exception {
    Data d = new Data(1, 3, 2019);
    System.out.println("Data inicial: " + d);
    System.out.println("Próxima data: " + d.proxima());
    System.out.println("Data anterior: " + d.anterior());
  }
}
