package com.tencent.superplayer.config;

import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import java.io.IOException;

class PullConfigRequest$1
  implements ITVKHttpProcessor.ITVKHttpCallback
{
  PullConfigRequest$1(PullConfigRequest paramPullConfigRequest) {}
  
  public void onFailure(IOException paramIOException)
  {
    PullConfigRequest.access$100(this.this$0, paramIOException);
  }
  
  public void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    PullConfigRequest.access$000(this.this$0, paramHttpResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.config.PullConfigRequest.1
 * JD-Core Version:    0.7.0.1
 */