import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;

class upt
  extends OnPluginInstallListener.Stub
{
  upt(ups paramups) {}
  
  public void onInstallBegin(String paramString)
  {
    ups.a = 1;
    ups.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallBegin  STATE_PRELOAD_BEGIN sPreloadPluginState = " + ups.a);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    ups.a = -1;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallError  STATE_PRELOAD_ERR sPreloadPluginState = " + ups.a);
  }
  
  public void onInstallFinish(String paramString)
  {
    ups.a = 2;
    ups.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallFinish  STATE_PRELOAD_FINISH sPreloadPluginState = " + ups.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upt
 * JD-Core Version:    0.7.0.1
 */