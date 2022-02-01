package cooperation.qqdataline;

import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import aqgv;
import aqiw;
import arhz;
import aurf;
import avfw;
import avil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class DatalineBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private arhz W;
  private avfw a;
  private aurf b;
  private String cKS;
  private long mStartTime;
  private Bundle y;
  
  private boolean aKF()
  {
    if (DatalinePluginProxyActivity.cJ(this))
    {
      if (this.app == null) {
        return false;
      }
      this.a = ((avfw)this.app.getManager(27));
      if (this.a == null)
      {
        abI(-6);
        return false;
      }
      Object localObject1 = this.a.b("qqdataline.apk");
      if ((localObject1 != null) && (((PluginBaseInfo)localObject1).mState != 4)) {
        return false;
      }
      QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] launchPlugin");
      Intent localIntent = new Intent();
      boolean bool1 = this.y.getBoolean("string_from", false);
      boolean bool2 = this.y.getBoolean("string_uin", false);
      long l = this.y.getLong("device_din", 0L);
      int i = this.y.getInt("sTitleID", 0);
      if (bool1) {
        localIntent.addFlags(536870912);
      }
      localIntent.putExtra("string_uin", bool2);
      localIntent.putExtra("device_din", l);
      localIntent.putExtra("sTitleID", i);
      localIntent.putExtra("userQqResources", 2);
      localObject1 = this.app.getAccount();
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
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.app.getAccount();
      }
      DatalinePluginProxyActivity.a(this, (String)localObject2, localIntent, this.cKS, -1, null);
      finish();
      overridePendingTransition(0, 0);
      return true;
    }
    return false;
  }
  
  private void abI(int paramInt)
  {
    QLog.e("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] handleFailed errCode:" + paramInt);
    int i = getResources().getDimensionPixelSize(2131299627);
    String str = acfp.m(2131704618);
    if (-4 == paramInt) {
      str = acfp.m(2131704636);
    }
    for (;;)
    {
      QQToast.a(this.app.getApp(), 1, str, 0).show(i);
      finish();
      return;
      if ((-5 == paramInt) || (-1 == paramInt) || (-3 == paramInt) || (-2 == paramInt)) {
        str = acfp.m(2131704631);
      } else if (-6 == paramInt) {
        str = acfp.m(2131704634);
      }
    }
  }
  
  private void b(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo!");
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
          QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo is no ready and query it");
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
      QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity] queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
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
      this.a.installPlugin("qqdataline.apk");
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
    QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] launchPlugin->");
    Intent localIntent = new Intent();
    boolean bool1 = this.y.getBoolean("string_from", false);
    boolean bool2 = this.y.getBoolean("string_uin", false);
    long l = this.y.getLong("device_din", 0L);
    int i = this.y.getInt("sTitleID", 0);
    if (bool1) {
      localIntent.addFlags(536870912);
    }
    localIntent.putExtra("string_uin", bool2);
    localIntent.putExtra("device_din", l);
    localIntent.putExtra("sTitleID", i);
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
      localIntent.putExtra("userQqResources", 2);
      DatalinePluginProxyActivity.a(this, localException, localIntent, this.cKS, -1, this.W);
      overridePendingTransition(0, 0);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.app.getAccount();
    }
    if (DatalinePluginProxyActivity.cJ(this))
    {
      DatalinePluginProxyActivity.a(this, (String)localObject2, localIntent, this.cKS, -1, null);
      finish();
      overridePendingTransition(0, 0);
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.y = getIntent().getBundleExtra("_param_");
    this.cKS = getIntent().getStringExtra("componetname");
    this.b = new aurf(this);
    if (aKF()) {
      return true;
    }
    this.W = new arhz(this, getResources().getDimensionPixelSize(2131299627));
    this.W.setMessage(acfp.m(2131704632));
    this.W.setOnDismissListener(new avil(this));
    this.b.postDelayed(new DatalineBridgeActivity.2(this), 300L);
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
        QLog.d("DatalineBridgeActivity", 4, "[DatalineBridgeActivity]  ACTION_QUERY!");
      }
      if (!isFinishing()) {
        b("qqdataline.apk", this.a.b("qqdataline.apk"));
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
      QLog.d("QPlugin", 4, "DatalineBridgeActivity onDestroy");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void start()
  {
    this.a = ((avfw)this.app.getManager(27));
    QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    if (this.a == null) {
      abI(-6);
    }
    for (;;)
    {
      return;
      this.mStartTime = System.currentTimeMillis();
      PluginInfo localPluginInfo = this.a.b("qqdataline.apk");
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
          this.W.setMessage(acfp.m(2131704630));
          this.W.show();
        }
        this.b.sendEmptyMessageDelayed(1001, 400L);
        return;
        label124:
        QLog.i("DatalineBridgeActivity", 1, "[DatalineBridgeActivity] onPluginManagerLoaded start down or install...");
        this.a.installPlugin("qqdataline.apk");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqdataline.DatalineBridgeActivity
 * JD-Core Version:    0.7.0.1
 */