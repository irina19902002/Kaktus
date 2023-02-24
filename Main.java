import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Main extends Detector {
    public static void main(String[] args) {
        System.out.println("Введите дату последнего полива в формате \"MMMM d, yyyy\" ");
        Scanner sc = new Scanner(System.in);
        String stringDateWater = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDate dateWater = LocalDate.parse(stringDateWater, formatter);
        LocalDate dateTek= LocalDate.now();
        long timestamp = Timestamp.valueOf(dateWater.atStartOfDay()).getTime();
        long timestampNow = Timestamp.valueOf(dateTek.atStartOfDay()).getTime();
        long diffDays = (timestampNow - timestamp) / 1000 / 60 / 24 / 60;
        int mes = dateTek.getMonthValue();
        Integer[] springAutumn = new Integer[]{Calendar.MARCH, Calendar.APRIL, Calendar.MAY, Calendar.SEPTEMBER, Calendar.OCTOBER, Calendar.NOVEMBER};
        Integer[] summer = new Integer[]{Calendar.JULY, Calendar.JUNE, Calendar.AUGUST};
        Integer[] winter = new Integer[]{Calendar.DECEMBER, Calendar.JANUARY, Calendar.FEBRUARY};
        List<Integer> springAutumnList = new ArrayList<>(Arrays.asList(springAutumn));
        List<Integer> winterList = new ArrayList<>(Arrays.asList(winter));
        List<Integer> summerList = new ArrayList<>(Arrays.asList(summer));
        boolean foundMezhseson = springAutumnList.contains(mes - 1);
        boolean foundSummer = summerList.contains(mes - 1);
        boolean foundWinter = winterList.contains(mes - 1);
        if (foundMezhseson) {
            dateWater = dateWater.plusWeeks(1);
            System.out.println("Полей кактус: " + dateWater.format(formatter));
        }
        if (foundSummer) {
            while (diffDays < 2) {
                dateTek = dateTek.plusDays(1);
                diffDays++;
            }
            if (GetHumidity() < 30) {
                System.out.println("Полей кактус: " + dateTek.format(formatter));
            } else {
                System.out.println("Полей кактус: сентября 1, "+ dateTek.getYear());
            }
        }
        if (foundWinter) {
            dateWater = dateWater.plusMonths(1);
            //calendar.add(Calendar.MONTH, 1);
            System.out.println("Полей кактус: " + dateWater.format(formatter));
        }
    }
}
