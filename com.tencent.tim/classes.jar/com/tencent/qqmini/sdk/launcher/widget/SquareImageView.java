package com.tencent.qqmini.sdk.launcher.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class SquareImageView
  extends ImageView
{
  public static final String TAG = SquareImageView.class.getSimpleName();
  protected final Path mClipPath = new Path();
  private int mFilterColor = -1;
  private String mFilterText;
  private int mFilterTextSize = 20;
  protected int mRoundRectRadius;
  private float mScale = 1.0F;
  private float mScaleOffset = 0.0F;
  protected final RectF mViewBounds = new RectF();
  
  public SquareImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mRoundRectRadius != 0)
    {
      if (this.mClipPath.isEmpty()) {
        this.mClipPath.addRoundRect(this.mViewBounds, this.mRoundRectRadius, this.mRoundRectRadius, Path.Direction.CW);
      }
      if (Build.VERSION.SDK_INT >= 18) {
        paramCanvas.clipPath(this.mClipPath);
      }
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Paint localPaint;
    if (this.mFilterColor != -1)
    {
      localPaint = new Paint();
      localPaint.setColor(this.mFilterColor);
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight()), this.mRoundRectRadius, this.mRoundRectRadius, localPaint);
    }
    if (!TextUtils.isEmpty(this.mFilterText))
    {
      localPaint = new Paint(1);
      localPaint.setTextSize(this.mFilterTextSize);
      localPaint.setColor(-1);
      localPaint.setTextAlign(Paint.Align.CENTER);
      Paint.FontMetricsInt localFontMetricsInt = localPaint.getFontMetricsInt();
      paramCanvas.drawText(this.mFilterText, getMeasuredWidth() / 2, (getMeasuredHeight() - localFontMetricsInt.ascent - localFontMetricsInt.descent) / 2, localPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mViewBounds.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
    paramInt1 = getMeasuredWidth();
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * 1.0F / this.mScale + (int)this.mScaleOffset), 1073741824));
  }
  
  public void setFilterColor(int paramInt)
  {
    this.mFilterColor = paramInt;
    invalidate();
  }
  
  public void setFilterText(String paramString)
  {
    this.mFilterText = paramString;
    requestLayout();
  }
  
  public void setFilterTextSize(int paramInt)
  {
    this.mFilterTextSize = paramInt;
    requestLayout();
  }
  
  public void setImageScale(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > 0.0F) {
      this.mScale = paramFloat1;
    }
    this.mScaleOffset = paramFloat2;
    requestLayout();
  }
  
  public void setRoundRect(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 0;
    }
    this.mRoundRectRadius = i;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.widget.SquareImageView
 * JD-Core Version:    0.7.0.1
 */