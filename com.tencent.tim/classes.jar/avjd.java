import android.os.RemoteException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class avjd
  extends OnPluginInstallListener.Stub
{
  avjd(avjc paramavjc) {}
  
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
      QLog.i("qqfav", 2, "install plugin " + paramString + " error! " + paramInt);
    }
    try
    {
      ThreadManager.post(this.a.iB, 5, null, false);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "install plugin " + paramString + " OK.");
    }
    avja.access$000().set(true);
    try
    {
      ThreadManager.post(this.a.iB, 5, null, false);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avjd
 * JD-Core Version:    0.7.0.1
 */