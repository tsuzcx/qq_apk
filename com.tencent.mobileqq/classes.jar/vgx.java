import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vgx
{
  protected static List<String> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    paramContext = paramContext.queryIntentActivities(localIntent, 65536).iterator();
    while (paramContext.hasNext()) {
      localArrayList.add(((ResolveInfo)paramContext.next()).activityInfo.packageName);
    }
    return localArrayList;
  }
  
  protected static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramInt != 0)) {
      paramQQAppInterface.s();
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "playSound ringType = " + paramInt);
    }
  }
  
  protected static boolean a(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (localList == null) {
      return false;
    }
    return a(paramContext).contains(((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 == null) {
      return false;
    }
    boolean bool = GesturePWDUtils.getGestureLocking((Context)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.protocol", 2, "isQQForeground isQQLock=" + bool);
    }
    if ((paramQQAppInterface == null) || (bool)) {
      return false;
    }
    if (a((Context)localObject1)) {
      return false;
    }
    if (!paramQQAppInterface.isBackground_Pause) {
      return true;
    }
    try
    {
      Object localObject2 = (ActivityManager)((Context)localObject1).getApplicationContext().getSystemService("activity");
      if (localObject2 == null) {
        return false;
      }
      paramQQAppInterface = ((Context)localObject1).getApplicationContext().getPackageName();
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        return false;
      }
      localObject1 = ((ActivityManager)localObject2).getRunningAppProcesses();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if ((((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100) && (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null))
        {
          if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface + ":video")) {
            return false;
          }
          if (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals(paramQQAppInterface))
          {
            bool = ((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith(paramQQAppInterface + ":");
            if (!bool) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgx
 * JD-Core Version:    0.7.0.1
 */