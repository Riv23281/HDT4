public class ExpressionEvaluator {
    private IStack<Character> operatorStack;
    private IStack<Double> valueStack;

    public ExpressionEvaluator(IStack<Character> operatorStack, IStack<Double> valueStack) {
        this.operatorStack = operatorStack;
        this.valueStack = valueStack;
    }

    // Implementación del algoritmo Shunting Yard y la evaluación de expresiones...
}
