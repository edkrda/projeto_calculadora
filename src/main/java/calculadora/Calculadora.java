
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

    /**
     * Executa uma operação aritmética entre dois números inteiros.
     *
     * @param a primeiro número da operação
     * @param b segundo número da operação
     * @param op operador: {@code +}, {@code -}, {@code *} ou {@code /}
     * @return resultado inteiro da operação
     * @throws IllegalArgumentException se o operador for inválido ou nulo
     * @throws ArithmeticException se houver divisão por zero
     */
    public int calc(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException(
                    "Operação inválida: o operador não pode ser nulo."
            );
        }

        switch (op) {
            case "+":
                return somar(a, b);
            case "-":
                return subtrair(a, b);
            case "*":
                return multiplicar(a, b);
            case "/":
                return dividir(a, b);
            default:
                throw new IllegalArgumentException(
                        "Operação inválida: use +, -, * ou /."
                );
        }
    }

    /**
     * Soma dois números inteiros.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da soma
     */
    private int somar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número do primeiro.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da subtração
     */
    private int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return resultado da multiplicação
     */
    private int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide o primeiro número pelo segundo.
     *
     * @param a dividendo
     * @param b divisor
     * @return resultado inteiro da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    private int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException(
                    "Não é possível dividir por zero."
            );
        }

        return a / b;
    }
}
