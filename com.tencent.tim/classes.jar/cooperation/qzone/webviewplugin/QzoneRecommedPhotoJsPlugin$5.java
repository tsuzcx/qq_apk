package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import avzf;
import avzh;
import awgj;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QzoneRecommedPhotoJsPlugin$5
  implements Runnable
{
  public QzoneRecommedPhotoJsPlugin$5(awgj paramawgj, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$jsonString);
      Bundle localBundle = new Bundle();
      localBundle.putInt("status", localJSONObject.optInt("status"));
      avzf.a().a().ek(localBundle);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QzoneRecommedPhotoJsPlugin", 1, "handleSetQuickMakeDynamicStatus error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */