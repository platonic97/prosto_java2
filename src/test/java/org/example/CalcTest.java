package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @BeforeAll
    public static void setUp(){
        System.out.println("before all");
    }
    @BeforeEach
    public void setUpEach(){
        System.out.println("before each");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("after All");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("after each");
    }


    @ParameterizedTest(name= "#{index} - сложения {0} и {1}, ожидаем {2}")
    @CsvSource ({"1,2,3","-1,2,1","0,0,0"})
    @DisplayName("Проверка сложения")
    @Tag("sum")
    void sum(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.sum(a, b);
        Assertions.assertEquals(expectedResult, result, "Не тот ответ");
    }


    @ParameterizedTest(name= "#{index} - вычитания {0} и {1}, ожидаем {2}")
    @CsvSource ({"4,2,2","5,2,3","1,0,1"})
    @DisplayName("Проверка вычитания")
    @Tag("dif")
    void difference(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.difference(a, b);
        Assertions.assertEquals(expectedResult, result, "Не тот ответ");
    }
}
