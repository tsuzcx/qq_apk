package com.tencent.qqmail.view.imageview;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import java.util.List;

public class MathUtils
{
  public static float angle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.atan2(paramFloat4 - paramFloat2, paramFloat3 - paramFloat1);
  }
  
  public static float angle(PointF paramPointF1, PointF paramPointF2)
  {
    return angle(paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y);
  }
  
  public static double avg(List<Double> paramList)
  {
    if (paramList == null) {
      throw new DevRuntimeException("data is null");
    }
    double d = 0.0D;
    int i = 0;
    while (i < paramList.size())
    {
      d += ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return d / paramList.size();
  }
  
  public static float distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static float distance(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public static float distance(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return 0.0F;
    }
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public static double findMax(List<Double> paramList)
  {
    if (paramList == null) {
      throw new DevRuntimeException("data is null");
    }
    double d1 = 4.9E-324D;
    int i = 0;
    while (i < paramList.size())
    {
      double d2 = d1;
      if (d1 < ((Double)paramList.get(i)).doubleValue()) {
        d2 = ((Double)paramList.get(i)).doubleValue();
      }
      i += 1;
      d1 = d2;
    }
    return d1;
  }
  
  public static double findMin(List<Double> paramList)
  {
    if (paramList == null) {
      throw new DevRuntimeException("data is null");
    }
    double d1 = 1.7976931348623157E+308D;
    int i = 0;
    while (i < paramList.size())
    {
      double d2 = d1;
      if (d1 > ((Double)paramList.get(i)).doubleValue()) {
        d2 = ((Double)paramList.get(i)).doubleValue();
      }
      i += 1;
      d1 = d2;
    }
    return d1;
  }
  
  public static double max(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 >= paramDouble2) {
      return paramDouble1;
    }
    return paramDouble2;
  }
  
  public static void midpoint(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, PointF paramPointF)
  {
    paramPointF.x = ((paramFloat1 + paramFloat3) / 2.0F);
    paramPointF.y = ((paramFloat2 + paramFloat4) / 2.0F);
  }
  
  public static void midpoint(MotionEvent paramMotionEvent, PointF paramPointF)
  {
    if (paramMotionEvent.getPointerCount() < 2) {
      return;
    }
    midpoint(paramMotionEvent.getX(0), paramMotionEvent.getY(0), paramMotionEvent.getX(1), paramMotionEvent.getY(1), paramPointF);
  }
  
  public static double min(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 >= paramDouble2) {
      return paramDouble2;
    }
    return paramDouble1;
  }
  
  public static double randomDouble()
  {
    return Math.random();
  }
  
  public static int setBitTo0(int paramInt1, int paramInt2)
  {
    return (1 << paramInt2 ^ 0xFFFFFFFF) & paramInt1;
  }
  
  public static int setBitTo1(int paramInt1, int paramInt2)
  {
    return 1 << paramInt2 | paramInt1;
  }
  
  public void rotate(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF1.y;
    float f3 = paramPointF2.x;
    float f4 = paramPointF2.y;
    paramPointF1.x = ((float)Math.cos(paramFloat) * (f1 - f3) - (float)Math.sin(paramFloat) * (f2 - f4) + f3);
    paramPointF1.y = ((f1 - f3) * (float)Math.sin(paramFloat) + (f2 - f4) * (float)Math.cos(paramFloat) + f4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.MathUtils
 * JD-Core Version:    0.7.0.1
 */