package taiji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.service.update.e;
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
    if (!e.a().b()) {
      return "UNKNOWN";
    }
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (str2 == null) {
      str1 = "UNKNOWN";
    }
    return str1;
  }
  
  public static String c()
  {
    if (!e.a().b()) {
      return "UNKNOWN";
    }
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
    if (!e.a().b()) {
      return null;
    }
    label274:
    String str1;
    for (;;)
    {
      try
      {
        Object localObject = Build.MANUFACTURER;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return null;
        }
        localObject = ((String)localObject).toLowerCase(Locale.ENGLISH);
        if (((String)localObject).contains("huawei")) {
          return a("ro.build.version.emui");
        }
        if (((String)localObject).contains("xiaomi")) {
          return a("ro.miui.ui.version.name");
        }
        if (((String)localObject).contains("gionee"))
        {
          localObject = a("ro.gn.extvernumber");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return a("ro.build.display.id");
          }
        }
        else
        {
          if (((String)localObject).contains("vivo"))
          {
            localObject = a("ro.vivo.os.name");
            String str2 = a("ro.vivo.os.version");
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
          if (((String)localObject).contains("meizu")) {
            return a("ro.build.display.id");
          }
          if (((String)localObject).contains("lenovo"))
          {
            localObject = a("ro.lenovo.lvp.version");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label281;
            }
            localObject = ((String)localObject).split("_");
            if (localObject == null) {
              break label281;
            }
            if (localObject.length > 0) {
              break label274;
            }
            break label281;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            return a("ro.build.version.incremental");
          }
          if (((String)localObject).contains("letv")) {
            return a("ro.letv.eui");
          }
          if (((String)localObject).contains("oppo"))
          {
            localObject = a("ro.build.version.opporom");
            return localObject;
          }
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      return localThrowable;
      str1 = localThrowable[0];
      continue;
      label281:
      str1 = null;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bl
 * JD-Core Version:    0.7.0.1
 */