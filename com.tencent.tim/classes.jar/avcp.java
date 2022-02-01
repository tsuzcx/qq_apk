import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class avcp
  implements OnPluginInstallListener
{
  avcp(AppRuntime paramAppRuntime, avcn paramavcn, avco.a parama, int paramInt) {}
  
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
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "pluginType:" + this.b.cdu + " preload:fail:installerror");
    }
    avcm.a(this.val$app, 1, this.b.cdu, this.b.ewp, 3, "preload:fail:installerror", this.ewD, new String[] { String.valueOf(this.b.mStrategyId) });
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "plugin install success, do preload.");
    }
    avcm.a(this.val$app, 0, this.b.cdu, this.b.ewp, this.a.ewq, this.a.cJg, this.ewD, new String[] { String.valueOf(this.b.mStrategyId) });
    this.b.aBp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcp
 * JD-Core Version:    0.7.0.1
 */