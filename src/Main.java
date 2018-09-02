import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        //Uruchomienie metod
        tankMeasures.main(args);
        nozzleMeasures.main(args);

        List<String> listaNozzle1V = new ArrayList<String>();
        List<String> listaTank1V = new ArrayList<String>();
        List<String> listaTank1H = new ArrayList<String>();
        List<String> listaTank1D = new ArrayList<String>();
        List<String> listaNozzle2V = new ArrayList<String>();
        List<String> listaTank2V = new ArrayList<String>();
        List<String> listaTank2H = new ArrayList<String>();
        List<String> listaTank2D = new ArrayList<String>();
        List<String> listaNozzle3V = new ArrayList<String>();
        List<String> listaTank3V = new ArrayList<String>();
        List<String> listaTank3H = new ArrayList<String>();
        List<String> listaTank3D = new ArrayList<String>();
        List<String> listaNozzle4V = new ArrayList<String>();
        List<String> listaTank4V = new ArrayList<String>();
        List<String> listaTank4H = new ArrayList<String>();
        List<String> listaTank4D = new ArrayList<String>();


        // zmień ścieżki
        BufferedReader zbiornik1_nozzle = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zbiornik_1_nozzle.csv"));
        BufferedReader zbiornik1_tank = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zbiornik_1_tank.csv"));
        BufferedReader zbiornik2_nozzle = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zbiornik_2_nozzle.csv"));
        BufferedReader zbiornik2_tank = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zbiornik_2_tank.csv"));
        BufferedReader zbiornik3_nozzle = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zbiornik_3_nozzle.csv"));
        BufferedReader zbiornik3_tank = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zbiornik_3_tank.csv"));
        BufferedReader zbiornik4_nozzle = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zbiornik_4_nozzle.csv"));
        BufferedReader zbiornik4_tank = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zbiornik_4_tank.csv"));

        //Pobieranie danych do obliczenia Var rekoncylacji zbiornik 1
        try (zbiornik1_nozzle; zbiornik1_tank ) {
            while ((zbiornik1_nozzle.readLine()) != null) {
                String[] V1_1 = zbiornik1_nozzle.readLine().split("\n");
                listaNozzle1V.add(V1_1[0]);
            }
            while ((zbiornik1_tank.readLine()) != null) {
                String[] V1_2 = zbiornik1_tank.readLine().split(";");
                listaTank1D.add(V1_2[0]);
                listaTank1H.add(V1_2[1]);
                listaTank1V.add(V1_2[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Pobieranie danych do obliczenia Var rekoncylacji zbiornik 2
        try (zbiornik2_nozzle; zbiornik2_tank ) {
            while ((zbiornik2_nozzle.readLine()) != null) {
                String[] V2_1 = zbiornik2_nozzle.readLine().split("\n");
                listaNozzle2V.add(V2_1[0]);
            }
            while ((zbiornik2_tank.readLine()) != null) {
                String[] V1_2 = zbiornik2_tank.readLine().split(";");
                listaTank2D.add(V1_2[0]);
                listaTank2H.add(V1_2[1]);
                listaTank2V.add(V1_2[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // COS NIE HALO (nie wiem co nie gra) ;/

//        //Pobieranie danych do obliczenia Var rekoncylacji zbiornik 3
//        try (zbiornik3_nozzle; zbiornik3_tank ) {
//            while ((zbiornik3_nozzle.readLine()) != null) {
//                String[] V3_1 = zbiornik3_nozzle.readLine().split("\n");
//                listaNozzle3V.add(V3_1[0]);
//            }
//            while ((zbiornik3_tank.readLine()) != null) {
//                String[] V3_2 = zbiornik3_tank.readLine().split(";");
//                listaTank3D.add(V3_2[0]);
//                listaTank3H.add(V3_2[1]);
//                listaTank3V.add(V3_2[2]);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //Pobieranie danych do obliczenia Var rekoncylacji zbiornik 4
//        try (zbiornik4_nozzle; zbiornik4_tank ) {
//            while ((zbiornik4_nozzle.readLine()) != null) {
//                String[] V4_1 = zbiornik4_nozzle.readLine().split("\n");
//                listaNozzle2V.add(V4_1[0]);
//            }
//            while ((zbiornik4_tank.readLine()) != null) {
//                String[] V4_2 = zbiornik4_tank.readLine().split(";");
//                listaTank4D.add(V4_2[0]);
//                listaTank4H.add(V4_2[1]);
//                listaTank4V.add(V4_2[2]);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //utworzenie pliku do zapisu danych w formacie .csv
        PrintWriter zw1 = new PrintWriter(new File("CV_Zbiornik1.csv"));
        PrintWriter zw2 = new PrintWriter(new File("CV_Zbiornik2.csv"));
        PrintWriter zw3 = new PrintWriter(new File("CV_Zbiornik3.csv"));
        PrintWriter zw4 = new PrintWriter(new File("CV_Zbiornik4.csv"));

        //inicjalizacja kolumn pliku .csv
        StringBuilder cellZbiornik1 = new StringBuilder();
        cellZbiornik1.append("Czas_pocz"+';'+"Czas_kon"+';'+"Zbiornik"+';'+"H_pocz"+';'+"H_kon"+';'+"Bilans"+'\n');
        StringBuilder cellZbiornik2 = new StringBuilder();
        cellZbiornik2.append("Czas_pocz"+';'+"Czas_kon"+';'+"Zbiornik"+';'+"H_pocz"+';'+"H_kon"+';'+"Bilans"+'\n');
        StringBuilder cellZbiornik3 = new StringBuilder();
        cellZbiornik3.append("Czas_pocz"+';'+"Czas_kon"+';'+"Zbiornik"+';'+"H_pocz"+';'+"H_kon"+';'+"Bilans"+'\n');
        StringBuilder cellZbiornik4 = new StringBuilder();
        cellZbiornik4.append("Czas_pocz"+';'+"Czas_kon"+';'+"Zbiornik"+';'+"H_pocz"+';'+"H_kon"+';'+"Bilans"+'\n');

        //rekoncylacja zbiornik 1
        for(int i=0;i<83;i++) {
            String data_pocz = listaTank1D.get(i);
            String data_kon = listaTank1D.get(i+1);
            String id = "1";
            String d1_V1 = listaTank1V.get(i+1).replace(',', '.');
            String d1_V2 = listaTank1V.get(i).replace(',', '.');
            String d2_V1 = listaNozzle1V.get(i+1).replace(',', '.');
            String d2_V2 = listaNozzle1V.get(i).replace(',', '.');
            String d1_H1 = listaTank1H.get(i+1).replace(',', '.');
            String d1_H2 = listaTank1H.get(i+1).replace(',', '.');
            float H1 = Float.parseFloat(d1_H1);
            float H2 = Float.parseFloat(d1_H2);
            float var1_1 = Float.parseFloat(d1_V1);
            float var1_2 = Float.parseFloat(d1_V2);
            float var2_1 = Float.parseFloat(d2_V1);
            float var2_2 = Float.parseFloat(d2_V2);
            float VAR1 = var1_2-var1_1;
            float VAR2 = var2_1-var2_2;
            float VAR = VAR1- VAR2;
            String CV = Float.toString(VAR).replace('.', ',');
            cellZbiornik1.append(data_pocz);
            cellZbiornik1.append(';');
            cellZbiornik1.append(data_kon);
            cellZbiornik1.append(';');
            cellZbiornik1.append(id);
            cellZbiornik1.append(';');
            cellZbiornik1.append(H1);
            cellZbiornik1.append(';');
            cellZbiornik1.append(H2);
            cellZbiornik1.append(';');
            cellZbiornik1.append(CV);
            cellZbiornik1.append('\n');
        }
        //rekoncylacja zbiornik 2
        for(int j=0;j<83;j++) {
            String data_pocz = listaTank2D.get(j);
            String data_kon = listaTank2D.get(j+1);
            String id = "1";
            String d1_V1 = listaTank2V.get(j+1).replace(',', '.');
            String d1_V2 = listaTank2V.get(j).replace(',', '.');
            String d2_V1 = listaNozzle2V.get(j+1).replace(',', '.');
            String d2_V2 = listaNozzle2V.get(j).replace(',', '.');
            String d1_H1 = listaTank2H.get(j+1).replace(',', '.');
            String d1_H2 = listaTank2H.get(j+1).replace(',', '.');
            float H1 = Float.parseFloat(d1_H1);
            float H2 = Float.parseFloat(d1_H2);
            float var1_1 = Float.parseFloat(d1_V1);
            float var1_2 = Float.parseFloat(d1_V2);
            float var2_1 = Float.parseFloat(d2_V1);
            float var2_2 = Float.parseFloat(d2_V2);
            float VAR1 = var1_2-var1_1;
            float VAR2 = var2_1-var2_2;
            float VAR = VAR1- VAR2;
            String CV = Float.toString(VAR).replace('.', ',');
            cellZbiornik2.append(data_pocz);
            cellZbiornik2.append(';');
            cellZbiornik2.append(data_kon);
            cellZbiornik2.append(';');
            cellZbiornik2.append(id);
            cellZbiornik2.append(';');
            cellZbiornik2.append(H1);
            cellZbiornik2.append(';');
            cellZbiornik2.append(H2);
            cellZbiornik2.append(';');
            cellZbiornik2.append(CV);
            cellZbiornik2.append('\n');
           }
//        //rekoncylacja zbiornik 3
//        for(int k=0;k<83;k++) {
//            String data_pocz = listaTank3D.get(k);
//            String data_kon = listaTank3D.get(k+1);
//            String id = "1";
//            String d1_V1 = listaTank3V.get(k+1).replace(',', '.');
//            String d1_V2 = listaTank3V.get(k).replace(',', '.');
//            String d2_V1 = listaNozzle3V.get(k+1).replace(',', '.');
//            String d2_V2 = listaNozzle3V.get(k).replace(',', '.');
//            String d1_H1 = listaTank3H.get(k+1).replace(',', '.');
//            String d1_H2 = listaTank3H.get(k+1).replace(',', '.');
//            float H1 = Float.parseFloat(d1_H1);
//            float H2 = Float.parseFloat(d1_H2);
//            float var1_1 = Float.parseFloat(d1_V1);
//            float var1_2 = Float.parseFloat(d1_V2);
//            float var2_1 = Float.parseFloat(d2_V1);
//            float var2_2 = Float.parseFloat(d2_V2);
//            float VAR1 = var1_2-var1_1;
//            float VAR2 = var2_1-var2_2;
//            float VAR = VAR1- VAR2;
//            String CV = Float.toString(VAR).replace('.', ',');
//            cellZbiornik3.append(data_pocz);
//            cellZbiornik3.append(';');
//            cellZbiornik3.append(data_kon);
//            cellZbiornik3.append(';');
//            cellZbiornik3.append(id);
//            cellZbiornik3.append(';');
//            cellZbiornik3.append(H1);
//            cellZbiornik3.append(';');
//            cellZbiornik3.append(H2);
//            cellZbiornik3.append(';');
//            cellZbiornik3.append(CV);
//            cellZbiornik3.append('\n');
//        }
//        //rekoncylacja zbiornik 4
//        for(int l=0;l<83;l++) {
//            String data_pocz = listaTank4D.get(l);
//            String data_kon = listaTank4D.get(l+1);
//            String id = "1";
//            String d1_V1 = listaTank4V.get(l+1).replace(',', '.');
//            String d1_V2 = listaTank4V.get(l).replace(',', '.');
//            String d2_V1 = listaNozzle4V.get(l+1).replace(',', '.');
//            String d2_V2 = listaNozzle4V.get(l).replace(',', '.');
//            String d1_H1 = listaTank4H.get(l+1).replace(',', '.');
//            String d1_H2 = listaTank4H.get(l+1).replace(',', '.');
//            float H1 = Float.parseFloat(d1_H1);
//            float H2 = Float.parseFloat(d1_H2);
//            float var1_1 = Float.parseFloat(d1_V1);
//            float var1_2 = Float.parseFloat(d1_V2);
//            float var2_1 = Float.parseFloat(d2_V1);
//            float var2_2 = Float.parseFloat(d2_V2);
//            float VAR1 = var1_2-var1_1;
//            float VAR2 = var2_1-var2_2;
//            float VAR = VAR1- VAR2;
//            String CV = Float.toString(VAR).replace('.', ',');
//            cellZbiornik4.append(data_pocz);
//            cellZbiornik4.append(';');
//            cellZbiornik4.append(data_kon);
//            cellZbiornik4.append(';');
//            cellZbiornik4.append(id);
//            cellZbiornik4.append(';');
//            cellZbiornik4.append(H1);
//            cellZbiornik4.append(';');
//            cellZbiornik4.append(H2);
//            cellZbiornik4.append(';');
//            cellZbiornik4.append(CV);
//            cellZbiornik4.append('\n');
//        }
        zw1.write(cellZbiornik1.toString());
        zw1.close();
        zw2.write(cellZbiornik2.toString());
        zw2.close();
        zw3.write(cellZbiornik3.toString());
        zw3.close();
        zw4.write(cellZbiornik4.toString());
        zw4.close();
    }
}
