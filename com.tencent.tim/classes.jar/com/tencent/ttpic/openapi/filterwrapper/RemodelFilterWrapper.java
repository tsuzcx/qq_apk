package com.tencent.ttpic.openapi.filterwrapper;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.RemodelFilter;
import java.util.List;

public class RemodelFilterWrapper
{
  private RemodelFilter remodelFilter = new RemodelFilter();
  
  public void clear()
  {
    this.remodelFilter.clear();
  }
  
  public void closeAIBeautyConfig()
  {
    this.remodelFilter.closeAIBeautyConfig();
  }
  
  public void init()
  {
    this.remodelFilter.init();
  }
  
  public Frame process(Frame paramFrame, List<List<PointF>> paramList, List<FaceStatus> paramList1, List<float[]> paramList2, double paramDouble, boolean paramBoolean)
  {
    return this.remodelFilter.process(paramFrame, paramList, paramList1, paramList2, paramDouble, paramBoolean);
  }
  
  public void setParam(BeautyRealConfig.TYPE paramTYPE, float paramFloat)
  {
    this.remodelFilter.setParam(paramTYPE, paramFloat);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.remodelFilter.setRenderMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filterwrapper.RemodelFilterWrapper
 * JD-Core Version:    0.7.0.1
 */