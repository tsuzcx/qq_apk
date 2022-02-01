import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;

class avgo
  implements OnPluginInstallListener
{
  avgo(avgn paramavgn) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {}
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if ("qqreaderplugin.apk".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallError, pluginId = " + paramString + ", errorCode = " + paramInt);
      }
      anot.a(avgn.a(this.b), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, paramInt, "", "", "", "");
    }
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.i("PluginPreInstaller", 2, "PluginReinstallInWiFi finish,plugin:" + paramString);
    }
    Object localObject;
    if ("qqreaderplugin.apk".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "PluginPreInstaller onInstallFinish, pluginId = " + paramString);
      }
      anot.a(avgn.a(this.b), "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 0, 0, "", "", "", "");
      localObject = (avmd)avgn.a(this.b).getManager(129);
      if (localObject != null) {
        ((avmd)localObject).eAL();
      }
    }
    for (;;)
    {
      localObject = new Intent("com.tencent.mobileqq.cooperation.plugin." + paramString);
      ((Intent)localObject).putExtra("plugin", paramString);
      avgn.a(this.b).sendBroadcast((Intent)localObject);
      return;
      if ("comic_plugin.apk".equals(paramString)) {
        aveb.gl(avgn.a(this.b));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgo
 * JD-Core Version:    0.7.0.1
 */