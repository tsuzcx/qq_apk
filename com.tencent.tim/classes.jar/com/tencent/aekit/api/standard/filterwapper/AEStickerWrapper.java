package com.tencent.aekit.api.standard.filterwapper;

import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.api.standard.filter.AESticker.STICKER_TYPE;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;

public class AEStickerWrapper
{
  private AESticker aeSticker;
  
  public AEStickerWrapper(VideoMaterial paramVideoMaterial, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.aeSticker = new AESticker(paramVideoMaterial, paramVideoPreviewFaceOutlineDetector);
  }
  
  public void apply()
  {
    this.aeSticker.apply();
  }
  
  public boolean checkStickerType(AESticker.STICKER_TYPE paramSTICKER_TYPE)
  {
    return this.aeSticker.checkStickerType(paramSTICKER_TYPE);
  }
  
  public void clear()
  {
    this.aeSticker.clear();
  }
  
  public boolean is3DCosMaterial()
  {
    return this.aeSticker.is3DCosMaterial();
  }
  
  public boolean needDetectBody()
  {
    return this.aeSticker.needDetectBody();
  }
  
  public boolean needDetectEmotion()
  {
    return this.aeSticker.needDetectEmotion();
  }
  
  public boolean needDetectGesture()
  {
    return this.aeSticker.needDetectGesture();
  }
  
  public Frame processStickerFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    return this.aeSticker.processStickerFilters(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
  }
  
  public Frame processTransformRelatedFilters(Frame paramFrame, PTFaceAttr paramPTFaceAttr, PTSegAttr paramPTSegAttr, AIAttr paramAIAttr)
  {
    return this.aeSticker.processTransformRelatedFilters(paramFrame, paramPTFaceAttr, paramPTSegAttr, paramAIAttr);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.aeSticker.setRenderMode(paramInt);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.aeSticker.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filterwapper.AEStickerWrapper
 * JD-Core Version:    0.7.0.1
 */