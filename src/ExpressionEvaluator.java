import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        try {
            String infixExpression = readExpressionFromFile("datos.txt");
            System.out.println("Infix Expression: " + infixExpression);

            String postfixExpression = infixToPostfix(infixExpression);
            System.out.println("Postfix Expression: " + postfixExpression);

            int result = evaluatePostfix(postfixExpression);
            System.out.println("Result: " + result);
        } catch (IOException e) {
            System.err.println("Error reading expression from file: " + e.getMessage());
        }
    }

    public static String readExpressionFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder expression = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            expression.append(line.trim());
        }
        reader.close();
        return expression.toString();
    }

    public static String infixToPostfix(String infixExpression) {
    StringBuilder postfix = new StringBuilder();
    Stack<Character> operatorStack = new Stack<>();

    for (char token : infixExpression.toCharArray()) {
        if (Character.isDigit(token)) {
            postfix.append(token).append(" ");
        } else if (isOperator(token)) {
            while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                postfix.append(operatorStack.pop()).append(" ");
            }
            operatorStack.push(token);
        } else if (token == '(') {
            operatorStack.push(token);
        } else if (token == ')') {
            while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                postfix.append(operatorStack.pop()).append(" ");
            }
            operatorStack.pop(); // Pop '(' from stack
        }
    }

    while (!operatorStack.isEmpty()) {
        postfix.append(operatorStack.pop()).append(" ");
    }

    return postfix.toString().trim();
}

public static int evaluatePostfix(String postfixExpression) {
    Stack<Integer> operandStack = new Stack<>();
    StringTokenizer tokenizer = new StringTokenizer(postfixExpression, " ");

    while (tokenizer.hasMoreTokens()) {
        String token = tokenizer.nextToken();

        if (Character.isDigit(token.charAt(0))) {
            operandStack.push(Integer.parseInt(token));
        } else {
            int operand2 = operandStack.pop();
            int operand1 = operandStack.pop();
            int result = performOperation(operand1, operand2, token.charAt(0));
            operandStack.push(result);
        }
    }

    return operandStack.pop();
}

public static boolean isOperator(char token) {
    return token == '+' || token == '-' || token == '*' || token == '/';
}

public static int precedence(char operator) {
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

public static int performOperation(int operand1, int operand2, char operator) {
    switch (operator) {
        case '+':
            return operand1 + operand2;
        case '-':
            return operand1 - operand2;
        case '*':
            return operand1 * operand2;
        case '/':
            if (operand2 == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return operand1 / operand2;
        default:
            throw new IllegalArgumentException("Invalid operator");
    }
}

}
