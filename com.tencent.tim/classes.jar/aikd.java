import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class aikd
  extends WebViewPlugin
{
  private final skj mClient = skj.a();
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("studyroom".equals(paramString2)) && ("predownload".equals(paramString3)))
    {
      this.mClient.bzs();
      return true;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mClient.bzj();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mClient.bzk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikd
 * JD-Core Version:    0.7.0.1
 */