import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class xra
  extends ThreadLocal<DateFormat>
{
  protected DateFormat a()
  {
    return new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xra
 * JD-Core Version:    0.7.0.1
 */