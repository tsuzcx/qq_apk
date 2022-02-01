package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.composition.image.WSImageRender;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutImageSession$3
  implements MediaBuilderListener
{
  TAVCutImageSession$3(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    this.this$0.renderChainManagers.put(this.val$index, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(this.val$index, paramVideoRenderChainManager.getComposition());
    int j = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int k = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    int m = BitmapUtil.getImageRotation((String)TAVCutImageSession.access$000(this.this$0).get(this.val$index));
    int i;
    if (m != 90)
    {
      paramInt = k;
      i = j;
      if (m != 270) {}
    }
    else
    {
      i = k;
      paramInt = j;
    }
    paramMediaBuilderOutput = new WSImageRender();
    paramVideoRenderChainManager.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
    CropModel localCropModel = ((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaEffectModel().getCropModel();
    k = paramInt;
    j = i;
    if (localCropModel != null)
    {
      k = paramInt;
      j = i;
      if (localCropModel.getCropConfig() != null)
      {
        j = (int)(i * localCropModel.getCropConfig().getWidth());
        float f = paramInt;
        k = (int)(localCropModel.getCropConfig().getHeight() * f);
      }
    }
    this.this$0.constrainRenderSize(j, k, paramVideoRenderChainManager);
    paramMediaBuilderOutput.init(paramVideoRenderChainManager.getComposition(), paramVideoRenderChainManager.getComposition().getRenderSize());
    TAVCutImageSession.access$300(this.this$0).put(this.val$index, paramMediaBuilderOutput);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.3
 * JD-Core Version:    0.7.0.1
 */