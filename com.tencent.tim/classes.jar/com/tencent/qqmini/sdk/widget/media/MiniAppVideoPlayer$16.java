package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$16
  implements Runnable
{
  MiniAppVideoPlayer$16(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    if ((!MiniAppVideoPlayer.access$2700(this.this$0)) && (MiniAppVideoPlayer.access$5400(this.this$0) == 0)) {}
    label225:
    do
    {
      return;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", this.this$0.data);
          if (!MiniAppVideoPlayer.access$2700(this.this$0)) {
            continue;
          }
          i = MiniAppVideoPlayer.access$5400(this.this$0);
          localJSONObject.put("buffered", i);
          localJSONObject.put("videoId", this.this$0.videoId);
          if (this.this$0.mMiniAppContext == null) {
            continue;
          }
          localIMiniAppContext = (IMiniAppContext)this.this$0.mMiniAppContext.get();
          if (localIMiniAppContext != null) {
            localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoProgress", localJSONObject.toString(), this.this$0.webviewId));
          }
          this.this$0.pageWebview.evaluateSubscribeJS("onVideoProgress", localJSONObject.toString(), this.this$0.webviewId);
          QMLog.d("MiniAppVideoPlayer", "updateBufferProgress onVideoProgress = " + localJSONObject.toString());
        }
        catch (JSONException localJSONException)
        {
          int i;
          IMiniAppContext localIMiniAppContext;
          localJSONException.printStackTrace();
          continue;
        }
        if (MiniAppVideoPlayer.access$2700(this.this$0)) {
          break label225;
        }
        MiniAppVideoPlayer.access$5402(this.this$0, 0);
        return;
        i = 100;
        continue;
        localIMiniAppContext = null;
      }
    } while (MiniAppVideoPlayer.access$5400(this.this$0) > 98);
    if (MiniAppVideoPlayer.access$5400(this.this$0) < 60) {
      MiniAppVideoPlayer.access$5402(this.this$0, MiniAppVideoPlayer.access$5400(this.this$0) + 10);
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$2800(this.this$0, true);
      return;
      if (MiniAppVideoPlayer.access$5400(this.this$0) < 90) {
        MiniAppVideoPlayer.access$5402(this.this$0, MiniAppVideoPlayer.access$5400(this.this$0) + 5);
      } else {
        MiniAppVideoPlayer.access$5408(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.16
 * JD-Core Version:    0.7.0.1
 */