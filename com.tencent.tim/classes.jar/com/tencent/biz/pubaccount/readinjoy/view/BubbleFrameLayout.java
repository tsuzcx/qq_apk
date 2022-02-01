package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import atau.a;

public class BubbleFrameLayout
  extends FrameLayout
{
  private static final int aXE = Color.argb(25, 0, 0, 0);
  private int aXF;
  private int backgroundColor;
  private int borderColor;
  private int borderRadius;
  private int borderWidth;
  private float kk;
  private Paint paint = new Paint(1);
  private Path path = new Path();
  private RectF rectF = new RectF();
  private int shadowColor;
  private int shadowDx;
  private int shadowDy;
  private int shadowRadius;
  private float x1;
  private float x2;
  private float x3;
  private float y1;
  private float y2;
  private float y3;
  
  public BubbleFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BubbleFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  private void aVy()
  {
    setPadding(getPaddingLeft() + this.shadowRadius, getPaddingTop() + this.shadowRadius, getPaddingRight() + this.shadowRadius, getPaddingBottom() + this.aXF + this.shadowRadius);
  }
  
  private void ae(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i = this.shadowRadius;
    int j = getWidth() - this.shadowRadius;
    int k = this.shadowRadius;
    int m = getHeight() - this.aXF - this.shadowRadius;
    this.path.moveTo(this.borderRadius + i, m);
    this.rectF.set(i, m - this.borderRadius * 2, this.borderRadius * 2 + i, m);
    this.path.arcTo(this.rectF, 90.0F, 90.0F);
    this.path.lineTo(i, this.borderRadius + k);
    this.rectF.set(i, k, this.borderRadius * 2 + i, this.borderRadius * 2 + k);
    this.path.arcTo(this.rectF, -180.0F, 90.0F);
    this.path.lineTo(j - this.borderRadius, k);
    this.rectF.set(j - this.borderRadius * 2, k, j, k + this.borderRadius * 2);
    this.path.arcTo(this.rectF, -90.0F, 90.0F);
    this.path.lineTo(j, m - this.borderRadius);
    this.rectF.set(j - this.borderRadius * 2, m - this.borderRadius * 2, j, m);
    this.path.arcTo(this.rectF, 0.0F, 90.0F);
    this.x2 = (getWidth() * this.kk);
    this.y2 = (getHeight() - this.shadowRadius);
    this.x1 = (this.x2 - this.aXF);
    this.y1 = (this.y2 - this.aXF);
    this.x3 = (this.x1 + this.aXF * 2);
    this.y3 = this.y1;
    this.path.lineTo(this.x3, this.y3);
    this.path.lineTo(this.x2, this.y2);
    this.path.lineTo(this.x1, this.y1);
    this.path.lineTo(i + this.borderRadius, m);
    this.path.close();
    paramCanvas.drawPath(this.path, this.paint);
    this.path.reset();
    paramCanvas.restore();
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, atau.a.pI, 0, 0);
    try
    {
      this.kk = paramContext.getFloat(8, 0.6F);
      this.aXF = paramContext.getDimensionPixelSize(9, 24);
      this.borderRadius = paramContext.getDimensionPixelSize(2, 6);
      this.shadowDx = paramContext.getDimensionPixelSize(5, 0);
      this.shadowDy = paramContext.getDimensionPixelSize(6, 4);
      this.shadowRadius = paramContext.getDimensionPixelSize(7, 24);
      this.shadowColor = paramContext.getColor(4, aXE);
      this.backgroundColor = paramContext.getColor(0, -1);
      this.borderColor = paramContext.getColor(1, -1644826);
      this.borderWidth = paramContext.getDimensionPixelSize(3, 1);
      paramContext.recycle();
      this.path.setFillType(Path.FillType.WINDING);
      this.paint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
      setLayerType(1, this.paint);
      setWillNotDraw(false);
      aVy();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(0.0F, this.shadowRadius / 2);
    this.paint.setColor(this.backgroundColor);
    ae(paramCanvas);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(this.borderWidth);
    this.paint.setColor(this.borderColor);
    ae(paramCanvas);
    this.paint.setAlpha(255);
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BubbleFrameLayout
 * JD-Core Version:    0.7.0.1
 */