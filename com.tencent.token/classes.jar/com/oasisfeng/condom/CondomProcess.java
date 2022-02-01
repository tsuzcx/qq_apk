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
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
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
          paramApplication = new StringBuilder();
          paramApplication.append("Process name \"");
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
    Object localObject = paramString;
    if (paramString.length() > 0)
    {
      localObject = paramString;
      if (paramString.charAt(0) == ':')
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.getPackageName());
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  @Nullable
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
      Log.e(TAG, "Error querying the name of current process.");
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
    paramString = new StringBuilder();
    paramString.append("Condom:");
    paramString.append(str);
    FULL_TAG = paramString.toString();
    TAG = CondomCore.asLogTag(FULL_TAG);
    paramApplication = new CondomCore(paramApplication, paramCondomOptions, TAG);
    try
    {
      installCondomProcessActivityManager(paramApplication);
      installCondomProcessPackageManager(paramApplication);
      Log.d(TAG, "Global condom is installed in current process");
      return;
    }
    catch (Exception paramString)
    {
      paramApplication.logConcern("Incompatibility", paramString.getMessage());
      Log.e(TAG, "Error installing global condom in current process", paramString);
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
      label25:
      Object localObject2;
      Object localObject3;
      Class localClass;
      Object localObject4;
      break label25;
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
            Log.w(TAG, "CondomActivityManager was already installed in this process.");
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
        Log.w(TAG, "CondomPackageManager was already installed in this process.");
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
      public void run()
      {
        CondomProcess.doValidateProcessNames(this.a, paramArrayOfString);
      }
    });
    paramApplication.setPriority(1);
    paramApplication.start();
  }
  
  @VisibleForTesting
  static class a
    extends CondomProcess.c
  {
    private CondomCore a;
    
    a(CondomCore paramCondomCore, Object paramObject)
    {
      super("IActivityManager.", paramCondomCore.DEBUG);
      this.a = paramCondomCore;
    }
    
    private Object a(final Object paramObject, final Method paramMethod, final Object[] paramArrayOfObject)
    {
      Object localObject = paramMethod.getName();
      int i = ((String)localObject).hashCode();
      if (i != 972810068)
      {
        if (i != 1155315389)
        {
          if (i != 1418030008)
          {
            if ((i == 1849706483) && (((String)localObject).equals("startService")))
            {
              i = 2;
              break label111;
            }
          }
          else if (((String)localObject).equals("bindService"))
          {
            i = 1;
            break label111;
          }
        }
        else if (((String)localObject).equals("broadcastIntent"))
        {
          i = 0;
          break label111;
        }
      }
      else if (((String)localObject).equals("getContentProvider"))
      {
        i = 3;
        break label111;
      }
      i = -1;
      switch (i)
      {
      default: 
        break;
      case 3: 
        localObject = (String)paramArrayOfObject[1];
        CondomCore localCondomCore = this.a;
        if (!localCondomCore.shouldAllowProvider(localCondomCore.mBase, (String)localObject, 131072)) {
          return null;
        }
        break;
      case 2: 
        localObject = (Intent)paramArrayOfObject[1];
        paramObject = (ComponentName)this.a.proceed(OutboundType.START_SERVICE, (Intent)localObject, null, new CondomCore.g()
        {
          public ComponentName a()
          {
            return (ComponentName)CondomProcess.a.c(CondomProcess.a.this, paramObject, paramMethod, paramArrayOfObject);
          }
        });
        if (paramObject != null) {
          this.a.logIfOutboundPass(CondomProcess.FULL_TAG, (Intent)localObject, paramObject.getPackageName(), CondomCore.CondomEvent.START_PASS);
        }
        return paramObject;
      case 1: 
        localObject = (Intent)paramArrayOfObject[2];
        i = ((Integer)this.a.proceed(OutboundType.BIND_SERVICE, (Intent)localObject, Integer.valueOf(0), new CondomCore.g()
        {
          public Integer a()
          {
            return (Integer)CondomProcess.a.b(CondomProcess.a.this, paramObject, paramMethod, paramArrayOfObject);
          }
        })).intValue();
        if (i > 0) {
          this.a.logIfOutboundPass(CondomProcess.FULL_TAG, (Intent)localObject, CondomCore.getTargetPackage((Intent)localObject), CondomCore.CondomEvent.BIND_PASS);
        }
        return Integer.valueOf(i);
      case 0: 
        label111:
        i = ((Integer)this.a.proceed(OutboundType.BROADCAST, (Intent)paramArrayOfObject[1], Integer.valueOf(-2147483648), new CondomCore.g()
        {
          public Integer a()
          {
            return (Integer)CondomProcess.a.a(CondomProcess.a.this, paramObject, paramMethod, paramArrayOfObject);
          }
        })).intValue();
        paramMethod = paramArrayOfObject[3];
        if (i != -2147483648) {
          return Integer.valueOf(i);
        }
        if (paramMethod == null) {
          return Integer.valueOf(0);
        }
        localObject = paramMethod.getClass();
        if (Build.VERSION.SDK_INT >= 17)
        {
          paramObject = new Class[7];
          paramObject[0] = Intent.class;
          paramObject[1] = Integer.TYPE;
          paramObject[2] = String.class;
          paramObject[3] = Bundle.class;
          paramObject[4] = Boolean.TYPE;
          paramObject[5] = Boolean.TYPE;
          paramObject[6] = Integer.TYPE;
        }
        else
        {
          paramObject = new Class[6];
          paramObject[0] = Intent.class;
          paramObject[1] = Integer.TYPE;
          paramObject[2] = String.class;
          paramObject[3] = Bundle.class;
          paramObject[4] = Boolean.TYPE;
          paramObject[5] = Boolean.TYPE;
        }
        localObject = ((Class)localObject).getMethod("performReceive", paramObject);
        if (Build.VERSION.SDK_INT >= 17)
        {
          paramObject = new Object[7];
          paramObject[0] = paramArrayOfObject[1];
          paramObject[1] = paramArrayOfObject[4];
          paramObject[2] = paramArrayOfObject[5];
          paramObject[3] = paramArrayOfObject[6];
          paramObject[4] = paramArrayOfObject[(paramArrayOfObject.length - 3)];
          paramObject[5] = paramArrayOfObject[(paramArrayOfObject.length - 2)];
          paramObject[6] = paramArrayOfObject[(paramArrayOfObject.length - 1)];
        }
        else
        {
          paramObject = new Object[6];
          paramObject[0] = paramArrayOfObject[1];
          paramObject[1] = paramArrayOfObject[4];
          paramObject[2] = paramArrayOfObject[5];
          paramObject[3] = paramArrayOfObject[6];
          paramObject[4] = paramArrayOfObject[8];
          paramObject[5] = paramArrayOfObject[9];
        }
        ((Method)localObject).invoke(paramMethod, paramObject);
        return Integer.valueOf(0);
      }
      return super.invoke(paramObject, paramMethod, paramArrayOfObject);
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      try
      {
        Object localObject = a(paramObject, paramMethod, paramArrayOfObject);
        return localObject;
      }
      catch (Exception localException)
      {
        if (this.c)
        {
          String str = CondomProcess.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Error proceeding ");
          localStringBuilder.append(paramMethod);
          Log.e(str, localStringBuilder.toString(), localException);
        }
      }
      return super.invoke(paramObject, paramMethod, paramArrayOfObject);
    }
  }
  
  @VisibleForTesting
  static class b
    extends CondomProcess.c
  {
    final Intent a = new Intent();
    @VisibleForTesting
    CondomCore b;
    private Method d;
    private Method e;
    
    b(CondomCore paramCondomCore, Object paramObject)
    {
      super("IPackageManager.", paramCondomCore.DEBUG);
      this.b = paramCondomCore;
    }
    
    private Object a(final Object paramObject, final Method paramMethod, final Object[] paramArrayOfObject)
    {
      Object localObject1 = paramMethod.getName();
      switch (((String)localObject1).hashCode())
      {
      default: 
        break;
      case 1786110784: 
        if (((String)localObject1).equals("queryIntentReceivers")) {
          i = 1;
        }
        break;
      case 1600494599: 
        if (((String)localObject1).equals("getInstalledApplications")) {
          i = 4;
        }
        break;
      case 1326102014: 
        if (((String)localObject1).equals("resolveContentProvider")) {
          i = 3;
        }
        break;
      case -109758974: 
        if (((String)localObject1).equals("queryIntentServices")) {
          i = 0;
        }
        break;
      case -150905391: 
        if (((String)localObject1).equals("getInstalledPackages")) {
          i = 5;
        }
        break;
      case -297395415: 
        if (((String)localObject1).equals("resolveService")) {
          i = 2;
        }
        break;
      }
      final int i = -1;
      switch (i)
      {
      default: 
        break;
      case 4: 
      case 5: 
        localObject2 = this.b;
        localObject3 = CondomProcess.FULL_TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("IPackageManager.");
        localStringBuilder.append((String)localObject1);
        ((CondomCore)localObject2).logConcern((String)localObject3, localStringBuilder.toString());
        break;
      case 3: 
        paramObject = (ProviderInfo)super.invoke(paramObject, paramMethod, paramArrayOfObject);
        if ((((Integer)paramArrayOfObject[1]).intValue() & 0x20000) != 0) {
          return paramObject;
        }
        if (this.b.shouldAllowProvider(paramObject)) {
          return paramObject;
        }
        return null;
      case 2: 
        localObject1 = (Intent)paramArrayOfObject[0];
        i = ((Intent)localObject1).getFlags();
        this.b.proceed(OutboundType.QUERY_SERVICES, (Intent)localObject1, null, new CondomCore.g()
        {
          public ResolveInfo a()
          {
            if ((!CondomProcess.b.this.b.mExcludeBackgroundServices) && (CondomProcess.b.this.b.mOutboundJudge == null)) {
              return (ResolveInfo)CondomProcess.b.a(CondomProcess.b.this, paramObject, paramMethod, paramArrayOfObject);
            }
            if (CondomProcess.b.a(CondomProcess.b.this) == null)
            {
              CondomProcess.b.this.b.mBase.getPackageManager().queryIntentServices(CondomProcess.b.this.a, 0);
              if (CondomProcess.b.a(CondomProcess.b.this) == null) {
                throw new IllegalStateException("Failed to capture IPackageManager.queryIntentServices()");
              }
            }
            Object localObject = CondomProcess.b.this;
            localObject = CondomProcess.b.a((CondomProcess.b)localObject, CondomProcess.b.b((CondomProcess.b)localObject, paramObject, CondomProcess.b.a((CondomProcess.b)localObject), paramArrayOfObject));
            return CondomProcess.b.this.b.filterCandidates(OutboundType.QUERY_SERVICES, this.d.setFlags(i), (List)localObject, CondomProcess.FULL_TAG, false);
          }
        });
      case 1: 
        localObject1 = null;
        break;
      case 0: 
        localObject1 = OutboundType.QUERY_SERVICES;
        if (this.d == null) {
          this.d = paramMethod;
        }
        if (paramArrayOfObject[0] == this.a) {
          return null;
        }
        break;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = OutboundType.QUERY_RECEIVERS;
      }
      paramMethod = super.invoke(paramObject, paramMethod, paramArrayOfObject);
      localObject1 = this.b;
      paramArrayOfObject = (Intent)paramArrayOfObject[0];
      Object localObject3 = new CondomCore.g()
      {
        public List<ResolveInfo> a()
        {
          return CondomProcess.b.a(CondomProcess.b.this, paramMethod);
        }
      };
      if (localObject2 == OutboundType.QUERY_SERVICES) {
        paramObject = CondomCore.SERVICE_PACKAGE_GETTER;
      } else {
        paramObject = CondomCore.RECEIVER_PACKAGE_GETTER;
      }
      if (((CondomCore)localObject1).proceedQuery((OutboundType)localObject2, paramArrayOfObject, (CondomCore.g)localObject3, paramObject).isEmpty()) {
        a(paramMethod).clear();
      }
      return paramMethod;
      return super.invoke(paramObject, paramMethod, paramArrayOfObject);
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
      paramObject = new StringBuilder();
      paramObject.append("Neither List nor ParceledListSlice: ");
      paramObject.append(localClass);
      throw new IllegalArgumentException(paramObject.toString());
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      try
      {
        Object localObject = a(paramObject, paramMethod, paramArrayOfObject);
        return localObject;
      }
      catch (Exception localException)
      {
        if (this.c)
        {
          String str = CondomProcess.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Error proceeding ");
          localStringBuilder.append(paramMethod);
          Log.e(str, localStringBuilder.toString(), localException);
        }
      }
      return super.invoke(paramObject, paramMethod, paramArrayOfObject);
    }
  }
  
  private static class c
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
        String str = CondomProcess.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(paramMethod.getName());
        if (paramArrayOfObject == null) {
          paramObject = "";
        } else {
          paramObject = Arrays.deepToString(paramArrayOfObject);
        }
        localStringBuilder.append(paramObject);
        Log.d(str, localStringBuilder.toString());
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