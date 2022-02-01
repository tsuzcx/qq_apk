import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.util.QZLog;

final class awcd
  implements ModuleDownloadListener
{
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString)
  {
    QZLog.i(awcc.TAG, "download webp so fail");
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("animatedWebp.so")) {
      return;
    }
    arym.getPreferences().edit().putString("PREFERENCE_SO_MD5_KEY", awcc.cOW).commit();
    QZLog.i(awcc.TAG, "download webp so succ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awcd
 * JD-Core Version:    0.7.0.1
 */