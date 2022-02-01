package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import org.json.JSONArray;

class MediaJsPlugin$1
  implements Runnable
{
  MediaJsPlugin$1(MediaJsPlugin paramMediaJsPlugin, int paramInt, RequestEvent paramRequestEvent, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 0;
    CoverView localCoverView = CoverViewAction.obtain(MediaJsPlugin.access$000(this.this$0)).get(this.val$videoPlayerId);
    if ((localCoverView == null) || (!(localCoverView instanceof CoverVideoView)))
    {
      this.val$req.fail();
      return;
    }
    if ("play".equals(this.val$type)) {
      ((CoverVideoView)localCoverView).playWithUi();
    }
    do
    {
      for (;;)
      {
        this.this$0.callbackJsEventOK(this.val$req, this.val$type, null, this.val$videoPlayerId);
        return;
        if ("pause".equals(this.val$type))
        {
          ((CoverVideoView)localCoverView).pauseWithUi();
        }
        else if ("stop".equals(this.val$type))
        {
          ((CoverVideoView)localCoverView).stop();
        }
        else if (("seek".equals(this.val$type)) && (!TextUtils.isEmpty(this.val$data)))
        {
          try
          {
            JSONArray localJSONArray1 = new JSONArray(this.val$data);
            if (localJSONArray1.length() == 1)
            {
              i = (int)(localJSONArray1.getDouble(0) * 1000.0D);
              bool = ((CoverVideoView)localCoverView).seekTo(i);
              if (bool) {
                continue;
              }
              this.this$0.callbackJsEventFail(this.val$req, this.val$type, null, this.val$videoPlayerId);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              QMLog.e("MediaJsPlugin", "wrong seek pram. " + this.val$data);
              boolean bool = false;
            }
          }
        }
        else if (("playbackRate".equals(this.val$type)) && (!TextUtils.isEmpty(this.val$data)))
        {
          QMLog.e("MediaJsPlugin", "playbackRate is not support.");
        }
        else if ("requestFullScreen".equals(this.val$type))
        {
          if (!((CoverVideoView)localCoverView).isFullScreen()) {
            ((CoverVideoView)localCoverView).fullScreen();
          }
        }
        else
        {
          if (!"exitFullScreen".equals(this.val$type)) {
            break;
          }
          if (((CoverVideoView)localCoverView).isFullScreen()) {
            ((CoverVideoView)localCoverView).smallScreen();
          }
        }
      }
    } while (!"sendDanmu".equals(this.val$type));
    for (;;)
    {
      JSONArray localJSONArray2;
      try
      {
        localJSONArray2 = new JSONArray(this.val$data);
        if (localJSONArray2.length() != 2) {
          break label467;
        }
        String str1 = localJSONArray2.getString(0);
        i = ColorUtils.parseColor(localJSONArray2.getString(1));
        ((CoverVideoView)localCoverView).playDanmu(str1, i);
      }
      catch (Exception localException2)
      {
        QMLog.e("MediaJsPlugin", "sendDanmu error." + localException2);
        this.this$0.callbackJsEventFail(this.val$req, this.val$type, null, this.val$videoPlayerId);
      }
      break;
      label467:
      String str2;
      if (localJSONArray2.length() == 1) {
        str2 = localJSONArray2.getString(0);
      } else {
        str2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */