import java.util.ArrayList;
import java.util.List;

public abstract class AbstractList<T> implements IList<T> {
    protected List<T> list;

    public AbstractList() {
        list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void add(T value) {
        list.add(value);
    }

    @Override
    public void remove(T value) {
        list.remove(value);
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }
}
