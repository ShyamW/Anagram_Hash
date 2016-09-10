
public class MainApplication {
    public static void main(String[] args) {
        AnagramHash num1 = new AnagramHash("racecarpizza");
        System.out.println(num1.value);
        AnagramHash num2 = new AnagramHash("pzziacarrace");
        System.out.println(num2.value);
    }
}
