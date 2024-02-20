import java.util.Arrays;
import java.util.Objects;

public class DynamicIntegerArray {

    private Integer[] elementData;
    private int size = 0;

    public DynamicIntegerArray() {
        this(10);
    }
    public DynamicIntegerArray(int initialCapacity) {
        this.elementData = new Integer[initialCapacity];
    }

    public boolean add(Integer item) {
        if (size == elementData.length)
            grow();
        elementData[size] = item;
        size++;
        return true;
    }

    public Integer get(int index) {
        Objects.checkIndex(index, elementData.length);
        return elementData[index];
    }

    public Integer remove(int index) {
        Objects.checkIndex(index, elementData.length);
        Integer oldValue = elementData[index];
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
        }
        elementData[size = newSize] = null;
        return oldValue;
    }

    public boolean remove(Integer o) {
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

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }

    public static void main(String[] args) {
        DynamicIntegerArray array = new DynamicIntegerArray();
        array.add(12);
        array.add(3);
        array.add(null);
        array.add(25);
        array.add(50);
        array.add(55);
        System.out.println(array);
        System.out.println(array.get(2));
        System.out.println(array.remove(null));
        System.out.println(array.remove(new Integer("55")));
        System.out.println(array);
    }
}
