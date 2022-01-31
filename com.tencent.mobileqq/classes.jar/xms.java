import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class xms
  extends ThreadLocal<DateFormat>
{
  protected DateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xms
 * JD-Core Version:    0.7.0.1
 */