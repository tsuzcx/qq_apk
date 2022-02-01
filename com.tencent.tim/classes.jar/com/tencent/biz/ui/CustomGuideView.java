package com.tencent.biz.ui;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class CustomGuideView
  extends View
{
  public int AD;
  public int bgColor;
  public int byu;
  public int byv;
  private TextPaint f;
  public int mContentHeight;
  public int padding;
  private Paint paint;
  private Path path;
  public int radius;
  public String text = acfp.m(2131704601);
  public int textColor;
  public float textSize;
  
  public CustomGuideView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CustomGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CustomGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int m(float paramFloat)
  {
    return (int)(getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private int measureDimension(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      paramInt2 = i;
    }
    do
    {
      return paramInt2;
      paramInt2 = paramInt1;
    } while (j != -2147483648);
    return Math.min(paramInt1, i);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    float f1 = getWidth() * 0.9F - this.byv;
    float f2 = this.byu;
    this.path.reset();
    this.path.moveTo(f1, f2);
    this.path.lineTo(this.byv / 2 + f1, 0.0F);
    this.path.lineTo(f1 + this.byv, f2);
    this.paint.setColor(this.bgColor);
    this.paint.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(this.path, this.paint);
    RectF localRectF = new RectF(0.0F, this.byu, getWidth(), getHeight());
    paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.paint);
    this.f.setColor(this.textColor);
    this.f.setTextSize(this.textSize);
    Paint.FontMetrics localFontMetrics = this.f.getFontMetrics();
    String str = this.text;
    f1 = (getWidth() - this.f.measureText(this.text)) / 2.0F;
    f2 = this.byu;
    float f3 = localRectF.height();
    float f4 = localFontMetrics.ascent;
    paramCanvas.drawText(str, f1, (f3 - (localFontMetrics.bottom + f4)) / 2.0F + f2, this.f);
  }
  
  public void init()
  {
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setFilterBitmap(true);
    this.f = new TextPaint();
    this.path = new Path();
    this.radius = m(12.5F);
    this.mContentHeight = m(30.0F);
    this.byu = m(7.0F);
    this.padding = m(5.0F);
    this.AD = 0;
    this.textSize = m(12.0F);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(measureDimension(uq(), paramInt1), measureDimension(up(), paramInt2));
  }
  
  public int up()
  {
    return this.mContentHeight + this.byu;
  }
  
  public int uq()
  {
    this.f.setTextSize(this.textSize);
    return (int)(this.f.measureText(this.text) + this.padding * 2 + this.AD * 2 + this.radius * 2 + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.ui.CustomGuideView
 * JD-Core Version:    0.7.0.1
 */