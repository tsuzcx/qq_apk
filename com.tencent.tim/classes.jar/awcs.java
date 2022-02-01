import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awcs
{
  private static List<String> LP;
  public static String cPh = "";
  public static int eAe;
  public static WeakReference<Activity> ji;
  
  public static String GL()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return GN();
    }
    return GM();
  }
  
  public static String GM()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningTasks(1);
    if ((localObject == null) || (((List)localObject).get(0) == null) || (((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity == null)) {
      return null;
    }
    localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
    return ((ComponentName)localObject).getPackageName() + "/" + ((ComponentName)localObject).getClassName();
  }
  
  private static String GN()
  {
    Object localObject3 = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if (QLog.isDevelopLevel()) {
      QLog.d("ProcessUtils", 4, "processInfos.size()=" + ((List)localObject3).size());
    }
    for (;;)
    {
      try
      {
        Object localObject1 = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
        if (localObject1 != null)
        {
          Iterator localIterator = ((List)localObject3).iterator();
          if (localIterator.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
            if (QLog.isDevelopLevel()) {
              QLog.d("ProcessUtils", 4, "processInfo: processName=" + localRunningAppProcessInfo.processName + " importance=" + localRunningAppProcessInfo.importance + " importanceReasonCode=" + localRunningAppProcessInfo.importanceReasonCode);
            }
            if ((localRunningAppProcessInfo.importance != 100) || (localRunningAppProcessInfo.importanceReasonCode != 0)) {
              continue;
            }
            try
            {
              int i = ((Field)localObject1).getInt(localRunningAppProcessInfo);
              localObject3 = Integer.valueOf(i);
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              QLog.w("ProcessUtils", 1, "IllegalAccessException", localIllegalAccessException);
              Object localObject4 = null;
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("ProcessUtils", 4, "processInfo: state=" + localObject3);
            }
            if ((localObject3 == null) || (((Integer)localObject3).intValue() != 2)) {
              continue;
            }
            localObject1 = localRunningAppProcessInfo;
            if (QLog.isDevelopLevel()) {
              QLog.d("ProcessUtils", 4, "===============");
            }
            if (localObject1 == null) {
              return null;
            }
          }
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        QLog.w("ProcessUtils", 1, "NoSuchFieldException: processState", localNoSuchFieldException);
        localObject2 = null;
        continue;
        return localObject2.processName;
      }
      Object localObject2 = null;
    }
  }
  
  public static void Z(Activity paramActivity, String paramString)
  {
    ji = new WeakReference(paramActivity);
    eAe = ji.hashCode();
    cPh = paramString;
  }
  
  public static String getCurProcessName(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      QLog.e("ProcessUtils", 1, "getCurProcessName: processInfos is null.");
      return null;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public static Activity getTopActivity()
  {
    return (Activity)ji.get();
  }
  
  private static List<String> hB()
  {
    if (LP != null) {
      return LP;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    localObject = ((PackageManager)localObject).queryIntentActivities(localIntent, 65536).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName);
    }
    LP = localArrayList;
    return localArrayList;
  }
  
  public static String rH()
  {
    return cPh;
  }
  
  public static boolean tF(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    List localList;
    do
    {
      return false;
      localList = hB();
      if (localList.contains(paramString)) {
        return true;
      }
      paramString = paramString.split("/");
    } while (paramString.length < 2);
    return localList.contains(paramString[0]);
  }
  
  public static boolean tG(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ("com.tencent.mobileqq:qzone".equals(paramString)) {
        return true;
      }
      paramString = paramString.split("/");
    } while ((paramString.length < 2) || (!"com.tencent.mobileqq".equals(paramString[0])) || (TextUtils.isEmpty(paramString[1])));
    paramString = paramString[1].toLowerCase().split("\\.");
    if ((paramString.length > 0) && (paramString[(paramString.length - 1)].startsWith("qzone")) && (paramString[(paramString.length - 1)].endsWith("proxyactivity"))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean tH(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("com.tencent.mobileqq:tool".equals(paramString)) || ("com.tencent.mobileqq/com.tencent.mobileqq.activity.QQBrowserActivity".equals(paramString)));
  }
  
  public static boolean tI(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("com.tencent.mobileqq:peak".equals(paramString)) || ("com.tencent.mobileqq/com.tencent.mobileqq.activity.photo.PhotoListActivity".equals(paramString)) || ("com.tencent.mobileqq/com.tencent.mobileqq.activity.photo.AlbumListActivity".equals(paramString)));
  }
  
  public static boolean tJ(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("com.tencent.mobileqq:picture".equals(paramString)) || ("com.tencent.mobileqq/cooperation.qzone.QzonePicturePluginProxyActivity".equals(paramString)));
  }
  
  public static boolean tK(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("com.tencent.mobileqq:qzonelive".equals(paramString)) || ("com.tencent.mobileqq/cooperation.qzone.video.QzoneLiveVideoGpuProxyActivity".equals(paramString)));
  }
  
  public static boolean tL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ("com.tencent.mobileqq".equals(paramString)) {
        return true;
      }
      paramString = paramString.split("/");
    } while ((paramString.length < 2) || (!"com.tencent.mobileqq".equals(paramString[0])) || (TextUtils.isEmpty(paramString[1])));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     awcs
 * JD-Core Version:    0.7.0.1
 */