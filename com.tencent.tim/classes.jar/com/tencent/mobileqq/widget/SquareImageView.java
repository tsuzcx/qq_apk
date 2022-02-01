package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
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
import atau.a;
import com.tencent.image.URLImageView;

public class SquareImageView
  extends URLImageView
{
  public static final String TAG = SquareImageView.class.getSimpleName();
  private int bhV = -1;
  private Paint cH = new Paint();
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sk);
    this.mScale = paramContext.getFloat(4, 1.0F);
    this.mScaleOffset = paramContext.getFloat(5, 0.0F);
    this.mFilterColor = paramContext.getColor(0, -1);
    this.mFilterText = paramContext.getString(1);
    this.mFilterTextSize = paramContext.getDimensionPixelSize(2, 40);
    this.mRoundRectRadius = paramContext.getDimensionPixelSize(3, 0);
    paramContext.recycle();
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
    if (this.bhV != -1)
    {
      this.cH.setColor(this.bhV);
      this.cH.setAntiAlias(false);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.cH);
    }
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
  
  public void setCircleBgColor(int paramInt)
  {
    this.bhV = paramInt;
    invalidate();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SquareImageView
 * JD-Core Version:    0.7.0.1
 */