package com.tencent.android.tpush.d.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.d.c;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class e
  extends c
{
  StringBuffer a;
  private String b;
  private Object c = null;
  private Object d = null;
  private boolean e = false;
  private int f = 0;
  private Class<?> g = null;
  private Class<?> h = null;
  
  private int b()
  {
    try
    {
      i = d();
      return i;
    }
    catch (Throwable localThrowable1)
    {
      int i;
      TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_heytapOS202");
      try
      {
        i = e();
        return i;
      }
      catch (Throwable localThrowable2)
      {
        TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_heytapOS210");
        try
        {
          i = c();
          return i;
        }
        catch (Throwable localThrowable3)
        {
          TLogger.ww("OtherPushOppoImpl", "unexpected for checkOppoSdkVersion_colorOS");
          this.g = null;
          this.h = null;
          TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: -1");
        }
      }
    }
    return -1;
  }
  
  private int c()
  {
    this.g = Class.forName("com.coloros.mcssdk.PushManager");
    this.h = Class.forName("com.coloros.mcssdk.callback.PushCallback");
    TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: 1");
    return 1;
  }
  
  private int d()
  {
    this.g = Class.forName("com.heytap.mcssdk.PushManager");
    this.h = Class.forName("com.heytap.mcssdk.callback.PushCallback");
    TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: 2");
    return 2;
  }
  
  private int e()
  {
    this.g = Class.forName("com.heytap.msp.push.HeytapPushManager");
    this.h = Class.forName("com.heytap.msp.push.callback.ICallBackResultService");
    TLogger.i("OtherPushOppoImpl", "Get oppo sdk version: 210");
    return 210;
  }
  
  /* Error */
  private Object f(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/android/tpush/d/a/e:f	I
    //   4: ifne +11 -> 15
    //   7: aload_0
    //   8: aload_0
    //   9: invokespecial 99	com/tencent/android/tpush/d/a/e:b	()I
    //   12: putfield 33	com/tencent/android/tpush/d/a/e:f	I
    //   15: aload_0
    //   16: getfield 33	com/tencent/android/tpush/d/a/e:f	I
    //   19: iconst_m1
    //   20: if_icmpne +12 -> 32
    //   23: ldc 49
    //   25: ldc 101
    //   27: invokestatic 57	com/tencent/android/tpush/logging/TLogger:ww	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aconst_null
    //   31: areturn
    //   32: aload_0
    //   33: getfield 29	com/tencent/android/tpush/d/a/e:d	Ljava/lang/Object;
    //   36: ifnonnull +221 -> 257
    //   39: aload_0
    //   40: getfield 33	com/tencent/android/tpush/d/a/e:f	I
    //   43: sipush 210
    //   46: if_icmpne +104 -> 150
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 35	com/tencent/android/tpush/d/a/e:g	Ljava/lang/Class;
    //   54: iconst_0
    //   55: anewarray 74	java/lang/Class
    //   58: invokevirtual 105	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   61: iconst_0
    //   62: anewarray 107	java/lang/Object
    //   65: invokevirtual 113	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   68: putfield 29	com/tencent/android/tpush/d/a/e:d	Ljava/lang/Object;
    //   71: aload_0
    //   72: getfield 35	com/tencent/android/tpush/d/a/e:g	Ljava/lang/Class;
    //   75: ldc 115
    //   77: iconst_2
    //   78: anewarray 74	java/lang/Class
    //   81: dup
    //   82: iconst_0
    //   83: ldc 117
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: getstatic 122	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   91: aastore
    //   92: invokevirtual 126	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   95: aload_0
    //   96: getfield 35	com/tencent/android/tpush/d/a/e:g	Ljava/lang/Class;
    //   99: iconst_2
    //   100: anewarray 107	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: aload_1
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: iconst_1
    //   110: invokestatic 130	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: invokevirtual 136	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: ldc 49
    //   120: new 138	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   127: ldc 141
    //   129: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: getfield 29	com/tencent/android/tpush/d/a/e:d	Ljava/lang/Object;
    //   136: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 70	com/tencent/android/tpush/logging/TLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 29	com/tencent/android/tpush/d/a/e:d	Ljava/lang/Object;
    //   149: areturn
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 35	com/tencent/android/tpush/d/a/e:g	Ljava/lang/Class;
    //   155: ldc 154
    //   157: iconst_0
    //   158: anewarray 74	java/lang/Class
    //   161: invokevirtual 126	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   164: aload_0
    //   165: getfield 35	com/tencent/android/tpush/d/a/e:g	Ljava/lang/Class;
    //   168: iconst_0
    //   169: anewarray 107	java/lang/Object
    //   172: invokevirtual 136	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   175: putfield 29	com/tencent/android/tpush/d/a/e:d	Ljava/lang/Object;
    //   178: goto -60 -> 118
    //   181: astore_2
    //   182: aload_2
    //   183: invokevirtual 158	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   186: astore_3
    //   187: ldc 49
    //   189: new 138	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   196: ldc 160
    //   198: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_3
    //   202: invokevirtual 163	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   205: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 166	com/tencent/android/tpush/logging/TLogger:ee	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_1
    //   215: ldc 168
    //   217: aload_0
    //   218: getfield 170	com/tencent/android/tpush/d/a/e:a	Ljava/lang/StringBuffer;
    //   221: new 138	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   228: ldc 172
    //   230: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_2
    //   234: invokevirtual 175	java/lang/reflect/InvocationTargetException:getLocalizedMessage	()Ljava/lang/String;
    //   237: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokevirtual 180	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   246: invokevirtual 181	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   249: invokestatic 187	com/tencent/android/tpush/service/util/SharePrefsUtil:setString	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: aconst_null
    //   254: putfield 29	com/tencent/android/tpush/d/a/e:d	Ljava/lang/Object;
    //   257: aload_0
    //   258: getfield 29	com/tencent/android/tpush/d/a/e:d	Ljava/lang/Object;
    //   261: areturn
    //   262: astore_1
    //   263: ldc 49
    //   265: ldc 189
    //   267: aload_1
    //   268: invokestatic 192	com/tencent/android/tpush/logging/TLogger:ee	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto -19 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	e
    //   0	274	1	paramContext	Context
    //   181	53	2	localInvocationTargetException	InvocationTargetException
    //   186	16	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   39	118	181	java/lang/reflect/InvocationTargetException
    //   118	150	181	java/lang/reflect/InvocationTargetException
    //   150	178	181	java/lang/reflect/InvocationTargetException
    //   39	118	262	java/lang/Throwable
    //   118	150	262	java/lang/Throwable
    //   150	178	262	java/lang/Throwable
  }
  
  public String a()
  {
    return "oppo";
  }
  
  public void a(Context paramContext)
  {
    this.a = new StringBuffer();
    if ((!this.e) && (Build.VERSION.SDK_INT >= 26)) {}
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      localObject2 = new NotificationChannel("default_message", "默认通知", 4);
      if (localNotificationManager != null)
      {
        localNotificationManager.createNotificationChannel((NotificationChannel)localObject2);
        this.e = true;
        TLogger.ii("OtherPushOppoImpl", "create oppo push channle success");
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        Object localObject2;
        TLogger.ee("OtherPushOppoImpl", "create oppo push channle error: ", localThrowable1);
        SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -150 , errMsg : ").append(localThrowable1.getLocalizedMessage()).toString());
        continue;
        if (!i.b(d.f)) {
          break label154;
        }
        TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null AppSecret");
        return;
        label154:
        Object localObject1 = f(paramContext);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          TLogger.ii("OtherPushOppoImpl", "begin oppo register!" + d.e + " " + d.f);
          if (this.c != null) {
            break label244;
          }
          localObject2 = new a(paramContext);
          this.c = Proxy.newProxyInstance(this.h.getClassLoader(), new Class[] { this.h }, (InvocationHandler)localObject2);
          label244:
          localObject2 = this.h;
          this.g.getDeclaredMethod("register", new Class[] { Context.class, String.class, String.class, localObject2 }).invoke(localObject1, new Object[] { paramContext, d.e, d.f, this.c });
          TLogger.ii("OtherPushOppoImpl", "registerPush oppo push channel success");
          if ((this.f < 2) || (!d.g.booleanValue())) {
            continue;
          }
          this.g.getDeclaredMethod("requestNotificationPermission", new Class[0]).invoke(localObject1, new Object[0]);
          return;
        }
        catch (Throwable localThrowable2)
        {
          TLogger.ee("OtherPushOppoImpl", "registerPush Throwable e: " + localThrowable2.getMessage());
          SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -151 , errMsg : ").append(localThrowable2.getLocalizedMessage()).toString());
        }
      }
    }
    if (i.b(d.e))
    {
      TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null AppKey");
      return;
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
      this.g.getDeclaredMethod("unRegister", new Class[0]).invoke(localObject, new Object[0]);
      TLogger.ii("OtherPushOppoImpl", "unregisterPush oppo push channel success");
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.ee("OtherPushOppoImpl", "unregisterPush Throwable e: " + localThrowable.getMessage());
      SharePrefsUtil.setString(paramContext, "other_push_error_code", new StringBuilder().append("errCode : -152 , errMsg : ").append(localThrowable.getLocalizedMessage()).toString());
    }
  }
  
  public String c(Context paramContext)
  {
    if (i.b(this.b)) {
      this.b = SharePrefsUtil.getString(paramContext, "oppo_token", "");
    }
    return this.b;
  }
  
  public boolean d(Context paramContext)
  {
    if ((i.b(d.e)) || (i.b(d.f))) {
      i.a(paramContext, 6);
    }
    boolean bool2;
    if (i.b(d.e))
    {
      TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null appid");
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      if (i.b(d.f))
      {
        TLogger.ee("OtherPushOppoImpl", "registerPush Error for oppo null miAppkey");
        return false;
      }
      Object localObject = f(paramContext);
      if (localObject != null) {}
      try
      {
        if (this.f == 210)
        {
          bool1 = ((Boolean)this.g.getDeclaredMethod("isSupportPush", new Class[0]).invoke(localObject, new Object[0])).booleanValue();
          bool2 = bool1;
          if (bool1) {
            continue;
          }
          TLogger.ee("OtherPushOppoImpl", "OPPO push api isSupportPush() returns false, the device not support for OPPO push!");
          return bool1;
        }
      }
      catch (InvocationTargetException paramContext)
      {
        for (;;)
        {
          paramContext = paramContext.getCause();
          TLogger.ee("OtherPushOppoImpl", "isConfig Error for InvocationTargetException: " + paramContext.getMessage());
          return false;
          boolean bool1 = ((Boolean)this.g.getDeclaredMethod("isSupportPush", new Class[] { Context.class }).invoke(localObject, new Object[] { paramContext })).booleanValue();
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TLogger.ee("OtherPushOppoImpl", "isConfig Error ", paramContext);
        }
      }
    }
  }
  
  public int e(Context paramContext)
  {
    return 6;
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
            do
            {
              do
              {
                return paramObject;
                if (!paramMethod.getName().equals("onRegister")) {
                  break;
                }
                paramObject = paramMethod;
              } while (paramArrayOfObject == null);
              paramObject = paramMethod;
            } while (paramArrayOfObject.length < 2);
            i = ((Integer)paramArrayOfObject[0]).intValue();
            paramObject = (String)paramArrayOfObject[1];
            if (i == 0)
            {
              TLogger.ii("OtherPushOppoImpl", "OppoPush Register success, registerId:" + paramObject);
              if ((!i.b(paramObject)) && (!paramObject.equals(e.this.c(this.b))))
              {
                e.a(e.this, paramObject);
                SharePrefsUtil.setString(this.b, "oppo_token", e.a(e.this));
              }
              paramArrayOfObject = "errCode : " + i + " , errMsg : success";
              d.a(this.b, "OtherPushOppoImpl", paramArrayOfObject);
            }
            for (;;)
            {
              try
              {
                paramArrayOfObject = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                paramArrayOfObject.putExtra("TPUSH.ERRORCODE", i);
                paramArrayOfObject.putExtra("other_push_token", paramObject);
                paramArrayOfObject.putExtra("TPUSH.FEEDBACK", 1);
                paramArrayOfObject.putExtra("PUSH.CHANNEL", 105);
                paramArrayOfObject.setPackage(this.b.getPackageName());
                BroadcastAgent.sendBroadcast(this.b, paramArrayOfObject);
                return paramMethod;
              }
              catch (Throwable paramObject)
              {
                TLogger.w("OtherPushOppoImpl", "OppoPush Register callback broadcast error: " + paramObject.getMessage());
                return paramMethod;
              }
              TLogger.ww("OtherPushOppoImpl", "OppoPush Register failed, code=" + i + ", msg=" + paramObject);
              SharePrefsUtil.setString(this.b, "other_push_error_code", new StringBuilder().append("errCode : ").append(i).append(" , errMsg : unknown").toString());
            }
            paramObject = paramMethod;
          } while (!paramMethod.getName().equals("onUnRegister"));
          paramObject = paramMethod;
        } while (paramArrayOfObject == null);
        paramObject = paramMethod;
      } while (paramArrayOfObject.length < 1);
      int i = ((Integer)paramArrayOfObject[0]).intValue();
      if (i == 0)
      {
        TLogger.ii("OtherPushOppoImpl", "OppoPush UnRegister success");
        return paramMethod;
      }
      TLogger.ww("OtherPushOppoImpl", "OppoPush UnRegister failed, code=" + i);
      SharePrefsUtil.setString(this.b, "other_push_error_code", new StringBuilder().append("errCode : ").append(i).append(" , errMsg : unknown").toString());
      return paramMethod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.a.e
 * JD-Core Version:    0.7.0.1
 */