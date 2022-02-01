import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class amwz
{
  public static final String sS = acfp.m(2131704659);
  public static final String sT = acfp.m(2131704667);
  public static final String sU = acfp.m(2131704658);
  public static final String sY = acfp.m(2131704657);
  
  public static String getDateString(long paramLong)
  {
    long l = System.currentTimeMillis() / 1000L - paramLong;
    if ((l >= 0L) && (l < 60L)) {
      return sS;
    }
    if ((l >= 60L) && (l < 3600L)) {
      return l / 60L + sT;
    }
    if ((l >= 3600L) && (l < 86400L)) {
      return l / 3600L + sU;
    }
    if ((l >= 86400L) && (l < 432000L)) {
      return l / 86400L + sY;
    }
    return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong * 1000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwz
 * JD-Core Version:    0.7.0.1
 */