package cooperation.qzone;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import avpw;
import avyh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import jqc;

public class QZoneLiveVideoDownloadActivity
  extends QZoneLiveVideoBaseDownLoadActivty
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public PluginManagerClient mPluginManager;
  
  protected String Ge()
  {
    return "qzone_live_video_plugin.apk";
  }
  
  protected void installPlugin()
  {
    super.installPlugin();
    if (this.mPluginManager == null)
    {
      QZLog.e("QZoneLiveVideoDownloadActivity", "[installPlugin] mPluginManager is null");
      return;
    }
    this.mPluginManager.installPlugin(Ge());
  }
  
  protected void installPluginSilence()
  {
    QLog.d("QZoneLiveVideoDownloadActivity", 1, "installPluginSilence");
    this.mPluginManager.installPlugin(Ge());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!aLn()) {
      return;
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_launch_completed");
      this.mReceiver = new QZoneLiveVideoBaseDownLoadActivty.LaunchCompletedObserver(this, "QZoneLiveVideo", "qzone_live_video_plugin.apk");
      registerReceiver(this.mReceiver, paramBundle);
      PluginManagerHelper.getPluginInterface(this, this);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoDownloadActivity", 1, "", paramBundle);
      }
    }
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (paramPluginManagerClient == null)
    {
      QZLog.w("QZoneLiveVideoDownloadActivity", "[onPluginManagerLoaded] pInterface is null");
      paramPluginManagerClient = BaseApplicationImpl.getContext().getString(2131717916);
      QQToast.a(BaseApplicationImpl.getContext(), paramPluginManagerClient, 1).show();
      return;
    }
    this.mPluginManager = paramPluginManagerClient;
    if (this.mPluginManager.isPluginInstalled(Ge()))
    {
      QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin installed already");
      eBy();
      return;
    }
    paramPluginManagerClient = this.mPluginManager.queryPlugin(Ge());
    if (paramPluginManagerClient == null)
    {
      QLog.w("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] PluginBaseInfo is null, isReady=" + this.mPluginManager.isReady());
      paramPluginManagerClient = BaseApplicationImpl.getContext().getString(2131717916);
      QQToast.a(BaseApplicationImpl.getContext(), paramPluginManagerClient, 1).show();
      return;
    }
    if (QZLog.isColorLevel()) {
      QZLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin state=" + paramPluginManagerClient.mState);
    }
    if (2 == paramPluginManagerClient.mState)
    {
      QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin downloaded, continue to install");
      this.mPluginManager.installPlugin(Ge());
      return;
    }
    QLog.d("QZoneLiveVideoDownloadActivity", 2, "[onPluginManagerLoaded] plugin not downloaded");
    LpReportInfo_dc01500.reportLaunch(Ge(), "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 7, this.mMode + "");
    if ((3 == this.mMode) && (!TextUtils.isEmpty(this.mBackupUrl)) && (jqc.isValidUrl(this.mBackupUrl)))
    {
      paramPluginManagerClient = this.mBackupUrl + "&stayin=1";
      QLog.d("QZoneLiveVideoDownloadActivity", 1, "watch mode, jump to H5, " + paramPluginManagerClient);
      avpw.forwardToBrowser(this, paramPluginManagerClient, -1, null, null);
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
    QLog.d("QZoneLiveVideoDownloadActivity", 1, "network type = " + i);
    if ((2 != i) && (i != 0))
    {
      installPlugin();
      return;
    }
    paramPluginManagerClient = Message.obtain();
    paramPluginManagerClient.what = 1000;
    paramPluginManagerClient.arg1 = 1;
    this.mHandler.sendMessage(paramPluginManagerClient);
  }
  
  protected PluginBaseInfo queryPlugin(String paramString)
  {
    return this.mPluginManager.queryPlugin(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */