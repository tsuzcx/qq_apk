import android.os.SystemClock;

public class iqs
{
  private static volatile long sTime;
  
  public static long get()
  {
    return sTime;
  }
  
  public static void update()
  {
    sTime = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqs
 * JD-Core Version:    0.7.0.1
 */