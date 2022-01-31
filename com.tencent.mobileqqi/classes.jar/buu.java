import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;

public class buu
  implements LoadedBack2
{
  public buu(OfflinePlugin paramOfflinePlugin) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.a();
    if (localObject == null) {}
    WebView localWebView;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(localObject instanceof QQBrowserActivity));
        localObject = (QQBrowserActivity)localObject;
      } while (QQBrowserActivity.a == localObject);
      localWebView = this.a.mRuntime.a();
    } while (localWebView == null);
    localWebView.loadUrl(((QQBrowserActivity)localObject).I);
  }
  
  public void a(int paramInt)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.arg1 = 5;
    localMessage.arg2 = paramInt;
    this.a.a.sendMessage(localMessage);
  }
  
  public void b(int paramInt)
  {
    Message localMessage = this.a.a.obtainMessage();
    localMessage.arg1 = 4;
    localMessage.arg2 = paramInt;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     buu
 * JD-Core Version:    0.7.0.1
 */