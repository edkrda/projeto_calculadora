package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários das operações e das validações da classe {@link Calculadora}.
 */
class TesteCalculadora {

    private Calculadora calculadora;

    @BeforeEach
    void prepararCalculadora() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar dois números")
    void deveSomar() {
        assertEquals(15, calculadora.calc(10, 5, "+"));
        assertEquals(15, calculadora.getR());
    }

    @Test
    @DisplayName("Deve subtrair dois números")
    void deveSubtrair() {
        assertEquals(5, calculadora.calc(10, 5, "-"));
    }

    @Test
    @DisplayName("Deve multiplicar dois números")
    void deveMultiplicar() {
        assertEquals(50, calculadora.calc(10, 5, "*"));
    }

    @Test
    @DisplayName("Deve dividir dois números com resultado inteiro")
    void deveDividir() {
        assertEquals(4, calculadora.calc(20, 5, "/"));
    }

    @Test
    @DisplayName("Deve realizar divisão inteira")
    void deveTruncarParteDecimalDaDivisaoInteira() {
        assertEquals(3, calculadora.calc(10, 3, "/"));
    }

    @Test
    @DisplayName("Deve aceitar números negativos")
    void deveTrabalharComNumerosNegativos() {
        assertEquals(-7, calculadora.calc(-10, 3, "+"));
    }

    @Test
    @DisplayName("Deve rejeitar divisão por zero com mensagem clara")
    void deveRejeitarDivisaoPorZero() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calc(10, 0, "/")
        );

        assertEquals("Não é possível dividir por zero.", erro.getMessage());
    }

    @Test
    @DisplayName("Deve rejeitar operador não suportado")
    void deveRejeitarOperadorInvalido() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calc(10, 2, "%")
        );

        assertEquals("Operação inválida: use +, -, * ou /.", erro.getMessage());
    }

    @Test
    @DisplayName("Deve rejeitar operador nulo")
    void deveRejeitarOperadorNulo() {
        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calc(10, 2, null)
        );

        assertEquals(
                "Operação inválida: o operador não pode ser nulo.",
                erro.getMessage()
        );
    }

    @Test
    @DisplayName("Erro não deve sobrescrever o último resultado válido")
    void erroNaoDeveAlterarUltimoResultadoValido() {
        calculadora.calc(8, 2, "+");

        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calc(10, 0, "/")
        );

        assertEquals(10, calculadora.getR());
    }
}
