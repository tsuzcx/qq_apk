package com.tencent.android.tpush.stat.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import java.util.Set;

public class a
  extends TTask
{
  private static long a = 0L;
  private static long b = 0L;
  private static String f;
  private static volatile boolean g;
  private static a h;
  private Intent c;
  private String d;
  private Context e;
  
  public a(Context paramContext, Intent paramIntent, String paramString)
  {
    super("AppLaunchTask");
    this.c = paramIntent;
    this.d = paramString;
    this.e = paramContext;
  }
  
  private void a()
  {
    if ((i.c(this.e, this.e.getPackageName())) && (PushPreferences.getBoolean(this.e, "app_first_launch", true)))
    {
      ServiceStat.reportCustomData4FirstLaunch(this.e);
      PushPreferences.putBoolean(this.e, "app_first_launch", false);
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {}
    try
    {
      TLogger.w("AppLaunchTask", "onActivityExits - activity was null, reason:" + paramString);
      return;
    }
    catch (Throwable paramActivity) {}
    if (a(paramActivity))
    {
      TLogger.d("AppLaunchTask", "setLastedBackgroundTime - activity was wake translucent Activity");
      return;
    }
    a = System.currentTimeMillis();
    if (b != 0L) {
      b = 0L;
    }
    return;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (i.b(paramString1))
      {
        TLogger.d("AppLaunchTask", "token was null");
        return;
      }
      if (paramContext == null)
      {
        TLogger.d("AppLaunchTask", "context was null");
        return;
      }
      if (!Util.isMainProcess(paramContext))
      {
        TLogger.d("AppLaunchTask", "must run at main process");
        return;
      }
      f = paramString1;
      if ((g) && (h != null))
      {
        CommonWorkingThread.getInstance().execute(h);
        g = false;
        h = null;
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private static boolean a(Activity paramActivity)
  {
    if (paramActivity == null) {
      TLogger.d("AppLaunchTask", "isWakeTranslucentActivity - activity was null");
    }
    String str;
    do
    {
      return false;
      str = paramActivity.getComponentName().getClassName();
    } while ((!i.a(paramActivity)) || (TextUtils.equals(str, TpnsActivity.class.getCanonicalName())));
    return true;
  }
  
  private static boolean a(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      if (!i.b(f)) {
        break;
      }
      f = GuidInfoManager.getToken(paramContext.getApplicationContext());
    } while (i.b(f));
    return true;
  }
  
  private int b(Context paramContext)
  {
    long l1 = PushPreferences.getLong(paramContext, "fisrt.launch.of.the.day", 0L);
    long l2 = System.currentTimeMillis();
    boolean bool = i.a(l2, l1);
    if (!bool) {
      PushPreferences.putLong(paramContext, "fisrt.launch.of.the.day", l2);
    }
    if (bool) {
      return 0;
    }
    return 1;
  }
  
  private void b()
  {
    int i;
    long l;
    if (!CloudManager.getInstance(this.e).disableRepLanuEv()) {
      if (TextUtils.equals(this.d, TpnsActivity.class.getCanonicalName()))
      {
        i = 3;
        l = TpnsActivity.getMsgIdWithIntent(this.c);
      }
    }
    for (;;)
    {
      int j = b(this.e);
      ServiceStat.reportLaunchEvent(this.e, i, j, l);
      return;
      if (this.c != null)
      {
        Object localObject = this.c.getData();
        if ((localObject != null) && (!i.b(((Uri)localObject).getHost())))
        {
          i = 2;
          l = 0L;
        }
        else
        {
          localObject = this.c.getAction();
          Set localSet = this.c.getCategories();
          if ((localSet != null) && (localSet.contains("android.intent.category.LAUNCHER"))) {
            i = 1;
          }
          for (;;)
          {
            if ((TextUtils.equals((CharSequence)localObject, "android.intent.action.MAIN")) && (i != 0))
            {
              i = 1;
              l = 0L;
              break;
              i = 0;
              continue;
              TLogger.d("AppLaunchTask", "disabled report launch event");
              return;
            }
          }
        }
      }
      else
      {
        l = 0L;
        i = 4;
      }
    }
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {}
    try
    {
      TLogger.w("AppLaunchTask", "onActivityEntry - activity was null, reason:" + paramString);
      return;
    }
    catch (Throwable paramActivity) {}
    if (a(paramActivity))
    {
      TLogger.d("AppLaunchTask", "activity was wake translucent Activity");
      return;
    }
    if (!a(paramActivity))
    {
      if (c())
      {
        g = true;
        h = c(paramActivity, paramString);
      }
    }
    else
    {
      if (c()) {
        d(paramActivity, paramString);
      }
      if (b == 0L) {
        b = System.currentTimeMillis();
      }
    }
    return;
  }
  
  private static a c(Activity paramActivity, String paramString)
  {
    if (paramActivity == null)
    {
      TLogger.d("AppLaunchTask", "runAppLaunch - activity was null");
      return null;
    }
    paramString = paramActivity.getComponentName().getClassName();
    Intent localIntent = paramActivity.getIntent();
    return new a(paramActivity.getApplicationContext(), localIntent, paramString);
  }
  
  /* Error */
  private static boolean c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   6: lstore_0
    //   7: getstatic 22	com/tencent/android/tpush/stat/a/a:a	J
    //   10: lstore_2
    //   11: getstatic 24	com/tencent/android/tpush/stat/a/a:b	J
    //   14: lstore 4
    //   16: lload 4
    //   18: lconst_0
    //   19: lcmp
    //   20: ifne +22 -> 42
    //   23: lload_0
    //   24: lload_2
    //   25: lsub
    //   26: ldc2_w 257
    //   29: lcmp
    //   30: ifle +12 -> 42
    //   33: iconst_1
    //   34: istore 6
    //   36: ldc 2
    //   38: monitorexit
    //   39: iload 6
    //   41: ireturn
    //   42: iconst_0
    //   43: istore 6
    //   45: goto -9 -> 36
    //   48: astore 7
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload 7
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	18	0	l1	long
    //   10	15	2	l2	long
    //   14	3	4	l3	long
    //   34	10	6	bool	boolean
    //   48	6	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	48	finally
  }
  
  private static void d(Activity paramActivity, String paramString)
  {
    try
    {
      paramActivity = c(paramActivity, paramString);
      if (paramActivity != null) {
        CommonWorkingThread.getInstance().execute(paramActivity);
      }
      h = null;
      g = false;
      return;
    }
    catch (Throwable paramActivity)
    {
      TLogger.d("AppLaunchTask", "unexpected for runAppLaunch:" + paramActivity.getMessage());
    }
  }
  
  public void TRun()
  {
    if (this.e == null)
    {
      TLogger.d("AppLaunchTask", "context was null");
      return;
    }
    a();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.a.a
 * JD-Core Version:    0.7.0.1
 */