import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;

class vmd
  extends OnPluginInstallListener.Stub
{
  vmd(vmc paramvmc) {}
  
  public void onInstallBegin(String paramString)
  {
    vmc.a = 1;
    vmc.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallBegin  STATE_PRELOAD_BEGIN sPreloadPluginState = " + vmc.a);
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    vmc.a = -1;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallError  STATE_PRELOAD_ERR sPreloadPluginState = " + vmc.a);
  }
  
  public void onInstallFinish(String paramString)
  {
    vmc.a = 2;
    vmc.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallFinish  STATE_PRELOAD_FINISH sPreloadPluginState = " + vmc.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmd
 * JD-Core Version:    0.7.0.1
 */