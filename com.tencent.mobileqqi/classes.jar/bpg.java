import android.os.Handler;
import android.os.Message;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

public class bpg
  extends Handler
{
  public bpg(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5) {
      SensorAPIJavaScript.a(this.a, (String)paramMessage.obj);
    }
    WebView localWebView;
    do
    {
      do
      {
        return;
      } while (this.a.a == null);
      localWebView = (WebView)this.a.a.get();
    } while (localWebView == null);
    localWebView.loadUrl((String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpg
 * JD-Core Version:    0.7.0.1
 */