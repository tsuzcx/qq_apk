package cooperation.qzone;

import acfp;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import arxa;
import avpw;
import avqf;
import avxl;
import avxr.a;
import avyh;
import avyi;
import avyi.a;
import avyo;
import avyq;
import avzf;
import awed;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.util.NetworkState;
import jqc;

public class QZoneLiveVideoDownLoadActivtyV2
  extends QZoneLiveVideoBaseDownLoadActivty
  implements avyi.a
{
  avxl b;
  
  private PluginBaseInfo a(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return null;
    }
    PluginBaseInfo localPluginBaseInfo = new PluginBaseInfo();
    localPluginBaseInfo.mState = paramPluginRecord.state;
    localPluginBaseInfo.mDownloadProgress = paramPluginRecord.progress;
    localPluginBaseInfo.mVersion = String.valueOf(paramPluginRecord.ver);
    localPluginBaseInfo.mID = paramPluginRecord.id;
    return localPluginBaseInfo;
  }
  
  protected String Ge()
  {
    return "qzone_live_video_plugin_hack.apk";
  }
  
  public void a(avxl paramavxl)
  {
    if (paramavxl == null)
    {
      avyi.a(this, this);
      return;
    }
    QQAppInterface localQQAppInterface2 = (QQAppInterface)getAppRuntime();
    QQAppInterface localQQAppInterface1 = localQQAppInterface2;
    if (localQQAppInterface2 == null)
    {
      QLog.i("QZoneLiveVideoDownLoadActivtyV2", 1, "onQzonePluginClientReady: getAppRuntime return null.");
      localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (localQQAppInterface1 != null) {
      avyq.a().setAppInterface(localQQAppInterface1);
    }
    this.b = paramavxl;
    paramavxl = this.b.a("qzone_live_video_plugin_hack.apk");
    if (paramavxl != null)
    {
      if (paramavxl.state == 4)
      {
        eBz();
        return;
      }
      if (paramavxl.state == 2) {
        try
        {
          this.b.a("qzone_live_video_plugin_hack.apk", null, this.mMode);
          return;
        }
        catch (RemoteException paramavxl)
        {
          QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, paramavxl, new Object[0]);
          return;
        }
      }
      QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "QZoneLiveVideo has not installed");
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 7, this.mMode + "");
      if ((3 == this.mMode) && (!TextUtils.isEmpty(this.mBackupUrl)) && (jqc.isValidUrl(this.mBackupUrl)))
      {
        paramavxl = this.mBackupUrl + "&stayin=1";
        QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "watch mode, jump to H5, " + paramavxl);
        avpw.forwardToBrowser(this, paramavxl, -1, null, null);
        if (avyh.aLU()) {
          installPluginSilence();
        }
        cw();
        return;
      }
      if (1 == this.mMode) {
        LpReportInfo_dc00321.report(8, 128, 3, false, false, null);
      }
      int i = NetworkState.getNetworkType();
      QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "network type = " + i);
      if ((1 == i) || (4 == i) || (5 == i) || (3 == i))
      {
        installPlugin();
        return;
      }
      paramavxl = Message.obtain();
      paramavxl.what = 1000;
      paramavxl.arg1 = 1;
      this.mHandler.sendMessage(paramavxl);
      return;
    }
    installPlugin();
    arxa.a().showToast(acfp.m(2131713144));
    cw();
  }
  
  protected boolean a(PluginBaseInfo paramPluginBaseInfo)
  {
    boolean bool = super.a(paramPluginBaseInfo);
    if (!bool)
    {
      installPlugin();
      this.mHandler.sendEmptyMessageDelayed(1005, 500L);
    }
    return bool;
  }
  
  protected void cancelInstall()
  {
    super.cancelInstall();
    if (QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadCanceledOnCloseBtn", 0) == 1) {
      this.b.tB("qzone_live_video_plugin_hack.apk");
    }
    awed.ad(this.account, "live_video_entry", "9", null);
  }
  
  protected void eBA()
  {
    if ((this.mMode == 1) && (!avyo.cV(BaseApplicationImpl.getContext())) && (this.b != null)) {
      try
      {
        this.b.a(new avqf(this), 1);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
        return;
      }
    }
    eBy();
  }
  
  protected void eBy()
  {
    super.eBy();
    if ((this.mMode != 1) && (!avyo.cV(BaseApplicationImpl.getContext())) && (this.b != null)) {}
    try
    {
      this.b.a(null, 3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
    }
  }
  
  protected void handleDownloadPlugin(PluginBaseInfo paramPluginBaseInfo)
  {
    super.handleDownloadPlugin(paramPluginBaseInfo);
    if (paramPluginBaseInfo.mState == 2)
    {
      if (avyo.isProcessExist("com.tencent.mobileqq:qzonelive"))
      {
        avzf.a().a("cmd.killLiveVideo", new Bundle(), false);
        new Handler().postDelayed(new QZoneLiveVideoDownLoadActivtyV2.1(this, paramPluginBaseInfo), 500L);
      }
    }
    else {
      return;
    }
    try
    {
      this.b.a(paramPluginBaseInfo.mID, null, this.mMode);
      return;
    }
    catch (RemoteException paramPluginBaseInfo)
    {
      paramPluginBaseInfo.printStackTrace();
    }
  }
  
  protected void installPlugin()
  {
    super.installPlugin();
    try
    {
      this.b.a("qzone_live_video_plugin_hack.apk", new a(), this.mMode);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
    }
  }
  
  protected void installPluginSilence()
  {
    QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "installPluginSilence");
    try
    {
      this.b.a("qzone_live_video_plugin_hack.apk", null, 3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, "installPluginSilence", localRemoteException);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("QZoneLiveVideoDownLoadActivtyV2", 4, "oncreate");
    if (!aLn()) {
      return;
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_launch_completed");
      this.mReceiver = new QZoneLiveVideoBaseDownLoadActivty.LaunchCompletedObserver(this, "QZoneLiveVideo", "qzone_live_video_plugin_hack.apk");
      registerReceiver(this.mReceiver, paramBundle);
      avyi.a(this, this);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoDownLoadActivtyV2", 1, "", paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b = null;
  }
  
  protected PluginBaseInfo queryPlugin(String paramString)
  {
    return a(this.b.a(paramString));
  }
  
  class a
    extends avxr.a
  {
    a() {}
    
    public void a(String paramString, float paramFloat, long paramLong)
      throws RemoteException
    {}
    
    public void onInstallBegin(String paramString)
      throws RemoteException
    {}
    
    public void onInstallError(String paramString, int paramInt)
      throws RemoteException
    {
      QLog.w("QZoneLiveVideoDownLoadActivtyV2", 1, "[onInstallError] pluginId=" + paramString + ", errorCode=" + paramInt);
      paramString = QZoneLiveVideoDownLoadActivtyV2.this.mHandler.obtainMessage();
      paramString.what = 1010;
      if (8 == paramInt) {}
      for (paramString.obj = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastPluginDownloadErrorNoSpace", "内部存储空间不足，下载失败");; paramString.obj = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "ToastPluginDownloadError", "插件下载失败"))
      {
        QZoneLiveVideoDownLoadActivtyV2.this.mHandler.sendMessage(paramString);
        return;
      }
    }
    
    public void onInstallFinish(String paramString)
      throws RemoteException
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2
 * JD-Core Version:    0.7.0.1
 */