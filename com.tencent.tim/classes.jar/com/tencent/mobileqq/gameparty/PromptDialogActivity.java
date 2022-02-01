package com.tencent.mobileqq.gameparty;

import ahvn;
import anan;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import aqha;
import aqju;
import aqlr;
import arts;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PromptDialogActivity
  extends BaseActivity
  implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, View.OnClickListener
{
  SharedPreferences S = null;
  private String appid = "";
  aqju aw = null;
  aqju ax = null;
  private String bLQ = "";
  private String bLR = "";
  private String downloadUrl = "";
  private URLImageView g;
  private Button gn;
  private Button go;
  private String packageName = "";
  private TextView summary;
  private TextView title;
  
  private void H(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    anan localanan = new anan();
    j = 268435456;
    try
    {
      k = Integer.parseInt(paramString4);
      if ((k & 0x4000000) != 67108864) {
        break label98;
      }
      j = 335544320;
    }
    catch (Exception paramString4)
    {
      for (;;)
      {
        int k;
        int i;
        continue;
        j = 268435456;
      }
    }
    i = j;
    if ((k & 0x20000000) == 536870912) {
      i = j | 0x20000000;
    }
    j = i;
    if ((k & 0x400000) == 4194304) {
      j = i | 0x400000;
    }
    localanan.a(this.app, this, paramString1, paramString2, paramString3, j);
  }
  
  @TargetApi(16)
  private void dqs()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)super.getSystemService("keyguard");
      if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
      {
        boolean bool = localKeyguardManager.isKeyguardSecure();
        if (bool) {
          return;
        }
      }
      super.startActivity(new Intent(super.getApplicationContext(), QQLSUnlockActivity.class));
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  private void eQ(boolean paramBoolean)
  {
    if (isAppInstalled(this, this.packageName))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PromptDialogActivity", 2, "startGame directStart = " + paramBoolean + ", app installed");
      }
      Object localObject = (ahvn)this.app.getManager(156);
      ((ahvn)localObject).dqr();
      ((ahvn)localObject).a("https://openmobile.qq.com/gameteam/start_game?uin=" + this.app.getCurrentAccountUin(), null);
      if (paramBoolean) {}
      for (localObject = this.bLR;; localObject = String.format("platform=qq_m&current_uin=$OPID$&launchfrom=&gamedata=%s&platformdata=&openid=$OPID$&atoken=$AT$&ptoken=$PT$", new Object[] { this.bLQ }))
      {
        if (aqlr.isScreenLocked(super.getApplicationContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PromptDialogActivity", 2, "startGame screen is locked, need unlock");
          }
          dqs();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PromptDialogActivity", 2, "startGame launch Game now");
        }
        H(this.appid, (String)localObject, this.packageName, "0");
        arts.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2036", "0", false);
        finish();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PromptDialogActivity", 2, "startGame directStart = " + paramBoolean + ", app not installed");
    }
    this.aw = aqha.a(this, 230);
    this.aw.setTitle(this.app.getApp().getString(2131694227));
    this.aw.setMessage(this.app.getApp().getString(2131694224));
    this.aw.setPositiveButton(this.app.getApp().getString(2131694226), this);
    this.aw.setNegativeButton(this.app.getApp().getString(2131694225), this);
    this.aw.setOnCancelListener(this);
    this.aw.show();
    arts.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2036", "1", false);
    arts.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2039", "0", false);
  }
  
  private boolean isAppInstalled(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString.trim(), 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject = super.getIntent();
    if (localObject == null)
    {
      finish();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PromptDialogActivity", 2, "doOnCreate start");
    }
    super.doOnCreate(paramBundle);
    this.appid = ((Intent)localObject).getStringExtra("appid");
    paramBundle = ((Intent)localObject).getStringExtra("packageName");
    int i = paramBundle.indexOf('|');
    if ((i < 0) || (i >= paramBundle.length() - 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PromptDialogActivity", 2, "doOnCreate split packageName and downloadUrl failed");
      }
      finish();
      return false;
    }
    this.packageName = paramBundle.substring(0, i);
    this.downloadUrl = paramBundle.substring(i + 1, paramBundle.length());
    if ((TextUtils.isEmpty(this.appid)) || (TextUtils.isEmpty(this.packageName)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PromptDialogActivity", 2, "doOnCreate appid or packageName is empty");
      }
      finish();
      return false;
    }
    if (((Intent)localObject).getBooleanExtra("direct_start", false))
    {
      this.bLR = ((Intent)localObject).getStringExtra("paramsStr");
      eQ(true);
      return true;
    }
    String str1 = ((Intent)localObject).getStringExtra("title");
    String str2 = ((Intent)localObject).getStringExtra("summary");
    paramBundle = ((Intent)localObject).getStringExtra("picUrl");
    this.bLQ = ((Intent)localObject).getStringExtra("gamedata");
    ((Intent)localObject).getBooleanExtra("leader", false);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(1024);
    setContentView(2131559381);
    this.gn = ((Button)findViewById(2131368812));
    this.go = ((Button)findViewById(2131378694));
    this.gn.setOnClickListener(this);
    this.go.setOnClickListener(this);
    this.g = ((URLImageView)findViewById(2131368698));
    this.title = ((TextView)findViewById(2131379769));
    this.summary = ((TextView)findViewById(2131379009));
    this.title.setText(str1);
    this.summary.setText(str2);
    try
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = super.getResources().getDimensionPixelSize(2131297408);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = super.getResources().getDimensionPixelSize(2131297407);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = super.getResources().getDrawable(2130839310);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130839310);
      paramBundle = URLDrawable.getDrawable(paramBundle, (URLDrawable.URLDrawableOptions)localObject);
      this.g.setImageDrawable(paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        this.g.setImageDrawable(super.getResources().getDrawable(2130839310));
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface == this.ax) {
      if (paramInt == 1)
      {
        eQ(true);
        paramDialogInterface.dismiss();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 0);
        paramDialogInterface.dismiss();
        finish();
        return;
      } while (paramDialogInterface != this.aw);
      if (paramInt == 1)
      {
        arts.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2041", "0", false);
        if (aqlr.isScreenLocked(super.getApplicationContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PromptDialogActivity", 2, "on click download button, need unlock screen");
          }
          dqs();
        }
        if (!TextUtils.isEmpty(this.downloadUrl))
        {
          Intent localIntent = new Intent(this, QQBrowserActivity.class);
          localIntent.putExtra("url", this.downloadUrl);
          startActivity(localIntent);
        }
        for (;;)
        {
          paramDialogInterface.dismiss();
          finish();
          return;
          if (QLog.isColorLevel()) {
            QLog.d("PromptDialogActivity", 2, "on click download button, download url is empty");
          }
        }
      }
    } while (paramInt != 0);
    arts.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2040", "0", false);
    paramDialogInterface.dismiss();
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      arts.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2046", "0", false);
      finish();
      continue;
      arts.a().a(this.app.getCurrentAccountUin(), "", "", "2000", "2045", "0", false);
      eQ(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.PromptDialogActivity
 * JD-Core Version:    0.7.0.1
 */