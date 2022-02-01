import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class aeee
{
  private static boolean bTf;
  private static boolean bTg;
  private static Point i = new Point(-1, -1);
  
  public static void Hn(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (bi(BaseApplicationImpl.getContext())) {
        bool = true;
      }
    }
    if ((bool) && (bTg))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (((localAppRuntime instanceof QQAppInterface)) && (localAppRuntime.isLogin()) && (((QQAppInterface)localAppRuntime).a().a().Cf() > 0)) {
        e(((QQAppInterface)localAppRuntime).getApp(), false, true);
      }
    }
  }
  
  public static void Ho(boolean paramBoolean)
  {
    try
    {
      bTg = paramBoolean;
      if (QLog.isDevelopLevel()) {
        QLog.d("ColorNoteSmallScreenUtil", 2, "setAfterSyncMsg " + bTg);
      }
      Intent localIntent = new Intent("key_after_sync_msg");
      localIntent.putExtra("extra_after_sync_msg", bTg);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
      if (paramBoolean)
      {
        QLog.d("ColorNoteSmallScreenUtil", 1, "after sync, show floating window");
        e(BaseApplicationImpl.getContext(), false, false);
      }
      return;
    }
    finally {}
  }
  
  public static boolean Wn()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ColorNoteSmallScreenUtil", 2, "isAfterSyncMsg() " + bTg);
    }
    return bTg;
  }
  
  public static Point a(QQAppInterface paramQQAppInterface)
  {
    if ((i.x == -1) || (i.y == -1))
    {
      paramQQAppInterface = aqmj.c(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
      int k = paramQQAppInterface.getInt("colornote_windows_x", -1);
      int m = paramQQAppInterface.getInt("colornote_windows_y", -1);
      int j;
      if (k != -1)
      {
        j = m;
        if (m != -1) {}
      }
      else
      {
        k = aqnm.getScreenWidth() - aqnm.dip2px(25.0F);
        j = aqnm.getScreenHeight() / 2 + aqnm.dip2px(25.0F);
      }
      i.x = k;
      i.y = j;
    }
    return i;
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, ColorNote paramColorNote)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenUtil", 1, "showColorNoteSmallScreen , idAdd = " + paramBoolean1 + ", sHasServiceExit = " + bTf + ", force = " + paramBoolean2);
        }
        int j = b(paramColorNote);
        if ((!aeds.checkPermission(paramContext)) && (paramBoolean1)) {
          am(paramContext, j);
        }
        if ((!bTf) || (paramBoolean2))
        {
          bTf = true;
          paramColorNote = new Intent(paramContext, ColorNoteSmallScreenService.class);
          try
          {
            paramContext.startService(paramColorNote);
            return;
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + paramContext);
            }
            bTf = false;
            continue;
          }
        }
        e(paramContext, 3, true);
      }
      finally {}
    }
  }
  
  private static void am(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ColorNoteSmallScreenUtil", 2, "showPermissionDialog in");
    }
    paramContext = new Intent();
    paramContext.putExtra("public_fragment_window_feature", 1);
    paramContext.putExtra("key_permission_from", paramInt);
    if ((paramInt == 3) && (aebd.ago())) {}
    while (ColorNoteSmallScreenPermissionDialogFragment.bSY) {
      return;
    }
    PublicFragmentActivity.b.a(paramContext, PublicTransFragmentActivity.class, ColorNoteSmallScreenPermissionDialogFragment.class);
  }
  
  public static int b(ColorNote paramColorNote)
  {
    if ((paramColorNote != null) && (aebs.j(paramColorNote))) {
      return 2;
    }
    if (aebs.h(paramColorNote)) {
      return 3;
    }
    return 1;
  }
  
  private static boolean bi(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (!((List)localObject).isEmpty())
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (QLog.isDevelopLevel()) {
        QLog.d("FSReceiver", 4, new Object[] { "currTopPkg:", ((ComponentName)localObject).getPackageName() });
      }
      if (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) {
        return true;
      }
    }
    return false;
  }
  
  public static void e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenUtil", 1, "sendUpdateSmallScreenStateBroadcast sHasServiceExit = " + bTf + ", from = " + paramInt + ", shouldShow = " + paramBoolean);
    }
    Intent localIntent1 = new Intent("action_update_cn_smallscreen_state");
    localIntent1.setPackage(paramContext.getPackageName());
    localIntent1.putExtra("param_from", paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramContext.sendBroadcast(localIntent1);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenUtil", 2, "sendUpdateSmallScreenStateBroadcast:" + paramBoolean);
      }
      return;
      localIntent1.putExtra("param_not_in_colornote_list", paramBoolean);
      continue;
      localIntent1.putExtra("param_shoule_show_smallscreen", paramBoolean);
      continue;
      Intent localIntent2;
      if (paramBoolean) {
        localIntent2 = new Intent(paramContext, ColorNoteSmallScreenService.class);
      }
      try
      {
        paramContext.startService(localIntent2);
        localIntent1.putExtra("param_is_app_foreground", paramBoolean);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + localException);
          }
        }
      }
      localIntent1.putExtra("param_custom_night_mode", paramBoolean);
    }
  }
  
  public static void e(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      a(paramContext, paramBoolean1, paramBoolean2, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void ee(Context paramContext)
  {
    Intent localIntent;
    if (!bTf)
    {
      bTf = true;
      localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
    }
    try
    {
      paramContext.startService(localIntent);
      e(paramContext, 3, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenUtil", 2, "actionOn e = " + localException);
        }
        bTf = false;
      }
    }
  }
  
  /* Error */
  public static void ef(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +31 -> 37
    //   9: ldc 80
    //   11: iconst_1
    //   12: new 82	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 330
    //   22: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: getstatic 177	aeee:bTf	Z
    //   28: invokevirtual 93	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: new 103	android/content/Intent
    //   40: dup
    //   41: aload_0
    //   42: ldc 194
    //   44: invokespecial 197	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   47: astore_1
    //   48: iconst_0
    //   49: putstatic 177	aeee:bTf	Z
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 334	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   57: pop
    //   58: ldc 2
    //   60: monitorexit
    //   61: return
    //   62: astore_0
    //   63: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -8 -> 58
    //   69: ldc 80
    //   71: iconst_2
    //   72: new 82	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 336
    //   82: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 338	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -37 -> 58
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramContext	Context
    //   47	7	1	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   48	58	62	java/lang/Exception
    //   3	37	98	finally
    //   37	48	98	finally
    //   48	58	98	finally
    //   63	95	98	finally
  }
  
  public static void hH(int paramInt1, int paramInt2)
  {
    i.x = paramInt1;
    i.y = paramInt2;
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    boolean bool2 = false;
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localRunningAppProcessInfo = null;
        paramContext = localRunningAppProcessInfo;
        if (localList != null)
        {
          paramContext = localRunningAppProcessInfo;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label259;
        }
        if (!QLog.isDevelopLevel()) {
          break label264;
        }
        QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground componentName = " + paramContext);
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        bool1 = bool2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground e = " + paramContext);
        return false;
      }
      if (bool1)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if ((localRunningAppProcessInfo.importance != 100) || (!localRunningAppProcessInfo.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("ColorNoteSmallScreenUtil", 2, "isAppOnForeground appProcess.processName = " + localRunningAppProcessInfo.processName);
            }
            bool1 = true;
            return bool1;
          }
        }
        bool1 = false;
        continue;
      }
      continue;
      label259:
      boolean bool1 = false;
      continue;
      label264:
      bool1 = true;
    }
  }
  
  public static void y(Context paramContext, boolean paramBoolean)
  {
    if (BaseApplicationImpl.getApplication().getRuntime().isLogin())
    {
      Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
      localIntent.putExtra("KEY_CMD_SHOW_LIST", 1);
      localIntent.putExtra("KEY_SHOW_LIST_LAND", paramBoolean);
      paramContext.startService(localIntent);
    }
  }
  
  public static void z(Context paramContext, boolean paramBoolean)
  {
    if (BaseApplicationImpl.getApplication().getRuntime().isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenUtil", 2, "[showListFromAddTodo], is called");
      }
      Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
      localIntent.putExtra("KEY_CMD_SHOW_LIST", 1);
      localIntent.putExtra("key_upcoming_notify", 2);
      localIntent.putExtra("KEY_SHOW_LIST_LAND", paramBoolean);
      paramContext.startService(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeee
 * JD-Core Version:    0.7.0.1
 */