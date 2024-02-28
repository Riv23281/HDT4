import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

/**
 * The Main class is the entry point of the program. It reads an infix expression from a file,
 * converts it to postfix notation, evaluates the postfix expression, and prints the result.
 */
public class Main {
    public static void main(String[] args) {
        try {
            String infixExpression = readExpressionFromFile("datos.txt");
            System.out.println("Infix Expression: " + infixExpression);

            String postfixExpression = ExpressionEvaluator.infixToPostfix(infixExpression);
            System.out.println("Postfix Expression: " + postfixExpression);

            int result = ExpressionEvaluator.evaluatePostfix(postfixExpression);
            System.out.println("Result: " + result);
        } catch (IOException e) {
            System.err.println("Error reading expression from file: " + e.getMessage());
        }
    }

    /**
     * Reads an expression from a file.
     *
     * @param filePath the path of the file containing the expression
     * @return the expression read from the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    private static String readExpressionFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder expression = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            expression.append(line.trim());
        }
        reader.close();
        return expression.toString();
    }
}
