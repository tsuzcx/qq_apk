package com.tencent.tavcut.session;

import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;

class TAVCutSession$11
  implements Runnable
{
  TAVCutSession$11(TAVCutSession paramTAVCutSession, MediaModel paramMediaModel, VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void run()
  {
    this.val$mediaModel.getMediaEffectModel().setAeKitModel(null);
    this.this$0.updateRenderChain(this.val$renderChainManager, this.val$mediaModel.getMediaEffectModel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.11
 * JD-Core Version:    0.7.0.1
 */