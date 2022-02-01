import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.1;
import cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.2;
import mqq.os.MqqHandler;

public class awfm
  extends awfr
  implements avzi
{
  private static final String TAG = awfk.class.getSimpleName();
  
  private static void l(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    parama.a().getHandler(awfm.class).post(new QzoneDeviceTagJsPlugin.1(paramArrayOfString));
  }
  
  private static void m(WebViewPlugin paramWebViewPlugin, WebViewPlugin.a parama, String[] paramArrayOfString)
  {
    parama.a().getHandler(awfm.class).post(new QzoneDeviceTagJsPlugin.2());
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if ("GetDeviceInfo".equalsIgnoreCase(paramString3))
    {
      avzf.a().a(this);
      m(this.f, this.f.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetUserTail".equalsIgnoreCase(paramString3))
    {
      avzf.a().a(this);
      l(this.f, this.f.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    avzf.a().b(this);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("data");
          if (paramBundle != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(TAG, 2, "call js function,bundle is empty");
        return;
        if (!"cmd.getDeviceInfos".equals(paramString)) {
          break;
        }
        paramString = paramBundle.getString("param.DeviceInfos");
      } while (TextUtils.isEmpty(paramString));
      this.f.callJs("window.QZPhoneTagJSInterface.onReceive({code:0,data:" + paramString + "})");
      return;
    } while (!"cmd.setUserTail".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfm
 * JD-Core Version:    0.7.0.1
 */