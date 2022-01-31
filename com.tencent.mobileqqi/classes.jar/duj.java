import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class duj
  extends WebChromeClient
{
  private duj(UpgradeDetailActivity paramUpgradeDetailActivity) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    paramGeolocationPermissionsCallback.invoke(paramString, true, false);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "onProgressChanged: " + paramInt + "%");
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "onReceivedTitle:" + paramString);
    }
    this.a.setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     duj
 * JD-Core Version:    0.7.0.1
 */