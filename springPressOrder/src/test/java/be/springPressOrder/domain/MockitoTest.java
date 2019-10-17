package be.springPressOrder.domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;



public class MockitoTest {
    @Mock
    IMockitoService iMockitoService;

    public static int validQuantityRange() {
        return and(gt(0), lt(100));
    }

    public static int validMaxQuantity() {
        return eq(100);
    }

    public static int validMinQuantity() {
        return eq(0);
    }

    public static Fruit validFruit() {
        Fruit fruit = new Fruit("peer");
        return fruit;
    }

    @BeforeEach
    void setUp() {
        initMocks(this);

        Mockito.when(iMockitoService.checkValidRangeQuantity(validQuantityRange()))
                .thenReturn(true);
        Mockito.when(iMockitoService.checkValidRangeQuantity(not(validQuantityRange())))
                .thenReturn(false);

        Fruit fruit = new Fruit("peer");
        Mockito.when(iMockitoService.checkFruit(not(fruit))).thenReturn("Geen correct fruit");

        Mockito.when(iMockitoService.checkMaxquantityFruit(not(validMaxQuantity()))).thenReturn("Geen getal boven de 100");
        Mockito.when(iMockitoService.checkMaxquantityFruit(validMaxQuantity())).thenReturn("Goede max waarde");

        Mockito.when(iMockitoService.checkMinquantityFruit(not(validMinQuantity()))).thenReturn("Geen getal onder de 0");
        Mockito.when(iMockitoService.checkMinquantityFruit(validMinQuantity())).thenReturn("Goede min waarde");
    }


    @Test
    void test1 () {
        Fruit fruit = new Fruit("appel");
        assertEquals("Geen correct fruit", iMockitoService.checkFruit(fruit));
    }
}
