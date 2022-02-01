import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class anlb
{
  private static final SimpleDateFormat u = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE);
  
  public static String Ab()
  {
    synchronized (u)
    {
      int i = new Random().nextInt(10000);
      String str = u.format(new Date()) + "_" + i;
      return str;
    }
  }
  
  public static String w(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    return paramFile.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlb
 * JD-Core Version:    0.7.0.1
 */