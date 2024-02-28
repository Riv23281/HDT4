import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;


public class ExpressionEvaluator {
    private IStack<Character> operatorStack;
    private IStack<Double> valueStack;

    public ExpressionEvaluator(IStack<Character> operatorStack, IStack<Double> valueStack) {
        this.operatorStack = operatorStack;
        this.valueStack = valueStack;
    }

    public double evaluateFromFile(String filename) {
        try {
            String infixExpression = readFromFile(filename);
            String postfixExpression = infixToPostfix(infixExpression);
            return evaluatePostfix(postfixExpression);
        } catch (IOException e) {
            // Manejo de excepciones al leer el archivo.
            e.printStackTrace();
            return 0.0;  // o algún valor predeterminado según el caso.
        }
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
            } else if (token == '+') {
                operandStack.push(operandStack.pop() + operandStack.pop());
            } else if (token == '-') {
                double rightOperand = operandStack.pop();
                double leftOperand = operandStack.pop();
                operandStack.push(leftOperand - rightOperand);
            } else if (token == '*') {
                operandStack.push(operandStack.pop() * operandStack.pop());
            } else if (token == '/') {
                double divisor = operandStack.pop();
                double dividend = operandStack.pop();
                operandStack.push(dividend / divisor);
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
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();  // Elimina el paréntesis izquierdo.
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(token);
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
}