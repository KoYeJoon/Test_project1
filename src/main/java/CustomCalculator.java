//class 위에 알트 엔터누르고 test create누르면 테스트 생성 가능
public class CustomCalculator {
    //함수이름 바꾸고 싶을 때 함수 이름에 우클릭 -> refactor->rename
    //호출한 곳의 이름이 다 바뀜
    public int add(int valueNum1, int valueNum2){
        return valueNum1 + valueNum2;
    }

    public int subtract(int valueNum1, int valueNum2){
        return valueNum1 - valueNum2;
    }

    public int multiply(int valueNum1, int valueNum2){
        return valueNum1 * valueNum2;
    }

    public int divide(int valueNum1, int valueNum2){
        return valueNum1 / valueNum2;
    }
}
