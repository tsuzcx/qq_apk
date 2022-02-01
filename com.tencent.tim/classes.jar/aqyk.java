import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

class aqyk
  extends jxx
{
  aqyk(aqyg paramaqyg) {}
  
  private void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "show custom view called");
    }
    this.this$0.showCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public View getVideoLoadingProgressView()
  {
    return this.this$0.getVideoLoadingProgressView();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    this.this$0.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "hide custom view called");
    }
    this.this$0.onHideCustomView();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.this$0.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
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
      QLog.d("AbsWebView", 2, "onProgressChanged:" + paramInt);
    }
    if ((this.this$0.mProgressBarController != null) && (this.this$0.mProgressBarController.getCurStatus() == 0)) {
      this.this$0.mProgressBarController.enterStatus((byte)1);
    }
    if (paramInt == 100) {
      this.this$0.showProgressBar(false);
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
  
  @SuppressLint({"InlinedApi"})
  public void onShowCustomView(View paramView, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    showCustomView(paramView, 10, paramCustomViewCallback);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.this$0.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyk
 * JD-Core Version:    0.7.0.1
 */