import cooperation.qzone.util.QZLog;

public class awnd
{
  public static int CLR = 2;
  public static int DEV = 4;
  public static int USR = 1;
  
  public static void d(String paramString1, String paramString2)
  {
    QZLog.d(paramString1, USR, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    QZLog.e(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    QZLog.d(paramString1, DEV, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnd
 * JD-Core Version:    0.7.0.1
 */