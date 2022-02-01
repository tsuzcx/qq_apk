package com.tencent.tavcut.session;

import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.HashMap;

class TAVCutSession$6
  implements Runnable
{
  TAVCutSession$6(TAVCutSession paramTAVCutSession, MediaModel paramMediaModel, HashMap paramHashMap, String paramString, long paramLong1, int paramInt, float paramFloat1, float paramFloat2, long paramLong2, VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void run()
  {
    AEKitModel localAEKitModel2 = this.val$mediaModel.getMediaEffectModel().getAeKitModel();
    AEKitModel localAEKitModel1 = localAEKitModel2;
    if (localAEKitModel2 == null) {
      localAEKitModel1 = new AEKitModel();
    }
    if (this.val$adjustParams != null) {}
    for (boolean bool = true;; bool = false)
    {
      localAEKitModel1.setEnableAIFilter(bool);
      localAEKitModel1.setAdjustParams(this.val$adjustParams);
      localAEKitModel1.setLutPath(this.val$lutPath);
      localAEKitModel1.setStartTime(this.val$startTime);
      localAEKitModel1.setSmoothLevel(this.val$smoothLevel);
      localAEKitModel1.setLutAlpha(this.val$lutStrength);
      localAEKitModel1.setGlowAlpha(this.val$glowAlpha);
      localAEKitModel1.setDuration(this.val$duration);
      this.val$mediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel1);
      this.this$0.updateRenderChain(this.val$renderChainManager, this.val$mediaModel.getMediaEffectModel());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.6
 * JD-Core Version:    0.7.0.1
 */