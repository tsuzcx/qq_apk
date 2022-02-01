package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavcut.aifilter.AIFilterModel;
import com.tencent.tavcut.aifilter.TavAIFilter;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

@Deprecated
public class AIFilterNode
  implements TAVVideoEffect
{
  private AIFilterModel mAIFilterModel;
  private final String sEffectId = "AIFilterNode" + Integer.toHexString(hashCode());
  
  public TAVVideoEffect.Filter createFilter()
  {
    Logger.i("TAVAIFilter", "creating");
    return new AIFilter();
  }
  
  @Nullable
  public String effectId()
  {
    if (this.mAIFilterModel == null) {
      return "";
    }
    return this.sEffectId;
  }
  
  public void setAIFilterModel(AIFilterModel paramAIFilterModel)
  {
    Logger.i("TAVAIFilter", "set ai filter model");
    this.mAIFilterModel = paramAIFilterModel;
  }
  
  class AIFilter
    implements TAVVideoEffect.Filter
  {
    private TextureInfo inTextureInfo;
    TavAIFilter mEffect;
    private TextureInfo outTextureInfo;
    
    public AIFilter()
    {
      Logger.i("TAVAIFilter", "constructing");
      this.mEffect = new TavAIFilter();
      if (AIFilterNode.this.mAIFilterModel != null) {
        this.mEffect.setParams(AIFilterNode.this.mAIFilterModel.getConfig());
      }
    }
    
    @NonNull
    public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
    {
      Logger.i("TAVAIFilter", "applying");
      if (this.mEffect == null) {}
      do
      {
        long l;
        do
        {
          do
          {
            return paramCIImage;
            paramTAVVideoEffect = paramRenderInfo.getCiContext();
          } while ((paramTAVVideoEffect == null) || (paramTAVVideoEffect.getRenderContext() == null));
          l = paramRenderInfo.getTime().getTimeUs() / 1000L;
        } while ((AIFilterNode.this.mAIFilterModel != null) && ((l < AIFilterNode.this.mAIFilterModel.getStartTime()) || (l > AIFilterNode.this.mAIFilterModel.getStartTime() + AIFilterNode.this.mAIFilterModel.getDuration())));
        int i = (int)paramCIImage.getSize().width;
        int j = (int)paramCIImage.getSize().height;
        if (this.inTextureInfo == null)
        {
          paramTAVVideoEffect.getRenderContext().makeCurrent();
          this.inTextureInfo = CIContext.newTextureInfo(i, j);
        }
        if ((this.inTextureInfo.width != i) || (this.inTextureInfo.height != j))
        {
          paramTAVVideoEffect.getRenderContext().makeCurrent();
          this.inTextureInfo.release();
          this.inTextureInfo = CIContext.newTextureInfo(i, j);
        }
        paramTAVVideoEffect.convertImageToTexture(paramCIImage, this.inTextureInfo);
        paramTAVVideoEffect = new Frame();
      } while (this.inTextureInfo == null);
      paramTAVVideoEffect.setSizedTexture(this.inTextureInfo.textureID, this.inTextureInfo.width, this.inTextureInfo.height);
      return new CIImage(this.outTextureInfo);
    }
    
    public void release()
    {
      Logger.i("TAVAIFilter", "releasing");
      if (this.mEffect != null) {
        this.mEffect.release();
      }
      if ((this.inTextureInfo != null) && (!this.inTextureInfo.isReleased())) {
        this.inTextureInfo.release();
      }
      if ((this.outTextureInfo != null) && (!this.outTextureInfo.isReleased())) {
        this.outTextureInfo.release();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AIFilterNode
 * JD-Core Version:    0.7.0.1
 */