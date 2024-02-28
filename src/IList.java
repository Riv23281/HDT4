public interface IList<T> {
    int size();
    boolean isEmpty();
    void add(T value);
    void remove(T value);
    T get(int index);
}
