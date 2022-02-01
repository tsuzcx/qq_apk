import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class twh
{
  public static String a(String paramString)
  {
    String str1;
    if ((paramString != null) && (paramString.length() < 5)) {
      str1 = (String)tut.a.get(paramString);
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
      try
      {
        int i = Integer.parseInt(paramString);
        str1 = String.valueOf(i);
      }
      catch (Exception localException)
      {
        String str2 = (String)tut.a.get(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twh
 * JD-Core Version:    0.7.0.1
 */