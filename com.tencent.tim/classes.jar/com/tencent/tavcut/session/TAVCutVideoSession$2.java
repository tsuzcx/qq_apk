package com.tencent.tavcut.session;

import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.HashMap;
import java.util.List;

class TAVCutVideoSession$2
  implements Runnable
{
  TAVCutVideoSession$2(TAVCutVideoSession paramTAVCutVideoSession, String paramString, float paramFloat1, HashMap paramHashMap, int paramInt, float paramFloat2) {}
  
  public void run()
  {
    this.this$0.setAEKitAIFilter(this.this$0.getMediaModel(), TAVCutVideoSession.access$100(this.this$0), this.val$lutPath, this.val$lutStrength, this.val$adjustParams, this.val$smoothLevel, this.val$glowAlpha, 0L, ((MediaClipModel)this.this$0.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getSelectTimeDuration());
    TAVCutVideoSession.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.2
 * JD-Core Version:    0.7.0.1
 */