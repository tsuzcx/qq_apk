import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;

public class se
  implements Runnable
{
  public se(QzonePlugin paramQzonePlugin) {}
  
  public void run()
  {
    if (QzonePlugin.a(this.a) != null)
    {
      String str = QzonePlugin.a(this.a);
      if (this.a.mRuntime.a().getIntent().getExtras().getString("url") != null) {
        str = this.a.mRuntime.a().getIntent().getExtras().getString("url");
      }
      QzonePlugin.a(this.a).loadData(new String(str).replaceAll("#", "%23").replaceAll("%", "%25").replaceAll("'", "%27"), "text/html", "utf-8");
      ((QQBrowserActivity)this.a.mRuntime.a()).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     se
 * JD-Core Version:    0.7.0.1
 */