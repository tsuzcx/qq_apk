import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;

public abstract interface aqzw
{
  public abstract Object a(String paramString, Bundle paramBundle);
  
  public abstract void a(WebView paramWebView, SslError paramSslError);
  
  public abstract boolean a(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams);
  
  public abstract boolean a(WebView paramWebView, String paramString);
  
  public abstract void b(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract boolean c(WebView paramWebView, String paramString);
  
  public abstract void ec(int paramInt, String paramString);
  
  public abstract String getUAMark();
  
  public abstract View getVideoLoadingProgressView();
  
  public abstract void onDetectedBlankScreen(String paramString, int paramInt);
  
  public abstract void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback);
  
  public abstract void onHideCustomView();
  
  public abstract boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract void onPageFinished(WebView paramWebView, String paramString);
  
  public abstract void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract void onProgressChanged(WebView paramWebView, int paramInt);
  
  public abstract void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public abstract void onReceivedTitle(WebView paramWebView, String paramString);
  
  public abstract void onUrlChange(String paramString1, String paramString2);
  
  public abstract void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2);
  
  public abstract boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString);
  
  public abstract void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzw
 * JD-Core Version:    0.7.0.1
 */