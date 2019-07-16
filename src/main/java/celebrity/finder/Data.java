package celebrity.finder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class Data {
   public static int[][] fromClass() {
      int[][] data = { { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0 } };
      return data;
   }

   public static int[][] fromDB(DataSource ds) {
      // Make connection and retrieve data
      return new int[0][0];
   }

   public static int[][] fromFile(String path) throws FileNotFoundException, IOException {
      return fromFile(new File(path));
   }

   public static int[][] fromFile(File file) throws FileNotFoundException, IOException {
      try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
         ArrayList<int[]> list = new ArrayList<int[]>();
         String line;
         while ((line = br.readLine()) != null) {
            String[] a = line.split(",");
            int[] integers = new int[a.length];
            for (int i = 0; i < integers.length; i++) {
               integers[i] = Integer.parseInt(a[i]);
            }
            list.add(integers);
         }
         int[][] data = new int[list.size()][0];
         return list.toArray(data);
      }
   }

   public static int[][] fromResource(String resource) throws FileNotFoundException, IOException {
      File file = new File(Data.class.getClassLoader().getResource(resource).getFile());
      return fromFile(file);
   }

}
