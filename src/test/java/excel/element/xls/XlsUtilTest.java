package excel.element.xls;

import excel.util.XlsUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 */
public class XlsUtilTest {

    private final static String path = "src/test/resources/xls/example.xlsx";

    @Test
    public void simpleRead() throws Exception {
        int[] arr = XlsUtil.readInts(path);
        assertArrayEquals(new int[]{6, 3, 4, 1, 2, 5}, arr);
    }

    //todo implement more tests

}
