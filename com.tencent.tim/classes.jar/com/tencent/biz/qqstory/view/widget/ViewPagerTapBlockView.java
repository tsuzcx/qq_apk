package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import atau.a;

public class ViewPagerTapBlockView
  extends View
{
  private int buX;
  private int buY;
  private int buZ;
  private int mOffset;
  private Paint mPaint = new Paint();
  
  public ViewPagerTapBlockView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerTapBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerTapBlockView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, atau.a.sM, paramInt, 0);
    int j = paramContext.getIndexCount();
    paramInt = i;
    if (paramInt < j)
    {
      i = paramContext.getIndex(paramInt);
      switch (i)
      {
      }
      for (;;)
      {
        paramInt += 1;
        break;
        this.buX = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 56.0F, getResources().getDisplayMetrics()));
        continue;
        this.buY = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 3.0F, getResources().getDisplayMetrics()));
        continue;
        this.buZ = paramContext.getColor(i, -1);
        continue;
        this.mOffset = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 0.0F, getResources().getDisplayMetrics()));
      }
    }
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(this.buZ);
    paramCanvas.drawRect(this.mOffset, 0.0F, this.buX + this.mOffset, this.buY, this.mPaint);
  }
  
  public void setBlockColor(int paramInt)
  {
    this.buZ = paramInt;
  }
  
  public void setBlockWidth(int paramInt)
  {
    this.buX = paramInt;
  }
  
  public void setOffset(int paramInt)
  {
    this.mOffset = paramInt;
    invalidate();
  }
  
  public String toString()
  {
    return "ViewPagerTapBlockView width:" + this.buX + " | offset:" + this.mOffset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.ViewPagerTapBlockView
 * JD-Core Version:    0.7.0.1
 */