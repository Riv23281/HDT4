import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Por favor, elija la implementación deseada para el stack:");
            System.out.println("1. ArrayList");
            System.out.println("2. Vector");
            System.out.println("3. Lista");

            String stackTypeChoice = scanner.nextLine().toLowerCase();

            IStack<Character> operatorStack;
            IStack<Double> valueStack;

            switch (stackTypeChoice) {
                case "1", "arraylist":
                    operatorStack = StackFactory.createStack("array");
                    valueStack = StackFactory.createStack("array");
                    break;
                case "2", "vector":
                    operatorStack = StackFactory.createStack("array");
                    valueStack = StackFactory.createStack("array");
                    break;
                case "3", "lista":
                    System.out.println("Por favor, elija la implementación deseada para la lista:");
                    System.out.println("1. Simplemente encadenada");
                    System.out.println("2. Doblemente encadenada");

                    String listTypeChoice = scanner.nextLine().toLowerCase();
                    if ("1".equals(listTypeChoice) || "simplemente encadenada".equalsIgnoreCase(listTypeChoice)) {
                        operatorStack = StackFactory.createStack("linked");
                        valueStack = StackFactory.createStack("linked");
                    } else if ("2".equals(listTypeChoice) || "doblemente encadenada".equalsIgnoreCase(listTypeChoice)) {
                        operatorStack = StackFactory.createStack("doubleLinked");
                        valueStack = StackFactory.createStack("doubleLinked");
                    } else {
                        System.out.println("Opción no válida. Se utilizará la implementación de lista simplemente encadenada por defecto.");
                        operatorStack = StackFactory.createStack("linked");
                        valueStack = StackFactory.createStack("linked");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Se utilizará la implementación de stack basada en ArrayList por defecto.");
                    operatorStack = StackFactory.createStack("array");
                    valueStack = StackFactory.createStack("array");
                    break;
            }

            System.out.println("Por favor, ingrese el nombre del archivo que contiene la expresión matemática:");
            String filename = scanner.nextLine();

            ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator(operatorStack, valueStack);

            try {
                double result = expressionEvaluator.evaluateFromFile(filename);
                System.out.println("El resultado de la expresión matemática es: " + result);
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }
}
