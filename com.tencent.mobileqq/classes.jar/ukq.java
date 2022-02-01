import com.tencent.qphone.base.util.QLog;

public class ukq
{
  private static int a()
  {
    return 2;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a()) {
      QLog.d(paramString1, a(), paramString2);
    }
  }
  
  private static boolean a()
  {
    return QLog.isColorLevel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukq
 * JD-Core Version:    0.7.0.1
 */