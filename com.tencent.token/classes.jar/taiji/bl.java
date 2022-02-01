package taiji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

public class bl
{
  public static String a()
  {
    return Build.MODEL;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        paramContext = paramContext.getDeviceId();
      } else {
        paramContext = null;
      }
    }
    catch (Throwable paramContext)
    {
      label27:
      Object localObject;
      break label27;
    }
    paramContext = "00000000000001";
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "00000000000000";
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    String str = SystemProperties.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public static String b()
  {
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (str2 == null) {
      str1 = "UNKNOWN";
    }
    return str1;
  }
  
  public static String c()
  {
    Object localObject2 = Build.BRAND;
    Object localObject1;
    if (!"BBK".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (!"bbk".equalsIgnoreCase((String)localObject2)) {}
    }
    else
    {
      localObject1 = "vivo";
    }
    if (!"HONOR".equalsIgnoreCase((String)localObject1))
    {
      localObject2 = localObject1;
      if (!"honor".equalsIgnoreCase((String)localObject1)) {}
    }
    else
    {
      localObject2 = "huawei";
    }
    return localObject2;
  }
  
  public static String d()
  {
    String str1;
    for (Object localObject = null;; str1 = null)
    {
      try
      {
        String str2 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str2)) {
          return null;
        }
        str2 = str2.toLowerCase(Locale.ENGLISH);
        if (str2.contains("huawei")) {
          return a("ro.build.version.emui");
        }
        if (str2.contains("xiaomi")) {
          return a("ro.miui.ui.version.name");
        }
        if (str2.contains("gionee"))
        {
          localObject = a("ro.gn.extvernumber");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return a("ro.build.display.id");
          }
        }
        else
        {
          if (str2.contains("vivo"))
          {
            localObject = a("ro.vivo.os.name");
            str2 = a("ro.vivo.os.version");
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("_");
              localStringBuilder.append(str2);
              return localStringBuilder.toString();
            }
            return a("ro.vivo.os.build.display.id");
          }
          if (str2.contains("meizu")) {
            return a("ro.build.display.id");
          }
          if (str2.contains("lenovo"))
          {
            localObject = a("ro.lenovo.lvp.version");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              continue;
            }
            localObject = ((String)localObject).split("_");
            if ((localObject == null) || (localObject.length <= 0)) {
              continue;
            }
            localObject = localObject[0];
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            return a("ro.build.version.incremental");
          }
          if (str2.contains("letv")) {
            return a("ro.letv.eui");
          }
          if (str2.contains("oppo")) {
            localObject = a("ro.build.version.opporom");
          }
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      return localThrowable;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bl
 * JD-Core Version:    0.7.0.1
 */