package com.tencent.tavcut.session;

import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.HashMap;

class TAVCutSession$5
  implements Runnable
{
  TAVCutSession$5(TAVCutSession paramTAVCutSession, MediaModel paramMediaModel, HashMap paramHashMap, long paramLong1, long paramLong2, VideoRenderChainManager paramVideoRenderChainManager) {}
  
  public void run()
  {
    AEKitModel localAEKitModel2 = this.val$mediaModel.getMediaEffectModel().getAeKitModel();
    AEKitModel localAEKitModel1 = localAEKitModel2;
    if (localAEKitModel2 == null) {
      localAEKitModel1 = new AEKitModel();
    }
    localAEKitModel1.setAdjustParams(this.val$adjustParams);
    localAEKitModel1.setStartTime(this.val$lutStartTime);
    localAEKitModel1.setDuration(this.val$lutDuration);
    this.val$mediaModel.getMediaEffectModel().setAeKitModel(localAEKitModel1);
    this.this$0.updateRenderChain(this.val$renderChainManager, this.val$mediaModel.getMediaEffectModel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.5
 * JD-Core Version:    0.7.0.1
 */