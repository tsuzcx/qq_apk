import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.QQComicPluginBridge.1;

public class avec
  implements OnPluginInstallListener
{
  public avec(QQComicPluginBridge.1 param1) {}
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {
    if ((this.a.a != null) && (this.a.a.a != null)) {
      this.a.a.a.et(98, "载入中,（我会越来越快的>_<）");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {
    if ((this.a.a != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      this.a.a.azu = System.currentTimeMillis();
      if (this.a.a.a != null)
      {
        paramInt1 = (int)(paramInt1 / paramInt2 * 95.0F);
        this.a.a.a.et(paramInt1, "加载中,（别紧张啊我很小的>_<）");
      }
    }
  }
  
  public void onInstallError(String arg1, int paramInt)
    throws RemoteException
  {
    synchronized ()
    {
      aveb.access$000().notifyAll();
      if (this.a.a != null) {
        this.a.a.mErrCode = paramInt;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic install error");
      }
      return;
    }
  }
  
  public void onInstallFinish(String arg1)
    throws RemoteException
  {
    synchronized ()
    {
      aveb.access$000().notifyAll();
      if (this.a.a != null)
      {
        this.a.a.awO = System.currentTimeMillis();
        if (this.a.a.a != null) {
          this.a.a.a.et(99, "载入中,（我会越来越快的>_<）");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is installed");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avec
 * JD-Core Version:    0.7.0.1
 */