import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class uqu
{
  public static String a(String paramString)
  {
    String str1;
    if ((paramString != null) && (paramString.length() < 5)) {
      str1 = (String)upg.a.get(paramString);
    }
    for (;;)
    {
      String str3 = str1;
      if (str1 == null) {
        str3 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptUtil", 2, "getUin subscribeID[" + paramString + "]'s uin: " + str3);
      }
      return str3;
      String str2;
      if (paramString != null) {
        try
        {
          int i = Integer.parseInt(paramString);
          str1 = String.valueOf(i);
        }
        catch (Exception localException)
        {
          str2 = (String)upg.a.get(paramString);
        }
      } else {
        str2 = paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqu
 * JD-Core Version:    0.7.0.1
 */