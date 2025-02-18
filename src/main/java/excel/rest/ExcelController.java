package excel.rest;

import excel.sort.Sorter;
import excel.util.XlsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
@RequestMapping("/excel")
public class ExcelController {

    private final static Logger logger = LoggerFactory.getLogger(ExcelController.class);

    private Sorter sorter;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping(value = "/element")
    public int getNthNumber(@RequestParam(name = "path") String path, @RequestParam(name = "n") int n) throws Exception {

        logger.debug("Request received: n={}, path={} ", n, path);

        int[] arr = XlsUtil.readInts(path);
        if (n < 0 || n > arr.length) {
            throw new IllegalArgumentException("Illegal N value");
        }

        sorter.sort(arr);
        int result = arr[arr.length - n];
        logger.debug("Sending result: {}", result);

        return result;
    }

    @Autowired
    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }
}
