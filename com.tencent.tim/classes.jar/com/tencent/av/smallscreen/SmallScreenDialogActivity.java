package com.tencent.av.smallscreen;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import aqgz;
import aqha;
import aqju;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import ivo;
import ivv;
import mqq.app.BaseActivity;

public class SmallScreenDialogActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener
{
  private final String TAG = "SmallScreenDialogActivity_" + AudioHelper.hG();
  private int auj;
  public VideoAppInterface mApp;
  BroadcastReceiver mReceiver = new ivo(this);
  private aqju n;
  private aqju o;
  private long om;
  
  private void aqV()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    VasWebviewUtil.openQQBrowserWithoutAD(this, "https://kf.qq.com/touch/apifaq/1506297fqqea150629iuAjqU.html?platform=14", 524288L, localIntent, false, -1);
  }
  
  private aqju b()
  {
    aqju localaqju;
    if (this.n == null)
    {
      localaqju = aqha.a(this, 230).setMessage(2131698085).setNegativeButton(2131721058, this);
      if (!vC()) {
        break label76;
      }
    }
    label76:
    for (int i = 2131698089;; i = 2131698100)
    {
      this.n = localaqju.setPositiveButton(i, this);
      this.n.setTitle(2131698087);
      this.n.setCancelable(false);
      this.n.setCanceledOnTouchOutside(false);
      return this.n;
    }
  }
  
  private aqju c()
  {
    if (this.o == null)
    {
      this.o = aqha.a(this, 230).setMessage(2131698086).setNegativeButton(2131721058, this).setPositiveButton(2131694592, this);
      this.o.setTitle(2131698088);
      this.o.setCancelable(false);
      this.o.setCanceledOnTouchOutside(false);
    }
    return this.o;
  }
  
  static boolean vB()
  {
    return !"vivo".equalsIgnoreCase(aqgz.BY());
  }
  
  private boolean vC()
  {
    if ((ivv.isIntentAvailable(this, "miui.intent.action.APP_PERM_EDITOR")) || (ivv.isIntentAvailable(this, "com.meizu.safe.security.SHOW_APPSEC")) || (ivv.isIntentAvailable(this, "huawei.intent.action.NOTIFICATIONMANAGER")) || (ivv.isIntentAvailable(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (bool1) {
        bool2 = vD();
      }
      return bool2;
    }
  }
  
  void a(String paramString, aqju paramaqju)
  {
    try
    {
      QLog.w(this.TAG, 1, "showDialog, from[" + paramString + "]");
      paramaqju.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      QLog.w(this.TAG, 1, "showDialog BadTokenException, from[" + paramString + "]", localBadTokenException);
      getWindow().getDecorView().post(new SmallScreenDialogActivity.2(this, paramString, paramaqju));
    }
  }
  
  void aqU()
  {
    boolean bool3 = false;
    String str3 = getPackageName();
    Object localObject1 = null;
    if ((vB()) && (ivv.isIntentAvailable(this, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))) {
      localObject1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + str3));
    }
    for (;;)
    {
      try
      {
        startActivity((Intent)localObject1);
        localObject1 = "ACTION_ANDROID";
        bool2 = true;
      }
      catch (Exception localException1)
      {
        Object localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(this.TAG, 2, "openPermissionActivity Exception", localException1);
        str1 = "Exception:" + localException1.getMessage();
        bool2 = false;
        continue;
      }
      boolean bool1 = bool2;
      localObject3 = localObject1;
      if (!bool2)
      {
        bool1 = bool2;
        localObject3 = localObject1;
        if (ivv.isIntentAvailable(this, "miui.intent.action.APP_PERM_EDITOR"))
        {
          localObject3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
          ((Intent)localObject3).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
          ((Intent)localObject3).putExtra("extra_pkgname", str3);
        }
      }
      try
      {
        startActivity((Intent)localObject3);
        localObject3 = "ACTION_MIUI";
        bool1 = true;
      }
      catch (Exception localException3)
      {
        if (!QLog.isColorLevel()) {
          break label497;
        }
        QLog.e(this.TAG, 2, "openPermissionActivity Exception", localException3);
        bool1 = false;
        str2 = str1;
        continue;
      }
      boolean bool2 = bool1;
      localObject1 = localObject3;
      if (!bool1)
      {
        bool2 = bool1;
        localObject1 = localObject3;
        if (ivv.isIntentAvailable(this, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localObject1 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          ((Intent)localObject1).setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          ((Intent)localObject1).putExtra("packageName", str3);
        }
      }
      try
      {
        startActivity((Intent)localObject1);
        localObject1 = "ACTION_MEIZU";
        bool2 = true;
      }
      catch (Exception localException2)
      {
        label497:
        if (!QLog.isColorLevel()) {
          break label527;
        }
        QLog.e(this.TAG, 2, "openPermissionActivity Exception", localException2);
        label527:
        bool2 = false;
        localObject2 = str2;
        continue;
      }
      if ((!bool2) && ("vivo".equalsIgnoreCase(aqgz.BY())) && (ivv.isIntentAvailable(this, "permission.intent.action.softPermissionDetail")))
      {
        localObject3 = new Intent("permission.intent.action.softPermissionDetail");
        try
        {
          ((Intent)localObject3).putExtra("packagename", str3);
          startActivity((Intent)localObject3);
          localObject1 = "ACTION_VIVO";
          bool1 = true;
        }
        catch (Exception localException4)
        {
          if (!QLog.isColorLevel()) {
            break label557;
          }
          QLog.e(this.TAG, 2, "openPermissionActivity Exception", localException4);
          bool1 = false;
          continue;
        }
        localObject3 = localObject1;
        bool2 = bool1;
        if (!bool1)
        {
          localObject3 = localObject1;
          bool2 = bool1;
          if (ivv.isIntentAvailable(this, "huawei.intent.action.NOTIFICATIONMANAGER"))
          {
            localObject3 = new Intent();
            ((Intent)localObject3).setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
            try
            {
              startActivity((Intent)localObject3);
              localObject1 = "ACTION_HUAWEI_1";
              bool1 = true;
            }
            catch (Exception localException5)
            {
              if (!QLog.isColorLevel()) {
                break label583;
              }
              QLog.e(this.TAG, 2, "openPermissionActivity Exception", localException5);
              bool1 = false;
              continue;
            }
            localObject3 = localObject1;
            bool2 = bool1;
            if (!bool1)
            {
              localObject3 = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
              try
              {
                startActivity((Intent)localObject3);
                localObject3 = "ACTION_HUAWEI_2";
                bool1 = true;
              }
              catch (Exception localException6)
              {
                String str1;
                String str2;
                Object localObject2;
                Object localObject4 = localObject2;
                bool1 = bool3;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e(this.TAG, 2, "openPermissionActivity Exception", localException6);
                localObject4 = localObject2;
                bool1 = bool3;
                continue;
                this.auj += 1;
                this.om = SystemClock.elapsedRealtime();
                return;
              }
              QLog.w(this.TAG, 1, "openPermissionActivity, openSuccess[" + bool1 + "], code[" + (String)localObject3 + "]");
              if (!bool1)
              {
                aqV();
                finish();
                return;
              }
            }
          }
        }
        label557:
        label583:
        bool1 = bool2;
        continue;
      }
      bool1 = bool2;
      continue;
      bool2 = false;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.n)) {
      switch (paramInt)
      {
      }
    }
    while (!paramDialogInterface.equals(this.o))
    {
      return;
      boolean bool = getIntent().getBooleanExtra("is_video", false);
      paramDialogInterface = this.mApp.getCurrentAccountUin();
      ivv.e(paramDialogInterface, ivv.d(paramDialogInterface, bool) + 1, bool);
      finish();
      return;
      if (vC())
      {
        aqU();
        return;
      }
      aqV();
      finish();
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (ivv.ad(this))
      {
        QLog.w(this.TAG, 1, "锁屏中，不弹2");
        finish();
        return;
      }
      long l = Math.abs(SystemClock.elapsedRealtime() - this.om);
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "onClick_help_negative, duration[" + l + "], openPermissionCnt[" + this.auj + "]");
      }
      if ((l < 2000L) || (this.auj >= 2))
      {
        finish();
        return;
      }
      a("clickCancel", this.n);
      return;
    }
    aqV();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    this.mApp = ((VideoAppInterface)super.getAppRuntime());
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.v2q.SmallScreenState");
    registerReceiver(this.mReceiver, paramBundle);
    if (ivv.isFloatWindowOpAllowed(this.mApp.getApp())) {
      finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.mReceiver);
  }
  
  public void onResume()
  {
    super.onResume();
    if (ivv.ad(this))
    {
      QLog.w(this.TAG, 1, "锁屏中，不弹1");
      finish();
      return;
    }
    if (this.n == null)
    {
      b();
      a("onResume.1", this.n);
      return;
    }
    if (!ivv.isFloatWindowOpAllowed(this.mApp.getApp()))
    {
      c();
      a("onResume.1", this.o);
      return;
    }
    QLog.w(this.TAG, 1, "onResume, finish");
    finish();
  }
  
  boolean vD()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("PCKM80"))) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "isSupport, manufacturer[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "], bSupport[" + bool1 + "]");
      }
      return bool1;
      if (Build.MANUFACTURER.equalsIgnoreCase("VIVO"))
      {
        bool1 = bool2;
        if (!Build.MODEL.equalsIgnoreCase("V1838A"))
        {
          bool1 = bool2;
          if (!Build.MODEL.equalsIgnoreCase("V1936A"))
          {
            bool1 = bool2;
            if (Build.MODEL.equalsIgnoreCase("vivo X9s L")) {}
          }
        }
      }
      else if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))
      {
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("H60-L01")) {}
      }
      else if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
      {
        bool1 = bool2;
        if (Build.MODEL.equalsIgnoreCase("MI 5X")) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDialogActivity
 * JD-Core Version:    0.7.0.1
 */