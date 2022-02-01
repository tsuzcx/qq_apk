import com.tencent.qphone.base.util.QLog;

public class ooz
{
  private static final String aqW = "weishi" + "3.4.4".replaceAll("\\.", "");
  
  public static void bY(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      i(paramString1, 2, paramString2);
    }
  }
  
  public static void bZ(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      d(paramString1, 2, paramString2);
    }
  }
  
  public static void ca(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      w(paramString1, 2, paramString2);
    }
  }
  
  public static void d(String paramString)
  {
    d(aqW, 4, paramString);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(aqW + "-" + paramString1, paramInt, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, 4, paramString2);
  }
  
  public static void e(String paramString)
  {
    e(aqW, 1, paramString);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(aqW + "-" + paramString1, paramInt, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, 1, paramString2);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(aqW + "-" + paramString1, paramInt, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, 4, paramString2);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(aqW + "-" + paramString1, paramInt, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, 4, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ooz
 * JD-Core Version:    0.7.0.1
 */