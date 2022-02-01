import com.tencent.qphone.base.util.QLog;

public class igd
{
  @Deprecated
  public static void aH(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(paramString1, 4, paramString2);
    }
  }
  
  @Deprecated
  public static void aI(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e(paramString1, 4, paramString2);
    }
  }
  
  @Deprecated
  public static void aJ(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public static void aK(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public static void aL(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igd
 * JD-Core Version:    0.7.0.1
 */