package lexer;

import java.util.Scanner;

public class Main {

    private static final Token EOF_TOKEN = new Token(TokenType.EOF, "");

    public static void main(String[] args) {
        startRepl();
    }

    public static void startRepl() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lexer REPL — escribe código para tokenizarlo. Escribe salir() para salir.");

        while (true) {
            System.out.print(">> ");
            if (!scanner.hasNextLine()) break;

            String source = scanner.nextLine();
            if (source.equals("salir()")) break;

            Lexer lexer = new Lexer(source);
            Token token;
            while (!(token = lexer.nextToken()).equals(EOF_TOKEN)) {
                System.out.println(token);
            }
        }

        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}
