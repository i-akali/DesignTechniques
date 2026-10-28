import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void dataSourceNull() {

        DataSource d3 = new DataSource("DataSource"){
            public List<String> read(){
                return null;
            }
        };
         WordCounter w3 = WordCounter.getInstance();
         w3.setDataSource(d3);

        assertEquals(Collections.EMPTY_MAP, w3.countWords());
    }

    @Test
    void emptySource() {

        DataSource d3 = new DataSource("DataSource"){
            public List<String> read(){
                return Collections.EMPTY_LIST;
            }
        };
        WordCounter w3 = WordCounter.getInstance();
        w3.setDataSource(d3);

        assertEquals(Collections.EMPTY_MAP, w3.countWords());
    }

    @Test
    void multipleDog() {

        DataSource d3 = new DataSource("DataSource"){
            public List<String> read(){
                return List.of("dog", "dog", "cat", "why");
            }
        };
        WordCounter w3 = WordCounter.getInstance();
        w3.setDataSource(d3);

        assertEquals(Map.of("dog", 2, "cat", 1, "why", 1),w3.countWords());
    }

    @Test
    void multipleDogCases() {

        DataSource d3 = new DataSource("DataSource"){
            public List<String> read(){
                return List.of("dog", "DOG", "cat", "why");
            }
        };
        WordCounter w3 = WordCounter.getInstance();
        w3.setDataSource(d3);

        assertEquals(Map.of("dog", 2, "cat", 1, "why", 1),w3.countWords());
    }

}