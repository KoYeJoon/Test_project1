import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    //null을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_null_input(){
        String str = null;
        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(numberOfUpperCaseCharactersInString,is(0));

        assertFalse(numberOfUpperCaseCharactersInString==1);

    }

    //반겂울 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_empty_input() {
        String str = "";
        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(numberOfUpperCaseCharactersInString,is(0));

        assertFalse(numberOfUpperCaseCharactersInString==1);
    }

    //대문자들이 포함된 문자열을 전달했을 때 카운팅된 숫자와 맞는지 검증하는 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_10_for_ABCDEFGHIJ() {
        String str = "ABCDEFGHIJ";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        //assertTrue로 맞는 테스트 코드 작성
        assertTrue(numberOfUpperCaseCharactersInString ==10);
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        assertFalse(numberOfUpperCaseCharactersInString==1);
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        assertThat(numberOfUpperCaseCharactersInString,is(10));

        assertFalse(numberOfUpperCaseCharactersInString ==11);
    }

    //대소문자가 섞여 있을 때 정확히 카운팅 되는 지에 대한 테스트 코드 작성
    @Test
    public void getNumberOfUpperCaseCharacterInString_return_6_for_ABCdefGHI(){
        String str = "ABCdefGHI";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        //assertTrue로 맞는 테스트 코드 작성
        assertTrue(result==6);
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        assertFalse(result==5);
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        assertThat(result,is(6));
        System.out.println("result :: " + result);

        assertFalse(result==3);
    }

    //잘못된 값을 참조했을 때 IndexOutOfBoundsException Exception이 발생하는지 테스트 코드 작성
    @Test
    public void shouldThrowExceptionWhenGetZeroIndex() {
        new ArrayList<Object>().get(0);

        new ArrayList<Object>().get(1);
    }

    //해당 메소드가 제한된 시간내에 실행되는지에 대한 테스트 코드 작성 : timeout 사용
    //두번째로 해당 메소드는 테스트 하지 않도록 어노테이션 추가 적용 해봅니다. Ignore
    //Ignore하니까 이 test class를 실행시켰을 때 sleep을 6000으로해도 오류가나지 않음
    //@Ignore로 인해 이 함수를 실행하지 않나봄
    @Test(timeout = 5000)
    @Ignore
    public void testShouldRunInLimitedTime() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");


    }
}
