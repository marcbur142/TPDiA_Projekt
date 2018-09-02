import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class tankMeasures
{
    public static void main(String[] args) throws IOException
    {
        //zmień ścieżkę do danych tankMeasures.log
        BufferedReader dane = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zestaw 1\\tankMeasures.log"));
        String str;

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
        List<String> zbiornik1wys = new ArrayList<String>();
        List<String> zbiornik1objetosc = new ArrayList<String>();

        List<String> zbiornik2data = new ArrayList<String>();
        List<String> zbiornik2wys = new ArrayList<String>();
        List<String> zbiornik2objetosc = new ArrayList<String>();

        List<String> zbiornik3data = new ArrayList<String>();
        List<String> zbiornik3wys = new ArrayList<String>();
        List<String> zbiornik3objetosc = new ArrayList<String>();

        List<String> zbiornik4data = new ArrayList<String>();
        List<String> zbiornik4wys = new ArrayList<String>();
        List<String> zbiornik4objetosc = new ArrayList<String>();

        // definiowanie serii *dla wykresu:
        XYSeries dataSet1= new XYSeries("zbiornik 1");
        XYSeries dataSet2= new XYSeries("zbiornik 2");
        XYSeries dataSet3= new XYSeries("zbiornik 3");
        XYSeries dataSet4= new XYSeries("zbiornik 4");
        // Tworzenie kolekcji serii zawierajacej serie dataSet
        XYSeriesCollection xySeriesCollection1 = new XYSeriesCollection(dataSet1);
        XYSeriesCollection xySeriesCollection2 = new XYSeriesCollection(dataSet2);
        XYSeriesCollection xySeriesCollection3 = new XYSeriesCollection(dataSet3);
        XYSeriesCollection xySeriesCollection4 = new XYSeriesCollection(dataSet4);

        //utworzenie pliku do zapisu danych w formacie .csv
        PrintWriter zw1 = new PrintWriter(new File("Zbiornik_1_tank.csv"));
        PrintWriter zw2 = new PrintWriter(new File("Zbiornik_2_tank.csv"));
        PrintWriter zw3 = new PrintWriter(new File("Zbiornik_3_tank.csv"));
        PrintWriter zw4 = new PrintWriter(new File("Zbiornik_4_tank.csv"));

        //inicjalizacja kolumn pliku .csv
        StringBuilder cellZbiornik1 = new StringBuilder();
        cellZbiornik1.append("Data"+';'+"Wysokosc"+';'+"Objetosc"+'\n');
        StringBuilder cellZbiornik2 = new StringBuilder();
        cellZbiornik2.append("Data"+';'+"Wysokosc"+';'+"Objetosc"+'\n');
        StringBuilder cellZbiornik3 = new StringBuilder();
        cellZbiornik3.append("Data"+';'+"Wysokosc"+';'+"Objetosc"+'\n');
        StringBuilder cellZbiornik4 = new StringBuilder();
        cellZbiornik4.append("Data"+';'+"Wysokosc"+';'+"Objetosc"+'\n');

        for (String val : zbiornik1FullTime)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-7];
            String wysokosc = bits[bits.length-3];
            String objetosc = bits[bits.length-2];

            float wys = Float.parseFloat(wysokosc)/1000;
            float obj = Float.parseFloat(objetosc.replace(',', '.'))/1000;

            String wysA = Float.toString(wys).replace('.', ',');
            String objA = Float.toString(obj).replace('.', ',');

            //dodawanie danych do serii wykresu (mm to m)
            dataSet1.add(wys, obj);

            zbiornik1data.add(data);
            zbiornik1wys.add(wysokosc);
            zbiornik1objetosc.add(objetosc);

            cellZbiornik1.append(data);
            cellZbiornik1.append(';');
            cellZbiornik1.append(wysA);
            cellZbiornik1.append(';');
            cellZbiornik1.append(objA);
            cellZbiornik1.append('\n');
        }

        for (String val : zbiornik2FullTime)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-7];
            String wysokosc = bits[bits.length-3];
            String objetosc = bits[bits.length-2];

            float wys = Float.parseFloat(wysokosc)/1000;
            float obj = Float.parseFloat(objetosc.replace(',', '.'))/1000;

            String wysA = Float.toString(wys).replace('.', ',');
            String objA = Float.toString(obj).replace('.', ',');

            //dodawanie danych do serii wykresu (mm to m)
            dataSet2.add(wys, obj);

            zbiornik2data.add(data);
            zbiornik2wys.add(wysokosc);
            zbiornik2objetosc.add(objetosc);

            cellZbiornik2.append(data);
            cellZbiornik2.append(';');
            cellZbiornik2.append(wysA);
            cellZbiornik2.append(';');
            cellZbiornik2.append(objA);
            cellZbiornik2.append('\n');
        }

        for (String val : zbiornik3FullTime)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-7];
            String wysokosc = bits[bits.length-3];
            String objetosc = bits[bits.length-2];

            float wys = Float.parseFloat(wysokosc)/1000;
            float obj = Float.parseFloat(objetosc.replace(',', '.'))/1000;

            String wysA = Float.toString(wys).replace('.', ',');
            String objA = Float.toString(obj).replace('.', ',');

            //dodawanie danych do serii wykresu (mm to m)
            dataSet3.add(wys, obj);

            zbiornik3data.add(data);
            zbiornik3wys.add(wysokosc);
            zbiornik3objetosc.add(objetosc);

            cellZbiornik3.append(data);
            cellZbiornik3.append(';');
            cellZbiornik3.append(wysA);
            cellZbiornik3.append(';');
            cellZbiornik3.append(objA);
            cellZbiornik3.append('\n');
        }

        for (String val : zbiornik4FullTime)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-7];
            String wysokosc = bits[bits.length-3];
            String objetosc = bits[bits.length-2];

            float wys = Float.parseFloat(wysokosc)/1000;
            float obj = Float.parseFloat(objetosc.replace(',', '.'))/1000;

            String wysA = Float.toString(wys).replace('.', ',');
            String objA = Float.toString(obj).replace('.', ',');


            //dodawanie danych do serii wykresu (mm to m)
            dataSet4.add(wys, obj);

            zbiornik4data.add(data);
            zbiornik4wys.add(wysokosc);
            zbiornik4objetosc.add(objetosc);

            cellZbiornik4.append(data);
            cellZbiornik4.append(';');
            cellZbiornik4.append(wysA);
            cellZbiornik4.append(';');
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

        // tworzenie XYDataSet
        XYDataset xyDataset1 = xySeriesCollection1;
        XYDataset xyDataset2 = xySeriesCollection2;
        XYDataset xyDataset3 = xySeriesCollection3;
        XYDataset xyDataset4 = xySeriesCollection4;

        // tworzenie wykresu
        JFreeChart lineGraph1 = ChartFactory.createXYLineChart
                ("Poziom paliwa - zbiornik 1",  // Title
                        "Wysokość [m]",           // X-Axis label
                        "Objętość [m^3]",           // Y-Axis label
                        xyDataset1,          // Dataset
                        PlotOrientation.VERTICAL,        //Plot orientation
                        true,                //show legend
                        true,                // Show tooltips
                        false               //url show
                );
        JFreeChart lineGraph2 = ChartFactory.createXYLineChart
                ("Poziom paliwa - zbiornik 2",  // Title
                        "Wysokość [m]",           // X-Axis label
                        "Objętość [m^3]",           // Y-Axis label
                        xyDataset2,          // Dataset
                        PlotOrientation.VERTICAL,        //Plot orientation
                        true,                //show legend
                        true,                // Show tooltips
                        false               //url show
                );
        JFreeChart lineGraph3 = ChartFactory.createXYLineChart
                ("Poziom paliwa - zbiornik 3",  // Title
                        "Wysokość [m]",           // X-Axis label
                        "Objętość [m^3]",           // Y-Axis label
                        xyDataset3,          // Dataset
                        PlotOrientation.VERTICAL,        //Plot orientation
                        true,                //show legend
                        true,                // Show tooltips
                        false               //url show
                );
        JFreeChart lineGraph4 = ChartFactory.createXYLineChart
                ("Poziom paliwa - zbiornik 4",  // Title
                        "Wysokość [m]",           // X-Axis label
                        "Objętość [m^3]",           // Y-Axis label
                        xyDataset4,          // Dataset
                        PlotOrientation.VERTICAL,        //Plot orientation
                        true,                //show legend
                        true,                // Show tooltips
                        false               //url show
                );
        // Zapisywanie wykresu do pliku JPG:
        try {
            ChartUtilities.saveChartAsJPEG(new File("Zbiornik1_krzywa.jpg"), lineGraph1, 800, 600);
            ChartUtilities.saveChartAsJPEG(new File("Zbiornik2_krzywa.jpg"), lineGraph2, 800, 600);
            ChartUtilities.saveChartAsJPEG(new File("Zbiornik3_krzywa.jpg"), lineGraph3, 800, 600);
            ChartUtilities.saveChartAsJPEG(new File("Zbiornik4_krzywa.jpg"), lineGraph4, 800, 600);
        } catch (Exception e) {
            System.out.println("Problem z zapisem wykresu do pliku");
        }
        dane.close();
    }
}

