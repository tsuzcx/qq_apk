package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$10
  implements AbsVideoPlayer.OnInfoListener
{
  MiniAppVideoPlayer$10(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onInfo(AbsVideoPlayer paramAbsVideoPlayer, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = null;
    paramAbsVideoPlayer = null;
    QMLog.i("MiniAppVideoPlayer", "onInfo: " + paramInt1 + " " + paramInt1);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return false;
      QMLog.d("MiniAppVideoPlayer", "video player PLAYER_INFO_START_BUFFERING--------------");
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("data", this.this$0.data);
        if (this.this$0.mMiniAppContext != null) {
          paramAbsVideoPlayer = (IMiniAppContext)this.this$0.mMiniAppContext.get();
        }
        if (paramAbsVideoPlayer != null) {
          paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoLoadStart", localJSONObject1.toString(), this.this$0.webviewId));
        }
        this.this$0.pageWebview.evaluateSubscribeJS("onVideoLoadStart", localJSONObject1.toString(), this.this$0.webviewId);
        QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoLoadStart = " + localJSONObject1.toString());
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
      continue;
      QMLog.d("MiniAppVideoPlayer", "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("data", this.this$0.data);
        paramAbsVideoPlayer = localJSONObject1;
        if (this.this$0.mMiniAppContext != null) {
          paramAbsVideoPlayer = (IMiniAppContext)this.this$0.mMiniAppContext.get();
        }
        if (paramAbsVideoPlayer != null) {
          paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoLoadedData", localJSONObject2.toString(), this.this$0.webviewId));
        }
        this.this$0.pageWebview.evaluateSubscribeJS("onVideoLoadedData", localJSONObject2.toString(), this.this$0.webviewId);
        QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoLoadedData = " + localJSONObject2.toString());
      }
      catch (JSONException paramAbsVideoPlayer)
      {
        paramAbsVideoPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.10
 * JD-Core Version:    0.7.0.1
 */