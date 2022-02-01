import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class ror
  extends ThreadLocal<DateFormat>
{
  protected DateFormat initialValue()
  {
    return new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ror
 * JD-Core Version:    0.7.0.1
 */