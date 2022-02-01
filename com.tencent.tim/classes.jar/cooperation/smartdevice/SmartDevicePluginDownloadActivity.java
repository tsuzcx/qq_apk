package cooperation.smartdevice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqiw;
import arhz;
import awjb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.Observable;
import java.util.Observer;

public class SmartDevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
{
  private static String TAG = "SmartDevicePluginDownloadActivity";
  arhz X = null;
  protected Button aH;
  TextView mTextView = null;
  LinearLayout mo = null;
  
  private void eDR()
  {
    if (this.X == null)
    {
      this.X = new arhz(this, super.getResources().getDimensionPixelSize(2131299627));
      this.X.setMessage(2131721063);
    }
    this.X.show();
  }
  
  private void eDS()
  {
    if ((this.X != null) && (this.X.isShowing()))
    {
      this.X.cancel();
      this.X = null;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_OPENAV_RECEIVE", false))
    {
      paramBundle = getIntent();
      awjb.a().a(this, this.app, this.app.getAccount(), paramBundle, "com.tencent.device.activities.openav.OpenAVActivity", -1, null, SmartDevicePluginProxyActivity.class);
      finish();
      return false;
    }
    super.setContentView(2131559217);
    super.setTitle(2131692403);
    awjb.a().addObserver(this);
    this.leftView.setText(2131690700);
    this.aH = ((Button)super.findViewById(2131365814));
    this.aH.setOnClickListener(this);
    this.mo = ((LinearLayout)super.findViewById(2131365811));
    this.mTextView = ((TextView)super.findViewById(2131371994));
    if (!aqiw.isWifiConnected(this.app.getApp())) {
      this.mo.setVisibility(0);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    awjb.a().deleteObserver(this);
  }
  
  public void onClick(View paramView)
  {
    this.mo.setVisibility(4);
    if (!awjb.a().cF(this.app))
    {
      eDR();
      awjb.a().eDT();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nickname", this.app.getCurrentNickname());
    localIntent.putExtra("bitmap", this.app.a(this.app.getCurrentAccountUin(), (byte)2, false));
    localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
    String str1 = "com.tencent.device.activities.DeviceSearchActivity";
    str2 = str1;
    try
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
      str2 = str1;
      boolean bool = ((SharedPreferences)localObject).getBoolean("enable_public_device_" + this.app.getCurrentAccountUin(), true);
      str2 = str1;
      String str3 = ((SharedPreferences)localObject).getString("square_url_" + this.app.getCurrentAccountUin(), "");
      if (bool) {
        str1 = "com.tencent.device.activities.DeviceSquareActivity";
      }
      str2 = str1;
      if (!TextUtils.isEmpty(str3))
      {
        str2 = str1;
        localIntent.putExtra("url", str3);
      }
      str2 = str1;
      bool = ((SharedPreferences)localObject).getBoolean("search_device_enable_https_" + this.app.getCurrentAccountUin(), false);
      localObject = str1;
      str2 = str1;
      if (VersionUtils.isIceScreamSandwich())
      {
        localObject = str1;
        if (bool)
        {
          str2 = str1;
          localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
          localObject = str1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str2;
      }
    }
    awjb.a().a(this, this.app, this.app.getAccount(), localIntent, (String)localObject, 0, null, SmartDevicePluginProxyActivity.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "recv notify : plugin install finished with code " + paramObservable);
      }
      eDS();
      if (paramObservable.intValue() != 0)
      {
        this.mTextView.setText(2131692941);
        this.mo.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */