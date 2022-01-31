import android.os.Handler;
import android.os.Message;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

public class mv
  extends Handler
{
  public mv(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 5) {
      SensorAPIJavaScript.a(this.a, (String)paramMessage.obj);
    }
    if (paramMessage.what == 291) {
      this.a.a((String)paramMessage.obj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mv
 * JD-Core Version:    0.7.0.1
 */