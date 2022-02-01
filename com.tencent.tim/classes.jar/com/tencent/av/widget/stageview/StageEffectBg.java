package com.tencent.av.widget.stageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class StageEffectBg
  extends View
{
  private static final float[] al = { 0.8F, 0.6F, 0.6F, 0.5F, 0.5F, 0.4F, 0.4F, 0.3F };
  static final double[] d = { 0.0D, 5.585053606381854D, 0.6981317007977318D, 4.188790204786391D, 2.094395102393195D, 3.403392041388943D, 2.879793265790644D, 3.141592653589793D };
  private final RectF B = new RectF(-300.0F, -300.0F, 300.0F, 300.0F);
  private float[] aj;
  private float[] ak;
  private Paint au;
  private Bitmap bM;
  private final Camera mCamera = new Camera();
  private final Matrix mDrawMatrix = new Matrix();
  
  public StageEffectBg(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public StageEffectBg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.au = new Paint();
    this.au.setAntiAlias(true);
    this.au.setDither(true);
    this.au.setStyle(Paint.Style.STROKE);
    this.au.setColor(1358954495);
    this.au.setStrokeWidth(2.0F);
    this.au.setStrokeCap(Paint.Cap.ROUND);
    this.au.setStrokeJoin(Paint.Join.ROUND);
    this.aj = new float[16];
    this.ak = new float[8];
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.mDrawMatrix);
    paramCanvas.drawOval(this.B, this.au);
    paramCanvas.restore();
    if (this.bM == null)
    {
      this.bM = Bitmap.createBitmap(40, 40, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(this.bM);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setColor(-1638439);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setMaskFilter(new BlurMaskFilter(10.0F, BlurMaskFilter.Blur.SOLID));
      ((Canvas)localObject).drawOval(new RectF(10.0F, 10.0F, 30.0F, 30.0F), localPaint);
    }
    Object localObject = new Matrix();
    int i = 0;
    while (i < 8)
    {
      ((Matrix)localObject).reset();
      int j = paramCanvas.save();
      paramCanvas.translate(this.aj[(i * 2)], this.aj[(i * 2 + 1)]);
      float f = this.ak[i];
      paramCanvas.scale(f, f);
      paramCanvas.drawBitmap(this.bM, -20.0F, -20.0F, null);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt2 = paramInt4 - paramInt2;
      paramInt1 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      float f3 = paramInt1 / 832.0F;
      float f1 = (paramInt2 - paramInt3 - paramInt4) / 444.0F;
      float f2;
      if (f1 >= f3) {
        f2 = getPaddingLeft() + paramInt1 / 2.0F;
      }
      float f4;
      for (f1 = (paramInt2 - f3 * 444.0F) / 2.0F + 96.770576F * f3;; f1 = f4)
      {
        this.mDrawMatrix.reset();
        this.mCamera.save();
        this.mCamera.rotateX(72.199997F);
        this.mCamera.getMatrix(this.mDrawMatrix);
        this.mCamera.restore();
        this.mDrawMatrix.postScale(f3, f3);
        this.mDrawMatrix.postTranslate(f2, f1);
        paramInt1 = 0;
        while (paramInt1 < 8)
        {
          double d1 = d[paramInt1];
          this.aj[(paramInt1 * 2)] = ((float)(Math.sin(d1) * 300.0D));
          this.aj[(paramInt1 * 2 + 1)] = ((float)(Math.cos(d1) * 300.0D));
          this.ak[paramInt1] = (al[paramInt1] * f3);
          paramInt1 += 1;
        }
        f2 = getPaddingLeft() + paramInt1 / 2.0F;
        f4 = getPaddingTop() + 96.770576F * f1;
        f3 = f1;
      }
      this.mDrawMatrix.mapPoints(this.aj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectBg
 * JD-Core Version:    0.7.0.1
 */