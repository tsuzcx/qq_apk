package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.List;

public class CrazyFaceFilters
{
  private FaceAverageBackgroundFilter faceAverageBackgroundFilter;
  private FaceAverageFilter faceAverageFilter;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame = new Frame();
  private FaceSkinBalanceFilter mFaceSkinBalanceFilter;
  private Frame mSkinBalanceFrame = new Frame();
  
  public CrazyFaceFilters(VideoMaterial paramVideoMaterial)
  {
    VideoMaterial localVideoMaterial = paramVideoMaterial;
    if (paramVideoMaterial == null) {
      localVideoMaterial = new VideoMaterial();
    }
    this.faceAverageBackgroundFilter = new FaceAverageBackgroundFilter(localVideoMaterial.getDataPath(), localVideoMaterial.getFaceImageLayer());
    this.faceAverageFilter = new FaceAverageFilter(localVideoMaterial.getDataPath(), localVideoMaterial.getFaceImageLayer());
    this.mFaceSkinBalanceFilter = new FaceSkinBalanceFilter(localVideoMaterial.getFaceImageLayer());
  }
  
  public void ApplyGLSLFilter()
  {
    this.faceAverageBackgroundFilter.ApplyGLSLFilter();
    this.faceAverageFilter.ApplyGLSLFilter();
    this.mFaceSkinBalanceFilter.apply();
    this.mCopyFilter.apply();
  }
  
  public void clear()
  {
    this.faceAverageBackgroundFilter.clearGLSLSelf();
    this.faceAverageFilter.clearGLSLSelf();
    this.mFaceSkinBalanceFilter.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mCopyFrame.clear();
    this.mSkinBalanceFrame.clear();
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    this.mFaceSkinBalanceFilter.setImageData(paramArrayOfByte);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.faceAverageBackgroundFilter.setRenderMode(paramInt);
    this.faceAverageFilter.setRenderMode(paramInt);
    this.mFaceSkinBalanceFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public Frame updateAndRender(Frame paramFrame, int paramInt1, int paramInt2, List<PointF> paramList, float[] paramArrayOfFloat)
  {
    this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mCopyFrame);
    PTDetectInfo localPTDetectInfo = new PTDetectInfo.Builder().build();
    this.faceAverageBackgroundFilter.updatePreview(localPTDetectInfo);
    this.faceAverageBackgroundFilter.OnDrawFrameGLSL();
    this.faceAverageBackgroundFilter.renderTexture(this.mCopyFrame.getTextureId(), paramInt1, paramInt2);
    this.mFaceSkinBalanceFilter.RenderProcess(paramFrame.getTextureId(), paramInt1, paramInt2, -1, 0.0D, this.mSkinBalanceFrame);
    this.faceAverageFilter.setUserTexture(this.mSkinBalanceFrame.getTextureId());
    paramFrame = new PTDetectInfo.Builder().facePoints(paramList).faceAngles(paramArrayOfFloat).timestamp(0L).build();
    this.faceAverageFilter.updatePreview(paramFrame);
    this.mCopyFrame.bindFrame(this.mCopyFrame.getTextureId(), paramInt1, paramInt2, 0.0D);
    this.faceAverageFilter.OnDrawFrameGLSL();
    this.faceAverageFilter.renderTexture(this.mCopyFrame.getTextureId(), paramInt1, paramInt2);
    return this.mCopyFrame;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.faceAverageBackgroundFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.faceAverageFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.CrazyFaceFilters
 * JD-Core Version:    0.7.0.1
 */