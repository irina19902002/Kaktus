import java.time.Month;
import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

import static java.util.Collections.*;

public class Main extends Detector {
    public static void main(String[] args) {
        int day;
        int humidity;
        GregorianCalendar calendar = new GregorianCalendar(2023, Calendar.JANUARY, 21);//дата последнего полива
        GregorianCalendar calendarTek = new GregorianCalendar();
        int mes = calendarTek.get(calendar.MONTH);
        long diff = (calendarTek.getTimeInMillis() - calendar.getTimeInMillis()) / 1000 / 60 / 24 / 60;
        Integer[] springAutumn = new Integer[]{Calendar.MARCH, Calendar.APRIL, Calendar.MAY, Calendar.SEPTEMBER, Calendar.OCTOBER, Calendar.NOVEMBER};
        Integer[] summer = new Integer[]{Calendar.JULY, Calendar.JUNE, Calendar.AUGUST};
        Integer[] winter = new Integer[]{Calendar.DECEMBER, Calendar.JANUARY, Calendar.FEBRUARY};
        List<Integer> springAutumnList = new ArrayList<>(Arrays.asList(springAutumn));
        List<Integer> winterList = new ArrayList<>(Arrays.asList(winter));
        List<Integer> summerList = new ArrayList<>(Arrays.asList(summer));
        boolean foundMezhseson = springAutumnList.contains(mes);
        boolean foundSummer = summerList.contains(mes);
        boolean foundWinter = winterList.contains(mes);
        if (foundMezhseson == true) {
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            System.out.println(calendar.getTime());
        }
        if (foundSummer == true) {
            while (diff < 2) {
                calendarTek.add(Calendar.DAY_OF_MONTH, 1);
            }
            if (GetHumidity() < 30) {
                System.out.println("Leto" + calendarTek.getTime());
            } else {
                System.out.println("полей 1 сеньября");
            }
        }
        if (foundWinter == true) {
            calendar.add(Calendar.MONTH, 1);
            System.out.println(calendar.getTime());
        }

    }
}




