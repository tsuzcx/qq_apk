package com.tencent.av.opengl.gesture;

import android.graphics.PointF;
import android.util.FloatMath;
import android.view.MotionEvent;

public class MathUtils
{
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return FloatMath.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public static float a(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return FloatMath.sqrt(f1 * f1 + f2 * f2);
  }
  
  public static float a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return FloatMath.sqrt(f1 * f1 + f2 * f2);
  }
  
  public static void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, PointF paramPointF)
  {
    paramPointF.x = ((paramFloat1 + paramFloat3) / 2.0F);
    paramPointF.y = ((paramFloat2 + paramFloat4) / 2.0F);
  }
  
  public static void a(MotionEvent paramMotionEvent, PointF paramPointF)
  {
    a(paramMotionEvent.getX(0), paramMotionEvent.getY(0), paramMotionEvent.getX(1), paramMotionEvent.getY(1), paramPointF);
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.atan2(paramFloat4 - paramFloat2, paramFloat3 - paramFloat1);
  }
  
  public static float b(PointF paramPointF1, PointF paramPointF2)
  {
    return b(paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.gesture.MathUtils
 * JD-Core Version:    0.7.0.1
 */