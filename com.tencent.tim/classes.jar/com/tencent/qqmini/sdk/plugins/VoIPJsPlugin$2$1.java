package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.JoinRoomListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$2$1
  implements VoIPManager.JoinRoomListener
{
  VoIPJsPlugin$2$1(VoIPJsPlugin.2 param2) {}
  
  public void onError(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, ApiUtil.wrapCallbackFail(this.this$1.val$req.event, localJSONObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException);
      }
    }
  }
  
  public void onJoinRoom(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("openIdList", paramJSONArray);
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, ApiUtil.wrapCallbackOk(this.this$1.val$req.event, localJSONObject).toString());
      VoIPManager.getInstance().setEventListener(new VoIPJsPlugin.2.1.1(this));
      return;
    }
    catch (JSONException paramJSONArray)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", paramJSONArray);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.VoIPJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */