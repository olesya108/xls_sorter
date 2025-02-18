package excel.element.sort;

import excel.sort.Sorter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 */
public class SorterTest {

    private static Sorter sorter;

    @BeforeAll
    public static void init() {
        sorter = new Sorter();
    }

    @Test
    public void simpleSort() {
        int[] arr = new int[]{6, 4, 5, 3, 1, 2};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, arr);
    }

    //todo implement more tests

}
