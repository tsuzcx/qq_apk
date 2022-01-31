import com.tencent.qphone.base.util.QLog;

public class tlo
{
  private static final String a = "weishi" + "8.3.5".replaceAll("\\.", "");
  
  public static void a(String paramString)
  {
    b(a, 4, paramString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(a + "-" + paramString1, paramInt, paramString2);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, 4, paramString2);
  }
  
  public static void b(String paramString)
  {
    d(a, 1, paramString);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(a + "-" + paramString1, paramInt, paramString2);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, 4, paramString2);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(a + "-" + paramString1, paramInt, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    c(paramString1, 4, paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(a + "-" + paramString1, paramInt, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, 1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      a(paramString1, 2, paramString2);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      b(paramString1, 2, paramString2);
    }
  }
  
  public static void g(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      c(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tlo
 * JD-Core Version:    0.7.0.1
 */