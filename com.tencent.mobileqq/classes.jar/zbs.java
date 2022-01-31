import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class zbs
  extends WebViewPlugin
{
  public zbs()
  {
    this.mPluginNameSpace = "troop_member_level_JS_API";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"troop_member_level_JS_API".equals(paramString2)) {
      return false;
    }
    if (("setTitleBar".equals(paramString3)) && (paramVarArgs.length == 3))
    {
      paramString2 = (beey)super.getBrowserComponent(2);
      if (paramString2 != null)
      {
        paramString1 = paramVarArgs[0];
        paramJsBridgeListener = paramString1;
        if ("RETURN".equals(paramString1)) {
          paramJsBridgeListener = this.mRuntime.a().getIntent().getStringExtra("leftViewText");
        }
        paramString2.a.a(paramJsBridgeListener, paramVarArgs[1], paramVarArgs[2]);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zbs
 * JD-Core Version:    0.7.0.1
 */