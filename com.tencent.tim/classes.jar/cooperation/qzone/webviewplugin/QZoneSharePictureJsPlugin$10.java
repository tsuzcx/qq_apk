package cooperation.qzone.webviewplugin;

import awey;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.QZLog;

public class QZoneSharePictureJsPlugin$10
  implements Runnable
{
  public QZoneSharePictureJsPlugin$10(awey paramawey, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.f != null) && (this.this$0.f.mRuntime != null)) {
        QQToast.a(this.this$0.f.mRuntime.getActivity(), this.aIT, this.val$msg, 0).show();
      }
      return;
    }
    catch (Exception localException)
    {
      QZLog.w("QZoneSharePictureJsPlugin", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */