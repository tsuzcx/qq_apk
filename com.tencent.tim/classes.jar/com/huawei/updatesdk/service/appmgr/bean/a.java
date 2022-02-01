package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.d;
import com.huawei.updatesdk.a.a.c.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends com.huawei.updatesdk.service.a.c
{
  public static final String APIMETHOD = "client.updateCheck";
  public static final int DEFAULT_UPGRADE_RESULT = 0;
  public static final int FULL_UPGRADE_RESULT = 1;
  public static final int INSTALL_CHECK_DEFAULT = 0;
  private static final int PARSE_IS_REMOVABLE_PREINSTALLED_APK = 33554432;
  public static final int PRE_DOWNLOAD_CLOSE = 0;
  private static final String TAG = "UpgradeRequest";
  private static final int TYPE_NOT_PREINSTALL = 0;
  private static final int TYPE_PREINSTALL = 2;
  private static final int TYPE_PREINSTALL_REMOVABLE = 1;
  private String agVersion_;
  private String buildNumber_;
  private String density_;
  private com.huawei.updatesdk.a.a.c.a.a deviceSpecParams_;
  private int emuiApiLevel_ = 0;
  private String firmwareVersion_;
  private int getSafeGame_ = 1;
  private int gmsSupport_;
  private int installCheck_ = 0;
  private int isFirstLaunch_ = 0;
  private int isFullUpgrade_ = 0;
  private int mapleVer_;
  private String packageName_;
  private String phoneType_;
  private a pkgInfo_;
  private String resolution_;
  private String serviceCountry_;
  private int supportMaple_ = 0;
  private int versionCode_;
  private String version_;
  
  public a()
  {
    Context localContext = com.huawei.updatesdk.a.b.a.a.a().b();
    b("client.updateCheck");
    c("1.2");
    e(com.huawei.updatesdk.a.a.c.a.b.e());
    n(com.huawei.updatesdk.a.a.c.a.b.b());
    g(com.huawei.updatesdk.a.a.c.a.b.i(localContext));
    h(com.huawei.updatesdk.a.a.c.a.b.a());
    i(Build.MODEL);
    f(com.huawei.updatesdk.a.a.c.a.b.a(localContext));
    e(com.huawei.updatesdk.a.a.c.a.b.f(localContext));
    if (com.huawei.updatesdk.a.a.c.a.b.e(localContext)) {
      i = 1;
    }
    f(i);
    j(com.huawei.updatesdk.a.a.c.a.b.d(localContext));
    k(com.huawei.updatesdk.a.b.a.a.a().b().getPackageName());
    g(com.huawei.updatesdk.service.e.b.a().b());
    l(com.huawei.updatesdk.service.a.a.a().c());
    c(com.huawei.updatesdk.a.a.c.a.b.f().g());
    d(com.huawei.updatesdk.a.a.c.a.b.f().h());
    this.deviceSpecParams_ = new com.huawei.updatesdk.a.a.c.a.a.a(localContext).a(true).a();
    m(com.huawei.updatesdk.a.a.c.a.b.h(localContext));
  }
  
  public static a a(List<PackageInfo> paramList)
  {
    a locala = new a();
    a locala1 = new a();
    locala.a(locala1);
    ArrayList localArrayList = new ArrayList();
    locala1.a(localArrayList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new b((PackageInfo)paramList.next()));
    }
    return locala;
  }
  
  private static boolean a(ApplicationInfo paramApplicationInfo)
  {
    int i = paramApplicationInfo.flags;
    Object localObject = com.huawei.updatesdk.service.e.c.a();
    if ((localObject != null) && ((i & ((Integer)localObject).intValue()) != 0)) {}
    for (;;)
    {
      return true;
      localObject = com.huawei.updatesdk.service.e.c.b();
      if (localObject != null) {}
      try
      {
        i = ((Field)localObject).getInt(paramApplicationInfo);
        if ((i & 0x2000000) != 0) {}
      }
      catch (IllegalAccessException paramApplicationInfo)
      {
        for (;;)
        {
          com.huawei.updatesdk.a.a.b.a.a.a.a("UpgradeRequest", "can not get hwflags" + paramApplicationInfo.toString());
        }
      }
      catch (IllegalArgumentException paramApplicationInfo)
      {
        for (;;)
        {
          com.huawei.updatesdk.a.a.b.a.a.a.a("UpgradeRequest", "can not get hwflags" + paramApplicationInfo.toString());
        }
      }
    }
    return false;
  }
  
  private static int b(PackageInfo paramPackageInfo)
  {
    if ((paramPackageInfo.applicationInfo.flags & 0x1) == 0) {
      return 0;
    }
    if (a(paramPackageInfo.applicationInfo)) {
      return 1;
    }
    return 2;
  }
  
  public static a d(String paramString)
  {
    PackageInfo localPackageInfo = new PackageInfo();
    localPackageInfo.packageName = paramString;
    localPackageInfo.versionName = "1.0";
    localPackageInfo.versionCode = 1;
    paramString = new ApplicationInfo();
    paramString.targetSdkVersion = 19;
    localPackageInfo.applicationInfo = paramString;
    paramString = new ArrayList();
    paramString.add(localPackageInfo);
    paramString = a(paramString);
    paramString.b(1);
    return paramString;
  }
  
  public void a(int paramInt)
  {
    this.installCheck_ = paramInt;
  }
  
  public void a(a parama)
  {
    this.pkgInfo_ = parama;
  }
  
  public void b(int paramInt)
  {
    this.isFullUpgrade_ = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.supportMaple_ = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.mapleVer_ = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.versionCode_ = paramInt;
  }
  
  public void e(String paramString)
  {
    this.firmwareVersion_ = paramString;
  }
  
  public void f(int paramInt)
  {
    this.gmsSupport_ = paramInt;
  }
  
  public void f(String paramString)
  {
    this.density_ = paramString;
  }
  
  public void g(int paramInt)
  {
    this.emuiApiLevel_ = paramInt;
  }
  
  public void g(String paramString)
  {
    this.version_ = paramString;
  }
  
  public void h(String paramString)
  {
    this.buildNumber_ = paramString;
  }
  
  public void i(String paramString)
  {
    this.phoneType_ = paramString;
  }
  
  public void j(String paramString)
  {
    this.resolution_ = paramString;
  }
  
  public void k(String paramString)
  {
    this.packageName_ = paramString;
  }
  
  public void l(String paramString)
  {
    this.serviceCountry_ = paramString;
  }
  
  public void m(String paramString)
  {
    this.agVersion_ = paramString;
  }
  
  public static class a
    extends com.huawei.updatesdk.a.b.d.a.b
  {
    private List<a.b> params_;
    
    public void a(List<a.b> paramList)
    {
      this.params_ = paramList;
    }
  }
  
  public static class b
    extends com.huawei.updatesdk.a.b.d.a.b
  {
    private static final String FILE_SHA_KEY = "fileshakey";
    private static final String PACKAGE_KEY = "packagekey";
    private String fSha2_;
    private int isPre_;
    private int maple_;
    private String oldVersion_;
    private String package_;
    private String sSha2_;
    private int targetSdkVersion_;
    private int versionCode_;
    
    public b() {}
    
    public b(PackageInfo paramPackageInfo)
    {
      this.package_ = paramPackageInfo.packageName;
      this.versionCode_ = paramPackageInfo.versionCode;
      if (paramPackageInfo.versionName == null) {}
      String str2;
      for (String str1 = "null";; str1 = paramPackageInfo.versionName)
      {
        this.oldVersion_ = str1;
        this.targetSdkVersion_ = paramPackageInfo.applicationInfo.targetSdkVersion;
        this.isPre_ = a.a(paramPackageInfo);
        this.maple_ = com.huawei.updatesdk.service.e.c.b(this.package_);
        if (paramPackageInfo.signatures != null) {
          this.sSha2_ = g.c(com.huawei.updatesdk.a.a.c.a.a(g.d(paramPackageInfo.signatures[0].toCharsString())));
        }
        str1 = "packagekey" + this.package_;
        str2 = "fileshakey" + this.package_;
        if (!TextUtils.isEmpty(paramPackageInfo.applicationInfo.sourceDir)) {
          break;
        }
        this.fSha2_ = null;
        com.huawei.updatesdk.service.a.a.a().d(str1);
        com.huawei.updatesdk.service.a.a.a().d(str2);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramPackageInfo.lastUpdateTime).append(paramPackageInfo.versionCode).append(this.package_);
      if (!TextUtils.equals(localStringBuilder.toString(), com.huawei.updatesdk.service.a.a.a().c(str1))) {
        i = 1;
      }
      if (i != 0) {
        com.huawei.updatesdk.service.a.a.a().a(str1, localStringBuilder.toString());
      }
      str1 = com.huawei.updatesdk.service.a.a.a().c(str2);
      if ((TextUtils.isEmpty(str1)) || (i != 0))
      {
        str1 = d.a(paramPackageInfo.applicationInfo.sourceDir, "SHA-256");
        com.huawei.updatesdk.service.a.a.a().a(str2, str1);
      }
      this.fSha2_ = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.appmgr.bean.a
 * JD-Core Version:    0.7.0.1
 */