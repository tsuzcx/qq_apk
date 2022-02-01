import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class astg
  extends BaseJsPlugin
{
  private asth.a a;
  
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("[mini] WeiyunDownloadFilePlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  @JsEvent({"weiyunDownload"})
  public void weiyunDownload(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject;
    String str;
    try
    {
      localJSONObject = new JSONObject(a(paramRequestEvent).optString("data"));
      str = localJSONObject.getString("action");
      if ((TextUtils.isEmpty(str)) || ((!str.equals("createDownloadTask")) && (!str.equals("pauseDownloadTask")) && (!str.equals("cancelDownloadTask")))) {
        return;
      }
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "create weiyun Download");
      if (this.a == null) {
        this.a = new asth.a(this.mMiniAppContext);
      }
      localJSONObject = new JSONObject(localJSONObject.getString("data"));
      if (str.equals("createDownloadTask"))
      {
        if (this.a.isLegal(localJSONObject))
        {
          this.a.a(localJSONObject, localJSONObject.getString("file_id"), paramRequestEvent);
          paramRequestEvent.ok();
          return;
        }
        paramRequestEvent.fail("download params illegal.");
        return;
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
      return;
    }
    if (str.equals("pauseDownloadTask"))
    {
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "pause weiyun Download");
      this.a.a(localJSONObject.getString("file_id"), paramRequestEvent);
      return;
    }
    if (str.equals("cancelDownloadTask"))
    {
      QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "cacel weiyun Download");
      this.a.b(localJSONObject.getString("file_id"), paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astg
 * JD-Core Version:    0.7.0.1
 */