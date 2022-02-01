package com.tencent.android.tpush.d.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class c
  extends com.tencent.android.tpush.d.c
{
  String a;
  StringBuffer b;
  
  private String f(Context paramContext)
  {
    if (i.b(this.a)) {
      this.a = SharePrefsUtil.getString(paramContext, "meizu_token", "");
    }
    return this.a;
  }
  
  public String a()
  {
    return "meizu";
  }
  
  public void a(Context paramContext)
  {
    int j = 0;
    int i = 0;
    if (i.b(d.c)) {
      TLogger.ee("OtherPushMZImpl", "registerPush Error for mz null appid");
    }
    label376:
    label377:
    for (;;)
    {
      return;
      if (i.b(d.d))
      {
        TLogger.ee("OtherPushMZImpl", "registerPush Error for mz null mzAppkey");
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
            break label376;
          }
          i = 1;
        }
      }
      for (;;)
      {
        break;
        if (j == 0) {
          break label377;
        }
        TLogger.ii("OtherPushMZImpl", "begin Mzpush register!" + d.c + " " + d.d);
        try
        {
          localObject1 = Class.forName("com.meizu.cloud.pushsdk.PushManager");
          ((Class)localObject1).getMethod("register", new Class[] { Context.class, String.class, String.class }).invoke(localObject1, new Object[] { paramContext, d.c, d.d });
          TLogger.ii("OtherPushMZImpl", "creat meizu push channle success");
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localObject2 = localInvocationTargetException.getCause();
          TLogger.ee("OtherPushMZImpl", "meizu registerPush Error for InvocationTargetException: " + ((Throwable)localObject2).getMessage());
          SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -160 , errMsg : ").append(localInvocationTargetException.getLocalizedMessage()).toString());
          return;
        }
        catch (Throwable localThrowable)
        {
          TLogger.ee("OtherPushMZImpl", "meizu registerPush Error ", localThrowable);
          SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -161 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
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
      Class localClass = Class.forName("com.meizu.cloud.pushsdk.PushManager");
      localObject = localClass.getMethod("unRegister", new Class[] { Context.class, String.class, String.class });
      TLogger.i("OtherPushMZImpl", "begin Mzpush unregister!" + d.c + " " + d.d);
      ((Method)localObject).invoke(localClass, new Object[] { paramContext, d.c, d.d });
      TLogger.ii("OtherPushMZImpl", "unregisterPush meizu push channle success");
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Object localObject = localInvocationTargetException.getCause();
      TLogger.ee("OtherPushMZImpl", "meizu unregisterPush Error for InvocationTargetException: " + ((Throwable)localObject).getMessage());
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -162 , errMsg : ").append(localInvocationTargetException.getLocalizedMessage()).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.ee("OtherPushMZImpl", "meizu unregisterPush Error, are you import otherpush package? " + localThrowable);
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -163 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
    }
  }
  
  public String c(Context paramContext)
  {
    if (this.b == null) {
      this.b = new StringBuffer();
    }
    try
    {
      Object localObject1 = Class.forName("com.meizu.cloud.pushsdk.PushManager");
      Object localObject3 = ((Class)localObject1).getMethod("getPushId", new Class[] { Context.class }).invoke(localObject1, new Object[] { paramContext });
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
            SharePrefsUtil.setString(paramContext, "meizu_token", localObject3.toString());
            localObject1 = this.a;
          }
        }
      }
      return localObject1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Object localObject2 = localInvocationTargetException.getCause();
      TLogger.ee("OtherPushMZImpl", "meizu getToken Error for InvocationTargetException: " + ((Throwable)localObject2).getMessage());
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -164 , errMsg : ").append(localInvocationTargetException.getLocalizedMessage()).toString());
      return "";
    }
    catch (Throwable localThrowable)
    {
      TLogger.ee("OtherPushMZImpl", "meizu getToken Error", localThrowable);
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -165 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
    }
    return "";
  }
  
  public boolean d(Context paramContext)
  {
    if ((i.b(d.c)) || (i.b(d.d))) {
      i.a(paramContext, 2);
    }
    if ((i.b(d.c)) || (i.b(d.d))) {
      i.k(paramContext);
    }
    if (i.b(d.c)) {}
    while (i.b(d.d)) {
      return false;
    }
    return true;
  }
  
  public int e(Context paramContext)
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a.c
 * JD-Core Version:    0.7.0.1
 */