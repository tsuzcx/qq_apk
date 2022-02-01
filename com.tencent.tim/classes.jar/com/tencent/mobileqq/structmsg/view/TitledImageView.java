package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import aofk;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;

public class TitledImageView
  extends AnyScaleTypeImageView
{
  private Path Q;
  private TransformationMethod a;
  private int bWa = -16777216;
  private int dMO = 10;
  private int dMP = 10;
  private Layout mLayout;
  private TextPaint mPaint = new TextPaint();
  private CharSequence mTitle;
  private int textColor = -1;
  
  public TitledImageView(Context paramContext)
  {
    super(paramContext);
    this.mPaint.setAntiAlias(true);
    this.a = SingleLineTransformationMethod.getInstance();
  }
  
  public TitledImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mPaint.setAntiAlias(true);
    this.a = SingleLineTransformationMethod.getInstance();
  }
  
  public TitledImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setAntiAlias(true);
    this.a = SingleLineTransformationMethod.getInstance();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!TextUtils.isEmpty(this.mTitle))
    {
      this.mPaint.setColor(this.bWa);
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      float f = getMeasuredHeight() - this.mPaint.getTextSize() - this.dMO * 2;
      paramCanvas.save();
      paramCanvas.clipRect(0.0F, f, getMeasuredWidth(), getMeasuredHeight());
      if (this.Q != null) {
        paramCanvas.drawPath(this.Q, this.mPaint);
      }
      paramCanvas.translate(0.0F + this.dMO, f + this.dMO);
      this.mPaint.setColor(this.textColor);
      if (this.mLayout != null) {
        this.mLayout.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMeasuredHeight();
    paramInt2 = getMeasuredWidth();
    if ((paramInt1 < 1) || (paramInt2 < 1)) {}
    float f2;
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      this.Q = new Path();
      float f1 = paramInt1 - this.dMO * 2 - this.mPaint.getTextSize();
      f2 = paramInt2;
      float f3 = paramInt1;
      this.Q.moveTo(0.0F, f1);
      this.Q.lineTo(f2, f1);
      this.Q.lineTo(f2, f3 - this.dMP);
      localObject = new RectF(f2 - this.dMP * 2, f3 - this.dMP * 2, f2, f3);
      this.Q.arcTo((RectF)localObject, 0.0F, 90.0F, false);
      this.Q.lineTo(this.dMP + 0.0F, f3);
      localObject = new RectF(0.0F, f3 - this.dMP * 2, this.dMP * 2 + 0.0F, f3);
      this.Q.arcTo((RectF)localObject, 90.0F, 90.0F, true);
      this.Q.lineTo(0.0F, f1);
      this.Q.close();
    } while (this.mTitle == null);
    Object localObject = this.a.getTransformation(this.mTitle, this);
    paramInt1 = (int)Layout.getDesiredWidth(this.mTitle, this.mPaint);
    this.mLayout = new DynamicLayout(this.mTitle, (CharSequence)localObject, this.mPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.5F, false, TextUtils.TruncateAt.END, (int)(f2 - this.dMO * 2));
  }
  
  public void setTextBackground(int paramInt)
  {
    this.bWa = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public void setTextPadding(int paramInt)
  {
    this.dMO = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.mPaint.setTextSize(paramFloat);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.mTitle instanceof aofk))
    {
      this.mTitle = paramCharSequence;
      return;
    }
    this.mTitle = new aofk(paramCharSequence, 1, 16);
  }
  
  public void settextBgRadius(int paramInt)
  {
    this.dMP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.TitledImageView
 * JD-Core Version:    0.7.0.1
 */