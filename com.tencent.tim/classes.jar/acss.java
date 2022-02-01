public class acss
{
  public static long Rs = 60000L;
  public static String bqF = "sp_msglrucache";
  public static String bqG = "sp_key_msglrucache_switch";
  public static String bqH = "sp_key_cacheinitadjust_switch";
  public static String bqI = "sp_key_report_aio_last_time";
  public static String bqJ;
  public static int cAa;
  public static int cAb;
  public static int cAc;
  public static int cAd;
  public static int cAe;
  public static int cAf;
  public static int cAg;
  public static int cAh;
  public static int czT = 1600;
  public static int czU = 1400;
  public static int czV = 1;
  public static int czW = 2;
  public static int czX = 40;
  public static int czY = 20;
  public static int czZ = 10;
  
  static
  {
    cAb = 5;
    cAc = -1;
    cAd = 2;
    cAe = 1;
    cAf = 1;
    bqJ = "msglrucacheMoniterLogin";
    cAg = 100;
    cAh = 10;
  }
  
  public static int cE(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.contains("&"))
        {
          paramString = paramString.split("&");
          if (paramString.length >= 2)
          {
            int i = Integer.valueOf(paramString[1]).intValue();
            return i;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0;
  }
  
  public static String jC(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("&")) {
        str = paramString.split("&")[0];
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acss
 * JD-Core Version:    0.7.0.1
 */