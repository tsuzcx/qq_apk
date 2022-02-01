package com.tencent.open.applist;

import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import arvm;
import arwt;
import auru;
import avfw;
import avfw.d;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import cooperation.plugin.PluginInfo;
import cooperation.qappcenter.QAppCenterPluginProxyActivityQzone;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;

public class QZoneAppListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private View Kg;
  private auru jdField_a_of_type_Auru;
  private avfw jdField_a_of_type_Avfw;
  private TextView acZ;
  private int elb;
  
  private String Dt()
  {
    switch (this.elb)
    {
    default: 
      return null;
    case 1: 
      return "com.tencent.plugin.qappcenter.QZoneAppListActivity";
    case 2: 
      return "com.tencent.plugin.qappcenter.QZoneAppWebViewActivity";
    case 3: 
      return "com.tencent.plugin.qappcenter.QZoneAppWebViewActivity";
    case 4: 
      return "com.tencent.plugin.qappcenter.QZoneAppWebViewActivity";
    case 5: 
      return "com.tencent.plugin.qappcenter.WebAppActivity";
    case 6: 
      return "com.tencent.plugin.qappcenter.AppCenterMainActivity";
    case 7: 
      return "com.tencent.plugin.qappcenter.AppCenterAppDetailActivity";
    case 8: 
      return "com.tencent.plugin.qappcenter.AppCenterSearchActivity";
    }
    return "com.tencent.plugin.qappcenter.AppCenterBrowserActivity";
  }
  
  private void elN()
  {
    avfw.d locald = new avfw.d(1);
    locald.mPluginID = "qappcenter_plugin.apk";
    locald.mPluginName = acfp.m(2131712996);
    locald.mUin = this.app.getCurrentAccountUin();
    locald.cKu = Dt();
    Intent localIntent1 = getIntent();
    if (localIntent1 != null) {
      if (localIntent1.getIntExtra("process_id", -1) == 2) {
        locald.K = QAppCenterPluginProxyActivityQzone.class;
      }
    }
    for (;;)
    {
      arwt.i("GHOST", "[launchPlugin] class:" + locald.K);
      Intent localIntent2 = new Intent();
      localIntent2.putExtra("userQqResources", 2);
      if ((localIntent1 != null) && (localIntent1.getExtras() != null)) {
        localIntent2.putExtras(localIntent1.getExtras());
      }
      locald.mIntent = localIntent2;
      avfw.a(this, locald);
      finish();
      return;
      locald.K = QAppCenterPluginProxyActivityTools.class;
      continue;
      locald.K = QAppCenterPluginProxyActivityTools.class;
    }
  }
  
  private void initPlugin()
  {
    PluginInfo localPluginInfo = this.jdField_a_of_type_Avfw.b("qappcenter_plugin.apk");
    int j = 0;
    int i;
    if (localPluginInfo != null)
    {
      if (localPluginInfo.mState != 4) {
        break label43;
      }
      i = 1;
    }
    while (i == 0)
    {
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(1, 400L);
      return;
      label43:
      i = j;
      if (localPluginInfo.mState != 1)
      {
        this.jdField_a_of_type_Avfw.installPlugin("qappcenter_plugin.apk", new arvm(this));
        i = j;
      }
    }
    this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(5, 0L);
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_Avfw.isReady()) {
        this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(1, 400L);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "handlePluginInfo:" + paramPluginBaseInfo.mState);
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      return;
    case -2: 
      this.jdField_a_of_type_Auru.sendEmptyMessage(4);
      return;
    case 0: 
      this.jdField_a_of_type_Avfw.installPlugin("qappcenter_plugin.apk");
      return;
    case 1: 
    case 2: 
      int i = (int)(paramPluginBaseInfo.mDownloadProgress * 90.0F);
      this.jdField_a_of_type_Auru.obtainMessage(2, i, 0).sendToTarget();
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(1, 400L);
      return;
    case 3: 
      this.jdField_a_of_type_Auru.sendEmptyMessage(3);
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(1, 400L);
      return;
    case 5: 
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(1, 400L);
      return;
    }
    updateProgress(100);
    elN();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167595);
    setContentView(2131559857);
    this.acZ = ((TextView)findViewById(2131373659));
    this.acZ.setText("0%");
    this.Kg = findViewById(2131372274);
    setTitle(2131697524);
    updateAppRuntime();
    this.jdField_a_of_type_Avfw = ((avfw)this.app.getManager(27));
    this.jdField_a_of_type_Auru = new auru(this);
    if (DownloadSDKConfigManager.canGotoNewAppListPage()) {}
    for (int i = 6;; i = 1)
    {
      DownloadSDKConfigManager.refreshNewAppCenterConfig();
      this.elb = getIntent().getIntExtra("goto_type", i);
      arwt.i("GHOST", "[doOnCreate] mGotoType:" + this.elb);
      initPlugin();
      return true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = 99;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!isFinishing())
      {
        a("qappcenter_plugin.apk", this.jdField_a_of_type_Avfw.b("qappcenter_plugin.apk"));
        continue;
        updateProgress(paramMessage.arg1);
        continue;
        try
        {
          i = Integer.valueOf(this.acZ.getText().toString()).intValue();
          if (i < 99)
          {
            i = j;
            updateProgress(i);
          }
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("IphoneTitleBarActivity", 2, "handleMessage Exception:", paramMessage);
            }
            int i = 0;
            continue;
            i += 1;
          }
        }
        elN();
      }
    }
  }
  
  public void updateProgress(int paramInt)
  {
    runOnUiThread(new QZoneAppListActivity.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.applist.QZoneAppListActivity
 * JD-Core Version:    0.7.0.1
 */