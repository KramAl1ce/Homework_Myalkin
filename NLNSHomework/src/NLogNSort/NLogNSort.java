package NLogNSort;

import java.util.Arrays;

public class NLogNSort {
    private static void merge(int[] hdata, int a, int p, int q) {
        int e = q - a + 1;
        int[] Array = new int[e];

        int i = a;
        int j = p + 1;
        int k = 0;

        while (i <= p || j <= q) {
            if (i > p)
                Array[k++] = hdata[j++];
            else if (j > q)
                Array[k++] = hdata[i++];
            else if (hdata[i] < hdata[j])
                Array[k++] = hdata[i++];
            else
                Array[k++] = hdata[j++];
        }
        for (j = 0; j < e; j++)
            hdata[a + j] = Array[j];
    }

    public void sort(int[] data)
    {
    }
}