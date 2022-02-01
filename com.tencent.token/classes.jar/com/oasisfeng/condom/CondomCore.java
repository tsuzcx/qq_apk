package com.oasisfeng.condom;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Process;
import android.support.annotation.Keep;
import android.util.EventLog;
import com.oasisfeng.condom.util.Lazy;
import com.tencent.token.ajv;
import com.tencent.token.la;
import com.tencent.token.la.a;
import com.tencent.token.la.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.content.pm.ResolveInfo;>;
import java.util.Map;
import java.util.Set;

@Keep
public class CondomCore
{
  private static final int EVENT_TAG = "Condom".hashCode();
  static final int FLAG_RECEIVER_EXCLUDE_BACKGROUND = 8388608;
  public static final j<ResolveInfo, String> RECEIVER_PACKAGE_GETTER;
  public static final j<ResolveInfo, String> SERVICE_PACKAGE_GETTER = new e();
  final boolean DEBUG;
  final Context mBase;
  private final Lazy<ContentResolver> mContentResolver;
  boolean mDryRun;
  boolean mExcludeBackgroundReceivers;
  public boolean mExcludeBackgroundServices;
  boolean mExcludeStoppedPackages;
  private final i mKitManager;
  public OutboundJudge mOutboundJudge;
  private final Lazy<PackageManager> mPackageManager;
  
  static
  {
    RECEIVER_PACKAGE_GETTER = new f();
  }
  
  CondomCore(final Context paramContext, CondomOptions paramCondomOptions, final String paramString)
  {
    boolean bool2 = true;
    this.mExcludeStoppedPackages = true;
    this.mBase = paramContext;
    boolean bool1;
    if ((paramContext.getApplicationInfo().flags & 0x2) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.DEBUG = bool1;
    this.mExcludeBackgroundReceivers = paramCondomOptions.mExcludeBackgroundReceivers;
    if ((Build.VERSION.SDK_INT < 26) && (paramCondomOptions.mExcludeBackgroundServices)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.mExcludeBackgroundServices = bool1;
    this.mOutboundJudge = paramCondomOptions.mOutboundJudge;
    this.mDryRun = paramCondomOptions.mDryRun;
    paramString = new b(paramContext, paramString);
    this.mPackageManager = new c(paramCondomOptions.mPackageManagerFactory, paramContext, paramString);
    this.mContentResolver = new d(paramContext);
    paramContext = paramCondomOptions.mKits;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = new ArrayList(paramContext);
    }
    if ((paramContext != null) && (!paramContext.isEmpty()))
    {
      this.mKitManager = new i();
      paramContext = paramContext.iterator();
    }
    while (paramContext.hasNext())
    {
      ((la)paramContext.next()).a(this.mKitManager);
      continue;
      this.mKitManager = null;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private int adjustIntentFlags(OutboundType paramOutboundType, Intent paramIntent)
  {
    int j = paramIntent.getFlags();
    if (this.mDryRun) {
      return j;
    }
    if ((this.mExcludeBackgroundReceivers) && ((paramOutboundType == OutboundType.BROADCAST) || (paramOutboundType == OutboundType.QUERY_RECEIVERS)))
    {
      int i;
      if (Build.VERSION.SDK_INT >= 24) {
        i = 8388608;
      } else {
        i = 1073741824;
      }
      paramIntent.addFlags(i);
    }
    if ((Build.VERSION.SDK_INT >= 12) && (this.mExcludeStoppedPackages)) {
      paramIntent.setFlags(paramIntent.getFlags() & 0xFFFFFFDF | 0x10);
    }
    return j;
  }
  
  static String asLogTag(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 23) {
      str = paramString.substring(0, 23);
    }
    return str;
  }
  
  public static String buildLogTag(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString1;
    if (paramString3 != null)
    {
      str = paramString1;
      if (!paramString3.isEmpty())
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append(paramString3);
        str = asLogTag(paramString1.toString());
      }
    }
    return str;
  }
  
  private static String getCaller()
  {
    Object localObject = Thread.currentThread().getStackTrace();
    if (localObject.length <= 5) {
      return "<bottom>";
    }
    localObject = localObject[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((StackTraceElement)localObject).getClassName());
    localStringBuilder.append(".");
    localStringBuilder.append(((StackTraceElement)localObject).getMethodName());
    localStringBuilder.append(":");
    localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
    return localStringBuilder.toString();
  }
  
  public static String getTargetPackage(Intent paramIntent)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if (localComponentName != null) {
      return localComponentName.getPackageName();
    }
    return paramIntent.getPackage();
  }
  
  private void log(String paramString, h paramh, String... paramVarArgs)
  {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 2];
    arrayOfObject[0] = this.mBase.getPackageName();
    arrayOfObject[1] = paramString;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 2, paramVarArgs.length);
    EventLog.writeEvent(EVENT_TAG + paramh.ordinal(), arrayOfObject);
    if (this.DEBUG)
    {
      asLogTag(paramString);
      paramString = new StringBuilder();
      paramString.append(paramh.name());
      paramString.append(" ");
      paramString.append(Arrays.toString(paramVarArgs));
    }
  }
  
  private boolean shouldBlockRequestTarget(OutboundType paramOutboundType, Intent paramIntent, String paramString)
  {
    OutboundJudge localOutboundJudge = this.mOutboundJudge;
    return (localOutboundJudge != null) && (!localOutboundJudge.shouldAllow(paramOutboundType, paramIntent, paramString)) && (!this.mDryRun);
  }
  
  public ResolveInfo filterCandidates(OutboundType paramOutboundType, Intent paramIntent, List<ResolveInfo> paramList, String paramString, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int j = Process.myUid();
      Iterator localIterator = paramList.iterator();
      paramList = null;
      while (localIterator.hasNext())
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localIterator.next();
        ApplicationInfo localApplicationInfo = localResolveInfo.serviceInfo.applicationInfo;
        int i = localApplicationInfo.uid;
        if (i != j)
        {
          localObject1 = this.mOutboundJudge;
          if ((localObject1 == null) || (((OutboundJudge)localObject1).shouldAllow(paramOutboundType, paramIntent, localApplicationInfo.packageName)))
          {
            localObject1 = paramList;
            if (this.mExcludeBackgroundServices)
            {
              localObject1 = paramList;
              if (paramList == null) {
                localObject1 = new g();
              }
              paramList = ((g)localObject1).b;
              Object localObject2;
              if (paramList != null)
              {
                paramList = paramList.iterator();
                do
                {
                  if (!paramList.hasNext()) {
                    break;
                  }
                  localObject2 = (ActivityManager.RunningAppProcessInfo)paramList.next();
                } while ((((ActivityManager.RunningAppProcessInfo)localObject2).pid == 0) || (((ActivityManager.RunningAppProcessInfo)localObject2).importance >= 400) || (((ActivityManager.RunningAppProcessInfo)localObject2).uid != i));
                i = 1;
              }
              else
              {
                paramList = ((g)localObject1).a;
                if (paramList != null)
                {
                  paramList = paramList.iterator();
                  while (paramList.hasNext())
                  {
                    localObject2 = (ActivityManager.RunningServiceInfo)paramList.next();
                    if ((((ActivityManager.RunningServiceInfo)localObject2).pid != 0) && (((ActivityManager.RunningServiceInfo)localObject2).uid == i))
                    {
                      i = 1;
                      break label268;
                    }
                  }
                }
                i = 0;
              }
              label268:
              paramList = (List<ResolveInfo>)localObject1;
              if (i != 0) {}
            }
          }
          else
          {
            localObject1 = null;
            break label295;
          }
        }
        else
        {
          localObject1 = paramList;
        }
        paramList = (List<ResolveInfo>)localObject1;
        Object localObject1 = localResolveInfo;
        label295:
        if (localObject1 == null) {
          log(paramString, h.d, new String[] { localApplicationInfo.packageName, paramIntent.toString() });
        }
        if (this.mDryRun) {
          return localResolveInfo;
        }
        if (paramBoolean)
        {
          if (localObject1 == null) {
            localIterator.remove();
          }
        }
        else if (localObject1 != null) {
          return localObject1;
        }
      }
    }
    return null;
  }
  
  public ContentResolver getContentResolver()
  {
    return (ContentResolver)this.mContentResolver.get();
  }
  
  public PackageManager getPackageManager()
  {
    return (PackageManager)this.mPackageManager.get();
  }
  
  public String getPackageName()
  {
    return this.mBase.getPackageName();
  }
  
  public Set<String> getSpoofPermissions()
  {
    i locali = this.mKitManager;
    if (locali != null) {
      return locali.b;
    }
    return Collections.emptySet();
  }
  
  public Object getSystemService(String paramString)
  {
    i locali = this.mKitManager;
    if (locali != null)
    {
      paramString = (la.b)locali.a.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.a(this.mBase);
        if (paramString != null) {
          return paramString;
        }
      }
    }
    return null;
  }
  
  public void logConcern(String paramString1, String paramString2)
  {
    EventLog.writeEvent(EVENT_TAG + h.a.ordinal(), new Object[] { this.mBase.getPackageName(), paramString1, paramString2, getCaller() });
    if (this.DEBUG)
    {
      asLogTag(paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(" is invoked");
      new Throwable();
    }
  }
  
  public void logIfOutboundPass(String paramString1, Intent paramIntent, String paramString2, h paramh)
  {
    if ((paramString2 != null) && (!this.mBase.getPackageName().equals(paramString2))) {
      log(paramString1, paramh, new String[] { paramString2, paramIntent.toString() });
    }
  }
  
  public <R, T extends Throwable> R proceed(OutboundType paramOutboundType, Intent paramIntent, R paramR, n<R, T> paramn)
  {
    String str;
    if (paramIntent != null) {
      str = getTargetPackage(paramIntent);
    } else {
      str = null;
    }
    if (str != null)
    {
      if (this.mBase.getPackageName().equals(str)) {
        return paramn.a();
      }
      if (shouldBlockRequestTarget(paramOutboundType, paramIntent, str)) {
        return paramR;
      }
    }
    int i;
    if (paramIntent != null) {
      i = adjustIntentFlags(paramOutboundType, paramIntent);
    } else {
      i = 0;
    }
    try
    {
      paramOutboundType = paramn.a();
      return paramOutboundType;
    }
    finally
    {
      if (paramIntent != null) {
        paramIntent.setFlags(i);
      }
    }
  }
  
  public <R, T extends Throwable> R proceed(OutboundType paramOutboundType, String paramString, R paramR, n<R, T> paramn)
  {
    if (this.mBase.getPackageName().equals(paramString)) {
      return paramn.a();
    }
    if (shouldBlockRequestTarget(paramOutboundType, null, paramString)) {
      return paramR;
    }
    return paramn.a();
  }
  
  public void proceedBroadcast(Context paramContext, Intent paramIntent, m<Boolean> paramm, BroadcastReceiver paramBroadcastReceiver)
  {
    if ((proceed(OutboundType.BROADCAST, paramIntent, Boolean.FALSE, paramm) == Boolean.FALSE) && (paramBroadcastReceiver != null)) {
      paramBroadcastReceiver.onReceive(new k(paramContext), paramIntent);
    }
  }
  
  public <T, E extends Throwable> List<T> proceedQuery(final OutboundType paramOutboundType, final Intent paramIntent, final n<List<T>, E> paramn, final j<T, String> paramj)
  {
    return (List)proceed(paramOutboundType, paramIntent, Collections.emptyList(), new a(paramn, paramIntent, paramj, paramOutboundType));
  }
  
  public boolean shouldAllowProvider(Context paramContext, String paramString, int paramInt)
  {
    return shouldAllowProvider(paramContext.getPackageManager().resolveContentProvider(paramString, paramInt));
  }
  
  public boolean shouldAllowProvider(ProviderInfo paramProviderInfo)
  {
    if (paramProviderInfo == null) {
      return true;
    }
    if (this.mBase.getPackageName().equals(paramProviderInfo.packageName)) {
      return true;
    }
    if (shouldBlockRequestTarget(OutboundType.CONTENT, null, paramProviderInfo.packageName)) {
      return false;
    }
    if ("settings".equals(paramProviderInfo.authority)) {
      return true;
    }
    if ((Build.VERSION.SDK_INT >= 12) && (this.mExcludeStoppedPackages) && ((paramProviderInfo.applicationInfo.flags & 0x200001) == 2097152)) {
      return this.mDryRun;
    }
    return true;
  }
  
  public boolean shouldSpoofPermission(String paramString)
  {
    i locali = this.mKitManager;
    return (locali != null) && (locali.b.contains(paramString));
  }
  
  final class a
    implements CondomCore.n<List<T>, E>
  {
    a(CondomCore.n paramn, Intent paramIntent, CondomCore.j paramj, OutboundType paramOutboundType) {}
  }
  
  final class b
    extends Lazy<PackageManager>
  {
    b(Context paramContext, String paramString) {}
  }
  
  final class c
    extends Lazy<PackageManager>
  {
    c(ajv paramajv, Context paramContext, Lazy paramLazy) {}
  }
  
  final class d
    extends Lazy<ContentResolver>
  {
    d(Context paramContext) {}
  }
  
  static final class e
    implements CondomCore.j<ResolveInfo, String>
  {}
  
  static final class f
    implements CondomCore.j<ResolveInfo, String>
  {}
  
  final class g
  {
    final List<ActivityManager.RunningServiceInfo> a;
    final List<ActivityManager.RunningAppProcessInfo> b;
    
    g()
    {
      this$1 = (ActivityManager)CondomCore.this.mBase.getSystemService("activity");
      if (CondomCore.this == null)
      {
        this.a = null;
        this.b = null;
        return;
      }
      if (Build.VERSION.SDK_INT >= 22)
      {
        this.a = CondomCore.this.getRunningServices(64);
        this.b = null;
        return;
      }
      this.a = null;
      this.b = CondomCore.this.getRunningAppProcesses();
    }
  }
  
  public static enum h
  {
    private h() {}
  }
  
  static final class i
    implements la.a
  {
    final Map<String, la.b> a = new HashMap();
    final Set<String> b = new HashSet();
    
    public final void a(String paramString, la.b paramb)
    {
      this.a.put(paramString, paramb);
    }
  }
  
  public static abstract interface j<T, R>
  {
    public abstract R a(T paramT);
  }
  
  final class k
    extends ContextWrapper
  {
    k(Context paramContext)
    {
      super();
    }
    
    public final boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
    {
      throw new ReceiverCallNotAllowedException("BroadcastReceiver components are not allowed to bind to services");
    }
    
    public final Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
    {
      return registerReceiver(paramBroadcastReceiver, paramIntentFilter, null, null);
    }
    
    public final Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
    {
      if (paramBroadcastReceiver == null) {
        return super.registerReceiver(null, paramIntentFilter, paramString, paramHandler);
      }
      throw new ReceiverCallNotAllowedException("BroadcastReceiver components are not allowed to register to receive intents");
    }
  }
  
  public static abstract class l
    implements CondomCore.m<Boolean>
  {
    protected abstract void a_();
  }
  
  public static abstract interface m<R>
    extends CondomCore.n<R, RuntimeException>
  {}
  
  public static abstract interface n<R, T extends Throwable>
  {
    public abstract R a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.CondomCore
 * JD-Core Version:    0.7.0.1
 */