import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;

class ooq
  extends OnPluginInstallListener.Stub
{
  ooq(oop paramoop) {}
  
  public void onInstallBegin(String paramString)
    throws RemoteException
  {
    oop.bfx = 1;
    oop.a(this.this$0);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallBegin  STATE_PRELOAD_BEGIN sPreloadPluginState = " + oop.bfx);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException
  {}
  
  public void onInstallError(String paramString, int paramInt)
    throws RemoteException
  {
    oop.bfx = -1;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallError  STATE_PRELOAD_ERR sPreloadPluginState = " + oop.bfx);
  }
  
  public void onInstallFinish(String paramString)
    throws RemoteException
  {
    oop.bfx = 2;
    oop.a(this.this$0);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallFinish  STATE_PRELOAD_FINISH sPreloadPluginState = " + oop.bfx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ooq
 * JD-Core Version:    0.7.0.1
 */