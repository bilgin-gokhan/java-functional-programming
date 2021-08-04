package functionalinterface;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multipleByTenFunction.apply(2);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneAndThenMultiplyByTen =
                incrementByOneFunction.andThen(multipleByTenFunction);
        System.out.println(addByOneAndThenMultiplyByTen.apply(4));

    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multipleByTenFunction =
            number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }
}
