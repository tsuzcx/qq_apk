package com.tencent.mobileqq.shortvideo.ptvfilter;

import aymq;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import ric;

public class DoodleMagicAlgoHandler
{
  public static final String TAG = "Doodle_Strokes_MagicAlgoHandler";
  public static final int TOUCH_DOWN = 0;
  public static final int TOUCH_MOVE = 1;
  public static final int TOUCH_UP = 2;
  private static WeakReference<VideoFilterBase> mFilter;
  
  public static void OnUpdateSize(int paramInt1, int paramInt2, float paramFloat)
  {
    try
    {
      updateSize(paramInt1, paramInt2, paramFloat);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public static void onTouchEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        processTouch();
        long l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Doodle_Strokes_MagicAlgoHandler", 2, "onTouchEvent|processTouch time= " + (l2 - l1));
        return;
        touchBegin(paramFloat1, paramFloat2);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
        touchMove(paramFloat1, paramFloat2);
        continue;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        return;
      }
      touchEnd(paramFloat1, paramFloat2);
    }
  }
  
  public static native void processTouch();
  
  public static void renderToTemp(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Doodle_Strokes_MagicAlgoHandler", 2, "size= " + paramInt);
    }
    VideoFilterBase localVideoFilterBase;
    RenderPoint localRenderPoint;
    if ((mFilter != null) && (mFilter.get() != null))
    {
      localVideoFilterBase = (VideoFilterBase)mFilter.get();
      if (localVideoFilterBase != null)
      {
        localRenderPoint = new RenderPoint();
        localRenderPoint.xList = paramArrayOfFloat1;
        localRenderPoint.yList = paramArrayOfFloat2;
        localRenderPoint.aList = paramArrayOfFloat3;
        if (!(localVideoFilterBase instanceof ric)) {
          break label108;
        }
        ((ric)localVideoFilterBase).a(localRenderPoint);
      }
    }
    label108:
    while (!(localVideoFilterBase instanceof aymq)) {
      return;
    }
    ((aymq)localVideoFilterBase).a(localRenderPoint);
  }
  
  public static void setFilter(VideoFilterBase paramVideoFilterBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Doodle_Strokes_MagicAlgoHandler", 2, "setFilter");
    }
    mFilter = new WeakReference(paramVideoFilterBase);
  }
  
  public static native void touchBegin(float paramFloat1, float paramFloat2);
  
  public static native void touchEnd(float paramFloat1, float paramFloat2);
  
  public static native void touchMove(float paramFloat1, float paramFloat2);
  
  public static native void updateSize(int paramInt1, int paramInt2, float paramFloat);
  
  public static class RenderPoint
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public float[] aList;
    public float[] xList;
    public float[] yList;
    
    public RenderPoint() {}
    
    public RenderPoint(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, int paramInt)
    {
      this.xList = new float[paramInt];
      this.yList = new float[paramInt];
      this.aList = new float[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        this.xList[i] = paramArrayOfFloat1[i];
        this.yList[i] = paramArrayOfFloat2[i];
        this.aList[i] = paramArrayOfFloat3[i];
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.DoodleMagicAlgoHandler
 * JD-Core Version:    0.7.0.1
 */