import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqul
{
  private static volatile boolean cWh;
  private static boolean cWi;
  
  public static String getSDKPrivatePath(String paramString)
  {
    if (!cWh) {}
    String str3;
    try
    {
      cWi = "mounted".equals(Environment.getExternalStorageState());
      cWh = true;
      String str1 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        if (cWi)
        {
          str3 = aqum.a().getExternalPath();
          if ((!paramString.startsWith("/")) && (paramString.indexOf(":") <= 0)) {
            break label149;
          }
          str1 = paramString;
          if (str3 != null)
          {
            str1 = paramString;
            if (!paramString.startsWith(str3))
            {
              str1 = paramString;
              if (paramString.startsWith(aqum.a().up()))
              {
                String[] arrayOfString = paramString.split(aqum.a().up());
                str1 = paramString;
                if (arrayOfString.length >= 2) {
                  str1 = str3 + arrayOfString[1];
                }
              }
            }
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      label149:
      do
      {
        for (;;)
        {
          QLog.e("VFSAssistantUtils", 1, "getSDKPrivatePath is called!", localException);
        }
        String str2 = paramString;
      } while (str3 == null);
    }
    return str3 + File.separator + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqul
 * JD-Core Version:    0.7.0.1
 */