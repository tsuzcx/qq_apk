import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;

public class sso
  implements DownloadListener
{
  public sso(AbsBaseWebViewActivity paramAbsBaseWebViewActivity, TouchWebView paramTouchWebView) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "start UniformDownloadActivity");
    }
    String str = this.h.getUrl();
    Bundle localBundle = new Bundle();
    localBundle.putLong("_filesize", paramLong);
    localBundle.putString("param_user_agent", paramString2);
    localBundle.putString("param_content_des", paramString3);
    localBundle.putString("param_mime_type", paramString4);
    localBundle.putString("param_refer_url", str);
    agjj.a(this.this$0, paramString1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sso
 * JD-Core Version:    0.7.0.1
 */