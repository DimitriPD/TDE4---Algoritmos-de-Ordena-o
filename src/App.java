import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> fileNames = Arrays.asList("aleatorio_100.csv", "aleatorio_1000.csv", "aleatorio_10000.csv", "crescente_100.csv", "crescente_1000.csv", "crescente_10000.csv", "decrescente_100.csv", "decrescente_1000.csv", "decrescente_10000.csv");

        for (String file : fileNames) {
            ExecuteSortOperations(file);   
        }
    }

    private static ArrayList<Long> GetArrayFromFile(String fileName) throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + fileName);
        
        String dados = new String(Files.readAllBytes(file.toPath()));
        String[] stringArray = dados.split("\n");

        ArrayList<Long> array = new ArrayList<>();

        for (int i = 1; i < stringArray.length; i++) {
            String element = stringArray[i].trim();

            array.add(Long.valueOf(element));
        }

        return array;
    }

    private static void ExecuteSortOperations(String fileName) throws IOException {
        System.out.println("Executing Sorts for file: " + fileName);
        ArrayList<Long> array = GetArrayFromFile(fileName);
        long start, end, mileseconds;

        System.out.print("BubbleSort Time: ");
        ArrayList<Long> bubbleArray = new ArrayList<>(array);
        start = System.nanoTime();
        Sort.BubbleSort(bubbleArray);
        end = System.nanoTime();
        mileseconds = (end - start) / 1000000;
        System.out.println(mileseconds + " ms");

        System.out.print("InsertionSort Time: ");
        ArrayList<Long> insertionArray = new ArrayList<>(array);
        start = System.nanoTime();
        Sort.InsertionSort(insertionArray);
        end = System.nanoTime();
        mileseconds = (end - start) / 1000000;
        System.out.println(mileseconds + " ms");

        System.out.print("QuickSort Time: ");
        ArrayList<Long> quickArray = new ArrayList<>(array);
        start = System.nanoTime();
        Sort.QuickSort(quickArray, 0, quickArray.size() - 1);
        end = System.nanoTime();
        mileseconds = (end - start) / 1000000;
        System.out.println(mileseconds + " ms");

        System.out.println("\n --------------------------- \n");
    }
}
