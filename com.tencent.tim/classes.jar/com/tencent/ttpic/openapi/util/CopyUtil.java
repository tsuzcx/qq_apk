package com.tencent.ttpic.openapi.util;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class CopyUtil
{
  private static Frame copyFrame = new Frame();
  private static boolean isInited = false;
  private static BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  
  public static void clear()
  {
    isInited = false;
    mCopyFilter.ClearGLSL();
    copyFrame.unlock();
    copyFrame.clear();
  }
  
  public static void copy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!isInited) {
      init();
    }
    mCopyFilter.setRotationAndFlip(0, 0, 0);
    mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, 0.0D, copyFrame);
    mCopyFilter.setRotationAndFlip(0, 0, 0);
  }
  
  public static void copy(Frame paramFrame, int paramInt)
  {
    if (!isInited) {
      init();
    }
    mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, paramInt, 0.0D, copyFrame);
  }
  
  private static void init()
  {
    mCopyFilter.applyFilterChain(true, 0.0F, 0.0F);
    isInited = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.CopyUtil
 * JD-Core Version:    0.7.0.1
 */