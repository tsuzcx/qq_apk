import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager.a;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class axrm
  extends BroadcastReceiver
{
  public axrm(QIMMusicConfigManager paramQIMMusicConfigManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic"))) {
        break label43;
      }
    }
    for (;;)
    {
      return;
      label43:
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "onReceive:" + paramContext);
      }
      try
      {
        localJSONObject = new JSONObject(paramContext);
        int i = localJSONObject.optInt("id");
        paramContext = this.this$0.b(i);
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              boolean bool = localJSONObject.optBoolean("is_from_story", false);
              if (paramContext != null) {
                continue;
              }
              paramIntent = QIMMusicConfigManager.a(this.this$0, localJSONObject, bool);
              paramContext = paramIntent;
            }
            catch (JSONException paramIntent)
            {
              JSONObject localJSONObject;
              continue;
              continue;
            }
            try
            {
              paramContext.mSongMid = localJSONObject.optString("mid");
              if (QIMMusicConfigManager.a(this.this$0) == null) {
                break;
              }
              paramIntent = QIMMusicConfigManager.a(this.this$0).iterator();
              if (!paramIntent.hasNext()) {
                break;
              }
              ((QIMMusicConfigManager.a)paramIntent.next()).f(paramContext);
              continue;
              paramIntent = paramIntent;
              paramContext = null;
            }
            catch (JSONException paramIntent) {}
          }
          if (QLog.isColorLevel()) {
            QLog.e("QIMMusicConfigManager", 2, QLog.getStackTraceString(paramIntent));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrm
 * JD-Core Version:    0.7.0.1
 */