package com.tencent.qqlive.module.videoreport.exposure;

import android.graphics.Rect;
import android.graphics.RectF;

public class DetectionData
{
  static final double NO_EXPOSURE = -1.0D;
  final SafeList<AncestorInfo> ancestorsInfo = new DetectionData.1(this, 20);
  final SafeList<Double> exposureRate = new DetectionData.2(this, 20);
  final RectF helperRectF = new RectF();
  final Rect helperRectForExclusion = new Rect();
  int viewsDetected = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.exposure.DetectionData
 * JD-Core Version:    0.7.0.1
 */