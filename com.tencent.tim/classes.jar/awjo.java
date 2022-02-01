import android.os.Handler;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager;
import cooperation.troop.TroopPluginManager.InstallRunable;
import java.util.concurrent.ConcurrentLinkedQueue;

public class awjo
  extends OnPluginInstallListener.Stub
{
  public awjo(TroopPluginManager.InstallRunable paramInstallRunable) {}
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopPluginManager.TAG, 2, "Troop plugin onInstallBegin...  pluginId = " + this.a.mPluginId);
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopPluginManager.TAG, 2, "Troop plugin onInstallDownloadProgress... pluginId = " + this.a.mPluginId);
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopPluginManager.TAG, 2, "Troop plugin onInstallError... = " + this.a.mPluginId);
    }
    this.a.this$0.V.remove(paramString);
    this.a.mHandler.sendEmptyMessage(1002);
    anot.a(null, "P_CliOper", "BizTechReport", "", "troop_plugin", "install_plugin", 0, 1, null, null, null, null);
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopPluginManager.TAG, 2, "Troop plugin onInstallFinish...   pluginId = " + this.a.mPluginId);
    }
    this.a.this$0.V.remove(paramString);
    this.a.mHandler.sendEmptyMessage(1001);
    anot.a(null, "P_CliOper", "BizTechReport", "", "troop_plugin", "install_plugin", 0, 0, null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjo
 * JD-Core Version:    0.7.0.1
 */