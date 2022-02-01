package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.GlMatricUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Map;

public class QQTrackerStickersFilter
  extends QQBaseFilter
{
  private static String TAG = "QQTrackerStickersFilter";
  private boolean bwork = false;
  private ArrayList<TrackerStickerParam> listStickers;
  private GPUAlphaBlendFilter mMultiStickerFilter;
  private RenderBuffer mRenderFBO;
  private int mSurfaceHeight = 0;
  private int mSurfaceWidth = 0;
  private boolean mbReversed = true;
  private float[][] mvpMatrix;
  private int[] textureId;
  private float[] textureMatrix = null;
  
  public QQTrackerStickersFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  public void InitTrackerStickers(ArrayList<TrackerStickerParam> paramArrayList)
  {
    this.listStickers = paramArrayList;
    if ((this.listStickers != null) && (this.listStickers.size() > 0))
    {
      this.textureId = new int[this.listStickers.size()];
      this.mvpMatrix = new float[this.listStickers.size()][];
      this.bwork = true;
    }
    while (this.mbReversed)
    {
      this.textureMatrix = null;
      return;
      this.bwork = false;
      SLog.i(TAG, "TrackerStickerParam is null or zero");
    }
    this.textureMatrix = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public void SetReversedCoordination(boolean paramBoolean)
  {
    this.mbReversed = paramBoolean;
    if (this.mbReversed)
    {
      this.textureMatrix = null;
      return;
    }
    this.textureMatrix = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public float[] caculateMatrix(TrackerStickerParam paramTrackerStickerParam, TrackerStickerParam.MotionInfo paramMotionInfo)
  {
    float f1 = this.mSurfaceWidth / this.mSurfaceHeight;
    GlMatricUtil localGlMatricUtil = new GlMatricUtil();
    localGlMatricUtil.ortho(-1.0F * f1, 1.0F * f1, -1.0F, 1.0F, 3.0F, 20.0F);
    localGlMatricUtil.setCamera(0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    float f2 = paramMotionInfo.x * 2.0F / paramTrackerStickerParam.layerWidth;
    float f3 = paramMotionInfo.y * 2.0F / paramTrackerStickerParam.layerHeight;
    if (this.mbReversed) {
      localGlMatricUtil.translate((f2 - 1.0F) * f1, f3 - 1.0F, 0.0F);
    }
    for (;;)
    {
      float f4 = this.mSurfaceWidth / paramTrackerStickerParam.layerWidth;
      f2 = this.mSurfaceHeight / paramTrackerStickerParam.layerHeight;
      float f5 = paramTrackerStickerParam.width / this.mSurfaceWidth;
      f3 = paramTrackerStickerParam.height / this.mSurfaceHeight;
      f1 = f4 * paramTrackerStickerParam.scale * f5 * f1;
      f2 = f2 * paramTrackerStickerParam.scale * f3;
      localGlMatricUtil.rotate(paramTrackerStickerParam.rotate, 0.0F, 0.0F, 1.0F);
      localGlMatricUtil.scale(f1, f2, 1.0F);
      SLog.d("trackerMatrix ", "finalScaleX : " + f1 + " finalScaleY:" + f2);
      paramMotionInfo = localGlMatricUtil.getFinalMatrix();
      paramTrackerStickerParam = "mvp: ";
      int i = 0;
      while (i < 16)
      {
        paramTrackerStickerParam = paramTrackerStickerParam + " " + paramMotionInfo[i];
        i += 1;
      }
      localGlMatricUtil.translate((f2 - 1.0F) * f1, 1.0F - f3, 0.0F);
    }
    SLog.d("trackerMatrix ", paramTrackerStickerParam);
    return paramMotionInfo;
  }
  
  TrackerStickerParam.MotionInfo getTrackerPoint(long paramLong, TrackerStickerParam paramTrackerStickerParam)
  {
    TrackerStickerParam.MotionInfo localMotionInfo = (TrackerStickerParam.MotionInfo)paramTrackerStickerParam.mapMotionTrack.get(Long.valueOf(paramLong));
    paramTrackerStickerParam = localMotionInfo;
    if (localMotionInfo == null) {
      paramTrackerStickerParam = new TrackerStickerParam.MotionInfo(true, 0L, 0.0F, 0.0F, 1.0F, 0.0F);
    }
    return paramTrackerStickerParam;
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  @TargetApi(17)
  public void onDrawFrame()
  {
    long l2;
    long l3;
    long l4;
    if (this.bwork)
    {
      l2 = getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp();
      l3 = getQQFilterRenderManager().getBusinessOperation().getPresentTimeStamp();
      l1 = getQQFilterRenderManager().getBusinessOperation().getVideoStartTime();
      l4 = l2 / 1000000L;
      if (l4 <= l1) {
        break label353;
      }
    }
    label318:
    label346:
    label353:
    for (long l1 = l4 - l1;; l1 = 0L) {
      for (;;)
      {
        int i;
        try
        {
          this.mRenderFBO.setTexId(this.mInputTextureID);
          this.mRenderFBO.bind();
          i = 0;
          if (i >= this.listStickers.size()) {
            break label318;
          }
          TrackerStickerParam localTrackerStickerParam = (TrackerStickerParam)this.listStickers.get(i);
          if (!localTrackerStickerParam.isShow((int)l1)) {
            break label346;
          }
          if ((localTrackerStickerParam.mapMotionTrack == null) || (localTrackerStickerParam.mapMotionTrack.size() == 0))
          {
            localMotionInfo = new TrackerStickerParam.MotionInfo(false, l3, localTrackerStickerParam.centerP.x + localTrackerStickerParam.translateXValue, localTrackerStickerParam.centerP.y + localTrackerStickerParam.translateYValue, 1.0F, 0.0F);
            this.mvpMatrix[i] = caculateMatrix(localTrackerStickerParam, localMotionInfo);
            GLES20.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
            this.mMultiStickerFilter.drawTexture(this.textureId[i], this.textureMatrix, this.mvpMatrix[i]);
          }
        }
        catch (Throwable localThrowable)
        {
          this.mOutputTextureID = this.mInputTextureID;
          return;
        }
        TrackerStickerParam.MotionInfo localMotionInfo = getTrackerPoint(l2, localThrowable);
        if (!localMotionInfo.isLost)
        {
          this.mvpMatrix[i] = caculateMatrix(localThrowable, localMotionInfo);
          GLES20.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
          this.mMultiStickerFilter.drawTexture(this.textureId[i], this.textureMatrix, this.mvpMatrix[i]);
          break label346;
          this.mRenderFBO.unbind();
          this.mOutputTextureID = this.mRenderFBO.getTexId();
          return;
          this.mOutputTextureID = this.mInputTextureID;
          return;
        }
        i += 1;
      }
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    if ((paramInt1 != this.mSurfaceWidth) || (paramInt2 != this.mSurfaceHeight))
    {
      this.mSurfaceWidth = paramInt1;
      this.mSurfaceHeight = paramInt2;
      this.mRenderFBO = null;
      this.mRenderFBO = new RenderBuffer(this.mSurfaceWidth, this.mSurfaceHeight, 33984);
    }
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
    Object localObject;
    if (this.mMultiStickerFilter == null)
    {
      this.mMultiStickerFilter = new GPUAlphaBlendFilter();
      this.mMultiStickerFilter.init();
      localObject = this.mMultiStickerFilter;
      GPUAlphaBlendFilter.checkGlError("filter init");
    }
    int i;
    if (this.listStickers != null)
    {
      i = 0;
      while (i < this.listStickers.size())
      {
        localObject = BitmapFactory.decodeFile(((TrackerStickerParam)this.listStickers.get(i)).path);
        if (localObject != null) {
          this.textureId[i] = GlUtil.createTexture(3553, (Bitmap)localObject);
        }
        i += 1;
      }
    }
    this.mSurfaceWidth = getQQFilterRenderManager().getSufaceWidth();
    this.mSurfaceHeight = getQQFilterRenderManager().getSurfaceHeight();
    try
    {
      i = GLES20.glGetError();
      if (i != 0)
      {
        localObject = "previousUnknownError: glError 0x" + Integer.toHexString(i);
        SLog.e(TAG, (String)localObject);
      }
      this.mRenderFBO = new RenderBuffer(this.mSurfaceWidth, this.mSurfaceHeight, 33984);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.mRenderFBO = null;
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    this.mMultiStickerFilter.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQTrackerStickersFilter
 * JD-Core Version:    0.7.0.1
 */