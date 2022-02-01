package com.tencent.qqmini.sdk.widget.media;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$7
  implements AbsVideoPlayer.OnVideoPreparedListener
{
  MiniAppVideoPlayer$7(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onVideoPrepared(AbsVideoPlayer paramAbsVideoPlayer)
  {
    if (!this.this$0.playingBefore) {
      return;
    }
    JSONObject localJSONObject;
    if (!this.this$0.pageWebview.getClass().getName().equals("AppBrandService"))
    {
      MiniAppVideoPlayer.access$2600(this.this$0, "waiting");
      MiniAppVideoPlayer.access$2702(this.this$0, false);
      MiniAppVideoPlayer.access$2800(this.this$0, false);
      this.this$0.playingBefore = true;
      if (MiniAppVideoPlayer.access$2900(this.this$0))
      {
        if (MiniAppVideoPlayer.access$800(this.this$0).isPlaying()) {
          MiniAppVideoPlayer.access$800(this.this$0).pause();
        }
        ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.7.1(this));
        MiniAppVideoPlayer.access$2902(this.this$0, false);
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("videoId", this.this$0.videoId);
          localJSONObject.put("data", this.this$0.data);
          if (this.this$0.mMiniAppContext == null) {
            break label247;
          }
          paramAbsVideoPlayer = (IMiniAppContext)this.this$0.mMiniAppContext.get();
          if (paramAbsVideoPlayer != null) {
            paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoWaiting", localJSONObject.toString(), this.this$0.webviewId));
          }
          this.this$0.pageWebview.evaluateSubscribeJS("onVideoWaiting", localJSONObject.toString(), this.this$0.webviewId);
        }
        catch (JSONException paramAbsVideoPlayer)
        {
          paramAbsVideoPlayer.printStackTrace();
        }
        break;
        label247:
        paramAbsVideoPlayer = null;
      }
    }
    MiniAppVideoPlayer.access$800(this.this$0).start();
    this.this$0.postDelayed(new MiniAppVideoPlayer.7.2(this), 200L);
    if (!this.this$0.pageWebview.getClass().getName().equals("AppBrandService"))
    {
      MiniAppVideoPlayer.access$2600(this.this$0, "play");
      MiniAppVideoPlayer.access$3000(this.this$0);
      ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.7.3(this));
      paramAbsVideoPlayer = new StringBuilder().append("onVideoPrepared: ").append(MiniAppVideoPlayer.access$800(this.this$0).getDuration()).append(" ").append(MiniAppVideoPlayer.access$800(this.this$0).getCurrentPostion()).append(" ");
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label576;
      }
    }
    label571:
    label576:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MiniAppVideoPlayer", bool);
      MiniAppVideoPlayer.access$3700(this.this$0, 200L);
      return;
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("videoId", this.this$0.videoId);
          localJSONObject.put("data", this.this$0.data);
          if (this.this$0.mMiniAppContext == null) {
            break label571;
          }
          paramAbsVideoPlayer = (IMiniAppContext)this.this$0.mMiniAppContext.get();
          if (paramAbsVideoPlayer != null) {
            paramAbsVideoPlayer.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", localJSONObject.toString(), this.this$0.webviewId));
          }
          this.this$0.pageWebview.evaluateSubscribeJS("onVideoPlay", localJSONObject.toString(), this.this$0.webviewId);
          QMLog.d("MiniAppVideoPlayer", "OnVideoPreparedListener - onVideoPrepared evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
        }
        catch (JSONException paramAbsVideoPlayer)
        {
          paramAbsVideoPlayer.printStackTrace();
        }
        break;
        paramAbsVideoPlayer = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.7
 * JD-Core Version:    0.7.0.1
 */