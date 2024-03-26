import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateController {
    public static Period compare(String date01, String date02) throws Exception {
        try {
            LocalDate formmatedDate01 = LocalDate.parse(date01, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate formmatedDate02 = LocalDate.parse(date02, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return Period.between(formmatedDate01, formmatedDate02);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
