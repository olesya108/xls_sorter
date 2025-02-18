package excel.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 */
public class XlsUtil {

    private final static Logger logger = LoggerFactory.getLogger(XlsUtil.class);

    public static int[] readInts(String fileName) throws IOException {

        ArrayList<Integer> ints = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(fileName)) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (Objects.requireNonNull(cell.getCellType()) == CellType.NUMERIC) {
                    ints.add((int) cell.getNumericCellValue());
                } else {
                    logger.error("Non-numeric cell type: {}", cell.getCellType());
                }
            }

        }

        return ints.stream().mapToInt(value -> value).toArray();
    }

}
