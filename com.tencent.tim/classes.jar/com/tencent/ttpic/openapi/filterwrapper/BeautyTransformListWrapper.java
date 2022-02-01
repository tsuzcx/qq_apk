package com.tencent.ttpic.openapi.filterwrapper;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.filter.BeautyTransformList;
import com.tencent.ttpic.openapi.model.DistortParam;
import java.util.List;

public class BeautyTransformListWrapper
{
  private BeautyTransformList beautyTransformList = new BeautyTransformList();
  
  public void clear()
  {
    this.beautyTransformList.clear();
  }
  
  public void initial()
  {
    this.beautyTransformList.initial();
  }
  
  public Frame process(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, double paramDouble, List<float[]> paramList2, float paramFloat, boolean paramBoolean)
  {
    return this.beautyTransformList.process(paramFrame, paramList, paramList1, paramDouble, paramList2, paramFloat, paramBoolean);
  }
  
  public void setBeautyParam(int paramInt, DistortParam paramDistortParam)
  {
    this.beautyTransformList.setBeautyParam(paramInt, paramDistortParam);
  }
  
  public void setBeautyParamValue(int paramInt1, int paramInt2)
  {
    this.beautyTransformList.setBeautyParamValue(paramInt1, paramInt2);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.beautyTransformList.setRenderMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filterwrapper.BeautyTransformListWrapper
 * JD-Core Version:    0.7.0.1
 */