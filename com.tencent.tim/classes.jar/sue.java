import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class sue
  extends WebViewPlugin
{
  public sue()
  {
    this.mPluginNameSpace = "openToAppDetail";
  }
  
  public void U(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.mRuntime.a().getCurrentAccountUin());
    localBundle.putString("sid", this.mRuntime.getActivity().getIntent().getStringExtra("vkey"));
    localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ");
    if ((paramString2 != null) && (paramString2.equals("true"))) {
      localBundle.putBoolean("autoDownload", true);
    }
    if (paramString3 != null) {
      localBundle.putString("packageName", paramString3);
    }
    arue.a(this.mRuntime.getActivity(), paramString1, 2470, localBundle);
  }
  
  public void cT(String paramString1, String paramString2)
  {
    U(paramString1, paramString2, null);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"openToAppDetail".equals(paramString2)) {}
    do
    {
      do
      {
        return false;
      } while (!"openAppDetailPage".equals(paramString3));
      if (paramVarArgs.length == 2)
      {
        cT(paramVarArgs[0], paramVarArgs[1]);
        return true;
      }
    } while (paramVarArgs.length != 3);
    U(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sue
 * JD-Core Version:    0.7.0.1
 */