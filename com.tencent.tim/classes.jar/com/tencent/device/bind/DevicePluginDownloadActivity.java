package com.tencent.device.bind;

import aczy;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import aqgv;
import aqha;
import aqju;
import avqq;
import awjb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import rwt;
import syl;
import sym;
import syn;
import tar;

public class DevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private static String TAG = "DevicePluginDownloadActivity";
  public static String aIb = "agent_type";
  private String from = "";
  private Intent intent;
  
  private void bBZ()
  {
    String str;
    if (this.intent.getBooleanExtra("jumpPublicDevice", false)) {
      str = "com.tencent.device.activities.DeviceSquareActivity";
    }
    for (;;)
    {
      awjb.a().a(this, super.getAppRuntime(), super.getAppRuntime().getAccount(), this.intent, str, 0, null, SmartDevicePluginProxyActivity.class);
      return;
      if (this.intent.getIntExtra("public_device", 0) != 0)
      {
        str = "com.tencent.device.activities.DeviceScanActivity";
        this.intent.putExtra("nickname", this.app.getCurrentNickname());
        this.intent.putExtra("bitmap", this.app.a(this.app.getCurrentAccountUin(), (byte)2, false));
      }
      else
      {
        str = "com.tencent.device.activities.DeviceShareConfirmActivity";
      }
    }
  }
  
  private boolean init()
  {
    this.intent = super.getIntent();
    this.from = this.intent.getStringExtra("from");
    if ("connect".equals(this.from))
    {
      String str = this.intent.getStringExtra("qrurl");
      if (!TextUtils.isEmpty(str))
      {
        super.setContentView(2131559218);
        super.setTitle(2131692614);
        super.setLeftViewName(2131692614);
        tar.a().zh(1);
        tar.a().aIF = "";
        tar.a().bAQ = 0;
        int i = this.intent.getIntExtra("entrance", 1);
        tar.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", i);
        DeviceScanner.openDeviceQCodeUrl(this, null, str);
        super.finish();
      }
    }
    do
    {
      do
      {
        return true;
        super.finish();
        return true;
        if (!"share".equals(this.from)) {
          break;
        }
      } while ((TextUtils.isEmpty(this.from)) || (!this.from.equals("share")));
      if (this.intent.getIntExtra(aIb, -1) == 0)
      {
        if (!avqq.a((AppInterface)super.getAppRuntime(), this, this.intent.getBundleExtra("data"), null)) {
          rwt.ez(1, 2131689537);
        }
        super.finish();
        return true;
      }
      this.intent.putExtra("uinname", aqgv.o(this.app, this.intent.getStringExtra("uin")));
      if (awjb.a().cF((QQAppInterface)super.getAppRuntime()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "start SmartDevicePlugin to goshare");
        }
        bBZ();
        super.finish();
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "download install SmartDevicePlugin");
      }
      awjb.a().addObserver(this);
      awjb.a().eDT();
      return true;
      super.setContentView(2131559219);
      super.setTitle(2131692403);
      awjb.a().addObserver(this);
      this.leftView.setText(2131690700);
    } while (awjb.a().cF(this.app));
    awjb.a().eDT();
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 23) {
      if (!aczy.bd(this)) {
        aczy.a(this, 3, new syl(this));
      }
    }
    for (;;)
    {
      return true;
      init();
      continue;
      init();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    awjb.a().deleteObserver(this);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "recv notify : plugin install finished with code " + paramObservable);
      }
      if (paramObservable.intValue() != 0)
      {
        paramObservable = aqha.a(this, 230);
        paramObservable.setNegativeButton(2131721058, new sym(this));
        paramObservable.setPositiveButton(2131692616, new syn(this));
        paramObservable.setTitle(2131692613);
        paramObservable.setMessage(2131692612);
        paramObservable.show();
      }
    }
    else
    {
      return;
    }
    if ("share".equals(this.from)) {
      bBZ();
    }
    for (;;)
    {
      super.finish();
      return;
      paramObservable = new Intent();
      paramObject = super.getIntent();
      paramObservable.putExtra("DevicePID", paramObject.getStringExtra("DevicePID"));
      paramObservable.putExtra("DeviceSN", paramObject.getStringExtra("DeviceSN"));
      paramObservable.putExtra("DeviceToken", paramObject.getStringExtra("DeviceToken"));
      paramObservable.putExtra("DataReportSeq", tar.a().DU);
      awjb.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */