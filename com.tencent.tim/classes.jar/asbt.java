import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class asbt
{
  public static void ai(String paramString1, int paramInt, String paramString2)
  {
    paramString2 = "step" + paramInt + "-->" + paramString2;
    QLog.d("WadlStep." + paramString1, 2, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, qQ(paramString2));
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, qQ(paramString2), paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 1, qQ(paramString2));
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, 1, qQ(paramString2), paramThrowable);
  }
  
  private static String qQ(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.startsWith("##@")) {
        str = "##@" + paramString;
      }
    }
    return str;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, qQ(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbt
 * JD-Core Version:    0.7.0.1
 */