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
      if (paramContext == null) {
        break label37;
      }
      paramContext = paramContext.getDeviceId();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Object localObject;
        paramContext = "00000000000001";
        continue;
        label37:
        paramContext = null;
      }
    }
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
    Object localObject3;
    for (;;)
    {
      try
      {
        Object localObject1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        localObject1 = ((String)localObject1).toLowerCase(Locale.ENGLISH);
        if (((String)localObject1).contains("huawei")) {
          return a("ro.build.version.emui");
        }
        if (((String)localObject1).contains("xiaomi")) {
          return a("ro.miui.ui.version.name");
        }
        if (((String)localObject1).contains("gionee"))
        {
          localObject1 = a("ro.gn.extvernumber");
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return a("ro.build.display.id");
        }
        if (((String)localObject1).contains("vivo"))
        {
          localObject1 = a("ro.vivo.os.name");
          localObject3 = a("ro.vivo.os.version");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            return (String)localObject1 + "_" + (String)localObject3;
          }
          return a("ro.vivo.os.build.display.id");
        }
        if (((String)localObject1).contains("meizu")) {
          return a("ro.build.display.id");
        }
        if (((String)localObject1).contains("lenovo"))
        {
          localObject1 = a("ro.lenovo.lvp.version");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label253;
          }
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label253;
          }
          localObject1 = localObject1[0];
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return a("ro.build.version.incremental");
        }
        if (((String)localObject1).contains("letv")) {
          return a("ro.letv.eui");
        }
        if (((String)localObject1).contains("oppo"))
        {
          localObject1 = a("ro.build.version.opporom");
          return localObject1;
        }
      }
      catch (Throwable localThrowable) {}
      return null;
      label253:
      Object localObject2 = null;
    }
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bl
 * JD-Core Version:    0.7.0.1
 */