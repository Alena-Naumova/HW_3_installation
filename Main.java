package JavaCore.HW_3;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        StringBuilder sb = new StringBuilder();
        List<File> folder = Arrays.asList(
                new File("D://Games"),
                new File("D://Games/src"),
                new File("D://Games/res"),
                new File("D://Games/saveGames"),
                new File("D://Games/temp"),
                new File("D://Games/src/main"),
                new File("D://Games/src/test"),
                new File("D://Games/res/drawables"),
                new File("D://Games/res/vectors"),
                new File("D://Games/res/icons")
        );

        List<File> files = Arrays.asList(
                new File("D://Games/src/main", "main.java"),
                new File("D://Games/src/main", "utils.java"),
                new File("D://Games/temp", "temp.txt")
        );

        folder.forEach(f -> {
            if (f.mkdir()) sb.append("Каталог ").append(folder).append(" создан\n");
            else sb.append("Каталог ").append(folder).append(" не создан\n");
        });

        files.forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл ").append(files).append(" создан\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        try(FileWriter f = new FileWriter("D://Games/temp/temp.txt")) {
            f.write(sb.toString());
            f.flush();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        try (BufferedReader b = new BufferedReader(new FileReader("D://Games//temp//temp.txt"))) {
            String s;
            while ((s = b.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }






    }

}
