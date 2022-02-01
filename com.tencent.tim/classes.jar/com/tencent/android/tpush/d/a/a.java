package com.tencent.android.tpush.d.a;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a
  extends c
{
  private String a;
  
  private String f(Context paramContext)
  {
    if (i.b(this.a)) {
      this.a = SharePrefsUtil.getString(paramContext, "fcm_token", "");
    }
    return this.a;
  }
  
  public String a()
  {
    return "fcm";
  }
  
  public void a(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
      localClass.getMethod("registerPush", new Class[] { Context.class }).invoke(localClass, new Object[] { paramContext });
      return;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext = paramContext.getCause();
      TLogger.ee("OtherPushFcmImpl", "registerPush FCM Error for InvocationTargetException: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.ee("OtherPushFcmImpl", "registerPush FCM Error, are you import otherpush package? " + paramContext);
    }
  }
  
  public void b(Context paramContext)
  {
    try
    {
      Class localClass = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
      localClass.getMethod("unregisterPush", new Class[] { Context.class }).invoke(localClass, new Object[] { paramContext });
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.ee("OtherPushFcmImpl", "unregisterPush FCM Error, are you import otherpush package? " + paramContext);
    }
  }
  
  public String c(Context paramContext)
  {
    try
    {
      localObject1 = Class.forName("com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
      localObject2 = ((Class)localObject1).getMethod("getToken", new Class[] { Context.class }).invoke(localObject1, new Object[] { paramContext });
      str = f(paramContext);
      if ((localObject2 != null) && (!i.b(localObject2.toString()))) {
        localObject1 = localObject2.toString();
      }
    }
    catch (InvocationTargetException paramContext)
    {
      Object localObject2;
      String str;
      localObject1 = "";
      paramContext = paramContext.getCause();
      TLogger.ee("OtherPushFcmImpl", "getToken Error for InvocationTargetException: " + paramContext.getMessage());
      return localObject1;
    }
    catch (Throwable paramContext)
    {
      label107:
      Object localObject1 = "";
      label145:
      TLogger.ee("OtherPushFcmImpl", "getToken Error", paramContext);
      return localObject1;
    }
    try
    {
      if (!localObject2.toString().equals(str))
      {
        this.a = localObject2.toString();
        SharePrefsUtil.setString(paramContext, "fcm_token", localObject2.toString());
      }
      d.a(paramContext, "OtherPushFcmImpl", "errCode : 0 , errMsg : success");
      return localObject1;
    }
    catch (Throwable paramContext)
    {
      break label145;
    }
    catch (InvocationTargetException paramContext)
    {
      break label107;
    }
    return str;
  }
  
  public boolean d(Context paramContext)
  {
    try
    {
      boolean bool = com.tencent.android.tpush.d.a.a(paramContext, "com.tencent.android.tpush.otherpush.fcm.impl.OtherPushImpl");
      if (!bool) {
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      TLogger.ee("OtherPushFcmImpl", "isConfig :" + paramContext);
      return false;
    }
    return true;
  }
  
  public int e(Context paramContext)
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a.a
 * JD-Core Version:    0.7.0.1
 */