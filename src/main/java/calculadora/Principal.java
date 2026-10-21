package calculadora;

/**
 * Demonstra a utilização da calculadora e apresenta mensagens de erro
 * de forma controlada, sem encerrar inesperadamente a aplicação.
 */
public class Principal {

    /**
     * Ponto de entrada para a demonstração da calculadora.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        demonstrar(calculadora, 1200, 30, "+");
        demonstrar(calculadora, 150, 3, "/");
        demonstrar(calculadora, 120, 30, "*");
        demonstrar(calculadora, 10, 3, "-");
        demonstrar(calculadora, 100, 0, "/");
        demonstrar(calculadora, 10, 5, "%");
    }

    private static void demonstrar(Calculadora calculadora, int a, int b, String op) {
        try {
            int resultado = calculadora.calc(a, b, op);
            System.out.printf("%d %s %d = %d%n", a, op, b, resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
