import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nozzleMeasures {
    public static void main(String[] args) throws IOException
    {
        //zmień ścieżkę do danych nozzleMeasures.log
        BufferedReader dane = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zestaw 1\\nozzleMeasures.log"));
        String str;

        //NozzleMeasures.log ---------------------------------

        List<String> listaDanych = new ArrayList<String>();
        while((str = dane.readLine()) != null){
            listaDanych.add(str);
        }
        //utworzenie tablicy danych
        String[] daneTablica = listaDanych.toArray(new String[0]);

        //utworzenie tablic danych dla poszczególnych zbiorników
        String[] zbiornik1 =  Arrays.stream(daneTablica)
                .filter(s -> s.charAt(22) == '1')
                .toArray(String[]::new);

        String[] zbiornik2 =  Arrays.stream(daneTablica)
                .filter(s -> s.charAt(22) == '2')
                .toArray(String[]::new);

        String[] zbiornik3 =  Arrays.stream(daneTablica)
                .filter(s -> s.charAt(22) == '3')
                .toArray(String[]::new);

        String[] zbiornik4 =  Arrays.stream(daneTablica)
                .filter(s -> s.charAt(22) == '4')
                .toArray(String[]::new);

        //utworzenie tablic danych dla poszczególnych zbiorników z pomiarami z równych godzin
        String[] zbiornik1FullTime =  Arrays.stream(zbiornik1)
                .filter(s -> s.charAt(14) == '0' &&  s.charAt(15) == '0')
                .toArray(String[]::new);

        String[] zbiornik2FullTime =  Arrays.stream(zbiornik2)
                .filter(s -> s.charAt(14) == '0' &&  s.charAt(15) == '0')
                .toArray(String[]::new);

        String[] zbiornik3FullTime =  Arrays.stream(zbiornik3)
                .filter(s -> s.charAt(14) == '0' &&  s.charAt(15) == '0')
                .toArray(String[]::new);

        String[] zbiornik4FullTime =  Arrays.stream(zbiornik4)
                .filter(s -> s.charAt(14) == '0' &&  s.charAt(15) == '0')
                .toArray(String[]::new);


        //utworzenie listy konkretnych danych (data, H, V) dla poszczególnych zbiorników
        List<String> zbiornik1data = new ArrayList<String>();
        List<String> zbiornik1objetosc = new ArrayList<String>();

        List<String> zbiornik2data = new ArrayList<String>();
        List<String> zbiornik2objetosc = new ArrayList<String>();

        List<String> zbiornik3data = new ArrayList<String>();
        List<String> zbiornik3objetosc = new ArrayList<String>();

        List<String> zbiornik4data = new ArrayList<String>();
        List<String> zbiornik4objetosc = new ArrayList<String>();

        //utworzenie pliku do zapisu danych w formacie .csv
        PrintWriter zw1 = new PrintWriter(new File("Zbiornik_1_nozzle.csv"));
        PrintWriter zw2 = new PrintWriter(new File("Zbiornik_2_nozzle.csv"));
        PrintWriter zw3 = new PrintWriter(new File("Zbiornik_3_nozzle.csv"));
        PrintWriter zw4 = new PrintWriter(new File("Zbiornik_4_nozzle.csv"));

        //inicjalizacja kolumn pliku .csv
        StringBuilder cellZbiornik1 = new StringBuilder();
        cellZbiornik1.append("Objetosc"+'\n');
        StringBuilder cellZbiornik2 = new StringBuilder();
        cellZbiornik2.append("Objetosc"+'\n');
        StringBuilder cellZbiornik3 = new StringBuilder();
        cellZbiornik3.append("Objetosc"+'\n');
        StringBuilder cellZbiornik4 = new StringBuilder();
        cellZbiornik4.append("Objetosc"+'\n');

        //iterowanie po elementach tablicy zbiornik 1
        for (String val : zbiornik1FullTime)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-7];
            String objetosc = bits[bits.length-2];

            float obj = Float.parseFloat(objetosc.replace(',', '.'))/1000;

            String objA = Float.toString(obj).replace('.', ',');

            zbiornik1data.add(data);
            zbiornik1objetosc.add(objetosc);

            cellZbiornik1.append(objA);
            cellZbiornik1.append('\n');
        }
        //iterowanie po elementach tablicy zbiornik 2
        for (String val : zbiornik2FullTime)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-7];
            String objetosc = bits[bits.length-2];

            float obj = Float.parseFloat(objetosc.replace(',', '.'))/1000;

            String objA = Float.toString(obj).replace('.', ',');

            zbiornik2data.add(data);
            zbiornik2objetosc.add(objetosc);

            cellZbiornik2.append(objA);
            cellZbiornik2.append('\n');
        }
        //iterowanie po elementach tablicy zbiornik 3
        for (String val : zbiornik3FullTime)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-7];
            String objetosc = bits[bits.length-2];

            float obj = Float.parseFloat(objetosc.replace(',', '.'))/1000;

            String objA = Float.toString(obj).replace('.', ',');

            zbiornik3data.add(data);
            zbiornik3objetosc.add(objetosc);

            cellZbiornik3.append(objA);
            cellZbiornik3.append('\n');
        }
        //iterowanie po elementach tablicy zbiornik 4
        for (String val : zbiornik4FullTime)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-7];
            String objetosc = bits[bits.length-2];

            float obj = Float.parseFloat(objetosc.replace(',', '.'))/1000;

            String objA = Float.toString(obj).replace('.', ',');

            zbiornik4data.add(data);
            zbiornik4objetosc.add(objetosc);

            cellZbiornik4.append(objA);
            cellZbiornik4.append('\n');
        }
        zw1.write(cellZbiornik1.toString());
        zw2.write(cellZbiornik2.toString());
        zw3.write(cellZbiornik3.toString());
        zw4.write(cellZbiornik4.toString());
        zw1.close();
        zw2.close();
        zw3.close();
        zw4.close();
        dane.close();
    }

}
