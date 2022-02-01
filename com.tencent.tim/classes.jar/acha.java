import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class acha
{
  public static boolean bHZ;
  private static boolean bIa;
  private static final SparseArray<Locale> ci = new SparseArray();
  private static int cwj;
  
  static
  {
    ci.put(2052, Locale.SIMPLIFIED_CHINESE);
    ci.put(1033, Locale.US);
  }
  
  public static int Ax()
  {
    return cwj;
  }
  
  public static Locale a()
  {
    Locale localLocale2 = a(cwj);
    Locale localLocale1 = localLocale2;
    if (localLocale2 == null) {
      localLocale1 = Locale.SIMPLIFIED_CHINESE;
    }
    printLog("queryCurrentLocale, currentLocale:" + localLocale1.toString());
    return localLocale1;
  }
  
  private static Locale a(int paramInt)
  {
    return (Locale)ci.get(paramInt);
  }
  
  public static void a(Context paramContext, Locale paramLocale)
  {
    if ((paramContext == null) || (paramLocale == null)) {
      return;
    }
    mqq.app.AppActivity.locale = paramLocale;
    mqq.app.BaseActivity.locale = paramLocale;
    com.tencent.mobileqq.pluginsdk.PluginProxyActivity.locale = paramLocale;
    paramContext = paramContext.getResources();
    Configuration localConfiguration = paramContext.getConfiguration();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(paramContext.getDisplayMetrics());
    if (Build.VERSION.SDK_INT >= 24)
    {
      printLog("rconf locale set1:" + paramLocale.toString());
      paramLocale = new LocaleList(new Locale[] { paramLocale });
      LocaleList.setDefault(paramLocale);
      localConfiguration.setLocales(paramLocale);
    }
    for (;;)
    {
      paramContext.updateConfiguration(localConfiguration, paramContext.getDisplayMetrics());
      paramContext.getDisplayMetrics().setTo(localDisplayMetrics);
      return;
      printLog("rconf locale set2:" + paramLocale.toString());
      Locale.setDefault(paramLocale);
      localConfiguration.locale = paramLocale;
    }
  }
  
  public static boolean a(Locale paramLocale1, Locale paramLocale2)
  {
    if ((paramLocale1 == null) || (paramLocale2 == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = paramLocale1.getLanguage().equals(paramLocale2.getLanguage());
      bool2 = paramLocale1.getCountry().equals(paramLocale2.getCountry());
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public static boolean aaA()
  {
    return cwj == 1033;
  }
  
  public static boolean aaB()
  {
    return bIa;
  }
  
  public static void ah(Context paramContext, int paramInt)
  {
    printLog("setLocale , localeId = " + paramInt);
    aczz.save(paramContext, "key_local_last", String.valueOf(cwj));
    aczz.save(paramContext, "key_local_cache", String.valueOf(paramInt));
    cwj = paramInt;
    com.tencent.mobileqq.highway.HwEngine.localeId = cwj;
    mqq.app.AppActivity.localeId = cwj;
    mqq.app.BaseActivity.localeId = cwj;
    ai(paramContext, cwj);
    a(paramContext, a(paramInt));
    if (aaA()) {
      actf.a().dU(paramContext);
    }
  }
  
  private static void ai(Context paramContext, int paramInt)
  {
    int i = 0;
    try
    {
      SettingCloneUtil.writeValueForInt(paramContext, null, null, "qqsetting_locale_id", paramInt);
      printLog("updateMsfLocaleId, localeId:" + paramInt + ", time:" + System.currentTimeMillis());
      for (;;)
      {
        if ((i >= 3) || (SettingCloneUtil.readValueForInt(paramContext, null, null, "qqsetting_locale_id", 0) == paramInt))
        {
          if (SettingCloneUtil.readValueForInt(paramContext, null, null, "qqsetting_locale_id", 0) != paramInt) {
            printLog("updateMsfLocaleId, write failed, time:" + System.currentTimeMillis());
          }
          AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
          paramContext = new NewIntent(paramContext, BuiltInServlet.class);
          paramContext.putExtra("action", 2212);
          paramContext.putExtra("localeId", paramInt);
          localAppRuntime.startServlet(paramContext);
          return;
        }
        SettingCloneUtil.writeValueForInt(paramContext, null, null, "qqsetting_locale_id", paramInt);
        printLog("updateMsfLocaleId, write localeId:" + paramInt + ", time:" + System.currentTimeMillis());
        Thread.sleep(10L);
        i += 1;
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("LocaleManager", 1, "updateMsfLocaleId error!", paramContext);
    }
  }
  
  public static void dM(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    printLog("initializeAppLocale, sCurrentLocaleId:" + cwj);
    String str;
    if (cwj == 0)
    {
      str = aczz.h(paramContext, "key_local_cache", "0");
      printLog("initializeAppLocale, localeIdStr:" + str);
      if (!"0".equals(str)) {
        break label189;
      }
      cwj = 2052;
      aczz.save(paramContext, "key_local_cache", String.valueOf(cwj));
      str = aczz.h(paramContext, "key_local_last", "0");
      if (!"0".equals(str)) {
        break label207;
      }
      if (cwj == 2052) {
        break label202;
      }
    }
    for (;;)
    {
      bIa = bool1;
      aczz.save(paramContext, "key_local_last", String.valueOf(cwj));
      printLog("initializeAppLocale, HwEngine.localeId:" + cwj);
      com.tencent.mobileqq.highway.HwEngine.localeId = cwj;
      mqq.app.AppActivity.localeId = cwj;
      mqq.app.BaseActivity.localeId = cwj;
      dN(paramContext);
      return;
      label189:
      cwj = Integer.parseInt(str.trim());
      break;
      label202:
      bool1 = false;
    }
    label207:
    if (Integer.parseInt(str) != cwj) {}
    for (bool1 = bool2;; bool1 = false)
    {
      bIa = bool1;
      break;
    }
  }
  
  public static void dN(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = paramContext.getResources();
      if (localObject != null)
      {
        localObject = ((Resources)localObject).getConfiguration();
        printLog("tryApplyLocaleIfNeeded, resLocale:" + ((Configuration)localObject).locale.toString());
        Locale localLocale = a();
        if (!a(localLocale, ((Configuration)localObject).locale))
        {
          printLog("tryApplyLocaleIfNeeded, called tryApplyLocale");
          a(paramContext, localLocale);
        }
      }
      return;
    }
    printLog("called tryApplyLocaleIfNeeded, context null");
  }
  
  public static void dO(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = null;
    if (localObject != null) {
      paramContext = ((ActivityManager)localObject).getRunningAppProcesses();
    }
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (!"com.tencent.mobileqq".equals(localRunningAppProcessInfo.processName))
        {
          Process.killProcess(localRunningAppProcessInfo.pid);
          printLog("process killed on locale update, pid:" + localRunningAppProcessInfo.pid + ", name:" + localRunningAppProcessInfo.processName);
        }
      }
      paramContext = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject).pid);
        printLog("process killed on locale update, pid:" + ((ActivityManager.RunningAppProcessInfo)localObject).pid + ", name:" + ((ActivityManager.RunningAppProcessInfo)localObject).processName);
      }
    }
  }
  
  public static String dz(int paramInt)
  {
    if (paramInt == 2052) {
      return acfp.m(2131695192);
    }
    if (paramInt == 1033) {
      return acfp.m(2131695191);
    }
    return "";
  }
  
  public static boolean isLocaleCN()
  {
    return cwj == 2052;
  }
  
  public static void printLog(String paramString)
  {
    QLog.d("LocaleManager", 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acha
 * JD-Core Version:    0.7.0.1
 */