import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public class apef
{
  public static apef.a a(String paramString)
  {
    int i = 1;
    apef.a locala = new apef.a();
    if (TextUtils.isEmpty(paramString)) {
      return locala;
    }
    for (;;)
    {
      try
      {
        int j = paramString.indexOf("://");
        if (j == -1)
        {
          j = 0;
          String str1 = paramString.substring(j);
          int m = str1.indexOf("/");
          int k = m;
          if (-1 == m) {
            k = str1.length() - 1;
          }
          m = paramString.indexOf("&bHost=");
          if (-1 == m)
          {
            i = 0;
            str1 = null;
            str2 = str1;
            if (str1 == null) {
              str2 = paramString.substring(j, k + j);
            }
            if (str2 == null) {
              break;
            }
            j = str2.indexOf(":");
            if (j < 0) {
              continue;
            }
            paramString = str2.substring(0, j);
            str1 = str2.substring(j + 1);
            locala.ip = paramString;
            locala.port = Integer.valueOf(str1).intValue();
            if (i == 0) {
              break;
            }
            locala.proxyType = 1;
            return locala;
          }
          int n = paramString.indexOf("&bPort=", m);
          if (-1 == n)
          {
            i = 0;
            str1 = null;
            continue;
          }
          str1 = paramString.substring("&bHost=".length() + m, n);
          String str2 = paramString.substring("&bPort=".length() + n);
          str1 = str1 + ":" + str2;
          continue;
          locala.ip = str2;
          locala.port = 0;
          continue;
        }
        j += 3;
      }
      catch (Exception paramString)
      {
        return locala;
      }
    }
  }
  
  public static apsf a(long paramLong)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return null;
    }
    return apsf.a(localQQAppInterface, paramLong);
  }
  
  public static int eN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return 0;
        } while (!paramString.startsWith("H_"));
        i = paramString.indexOf("_");
      } while (i == -1);
      j = paramString.lastIndexOf("_");
    } while (i == j);
    paramString = paramString.substring(j);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int eO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return 0;
          i = paramString.indexOf("User-ReturnCode=[");
        } while (i == -1);
        paramString = paramString.substring("User-ReturnCode=[".length() + i);
      } while (TextUtils.isEmpty(paramString));
      i = paramString.indexOf("]");
    } while (i == -1);
    paramString = paramString.substring(0, i);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int eP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return 0;
        } while (!paramString.startsWith("H_"));
        i = paramString.indexOf("_");
      } while (i == -1);
      j = paramString.lastIndexOf("_");
    } while (i == j);
    paramString = paramString.substring(i, j - 1);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String getNetWorkTypeName()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      return "none";
    }
    if (AppNetConnInfo.isWifiConn()) {
      return "wifi";
    }
    if (AppNetConnInfo.isMobileConn())
    {
      switch (AppNetConnInfo.getMobileInfo())
      {
      default: 
        return "unkonw";
      case -1: 
        return "none";
      case 0: 
      case 1: 
        return "2g";
      case 2: 
        return "3g";
      }
      return "4g";
    }
    return "none";
  }
  
  public static long hr()
  {
    return (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
  }
  
  public static String oD(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.startsWith("/")) {
      return paramString.substring(1);
    }
    return "/" + paramString;
  }
  
  public static class a
  {
    public String ip;
    public int port;
    public int proxyType;
  }
  
  public static class b
  {
    public static int CLR = 1;
    public static int DEV = 2;
    public static String LG_HEAD = "<TroopFile> ";
    public static int USR;
    
    public static void d(String paramString1, int paramInt, String paramString2)
    {
      QLog.d(paramString1, qlogLevelOf(paramInt), LG_HEAD + paramString2);
    }
    
    public static void e(String paramString1, int paramInt, String paramString2)
    {
      QLog.e(paramString1, qlogLevelOf(paramInt), LG_HEAD + paramString2);
    }
    
    public static void i(String paramString1, int paramInt, String paramString2)
    {
      QLog.i(paramString1, qlogLevelOf(paramInt), LG_HEAD + paramString2);
    }
    
    private static int qlogLevelOf(int paramInt)
    {
      int j = 2;
      int i;
      if (USR == paramInt) {
        i = 1;
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (CLR == paramInt);
        i = j;
      } while (DEV != paramInt);
      return 4;
    }
    
    public static void w(String paramString1, int paramInt, String paramString2)
    {
      QLog.w(paramString1, qlogLevelOf(paramInt), LG_HEAD + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apef
 * JD-Core Version:    0.7.0.1
 */