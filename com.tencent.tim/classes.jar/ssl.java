import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

public class ssl
  extends jxx
{
  private int byW;
  private int byX;
  private IX5WebChromeClient.CustomViewCallback customViewCallback;
  private View lr;
  private View qI;
  
  public ssl(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  private void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "show custom view called");
    }
    if (this.customViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.byW = this.this$0.getRequestedOrientation();
    this.byX = (this.this$0.getWindow().getAttributes().flags & 0x400);
    if (this.this$0.customContainer == null)
    {
      this.this$0.customContainer = new FrameLayout(this.this$0);
      this.this$0.customContainer.setBackgroundColor(-16777216);
      ((ViewGroup)this.this$0.getWindow().getDecorView()).addView(this.this$0.customContainer, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!this.this$0.a.cYJ) {
      this.this$0.getWindow().setFlags(1024, 1024);
    }
    this.this$0.setRequestedOrientation(paramInt);
    this.this$0.aMU = true;
    this.this$0.customContainer.addView(paramView);
    this.lr = paramView;
    this.customViewCallback = paramCustomViewCallback;
    this.this$0.customContainer.setVisibility(0);
  }
  
  @SuppressLint({"InflateParams"})
  public View getVideoLoadingProgressView()
  {
    if (this.qI == null) {
      this.qI = LayoutInflater.from(this.this$0).inflate(2131563308, null);
    }
    return this.qI;
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.indexOf(':') == -1)
      {
        str = paramString;
        if (this.this$0.g != null)
        {
          str = paramString;
          if (this.this$0.g.getX5WebViewExtension() != null) {
            str = "https://" + paramString + "/";
          }
        }
      }
    }
    paramGeolocationPermissionsCallback.invoke(str, this.this$0.authConfig.z(str, "publicAccount.getLocation"), false);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "hide custom view called");
    }
    if (this.customViewCallback == null) {
      return;
    }
    this.lr.setKeepScreenOn(false);
    this.this$0.customContainer.setVisibility(8);
    this.customViewCallback.onCustomViewHidden();
    try
    {
      this.this$0.customContainer.removeAllViews();
      label61:
      if (!this.this$0.a.cYJ) {
        this.this$0.getWindow().setFlags(this.byX, 1024);
      }
      this.this$0.setRequestedOrientation(this.byW);
      this.lr = null;
      this.customViewCallback = null;
      this.qI = null;
      this.this$0.aMU = false;
      return;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  @Override
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onProgressChanged:" + paramInt);
    }
    this.this$0.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.this$0.onReceivedTitle(paramWebView, paramString);
  }
  
  public void onShowCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    showCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    showCustomView(paramView, 10, paramCustomViewCallback);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (this.this$0.mFileChooserHelper == null) {
      this.this$0.mFileChooserHelper = new jpu();
    }
    this.this$0.mFileChooserHelper.showFileChooser(this.this$0, 0, paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssl
 * JD-Core Version:    0.7.0.1
 */