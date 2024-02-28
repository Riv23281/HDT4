import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class ExpressionEvaluator {
    public ExpressionEvaluator(IStack<Character> operatorStack, IStack<Double> valueStack) {
    }

    public double evaluateFromFile(String filename) throws IOException {
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

    private double evaluatePostfix(String postfixExpression) {
        Stack<Double> operandStack = new Stack<>();

        for (char token : postfixExpression.toCharArray()) {
            if (Character.isDigit(token)) {
                operandStack.push((double) (token - '0'));
            } else if (isOperator(token)) {
                double rightOperand = operandStack.pop();
                double leftOperand = operandStack.pop();
                operandStack.push(performOperation(leftOperand, rightOperand, token));
            }
        }

        return operandStack.pop();
    }

    private String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char token : infixExpression.toCharArray()) {
            if (Character.isDigit(token)) {
                postfix.append(token);
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(token);
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();  // Elimina el paréntesis izquierdo.
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }

    private double performOperation(double leftOperand, double rightOperand, char operator) {
        switch (operator) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '*':
                return leftOperand * rightOperand;
            case '/':
                return leftOperand / rightOperand;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operator);
        }
    }
}
