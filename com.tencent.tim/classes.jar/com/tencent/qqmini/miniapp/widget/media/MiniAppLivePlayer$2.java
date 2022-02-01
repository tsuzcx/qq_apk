package com.tencent.qqmini.miniapp.widget.media;

import com.tencent.qqmini.miniapp.widget.media.live.TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePlayer$2
  implements TXLivePlayerJSAdapter.ITXAudioVolumeEvaluationOuterListener
{
  MiniAppLivePlayer$2(MiniAppLivePlayer paramMiniAppLivePlayer, RequestEvent paramRequestEvent) {}
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    QMLog.d("MiniAppLivePlayer", "onAudioVolumeEvaluationNotify code:" + paramInt);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("livePlayerId", this.this$0.livePlayerId);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("volume", paramInt);
      localJSONObject1.put("info", localJSONObject2);
      this.val$req.jsService.evaluateSubscribeJS("onLivePlayerAudioVolumeNotify", localJSONObject1.toString(), this.this$0.webviewId);
      if (QMLog.isColorLevel()) {
        QMLog.e("MiniAppLivePlayer", "onAudioVolumeEvaluationNotify resultObj.toString() = " + localJSONObject1.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.2
 * JD-Core Version:    0.7.0.1
 */