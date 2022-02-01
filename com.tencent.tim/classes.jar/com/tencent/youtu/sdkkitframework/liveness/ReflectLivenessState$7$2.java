package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import java.util.HashMap;

class ReflectLivenessState$7$2
  extends HashMap<String, Object>
{
  ReflectLivenessState$7$2(ReflectLivenessState.7 param7, String paramString1, YuvImage paramYuvImage, String paramString2, int paramInt)
  {
    put("ui_tips", "rst_succeed");
    put("process_action", "succeed");
    put("message", this.val$info);
    put("extra_message", this.val$bestImage);
    put("cmp_message", this.val$cmpInfo);
    put("cmp_score", Integer.valueOf(this.val$simi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState.7.2
 * JD-Core Version:    0.7.0.1
 */