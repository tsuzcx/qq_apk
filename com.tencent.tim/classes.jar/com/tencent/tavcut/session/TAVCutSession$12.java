package com.tencent.tavcut.session;

import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;

class TAVCutSession$12
  implements Runnable
{
  TAVCutSession$12(TAVCutSession paramTAVCutSession, MediaModel paramMediaModel, float paramFloat, VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void run()
  {
    AEKitModel localAEKitModel = this.val$mediaModel.getMediaEffectModel().getAeKitModel();
    if ((localAEKitModel == null) || (localAEKitModel.getLutPath() == null)) {
      return;
    }
    localAEKitModel.setLutAlpha(this.val$lutAlpha);
    this.this$0.updateRenderChain(this.val$renderChainManager, this.val$mediaModel.getMediaEffectModel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.12
 * JD-Core Version:    0.7.0.1
 */