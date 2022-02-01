package com.tencent.android.tpush.d.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class d
  extends c
{
  String a;
  StringBuffer b;
  
  private String f(Context paramContext)
  {
    if (i.b(this.a)) {
      this.a = SharePrefsUtil.getString(paramContext, "xiaomi_token", "");
    }
    return this.a;
  }
  
  public String a()
  {
    return "xiaomi";
  }
  
  public void a(Context paramContext)
  {
    int j = 0;
    int i = 0;
    if (i.b(com.tencent.android.tpush.d.d.a)) {
      TLogger.ee("OtherPushMiImpl", "registerPush Error for xiaomi null appid");
    }
    label380:
    label381:
    for (;;)
    {
      return;
      if (i.b(com.tencent.android.tpush.d.d.b))
      {
        TLogger.ee("OtherPushMiImpl", "registerPush Error for xiaomi null miAppkey");
        return;
      }
      this.b = new StringBuffer();
      Object localObject2 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      Object localObject1 = paramContext.getPackageName();
      int k = Process.myPid();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        j = i;
        if (((Iterator)localObject2).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
          if ((localRunningAppProcessInfo.pid != k) || (!((String)localObject1).equals(localRunningAppProcessInfo.processName))) {
            break label380;
          }
          i = 1;
        }
      }
      for (;;)
      {
        break;
        if (j == 0) {
          break label381;
        }
        try
        {
          localObject1 = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
          localObject2 = ((Class)localObject1).getMethod("registerPush", new Class[] { Context.class, String.class, String.class });
          TLogger.i("OtherPushMiImpl", "begin Mipush register!" + com.tencent.android.tpush.d.d.a + " " + com.tencent.android.tpush.d.d.b);
          ((Method)localObject2).invoke(localObject1, new Object[] { paramContext, com.tencent.android.tpush.d.d.a, com.tencent.android.tpush.d.d.b });
          TLogger.ii("OtherPushMiImpl", "registerPush xm push channle success");
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localObject2 = localInvocationTargetException.getCause();
          TLogger.ee("OtherPushMiImpl", "xm registerPush Error for InvocationTargetException: " + ((Throwable)localObject2).getMessage());
          SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -130 , errMsg : ").append(localInvocationTargetException.getLocalizedMessage()).toString());
          return;
        }
        catch (Throwable localThrowable)
        {
          TLogger.ee("OtherPushMiImpl", "xm registerPush Error ", localThrowable);
          SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -131 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
          return;
        }
      }
    }
  }
  
  public void b(Context paramContext)
  {
    if (this.b == null) {
      this.b = new StringBuffer();
    }
    try
    {
      Class localClass = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
      localClass.getMethod("unregisterPush", new Class[] { Context.class }).invoke(localClass, new Object[] { paramContext });
      TLogger.ii("OtherPushMiImpl", "unregisterPush xm push channle success");
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable2 = localInvocationTargetException.getCause();
      TLogger.ee("OtherPushMiImpl", "unregisterPush Error for InvocationTargetException: " + localThrowable2.getMessage());
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -132 , errMsg : ").append(localInvocationTargetException.getLocalizedMessage()).toString());
      return;
    }
    catch (Throwable localThrowable1)
    {
      TLogger.ee("OtherPushMiImpl", "unregisterPush Error, are you import otherpush package? " + localThrowable1);
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -133 , errMsg : ").append(localThrowable1.getLocalizedMessage()).toString());
    }
  }
  
  public String c(Context paramContext)
  {
    if (this.b == null) {
      this.b = new StringBuffer();
    }
    try
    {
      Object localObject1 = Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
      Object localObject3 = ((Class)localObject1).getMethod("getRegId", new Class[] { Context.class }).invoke(localObject1, new Object[] { paramContext });
      localObject2 = f(paramContext);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (!i.b(localObject3.toString()))
        {
          localObject1 = localObject2;
          if (!localObject3.toString().equals(localObject2))
          {
            this.a = localObject3.toString();
            SharePrefsUtil.setString(paramContext, "xiaomi_token", localObject3.toString());
            localObject1 = this.a;
          }
        }
      }
      return localObject1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Object localObject2 = localInvocationTargetException.getCause();
      TLogger.ee("OtherPushMiImpl", "xm getToken Error for InvocationTargetException: " + ((Throwable)localObject2).getMessage());
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -134 , errMsg : ").append(localInvocationTargetException.getLocalizedMessage()).toString());
      return "";
    }
    catch (Throwable localThrowable)
    {
      TLogger.ee("OtherPushMiImpl", "xm getToken Error", localThrowable);
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -135 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
    }
    return "";
  }
  
  public boolean d(Context paramContext)
  {
    if ((i.b(com.tencent.android.tpush.d.d.a)) || (i.b(com.tencent.android.tpush.d.d.b))) {
      i.a(paramContext, 1);
    }
    if ((i.b(com.tencent.android.tpush.d.d.a)) || (i.b(com.tencent.android.tpush.d.d.b))) {
      i.k(paramContext);
    }
    if (i.b(com.tencent.android.tpush.d.d.a)) {}
    while (i.b(com.tencent.android.tpush.d.d.b)) {
      return false;
    }
    return true;
  }
  
  public int e(Context paramContext)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a.d
 * JD-Core Version:    0.7.0.1
 */