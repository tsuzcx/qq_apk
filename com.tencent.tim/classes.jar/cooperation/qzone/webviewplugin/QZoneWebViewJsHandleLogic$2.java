package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import awal;
import awfb;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.Map;

public final class QZoneWebViewJsHandleLogic$2
  implements Runnable
{
  public QZoneWebViewJsHandleLogic$2(WebViewPlugin.a parama, Map paramMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject = this.a.getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    localObject = (Bitmap)this.eI.remove("image");
    awal.a().a(awfb.a);
    awal.a().a(this.val$title, (Bitmap)localObject, this.val$description, this.cPM, this.val$path, this.val$userName, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.2
 * JD-Core Version:    0.7.0.1
 */