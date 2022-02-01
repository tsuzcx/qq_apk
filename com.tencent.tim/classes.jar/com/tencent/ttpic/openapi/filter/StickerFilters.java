package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.AEFilterBase;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.List;

public class StickerFilters
  extends AEFilterBase
{
  private boolean isBeforeFaceTransform = false;
  private AIAttr mAIAttr;
  private PTFaceAttr mFaceAttr;
  private List<String> mRenderOrderList;
  private PTSegAttr mSegAttr;
  private AESticker mSticker = null;
  private StickersMap stickersMap;
  
  public StickerFilters(AESticker paramAESticker, boolean paramBoolean)
  {
    super(null, null);
    setBeforeFaceTransform(paramBoolean);
    setSticker(paramAESticker);
    this.stickersMap = new StickersMap();
  }
  
  public void apply() {}
  
  public void clear()
  {
    this.mSticker = null;
    this.stickersMap = null;
  }
  
  public boolean isApplied()
  {
    if (this.mSticker != null) {
      return this.mSticker.isApplied();
    }
    return false;
  }
  
  public boolean isBeforeFaceTransform()
  {
    return this.isBeforeFaceTransform;
  }
  
  public boolean isChangeRenderOrder()
  {
    return (this.mRenderOrderList != null) && (this.mRenderOrderList.size() > 0);
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((this.mSticker == null) || (!this.mSticker.isValid())) {
      return paramFrame;
    }
    setRenderOrderList(this.mSticker);
    if (this.mSticker.isUseStickerPlugin())
    {
      this.mSticker.updateTriggerManager();
      if (this.mSticker != null) {
        paramFrame = this.mSticker.updateInputFrame(paramFrame);
      }
      for (;;)
      {
        this.stickersMap.setRenderOrder(this.mRenderOrderList);
        return this.stickersMap.chainStickerFilters(this.mSticker, paramFrame, this.mFaceAttr, this.mSegAttr, this.mAIAttr);
      }
    }
    if (isBeforeFaceTransform())
    {
      this.mSticker.updateTriggerManager();
      Frame localFrame = paramFrame;
      if (this.mSticker != null) {
        localFrame = this.mSticker.updateInputFrame(paramFrame);
      }
      return this.mSticker.processTransformRelatedFilters(localFrame, this.mFaceAttr, this.mSegAttr, this.mAIAttr);
    }
    return this.mSticker.processStickerFilters(paramFrame, this.mFaceAttr, this.mSegAttr, this.mAIAttr);
  }
  
  public void setAIAttr(AIAttr paramAIAttr)
  {
    this.mAIAttr = paramAIAttr;
  }
  
  public void setBeforeFaceTransform(boolean paramBoolean)
  {
    this.isBeforeFaceTransform = paramBoolean;
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    PTFaceAttr localPTFaceAttr = paramPTFaceAttr;
    if (this.mSticker != null) {
      localPTFaceAttr = this.mSticker.updatePTFaceAttr(paramPTFaceAttr);
    }
    this.mFaceAttr = localPTFaceAttr;
  }
  
  public void setRenderOrderList(AESticker paramAESticker)
  {
    if ((paramAESticker != null) && (paramAESticker.getVideoMateral() != null)) {
      this.mRenderOrderList = paramAESticker.getVideoMateral().getRenderOrderList();
    }
  }
  
  public void setSegAttr(PTSegAttr paramPTSegAttr)
  {
    PTSegAttr localPTSegAttr = paramPTSegAttr;
    if (this.mSticker != null) {
      localPTSegAttr = this.mSticker.updatePTSegAttr(paramPTSegAttr);
    }
    this.mSegAttr = localPTSegAttr;
  }
  
  public void setSticker(AESticker paramAESticker)
  {
    this.mSticker = paramAESticker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.StickerFilters
 * JD-Core Version:    0.7.0.1
 */