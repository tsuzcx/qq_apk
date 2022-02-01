import android.os.Handler;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoPluginInstallerActivity;

public class avff
  extends OnPluginInstallListener.Stub
{
  public avff(GVideoPluginInstallerActivity paramGVideoPluginInstallerActivity) {}
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "Group video plugin onInstallBegin...");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "Group video plugin onInstallDownloadProgress...");
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "Group video plugin onInstallError...");
    }
    this.this$0.mMainThreadHandler.sendEmptyMessageDelayed(3, 200L);
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "Group video plugin onInstallFinish...");
    }
    this.this$0.mMainThreadHandler.sendEmptyMessageDelayed(1, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avff
 * JD-Core Version:    0.7.0.1
 */