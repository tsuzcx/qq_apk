package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import atau.a;
import com.tencent.qphone.base.util.QLog;

public class BubbleLayout
  extends RelativeLayout
{
  int caB;
  int caC;
  private Point d;
  boolean isSelected;
  private Paint mBorderPaint;
  private int mDirection;
  private int mOffset;
  private Path mPath;
  private int mRadius;
  private RectF mRect;
  float qO;
  
  public BubbleLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  private void aH(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    if (i == 0) {
      return;
    }
    this.mPath.reset();
    this.mPath.addRoundRect(this.mRect, this.mRadius, this.mRadius, Path.Direction.CCW);
    if (this.isSelected)
    {
      this.mPath.moveTo(this.d.x, this.d.y - i);
      this.mPath.lineTo(this.d.x - i, this.d.y);
      this.mPath.lineTo(this.d.x, i + this.d.y);
      CornerPathEffect localCornerPathEffect = new CornerPathEffect(this.qO);
      this.mBorderPaint.setPathEffect(localCornerPathEffect);
    }
    paramCanvas.drawPath(this.mPath, this.mBorderPaint);
  }
  
  private void aI(Canvas paramCanvas)
  {
    int i = getPaddingTop();
    if (i == 0) {
      return;
    }
    this.mPath.reset();
    this.mPath.addRoundRect(this.mRect, this.mRadius, this.mRadius, Path.Direction.CCW);
    if (this.isSelected)
    {
      this.mPath.moveTo(this.d.x + i, this.d.y);
      this.mPath.lineTo(this.d.x, this.d.y - i);
      this.mPath.lineTo(this.d.x - i, this.d.y);
      CornerPathEffect localCornerPathEffect = new CornerPathEffect(this.qO);
      this.mBorderPaint.setPathEffect(localCornerPathEffect);
    }
    paramCanvas.drawPath(this.mPath, this.mBorderPaint);
  }
  
  private void aJ(Canvas paramCanvas)
  {
    int i = getPaddingRight();
    if (i == 0) {
      return;
    }
    this.mPath.reset();
    this.mPath.addRoundRect(this.mRect, this.mRadius, this.mRadius, Path.Direction.CCW);
    if (this.isSelected)
    {
      this.mPath.moveTo(this.d.x, this.d.y - i);
      this.mPath.lineTo(this.d.x + i, this.d.y);
      this.mPath.lineTo(this.d.x, i + this.d.y);
      CornerPathEffect localCornerPathEffect = new CornerPathEffect(this.qO);
      this.mBorderPaint.setPathEffect(localCornerPathEffect);
    }
    paramCanvas.drawPath(this.mPath, this.mBorderPaint);
  }
  
  private void aK(Canvas paramCanvas)
  {
    int i = getPaddingBottom();
    if (i == 0) {
      return;
    }
    this.mPath.reset();
    this.mPath.addRoundRect(this.mRect, this.mRadius, this.mRadius, Path.Direction.CCW);
    if (this.isSelected)
    {
      this.mPath.addRoundRect(this.mRect, this.mRadius, this.mRadius, Path.Direction.CCW);
      this.mPath.moveTo(this.d.x + i, this.d.y);
      this.mPath.lineTo(this.d.x, this.d.y + i);
      this.mPath.lineTo(this.d.x - i, this.d.y);
      if (Build.VERSION.SDK_INT < 21) {
        break label189;
      }
      CornerPathEffect localCornerPathEffect = new CornerPathEffect(this.qO);
      this.mBorderPaint.setPathEffect(localCornerPathEffect);
    }
    for (;;)
    {
      paramCanvas.drawPath(this.mPath, this.mBorderPaint);
      return;
      label189:
      this.mPath.close();
    }
  }
  
  private void ckF()
  {
    switch (this.mDirection)
    {
    default: 
      return;
    case 1: 
    case 3: 
      localPoint = this.d;
      localPoint.y += this.mOffset;
      return;
    }
    Point localPoint = this.d;
    localPoint.x += this.mOffset;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pD);
    this.caC = paramContext.getColor(0, -1);
    this.caB = Color.parseColor("#F5F6FA");
    int i = paramContext.getColor(4, Color.parseColor("#999999"));
    int j = paramContext.getDimensionPixelSize(5, (int)TypedValue.applyDimension(0, 0.0F, getResources().getDisplayMetrics()));
    this.mRadius = paramContext.getDimensionPixelSize(1, 0);
    this.qO = paramContext.getDimensionPixelSize(6, 0);
    this.mDirection = paramContext.getInt(2, 4);
    this.mOffset = paramContext.getDimensionPixelOffset(3, 0);
    paramContext.recycle();
    this.mBorderPaint = new Paint();
    this.mBorderPaint.setAntiAlias(true);
    this.mBorderPaint.setColor(this.caB);
    this.mBorderPaint.setShadowLayer(j, 0.0F, 0.0F, i);
    this.mPath = new Path();
    this.mRect = new RectF();
    this.d = new Point();
    setWillNotDraw(false);
    setLayerType(1, null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.d.x > 0) && (this.d.y > 0))
    {
      if (!this.isSelected) {
        break label77;
      }
      this.mBorderPaint.setColor(this.caC);
    }
    for (;;)
    {
      switch (this.mDirection)
      {
      default: 
        return;
        label77:
        this.mBorderPaint.setColor(this.caB);
      }
    }
    aH(paramCanvas);
    return;
    aI(paramCanvas);
    return;
    aJ(paramCanvas);
    return;
    aK(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mRect.left = getPaddingLeft();
    this.mRect.top = getPaddingTop();
    this.mRect.right = (paramInt1 - getPaddingRight());
    this.mRect.bottom = (paramInt2 - getPaddingBottom());
    switch (this.mDirection)
    {
    }
    for (;;)
    {
      if (this.mOffset != 0) {
        ckF();
      }
      return;
      this.d.x = getPaddingLeft();
      this.d.y = (paramInt2 / 2);
      continue;
      this.d.x = (paramInt1 / 2);
      this.d.y = getPaddingTop();
      continue;
      this.d.x = (paramInt1 - getPaddingRight());
      this.d.y = (paramInt2 / 2);
      continue;
      this.d.x = (paramInt1 / 2);
      this.d.y = (paramInt2 - getPaddingBottom());
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
    postInvalidate();
  }
  
  public void setSelectedColor(String paramString)
  {
    try
    {
      this.caC = Color.parseColor(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.d("BubbleLayout", 1, "setSelectedColor error", paramString);
    }
  }
  
  public void setTriangleOffset(int paramInt)
  {
    this.mOffset = paramInt;
    ckF();
    invalidate();
  }
  
  public void setUnselectedColor(String paramString)
  {
    try
    {
      this.caB = Color.parseColor(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.d("BubbleLayout", 1, "setUnselectedColor error", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */