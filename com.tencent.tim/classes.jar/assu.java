import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class assu
  extends BaseJsPlugin
{
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("SetAvatarNativePlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  @JsEvent({"uploadAvatar"})
  public void uploadAvatar(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = a(paramRequestEvent);
      QLog.i("SetAvatarNativePlugin", 1, "onInvoke, param=" + localObject);
      localObject = ((JSONObject)localObject).optJSONObject("data");
      if (localObject == null)
      {
        paramRequestEvent.fail(new JSONObject("empty data"), "empty data");
        return;
      }
      localObject = ((JSONObject)localObject).optString("path", null);
      localObject = ((IMiniAppFileManager)this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath((String)localObject);
      QLog.d("SetAvatarNativePlugin", 1, (String)localObject);
      Bundle localBundle = new Bundle();
      localBundle.putString("param_avatar_path", (String)localObject);
      QIPCClientHelper.getInstance().getClient().callServer("CommonModule", "set_avatar", localBundle, new assu.a(paramRequestEvent));
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("SetAvatarNativePlugin", 1, "setAvatar err", paramRequestEvent);
    }
  }
  
  class a
    implements EIPCResultCallback
  {
    private RequestEvent req;
    
    a(RequestEvent paramRequestEvent)
    {
      this.req = paramRequestEvent;
    }
    
    public void onCallback(EIPCResult paramEIPCResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetAvatarNativePlugin", 2, "onCallback, result=" + paramEIPCResult);
      }
      if (paramEIPCResult == null) {}
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("SetAvatarNativePlugin", 2, "onCallback, result.isSuccess=" + paramEIPCResult.isSuccess());
          }
          paramEIPCResult = paramEIPCResult.data;
          if (paramEIPCResult != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SetAvatarNativePlugin", 2, "onCallback, data is null");
        return;
        localObject = paramEIPCResult.getString("param_action");
        if (QLog.isColorLevel()) {
          QLog.d("SetAvatarNativePlugin", 2, "onCallback, action=" + (String)localObject);
        }
      } while (!"set_avatar".equals(localObject));
      int i = paramEIPCResult.getInt("param_result_code", -1);
      paramEIPCResult = paramEIPCResult.getString("param_result_desc", "null");
      if (QLog.isColorLevel()) {
        QLog.d("SetAvatarNativePlugin", 2, "onCallback, errCode=" + i + ", errDesc=" + paramEIPCResult);
      }
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("param_result_code", i);
        ((JSONObject)localObject).put("param_result_desc", paramEIPCResult);
        label222:
        if (i == 0)
        {
          this.req.ok((JSONObject)localObject);
          return;
        }
        this.req.fail((JSONObject)localObject, paramEIPCResult);
        return;
      }
      catch (Exception localException)
      {
        break label222;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assu
 * JD-Core Version:    0.7.0.1
 */