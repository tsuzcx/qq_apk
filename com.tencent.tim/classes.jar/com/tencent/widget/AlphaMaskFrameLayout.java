package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

public class AlphaMaskFrameLayout
  extends FrameLayout
{
  private static final float[] dP = { 0.0F, 1.0F };
  private static final int[] tm = { -1, 0 };
  private int esr;
  private Bitmap gV;
  private Bitmap gW;
  private Paint mPaint;
  
  public AlphaMaskFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlphaMaskFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AlphaMaskFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.esr = ((int)(paramContext.getResources().getDisplayMetrics().density * 15.0F + 0.5F));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
    }
    Object localObject1;
    Object localObject2;
    if ((this.gV == null) || (this.gV.getWidth() != getWidth()))
    {
      this.gV = Bitmap.createBitmap(getWidth(), this.esr, Bitmap.Config.ARGB_8888);
      this.gV.setDensity(getResources().getDisplayMetrics().densityDpi);
      localObject1 = new Canvas(this.gV);
      localObject2 = new Paint(1);
      ((Paint)localObject2).setShader(new LinearGradient(0.0F, 0.0F, 0.0F, this.esr, tm, dP, Shader.TileMode.CLAMP));
      ((Canvas)localObject1).drawRect(0.0F, 0.0F, ((Canvas)localObject1).getWidth(), ((Canvas)localObject1).getHeight(), (Paint)localObject2);
    }
    if (((this.gW == null) || (this.gW.getWidth() != getWidth())) && (this.gV != null))
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).preScale(1.0F, -1.0F);
      localObject2 = this.gV;
      this.gW = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, false);
      this.gW.setDensity(getResources().getDisplayMetrics().densityDpi);
    }
    if (this.gV != null) {
      paramCanvas.drawBitmap(this.gV, 0.0F, 0.0F, this.mPaint);
    }
    if (this.gW != null) {
      paramCanvas.drawBitmap(this.gW, 0.0F, getHeight() - this.gW.getHeight(), this.mPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.AlphaMaskFrameLayout
 * JD-Core Version:    0.7.0.1
 */