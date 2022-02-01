package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.oasisfeng.condom.CondomContext;
import com.oasisfeng.condom.CondomOptions;
import com.oasisfeng.condom.OutboundJudge;
import com.oasisfeng.condom.OutboundType;
import com.oasisfeng.condom.PackageManagerWrapper;
import com.oasisfeng.condom.c;
import com.oasisfeng.condom.c.a;
import com.oasisfeng.condom.c.b;
import com.oasisfeng.condom.f;
import com.tencent.token.global.RqdApplication;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

public final class dx
{
  public static Context a(Context paramContext)
  {
    if (c()) {
      return paramContext;
    }
    Object localObject = new CondomOptions();
    ((CondomOptions)localObject).preventBroadcastToBackgroundPackages(false);
    ((CondomOptions)localObject).preventServiceInBackgroundPackages(false);
    ((CondomOptions)localObject).setOutboundJudge(new OutboundJudge()
    {
      public boolean shouldAllow(OutboundType paramAnonymousOutboundType, @Nullable Intent paramAnonymousIntent, String paramAnonymousString)
      {
        return true;
      }
    });
    ((CondomOptions)localObject).setPackageManagerFactory(new h()
    {
      public PackageManagerWrapper a(Context paramAnonymousContext, final PackageManager paramAnonymousPackageManager)
      {
        new PackageManagerWrapper(paramAnonymousPackageManager)
        {
          public List<ApplicationInfo> getInstalledApplications(int paramAnonymous2Int)
          {
            return dx.b(paramAnonymousPackageManager, paramAnonymous2Int);
          }
          
          public List<PackageInfo> getInstalledPackages(int paramAnonymous2Int)
          {
            return dx.a(paramAnonymousPackageManager, paramAnonymous2Int);
          }
          
          public List<ResolveInfo> queryBroadcastReceivers(Intent paramAnonymous2Intent, int paramAnonymous2Int)
          {
            return dx.a(paramAnonymousPackageManager, paramAnonymous2Intent, paramAnonymous2Int);
          }
          
          public List<ResolveInfo> queryIntentActivities(Intent paramAnonymous2Intent, int paramAnonymous2Int)
          {
            return dx.b(paramAnonymousPackageManager, paramAnonymous2Intent, paramAnonymous2Int);
          }
          
          public List<ResolveInfo> queryIntentActivityOptions(ComponentName paramAnonymous2ComponentName, Intent[] paramAnonymous2ArrayOfIntent, Intent paramAnonymous2Intent, int paramAnonymous2Int)
          {
            return dx.a(paramAnonymousPackageManager, paramAnonymous2ComponentName, paramAnonymous2ArrayOfIntent, paramAnonymous2Intent, paramAnonymous2Int);
          }
          
          public List<ResolveInfo> queryIntentServices(Intent paramAnonymous2Intent, int paramAnonymous2Int)
          {
            return dx.c(paramAnonymousPackageManager, paramAnonymous2Intent, paramAnonymous2Int);
          }
        };
      }
    });
    ((CondomOptions)localObject).addKit(new c()
    {
      public void a(c.a paramAnonymousa)
      {
        paramAnonymousa.a("phone", new c.b()
        {
          public Object a(Context paramAnonymous2Context, String paramAnonymous2String)
          {
            paramAnonymous2String = (TelephonyManager)RqdApplication.a().getSystemService("phone");
            try
            {
              paramAnonymous2Context = new com.oasisfeng.condom.e(paramAnonymous2Context, paramAnonymous2String)
              {
                @SuppressLint({"MissingPermission"})
                public String getDeviceId()
                {
                  if (dx.a()) {
                    return super.getDeviceId();
                  }
                  return "00000000000000";
                }
                
                @SuppressLint({"MissingPermission"})
                public String getDeviceId(int paramAnonymous3Int)
                {
                  if (dx.a()) {
                    return super.getDeviceId(paramAnonymous3Int);
                  }
                  return "00000000000000";
                }
                
                @SuppressLint({"MissingPermission"})
                public String getImei()
                {
                  if (dx.a()) {
                    return super.getImei();
                  }
                  return "00000000000000";
                }
                
                @SuppressLint({"MissingPermission"})
                public String getImei(int paramAnonymous3Int)
                {
                  if (dx.a()) {
                    return super.getImei(paramAnonymous3Int);
                  }
                  return "00000000000000";
                }
                
                @SuppressLint({"MissingPermission"})
                public String getMeid()
                {
                  if (dx.a()) {
                    return super.getMeid();
                  }
                  return "00000000000000";
                }
              };
              return paramAnonymous2Context;
            }
            catch (Exception paramAnonymous2Context)
            {
              paramAnonymous2Context.printStackTrace();
            }
            return paramAnonymous2String;
          }
        });
      }
    });
    ((CondomOptions)localObject).addKit(new c()
    {
      public void a(c.a paramAnonymousa)
      {
        paramAnonymousa.a("wifi", new c.b()
        {
          public Object a(Context paramAnonymous2Context, String paramAnonymous2String)
          {
            paramAnonymous2Context = (WifiManager)RqdApplication.a().getSystemService("wifi");
            try
            {
              paramAnonymous2String = new f(paramAnonymous2Context)
              {
                public WifiInfo getConnectionInfo()
                {
                  WifiInfo localWifiInfo;
                  if (dx.a()) {
                    localWifiInfo = super.getConnectionInfo();
                  } else {
                    localWifiInfo = dx.b();
                  }
                  if (localWifiInfo != null)
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("intercepting...getConnectionInfo mac:");
                    localStringBuilder.append(localWifiInfo.getMacAddress());
                    Log.i("SecurePackageManagerU", localStringBuilder.toString());
                  }
                  return localWifiInfo;
                }
              };
              return paramAnonymous2String;
            }
            catch (Throwable paramAnonymous2String)
            {
              paramAnonymous2String.printStackTrace();
            }
            return paramAnonymous2Context;
          }
        });
      }
    });
    try
    {
      localObject = CondomContext.wrap(paramContext, "intercept_pm", (CondomOptions)localObject);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramContext;
  }
  
  public static List<PackageInfo> a(PackageManager paramPackageManager, int paramInt)
  {
    if (!c()) {
      return null;
    }
    return paramPackageManager.getInstalledPackages(paramInt);
  }
  
  public static List<ResolveInfo> a(PackageManager paramPackageManager, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt)
  {
    if (!c()) {
      return null;
    }
    return paramPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, paramInt);
  }
  
  public static List<ResolveInfo> a(PackageManager paramPackageManager, Intent paramIntent, int paramInt)
  {
    if (!c()) {
      return null;
    }
    return paramPackageManager.queryBroadcastReceivers(paramIntent, paramInt);
  }
  
  public static List<ApplicationInfo> b(PackageManager paramPackageManager, int paramInt)
  {
    if (!c()) {
      return null;
    }
    return paramPackageManager.getInstalledApplications(paramInt);
  }
  
  public static List<ResolveInfo> b(PackageManager paramPackageManager, Intent paramIntent, int paramInt)
  {
    if (!c()) {
      return null;
    }
    return paramPackageManager.queryIntentActivities(paramIntent, paramInt);
  }
  
  public static List<ResolveInfo> c(PackageManager paramPackageManager, Intent paramIntent, int paramInt)
  {
    if (!c()) {
      return null;
    }
    return paramPackageManager.queryIntentServices(paramIntent, paramInt);
  }
  
  private static boolean c()
  {
    return com.tencent.service.update.e.a().b();
  }
  
  private static WifiInfo d()
  {
    try
    {
      WifiInfo localWifiInfo = (WifiInfo)WifiInfo.class.getConstructor(new Class[0]).newInstance(new Object[0]);
      Field localField = localWifiInfo.getClass().getDeclaredField("mMacAddress");
      localField.setAccessible(true);
      localField.set(localWifiInfo, "");
      return localWifiInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dx
 * JD-Core Version:    0.7.0.1
 */