import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

public class aqyr
  extends WebViewPlugin
{
  public aqyr()
  {
    this.mPluginNameSpace = "forceHttps";
  }
  
  private boolean rK(String paramString)
  {
    boolean bool2 = false;
    jml localjml = jml.a();
    boolean bool1 = bool2;
    if (localjml.cU(paramString))
    {
      bool1 = bool2;
      if (!localjml.cV(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (!jml.a().xZ()) {
      return false;
    }
    if (("http".equals(paramString2)) && (rK(paramString1)))
    {
      paramString2 = this.mRuntime.b();
      if ((paramString2 != null) && (paramString2.a != null)) {
        paramString2.a.cYe = true;
      }
      paramString2 = "https" + paramString1.substring("http".length());
      CustomWebView localCustomWebView = this.mRuntime.getWebView();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("need switch url=").append(jqo.filterKeyForLog(paramString1, new String[0]));
        if (localCustomWebView != null) {
          break label155;
        }
      }
      label155:
      for (paramString1 = ", view==null";; paramString1 = "")
      {
        QLog.i("forceHttps", 2, paramString1);
        if (localCustomWebView == null) {
          break;
        }
        localCustomWebView.loadUrl(paramString2);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyr
 * JD-Core Version:    0.7.0.1
 */