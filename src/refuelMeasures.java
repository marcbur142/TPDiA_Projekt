import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class refuelMeasures {
    public static void main(String[] args) throws IOException
    {
        BufferedReader dane = new BufferedReader(new FileReader("C:\\Users\\Marcin\\IdeaProjects\\TPDIA\\Zestaw 1\\refuel.log"));
        String str;

        //refuel.log ---------------------------------
        List<String> list = new ArrayList<String>();
        while((str = dane.readLine()) != null){
            list.add(str);
        }

        String[] daneTablica = list.toArray(new String[0]);

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


        //utworzenie listy konkretnych danych (data, H, V) dla poszczególnych zbiorników
        List<String> zbiornik1data = new ArrayList<String>();
        List<String> zbiornik1objetosc = new ArrayList<String>();

        List<String> zbiornik2data = new ArrayList<String>();
        List<String> zbiornik2objetosc = new ArrayList<String>();

        List<String> zbiornik3data = new ArrayList<String>();
        List<String> zbiornik3objetosc = new ArrayList<String>();

        List<String> zbiornik4data = new ArrayList<String>();
        List<String> zbiornik4objetosc = new ArrayList<String>();

        for (String val : zbiornik1)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-4];
            String objetosc = bits[bits.length-2];

            zbiornik1data.add(data);
            zbiornik1objetosc.add(objetosc);
        }

        for (String val : zbiornik2)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-4];
            String objetosc = bits[bits.length-2];

            zbiornik2data.add(data);
            zbiornik2objetosc.add(objetosc);
        }

        for (String val : zbiornik3)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-4];
            String objetosc = bits[bits.length-2];

            zbiornik3data.add(data);
            zbiornik3objetosc.add(objetosc);
        }

        for (String val : zbiornik4)
        {
            String[] bits = val.split(";");
            String data = bits[bits.length-4];
            String objetosc = bits[bits.length-2];

            zbiornik4data.add(data);
            zbiornik4objetosc.add(objetosc);
        }
        dane.close();
    }
}
