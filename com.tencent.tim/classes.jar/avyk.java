import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.a;

class avyk
  extends avxr.a
  implements NetworkState.a
{
  private static int ezu;
  private static final String[] iY = { "qzone_live_video_plugin_hack.apk", "qzone_vertical_video_plugin.apk" };
  private avyh jdField_a_of_type_Avyh;
  private avym jdField_a_of_type_Avym;
  private Handler mHandler = new avyl(this, Looper.getMainLooper());
  
  avyk(avyh paramavyh, avym paramavym)
  {
    this.jdField_a_of_type_Avym = paramavym;
    this.jdField_a_of_type_Avyh = paramavyh;
    NetworkState.addListener(this);
  }
  
  public void a(String paramString, float paramFloat, long paramLong)
    throws RemoteException
  {}
  
  public void onDestroy()
  {
    this.mHandler.removeMessages(1);
    ezu = 0;
    NetworkState.removeListener(this);
  }
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallBegin");
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallError, plugin=" + paramString + ", retryInstallNum=" + ezu);
    }
    paramInt = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
    if ((ezu < paramInt) && (this.jdField_a_of_type_Avyh != null))
    {
      ezu += 1;
      paramString = this.mHandler.obtainMessage(1, paramString);
      this.mHandler.sendMessageDelayed(paramString, ezu * 30 * 1000);
    }
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginPreInstaller", 2, "onInstallFinish");
    }
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (avyh.aLU()) {
      preload();
    }
  }
  
  void preload()
  {
    if ((avyh.aLU()) && (this.jdField_a_of_type_Avym.aL() != null)) {
      try
      {
        String[] arrayOfString = iY;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.jdField_a_of_type_Avyh.a(str, this, 0);
          i += 1;
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("QZonePluginPreInstaller", 1, localRemoteException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyk
 * JD-Core Version:    0.7.0.1
 */