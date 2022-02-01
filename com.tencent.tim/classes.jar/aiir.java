import android.app.Activity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class aiir
  extends WebViewPlugin
{
  public aiir()
  {
    this.mPluginNameSpace = "accounts";
  }
  
  private void dsD()
  {
    aczy.dW(r());
  }
  
  private Activity r()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity instanceof BasePluginActivity); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"accounts".equals(paramString2)) {}
    while (!"gotoSetting".equals(paramString3)) {
      return false;
    }
    dsD();
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiir
 * JD-Core Version:    0.7.0.1
 */