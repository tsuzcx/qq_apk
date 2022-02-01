import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import mqq.app.AppRuntime;

public abstract class aacl
{
  public static boolean bvb = TextUtils.isEmpty(ql());
  public AppRuntime mApp;
  
  public aacl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public static String X(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = Y(paramString, paramInt);
      if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        aadj.w(paramString, paramInt, NetConnInfoCenter.getServerTimeMillis());
        return str;
      }
    }
    return null;
  }
  
  public static String Y(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = MD5.toMD5(paramString);
    return cT(paramInt) + paramString;
  }
  
  public static String c(AppRuntime paramAppRuntime, String paramString)
  {
    return d(paramAppRuntime) + paramString;
  }
  
  public static String cT(int paramInt)
  {
    if (paramInt == 1) {
      return qk();
    }
    String str = ql();
    if (!TextUtils.isEmpty(str))
    {
      bvb = false;
      return str;
    }
    bvb = true;
    return qk();
  }
  
  public static String d(AppRuntime paramAppRuntime)
  {
    return aagi.bcS + paramAppRuntime.getAccount() + "/" + ".preloaduni" + "/";
  }
  
  public static String getFilePath(String paramString)
  {
    return Y(paramString, 0);
  }
  
  public static String id(String paramString)
  {
    return X(paramString, 0);
  }
  
  public static String qj()
  {
    return cT(0);
  }
  
  public static String qk()
  {
    return aagi.bcS + ".preloaduni" + "/";
  }
  
  public static String ql()
  {
    String str1 = null;
    try
    {
      String str2 = aagi.bcQ;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2 + ".preloaduni" + "/";
      }
      return str1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private int u(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("WiFi")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("4G")) {
        return 4;
      }
      if (paramString.equalsIgnoreCase("3G")) {
        return 3;
      }
      if (paramString.equalsIgnoreCase("2G")) {
        return 2;
      }
    } while (!paramString.equalsIgnoreCase("5G"));
    return 6;
  }
  
  public abstract void a(DownloadParam paramDownloadParam, PreloadManager.d paramd);
  
  public void c(String paramString, PreloadManager.d paramd)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString;
    a(localDownloadParam, paramd);
  }
  
  public boolean iK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = aqiw.getSystemNetwork(this.mApp.getApplication());
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label57;
      }
      if (u(paramString[i]) == j) {
        break;
      }
      i += 1;
    }
    label57:
    return false;
  }
  
  public String ic(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacl
 * JD-Core Version:    0.7.0.1
 */