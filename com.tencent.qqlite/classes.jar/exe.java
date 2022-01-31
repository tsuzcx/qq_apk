import android.app.Activity;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;

public class exe
  implements Runnable
{
  public exe(WebViewJumpPlugin paramWebViewJumpPlugin) {}
  
  public void run()
  {
    Activity localActivity = this.a.mRuntime.a();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     exe
 * JD-Core Version:    0.7.0.1
 */