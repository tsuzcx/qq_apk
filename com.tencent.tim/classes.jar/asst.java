import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin(secondary=true)
public class asst
  extends BaseJsPlugin
{
  @JsEvent({"refreshQzoneFeed"})
  public void refreshQzoneFeed(RequestEvent paramRequestEvent)
  {
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent("action_personalize_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "refreshFeed");
      localIntent.putExtras(localBundle);
      avpw.a(localActivity, avpw.d.a(), localIntent);
      paramRequestEvent.ok();
      if (QLog.isColorLevel()) {
        QLog.i("RefreshQzoneFeedPlugin", 2, "RefreshQzoneFeed");
      }
      return;
    }
    QLog.e("RefreshQzoneFeedPlugin", 1, "activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asst
 * JD-Core Version:    0.7.0.1
 */