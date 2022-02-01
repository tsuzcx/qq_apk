package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import aqcx;

public class TipsView
  extends View
{
  protected Paint Q;
  protected int buV = 1;
  protected int buW = 3;
  protected float mHeight;
  protected int mOffsetX;
  protected Path mPath;
  protected RectF mRectF = new RectF();
  protected String mText = "";
  protected Paint mTextPaint;
  protected float mWidth;
  
  public TipsView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public static void a(Context paramContext, View paramView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    TipsView localTipsView = new TipsView(paramContext);
    localTipsView.setText(paramString);
    localTipsView.setBgColor(paramInt7);
    localTipsView.setArrowPosition(paramInt1, paramInt2, paramInt5);
    paramString = new PopupWindow(localTipsView, -2, -2);
    paramString.setTouchable(true);
    paramString.setOutsideTouchable(true);
    paramString.setBackgroundDrawable(new BitmapDrawable(paramContext.getResources(), (Bitmap)null));
    paramInt5 = (int)((paramView.getWidth() - localTipsView.aA()) / 2.0F);
    if (paramInt2 == 1) {}
    for (;;)
    {
      if (paramInt1 == 1) {}
      for (float f = aqcx.dip2px(paramContext, 5.0F);; f = -paramView.getHeight() - localTipsView.aB() - aqcx.dip2px(paramContext, 5.0F))
      {
        paramString.showAsDropDown(paramView, paramInt3, (int)f + paramInt4);
        localTipsView.postDelayed(new TipsView.1(paramString), paramInt6);
        return;
        if (paramInt2 != 2) {
          break label191;
        }
        paramInt3 = (int)(paramView.getWidth() - localTipsView.aA());
        break;
      }
      label191:
      paramInt3 = paramInt5;
    }
  }
  
  public float aA()
  {
    if (this.mWidth == 0.0F) {
      return this.mTextPaint.measureText(this.mText) + (super.getPaddingLeft() + super.getPaddingRight());
    }
    return this.mWidth;
  }
  
  public float aB()
  {
    if (this.mHeight == 0.0F)
    {
      Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
      return localFontMetrics.bottom - localFontMetrics.top + (super.getPaddingTop() + super.getPaddingBottom()) + aqcx.dip2px(super.getContext(), 6.5F);
    }
    return this.mHeight;
  }
  
  protected void init()
  {
    this.mTextPaint = new Paint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setColor(-1);
    this.mTextPaint.setTextSize(aqcx.dip2px(super.getContext(), 14.0F));
    this.Q = new Paint();
    this.Q.setAntiAlias(true);
    this.Q.setColor(Color.argb(178, 0, 0, 0));
    this.mPath = new Path();
    int i = aqcx.dip2px(super.getContext(), 10.0F);
    super.setPadding(i, i, i, i);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    Object localObject = this.mTextPaint.getFontMetrics();
    float f1 = ((Paint.FontMetrics)localObject).bottom;
    float f2 = ((Paint.FontMetrics)localObject).top;
    float f3 = ((Paint.FontMetrics)localObject).bottom;
    float f4 = super.getPaddingTop();
    int j;
    if (this.buV == 1)
    {
      i = aqcx.dip2px(super.getContext(), 6.5F);
      localObject = this.mRectF;
      float f5 = i;
      float f6 = this.mWidth;
      float f7 = this.mHeight;
      if (this.buV != 1) {
        break label289;
      }
      j = 0;
      label91:
      ((RectF)localObject).set(0.0F, f5, f6, f7 - j);
      paramCanvas.drawRoundRect(this.mRectF, aqcx.dip2px(super.getContext(), 4.0F), aqcx.dip2px(super.getContext(), 4.0F), this.Q);
      paramCanvas.drawText(this.mText, super.getPaddingLeft(), f4 + (f1 - f2 - f3) + i, this.mTextPaint);
      this.mPath.reset();
      f1 = this.mWidth / 2.0F;
      if (this.buW != 1) {
        break label303;
      }
      f1 = this.mOffsetX;
    }
    for (;;)
    {
      if (this.buV != 1) {
        break label325;
      }
      this.mPath.moveTo(f1, 0.0F);
      this.mPath.lineTo(f1 - aqcx.dip2px(super.getContext(), 6.5F), i);
      this.mPath.lineTo(f1 + aqcx.dip2px(super.getContext(), 6.5F), i);
      this.mPath.close();
      paramCanvas.drawPath(this.mPath, this.Q);
      super.onDraw(paramCanvas);
      return;
      i = 0;
      break;
      label289:
      j = aqcx.dip2px(super.getContext(), 6.5F);
      break label91;
      label303:
      if (this.buW == 2) {
        f1 = this.mWidth - this.mOffsetX;
      }
    }
    label325:
    this.mPath.moveTo(f1, this.mHeight);
    localObject = this.mPath;
    f2 = aqcx.dip2px(super.getContext(), 6.5F);
    f3 = this.mHeight;
    if (this.buV == 1)
    {
      i = 0;
      label371:
      ((Path)localObject).lineTo(f1 - f2, f3 - i);
      localObject = this.mPath;
      f2 = aqcx.dip2px(super.getContext(), 6.5F);
      f3 = this.mHeight;
      if (this.buV != 1) {
        break label470;
      }
    }
    label470:
    for (int i = k;; i = aqcx.dip2px(super.getContext(), 6.5F))
    {
      ((Path)localObject).lineTo(f1 + f2, f3 - i);
      this.mPath.close();
      paramCanvas.drawPath(this.mPath, this.Q);
      break;
      i = aqcx.dip2px(super.getContext(), 6.5F);
      break label371;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = (this.mTextPaint.measureText(this.mText) + (super.getPaddingLeft() + super.getPaddingRight()));
    Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
    this.mHeight = (localFontMetrics.bottom - localFontMetrics.top + (super.getPaddingTop() + super.getPaddingBottom()) + aqcx.dip2px(super.getContext(), 6.5F));
    super.setMeasuredDimension((int)this.mWidth, (int)this.mHeight);
  }
  
  public void setArrowPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    this.buV = paramInt1;
    this.buW = paramInt2;
    this.mOffsetX = paramInt3;
    super.invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    this.Q.setColor(paramInt);
    super.invalidate();
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.TipsView
 * JD-Core Version:    0.7.0.1
 */