import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class aiji
  extends WebViewPlugin
{
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("nvPopToRoot".equals(paramString3)) && (paramVarArgs.length > 0))
    {
      paramJsBridgeListener = this.mRuntime.getActivity();
      paramString1 = new Intent(paramJsBridgeListener, SplashActivity.class);
      paramString1.setFlags(67108864);
      paramJsBridgeListener.startActivity(paramString1);
      return false;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiji
 * JD-Core Version:    0.7.0.1
 */