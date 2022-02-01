package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;

class NetLivenessReqResultState$4
  implements YtSDKKitFramework.IYtSDKKitNetResponseParser
{
  NetLivenessReqResultState$4(NetLivenessReqResultState paramNetLivenessReqResultState) {}
  
  public void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    YtLogger.d(NetLivenessReqResultState.access$000(), "Parse action response");
    NetLivenessReqResultState.access$100(this.this$0, paramHashMap, paramException);
    NetLivenessReqResultState.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.4
 * JD-Core Version:    0.7.0.1
 */