package com.huawei.hms.update.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import java.io.File;

public class l
  extends a
  implements com.huawei.hms.update.a.a.b
{
  private com.huawei.hms.update.a.a.a k;
  private com.huawei.hms.update.a.a.c l;
  private int m = 0;
  
  private static Uri a(Context paramContext, File paramFile)
  {
    int i = 1;
    PackageManagerHelper localPackageManagerHelper = new PackageManagerHelper(paramContext);
    String str1 = paramContext.getPackageName();
    String str2 = str1 + ".hms.update.provider";
    if (Build.VERSION.SDK_INT > 23) {
      if (paramContext.getApplicationInfo().targetSdkVersion <= 23) {}
    }
    while (i != 0)
    {
      return UpdateProvider.getUriForFile(paramContext, str2, paramFile);
      if (!localPackageManagerHelper.hasProvider(str1, str2)) {
        i = 0;
      }
    }
    return Uri.fromFile(paramFile);
  }
  
  private void a(Intent paramIntent, com.huawei.hms.update.a.a.b paramb)
  {
    int i;
    String str;
    Object localObject;
    int j;
    try
    {
      i = paramIntent.getIntExtra("status", -99);
      HMSLog.i("UpdateWizard", "CheckUpdateCallBack status is " + i);
      str = paramIntent.getStringExtra("failreason");
      if (!TextUtils.isEmpty(str)) {
        HMSLog.e("UpdateWizard", "checkTargetAppUpdate reason is " + str);
      }
      if (i != 7) {
        break label311;
      }
      paramIntent = paramIntent.getSerializableExtra("updatesdk_update_info");
      if ((paramIntent != null) && ((paramIntent instanceof ApkUpgradeInfo)))
      {
        localObject = (ApkUpgradeInfo)paramIntent;
        paramIntent = ((ApkUpgradeInfo)localObject).getPackage_();
        i = ((ApkUpgradeInfo)localObject).getVersionCode_();
        str = ((ApkUpgradeInfo)localObject).getDownurl_();
        j = ((ApkUpgradeInfo)localObject).getSize_();
        localObject = ((ApkUpgradeInfo)localObject).getSha256_();
        if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals(this.c.b()))) {
          a(paramb, 1201, null);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramIntent)
    {
      HMSLog.e("UpdateWizard", "intent has some error" + paramIntent.getMessage());
      a(paramb, 1201, null);
      return;
    }
    if (i < this.c.c())
    {
      HMSLog.e("UpdateWizard", "CheckUpdateCallBack versionCode is " + i + "bean.getClientVersionCode() is " + this.c.c());
      a(paramb, 1203, null);
      return;
    }
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      a(paramb, 1201, null);
      return;
    }
    a(paramb, 1000, new com.huawei.hms.update.a.a.c(paramIntent, i, str, j, (String)localObject));
    return;
    label311:
    if (i == 3)
    {
      a(paramb, 1202, null);
      return;
    }
    a(paramb, 1201, null);
  }
  
  private void a(com.huawei.hms.update.a.a.b paramb)
  {
    if (paramb == null) {
      return;
    }
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      a(paramb, 1201, null);
      return;
    }
    UpdateSdkAPI.checkTargetAppUpdate(localActivity, this.c.b(), new l.2(this, paramb));
  }
  
  private static void a(com.huawei.hms.update.a.a.b paramb, int paramInt, com.huawei.hms.update.a.a.c paramc)
  {
    if (paramb != null) {
      new Handler(Looper.getMainLooper()).post(new l.1(paramb, paramInt, paramc));
    }
  }
  
  private void a(File paramFile)
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    paramFile = a(localActivity, paramFile);
    if (paramFile == null)
    {
      HMSLog.e("UpdateWizard", "In startInstaller, Failed to creates a Uri from a file.");
      e();
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(paramFile, "application/vnd.android.package-archive");
    localIntent.setFlags(3);
    localIntent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
    try
    {
      localActivity.startActivityForResult(localIntent, getRequestCode());
      return;
    }
    catch (ActivityNotFoundException paramFile)
    {
      HMSLog.e("UpdateWizard", "In startInstaller, Failed to start package installer." + paramFile.getMessage());
      e();
    }
  }
  
  private void d()
  {
    Object localObject = b();
    if (localObject != null) {}
    for (localObject = Util.getNetType(((Activity)localObject).getBaseContext());; localObject = "")
    {
      HMSLog.i("UpdateWizard", "current network is " + (String)localObject);
      if (!"WIFI".equals(localObject)) {
        break;
      }
      a(e.class);
      f();
      HMSLog.i("UpdateWizard", "current network is wifi");
      return;
    }
    a(d.b.class);
    HMSLog.i("UpdateWizard", "current network is not wifi");
  }
  
  private void e()
  {
    if (!a(false))
    {
      b(8, this.f);
      return;
    }
    a(8, this.f);
  }
  
  private void f()
  {
    Activity localActivity = b();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      a(j.c.class);
      return;
    }
    g();
    this.k = new com.huawei.hms.update.a.c(new com.huawei.hms.update.a.d(localActivity));
    this.k.a(this, this.l);
  }
  
  private void g()
  {
    if (this.k != null)
    {
      this.k.a();
      this.k = null;
    }
  }
  
  void a()
  {
    b(13, this.f);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, File paramFile)
  {
    HMSLog.i("UpdateWizard", "Enter onDownloadPackage, status: " + com.huawei.hms.update.a.a.d.a(paramInt1) + ", reveived: " + paramInt2 + ", total: " + paramInt3);
    switch (paramInt1)
    {
    case 2101: 
    default: 
    case 2000: 
    case 2100: 
      do
      {
        return;
        c();
        if (paramFile == null)
        {
          e();
          return;
        }
        if (FileUtil.verifyHash(this.l.e, paramFile))
        {
          a(paramFile);
          return;
        }
        HMSLog.i("UpdateWizard", "Hash value mismatch for download file");
        return;
      } while ((this.d == null) || (!(this.d instanceof e)));
      if ((paramInt2 < 0) || (paramInt3 <= 0)) {
        break;
      }
    }
    for (paramInt1 = (int)(paramInt2 * 100L / paramInt3);; paramInt1 = 0)
    {
      this.m = paramInt1;
      ((e)this.d).b(paramInt1);
      return;
      a(j.c.class);
      return;
      a(j.d.class);
      return;
      a(d.c.class);
      return;
    }
  }
  
  public void a(int paramInt, com.huawei.hms.update.a.a.c paramc)
  {
    HMSLog.i("UpdateWizard", "Enter onCheckUpdate, status: " + com.huawei.hms.update.a.a.d.a(paramInt));
    switch (paramInt)
    {
    default: 
      a(j.b.class);
      return;
    case 1000: 
      this.l = paramc;
      d();
      return;
    }
    a(j.b.class);
  }
  
  public void a(b paramb)
  {
    HMSLog.i("UpdateWizard", "Enter onCancel.");
    if ((paramb instanceof i))
    {
      a();
      return;
    }
    if ((paramb instanceof c))
    {
      g();
      a();
      return;
    }
    if ((paramb instanceof e))
    {
      g();
      a(d.d.class);
      return;
    }
    if ((paramb instanceof d.d))
    {
      a(e.class);
      f();
      return;
    }
    if ((paramb instanceof d.c))
    {
      a();
      return;
    }
    if ((paramb instanceof d.b))
    {
      a();
      return;
    }
    e();
  }
  
  void a(Class<? extends b> paramClass)
  {
    c();
    try
    {
      paramClass = (b)paramClass.newInstance();
      if ((!TextUtils.isEmpty(this.h)) && ((paramClass instanceof i)))
      {
        this.h = ResourceLoaderUtil.getString("hms_update_title");
        ((i)paramClass).a(this.h);
      }
      if ((this.m > 0) && ((paramClass instanceof e))) {
        ((e)paramClass).a(this.m);
      }
      paramClass.a(this);
      this.d = paramClass;
      return;
    }
    catch (InstantiationException paramClass)
    {
      HMSLog.e("UpdateWizard", "In showDialog, Failed to show the dialog." + paramClass.getMessage());
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      break label87;
    }
    catch (IllegalStateException paramClass)
    {
      label87:
      break label87;
    }
  }
  
  public void b(b paramb)
  {
    HMSLog.i("UpdateWizard", "Enter onDoWork.");
    if ((paramb instanceof i))
    {
      paramb.c();
      a(c.class);
      a(this);
    }
    do
    {
      return;
      if ((paramb instanceof d.d))
      {
        paramb.c();
        a();
        return;
      }
      if ((paramb instanceof d.c))
      {
        a(e.class);
        f();
        return;
      }
      if ((paramb instanceof d.b))
      {
        a(e.class);
        f();
        return;
      }
      if ((paramb instanceof j.b))
      {
        e();
        return;
      }
      if ((paramb instanceof j.c))
      {
        e();
        return;
      }
    } while (!(paramb instanceof j.d));
    e();
  }
  
  public int getRequestCode()
  {
    return 2006;
  }
  
  public void onBridgeActivityCreate(Activity paramActivity)
  {
    super.onBridgeActivityCreate(paramActivity);
    if (this.c == null) {
      return;
    }
    this.f = 6;
    if ((this.c.isNeedConfirm()) && (!TextUtils.isEmpty(this.h)))
    {
      a(i.class);
      return;
    }
    a(c.class);
    a(this);
  }
  
  public void onBridgeActivityDestroy()
  {
    g();
    super.onBridgeActivityDestroy();
  }
  
  public boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.e) && (this.b != null)) {
      bool1 = this.b.onBridgeActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.f != 6);
      bool1 = bool2;
    } while (paramInt1 != getRequestCode());
    if (a(this.g, this.i)) {
      b(0, this.f);
    }
    for (;;)
    {
      return true;
      e();
    }
  }
  
  public void onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.e) && (this.b != null)) {
      this.b.onKeyUp(paramInt, paramKeyEvent);
    }
    do
    {
      do
      {
        return;
      } while (4 != paramInt);
      HMSLog.i("UpdateWizard", "In onKeyUp, Call finish.");
      paramKeyEvent = b();
    } while ((paramKeyEvent == null) || (paramKeyEvent.isFinishing()));
    paramKeyEvent.setResult(0, null);
    paramKeyEvent.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.update.ui.l
 * JD-Core Version:    0.7.0.1
 */