import java.text.SimpleDateFormat;
import java.util.Locale;

class aprq
  extends ThreadLocal<SimpleDateFormat>
{
  aprq(aprp paramaprp) {}
  
  protected SimpleDateFormat initialValue()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprq
 * JD-Core Version:    0.7.0.1
 */