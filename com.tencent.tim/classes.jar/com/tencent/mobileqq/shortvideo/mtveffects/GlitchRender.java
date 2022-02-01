package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class GlitchRender
{
  private static final String TAG = "GlitchRender";
  private int mDisColorH = -1;
  private int mDisColorV = -1;
  private GlitchFilter mGlitchFiler;
  private MaterialFilter mMaterialFilter;
  private float mMaxDisH = 0.5F;
  private float mMaxDisV = 0.5F;
  private RectF mRcSrc = null;
  private RenderBuffer mRenderFBO;
  private RenderBuffer mRenderFBO2;
  private ScaleFilter mScaleFilter;
  
  public boolean init(RectF paramRectF, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2)
  {
    this.mDisColorH = paramInt1;
    this.mDisColorV = paramInt2;
    this.mMaxDisH = paramFloat1;
    this.mMaxDisV = paramFloat2;
    this.mRcSrc = paramRectF;
    paramRectF = new int[1];
    GLES20.glGetIntegerv(35660, paramRectF, 0);
    return paramRectF[0] > 0;
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    if (this.mGlitchFiler != null)
    {
      this.mGlitchFiler.onOutputSizeChanged(paramInt1, paramInt2);
      label25:
      if (this.mScaleFilter == null) {
        break label273;
      }
      this.mScaleFilter.onOutputSizeChanged(paramInt1, paramInt2);
      label41:
      if (this.mMaterialFilter == null) {
        break label303;
      }
      this.mMaterialFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
    for (;;)
    {
      if ((this.mRenderFBO == null) || (this.mRenderFBO.getWidth() != paramInt1) || (this.mRenderFBO.getHeight() != paramInt2))
      {
        if (this.mRenderFBO != null)
        {
          if (this.mRenderFBO.getTexId() >= 0) {
            GlUtil.deleteTexture(this.mRenderFBO.getTexId());
          }
          this.mRenderFBO.destroy();
          this.mRenderFBO = null;
        }
        this.mRenderFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
      }
      if ((this.mRenderFBO2 != null) && (this.mRenderFBO2.getWidth() == paramInt1) && (this.mRenderFBO2.getHeight() == paramInt2)) {
        break;
      }
      if (this.mRenderFBO2 != null)
      {
        if (this.mRenderFBO2.getTexId() >= 0) {
          GlUtil.deleteTexture(this.mRenderFBO2.getTexId());
        }
        this.mRenderFBO2.destroy();
        this.mRenderFBO2 = null;
      }
      this.mRenderFBO2 = new RenderBuffer(paramInt1, paramInt2, 33984);
      return;
      if (this.mRcSrc != null)
      {
        this.mGlitchFiler = new GlitchFilter(this.mRcSrc);
        this.mGlitchFiler.init();
        this.mGlitchFiler.onOutputSizeChanged(paramInt1, paramInt2);
        break label25;
      }
      this.mGlitchFiler = null;
      break label25;
      label273:
      this.mScaleFilter = new ScaleFilter();
      this.mScaleFilter.init();
      this.mScaleFilter.onOutputSizeChanged(paramInt1, paramInt2);
      break label41;
      label303:
      this.mMaterialFilter = new MaterialFilter();
      this.mMaterialFilter.init();
      this.mMaterialFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (this.mGlitchFiler != null)
    {
      this.mGlitchFiler.destroy();
      this.mGlitchFiler = null;
    }
    if (this.mScaleFilter != null)
    {
      this.mScaleFilter.destroy();
      this.mScaleFilter = null;
    }
    if (this.mMaterialFilter != null)
    {
      this.mMaterialFilter.destroy();
      this.mMaterialFilter = null;
    }
    LayerRenderBase.releaseRenderBuffer(this.mRenderFBO);
    LayerRenderBase.releaseRenderBuffer(this.mRenderFBO2);
  }
  
  public int process(RenderBuffer paramRenderBuffer, int paramInt1, int paramInt2, RectF paramRectF, boolean paramBoolean, int paramInt3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramInt2 < 0) || (paramRenderBuffer == null) || (this.mRcSrc == null) || (paramRectF == null)) {
      return -1;
    }
    long l1 = System.currentTimeMillis();
    if ((paramInt1 >= 0) && (this.mGlitchFiler != null))
    {
      LayerRenderBase.clearColorBuffer(this.mRenderFBO, 0);
      this.mRenderFBO.bind();
      this.mGlitchFiler.updateData(this.mDisColorH, this.mMaxDisH, paramRectF.left - this.mRcSrc.left, this.mDisColorV, this.mMaxDisV, paramRectF.top - this.mRcSrc.top);
      this.mGlitchFiler.process(paramInt1, paramInt2, paramBoolean, paramInt3, true);
      this.mRenderFBO.unbind();
      paramInt1 = this.mRenderFBO.getTexId();
    }
    label249:
    int i;
    for (paramInt2 = 1;; paramInt2 = i)
    {
      long l2 = System.currentTimeMillis();
      Log.d("GlitchRender", "glitch time:" + (l2 - l1));
      l1 = System.currentTimeMillis();
      float f1;
      float f2;
      int j;
      if (((paramRectF.width() != this.mRcSrc.width()) || (paramRectF.height() != this.mRcSrc.height())) && (this.mScaleFilter != null))
      {
        LayerRenderBase.clearColorBuffer(this.mRenderFBO2, 0);
        this.mRenderFBO2.bind();
        if (paramInt2 != 0)
        {
          f1 = paramRectF.left;
          if (paramInt2 == 0) {
            break label456;
          }
          f2 = paramRectF.top;
          this.mScaleFilter.process(paramInt1, f1, f2, paramRectF.width() / this.mRcSrc.width(), paramArrayOfFloat1, paramArrayOfFloat2);
          this.mRenderFBO2.unbind();
          i = this.mRenderFBO2.getTexId();
          j = 1;
        }
      }
      for (;;)
      {
        l2 = System.currentTimeMillis();
        Log.d("GlitchRender", "sclae time:" + (l2 - l1));
        l1 = System.currentTimeMillis();
        if (this.mMaterialFilter != null)
        {
          RectF localRectF;
          label363:
          MaterialFilter localMaterialFilter;
          if (paramInt2 != 0)
          {
            localRectF = new RectF(0.0F, 1.0F, 1.0F, 0.0F);
            paramInt1 = 1;
            paramRenderBuffer.bind();
            localMaterialFilter = this.mMaterialFilter;
            if (paramInt1 == 0) {
              break label538;
            }
            paramRectF = localRectF;
          }
          label538:
          for (;;)
          {
            localMaterialFilter.process(i, localRectF, paramRectF, paramBoolean, paramInt3, paramArrayOfFloat1, paramArrayOfFloat2);
            paramRenderBuffer.unbind();
            l2 = System.currentTimeMillis();
            Log.d("GlitchRender", "final time:" + (l2 - l1));
            return paramRenderBuffer.getTexId();
            f1 = this.mRcSrc.left;
            break;
            label456:
            f2 = this.mRcSrc.top;
            break label249;
            if (j != 0)
            {
              localRectF = new RectF(this.mRcSrc.left, this.mRcSrc.top, this.mRcSrc.left + paramRectF.width(), this.mRcSrc.top + paramRectF.height());
              paramInt1 = 0;
              break label363;
            }
            localRectF = this.mRcSrc;
            paramInt1 = 0;
            break label363;
          }
        }
        return -1;
        j = 0;
        i = paramInt1;
      }
      i = 0;
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.GlitchRender
 * JD-Core Version:    0.7.0.1
 */