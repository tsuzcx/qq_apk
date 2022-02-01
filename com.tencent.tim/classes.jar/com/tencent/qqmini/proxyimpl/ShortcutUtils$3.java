package com.tencent.qqmini.proxyimpl;

import acfp;
import android.app.Activity;
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
import aswu;
import aswu.a;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class ShortcutUtils$3
  implements Runnable
{
  public ShortcutUtils$3(Activity paramActivity, MiniAppInfo paramMiniAppInfo, aswu.a parama) {}
  
  public void run()
  {
    boolean bool = false;
    try
    {
      if (Build.VERSION.SDK_INT < 26) {
        break label347;
      }
      ShortcutManager localShortcutManager = (ShortcutManager)this.val$activity.getSystemService("shortcut");
      if (aswu.isShortcutCreated_O(this.val$miniAppInfo.appId, localShortcutManager))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        arxa.a().showToast(this.val$miniAppInfo.name + "\"快捷方式已存在");
        if (this.a == null) {
          return;
        }
        this.a.onAddResult(0, acfp.m(2131714451));
        return;
      }
      if (localShortcutManager.isRequestPinShortcutSupported())
      {
        Object localObject1 = aswu.b(this.val$activity, this.val$miniAppInfo);
        Object localObject2 = aswu.b(this.val$activity, this.val$miniAppInfo);
        PersistableBundle localPersistableBundle = new PersistableBundle();
        localObject1 = new ShortcutInfo.Builder(this.val$activity, this.val$miniAppInfo.appId).setIcon(Icon.createWithBitmap((Bitmap)localObject2)).setShortLabel(this.val$miniAppInfo.name).setIntent((Intent)localObject1).setExtras(localPersistableBundle).build();
        localObject2 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
        ((Intent)localObject2).putExtra("CONFIG_APPNAME", this.val$miniAppInfo.name);
        bool = localShortcutManager.requestPinShortcut((ShortcutInfo)localObject1, PendingIntent.getBroadcast(this.val$activity, 0, (Intent)localObject2, 134217728).getIntentSender());
      }
      if (!bool)
      {
        aswu.access$200(this.val$activity);
        if (this.a == null) {
          return;
        }
        this.a.onAddResult(1, acfp.m(2131714447));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Shortcut", 1, "doAddShortcut exception!", localThrowable);
      return;
    }
    Thread.sleep(1000L);
    if (aswu.isShortcutCreated_O(this.val$miniAppInfo.appId, localThrowable))
    {
      if (this.a != null) {
        this.a.onAddResult(0, acfp.m(2131714442));
      }
    }
    else if (this.a != null)
    {
      this.a.onAddResult(1, acfp.m(2131714447));
      return;
      label347:
      if (aqml.hasShortCut(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.val$miniAppInfo.name }))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        arxa.a().showToast(this.val$miniAppInfo.name + "\"快捷方式已存在");
        if (this.a != null) {
          this.a.onAddResult(0, acfp.m(2131714439));
        }
      }
      else
      {
        Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent.putExtra("android.intent.extra.shortcut.NAME", this.val$miniAppInfo.name);
        localIntent.putExtra("duplicate", false);
        localIntent.putExtra("android.intent.extra.shortcut.ICON", aswu.b(this.val$activity, this.val$miniAppInfo));
        localIntent.putExtra("android.intent.extra.shortcut.INTENT", aswu.b(this.val$activity, this.val$miniAppInfo));
        this.val$activity.sendBroadcast(localIntent);
        Thread.sleep(1000L);
        if (aqml.hasShortCut(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.val$miniAppInfo.name }))
        {
          arxa.a().showToast("已创建\"" + this.val$miniAppInfo.name + "\"快捷方式到桌面");
          if (this.a != null) {
            this.a.onAddResult(0, acfp.m(2131714441));
          }
        }
        else
        {
          aswu.access$200(this.val$activity);
          if (this.a != null) {
            this.a.onAddResult(1, acfp.m(2131714450));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.3
 * JD-Core Version:    0.7.0.1
 */