package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Curve2D;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.filter.ClarityMaskFilter;
import com.tencent.ttpic.openapi.filter.FaceBeautysRealAutoFilter;
import com.tencent.ttpic.openapi.filter.GPUImageTwoInputHighPassFilter;
import com.tencent.ttpic.openapi.filter.LongLegFilter;
import com.tencent.ttpic.openapi.filter.NewFaceColorFilter;
import com.tencent.ttpic.openapi.filter.PtuFilterFactory;
import com.tencent.ttpic.openapi.filter.SlimWaistFilter;
import com.tencent.ttpic.openapi.filter.SmoothBClarifyFilter;
import com.tencent.ttpic.openapi.filter.SmoothBLargeBlurFilter;
import com.tencent.ttpic.openapi.filter.SmoothBProcessFilter;
import com.tencent.ttpic.openapi.filter.SmoothBVarianceFilter;
import com.tencent.ttpic.openapi.filter.SmoothSharpenFilter;
import com.tencent.ttpic.openapi.filter.ThinBodyFilter;
import com.tencent.ttpic.openapi.filter.ThinShoulderFilter;
import com.tencent.ttpic.openapi.model.CameraFilterParamSDK;
import com.tencent.ttpic.util.FrameUtil;
import java.util.List;
import java.util.Map;

public class PTFilter
{
  protected BaseFilter mFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  protected Frame mFilterFrame = new Frame();
  
  @Deprecated
  public static PTFilter createByFile(String paramString)
  {
    return null;
  }
  
  public static PTFilter createById(int paramInt1, int paramInt2)
  {
    PTFilter localPTFilter = new PTFilter();
    localPTFilter.mFilter = PtuFilterFactory.createFilter(paramInt1);
    localPTFilter.mFilter.needFlipBlend = true;
    localPTFilter.mFilter.setSrcFilterIndex(-1);
    localPTFilter.mFilter.setEffectIndex(paramInt2);
    return localPTFilter;
  }
  
  public static PTFilter createByLut(String paramString)
  {
    PTFilter localPTFilter = new PTFilter();
    Bitmap localBitmap2 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
    }
    localPTFilter.mFilter = TTPicFilterFactoryLocal.lutFilterWithBitmap(localBitmap1);
    if (localPTFilter.mFilter == null) {
      return null;
    }
    localPTFilter.mFilter.needFlipBlend = true;
    localPTFilter.mFilter.setSrcFilterIndex(-1);
    localPTFilter.mFilterFrame = new Frame();
    return localPTFilter;
  }
  
  public static PTFilter createCopyFilter()
  {
    return new PTCopyFilter();
  }
  
  public static PTFilter createCurve2D(String paramString)
  {
    return createCurve2D(paramString, null);
  }
  
  public static PTFilter createCurve2D(String paramString, float[] paramArrayOfFloat)
  {
    PTFilter localPTFilter = new PTFilter();
    paramString = new Curve2D(paramString);
    if (paramArrayOfFloat != null) {
      paramString.setMatrix(paramArrayOfFloat);
    }
    localPTFilter.mFilter = paramString;
    localPTFilter.mFilter.needFlipBlend = true;
    localPTFilter.mFilter.setSrcFilterIndex(-1);
    localPTFilter.mFilterFrame = new Frame();
    return localPTFilter;
  }
  
  public static PTFilter createYUV2RGBAFilter()
  {
    PTFilter localPTFilter = new PTFilter();
    localPTFilter.mFilter = new SurfaceTextureFilter();
    return localPTFilter;
  }
  
  public void destroy()
  {
    this.mFilter.ClearGLSL();
    this.mFilterFrame.clear();
  }
  
  public BaseFilter getFilter()
  {
    return this.mFilter;
  }
  
  public int init()
  {
    this.mFilter.applyFilterChain(true, 1.0F, 1.0F);
    return 0;
  }
  
  public Frame process(Frame paramFrame)
  {
    this.mFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mFilterFrame);
    return FrameUtil.getLastRenderFrame(this.mFilterFrame);
  }
  
  public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
  {
    this.mFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mFilterFrame);
    return FrameUtil.getLastRenderFrame(this.mFilterFrame);
  }
  
  public void processToScreen(Frame paramFrame, int paramInt1, int paramInt2)
  {
    this.mFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, 0, 0.0D, this.mFilterFrame);
  }
  
  public void setFilter(BaseFilter paramBaseFilter)
  {
    this.mFilter = paramBaseFilter;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mFilter.setRenderMode(paramInt);
  }
  
  public static class PTAlphaFilter
    extends PTFilter
  {
    public PTAlphaFilter()
    {
      this.mFilter = new AlphaAdjustFilter();
    }
    
    public int init()
    {
      int i = super.init();
      this.mFilter.setAdjustParam(0.0F);
      this.mFilter.applyFilterChain(true, 0.0F, 0.0F);
      return i;
    }
  }
  
  public static class PTBeautyBodyFilter
    extends PTFilter
  {
    private boolean enable = true;
    BeautyBodyFilter mBeautyBodyFilter = new BeautyBodyFilter();
    private Frame mBeautyBodyFrame = new Frame();
    
    public void beautyBody(float paramFloat, List<PointF> paramList, int paramInt1, int paramInt2)
    {
      this.mBeautyBodyFilter.beautyBody(paramFloat, paramList, paramInt1, paramInt2);
    }
    
    public void beautyBody(float paramFloat, boolean paramBoolean, List<PointF> paramList, int paramInt1, int paramInt2)
    {
      this.mBeautyBodyFilter.beautyBody(paramFloat, paramBoolean, paramList, paramInt1, paramInt2);
    }
    
    public void beautyBody(List<PointF> paramList, int paramInt1, int paramInt2)
    {
      this.mBeautyBodyFilter.beautyBody(paramList, paramInt1, paramInt2);
    }
    
    public void destroy()
    {
      this.mBeautyBodyFilter.clearGLSLSelf();
      this.mBeautyBodyFilter = null;
      this.mBeautyBodyFrame.clear();
      super.destroy();
    }
    
    public float getLongLegStrength()
    {
      return this.mBeautyBodyFilter.getStrength("LONG_LEG");
    }
    
    public float getSlimWaistStrength()
    {
      return this.mBeautyBodyFilter.getStrength("SLIM_WAIST");
    }
    
    public float getThinBodyStrength()
    {
      return this.mBeautyBodyFilter.getStrength("THIN_BODY");
    }
    
    public float getThinShoulderStrength()
    {
      return this.mBeautyBodyFilter.getStrength("THIN_SHOULDER");
    }
    
    public int init()
    {
      int i = super.init();
      if (this.mBeautyBodyFilter == null) {
        this.mBeautyBodyFilter = new BeautyBodyFilter();
      }
      this.mBeautyBodyFilter.ApplyGLSLFilter();
      return i;
    }
    
    public boolean isEnable()
    {
      return this.enable;
    }
    
    public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
    {
      Frame localFrame = paramFrame;
      if (this.enable)
      {
        this.mBeautyBodyFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mBeautyBodyFrame);
        localFrame = this.mBeautyBodyFrame;
      }
      return localFrame;
    }
    
    public void setLongLegEnable(boolean paramBoolean)
    {
      this.mBeautyBodyFilter.setEnableLeg(paramBoolean);
    }
    
    public void setLongLegStrength(float paramFloat)
    {
      if (this.mBeautyBodyFilter != null) {
        this.mBeautyBodyFilter.setStrength("LONG_LEG", paramFloat);
      }
    }
    
    public void setSlimWaistEnable(boolean paramBoolean)
    {
      this.mBeautyBodyFilter.setEnableWaist(paramBoolean);
    }
    
    public void setSlimWaistStrength(float paramFloat)
    {
      if (this.mBeautyBodyFilter != null) {
        this.mBeautyBodyFilter.setStrength("SLIM_WAIST", paramFloat);
      }
    }
    
    public void setThinBodyEnable(boolean paramBoolean)
    {
      this.mBeautyBodyFilter.setEnableBody(paramBoolean);
    }
    
    public void setThinBodyStrength(float paramFloat)
    {
      if (this.mBeautyBodyFilter != null) {
        this.mBeautyBodyFilter.setStrength("THIN_BODY", paramFloat);
      }
    }
    
    public void setThinShoulderEnable(boolean paramBoolean)
    {
      this.mBeautyBodyFilter.setEnableShoulder(paramBoolean);
    }
    
    public void setThinShoulderStrength(float paramFloat)
    {
      if (this.mBeautyBodyFilter != null) {
        this.mBeautyBodyFilter.setStrength("THIN_SHOULDER", paramFloat);
      }
    }
  }
  
  public static class PTClarityMaskFilter
    extends PTFilter
  {
    private boolean hasApply = false;
    private ClarityMaskFilter mClarityMaskFilter = new ClarityMaskFilter();
    private Frame mClarityMaskFrame = new Frame();
    private SmoothSharpenFilter mSmoothSharpenFilter = new SmoothSharpenFilter();
    private Frame mSmoothSharpenFrame = new Frame();
    
    public void destroy()
    {
      this.mClarityMaskFilter.clearGLSLSelf();
      this.mSmoothSharpenFilter.clearGLSLSelf();
      this.mClarityMaskFrame.clear();
      this.mSmoothSharpenFrame.clear();
      this.hasApply = false;
      super.destroy();
    }
    
    public int init()
    {
      return super.init();
    }
    
    public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
    {
      if (!this.hasApply)
      {
        this.mClarityMaskFilter.applyFilterChain(true, paramInt1, paramInt2);
        this.mSmoothSharpenFilter.applyFilterChain(true, paramInt1, paramInt2);
        this.hasApply = true;
      }
      paramInt1 = paramFrame.height * 720 / paramFrame.width;
      this.mClarityMaskFilter.updateSize(720, paramInt1);
      this.mClarityMaskFilter.RenderProcess(paramFrame.getTextureId(), 720, paramInt1, -1, 0.0D, this.mClarityMaskFrame);
      this.mSmoothSharpenFilter.updateTexture(this.mClarityMaskFrame.getTextureId());
      this.mSmoothSharpenFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mSmoothSharpenFrame);
      return this.mSmoothSharpenFrame;
    }
  }
  
  public static class PTCopyFilter
    extends PTFilter
  {
    public void setRotationAndFlip(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 1;
      BaseFilter localBaseFilter = this.mFilter;
      int i;
      if (paramBoolean1)
      {
        i = 1;
        if (!paramBoolean2) {
          break label38;
        }
      }
      for (;;)
      {
        localBaseFilter.setRotationAndFlip(paramInt, i, j);
        return;
        i = 0;
        break;
        label38:
        j = 0;
      }
    }
  }
  
  public static class PTCropFilter
    extends PTFilter
  {
    private float bottom = 0.0F;
    private float left = 0.0F;
    
    public void updateCorpRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      float f1 = (paramInt3 - paramInt1) / 2.0F / paramInt3;
      float f2 = 1.0F - f1;
      float f3 = (paramInt4 - paramInt2) / 2.0F / paramInt4;
      float f4 = 1.0F - f3;
      if ((Float.compare(f1, this.left) == 0) && (Float.compare(f3, this.bottom) == 0)) {
        return;
      }
      this.left = f1;
      this.bottom = f3;
      this.mFilter.setTexCords(new float[] { f1, f3, f1, f4, f2, f4, f2, f3 });
    }
  }
  
  public static class PTLongLegFilter
    extends PTFilter
  {
    private boolean enable = true;
    private LongLegFilter mLongLegFilter = new LongLegFilter();
    private Frame mLongLegFrame = new Frame();
    private float strength = 0.0F;
    
    public void destroy()
    {
      this.mLongLegFilter.clearGLSLSelf();
      this.mLongLegFrame.clear();
      super.destroy();
    }
    
    public float getStrength()
    {
      return this.strength;
    }
    
    public int init()
    {
      int i = super.init();
      this.mLongLegFilter.ApplyGLSLFilter();
      return i;
    }
    
    public boolean isEnable()
    {
      return this.enable;
    }
    
    public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
    {
      Frame localFrame = paramFrame;
      if (this.enable)
      {
        this.mLongLegFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mLongLegFrame);
        localFrame = this.mLongLegFrame;
      }
      return localFrame;
    }
    
    public void setEnable(boolean paramBoolean)
    {
      this.enable = paramBoolean;
    }
    
    public void setStrength(float paramFloat)
    {
      this.mLongLegFilter.setStrength(paramFloat);
      this.strength = paramFloat;
    }
    
    public void setWaistLine(List<PointF> paramList, int paramInt)
    {
      this.mLongLegFilter.setWaistLine(paramList, paramInt);
    }
  }
  
  public static class PTNewFaceColorFilter
    extends PTFilter
  {
    public PTNewFaceColorFilter()
    {
      this.mFilter = new NewFaceColorFilter();
    }
    
    public int init()
    {
      int i = super.init();
      new TextureResParam("inputImageTexture2", "sh/facecolor_b.png", 33986).initialParams(this.mFilter.getProgramIds());
      return i;
    }
  }
  
  public static class PTSlimWaistFilter
    extends PTFilter
  {
    private boolean enable = true;
    private SlimWaistFilter mSlimWaistFilter = new SlimWaistFilter();
    private Frame mSlimWaistFrame = new Frame();
    private float strength = 0.0F;
    
    public void destroy()
    {
      this.mSlimWaistFilter.clearGLSLSelf();
      this.mSlimWaistFrame.clear();
      super.destroy();
    }
    
    public float getStrength()
    {
      return this.strength;
    }
    
    public int init()
    {
      int i = super.init();
      this.mSlimWaistFilter.ApplyGLSLFilter();
      return i;
    }
    
    public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
    {
      this.mSlimWaistFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mSlimWaistFrame);
      return this.mSlimWaistFrame;
    }
    
    public void setStatusReset()
    {
      this.mSlimWaistFilter.setStatusReset();
    }
    
    public void setStrength(float paramFloat)
    {
      this.mSlimWaistFilter.setStrength(paramFloat);
      this.strength = paramFloat;
    }
    
    public boolean setWaistRectangle(List<PointF> paramList, int paramInt1, int paramInt2)
    {
      return this.mSlimWaistFilter.setWaistRectangle(paramList, paramInt1, paramInt2);
    }
  }
  
  public static class PTSmoothBFilters
    extends PTFilter
  {
    private SmoothBLargeBlurFilter mBigBlurFilter = new SmoothBLargeBlurFilter();
    private Frame mBigBlurFrame1 = new Frame();
    private BoxFilterWithRadius mBoxFilter = new BoxFilterWithRadius();
    private Frame mBoxFrame1 = new Frame();
    private Frame mBoxFrame1_1 = new Frame();
    private Frame mBoxFrame2 = new Frame();
    private Frame mBoxFrame2_1 = new Frame();
    private Frame mBoxFrame3 = new Frame();
    private SmoothBClarifyFilter mClarityFilter = new SmoothBClarifyFilter();
    private Frame mClarityFrame1 = new Frame();
    private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    private GPUImageTwoInputHighPassFilter mHighPassFilter = new GPUImageTwoInputHighPassFilter();
    private Frame mHighPassFrame = new Frame();
    private SmoothBProcessFilter mProcessVarianceFilter = new SmoothBProcessFilter();
    private SmoothBProcessFilter mProcessVarianceFilter2 = new SmoothBProcessFilter();
    private Frame mProcessVarianceFrame1 = new Frame();
    private SmoothBVarianceFilter mVarianceFilter = new SmoothBVarianceFilter();
    private SmoothBVarianceFilter mVarianceFilter2 = new SmoothBVarianceFilter();
    private Frame mVarianceFrame1 = new Frame();
    private Frame mVarianceFrame1_1 = new Frame();
    private Frame outputFrame = new Frame();
    
    public void destroy()
    {
      this.mClarityFilter.ClearGLSL();
      this.mBigBlurFilter.ClearGLSL();
      this.mVarianceFilter.ClearGLSL();
      this.mVarianceFilter2.ClearGLSL();
      this.mBoxFilter.ClearGLSL();
      this.mProcessVarianceFilter.ClearGLSL();
      this.mProcessVarianceFilter2.ClearGLSL();
      this.mHighPassFilter.ClearGLSL();
      this.mCopyFilter.ClearGLSL();
      this.mBoxFrame1.clear();
      this.mBoxFrame1_1.clear();
      this.mVarianceFrame1.clear();
      this.mVarianceFrame1_1.clear();
      this.mProcessVarianceFrame1.clear();
      this.mBoxFrame2.clear();
      this.mBoxFrame2_1.clear();
      this.mBoxFrame3.clear();
      this.mBigBlurFrame1.clear();
      this.mClarityFrame1.clear();
      this.mHighPassFrame.clear();
      this.outputFrame.clear();
      super.destroy();
    }
    
    public int init()
    {
      int i = super.init();
      this.mClarityFilter.apply();
      this.mBigBlurFilter.apply();
      this.mVarianceFilter.apply();
      this.mVarianceFilter2.apply();
      this.mBoxFilter.applyFilterChain(true, 0.0F, 0.0F);
      this.mProcessVarianceFilter.apply();
      this.mProcessVarianceFilter2.apply();
      this.mHighPassFilter.apply();
      this.mCopyFilter.apply();
      return i;
    }
    
    public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
    {
      if (this.mProcessVarianceFilter.getBlurAlpha() > 0.01F)
      {
        paramInt1 = paramFrame.height * 360 / paramFrame.width;
        this.mBoxFilter.updateParam(360, paramInt1);
        this.mBoxFilter.RenderProcess(paramFrame.getTextureId(), 360, paramInt1, -1, 0.0D, this.mBoxFrame1);
        this.mVarianceFilter2.setTexture2(FrameUtil.getLastRenderFrame(this.mBoxFrame1).getTextureId());
        this.mVarianceFilter2.RenderProcess(paramFrame.getTextureId(), 360, paramInt1, -1, 0.0D, this.mVarianceFrame1);
        this.mBoxFilter.updateParam(360, paramInt1);
        this.mBoxFilter.RenderProcess(this.mVarianceFrame1.getTextureId(), 360, paramInt1, -1, 0.0D, this.mBoxFrame2);
        this.mProcessVarianceFilter2.updateTextures(FrameUtil.getLastRenderFrame(this.mBoxFrame1).getTextureId(), FrameUtil.getLastRenderFrame(this.mBoxFrame2).getTextureId());
        this.mProcessVarianceFilter2.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.outputFrame);
      }
      for (;;)
      {
        return this.outputFrame;
        this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.outputFrame);
      }
    }
    
    public void updateBlurAlpha(float paramFloat)
    {
      this.mProcessVarianceFilter.updateBlurAlpha(0.8F * paramFloat);
      this.mProcessVarianceFilter2.updateBlurAlpha(0.8F * paramFloat);
    }
  }
  
  public static class PTSmoothSkin
    extends PTFilter
  {
    private CameraFilterParamSDK mBeautyParam = new CameraFilterParamSDK();
    
    public PTSmoothSkin()
    {
      this.mFilter = new FaceBeautysRealAutoFilter();
      setBeautyLevel(1);
    }
    
    public int getBeautyLevel()
    {
      return this.mBeautyParam.smoothLevel;
    }
    
    public void setBeautyLevel(int paramInt)
    {
      this.mBeautyParam.smoothLevel = paramInt;
      Map localMap = this.mBeautyParam.getSmoothMap();
      this.mFilter.setParameterDic(localMap);
    }
  }
  
  public static class PTThinBodyFilter
    extends PTFilter
  {
    private boolean enable = true;
    private ThinBodyFilter mThinBodyFilter = new ThinBodyFilter();
    private Frame mThinBodyFrame = new Frame();
    private float strength = 0.0F;
    
    public void destroy()
    {
      this.mThinBodyFilter.clearGLSLSelf();
      this.mThinBodyFrame.clear();
      super.destroy();
    }
    
    public float getStrength()
    {
      return this.strength;
    }
    
    public int init()
    {
      int i = super.init();
      this.mThinBodyFilter.ApplyGLSLFilter();
      return i;
    }
    
    public boolean isEnable()
    {
      return this.enable;
    }
    
    public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
    {
      Frame localFrame = paramFrame;
      if (this.enable)
      {
        this.mThinBodyFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mThinBodyFrame);
        localFrame = this.mThinBodyFrame;
      }
      return localFrame;
    }
    
    public void setBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        this.mThinBodyFilter.setupBodyPoints(paramList, paramInt1, paramInt2);
      }
    }
    
    public void setEnable(boolean paramBoolean)
    {
      this.mThinBodyFilter.setShowMark(true);
      this.mThinBodyFilter.setEnable(paramBoolean);
      this.enable = paramBoolean;
    }
    
    public void setStrength(float paramFloat)
    {
      this.mThinBodyFilter.setStrength(paramFloat);
      this.strength = paramFloat;
    }
  }
  
  public static class PTThinShoulderFilter
    extends PTFilter
  {
    private boolean enable = true;
    private ThinShoulderFilter mThinShoulderFilter = new ThinShoulderFilter();
    private Frame mThinShoulderFrame = new Frame();
    private float strength = 0.0F;
    
    public void destroy()
    {
      this.mThinShoulderFilter.clearGLSLSelf();
      this.mThinShoulderFrame.clear();
      super.destroy();
    }
    
    public float getStrength()
    {
      return this.strength;
    }
    
    public int init()
    {
      int i = super.init();
      this.mThinShoulderFilter.ApplyGLSLFilter();
      return i;
    }
    
    public boolean isEnable()
    {
      return this.enable;
    }
    
    public Frame process(Frame paramFrame, int paramInt1, int paramInt2)
    {
      Frame localFrame = paramFrame;
      if (this.enable)
      {
        this.mThinShoulderFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mThinShoulderFrame);
        localFrame = this.mThinShoulderFrame;
      }
      return localFrame;
    }
    
    public boolean setBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
    {
      return this.mThinShoulderFilter.setupBodyPoints(paramList, paramInt1, paramInt2);
    }
    
    public void setEnable(boolean paramBoolean)
    {
      this.mThinShoulderFilter.setShowMark(true);
      this.mThinShoulderFilter.setEnable(paramBoolean);
      this.enable = paramBoolean;
    }
    
    public void setStrength(float paramFloat)
    {
      this.mThinShoulderFilter.setStrength(paramFloat);
      this.strength = paramFloat;
    }
  }
  
  public static class PTYUV2RGBAFilter
    extends PTFilter
  {
    public PTYUV2RGBAFilter()
    {
      this.mFilter = new SurfaceTextureFilter();
    }
    
    public void setRotationAndFlip(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 1;
      BaseFilter localBaseFilter = this.mFilter;
      int i;
      if (paramBoolean1)
      {
        i = 1;
        if (!paramBoolean2) {
          break label38;
        }
      }
      for (;;)
      {
        localBaseFilter.setRotationAndFlip(paramInt, i, j);
        return;
        i = 0;
        break;
        label38:
        j = 0;
      }
    }
    
    public void setTextureCoordsMatrix(float[] paramArrayOfFloat)
    {
      this.mFilter.updateMatrix(paramArrayOfFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.PTFilter
 * JD-Core Version:    0.7.0.1
 */