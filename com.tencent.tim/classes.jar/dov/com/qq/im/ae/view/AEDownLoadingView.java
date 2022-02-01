package dov.com.qq.im.ae.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class AEDownLoadingView
  extends View
{
  private static float scale;
  protected Path N;
  protected RectF aP;
  protected RectF aQ = new RectF(this.centerX - 16843176, this.centerY - 16843176, this.centerX + 16843176, this.centerY + 16843176);
  protected float aU = a(2.5F, getContext());
  protected long afV = 100L;
  protected Paint cI;
  protected int centerX;
  protected int centerY;
  protected Paint ci;
  boolean duZ = false;
  boolean dva = true;
  private int mHeight;
  protected long mProgress;
  protected float mRadius = a(17.5F, getContext());
  private int mWidth;
  protected float zc = a(2.0F, getContext());
  
  public AEDownLoadingView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public AEDownLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AEDownLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private static int a(float paramFloat, Context paramContext)
  {
    if (scale == 0.0F) {
      scale = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(scale * paramFloat);
  }
  
  public void Yq(boolean paramBoolean)
  {
    this.duZ = paramBoolean;
  }
  
  protected void init()
  {
    this.ci = new Paint(1);
    this.ci.setStyle(Paint.Style.FILL);
    this.ci.setColor(2130706432);
    this.cI = new Paint(1);
    this.cI.setStyle(Paint.Style.FILL);
    this.cI.setColor(0);
    this.cI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.N = new Path();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.duZ) {
      paramCanvas.drawRoundRect(this.aP, this.zc, this.zc, this.ci);
    }
    do
    {
      return;
      paramCanvas.drawRoundRect(this.aP, this.zc, this.zc, this.ci);
    } while ((this.mProgress == 0L) || (this.mProgress == this.afV));
    float f = (float)this.mProgress * 360.0F / (float)this.afV;
    if (this.dva)
    {
      paramCanvas.drawCircle(this.centerX, this.centerY, this.mRadius, this.cI);
      paramCanvas.drawCircle(this.centerX, this.centerY, this.mRadius - this.aU, this.ci);
      this.N.reset();
      this.N.moveTo(this.centerX, this.centerY);
      this.N.arcTo(this.aQ, 270.0F, f);
      paramCanvas.drawPath(this.N, this.cI);
      return;
    }
    paramCanvas.drawArc(this.aQ, 270.0F, f, false, this.cI);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.centerX = (this.mWidth / 2);
    this.centerY = (this.mHeight / 2);
    this.aP = new RectF(0.0F, 0.0F, this.mWidth, this.mHeight);
    float f = this.mRadius - this.aU;
    this.aQ = new RectF(this.centerX - f, this.centerY - f, this.centerX + f, f + this.centerY);
  }
  
  public void setBgColor(int paramInt)
  {
    this.ci.setColor(paramInt);
  }
  
  public void setBgCorner(float paramFloat)
  {
    this.zc = paramFloat;
  }
  
  public void setMax(int paramInt)
  {
    this.afV = paramInt;
  }
  
  public void setProgress(long paramLong)
  {
    this.mProgress = paramLong;
    if (this.mProgress == this.afV) {
      setVisibility(4);
    }
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.cI.setColor(paramInt);
  }
  
  public void setProgressSizeAndMode(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.mRadius = paramFloat1;
    this.aU = paramFloat2;
    paramFloat1 = this.mRadius - this.aU;
    this.aQ = new RectF(this.centerX - paramFloat1, this.centerY - paramFloat1, this.centerX + paramFloat1, paramFloat1 + this.centerY);
    this.dva = paramBoolean;
    if (this.dva)
    {
      this.cI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.cI.setStyle(Paint.Style.FILL);
      return;
    }
    this.cI.setStrokeWidth(paramFloat2);
    this.cI.setXfermode(null);
    this.cI.setStyle(Paint.Style.STROKE);
    this.cI.setStrokeCap(Paint.Cap.ROUND);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.AEDownLoadingView
 * JD-Core Version:    0.7.0.1
 */