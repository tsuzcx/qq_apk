package com.tencent.token.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class ScaleImageView
  extends ImageView
{
  int a = 0;
  PointF b = new PointF();
  PointF c = new PointF();
  float d = 1.0F;
  private Matrix e = new Matrix();
  private Matrix f = new Matrix();
  
  public ScaleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScaleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static float a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      float f1;
      if (i != 2)
      {
        switch (i)
        {
        default: 
          break;
        case 6: 
          this.a = 0;
          break;
        case 5: 
          this.d = a(paramMotionEvent);
          if (this.d <= 10.0F) {
            break;
          }
          new StringBuilder("oldDist").append(this.d);
          this.f.set(this.e);
          PointF localPointF = this.c;
          f1 = paramMotionEvent.getX(0);
          float f2 = paramMotionEvent.getX(1);
          float f3 = paramMotionEvent.getY(0);
          float f4 = paramMotionEvent.getY(1);
          localPointF.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
          this.a = 2;
          break;
        }
      }
      else
      {
        i = this.a;
        if (i == 1)
        {
          this.e.set(this.f);
          this.e.postTranslate(paramMotionEvent.getX() - this.b.x, paramMotionEvent.getY() - this.b.y);
        }
        else if (i == 2)
        {
          f1 = a(paramMotionEvent);
          if (f1 > 10.0F)
          {
            this.e.set(this.f);
            f1 /= this.d;
            this.e.postScale(f1, f1, this.c.x, this.c.y);
          }
        }
      }
    }
    else
    {
      this.e.set(getImageMatrix());
      this.f.set(this.e);
      this.b.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      this.a = 1;
    }
    setImageMatrix(this.e);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.ScaleImageView
 * JD-Core Version:    0.7.0.1
 */