package calculadora;

/**
 * Realiza operações aritméticas básicas para o módulo financeiro do FinançApp.
 *
 * <p>A classe aceita dois números inteiros e um operador. Os operadores
 * permitidos são {@code +}, {@code -}, {@code *} e {@code /}. Se o operador
 * for inválido ou houver tentativa de divisão por zero, o método informa
 * o problema por meio de uma exceção {@link IllegalArgumentException}.</p>
 *
 * @author Nome do aluno
 * @version 1.0
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
     * @throws IllegalArgumentException se o operador for inválido ou se
     *                                  houver divisão por zero
     */
    public int calc(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException(
                    "Operação inválida: o operador não pode ser nulo."
            );
        }

        switch (op) {
            case "+":
                r = a + b;
                break;
            case "-":
                r = a - b;
                break;
            case "*":
                r = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new IllegalArgumentException(
                            "Não é possível dividir por zero."
                    );
                }
                r = a / b;
                break;
            default:
                throw new IllegalArgumentException(
                        "Operação inválida: use +, -, * ou /."
                );
        }

        return r;
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
