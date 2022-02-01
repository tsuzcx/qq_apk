import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class awgi
  extends awfr
{
  private void n(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (parama == null)) {
      return;
    }
    QLog.i("QzoneReactMessageDeliverPlugin", 1, paramArrayOfString[0]);
    paramWebViewPlugin = new Intent("ReactNativeMsgDeliver");
    paramWebViewPlugin.putExtra("args", paramArrayOfString[0]);
    BaseApplication.getContext().sendBroadcast(paramWebViewPlugin);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.f == null) || (this.f.mRuntime == null)) {}
    while (!"deliverMsg".equalsIgnoreCase(paramString3)) {
      return false;
    }
    n(this.f, this.f.mRuntime, paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgi
 * JD-Core Version:    0.7.0.1
 */