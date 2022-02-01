import android.os.Bundle;
import com.tencent.ark.open.security.ArkBaseUrlChecker;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

public class adto
  extends WebViewPlugin
{
  private ArkBaseUrlChecker a;
  private boolean bQG = true;
  private String mAppName;
  private String mSenderUin = "";
  
  public adto(Bundle paramBundle)
  {
    this.mPluginNameSpace = "ArkSecurity";
    if (paramBundle != null) {
      try
      {
        paramBundle.setClassLoader(adto.class.getClassLoader());
        this.a = ((ArkBaseUrlChecker)paramBundle.getParcelable("h5_ark_url_web_checker"));
        this.mAppName = paramBundle.getString("h5_ark_app_name", null);
        this.mSenderUin = paramBundle.getString("h5_ark_url_web_sender_uin", "");
        this.bQG = paramBundle.getBoolean("h5_ark_url_web_checker_enable", true);
        String str1 = this.mAppName;
        boolean bool = this.bQG;
        String str2 = this.mSenderUin;
        if (this.a != null)
        {
          paramBundle = this.a.toString();
          QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.ArkSecurityWebViewPlugin init appname = ", str1, ",mEnableUrlCheck = ", Boolean.valueOf(bool), ", senderUin=", str2, ", mUrlChecker=", paramBundle });
          return;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          QLog.e("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin init exception:", paramBundle);
          continue;
          paramBundle = null;
        }
      }
    }
    QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin init bundle is null");
  }
  
  protected void cUn()
  {
    if (this.mRuntime == null) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.getWebView();
    } while (localCustomWebView == null);
    QLog.i("ArkApp.ArkSecurityWebViewPlugin", 1, "now jump url=" + jqo.filterKeyForLog("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html", new String[0]));
    localCustomWebView.loadUrl("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html");
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool3 = true;
    if ("https://qzonestyle.gtimg.cn/qzone/hybrid/page/safeTips/index.html".equals(paramString1))
    {
      QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe now jump url=", paramString1 });
      return false;
    }
    boolean bool1;
    int i;
    if (this.a != null)
    {
      int j = this.a.checkURLLoose(paramString1);
      if (j == 0)
      {
        bool1 = true;
        if (bool1) {
          break label201;
        }
        if (this.bQG) {
          break label196;
        }
        QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.web.set isPermitted=true,url=", jqo.filterKeyForLog(paramString1, new String[0]) });
        i = 2;
        bool1 = true;
        label101:
        adtn.f(this.mAppName, paramString1, j, i, this.mSenderUin);
        bool2 = bool1;
        if (!bool1)
        {
          QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, new Object[] { "ArkSafe.handleSchemaRequest,isPermitted=", Boolean.valueOf(bool1), ", url=", jqo.filterKeyForLog(paramString1, new String[0]) });
          cUn();
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if (!bool2) {}
      for (bool1 = bool3;; bool1 = false)
      {
        return bool1;
        bool1 = false;
        break;
      }
      label196:
      i = 1;
      break label101;
      label201:
      i = 0;
      break label101;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("ArkApp.ArkSecurityWebViewPlugin", 1, "ArkSafe.ArkSecurityWebViewPlugin onDestroy");
    adst.a().a("callDisableReport", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adto
 * JD-Core Version:    0.7.0.1
 */