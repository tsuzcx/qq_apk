import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class zoh
  extends ThreadLocal<DateFormat>
{
  protected DateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zoh
 * JD-Core Version:    0.7.0.1
 */