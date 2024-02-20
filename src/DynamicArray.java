import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;

public class DynamicArray<E> implements Iterable<E> {

    private Object[] elementData;
    private int size = 0;

    public DynamicArray() {
        this(10);
    }
    public DynamicArray(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public boolean add(E item) {
        if (size == elementData.length)
            grow();
        elementData[size] = item;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, elementData.length);
        return (E)elementData[index];
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        Objects.checkIndex(index, elementData.length);
        Object oldValue = elementData[index];
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        }
        elementData[size = newSize] = null;
        return (E)oldValue;
    }

    public boolean remove(E o) {
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++) {
                    if (elementData[i] == null) {
                        break found;
                    }
                }
            } else {
                for (; i < size; i++) {
                    if (o.equals(elementData[i])) {
                        break found;
                    }
                }
            }
            return false;
        }
        remove(i);
        return true;
    }

    private void grow() {
        int newCapacity = elementData.length + elementData.length / 2 + 1;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) Arrays.stream(Arrays.copyOf(elementData, size)).iterator();
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }

    public static void main(String[] args) {
        DynamicArray<String> array = new DynamicArray<>();
        array.add("Java");
        array.add("Python");
        array.add(null);
        array.add("PHP");
        array.add("Go");
        System.out.println(array);
        System.out.println(array.get(2));
        System.out.println(array.remove(null));
        System.out.println(array.remove(new String("Java")));
        System.out.println(array);

        for (String arr : array) {
            System.out.println(arr);
        }


        DynamicArray<Student> students = new DynamicArray<>();
        students.add(new Student("Ali"));
        students.add(new Student("Farrux"));
        System.out.println(students);
    }


}

class Student{
    private final String id;
    private final String name;

    public Student(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
