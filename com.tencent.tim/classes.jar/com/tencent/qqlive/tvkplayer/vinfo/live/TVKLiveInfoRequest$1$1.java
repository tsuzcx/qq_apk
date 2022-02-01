package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.net.ParseException;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;

class TVKLiveInfoRequest$1$1
  implements Runnable
{
  TVKLiveInfoRequest$1$1(TVKLiveInfoRequest.1 param1, String paramString) {}
  
  public void run()
  {
    try
    {
      TVKLiveVideoInfo localTVKLiveVideoInfo1 = this.this$1.this$0.parseOutput(this.val$responseBody);
      if (localTVKLiveVideoInfo1 == null) {
        throw new Exception("parse failed");
      }
    }
    catch (ParseException localParseException)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKLiveInfoRequest.java]", localParseException);
      TVKLiveVideoInfo localTVKLiveVideoInfo2 = new TVKLiveVideoInfo();
      localTVKLiveVideoInfo2.setErrModule(10000);
      localTVKLiveVideoInfo2.setErrInfo("json 解析异常");
      localTVKLiveVideoInfo2.setRetCode(121008);
      TVKLiveInfoRequest.access$300(this.this$1.this$0).onFailure(TVKLiveInfoRequest.access$200(this.this$1.this$0), localTVKLiveVideoInfo2);
      do
      {
        return;
      } while (TVKLiveInfoRequest.access$300(this.this$1.this$0).isCancelled());
      TVKLiveInfoRequest.access$300(this.this$1.this$0).onSuccess(TVKLiveInfoRequest.access$200(this.this$1.this$0), localTVKLiveVideoInfo2);
      return;
    }
    catch (Throwable localThrowable)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKLiveInfoRequest.java]", localThrowable);
      TVKLiveVideoInfo localTVKLiveVideoInfo3 = new TVKLiveVideoInfo();
      localTVKLiveVideoInfo3.setErrModule(10000);
      localTVKLiveVideoInfo3.setErrInfo("网络错误");
      localTVKLiveVideoInfo3.setRetCode(141001);
      TVKLiveInfoRequest.access$300(this.this$1.this$0).onFailure(TVKLiveInfoRequest.access$200(this.this$1.this$0), localTVKLiveVideoInfo3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoRequest.1.1
 * JD-Core Version:    0.7.0.1
 */