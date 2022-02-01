package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import java.util.HashMap;

class NetFetchState$2
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  NetFetchState$2(NetFetchState paramNetFetchState) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    YtFSM.getInstance().sendFSMEvent(new NetFetchState.2.2(this, paramInt, paramString1, paramString2));
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    paramLiveStyleResponse = new WeJson().toJson(paramYTLiveStyleReq);
    NetFetchState.access$000(this.this$0).put("select_data", paramYTLiveStyleReq.select_data);
    if ((!NetFetchState.access$100(this.this$0).isEmpty()) && (NetFetchState.access$200(this.this$0)))
    {
      YtLogger.d(NetFetchState.access$300(), "Use local data");
      NetFetchState.access$400(this.this$0).put("color_data", NetFetchState.access$100(this.this$0));
      NetFetchState.access$500(this.this$0).put("action_data", "0");
      this.this$0.moveToNextState();
      return;
    }
    YtLogger.d(NetFetchState.access$300(), "Use online data ---> on get config info: " + paramLiveStyleResponse);
    YtFSM.getInstance().sendNetworkRequset(NetFetchState.access$600(this.this$0), paramLiveStyleResponse, null, new NetFetchState.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState.2
 * JD-Core Version:    0.7.0.1
 */