package com.oasisfeng.condom;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Keep
public class CondomProcess
{
  static String FULL_TAG = "CondomProcess";
  static String TAG = "CondomProcess";
  private static final String TAG_INCOMPATIBILITY = "Incompatibility";
  
  private static void doValidateProcessNames(Application paramApplication, String[] paramArrayOfString)
  {
    try
    {
      Object localObject1 = paramApplication.getPackageManager().getPackageInfo(paramApplication.getPackageName(), 15);
      HashSet localHashSet = new HashSet();
      Object localObject2 = ((PackageInfo)localObject1).activities;
      int j = 0;
      if (localObject2 != null)
      {
        localObject2 = ((PackageInfo)localObject1).activities;
        k = localObject2.length;
        i = 0;
        while (i < k)
        {
          localHashSet.add(localObject2[i].processName);
          i += 1;
        }
      }
      if (((PackageInfo)localObject1).services != null)
      {
        localObject2 = ((PackageInfo)localObject1).services;
        k = localObject2.length;
        i = 0;
        while (i < k)
        {
          localHashSet.add(localObject2[i].processName);
          i += 1;
        }
      }
      if (((PackageInfo)localObject1).receivers != null)
      {
        localObject2 = ((PackageInfo)localObject1).receivers;
        k = localObject2.length;
        i = 0;
        while (i < k)
        {
          localHashSet.add(localObject2[i].processName);
          i += 1;
        }
      }
      if (((PackageInfo)localObject1).providers != null)
      {
        localObject1 = ((PackageInfo)localObject1).providers;
        k = localObject1.length;
        i = 0;
        while (i < k)
        {
          localHashSet.add(localObject1[i].processName);
          i += 1;
        }
      }
      int k = paramArrayOfString.length;
      int i = j;
      while (i < k)
      {
        localObject1 = paramArrayOfString[i];
        if (localHashSet.contains(getFullProcessName(paramApplication, (String)localObject1)))
        {
          i += 1;
        }
        else
        {
          paramApplication = new StringBuilder("Process name \"");
          paramApplication.append((String)localObject1);
          paramApplication.append("\" is not used by any component in AndroidManifest.xml");
          throw new IllegalArgumentException(paramApplication.toString());
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramApplication) {}
  }
  
  private static String getFullProcessName(Context paramContext, String paramString)
  {
    if ((paramString.length() > 0) && (paramString.charAt(0) == ':'))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return paramString;
  }
  
  private static String getProcessName(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getRunningAppProcesses();
      int i = Process.myPid();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == i) {
            return localRunningAppProcessInfo.processName;
          }
        }
      }
      return null;
    }
    catch (SecurityException paramContext) {}
    return null;
  }
  
  private static void install(Application paramApplication, String paramString, CondomOptions paramCondomOptions)
  {
    int i = paramString.indexOf(':');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(i + 1);
    }
    paramString = "Condom:".concat(String.valueOf(str));
    FULL_TAG = paramString;
    TAG = CondomCore.asLogTag(paramString);
    paramApplication = new CondomCore(paramApplication, paramCondomOptions, TAG);
    try
    {
      installCondomProcessActivityManager(paramApplication);
      installCondomProcessPackageManager(paramApplication);
      return;
    }
    catch (Exception paramString)
    {
      paramApplication.logConcern("Incompatibility", paramString.getMessage());
    }
  }
  
  @SuppressLint({"PrivateApi"})
  private static void installCondomProcessActivityManager(CondomCore paramCondomCore)
  {
    Object localObject1 = Class.forName("android.app.ActivityManagerNative");
    if (Build.VERSION.SDK_INT <= 25) {}
    try
    {
      localObject1 = ((Class)localObject1).getDeclaredField("gDefault");
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label24:
      Object localObject2;
      Object localObject3;
      Class localClass;
      Object localObject4;
      break label24;
    }
    localObject1 = null;
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ActivityManager.class.getDeclaredField("IActivityManagerSingleton");
    }
    ((Field)localObject2).setAccessible(true);
    localObject1 = Class.forName("android.util.Singleton");
    localObject3 = ((Class)localObject1).getDeclaredMethod("get", new Class[0]);
    ((Method)localObject3).setAccessible(true);
    localObject1 = ((Class)localObject1).getDeclaredField("mInstance");
    ((Field)localObject1).setAccessible(true);
    localClass = Class.forName("android.app.IActivityManager");
    localObject2 = ((Field)localObject2).get(null);
    if (localObject2 != null)
    {
      localObject3 = ((Method)localObject3).invoke(localObject2, new Object[0]);
      if (localObject3 != null)
      {
        if (Proxy.isProxyClass(localObject3.getClass()))
        {
          localObject4 = Proxy.getInvocationHandler(localObject3);
          if ((localObject4 instanceof a))
          {
            a.a((a)localObject4, paramCondomCore);
            return;
          }
        }
        localObject4 = paramCondomCore.mBase.getClassLoader();
        paramCondomCore = new a(paramCondomCore, localObject3);
        ((Field)localObject1).set(localObject2, Proxy.newProxyInstance((ClassLoader)localObject4, new Class[] { localClass }, paramCondomCore));
        return;
      }
      throw new IllegalStateException("ActivityManagerNative.gDefault.get() returns null");
    }
    throw new IllegalStateException("ActivityManagerNative.gDefault is null");
  }
  
  @SuppressLint({"PrivateApi"})
  private static void installCondomProcessPackageManager(CondomCore paramCondomCore)
  {
    Field localField = Class.forName("android.app.ActivityThread").getDeclaredField("sPackageManager");
    localField.setAccessible(true);
    Class localClass = Class.forName("android.content.pm.IPackageManager");
    Object localObject1 = localField.get(null);
    if (Proxy.isProxyClass(localObject1.getClass()))
    {
      localObject2 = Proxy.getInvocationHandler(localObject1);
      if ((localObject2 instanceof b))
      {
        ((b)localObject2).b = paramCondomCore;
        return;
      }
    }
    Object localObject2 = paramCondomCore.mBase.getClassLoader();
    paramCondomCore = new b(paramCondomCore, localObject1);
    localField.set(null, Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { localClass }, paramCondomCore));
  }
  
  public static void installExcept(Application paramApplication, CondomOptions paramCondomOptions, String... paramVarArgs)
  {
    if (paramVarArgs.length != 0)
    {
      validateCondomOptions(paramCondomOptions);
      String str = getProcessName(paramApplication);
      if (str == null) {
        return;
      }
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (!str.equals(getFullProcessName(paramApplication, paramVarArgs[i])))
        {
          install(paramApplication, str, paramCondomOptions);
          return;
        }
        i += 1;
      }
      if ((paramApplication.getApplicationInfo().flags & 0x2) != 0) {
        validateProcessNames(paramApplication, paramVarArgs);
      }
      return;
    }
    throw new IllegalArgumentException("At lease one process name must be specified");
  }
  
  public static void installExceptDefaultProcess(Application paramApplication)
  {
    installExceptDefaultProcess(paramApplication, new CondomOptions());
  }
  
  public static void installExceptDefaultProcess(Application paramApplication, CondomOptions paramCondomOptions)
  {
    validateCondomOptions(paramCondomOptions);
    String str = getProcessName(paramApplication);
    if (str == null) {
      return;
    }
    if (!str.equals(paramApplication.getApplicationInfo().processName)) {
      install(paramApplication, str, paramCondomOptions);
    }
  }
  
  public static void installInCurrentProcess(Application paramApplication, String paramString, CondomOptions paramCondomOptions)
  {
    install(paramApplication, paramString, paramCondomOptions);
  }
  
  private static void validateCondomOptions(CondomOptions paramCondomOptions)
  {
    if (paramCondomOptions.mKits != null)
    {
      if (paramCondomOptions.mKits.isEmpty()) {
        return;
      }
      throw new IllegalArgumentException("CondomKit is not yet compatible with CondomProcess. If you really need this, please submit a feature request on GitHub issue tracker, with the use case.");
    }
  }
  
  private static void validateProcessNames(Application paramApplication, final String[] paramArrayOfString)
  {
    paramApplication = new Thread(new Runnable()
    {
      public final void run()
      {
        CondomProcess.doValidateProcessNames(this.a, paramArrayOfString);
      }
    });
    paramApplication.setPriority(1);
    paramApplication.start();
  }
  
  static final class a
    extends CondomProcess.c
  {
    private CondomCore a;
    
    a(CondomCore paramCondomCore, Object paramObject)
    {
      super("IActivityManager.", paramCondomCore.DEBUG);
      this.a = paramCondomCore;
    }
    
    public final Object invoke(final Object paramObject, final Method paramMethod, final Object[] paramArrayOfObject)
    {
      Object localObject2;
      try
      {
        localObject1 = paramMethod.getName();
        i = -1;
        int j = ((String)localObject1).hashCode();
        if (j != 972810068)
        {
          if (j != 1155315389)
          {
            if (j != 1418030008)
            {
              if ((j == 1849706483) && (((String)localObject1).equals("startService"))) {
                i = 2;
              }
            }
            else if (((String)localObject1).equals("bindService")) {
              i = 1;
            }
          }
          else if (((String)localObject1).equals("broadcastIntent")) {
            i = 0;
          }
        }
        else if (((String)localObject1).equals("getContentProvider")) {
          i = 3;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          int i;
          Object localObject3;
          continue;
          switch (i)
          {
          }
        }
      }
      localObject1 = (String)paramArrayOfObject[1];
      if (!this.a.shouldAllowProvider(this.a.mBase, (String)localObject1, 131072))
      {
        return null;
        localObject1 = (Intent)paramArrayOfObject[1];
        localObject2 = (ComponentName)this.a.proceed(OutboundType.START_SERVICE, (Intent)localObject1, null, new CondomCore.g() {});
        if (localObject2 != null)
        {
          this.a.logIfOutboundPass(CondomProcess.FULL_TAG, (Intent)localObject1, ((ComponentName)localObject2).getPackageName(), CondomCore.CondomEvent.START_PASS);
          return localObject2;
          localObject1 = (Intent)paramArrayOfObject[2];
          i = ((Integer)this.a.proceed(OutboundType.BIND_SERVICE, (Intent)localObject1, Integer.valueOf(0), new CondomCore.g() {})).intValue();
          if (i > 0) {
            this.a.logIfOutboundPass(CondomProcess.FULL_TAG, (Intent)localObject1, CondomCore.getTargetPackage((Intent)localObject1), CondomCore.CondomEvent.BIND_PASS);
          }
          return Integer.valueOf(i);
          i = ((Integer)this.a.proceed(OutboundType.BROADCAST, (Intent)paramArrayOfObject[1], Integer.valueOf(-2147483648), new CondomCore.g() {})).intValue();
          localObject2 = paramArrayOfObject[3];
          if (i != -2147483648) {
            return Integer.valueOf(i);
          }
          if (localObject2 == null) {
            return Integer.valueOf(0);
          }
          localObject3 = localObject2.getClass();
          if (Build.VERSION.SDK_INT >= 17)
          {
            localObject1 = new Class[7];
            localObject1[0] = Intent.class;
            localObject1[1] = Integer.TYPE;
            localObject1[2] = String.class;
            localObject1[3] = Bundle.class;
            localObject1[4] = Boolean.TYPE;
            localObject1[5] = Boolean.TYPE;
            localObject1[6] = Integer.TYPE;
          }
          else
          {
            localObject1 = new Class[6];
            localObject1[0] = Intent.class;
            localObject1[1] = Integer.TYPE;
            localObject1[2] = String.class;
            localObject1[3] = Bundle.class;
            localObject1[4] = Boolean.TYPE;
            localObject1[5] = Boolean.TYPE;
          }
          localObject3 = ((Class)localObject3).getMethod("performReceive", (Class[])localObject1);
          if (Build.VERSION.SDK_INT >= 17)
          {
            localObject1 = new Object[7];
            localObject1[0] = paramArrayOfObject[1];
            localObject1[1] = paramArrayOfObject[4];
            localObject1[2] = paramArrayOfObject[5];
            localObject1[3] = paramArrayOfObject[6];
            localObject1[4] = paramArrayOfObject[(paramArrayOfObject.length - 3)];
            localObject1[5] = paramArrayOfObject[(paramArrayOfObject.length - 2)];
            localObject1[6] = paramArrayOfObject[(paramArrayOfObject.length - 1)];
          }
          else
          {
            localObject1 = new Object[6];
            localObject1[0] = paramArrayOfObject[1];
            localObject1[1] = paramArrayOfObject[4];
            localObject1[2] = paramArrayOfObject[5];
            localObject1[3] = paramArrayOfObject[6];
            localObject1[4] = paramArrayOfObject[8];
            localObject1[5] = paramArrayOfObject[9];
          }
          ((Method)localObject3).invoke(localObject2, (Object[])localObject1);
          return Integer.valueOf(0);
        }
      }
      else
      {
        localObject1 = super.invoke(paramObject, paramMethod, paramArrayOfObject);
        return localObject1;
        if (this.c)
        {
          localObject1 = CondomProcess.TAG;
          new StringBuilder("Error proceeding ").append(paramMethod);
        }
        return super.invoke(paramObject, paramMethod, paramArrayOfObject);
      }
      return localObject2;
    }
  }
  
  static final class b
    extends CondomProcess.c
  {
    final Intent a = new Intent();
    CondomCore b;
    private Method d;
    private Method e;
    
    b(CondomCore paramCondomCore, Object paramObject)
    {
      super("IPackageManager.", paramCondomCore.DEBUG);
      this.b = paramCondomCore;
    }
    
    private <T> List<T> a(Object paramObject)
    {
      if ((paramObject instanceof List)) {
        return (List)paramObject;
      }
      Class localClass = paramObject.getClass();
      if ("android.content.pm.ParceledListSlice".equals(localClass.getName()))
      {
        if (this.e == null) {
          this.e = localClass.getMethod("getList", new Class[0]);
        }
        return (List)this.e.invoke(paramObject, new Object[0]);
      }
      throw new IllegalArgumentException("Neither List nor ParceledListSlice: ".concat(String.valueOf(localClass)));
    }
    
    public final Object invoke(final Object paramObject, final Method paramMethod, final Object[] paramArrayOfObject)
    {
      final Object localObject4;
      try
      {
        localObject1 = paramMethod.getName();
        i = -1;
        switch (((String)localObject1).hashCode())
        {
        case 1786110784: 
          if (!((String)localObject1).equals("queryIntentReceivers")) {
            break label465;
          }
          i = 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          final int i;
          continue;
          switch (i)
          {
          }
        }
      }
      if (((String)localObject1).equals("getInstalledApplications"))
      {
        i = 4;
        break label465;
        if (((String)localObject1).equals("resolveContentProvider"))
        {
          i = 3;
          break label465;
          if (((String)localObject1).equals("queryIntentServices"))
          {
            i = 0;
            break label465;
            if (((String)localObject1).equals("getInstalledPackages"))
            {
              i = 5;
              break label465;
              if (((String)localObject1).equals("resolveService"))
              {
                i = 2;
                break label465;
                this.b.logConcern(CondomProcess.FULL_TAG, "IPackageManager.".concat(String.valueOf(localObject1)));
                break label414;
                localObject1 = (ProviderInfo)super.invoke(paramObject, paramMethod, paramArrayOfObject);
                if ((((Integer)paramArrayOfObject[1]).intValue() & 0x20000) != 0) {
                  return localObject1;
                }
                if (!this.b.shouldAllowProvider((ProviderInfo)localObject1)) {
                  break label507;
                }
                return localObject1;
                localObject1 = (Intent)paramArrayOfObject[0];
                i = ((Intent)localObject1).getFlags();
                this.b.proceed(OutboundType.QUERY_SERVICES, (Intent)localObject1, null, new CondomCore.g() {});
                localObject1 = OutboundType.QUERY_SERVICES;
                if (this.d == null) {
                  this.d = paramMethod;
                }
                if (paramArrayOfObject[0] == this.a) {
                  return null;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = OutboundType.QUERY_RECEIVERS;
        }
        localObject4 = super.invoke(paramObject, paramMethod, paramArrayOfObject);
        CondomCore localCondomCore = this.b;
        Intent localIntent = (Intent)paramArrayOfObject[0];
        CondomCore.g local1 = new CondomCore.g() {};
        if (localObject3 == OutboundType.QUERY_SERVICES) {
          localObject1 = CondomCore.SERVICE_PACKAGE_GETTER;
        } else {
          localObject1 = CondomCore.RECEIVER_PACKAGE_GETTER;
        }
        if (!localCondomCore.proceedQuery((OutboundType)localObject3, localIntent, local1, (CondomCore.c)localObject1).isEmpty()) {
          break;
        }
        a(localObject4).clear();
        return localObject4;
        label414:
        localObject1 = super.invoke(paramObject, paramMethod, paramArrayOfObject);
        return localObject1;
        if (this.c)
        {
          localObject1 = CondomProcess.TAG;
          new StringBuilder("Error proceeding ").append(paramMethod);
        }
        return super.invoke(paramObject, paramMethod, paramArrayOfObject);
        label465:
        label507:
        return null;
        Object localObject2 = null;
      }
      return localObject4;
    }
  }
  
  static class c
    implements InvocationHandler
  {
    private final Object a;
    private final String b;
    final boolean c;
    
    c(Object paramObject, String paramString, boolean paramBoolean)
    {
      this.a = paramObject;
      this.b = paramString;
      this.c = paramBoolean;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (this.c)
      {
        paramObject = CondomProcess.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(paramMethod.getName());
        if (paramArrayOfObject == null) {
          paramObject = "";
        } else {
          paramObject = Arrays.deepToString(paramArrayOfObject);
        }
        localStringBuilder.append(paramObject);
      }
      try
      {
        paramObject = paramMethod.invoke(this.a, paramArrayOfObject);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        throw paramObject.getTargetException();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.CondomProcess
 * JD-Core Version:    0.7.0.1
 */