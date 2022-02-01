package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.support.log.HMSLog;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static b a;
  private static final Object b = new Object();
  private final Context c;
  private final PackageManagerHelper d;
  private String e;
  private String f;
  private int g;
  
  private b(Context paramContext)
  {
    this.c = paramContext;
    this.d = new PackageManagerHelper(paramContext);
  }
  
  public static b a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null)
      {
        a = new b(paramContext.getApplicationContext());
        a.d();
      }
      return a;
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      HMSLog.e("HMSPackageManager", "args is invalid");
      return false;
    }
    paramString3 = c.b(paramString3);
    if (paramString3.size() == 0)
    {
      HMSLog.e("HMSPackageManager", "certChain is empty");
      return false;
    }
    if (!c.a(c.a(this.c), paramString3))
    {
      HMSLog.e("HMSPackageManager", "failed to verify cert chain");
      return false;
    }
    paramString3 = (X509Certificate)paramString3.get(paramString3.size() - 1);
    if (!c.a(paramString3, "Huawei CBG HMS"))
    {
      HMSLog.e("HMSPackageManager", "CN is invalid");
      return false;
    }
    if (!c.b(paramString3, "Huawei CBG Cloud Security Signer"))
    {
      HMSLog.e("HMSPackageManager", "OU is invalid");
      return false;
    }
    if (!c.b(paramString3, paramString1, paramString2))
    {
      HMSLog.e("HMSPackageManager", "signature is invalid: " + paramString1);
      return false;
    }
    return true;
  }
  
  private void d()
  {
    Pair localPair = e();
    if (localPair == null)
    {
      HMSLog.e("HMSPackageManager", "Failed to find HMS apk");
      return;
    }
    this.e = ((String)localPair.first);
    this.f = ((String)localPair.second);
    this.g = this.d.getPackageVersionCode(b());
    HMSLog.i("HMSPackageManager", "Succeed to find HMS apk: " + this.e + " version: " + this.g);
  }
  
  private Pair<String, String> e()
  {
    Object localObject1 = this.c.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
    if (((List)localObject1).size() == 0) {
      return null;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      String str1 = ((ResolveInfo)localObject2).serviceInfo.applicationInfo.packageName;
      localObject2 = ((ResolveInfo)localObject2).serviceInfo.metaData;
      if (localObject2 == null)
      {
        HMSLog.e("HMSPackageManager", "skip package " + str1 + " for metadata is null");
      }
      else if (!((Bundle)localObject2).containsKey("hms_app_signer"))
      {
        HMSLog.e("HMSPackageManager", "skip package " + str1 + " for no signer");
      }
      else if (!((Bundle)localObject2).containsKey("hms_app_cert_chain"))
      {
        HMSLog.e("HMSPackageManager", "skip package " + str1 + " for no cert chain");
      }
      else
      {
        String str2 = this.d.getPackageSignature(str1);
        if (!a(str1 + "&" + str2, ((Bundle)localObject2).getString("hms_app_signer"), ((Bundle)localObject2).getString("hms_app_cert_chain"))) {
          HMSLog.e("HMSPackageManager", "checkSinger failed");
        } else {
          return new Pair(str1, str2);
        }
      }
    }
    return null;
  }
  
  public PackageManagerHelper.PackageStates a()
  {
    Object localObject;
    if ((TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f)))
    {
      d();
      localObject = this.d.getPackageStates(this.e);
    }
    do
    {
      PackageManagerHelper.PackageStates localPackageStates;
      do
      {
        return localObject;
        localPackageStates = this.d.getPackageStates(this.e);
        localObject = localPackageStates;
      } while (localPackageStates != PackageManagerHelper.PackageStates.ENABLED);
      localObject = localPackageStates;
    } while (this.f.equals(this.d.getPackageSignature(this.e)));
    return PackageManagerHelper.PackageStates.NOT_INSTALLED;
  }
  
  public boolean a(int paramInt)
  {
    if (this.g >= paramInt) {}
    do
    {
      return true;
      this.g = this.d.getPackageVersionCode(b());
    } while (this.g >= paramInt);
    return false;
  }
  
  public String b()
  {
    if (this.e == null) {
      return "com.huawei.hwid";
    }
    return this.e;
  }
  
  public int c()
  {
    return this.d.getPackageVersionCode(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.b
 * JD-Core Version:    0.7.0.1
 */