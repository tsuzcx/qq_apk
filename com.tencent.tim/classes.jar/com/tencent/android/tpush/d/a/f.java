package com.tencent.android.tpush.d.a;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class f
  extends c
{
  StringBuffer a;
  private Object b = null;
  private Class<?> c = null;
  private Class<?> d = null;
  private String e;
  
  private Object f(Context paramContext)
  {
    try
    {
      this.c = Class.forName("com.vivo.push.PushClient");
      paramContext = this.c.getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(this.c, new Object[] { paramContext.getApplicationContext() });
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext = paramContext.getCause();
      TLogger.e("OtherPushVivoImpl", "getImplInstance Error for InvocationTargetException: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return null;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TLogger.e("OtherPushVivoImpl", "getImplInstance Error ", paramContext);
      }
    }
  }
  
  private String g(Context paramContext)
  {
    if (i.b(this.e)) {
      this.e = SharePrefsUtil.getString(paramContext, "vivo_token", "");
    }
    return this.e;
  }
  
  public String a()
  {
    return "vivo";
  }
  
  public void a(Context paramContext)
  {
    this.a = new StringBuffer();
    Object localObject = f(paramContext);
    if (localObject != null) {}
    try
    {
      if (this.c == null) {
        this.c = Class.forName("com.vivo.push.PushClient");
      }
      this.c.getDeclaredMethod("initialize", new Class[0]).invoke(localObject, new Object[0]);
      if (this.b == null)
      {
        this.d = Class.forName("com.vivo.push.IPushActionListener");
        a locala = new a(paramContext);
        this.b = Proxy.newProxyInstance(this.d.getClassLoader(), new Class[] { this.d }, locala);
      }
      if (this.d == null) {
        this.d = Class.forName("com.vivo.push.IPushActionListener");
      }
      this.c.getDeclaredMethod("turnOnPush", new Class[] { this.d }).invoke(localObject, new Object[] { this.b });
      TLogger.ii("OtherPushVivoImpl", "registerPush vivo push channel success");
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("OtherPushVivoImpl", "registerPush Throwable e: " + localThrowable.getMessage(), localThrowable);
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -140 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
    }
  }
  
  public void b(Context paramContext)
  {
    if (this.a == null) {
      this.a = new StringBuffer();
    }
    Object localObject = f(paramContext);
    if (localObject != null) {}
    try
    {
      if (this.b == null)
      {
        this.d = Class.forName("com.vivo.push.IPushActionListener");
        a locala = new a(paramContext);
        this.b = Proxy.newProxyInstance(this.d.getClassLoader(), new Class[] { this.d }, locala);
      }
      if (this.d == null) {
        this.d = Class.forName("com.vivo.push.IPushActionListener");
      }
      if (this.c == null) {
        this.c = Class.forName("com.vivo.push.PushClient");
      }
      this.c.getDeclaredMethod("turnOffPush", new Class[] { this.d }).invoke(localObject, new Object[] { this.b });
      TLogger.ii("OtherPushVivoImpl", "unregisterPush vivo push channel success");
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("OtherPushVivoImpl", "unregisterPush Throwable e: " + localThrowable.getMessage(), localThrowable);
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -143 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
    }
  }
  
  public String c(Context paramContext)
  {
    if (this.a == null) {
      this.a = new StringBuffer();
    }
    Object localObject1 = f(paramContext);
    if (localObject1 != null) {
      try
      {
        Object localObject2 = Class.forName("com.vivo.push.PushClient").getDeclaredMethod("getRegId", new Class[0]).invoke(localObject1, new Object[0]);
        String str = g(paramContext);
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject1 = str;
          if (!i.b(localObject2.toString()))
          {
            localObject1 = str;
            if (!localObject2.toString().equals(str))
            {
              this.e = localObject2.toString();
              SharePrefsUtil.setString(paramContext, "vivo_token", this.e);
              localObject1 = this.e;
            }
          }
        }
        return localObject1;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        TLogger.e("OtherPushVivoImpl", "getRegId Error for InvocationTargetException: ", localInvocationTargetException.getCause());
        SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -141 , errMsg : ").append(localInvocationTargetException.getLocalizedMessage()).toString());
        return "";
      }
      catch (Throwable localThrowable)
      {
        TLogger.e("OtherPushVivoImpl", "getRegId Error ", localThrowable);
        SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -142 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
      }
    }
    return "";
  }
  
  public boolean d(Context paramContext)
  {
    paramContext = f(paramContext);
    if (paramContext != null) {}
    try
    {
      boolean bool = ((Boolean)Class.forName("com.vivo.push.PushClient").getDeclaredMethod("isSupport", new Class[0]).invoke(paramContext, new Object[0])).booleanValue();
      if (!bool) {
        TLogger.e("OtherPushVivoImpl", "vivo push api isSupport() returns false, the device not support for vivo push!");
      }
      return bool;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext = paramContext.getCause();
      TLogger.e("OtherPushVivoImpl", "isConfig Error for InvocationTargetException: " + paramContext.getMessage());
      paramContext.printStackTrace();
      return false;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TLogger.e("OtherPushVivoImpl", "isConfig Error ", paramContext);
      }
    }
  }
  
  public int e(Context paramContext)
  {
    return 7;
  }
  
  public class a
    implements InvocationHandler
  {
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (paramMethod == null) {
        paramObject = null;
      }
      do
      {
        do
        {
          do
          {
            return paramObject;
            paramObject = paramMethod;
          } while (!paramMethod.getName().equals("onStateChanged"));
          paramObject = paramMethod;
        } while (paramArrayOfObject == null);
        paramObject = paramMethod;
      } while (paramArrayOfObject.length <= 0);
      int i = ((Integer)paramArrayOfObject[0]).intValue();
      if (i == 0)
      {
        TLogger.ii("OtherPushVivoImpl", "vivoPush Register or UnRegister success, code = " + i);
        paramObject = "errCode : " + i + " , errMsg : success";
        d.a(this.b, "OtherPushVivoImpl", paramObject);
        return paramMethod;
      }
      TLogger.ww("OtherPushVivoImpl", "vivoPush Register or UnRegister fail, code = " + i);
      SharePrefsUtil.setString(this.b, "other_push_error_code", new StringBuilder().append("errCode : ").append(i).append(" , errMsg : unknown").toString());
      return paramMethod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a.f
 * JD-Core Version:    0.7.0.1
 */