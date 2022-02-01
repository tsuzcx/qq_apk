package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import azbx;
import com.tencent.mobileqq.activity.photo.DragGallery;

public class EmotionGallery
  extends DragGallery
{
  private a a;
  
  public EmotionGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public float bb()
  {
    if (this.mSelectedChild != null) {
      return super.getChildScale(this.mSelectedChild);
    }
    return 1.0F;
  }
  
  public float customScale(View paramView, float paramFloat, int paramInt)
  {
    paramFloat = getResources().getDisplayMetrics().density * 135.0F * 1.5F;
    if (paramInt > paramFloat) {}
    for (paramFloat /= paramInt;; paramFloat = Math.min(1.5F, paramFloat / paramInt))
    {
      setMaxScale((float)azbx.SCREEN_WIDTH / paramInt);
      return paramFloat;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      float f = bb();
      this.a.aL(f);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.a != null) {
      this.a.dbE();
    }
    return super.onScaleBegin(paramScaleGestureDetector);
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.a != null)
    {
      float f = bb();
      this.a.aK(f);
    }
    super.onScaleEnd(paramScaleGestureDetector);
  }
  
  public void setOnScaleChangeListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aK(float paramFloat);
    
    public abstract void aL(float paramFloat);
    
    public abstract void dbE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionGallery
 * JD-Core Version:    0.7.0.1
 */