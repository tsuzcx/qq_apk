package cooperation.qzone.webviewplugin;

import android.graphics.BitmapFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.util.QZLog;
import java.io.IOException;
import java.util.Map;
import jqc;

public final class QZoneWebViewJsHandleLogic$3
  implements Runnable
{
  public QZoneWebViewJsHandleLogic$3(String paramString, Map paramMap, WebViewPlugin.a parama, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject = jqc.a(BaseApplicationImpl.getContext(), this.val$picUrl, "GET", null, null);
      if (localObject != null)
      {
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if (localObject != null) {
          this.eI.put("image", localObject);
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QZLog.e("QZoneWebViewJsHandleLogic", "download pic error", localIOException);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QZLog.e("QZoneWebViewJsHandleLogic", "download pic error", localOutOfMemoryError);
      }
    }
    this.a.a().runOnUiThread(this.val$r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.3
 * JD-Core Version:    0.7.0.1
 */