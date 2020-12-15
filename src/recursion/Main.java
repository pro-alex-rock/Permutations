package recursion;

/*
may fall down due to stack overflow. Bad option
*/

public class Main {
    public static void main(String[] args) {
        String s = "алюминиевый красный красный очень очень компьютер";
        Permutation per = new Permutation(s);
        per.permutation(per.getStrings(), 0);
    }
}
