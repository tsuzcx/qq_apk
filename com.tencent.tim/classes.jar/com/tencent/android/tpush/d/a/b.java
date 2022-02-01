package com.tencent.android.tpush.d.a;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class b
  extends c
{
  Context a;
  BroadcastReceiver b = null;
  String c;
  StringBuffer d;
  private int e = 0;
  private Class<?> f = null;
  
  private int c()
  {
    try
    {
      this.f = Class.forName("com.huawei.hms.aaid.HmsInstanceId");
      return 3;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.f = Class.forName("com.huawei.android.hms.agent.HMSAgent");
        return 2;
      }
      catch (Throwable localThrowable2)
      {
        this.f = null;
        SharePrefsUtil.setString(this.a, "other_push_error_code", new StringBuilder().append("errCode : -121 , errMsg : ").append(localThrowable2.getLocalizedMessage()).toString());
      }
    }
    return -1;
  }
  
  private void g(Context paramContext)
  {
    if (this.b == null) {
      this.b = new b.1(this);
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
      localIntentFilter.addAction("com.huawei.android.push.intent.RECEIVE");
      localIntentFilter.addAction("com.huawei.intent.action.PUSH_STATE");
      paramContext.registerReceiver(this.b, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("OtherPushHuaWeiImpl", "registerReceiver error", localThrowable);
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -129 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
    }
  }
  
  public String a()
  {
    return "huawei";
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
    this.d = new StringBuffer();
    TLogger.i("OtherPushHuaWeiImpl", "other push huawei registerPush");
    g(paramContext);
    if (this.e == 0) {
      this.e = c();
    }
    TLogger.ii("OtherPushHuaWeiImpl", "Get HW SDK version: " + this.e);
    Object localObject2;
    try
    {
      if (this.e == 3)
      {
        Object localObject1 = this.f.getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(this.f, new Object[] { paramContext });
        localObject2 = this.f.getDeclaredMethod("getToken", new Class[] { String.class, String.class });
        String str = f(paramContext);
        TLogger.i("OtherPushHuaWeiImpl", "Get HW appId from agcp: " + str);
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[] { str, "HCM" });
        if ((localObject1 != null) && (!TextUtils.isEmpty(localObject1.toString())))
        {
          TLogger.i("OtherPushHuaWeiImpl", "Get HW token: " + localObject1.toString());
          if (!localObject1.toString().equals(c(paramContext)))
          {
            this.c = localObject1.toString();
            SharePrefsUtil.setString(paramContext, "huawei_token", this.c);
          }
          d.a(paramContext, "OtherPushHuaWeiImpl", "errCode : 0 , errMsg : success");
          return;
        }
        TLogger.i("OtherPushHuaWeiImpl", "Get HW token from HWS.getToken null or empty, get it from receiver");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("OtherPushHuaWeiImpl", "" + localThrowable.getCause(), localThrowable);
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -123 , errMsg :").append(localThrowable.getLocalizedMessage()).toString());
      return;
    }
    if (this.e == 2)
    {
      this.f.getDeclaredMethod("init", new Class[] { Application.class }).invoke(this.f, new Object[] { paramContext.getApplicationContext() });
      Class localClass = Class.forName("com.huawei.android.hms.agent.common.handler.ConnectHandler");
      localObject2 = new a();
      localObject2 = Proxy.newProxyInstance(this.f.getClassLoader(), new Class[] { localClass }, (InvocationHandler)localObject2);
      this.f.getDeclaredMethod("connect", new Class[] { Activity.class, localClass }).invoke(this.f, new Object[] { null, localObject2 });
      return;
    }
    if (this.e == -1)
    {
      SharePrefsUtil.setString(paramContext, "other_push_error_code", "errCode : -122 , errMsg : Missing HWPush Service SDK");
      TLogger.ww("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
      throw new Exception();
    }
  }
  
  public void b()
  {
    try
    {
      Class localClass1 = Class.forName("com.huawei.android.hms.agent.HMSAgent$Push");
      Class localClass2 = Class.forName("com.huawei.android.hms.agent.push.handler.GetTokenHandler");
      Object localObject = new a();
      localObject = Proxy.newProxyInstance(localClass1.getClassLoader(), new Class[] { localClass2 }, (InvocationHandler)localObject);
      localClass1.getDeclaredMethod("getToken", new Class[] { localClass2 }).invoke(localClass1, new Object[] { localObject });
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("OtherPushHuaWeiImpl", "getTokenAsyn error", localThrowable);
      SharePrefsUtil.setString(this.a, "other_push_error_code", new StringBuilder().append("errCode : -127 , errMsg :").append(localThrowable.getLocalizedMessage()).toString());
    }
  }
  
  public void b(Context paramContext)
  {
    if (i.b(this.c)) {}
    do
    {
      return;
      if (this.d == null) {
        this.d = new StringBuffer();
      }
      TLogger.i("OtherPushHuaWeiImpl", "other push huawei unregisterPush");
      if (this.e == 0) {
        this.e = c();
      }
      try
      {
        if (this.e == 3)
        {
          paramContext = this.f.getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(this.f, new Object[] { this.a });
          this.f.getDeclaredMethod("deleteToken", new Class[] { String.class, String.class }).invoke(paramContext, new Object[] { "100167977", "HCM" });
          return;
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.e("OtherPushHuaWeiImpl", "unregisterPush error", paramContext);
        SharePrefsUtil.setString(this.a, "other_push_error_code", new StringBuilder().append("errCode : -128 , errMsg :").append(paramContext.getLocalizedMessage()).toString());
        return;
      }
      if (this.e == 2)
      {
        paramContext = Class.forName("com.huawei.android.hms.agent.HMSAgent$Push");
        Class localClass = Class.forName("com.huawei.android.hms.agent.push.handler.DeleteTokenHandler");
        Object localObject = new a();
        localObject = Proxy.newProxyInstance(paramContext.getClassLoader(), new Class[] { localClass }, (InvocationHandler)localObject);
        paramContext.getDeclaredMethod("deleteToken", new Class[] { String.class, localClass }).invoke(paramContext, new Object[] { this.c, localObject });
        return;
      }
    } while (this.e != -1);
    TLogger.w("OtherPushHuaWeiImpl", "Missing HWPush Service SDK");
    SharePrefsUtil.setString(this.a, "other_push_error_code", "errCode : -122 , errMsg : Missing HWPush Service SDK");
    throw new Exception();
  }
  
  public String c(Context paramContext)
  {
    if (i.b(this.c)) {
      this.c = SharePrefsUtil.getString(paramContext, "huawei_token", "");
    }
    return this.c;
  }
  
  public boolean d(Context paramContext)
  {
    return true;
  }
  
  public int e(Context paramContext)
  {
    return 5;
  }
  
  public String f(Context paramContext)
  {
    String str = "";
    if (this.e == 0) {
      this.e = c();
    }
    Object localObject = str;
    if (this.e == 3)
    {
      localObject = str;
      try
      {
        if (!TextUtils.isEmpty(d.h))
        {
          localObject = str;
          return d.h;
        }
        localObject = str;
        Class localClass = Class.forName("com.huawei.agconnect.config.AGConnectServicesConfig");
        localObject = str;
        paramContext = localClass.getDeclaredMethod("fromContext", new Class[] { Context.class }).invoke(localClass, new Object[] { paramContext });
        localObject = str;
        if (paramContext != null)
        {
          localObject = str;
          paramContext = localClass.getDeclaredMethod("getString", new Class[] { String.class }).invoke(paramContext, new Object[] { "client/app_id" });
          localObject = str;
          if (paramContext != null)
          {
            localObject = str;
            paramContext = paramContext.toString();
            localObject = paramContext;
            d.h = paramContext;
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TLogger.ww("OtherPushHuaWeiImpl", "Not found AGConnectServicesConfig");
      }
    }
    return localObject;
  }
  
  public class a
    implements InvocationHandler
  {
    public a() {}
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (paramMethod == null) {}
      for (;;)
      {
        return null;
        TLogger.d("OtherPushHuaWeiImpl", "invoke, method:" + paramMethod);
        int i;
        try
        {
          if (!paramMethod.getName().equals("onConnect")) {
            break label261;
          }
          if (paramArrayOfObject == null) {
            continue;
          }
          i = paramArrayOfObject.length;
          if (i <= 0) {
            continue;
          }
          try
          {
            paramObject = (Integer)paramArrayOfObject[0];
            TLogger.i("OtherPushHuaWeiImpl", "other push huawei onConnect code:" + paramObject);
            if (paramObject.intValue() == 0)
            {
              b.this.b();
              return null;
            }
          }
          catch (Throwable paramObject)
          {
            SharePrefsUtil.setString(b.this.a, "other_push_error_code", new StringBuilder().append("errCode : -124 , errMsg :").append(paramObject.getLocalizedMessage()).toString());
            return null;
          }
          SharePrefsUtil.setString(b.this.a, "other_push_error_code", new StringBuilder().append("errCode : ").append(paramObject).append(" ,  errMsg : unkonwn").toString());
        }
        catch (Throwable paramObject)
        {
          TLogger.e("OtherPushHuaWeiImpl", "onConnectionFailed", paramObject);
          SharePrefsUtil.setString(b.this.a, "other_push_error_code", new StringBuilder().append("errCode : -126 , errMsg :").append(paramObject.getLocalizedMessage()).toString());
          return null;
        }
        return null;
        label261:
        if ((paramMethod.getName().equals("onResult")) && (paramArrayOfObject != null))
        {
          i = paramArrayOfObject.length;
          if (i > 0) {
            try
            {
              paramObject = (Integer)paramArrayOfObject[0];
              TLogger.i("OtherPushHuaWeiImpl", "other push huawei onResult code:" + paramObject);
              i = paramObject.intValue();
              if (i == 0) {
                return null;
              }
            }
            catch (Throwable paramObject)
            {
              SharePrefsUtil.setString(b.this.a, "other_push_error_code", new StringBuilder().append("errCode : -125 , errMsg :").append(paramObject.getLocalizedMessage()).toString());
            }
          }
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a.b
 * JD-Core Version:    0.7.0.1
 */