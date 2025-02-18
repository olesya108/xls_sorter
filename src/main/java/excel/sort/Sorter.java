package excel.sort;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 *
 */
@Component
public class Sorter {

    public void sort(int[] arr) {
        Objects.requireNonNull(arr, "Array is null");

        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

    }

}
