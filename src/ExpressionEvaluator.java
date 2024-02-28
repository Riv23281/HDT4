import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExpressionEvaluator {
    private IStack<Character> operatorStack;
    private IStack<Double> valueStack;

    public ExpressionEvaluator(IStack<Character> operatorStack, IStack<Double> valueStack) {
        this.operatorStack = operatorStack;
        this.valueStack = valueStack;
    }

    public int evaluateFromFile(String filename) throws IOException {
        String infixExpression = readFromFile(filename);
        String postfixExpression = infixToPostfix(infixExpression);
        return evaluatePostfix(postfixExpression);
    }

    private String readFromFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

    private int evaluatePostfix(String postfixExpression) {
        return 0; 
    }

    private String infixToPostfix(String infixExpression) {
        
        return "";
    }
}
