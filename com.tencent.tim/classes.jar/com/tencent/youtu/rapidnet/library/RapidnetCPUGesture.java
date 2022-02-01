package com.tencent.youtu.rapidnet.library;

import android.graphics.Bitmap;
import android.graphics.PointF;
import java.util.List;

public class RapidnetCPUGesture
{
  public static String[] gestureType = { "HEART", "PAPER", "SCISSOR", "FIST", "ONE", "LOVE", "LIKE", "OK", "ROCK", "SIX", "EIGHT", "LIFT", "OTHERS", "UNKNOWN", "THREE", "FOUR" };
  private long nativePtr;
  
  private float[] FacePoints2Box(List<PointF> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      float f1 = 1.4E-45F;
      float f4 = 1.4E-45F;
      float f2 = 3.4028235E+38F;
      float f3;
      for (float f5 = 3.4028235E+38F; i < paramList.size(); f5 = f3)
      {
        f3 = f5;
        if (((PointF)paramList.get(i)).x < f5) {
          f3 = ((PointF)paramList.get(i)).x;
        }
        f5 = f4;
        if (((PointF)paramList.get(i)).x > f4) {
          f5 = ((PointF)paramList.get(i)).x;
        }
        float f6 = f2;
        if (((PointF)paramList.get(i)).y < f2) {
          f6 = ((PointF)paramList.get(i)).y;
        }
        f2 = f1;
        if (((PointF)paramList.get(i)).y > f1) {
          f2 = ((PointF)paramList.get(i)).y;
        }
        i += 1;
        f1 = f2;
        f4 = f5;
        f2 = f6;
      }
      if ((f5 == 3.4028235E+38F) || (f2 == 3.4028235E+38F) || (f4 == 1.4E-45F) || (f1 == 1.4E-45F)) {
        return null;
      }
      return new float[] { f5, f2, f4, f1 };
    }
    return null;
  }
  
  private native void setFaceBox(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native int gestureAllDeinit();
  
  public native int gestureAllInit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10);
  
  public native int gestureClassifyDeinit();
  
  public native Bitmap gestureClassifyForward(Bitmap paramBitmap);
  
  public native int gestureClassifyInit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public native int gestureClassifyResult(Bitmap paramBitmap);
  
  public native float[] gestureClassifyResultWithBox(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public native int gestureClassifySetPrevNumOfFrame(int paramInt);
  
  public native int gestureDetectDeinit();
  
  public native Bitmap gestureDetectForward(Bitmap paramBitmap);
  
  public native float[] gestureDetectGetBox(Bitmap paramBitmap);
  
  public native int gestureDetectInit(String paramString1, String paramString2);
  
  public native float[] gestureKeyPointsAndClassifyResult(Bitmap paramBitmap);
  
  public native float[] gestureKeypointResult(Bitmap paramBitmap, int paramInt);
  
  public native float[] gestureKeypointResultWithBox(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt);
  
  public native int gestureKeypointsDeinit();
  
  public native Bitmap gestureKeypointsForward(Bitmap paramBitmap);
  
  public native int gestureKeypointsInit(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public native void gestureSetKeypointsPreFrame(int paramInt);
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public void setFacePoints(List<List<PointF>> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        float[] arrayOfFloat = FacePoints2Box((List)paramList.get(i));
        if (arrayOfFloat != null) {
          setFaceBox(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
        }
        i += 1;
      }
    }
  }
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.rapidnet.library.RapidnetCPUGesture
 * JD-Core Version:    0.7.0.1
 */