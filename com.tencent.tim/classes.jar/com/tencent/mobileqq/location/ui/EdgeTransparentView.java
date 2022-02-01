package com.tencent.mobileqq.location.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import atau.a;

public class EdgeTransparentView
  extends FrameLayout
{
  private float[] cA = { 0.0F, 0.5F, 1.0F };
  private int deZ = 1;
  private int dfa = this.deZ << 1;
  private int dfb = this.deZ << 2;
  private int dfc = this.deZ << 3;
  private int[] lH = { -1, -1, 16777215 };
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int position;
  private float wX;
  
  public EdgeTransparentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void dub()
  {
    this.mPaint.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.wX, this.lH, this.cA, Shader.TileMode.CLAMP));
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mPaint = new Paint(1);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qh);
    this.position = paramContext.getInt(0, 0);
    this.wX = paramContext.getDimension(1, 40.0F);
    paramContext.recycle();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    if ((this.position == 0) || ((this.position & this.deZ) != 0)) {
      paramCanvas.drawRect(0.0F, 0.0F, this.mWidth, this.wX, this.mPaint);
    }
    int j;
    if ((this.position == 0) || ((this.position & this.dfa) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(180.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.drawRect(0.0F, 0.0F, this.mWidth, this.wX, this.mPaint);
      paramCanvas.restoreToCount(j);
    }
    float f = (this.mHeight - this.mWidth) / 2.0F;
    if ((this.position == 0) || ((this.position & this.dfb) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(270.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.translate(0.0F, f);
      paramCanvas.drawRect(0.0F - f, 0.0F, this.mWidth + f, this.wX, this.mPaint);
      paramCanvas.restoreToCount(j);
    }
    if ((this.position == 0) || ((this.position & this.dfc) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(90.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.translate(0.0F, f);
      paramCanvas.drawRect(0.0F - f, 0.0F, this.mWidth + f, this.wX, this.mPaint);
      paramCanvas.restoreToCount(j);
    }
    paramCanvas.restoreToCount(i);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    dub();
    this.mWidth = getWidth();
    this.mHeight = getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.EdgeTransparentView
 * JD-Core Version:    0.7.0.1
 */