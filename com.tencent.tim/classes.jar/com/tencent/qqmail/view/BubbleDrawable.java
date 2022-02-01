package com.tencent.qqmail.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class BubbleDrawable
  extends Drawable
{
  public static final int LOCATION_BOTTOM = 0;
  public static final int LOCATION_TOP = 1;
  private int mFilledColor;
  private Paint mLinePaint = new Paint();
  private Paint mRectPaint = new Paint();
  private int mRectRadius;
  private RectF mRectRect = new RectF();
  private Paint mRectStrokePaint = new Paint();
  private int mSideLength;
  private int mStrokeColor;
  private int mStrokeWidth;
  private int mTrangleLocation = 0;
  private int mTrangleLocationOffset = 0;
  private Path mTranglePath = new Path();
  private Point mTranglePointLeft;
  private Point mTranglePointOutSide;
  private Point mTranglePointRight;
  private Paint mTrianglePaint = new Paint();
  
  public BubbleDrawable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.mSideLength = paramInt1;
    this.mStrokeWidth = paramInt4;
    if (this.mStrokeWidth % 2 != 0) {
      this.mStrokeWidth += 1;
    }
    this.mRectRadius = paramInt7;
    this.mFilledColor = paramInt6;
    this.mStrokeColor = paramInt5;
    this.mTrangleLocation = paramInt2;
    this.mTrangleLocationOffset = paramInt3;
    this.mRectPaint.setStyle(Paint.Style.FILL);
    this.mRectStrokePaint.setStyle(Paint.Style.STROKE);
    this.mTrianglePaint.setStyle(Paint.Style.FILL);
    this.mLinePaint.setAntiAlias(true);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mRectPaint.setColor(this.mFilledColor);
    this.mTrianglePaint.setColor(this.mFilledColor);
    this.mLinePaint.setColor(this.mStrokeColor);
    this.mLinePaint.setStrokeWidth(this.mStrokeWidth);
    this.mRectStrokePaint.setStrokeWidth(this.mStrokeWidth);
    this.mRectStrokePaint.setColor(this.mStrokeColor);
    this.mTranglePath.moveTo(this.mTranglePointLeft.x, this.mTranglePointLeft.y);
    this.mTranglePath.lineTo(this.mTranglePointOutSide.x, this.mTranglePointOutSide.y);
    this.mTranglePath.lineTo(this.mTranglePointRight.x, this.mTranglePointRight.y);
    this.mTranglePath.close();
    paramCanvas.drawRoundRect(this.mRectRect, this.mRectRadius, this.mRectRadius, this.mRectPaint);
    paramCanvas.drawRoundRect(this.mRectRect, this.mRectRadius, this.mRectRadius, this.mRectStrokePaint);
    paramCanvas.drawPath(this.mTranglePath, this.mTrianglePaint);
    this.mLinePaint.setColor(this.mFilledColor);
    paramCanvas.drawLine(this.mTranglePointLeft.x, this.mTranglePointLeft.y, this.mTranglePointRight.x, this.mTranglePointRight.y, this.mLinePaint);
    this.mLinePaint.setColor(this.mStrokeColor);
    paramCanvas.drawLine(this.mTranglePointLeft.x, this.mTranglePointLeft.y, this.mTranglePointOutSide.x, this.mTranglePointOutSide.y, this.mLinePaint);
    paramCanvas.drawLine(this.mTranglePointRight.x, this.mTranglePointRight.y, this.mTranglePointOutSide.x, this.mTranglePointOutSide.y, this.mLinePaint);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mRectPaint.setAlpha(paramInt);
    this.mLinePaint.setAlpha(paramInt);
    this.mTrianglePaint.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = this.mStrokeWidth / 2;
    this.mRectRect.left = (paramInt1 + i + 1);
    this.mRectRect.right = (paramInt3 - i - 1);
    paramInt1 = (paramInt1 + paramInt3) / 2 + this.mTrangleLocationOffset;
    paramInt3 = this.mSideLength / 2;
    switch (this.mTrangleLocation)
    {
    }
    for (;;)
    {
      invalidateSelf();
      return;
      this.mRectRect.top = (i + paramInt2 + 1);
      this.mRectRect.bottom = (paramInt4 - paramInt3);
      this.mTranglePointOutSide = new Point(paramInt1, paramInt4);
      this.mTranglePointLeft = new Point(paramInt1 - paramInt3, (int)this.mRectRect.bottom);
      this.mTranglePointRight = new Point(paramInt1 + paramInt3, (int)this.mRectRect.bottom);
      continue;
      this.mRectRect.top = (paramInt2 + paramInt3);
      this.mRectRect.bottom = (paramInt4 - i - 1);
      this.mTranglePointOutSide = new Point(paramInt1, paramInt2);
      this.mTranglePointLeft = new Point(paramInt1 - paramInt3, (int)this.mRectRect.top);
      this.mTranglePointRight = new Point(paramInt1 + paramInt3, (int)this.mRectRect.top);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mRectPaint.setColorFilter(paramColorFilter);
    this.mLinePaint.setColorFilter(paramColorFilter);
    this.mTrianglePaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.BubbleDrawable
 * JD-Core Version:    0.7.0.1
 */