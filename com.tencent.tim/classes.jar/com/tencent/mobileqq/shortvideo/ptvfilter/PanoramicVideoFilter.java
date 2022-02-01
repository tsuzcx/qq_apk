package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.FBO;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.panoramicvideo.SphereTo2DRenderObj;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.PanoramicLogUtil;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.filter.StaticStickerFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.recorder.ActVideoDecoder;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.io.File;

public class PanoramicVideoFilter
  extends StaticStickerFilter
  implements SensorEventHandler.CameraChangedCallBack
{
  private String TAG = PanoramicVideoFilter.class.getSimpleName();
  private FBO fbo;
  boolean hasInit = false;
  private int mHeight = -1;
  private int mWidth = -1;
  private GroupRenderObj renderObjGroup;
  private SphereTo2DRenderObj sphereTo2DRenderObj;
  
  public PanoramicVideoFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private int getNextFrame(int paramInt)
  {
    int i = 0;
    this.isImageReady = false;
    if (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE)
    {
      PanoramicLogUtil.performanceLog("begin decodeFrame");
      this.mVideoDecoder.decodeFrame(paramInt);
      PanoramicLogUtil.performanceLog("begin updateFrame");
      this.mVideoDecoder.updateFrame();
      this.isImageReady = true;
    }
    for (;;)
    {
      return getTextureId();
      Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
      Object localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
        localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        i = 1;
      }
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        GlUtil.loadTexture(getTextureId(), (Bitmap)localObject);
        if (i != 0) {
          ((Bitmap)localObject).recycle();
        }
        this.isImageReady = true;
      }
    }
  }
  
  private void initFBO(int paramInt1, int paramInt2)
  {
    if ((this.mWidth < 0) && (this.renderObjGroup != null))
    {
      this.fbo = FBO.newInstance().create(paramInt1, paramInt2);
      this.renderObjGroup.onRenderObjChanged(paramInt1, paramInt2);
      PanoramicLogUtil.Log("FBO.newInstance().create width=" + paramInt1 + "  |height=" + paramInt2);
      if (paramInt1 > 0)
      {
        this.mWidth = paramInt1;
        this.mHeight = paramInt2;
      }
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    if (this.renderObjGroup != null)
    {
      PanoramicLogUtil.Log("PanoramicVideoFilter clearGLSLSelf");
      this.mHeight = -1;
      this.mWidth = -1;
      if (this.fbo != null)
      {
        this.fbo.destroy();
        this.fbo = null;
      }
      super.clearGLSLSelf();
      this.renderObjGroup.destroy();
      this.renderObjGroup = null;
    }
  }
  
  public void initParams()
  {
    super.initParams();
    PanoramicLogUtil.Log("initParams");
    this.renderObjGroup = new GroupRenderObj();
    this.sphereTo2DRenderObj = new SphereTo2DRenderObj(AEModule.getContext());
    this.renderObjGroup.addFilter(this.sphereTo2DRenderObj);
    PanoramicLogUtil.Log("initParams end");
    SdkContext.getInstance().getResources().getSensorResource().setCameraChangedListener(this);
    onCameraChanged(SdkContext.getInstance().getResources().getSensorResource().getCameraIsFront());
  }
  
  public void initRender()
  {
    if (!this.hasInit)
    {
      this.renderObjGroup.init();
      this.hasInit = true;
    }
  }
  
  public void onCameraChanged(boolean paramBoolean)
  {
    PanoramicLogUtil.Log("onCameraChanged isFront=" + paramBoolean);
    if (this.sphereTo2DRenderObj != null) {
      this.sphereTo2DRenderObj.UpdateCameraOrientation(paramBoolean);
    }
  }
  
  public void updateTextureParam(int paramInt, long paramLong)
  {
    int i;
    if (paramInt != getLastFrameIndex())
    {
      if ((getLastFrameIndex() > paramInt) && (this.mVideoDecoder != null)) {
        this.mVideoDecoder.reset();
      }
      if (this.fbo == null) {}
      i = getNextFrame(paramInt);
      PanoramicLogUtil.performanceLog("begin drawToFBO");
      this.renderObjGroup.drawToFBO(i, this.fbo);
      if (this.fbo == null) {
        break label106;
      }
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.fbo.getFrameBufferTextureId(), 33986));
    }
    for (;;)
    {
      PanoramicLogUtil.performanceLog("end drawToFBO");
      setLastFrameIndex(paramInt);
      return;
      label106:
      addParam(new UniformParam.TextureParam("inputImageTexture2", i, 33986));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    initRender();
    initFBO(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.PanoramicVideoFilter
 * JD-Core Version:    0.7.0.1
 */