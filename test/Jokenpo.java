import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Main {

    /**
     * Esse m�todo calcula o vencedor do jogo Jokenpo (pedra, papel e tesoura)
     * As escolhas podem ser 1 (papel), 2 (pedra) e 3 (tesoura)
     * 
     * @param jogador1
     *                 Escolha do jogador 1
     * @param jogador2
     *                 Escolha do jogador 2
     * @return 0 se houve empate, 1 se jogador 1 venceu, 2 se jogador 2 venceu,
     *         -1 se op��o � inv�lida
     */
    public int jogar(int jogador1, int jogador2) {
        int retorno = 0;
        if ((jogador1 > 0) && (jogador1 <= 3) && (jogador2 > 0) && (jogador2 <= 3)) {
            if (jogador1 != jogador2) {
                if ((jogador1 - jogador2) == -1 || (jogador1 - jogador2 == 2)) {
                    retorno = 1;
                } else {
                    retorno = 2;
                }
            }
        } else {
            retorno = -1;
        }
        return retorno;
    }
    
    public class TesteJokenpo {
    	 public static void main(String[] args) {
    	 testar(0, 0, 0); // Empate: pedra vs pedra
    	 testar(1, 1, 0); // Empate: papel vs papel
    	 testar(2, 2, 0); // Empate: tesoura vs tesoura

    	 testar(0, 2, 1); // Pedra vence tesoura
    	 testar(1, 0, 1); // Papel vence pedra
    	 testar(2, 1, 1); // Tesoura vence papel

    	 testar(2, 0, 2); // Tesoura perde para pedra
    	 testar(0, 1, 2); // Pedra perde para papel
    	 testar(1, 2, 2); // Papel perde para tesoura

    	 testar(-1, 0, -1); // Inválido
    	 testar(0, 4, -1); // Inválido
    	 testar(5, 2, -1); // Inválido
    	 }

    	 private static void testar(int jogador1, int jogador2, int esperado) {
    	 int resultado = new Main().jogar(jogador1, jogador2);
    	 System.out.printf("Jogador1: %d, Jogador2: %d => Resultado: %d (%s)%n",
    	 jogador1, jogador2, resultado,
    	 resultado == esperado ? "OK" : "FALHOU");
    	 }
    }
    
    public class TesteJokenpo {
   	 public static void main(String[] args) {
   	 testar(0, 0, 0); // Empate: pedra vs pedra
   	 testar(1, 1, 0); // Empate: papel vs papel
   	 testar(2, 2, 0); // Empate: tesoura vs tesoura

   	 testar(0, 2, 1); // Pedra vence tesoura
   	 testar(1, 0, 1); // Papel vence pedra
   	 testar(2, 1, 1); // Tesoura vence papel

   	 testar(2, 0, 2); // Tesoura perde para pedra
   	 testar(0, 1, 2); // Pedra perde para papel
   	 testar(1, 2, 2); // Papel perde para tesoura

   	 testar(-1, 0, -1); // Inválido
   	 testar(0, 4, -1); // Inválido
   	 testar(5, 2, -1); // Inválido
   	 }

   	 private static void testar(int jogador1, int jogador2, int esperado) {
   	 int resultado = new Main().jogar(jogador1, jogador2);
   	 System.out.printf("Jogador1: %d, Jogador2: %d => Resultado: %d (%s)%n",
   	 jogador1, jogador2, resultado,
   	 resultado == esperado ? "OK" : "FALHOU");
   	 }
   }
   
   public class MainTest {

   	 Main main = new Main();

   	 @Test
   	 void testEmpatePedra() {
   		 assertEquals(0, main.jogar(0, 0));
   	 }

   	 @Test
   	 void testEmpatePapel() {
   	 assertEquals(0, main.jogar(1, 1));
   	 }

   	 @Test
   	 void testEmpateTesoura() {
   	 assertEquals(0, main.jogar(2, 2));
   	 }

   	 @Test
   	 void testJogador1Vence() {
   	 assertEquals(1, main.jogar(0, 2)); // Pedra ganha da Tesoura
   	 assertEquals(1, main.jogar(1, 0)); // Papel ganha da Pedra
   	 assertEquals(1, main.jogar(2, 1)); // Tesoura ganha do Papel
   	 }

   	 @Test
   	 void testJogador2Vence() {
   	 assertEquals(2, main.jogar(2, 0)); // Tesoura perde para Pedra
   	 assertEquals(2, main.jogar(0, 1)); // Pedra perde para Papel
   	 assertEquals(2, main.jogar(1, 2)); // Papel perde para Tesoura
   	 }

   	 @Test
   	 void testEntradaInvalida() {
   	 assertEquals(-1, main.jogar(-1, 0));
   	 assertEquals(-1, main.jogar(0, 3));
   	 assertEquals(-1, main.jogar(5, -2));
   	 }
   
    
}