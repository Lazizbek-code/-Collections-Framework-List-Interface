import java.util.List;

public class ListInterfaceTest {
    public static void main(String[] args) {
        List<Integer> integers = List.of(12,25,10);

        for (int number:integers){
            System.out.println(number);
        }
    }
}
