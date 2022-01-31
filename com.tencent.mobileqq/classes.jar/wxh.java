import com.tencent.biz.tribe.TribeVideoPlugin.TVKSDKInstallRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class wxh
  implements TVK_SDKMgr.InstallListener
{
  public wxh(TribeVideoPlugin.TVKSDKInstallRunnable paramTVKSDKInstallRunnable) {}
  
  public void onInstallProgress(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, String.format("plugin install %f", new Object[] { Float.valueOf(paramFloat) }));
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "plugin fail errorCode = " + paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoPlugin", 1, "plugin success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wxh
 * JD-Core Version:    0.7.0.1
 */