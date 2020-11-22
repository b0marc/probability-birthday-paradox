package es.bmark.birthday_paradox;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numeros1 = random.ints(23, 1, 365)
                .boxed()
                .collect(Collectors.toList());

        System.err.println(">>> TODOS LOS NUMEROS");
        numeros1.forEach(System.out::println);

        List<Integer> duplicados = numeros1.stream().mapToInt(Integer::intValue)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.err.println("NUMEROS REPETIDOS");
        duplicados.forEach(System.out::println);
    }
}
