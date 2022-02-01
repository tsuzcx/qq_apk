package com.tencent.mobileqq.mini.appbrand.utils;

import acfp;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import aqml;
import arxa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.qphone.base.util.QLog;

final class ShortcutUtils$3
  implements Runnable
{
  ShortcutUtils$3(BaseActivity paramBaseActivity, ApkgInfo paramApkgInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback) {}
  
  public void run()
  {
    boolean bool = false;
    try
    {
      if (Build.VERSION.SDK_INT < 26) {
        break label347;
      }
      ShortcutManager localShortcutManager = (ShortcutManager)this.val$activity.getSystemService("shortcut");
      if (ShortcutUtils.isShortcutCreated_O(this.val$apkgInfo.appId, localShortcutManager))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        arxa.a().showToast(this.val$apkgInfo.apkgName + "\"快捷方式已存在");
        if (this.val$callback == null) {
          return;
        }
        this.val$callback.onAddResult(0, acfp.m(2131714451));
        return;
      }
      if (localShortcutManager.isRequestPinShortcutSupported())
      {
        Object localObject1 = ShortcutUtils.access$000(this.val$activity, this.val$apkgInfo);
        Object localObject2 = ShortcutUtils.access$100(this.val$activity, this.val$apkgInfo);
        PersistableBundle localPersistableBundle = new PersistableBundle();
        localObject1 = new ShortcutInfo.Builder(this.val$activity, this.val$apkgInfo.appId).setIcon(Icon.createWithBitmap((Bitmap)localObject2)).setShortLabel(this.val$apkgInfo.apkgName).setIntent((Intent)localObject1).setExtras(localPersistableBundle).build();
        localObject2 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
        ((Intent)localObject2).putExtra("CONFIG_APPNAME", this.val$apkgInfo.apkgName);
        bool = localShortcutManager.requestPinShortcut((ShortcutInfo)localObject1, PendingIntent.getBroadcast(this.val$activity, 0, (Intent)localObject2, 134217728).getIntentSender());
      }
      if (!bool)
      {
        ShortcutUtils.access$200(this.val$activity);
        if (this.val$callback == null) {
          return;
        }
        this.val$callback.onAddResult(1, acfp.m(2131714447));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Shortcut", 1, "doAddShortcut exception!", localThrowable);
      return;
    }
    Thread.sleep(1000L);
    if (ShortcutUtils.isShortcutCreated_O(this.val$apkgInfo.appId, localThrowable))
    {
      if (this.val$callback != null) {
        this.val$callback.onAddResult(0, acfp.m(2131714442));
      }
    }
    else if (this.val$callback != null)
    {
      this.val$callback.onAddResult(1, acfp.m(2131714447));
      return;
      label347:
      if (aqml.hasShortCut(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.val$apkgInfo.apkgName }))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        arxa.a().showToast(this.val$apkgInfo.apkgName + "\"快捷方式已存在");
        if (this.val$callback != null) {
          this.val$callback.onAddResult(0, acfp.m(2131714439));
        }
      }
      else
      {
        Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent.putExtra("android.intent.extra.shortcut.NAME", this.val$apkgInfo.apkgName);
        localIntent.putExtra("duplicate", false);
        localIntent.putExtra("android.intent.extra.shortcut.ICON", ShortcutUtils.access$100(this.val$activity, this.val$apkgInfo));
        localIntent.putExtra("android.intent.extra.shortcut.INTENT", ShortcutUtils.access$000(this.val$activity, this.val$apkgInfo));
        this.val$activity.sendBroadcast(localIntent);
        Thread.sleep(1000L);
        if (aqml.hasShortCut(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.val$apkgInfo.apkgName }))
        {
          arxa.a().showToast("已创建\"" + this.val$apkgInfo.apkgName + "\"快捷方式到桌面");
          if (this.val$callback != null) {
            this.val$callback.onAddResult(0, acfp.m(2131714441));
          }
        }
        else
        {
          ShortcutUtils.access$200(this.val$activity);
          if (this.val$callback != null) {
            this.val$callback.onAddResult(1, acfp.m(2131714450));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.3
 * JD-Core Version:    0.7.0.1
 */