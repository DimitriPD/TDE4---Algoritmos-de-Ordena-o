import java.util.ArrayList;
import java.util.Random;

public class Sort {
    
    public static ArrayList<Long> BubbleSort(ArrayList<Long> array) {

        for(int i = 0; i < array.size() - 1; i++) {
			for(int j = 0; j < array.size() - i - 1; j++) {
				if(array.get(j) > array.get(j+1)) {
					long temp = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, temp);
				}
			}
		}

        return array;
    }

    public static ArrayList<Long> InsertionSort(ArrayList<Long> array) {

        for(int i = 1; i < array.size(); i++) {
			long temp = array.get(i);
			int j = i - 1;
			
			while(j >= 0 && array.get(j) > temp) {
                array.set(j + 1, array.get(j));
				j--;
			}
            array.set(j + 1, temp);
		}

        return array;
    }

    public static ArrayList<Long> QuickSort(ArrayList<Long> array, int start, int end) {

        if(end > start) {
            int pivotIndex = randomPivot(start, end);

            long temp = array.get(pivotIndex);
            array.set(pivotIndex, array.get(end));
            array.set(end, temp);

            int pivot = Partition(array, start, end);
            QuickSort(array, start, pivot - 1);
            QuickSort(array, pivot + 1, end);		
        }

        return array;
	}

	private static int Partition(ArrayList<Long> array, int start, int end) {

		long pivot = array.get(end); 
		int i = start - 1;
		
		for(int j = start; j <= end; j++) {
			if(array.get(j) < pivot) {
				i++;
				long temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
			}
		}
		i++;
		long temp = array.get(i);
        array.set(i, array.get(end));
        array.set(end, temp);

		return i;
	}

     private static int randomPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }
}
