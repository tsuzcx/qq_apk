import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.a;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public final class aikq
  implements EIPCResultCallback
{
  public aikq(JSONObject paramJSONObject, BridgeModule.a parama, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null)) {}
    for (boolean bool = paramEIPCResult.data.getBoolean("action_update_biu_and_comment_switch");; bool = false) {
      try
      {
        this.val$json.put("isGrayscaleUser", bool);
        QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig is " + bool);
        this.a.j(this.val$callBack, this.val$json);
        return;
      }
      catch (JSONException paramEIPCResult)
      {
        for (;;)
        {
          QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig error " + paramEIPCResult.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikq
 * JD-Core Version:    0.7.0.1
 */