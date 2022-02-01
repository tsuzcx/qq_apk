package com.tencent.tavcut.session;

import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;

class TAVCutSession$9
  implements Runnable
{
  TAVCutSession$9(TAVCutSession paramTAVCutSession, MediaModel paramMediaModel, VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void run()
  {
    AEKitModel localAEKitModel2 = this.val$mediaModel.getMediaEffectModel().getAeKitModel();
    AEKitModel localAEKitModel1 = localAEKitModel2;
    if (localAEKitModel2 == null) {
      localAEKitModel1 = new AEKitModel();
    }
    localAEKitModel1.setEnableAIFilter(false);
    localAEKitModel1.setAdjustParams(null);
    localAEKitModel1.setLutPath(null);
    localAEKitModel1.setGlowAlpha(0.0F);
    localAEKitModel1.setLutAlpha(0.0F);
    localAEKitModel1.setSmoothLevel(0);
    this.this$0.updateRenderChain(this.val$renderChainManager, this.val$mediaModel.getMediaEffectModel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.9
 * JD-Core Version:    0.7.0.1
 */