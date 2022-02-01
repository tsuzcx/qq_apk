package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import aqgz;
import wja;

public class LoadingView
  extends View
{
  private RectF G;
  private int aWY;
  private int aWZ;
  private int aXa;
  private int aXb;
  private Rect aw;
  private Rect ax;
  private int mAvatarSize;
  private Paint mLinePaint;
  private Paint mRectPaint;
  private int mTitleHeight;
  private int mTitleWidth;
  
  public LoadingView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void Z(Canvas paramCanvas)
  {
    this.G.left = (getLeft() + getPaddingLeft());
    this.G.top = ((this.mTitleHeight + this.aXb * 2) / 2 - this.mAvatarSize / 2);
    this.G.right = (this.G.left + this.mAvatarSize);
    this.G.bottom = (this.G.top + this.mAvatarSize);
    paramCanvas.drawRect(this.G, this.mRectPaint);
  }
  
  private void aa(Canvas paramCanvas)
  {
    this.aw.left = ((int)(getLeft() + this.aXa + this.G.right));
    this.aw.top = this.aXb;
    this.aw.right = (this.aw.left + this.mTitleWidth);
    this.aw.bottom = (this.aw.top + this.mTitleHeight);
    paramCanvas.drawRect(this.aw, this.mRectPaint);
  }
  
  private void ab(Canvas paramCanvas)
  {
    this.ax.left = (getLeft() + getPaddingLeft());
    this.ax.top = (this.aw.bottom + this.aXb);
    this.ax.right = (this.ax.left + (int)aqgz.hK());
    this.ax.bottom = (this.ax.top + this.aWY);
    paramCanvas.drawRect(this.ax, this.mRectPaint);
  }
  
  private void ac(Canvas paramCanvas)
  {
    paramCanvas.drawLine(this.ax.left + this.aWZ, this.ax.top, this.ax.left + this.aWZ, this.ax.left + this.ax.top + this.aWY, this.mLinePaint);
    paramCanvas.drawLine(this.ax.left + this.aWZ * 2, this.ax.top, this.ax.left + this.aWZ * 2, this.ax.top + this.aWY, this.mLinePaint);
    paramCanvas.drawLine(this.ax.left + this.aWZ * 3, this.ax.top, this.ax.left + this.aWZ * 3, this.ax.top + this.aWY, this.mLinePaint);
  }
  
  private void init()
  {
    this.G = new RectF();
    this.aw = new Rect();
    this.ax = new Rect();
    this.mRectPaint = new Paint();
    this.mRectPaint.setStyle(Paint.Style.FILL);
    this.mRectPaint.setColor(Color.parseColor("#E8E8E7"));
    this.mLinePaint = new Paint();
    this.mLinePaint.setStyle(Paint.Style.FILL);
    this.mLinePaint.setStrokeWidth(wja.dp2px(2.0F, getResources()));
    this.mLinePaint.setColor(Color.parseColor("#ffffff"));
    this.mAvatarSize = wja.dp2px(28.0F, getResources());
    this.mTitleWidth = wja.dp2px(100.0F, getResources());
    this.mTitleHeight = wja.dp2px(15.0F, getResources());
    this.aWZ = ((int)(aqgz.hK() * 0.29D));
    this.aWY = (this.aWZ * 4 / 3);
    this.aXa = wja.dp2px(9.0F, getResources());
    this.aXb = wja.dp2px(18.0F, getResources());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Z(paramCanvas);
    aa(paramCanvas);
    ab(paramCanvas);
    ac(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.mTitleHeight;
    paramInt2 = this.aXb;
    int i = this.aWY;
    setMeasuredDimension((int)aqgz.hK(), paramInt1 + paramInt2 * 2 + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.LoadingView
 * JD-Core Version:    0.7.0.1
 */