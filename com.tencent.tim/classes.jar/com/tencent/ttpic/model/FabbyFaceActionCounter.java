package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import java.util.HashMap;
import java.util.Map;

public class FabbyFaceActionCounter
  extends FaceActionCounter
{
  public Map<Integer, PointF> scaleMap = new HashMap();
  
  public FabbyFaceActionCounter(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.FabbyFaceActionCounter
 * JD-Core Version:    0.7.0.1
 */