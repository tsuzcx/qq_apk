package cooperation.qlink;

import acfp;
import ahau;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import aqgv;
import aqha;
import aqiw;
import aqju;
import arhz;
import aurf;
import avfw;
import avhm;
import avhn;
import avho;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class QlinkBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private arhz W;
  private avfw a;
  private Bundle aX;
  private aurf b;
  private int mFrom;
  private long mStartTime;
  
  private boolean aKF()
  {
    boolean bool = false;
    if (QlinkPluginProxyActivity.cI(this))
    {
      Intent localIntent = avho.E();
      Bundle localBundle = new Bundle();
      localBundle.putInt("string_from", this.mFrom);
      if (this.aX != null) {
        localBundle.putAll(this.aX);
      }
      localIntent.putExtra("string_bundle", localBundle);
      localBundle.putString("_SELF_NICK_", aqgv.o(this.app, this.app.getAccount()));
      QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, null);
      finish();
      overridePendingTransition(0, 0);
      bool = true;
    }
    return bool;
  }
  
  private void abI(int paramInt)
  {
    QLog.e("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] handleFailed errCode:" + paramInt);
    int i = getResources().getDimensionPixelSize(2131299627);
    String str = acfp.m(2131711289);
    if (-4 == paramInt) {
      str = acfp.m(2131711290);
    }
    for (;;)
    {
      QQToast.a(this.app.getApp(), 1, str, 0).show(i);
      finish();
      return;
      if ((-5 == paramInt) || (-1 == paramInt) || (-3 == paramInt) || (-2 == paramInt)) {
        str = acfp.m(2131711291);
      } else if (-6 == paramInt) {
        str = acfp.m(2131711293);
      }
    }
  }
  
  private void b(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo!");
    }
    int i = 0;
    if (System.currentTimeMillis() - this.mStartTime > 30000L) {
      i = 1;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.a.isReady())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          abI(-5);
          return;
        }
        this.b.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      abI(-1);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity] queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!aqiw.isNetworkAvailable(getApplicationContext())) && (System.currentTimeMillis() - this.mStartTime > 5000L))
    {
      abI(-4);
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    default: 
      abI(-3);
      return;
    case -1: 
      abI(-6);
      return;
    case 0: 
      this.a.installPlugin("qlink_plugin.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        abI(-5);
        return;
      }
      this.b.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (i != 0)
      {
        abI(-5);
        return;
      }
      this.b.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 4: 
      elN();
      return;
    }
    abI(-2);
  }
  
  private void elN()
  {
    QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] launchPlugin mFrom:" + this.mFrom);
    Intent localIntent = avho.E();
    Bundle localBundle = new Bundle();
    localBundle.putInt("string_from", this.mFrom);
    if (this.aX != null) {
      localBundle.putAll(this.aX);
    }
    if (this.app == null) {
      return;
    }
    Object localObject1 = this.app.getAccount();
    try
    {
      localObject2 = aqgv.s(this.app, this.app.getAccount());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
      }
      QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, this.W);
      overridePendingTransition(0, 0);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.app.getAccount();
    }
    localBundle.putString("_SELF_NICK_", (String)localObject2);
    localIntent.putExtra("string_bundle", localBundle);
    if (QlinkPluginProxyActivity.cI(this))
    {
      QlinkPluginProxyActivity.a(this, this.app.getAccount(), localIntent, 0, null);
      finish();
      overridePendingTransition(0, 0);
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.doOnCreate(paramBundle);
    this.mFrom = getIntent().getIntExtra("_from_", 0);
    this.aX = getIntent().getBundleExtra("_param_");
    this.b = new aurf(this);
    if (BaseApplication.getContext().getSharedPreferences("QlinkResistTerrorist", 0).getInt("QlinkResistTerrorist_res", 0) == 1)
    {
      ahau.JH("0X8005392");
      if (QLog.isColorLevel()) {
        QLog.e("QlinkBridgeActivity", 2, "[QLINK] QQ - startQlink failed because of QlinkResistTerrorist_res is 1!!!");
      }
      paramBundle = new avhm(this);
      aqha.a(this, 233, getString(2131700492), getString(2131700517), 2131700491, 2131700491, paramBundle, null).show();
      bool = false;
    }
    while (aKF()) {
      return bool;
    }
    this.W = new arhz(this, getResources().getDimensionPixelSize(2131299627));
    this.W.setMessage(acfp.m(2131711288));
    this.W.setOnDismissListener(new avhn(this));
    this.b.postDelayed(new QlinkBridgeActivity.3(this), 300L);
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("QlinkBridgeActivity", 4, "[QlinkBridgeActivity]  ACTION_QUERY!");
      }
      if (!isFinishing()) {
        b("qlink_plugin.apk", this.a.b("qlink_plugin.apk"));
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.W != null)
    {
      this.W.dismiss();
      this.W = null;
    }
    if (this.b != null) {
      this.b.removeMessages(1001);
    }
    if ((this.a == null) || (QLog.isDevelopLevel())) {
      QLog.d("QPlugin", 4, "QlinkBridgeActivity onDestroy");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void start()
  {
    this.a = ((avfw)this.app.getManager(27));
    QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    if (this.a == null) {
      abI(-6);
    }
    for (;;)
    {
      return;
      this.mStartTime = System.currentTimeMillis();
      PluginInfo localPluginInfo = this.a.b("qlink_plugin.apk");
      int j = 0;
      int i = j;
      if (localPluginInfo != null)
      {
        if (localPluginInfo.mState != 4) {
          break label124;
        }
        elN();
      }
      for (i = 1; i == 0; i = j)
      {
        if (this.W != null)
        {
          this.W.setMessage(acfp.m(2131711292));
          this.W.show();
        }
        this.b.sendEmptyMessageDelayed(1001, 400L);
        return;
        label124:
        QLog.i("QlinkBridgeActivity", 1, "[QlinkBridgeActivity] onPluginManagerLoaded start down or install...");
        this.a.installPlugin("qlink_plugin.apk");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qlink.QlinkBridgeActivity
 * JD-Core Version:    0.7.0.1
 */