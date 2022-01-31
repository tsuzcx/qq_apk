import com.tencent.mobileqq.richstatus.MovieDetailActivity;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class ecc
  extends WebChromeClient
{
  private ecc(MovieDetailActivity paramMovieDetailActivity) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    paramGeolocationPermissionsCallback.invoke(paramString, true, false);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.setTitle(paramString);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecc
 * JD-Core Version:    0.7.0.1
 */