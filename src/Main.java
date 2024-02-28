import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

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
