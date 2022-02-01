package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class RoundImageView
  extends ImageView
{
  boolean dbt = false;
  RectF i = new RectF();
  float mRadius = 0.0F;
  Path path = new Path();
  Rect rect1 = new Rect();
  Rect rect2 = new Rect();
  
  public RoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rz, paramInt, 0);
    try
    {
      this.mRadius = ((int)paramContext.getDimension(1, 0.0F));
      this.dbt = paramContext.getBoolean(0, false);
      return;
    }
    catch (Exception paramAttributeSet)
    {
      QLog.e("RoundImageView", 1, "initAttrs exception", paramAttributeSet);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void i(Canvas paramCanvas)
  {
    try
    {
      paramCanvas.clipPath(this.path);
      return;
    }
    catch (Exception paramCanvas)
    {
      QLog.e("RoundImageView", 1, "clipPathSafe exception", paramCanvas);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    for (;;)
    {
      try
      {
        int j = getMeasuredWidth();
        int k = getMeasuredHeight();
        if (this.mRadius > 0.0F)
        {
          localObject = this.i;
          float f2 = j;
          float f3 = k;
          if (this.dbt) {
            f1 = this.mRadius;
          }
          ((RectF)localObject).set(0.0F, 0.0F, f2, f1 + f3);
          this.path.addRoundRect(this.i, this.mRadius, this.mRadius, Path.Direction.CW);
          i(paramCanvas);
          localObject = getDrawable();
          if (localObject != null) {
            if ((localObject instanceof SkinnableBitmapDrawable))
            {
              localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
              if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
              {
                this.rect1.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
                this.rect2.set(0, 0, j, k);
                paramCanvas.drawBitmap((Bitmap)localObject, this.rect1, this.rect2, null);
              }
            }
            else
            {
              if (!(localObject instanceof BitmapDrawable)) {
                break label217;
              }
              localObject = ((BitmapDrawable)localObject).getBitmap();
              continue;
            }
          }
        }
        super.onDraw(paramCanvas);
        return;
      }
      catch (Exception paramCanvas)
      {
        QLog.e("RoundImageView", 1, "onDraw exception", paramCanvas);
        return;
      }
      label217:
      Object localObject = null;
    }
  }
  
  public void setmRadius(int paramInt, boolean paramBoolean)
  {
    this.mRadius = paramInt;
    this.dbt = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundImageView
 * JD-Core Version:    0.7.0.1
 */