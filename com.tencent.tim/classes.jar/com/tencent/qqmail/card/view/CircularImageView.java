package com.tencent.qqmail.card.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.androidqqmail.R.styleable;

public class CircularImageView
  extends ImageView
{
  private int mBorderRadius = -1;
  private int mBorderWidth;
  private RectF mCacheRect;
  private Bitmap mImage;
  private boolean mIsNeedMask = false;
  private int mMaskColor;
  private Paint mMaskPaint;
  private Paint mPaint = new Paint();
  private Paint mPaintBorder;
  private Matrix mTransformMatrix = new Matrix();
  
  public CircularImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setAntiAlias(true);
    this.mPaintBorder = new Paint();
    this.mPaintBorder.setAntiAlias(true);
    this.mPaintBorder.setStyle(Paint.Style.STROKE);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircularImageView, paramInt, 0);
    try
    {
      if (paramContext.getBoolean(R.styleable.CircularImageView_border, true))
      {
        paramInt = (int)getResources().getDimension(2131296641);
        this.mBorderWidth = paramContext.getDimensionPixelOffset(R.styleable.CircularImageView_border_width, paramInt);
        paramInt = getContext().getResources().getColor(2131165367);
        this.mPaintBorder.setColor(paramContext.getColor(R.styleable.CircularImageView_border_color, paramInt));
      }
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private RectF getCacheRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.mCacheRect == null) {
      this.mCacheRect = new RectF(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
    for (;;)
    {
      return this.mCacheRect;
      this.mCacheRect.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    }
  }
  
  private Paint getMaskPaint()
  {
    if (this.mMaskPaint == null)
    {
      this.mMaskPaint = new Paint();
      this.mMaskPaint.setStyle(Paint.Style.FILL);
      this.mMaskPaint.setAntiAlias(true);
    }
    this.mMaskPaint.setColor(this.mMaskColor);
    return this.mMaskPaint;
  }
  
  public int getBorderRadius()
  {
    return this.mBorderRadius;
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if ((i == 0) || (j == 0)) {
      super.onDraw(paramCanvas);
    }
    int k;
    Object localObject;
    label263:
    label297:
    do
    {
      return;
      if (this.mImage != null)
      {
        k = this.mImage.getWidth();
        int m = this.mImage.getHeight();
        float f = Math.max(i / k, j / m);
        localObject = new BitmapShader(this.mImage, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        this.mTransformMatrix.reset();
        this.mTransformMatrix.setScale(f, f);
        this.mTransformMatrix.postTranslate((i - k * f) / 2.0F, (j - m * f) / 2.0F);
        ((BitmapShader)localObject).setLocalMatrix(this.mTransformMatrix);
        this.mPaint.setShader((Shader)localObject);
        if (this.mBorderRadius >= 0) {
          break label263;
        }
        k = i / 2;
        m = j / 2;
        int n = (i - this.mBorderWidth) / 2;
        paramCanvas.drawCircle(k, m, n, this.mPaint);
      }
      for (;;)
      {
        if (this.mBorderRadius >= 0) {
          break label297;
        }
        k = i / 2;
        j /= 2;
        i = (i - this.mBorderWidth) / 2;
        paramCanvas.drawCircle(k, j, i, this.mPaintBorder);
        if (!this.mIsNeedMask) {
          break;
        }
        paramCanvas.drawCircle(k, j, i, getMaskPaint());
        return;
        k = this.mBorderRadius;
        paramCanvas.drawRoundRect(getCacheRect(0.0F, 0.0F, i, j), k, k, this.mPaint);
      }
      k = this.mBorderRadius;
      localObject = getCacheRect(0.0F, 0.0F, i, j);
      paramCanvas.drawRoundRect((RectF)localObject, k, k, this.mPaintBorder);
    } while (!this.mIsNeedMask);
    paramCanvas.drawRoundRect((RectF)localObject, k, k, getMaskPaint());
  }
  
  public void setBorderColor(int paramInt)
  {
    if (this.mPaintBorder != null) {
      this.mPaintBorder.setColor(paramInt);
    }
    invalidate();
  }
  
  public void setBorderRadius(int paramInt)
  {
    this.mBorderRadius = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
    this.mPaintBorder.setStrokeWidth(this.mBorderWidth);
    requestLayout();
    invalidate();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.mImage = paramBitmap;
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {}
    for (this.mImage = ((BitmapDrawable)paramDrawable).getBitmap();; this.mImage = null)
    {
      super.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  public void setImageResource(int paramInt)
  {
    this.mImage = null;
    super.setImageResource(paramInt);
  }
  
  public void setMaskColor(int paramInt)
  {
    this.mIsNeedMask = true;
    this.mMaskColor = paramInt;
    invalidate();
  }
  
  public void setMaskEnabled(boolean paramBoolean)
  {
    this.mIsNeedMask = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CircularImageView
 * JD-Core Version:    0.7.0.1
 */