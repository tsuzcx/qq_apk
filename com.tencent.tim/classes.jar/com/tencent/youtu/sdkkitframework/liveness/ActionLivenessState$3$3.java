package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectGetBestImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class ActionLivenessState$3$3
  implements YTPoseDetectInterface.PoseDetectGetBestImage
{
  ActionLivenessState$3$3(ActionLivenessState.3 param3) {}
  
  public void onGetBestImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    YtLogger.d(ActionLivenessState.access$200(), "获取到最优图. width:" + paramInt1 + " height: " + paramInt2 + " bytes size: " + paramArrayOfByte.length);
    paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
    ActionLivenessState.access$1500(this.this$1.this$0).put("best_frame", paramArrayOfByte);
    Collections.sort(ActionLivenessState.access$1600(this.this$1.this$0), new ActionLivenessState.BestFrameEyeRating(this.this$1.this$0));
    paramInt2 = Math.min(ActionLivenessState.access$1600(this.this$1.this$0).size(), 5);
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramArrayOfByte.add(ActionLivenessState.access$1600(this.this$1.this$0).get(paramInt1));
      paramInt1 += 1;
    }
    ActionLivenessState.access$1700(this.this$1.this$0).put("frame_list", paramArrayOfByte);
    ActionLivenessState.access$1800(this.this$1.this$0).put("act_reflect_data", ActionLivenessState.access$900(this.this$1.this$0));
    ActionLivenessState.access$1402(this.this$1.this$0, YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState.3.3
 * JD-Core Version:    0.7.0.1
 */