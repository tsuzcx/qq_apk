import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class apmh
  extends WebViewPlugin
{
  protected AtomicBoolean ac = new AtomicBoolean(false);
  protected skj h;
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ((!"GroupAppPanel".equals(paramString2)) || (("launchGroupApp".equals(paramString3)) && (paramVarArgs.length > 0) && (this.h != null))) {}
    try
    {
      paramString3 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString3.getString("groupCode");
      paramString1 = paramString3.getString("appID");
      paramString2 = paramString3.getString("url");
      paramString3 = paramString3.getString("source");
      this.h.p(paramJsBridgeListener, paramString1, paramString2, paramString3);
      bool = true;
      return bool;
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
        QLog.e("TroopAppPanelJsPlugin", 2, "launchGroupApp: args error");
      }
    }
  }
  
  public void onCreate()
  {
    if (this.ac.compareAndSet(false, true))
    {
      this.h = skj.a();
      this.h.bzj();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.ac.get()) {
      this.h.bzk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmh
 * JD-Core Version:    0.7.0.1
 */