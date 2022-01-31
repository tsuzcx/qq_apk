import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class vlh
  extends ThreadLocal<DateFormat>
{
  protected DateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vlh
 * JD-Core Version:    0.7.0.1
 */