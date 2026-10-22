
package calculadora;

/**
 * Realiza operações aritméticas básicas para o módulo financeiro do FinançApp.
 *
 * <p>A classe aceita dois números inteiros e um operador.
 * Os operadores permitidos são {@code +}, {@code -},
 * {@code *} e {@code /}.</p>
 *
 * @author Nome do aluno
 * @version 2.0
 */
public class Calculadora {

    /** Armazena o resultado da última operação concluída com sucesso. */
    private int r;

    /**
     * Executa uma operação aritmética entre dois números inteiros.
     *
     * @param a primeiro número da operação
     * @param b segundo número da operação
     * @param op operador: {@code +}, {@code -}, {@code *} ou {@code /}
     * @return resultado inteiro da operação
     * @throws IllegalArgumentException se o operador for inválido ou nulo,
     *                                  ou se houver divisão por zero
     */
    public int calc(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException(
                    "Operação inválida: o operador não pode ser nulo."
            );
        }

        int resultado;

        switch (op) {
            case "+":
                resultado = somar(a, b);
                break;
            case "-":
                resultado = subtrair(a, b);
                break;
            case "*":
                resultado = multiplicar(a, b);
                break;
            case "/":
                resultado = dividir(a, b);
                break;
            default:
                throw new IllegalArgumentException(
                        "Operação inválida: use +, -, * ou /."
                );
        }

        r = resultado;
        return r;
    }

    /** @return resultado da soma */
    private int somar(int a, int b) {
        return a + b;
    }

    /** @return resultado da subtração */
    private int subtrair(int a, int b) {
        return a - b;
    }

    /** @return resultado da multiplicação */
    private int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Realiza uma divisão inteira.
     *
     * @throws IllegalArgumentException se o divisor for zero
     */
    private int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException(
                    "Não é possível dividir por zero."
            );
        }

        return a / b;
    }

    /**
     * Retorna o resultado da última operação concluída com sucesso.
     *
     * @return último resultado calculado; inicialmente, zero
     */
    public int getR() {
        return r;
    }
}
