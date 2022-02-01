import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class assm
  extends BaseJsPlugin
  implements EIPCResultCallback
{
  private RequestEvent req;
  
  @JsEvent({"checkin_uploadRes"})
  public void checkinUploadRes(RequestEvent paramRequestEvent)
  {
    for (;;)
    {
      int i;
      try
      {
        this.req = paramRequestEvent;
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data");
        QLog.d("GroupCheckInUploadPlugin", 1, "data: " + localJSONObject);
        str1 = ((IMiniAppFileManager)this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(localJSONObject.optString("filePath"));
        if (localJSONObject.optInt("isVideo") != 1) {
          break label274;
        }
        i = 1;
        localBundle = new Bundle();
        if (i == 0) {
          continue;
        }
        String str2 = ((IMiniAppFileManager)this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(localJSONObject.optString("cover"));
        if (!aqhq.fileExists(str1)) {
          break label273;
        }
        if (!aqhq.fileExists(str2)) {
          return;
        }
        localBundle.putString("BUNDLE_NAME_FILEPATH", str1);
        localBundle.putString("BUNDLE_NAME_COVER", str2);
        localBundle.putLong("BUNDLE_NAME_VIDEOTIME", localJSONObject.optLong("videoDuration"));
        if (i == 0) {
          continue;
        }
        QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_VIDEO", localBundle, this);
      }
      catch (JSONException localJSONException)
      {
        String str1;
        Bundle localBundle;
        QLog.e("GroupCheckInUploadPlugin", 1, "checkinUploadRes(). Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
        continue;
        QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_PIC", localBundle, this);
        continue;
      }
      QLog.d("GroupCheckInUploadPlugin", 1, "checkin_uploadRes succeed");
      paramRequestEvent.ok();
      return;
      if (aqhq.fileExists(str1))
      {
        localBundle.putString("BUNDLE_NAME_FILEPATH", str1);
      }
      else
      {
        label273:
        return;
        label274:
        i = 0;
      }
    }
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = paramEIPCResult.code;
    Bundle localBundle = paramEIPCResult.data;
    if (QLog.isColorLevel()) {
      QLog.d("GroupCheckInUploadPlugin", 2, "result = " + i + ", data = " + localBundle.toString());
    }
    paramEIPCResult = new JSONObject();
    for (;;)
    {
      try
      {
        int j = localBundle.getInt("isVideo");
        int k = localBundle.getInt("result");
        if (k != 1) {
          break label275;
        }
        i = 1;
        paramEIPCResult.put("isVideo", j);
        paramEIPCResult.put("result", k);
        if (j != 1) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramEIPCResult.put("url", localBundle.getString("url"));
        paramEIPCResult.put("vid", localBundle.getString("vid"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (this.req == null) {
          break label274;
        }
        this.req.fail(paramEIPCResult, "");
        return;
        if (i == 0) {
          continue;
        }
        paramEIPCResult.put("url", localException.getString("url"));
        continue;
        paramEIPCResult.put("error", localException.getString("error"));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GroupCheckInUploadPlugin", 2, "onCallback json = " + paramEIPCResult.toString());
      }
      if (this.req != null)
      {
        this.req.ok(paramEIPCResult);
        return;
        paramEIPCResult.put("error", localBundle.getString("error"));
      }
      else
      {
        label274:
        return;
        label275:
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_CANCEL", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assm
 * JD-Core Version:    0.7.0.1
 */