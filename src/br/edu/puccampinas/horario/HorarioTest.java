package br.edu.puccampinas.horario;

import java.util.logging.Logger;

/**
 * Suíte de testes da classe Horário
 * 
 * @author aleph
 *
 */
public class HorarioTest {
  private static final Logger LOGGER = Logger.getLogger(HorarioTest.class.getName());

  /**
   * Driver para iniciar suíte de testes
   * 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    deve_impedir_horas_invalidas();
    deve_impedir_minutos_invalidos();
    deve_impedir_segundos_invalidos();
    deve_adiar_horario();
    deve_atrasar_horario();
    deve_modificar_horario();
    deve_transformar_segundos_em_horario();
    deve_comparar_dois_horarios_iguais();
  }

  private static void deve_impedir_horas_invalidas() throws Exception {
    try {
      Horario h = new Horario(10000, 15, 58);
      throw new Exception("Um horário com horas inválidas foi criado: " + h);
    } catch (Exception e) {
      LOGGER.info("Horas inválidas foram tratadas com sucesso.");
    }
  }

  private static void deve_impedir_minutos_invalidos() throws Exception {
    try {
      Horario h = new Horario(23, 10000, 58);
      throw new Exception("Um horário com minutos inválidos foi criado: " + h);
    } catch (Exception e) {
      LOGGER.info("Minutos inválidos foram tratados com sucesso.");
    }
  }

  private static void deve_impedir_segundos_invalidos() throws Exception {
    try {
      Horario h = new Horario(23, 15, 10000);
      throw new Exception("Um horário com segundos inválidos foi criado: " + h);
    } catch (Exception e) {
      LOGGER.info("Segundos inválidos foram tratados com sucesso.");
    }
  }

  private static void deve_adiar_horario() throws Exception {
    Horario h = new Horario(11, 30, 20);
    // 60 anos e 60 segundos
    h.adiante((86400 * 365 * 60) + 60);
    if (h.getHoras() == 11 && h.getMinutos() == 31 && h.getSegundos() == 20) {
      LOGGER.info("Horário adiantado com sucesso.");
      return;
    }
    throw new Exception("O horário não foi adiantado corretamente: " + h);
  }

  private static void deve_atrasar_horario() throws Exception {
    Horario h = new Horario(11, 30, 20);
    // 60 anos e 60 segundos
    h.atrase((86400 * 365 * 60) + 60);
    if (h.getHoras() == 11 && h.getMinutos() == 29 && h.getSegundos() == 20) {
      LOGGER.info("Horário atrasado com sucesso.");
      return;
    }
    throw new Exception("O horário não foi atrasado corretamente: " + h);
  }

  private static void deve_modificar_horario() throws Exception {
    Horario h = new Horario(13, 15, 58);
    h.setHoras(23);
    h.setMinutos(17);
    h.setSegundos(9);
    if (h.getHoras() == 23 && h.getMinutos() == 17 && h.getSegundos() == 9) {
      LOGGER.info("Horário modificado com sucesso.");
      return;
    }
    throw new Exception("O horário não foi modificado corretamente: " + h);
  }

  private static void deve_transformar_segundos_em_horario() throws Exception {
    Horario h = Horario.segundosEmHorario((86400 * 3) - 1);
    if (h.getHoras() == 23 && h.getMinutos() == 59 && h.getSegundos() == 59) {
      LOGGER.info("Horário transformado com sucesso.");
      return;
    }
    throw new Exception("O horário não foi transformado com sucesso: " + h);
  }

  private static void deve_comparar_dois_horarios_iguais() throws Exception {
    Horario h1 = new Horario(23, 56, 57);
    Horario h2 = new Horario(23, 56, 57);
    if (h1.equals(h2)) {
      LOGGER.info("Os horários foram comparados com sucesso.");
      return;
    }
    throw new Exception("Os horários não foram comparados corretamente:  " + h1 + " e " + h2);
  }
}
