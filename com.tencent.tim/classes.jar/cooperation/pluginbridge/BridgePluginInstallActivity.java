package cooperation.pluginbridge;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import anot;
import auru;
import avfw;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;

public class BridgePluginInstallActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnPluginInstallListener, Runnable
{
  private avfw a;
  private Handler mHandler = new auru(this);
  private Intent mIntent;
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "doOnCreate.");
    }
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      this.mHandler.sendEmptyMessageDelayed(3, 10000L);
      return false;
    }
    this.mIntent = getIntent();
    this.a = ((avfw)this.app.getManager(27));
    setContentView(2131558790);
    setTitle(this.mIntent.getStringExtra("distPluginName"));
    setContentBackgroundResource(2130838900);
    ThreadManager.post(this, 8, null, false);
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2: 
      do
      {
        return false;
      } while (isFinishing());
      boolean bool = this.a.isPlugininstalled("BridgePlugin.apk");
      if (QLog.isColorLevel()) {
        QLog.i("BridgePluginInstallActivity", 2, "Bridge plugin installed:" + bool);
      }
      if (bool)
      {
        paramMessage = this.mIntent.getStringExtra("distParamsString");
        String str1 = this.mIntent.getStringExtra("distPluginId");
        String str2 = this.mIntent.getStringExtra("distPluginName");
        try
        {
          BridgeHelper.b(this, this.app, this.mIntent, paramMessage, str1, str2);
          this.mHandler.sendEmptyMessageDelayed(3, 10000L);
          return false;
        }
        catch (Exception paramMessage)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BridgePluginInstallActivity", 2, "launchBridgePlugin fail.", paramMessage);
          }
          this.mHandler.sendEmptyMessage(4);
          return false;
        }
      }
      this.a.installPlugin("BridgePlugin.apk", this);
      return false;
    case 3: 
      finish();
      return false;
    }
    QQToast.a(getApplicationContext(), 2131697008, 0);
    anot.a(this.app, "P_CliOper", "BridgePlatform", "", "start_bridge_plugin", "BridgePlugin.apk", 0, -1, "", "", "", "");
    finish();
    return false;
  }
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallBegin.");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallDownloadProgress.offset:" + paramInt1 + ",total:" + paramInt2);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallError.pluginId:" + paramString + ". errorCode:" + paramInt);
    }
    this.mHandler.sendEmptyMessage(4);
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "onInstallFinish.");
    }
    this.mHandler.sendEmptyMessage(2);
  }
  
  public void run()
  {
    PluginInfo localPluginInfo = null;
    int i = 0;
    for (;;)
    {
      if (i < 300)
      {
        localPluginInfo = this.a.b("BridgePlugin.apk");
        if ((localPluginInfo == null) && (!this.a.isReady())) {}
        try
        {
          Thread.sleep(100L);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("BridgePluginInstallActivity", 2, "pluginInfo:" + localPluginInfo);
    }
    if (localPluginInfo == null)
    {
      if (this.a.isReady())
      {
        if (QLog.isColorLevel()) {
          QLog.i("BridgePluginInstallActivity", 2, "fail to load plugin.");
        }
        this.mHandler.sendEmptyMessage(4);
      }
      return;
    }
    this.mHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.pluginbridge.BridgePluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */