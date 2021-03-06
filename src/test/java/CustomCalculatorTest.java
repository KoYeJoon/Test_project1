
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result==25);

        //Hamcrest
        assertThat(result,is(25));
        System.out.println("result :: " + result);

        assertFalse(result == 10);
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result==13);
        assertFalse(result == 12);
        assertThat(result,is(13));
        System.out.println("result :: " + result);

        assertFalse(result == 1);
    }

    //서로다른 테스트의 경우 따로 함수로 정의하는 것이 좋을 수 있음.
    @Test
    public void 빼기테스트(){
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        assertFalse(result == 12);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertThat(result, is(45));
        System.out.println("result :: " + result);

        assertTrue(result == 45);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertThat(result,is(5));
        System.out.println("result :: " + result);

        assertTrue(result==5);
    }


    //timeout Test
    @Test(timeout = 4000)
    public void timeInMethodTest() throws InterruptedException {
        Thread.sleep(2000);
    }


    //오류날 것임 , timeout시간 넘김
    @Test(timeout = 3000)
    public void 시간제한체크() throws InterruptedException{
        Thread.sleep(4000);
    }


    //없는 값을 참조하므로 오류가 나야하는데 뒤에 (expected = IndexOutOfBoundsException.class) 하면 오류가 안남...?
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyIndexOutOfBoundException() {
        new ArrayList<Object>().get(0);
    }


    @Test
    public void testMethod() {
        ArrayList<Object> myList = new ArrayList<>();
        assertThat(myList,is(empty()));
    }

    @Test
    public void isEmptyArray(){
        ArrayList<Object>myList = new ArrayList<>();
        assertThat(myList,is(empty()));
    }

}