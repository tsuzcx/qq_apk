package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import aqed;
import aqju;
import aqlh;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import veo;
import vep;
import ver;
import ves;

public class KeepAliveGuideActivity
  extends IphoneTitleBarActivity
{
  private int bHQ = 1;
  private String currentUin = "";
  private View tw;
  private View tx;
  
  private void bQl()
  {
    bool = true;
    Activity localActivity = getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = localActivity.getPackageManager().getPackageInfo("com.miui.powerkeeper", 1);
        if (localPackageInfo == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        bool = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "checkForMIUIGodMode|support=" + bool);
      }
      if (!bool) {
        break;
      }
      localActivity.runOnUiThread(new KeepAliveGuideActivity.3(this));
      return;
      bool = false;
    }
  }
  
  private void bQm()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
    localIntent.putExtra("package_name", "com.tencent.tim");
    localIntent.putExtra("package_label", "TIM");
    try
    {
      superStartActivityForResult(localIntent, -1, null);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        bQn();
      } while (!QLog.isColorLevel());
      QLog.d("IphoneTitleBarActivity", 2, localException, new Object[0]);
    }
  }
  
  private void bQn()
  {
    aqlh localaqlh = new aqlh(getActivity(), 2131756467);
    localaqlh.setContentView(2131559153);
    localaqlh.setTitle(2131695170);
    localaqlh.a(2131695168);
    localaqlh.a(0, 0, null);
    localaqlh.a(2131694716, new ver(this));
    localaqlh.setCanceledOnTouchOutside(false);
    localaqlh.setCancelable(false);
    localaqlh.show();
  }
  
  private void bQo()
  {
    ((TextView)findViewById(2131380929)).setText(aqed.BP());
    ((TextView)findViewById(2131380928)).setText(aqed.BQ());
  }
  
  private void bQp()
  {
    aqed.e(this, this.app);
  }
  
  private void bQq()
  {
    aqed.f(this, this.app);
  }
  
  private void initUI()
  {
    this.tw = findViewById(2131372668);
    this.tw.setOnClickListener(new veo(this));
    this.tx = findViewById(2131372669);
    this.tx.setOnClickListener(new vep(this));
  }
  
  public void doOnBackPressed()
  {
    if (this.bHQ == 0)
    {
      aqju localaqju = new aqju(getActivity(), 2131756467);
      localaqju.setContentView(2131559151);
      localaqju.getTitleTextView().setVisibility(8);
      localaqju.setMessage(2131695164);
      localaqju.setPositiveButton(2131695167, new ves(this));
      localaqju.setCanceledOnTouchOutside(false);
      localaqju.setCancelable(false);
      localaqju.show();
      return;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558492);
    setTitle(2131696668);
    if (this.app != null) {
      this.currentUin = this.app.getCurrentAccountUin();
    }
    initUI();
    bQo();
    this.bHQ = getIntent().getIntExtra("GUIDE_FIRST_RUN", 1);
    return true;
  }
  
  public String setLastActivityName()
  {
    return getString(2131696668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KeepAliveGuideActivity
 * JD-Core Version:    0.7.0.1
 */