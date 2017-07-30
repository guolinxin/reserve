package com.xin.reserve.reservationservice.example;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by linxing on 29/07/2017.
 */

public class StreamTest {

    @Test
    public void streamCreateTest() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stringStream = Stream.of("Shuai");
        Stream randomStream = Stream.generate(Math::random);

        System.out.println("IntegerStrea ---> ");
        System.out.println(integerStream);

        System.out.println("StringStream ---> ");
        System.out.println(stringStream);

        System.out.println("ramdon");
        System.out.println(randomStream);

    }

    @Test
    public void streamMethodTest() {
        // map --> transform：e.g.: mapToInt，mapToLong和mapToDouble。

        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

        System.out.println("sum is: ");
        System.out.println(
                nums.stream()
                        .filter(num -> num != null)
                        .distinct()
                        .mapToInt(num -> num * 2)
                        .peek(System.out::println)
                        .skip(2)
                        .limit(4)
                        .sum()
        );
    }

}
