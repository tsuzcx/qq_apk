import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class dud
  extends WebViewClient
{
  public dud(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (PreviewingOfflineFileViewBase.a(this.a) == null) {
      return;
    }
    PreviewingOfflineFileViewBase.c(this.a).runOnUiThread(new duf(this));
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    QLog.e("PreviewingOfflineFileViewBase<FileAssistant>", 1, "load url[" + paramString2 + "] error! errCode[" + String.valueOf(paramInt) + "],description[" + String.valueOf(paramString1) + "]");
    PreviewingOfflineFileViewBase.b(this.a).runOnUiThread(new due(this, paramInt, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dud
 * JD-Core Version:    0.7.0.1
 */