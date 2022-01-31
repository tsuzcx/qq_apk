package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ViewCompatHC
{
  public static float getAlpha(View paramView)
  {
    return paramView.getAlpha();
  }
  
  static long getFrameTime()
  {
    return ValueAnimator.getFrameDelay();
  }
  
  public static int getLayerType(View paramView)
  {
    return paramView.getLayerType();
  }
  
  public static int getMeasuredHeightAndState(View paramView)
  {
    return paramView.getMeasuredHeightAndState();
  }
  
  public static int getMeasuredState(View paramView)
  {
    return paramView.getMeasuredState();
  }
  
  public static int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidthAndState();
  }
  
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompatHC
 * JD-Core Version:    0.7.0.1
 */