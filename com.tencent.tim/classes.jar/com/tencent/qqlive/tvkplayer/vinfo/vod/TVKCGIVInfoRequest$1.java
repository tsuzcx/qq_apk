package com.tencent.qqlive.tvkplayer.vinfo.vod;

import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import java.io.IOException;

class TVKCGIVInfoRequest$1
  implements ITVKHttpProcessor.ITVKHttpCallback
{
  TVKCGIVInfoRequest$1(TVKCGIVInfoRequest paramTVKCGIVInfoRequest) {}
  
  public void onFailure(IOException paramIOException)
  {
    TVKCGIVInfoRequest.access$100(this.this$0, paramIOException);
  }
  
  public void onSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    TVKCGIVInfoRequest.access$000(this.this$0, paramHttpResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIVInfoRequest.1
 * JD-Core Version:    0.7.0.1
 */