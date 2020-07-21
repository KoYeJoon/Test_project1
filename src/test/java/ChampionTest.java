import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    //값을 미리 넣어놓음
    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());

        //championList는 비어있지 않므로 오류남
        assertThat(championList,empty());
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        String lck = "LCK";
        assertThat(lck, notNullValue());

        //chmpionName은 비어있지 않으므로 테스트 통과
        String championName = championList.get(0).getName();
        assertThat(championName,notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());

        //chmpionName은 비어있지 않으므로 테스트 통과 못함
        String championName = championList.get(0).getName();
        assertThat(championName,nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";

        //오류가 안남
        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleString2, is(endsWith(endString)));

        //오류가 날 것임 (sampleString1에는 끝에 point가 없음 )
        assertThat(sampleString1,is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        assertThat(3.14, closeTo(3, 0.2));

        //오류가난다 3.14는 3으로부터 0.1보다  많이 떨어졌으므로
        assertThat(3.14, closeTo(3, 0.1));
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        //값이 있는지만 체크하는 것
        assertThat(championList.get(2), anything());

        //championList 0번째에는 값이 있으므로 오류 안날 것임
        assertThat(championList.get(0),anything());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        assertTrue(championList.size() == 5);
        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5));

        //championList size는 4가 아니므로 이는 오류가 나지 않을 것임
        assertFalse(championList.size()==4);
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));
        assertThat("타릭", equalTo(supportChamp.getName()));

        //타릭과 다리우스는 다르므로 오류가 날것임
        assertThat(championList.get(0).getName(), is(supportChamp.getName()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
        assertThat(championList.get(0),hasProperty("name"));
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        System.out.println("champion :: " + championList.get(0));

        //name이 다리우스로 같으므로 오류가 안날 것임
        assertThat(championList.get(0),hasProperty("name",equalTo("다리우스")));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
        //문자열 전체 비교
        assertThat(champListNames.get(0), hasToString("루시안"));

        //오류남
        assertThat(champListNames.get(0),hasToString("루시"));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));


        assertThat(championNames1, samePropertyValuesAs(Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르")));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        //optional : 객체가 확정되지 않았을 때 감싸는 객체
        //championlist를 stream으로 나열
        //왼쪽에 run하는 곳에 잘누르면 빨간점 찍어서 디버깅 가능
        //step over :  다음 스텝으로 감 step into: 안으로 들어감
        Optional<Champion> filterdChampion = championList.stream()
                //탑 포지션에서
                .filter(c -> c.getPosition().equals("탑"))
                // 첫 번째인거 (현재는 하나여서 효과가 없음 )
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));

        //filter 정글 포지션은 리신이어야 하는 경우
        Optional<Champion> filterdChampion2 = championList.stream()
                .filter(c -> c.getPosition().equals("정글"))
                .findFirst();
        String champName2 = filterdChampion2.get().getName();
        assertTrue(champName2.equals("리신"));
        assertThat("리신", is(champName2));
    }

}