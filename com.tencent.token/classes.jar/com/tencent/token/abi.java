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
import android.telephony.TelephonyManager;
import com.oasisfeng.condom.CondomContext;
import com.oasisfeng.condom.CondomOptions;
import com.oasisfeng.condom.OutboundJudge;
import com.oasisfeng.condom.OutboundType;
import com.oasisfeng.condom.PackageManagerWrapper;
import com.tencent.token.global.RqdApplication;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

public final class abi
{
  public static Context a(Context paramContext)
  {
    if (rp.a().b()) {
      return paramContext;
    }
    Object localObject = new CondomOptions();
    ((CondomOptions)localObject).preventBroadcastToBackgroundPackages(false);
    ((CondomOptions)localObject).preventServiceInBackgroundPackages(false);
    ((CondomOptions)localObject).setOutboundJudge(new OutboundJudge()
    {
      public final boolean shouldAllow(OutboundType paramAnonymousOutboundType, Intent paramAnonymousIntent, String paramAnonymousString)
      {
        return true;
      }
    });
    ((CondomOptions)localObject).setPackageManagerFactory(new kn()
    {
      public final PackageManagerWrapper a(final PackageManager paramAnonymousPackageManager)
      {
        new PackageManagerWrapper(paramAnonymousPackageManager)
        {
          public final List<ApplicationInfo> getInstalledApplications(int paramAnonymous2Int)
          {
            PackageManager localPackageManager = paramAnonymousPackageManager;
            if (!rp.a().b()) {
              return null;
            }
            return localPackageManager.getInstalledApplications(paramAnonymous2Int);
          }
          
          public final List<PackageInfo> getInstalledPackages(int paramAnonymous2Int)
          {
            PackageManager localPackageManager = paramAnonymousPackageManager;
            if (!rp.a().b()) {
              return null;
            }
            return localPackageManager.getInstalledPackages(paramAnonymous2Int);
          }
          
          public final List<ResolveInfo> queryBroadcastReceivers(Intent paramAnonymous2Intent, int paramAnonymous2Int)
          {
            PackageManager localPackageManager = paramAnonymousPackageManager;
            if (!rp.a().b()) {
              return null;
            }
            return localPackageManager.queryBroadcastReceivers(paramAnonymous2Intent, paramAnonymous2Int);
          }
          
          public final List<ResolveInfo> queryIntentActivities(Intent paramAnonymous2Intent, int paramAnonymous2Int)
          {
            PackageManager localPackageManager = paramAnonymousPackageManager;
            if (!rp.a().b()) {
              return null;
            }
            return localPackageManager.queryIntentActivities(paramAnonymous2Intent, paramAnonymous2Int);
          }
          
          public final List<ResolveInfo> queryIntentActivityOptions(ComponentName paramAnonymous2ComponentName, Intent[] paramAnonymous2ArrayOfIntent, Intent paramAnonymous2Intent, int paramAnonymous2Int)
          {
            PackageManager localPackageManager = paramAnonymousPackageManager;
            if (!rp.a().b()) {
              return null;
            }
            return localPackageManager.queryIntentActivityOptions(paramAnonymous2ComponentName, paramAnonymous2ArrayOfIntent, paramAnonymous2Intent, paramAnonymous2Int);
          }
          
          public final List<ResolveInfo> queryIntentServices(Intent paramAnonymous2Intent, int paramAnonymous2Int)
          {
            PackageManager localPackageManager = paramAnonymousPackageManager;
            if (!rp.a().b()) {
              return null;
            }
            return localPackageManager.queryIntentServices(paramAnonymous2Intent, paramAnonymous2Int);
          }
        };
      }
    });
    ((CondomOptions)localObject).addKit(new kj()
    {
      public final void a(kj.a paramAnonymousa)
      {
        paramAnonymousa.a("phone", new kj.b()
        {
          public final Object a(Context paramAnonymous2Context)
          {
            TelephonyManager localTelephonyManager = (TelephonyManager)RqdApplication.a().getSystemService("phone");
            try
            {
              paramAnonymous2Context = new kl(paramAnonymous2Context, localTelephonyManager)
              {
                @SuppressLint({"MissingPermission"})
                public final String getDeviceId()
                {
                  if (rp.a().b()) {
                    return super.getDeviceId();
                  }
                  return "00000000000000";
                }
                
                @SuppressLint({"MissingPermission"})
                public final String getDeviceId(int paramAnonymous3Int)
                {
                  if (rp.a().b()) {
                    return super.getDeviceId(paramAnonymous3Int);
                  }
                  return "00000000000000";
                }
                
                @SuppressLint({"MissingPermission"})
                public final String getImei()
                {
                  if (rp.a().b()) {
                    return super.getImei();
                  }
                  return "00000000000000";
                }
                
                @SuppressLint({"MissingPermission"})
                public final String getImei(int paramAnonymous3Int)
                {
                  if (rp.a().b()) {
                    return super.getImei(paramAnonymous3Int);
                  }
                  return "00000000000000";
                }
                
                @SuppressLint({"MissingPermission"})
                public final String getMeid()
                {
                  if (rp.a().b()) {
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
            return localTelephonyManager;
          }
        });
      }
    });
    ((CondomOptions)localObject).addKit(new kj()
    {
      public final void a(kj.a paramAnonymousa)
      {
        paramAnonymousa.a("wifi", new kj.b()
        {
          public final Object a(Context paramAnonymous2Context)
          {
            paramAnonymous2Context = (WifiManager)RqdApplication.a().getSystemService("wifi");
            try
            {
              km local1 = new km(paramAnonymous2Context)
              {
                public final WifiInfo getConnectionInfo()
                {
                  WifiInfo localWifiInfo;
                  if (rp.a().b()) {
                    localWifiInfo = super.getConnectionInfo();
                  } else {
                    localWifiInfo = abi.a();
                  }
                  if (localWifiInfo != null) {
                    new StringBuilder("intercepting...getConnectionInfo mac:").append(localWifiInfo.getMacAddress());
                  }
                  return localWifiInfo;
                }
              };
              return local1;
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
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
  
  static WifiInfo a()
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
 * Qualified Name:     com.tencent.token.abi
 * JD-Core Version:    0.7.0.1
 */