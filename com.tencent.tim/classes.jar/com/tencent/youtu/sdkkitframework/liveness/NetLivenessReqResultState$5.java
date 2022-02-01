package com.tencent.youtu.sdkkitframework.liveness;

import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2.UploadVideoResponse;
import java.util.HashMap;

class NetLivenessReqResultState$5
  implements YtSDKKitFramework.IYtSDKKitNetResponseParser
{
  NetLivenessReqResultState$5(NetLivenessReqResultState paramNetLivenessReqResultState, UploadVideoRequesterV2.UploadVideoResponse paramUploadVideoResponse) {}
  
  public void onNetworkResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    if (paramException != null) {
      this.val$uploadVideoResponseV2.onFailed(1, paramException.getLocalizedMessage());
    }
    for (;;)
    {
      NetLivenessReqResultState.access$200(this.this$0);
      return;
      this.val$uploadVideoResponseV2.onSuccess((String)paramHashMap.get("response"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState.5
 * JD-Core Version:    0.7.0.1
 */