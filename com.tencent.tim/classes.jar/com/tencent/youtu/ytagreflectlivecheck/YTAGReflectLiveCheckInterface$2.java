package com.tencent.youtu.ytagreflectlivecheck;

import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTLogger;

final class YTAGReflectLiveCheckInterface$2
  extends TimerWorker
{
  YTAGReflectLiveCheckInterface$2(long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onFinish] ");
    if (YTAGReflectLiveCheckInterface.access$200() != null)
    {
      YTAGReflectLiveCheckInterface.access$200().onSuccess(new LiveStyleRequester.YTLiveStyleReq(-2.0F, YTAGReflectLiveCheckInterface.mAppId), new LiveStyleResponse());
      YTAGReflectLiveCheckInterface.access$202(null);
    }
  }
  
  public void onTick(long paramLong)
  {
    YTLogger.i("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType.onTick] onTick");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.2
 * JD-Core Version:    0.7.0.1
 */