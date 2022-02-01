package com.tencent.qqmail.card.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class CircularDrawable
  extends Drawable
  implements Recyclable
{
  private Bitmap mBitmap;
  private int mBorderWidth;
  private Drawable mDefaultDrawable;
  private Paint mPaint = new Paint();
  private Paint mPaintBorder;
  private Object mTag;
  private Matrix mTransformMatrix = new Matrix();
  
  public CircularDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.mPaint.setAntiAlias(true);
    this.mPaintBorder = new Paint();
    this.mPaintBorder.setAntiAlias(true);
    this.mPaintBorder.setStyle(Paint.Style.STROKE);
    this.mPaintBorder.setColor(paramInt2);
    this.mBorderWidth = paramInt1;
    setBitmap(paramBitmap);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = getBounds().width();
    int j = getBounds().height();
    if (this.mBitmap != null)
    {
      localObject = this.mBitmap;
      k = this.mBitmap.getWidth();
      m = this.mBitmap.getHeight();
      f1 = i / Math.min(k, m);
      localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
      this.mTransformMatrix.reset();
      this.mTransformMatrix.setScale(f1, f1);
      localMatrix = this.mTransformMatrix;
      f2 = getBounds().left;
      f3 = (i - k * f1) / 2.0F;
      f4 = getBounds().top;
      localMatrix.postTranslate(f3 + f2, (j - m * f1) / 2.0F + f4);
      ((BitmapShader)localObject).setLocalMatrix(this.mTransformMatrix);
      this.mPaint.setShader((Shader)localObject);
      j = getBounds().centerX();
      k = getBounds().centerY();
      paramCanvas.drawCircle(j, k, (i - this.mBorderWidth) / 2, this.mPaint);
      paramCanvas.drawCircle(j, k, (i - this.mBorderWidth) / 2, this.mPaintBorder);
    }
    while (this.mDefaultDrawable == null)
    {
      Object localObject;
      int k;
      int m;
      float f1;
      Matrix localMatrix;
      float f2;
      float f3;
      float f4;
      return;
    }
    this.mDefaultDrawable.draw(paramCanvas);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public void recycle()
  {
    this.mBitmap = null;
  }
  
  public void setAlpha(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.mPaintBorder.setColor(paramInt);
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mDefaultDrawable != null) {
      this.mDefaultDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
    if (this.mDefaultDrawable != null) {
      this.mDefaultDrawable.setBounds(paramRect);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.mDefaultDrawable = paramDrawable;
  }
  
  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CircularDrawable
 * JD-Core Version:    0.7.0.1
 */