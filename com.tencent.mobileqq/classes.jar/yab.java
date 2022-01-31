import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

public class yab
  implements ModuleDownloadListener
{
  public yab(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QZLog.i("QzDynamicVideoPreviewActivity", 2, new Object[] { "onDownloadCanceled ", paramString });
  }
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i("QzDynamicVideoPreviewActivity", 2, new Object[] { "onDownloadFailed ", paramString });
    this.a.runOnUiThread(new yad(this));
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("cyber_clink.jar")) {
      return;
    }
    this.a.runOnUiThread(new yac(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yab
 * JD-Core Version:    0.7.0.1
 */