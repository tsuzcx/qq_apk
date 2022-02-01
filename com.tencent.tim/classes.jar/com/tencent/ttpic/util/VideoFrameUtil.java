package com.tencent.ttpic.util;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.EffectTriggerFilter;
import com.tencent.ttpic.openapi.filter.ComicEffectFilter;

public class VideoFrameUtil
{
  public static Frame renderProcessByCopy(int paramInt1, int paramInt2, int paramInt3, VideoFilterBase paramVideoFilterBase, BaseFilter paramBaseFilter, Frame paramFrame1, Frame paramFrame2)
  {
    if (paramFrame1.getTextureId() == paramInt1) {}
    for (;;)
    {
      paramBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramFrame2);
      paramVideoFilterBase.OnDrawFrameGLSL();
      paramVideoFilterBase.renderTexture(paramInt1, paramInt2, paramInt3);
      return paramFrame2;
      paramFrame2 = paramFrame1;
    }
  }
  
  public static Frame renderProcessByForAnimationEffectFilter(int paramInt1, int paramInt2, int paramInt3, ComicEffectFilter paramComicEffectFilter, Frame paramFrame1, Frame paramFrame2)
  {
    if (paramFrame1.getTextureId() == paramInt1) {}
    for (;;)
    {
      FrameUtil.clearFrame(paramFrame2, 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, paramInt3);
      paramComicEffectFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramFrame2);
      return paramFrame2;
      paramFrame2 = paramFrame1;
    }
  }
  
  public static Frame renderProcessByForEffectTriggerFilter(int paramInt1, int paramInt2, int paramInt3, EffectTriggerFilter paramEffectTriggerFilter, Frame paramFrame1, Frame paramFrame2)
  {
    if (paramFrame1.getTextureId() == paramInt1) {}
    for (;;)
    {
      paramEffectTriggerFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramFrame2);
      return paramFrame2;
      paramFrame2 = paramFrame1;
    }
  }
  
  public static Frame renderProcessBySwitchFbo(int paramInt1, int paramInt2, int paramInt3, VideoFilterBase paramVideoFilterBase, Frame paramFrame1, Frame paramFrame2)
  {
    if (paramFrame1.getTextureId() == paramInt1) {}
    for (;;)
    {
      paramVideoFilterBase.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramFrame2);
      return paramFrame2;
      paramFrame2 = paramFrame1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFrameUtil
 * JD-Core Version:    0.7.0.1
 */