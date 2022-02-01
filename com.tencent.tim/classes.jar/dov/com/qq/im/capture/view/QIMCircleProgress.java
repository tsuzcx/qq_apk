package dov.com.qq.im.capture.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import aqnm;
import axxf;
import axxg;
import axxh;
import axxi;
import java.util.ArrayList;
import java.util.List;

public class QIMCircleProgress
  extends ImageView
{
  public static int bCb = 10000;
  protected float Fm = 1.0F;
  public float Fn = 0.0F;
  float Fo = 5.0F;
  protected float Fp;
  private List<Float> Nr = new ArrayList();
  ValueAnimator aV;
  public ValueAnimator aW;
  Paint aX;
  int bjX;
  protected Paint dc;
  protected Paint dd;
  public boolean dwZ = false;
  public boolean dxa = false;
  public boolean dxb = false;
  protected int eIA;
  int eIy;
  protected int eIz;
  int efi;
  int mBgColor;
  float mDensity;
  protected int mHeight;
  protected int mMode = 0;
  protected Paint mPaint;
  float mProgress;
  int mProgressColor;
  int mStrokeWidth = 10;
  protected int mWidth;
  RectF oval = new RectF();
  
  public QIMCircleProgress(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QIMCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public void aea(int paramInt)
  {
    this.mMode = paramInt;
    if (this.mMode == 1) {
      cancelAnimation();
    }
    invalidate();
  }
  
  public float ak()
  {
    return this.mProgress;
  }
  
  protected void bZ(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.eIA / 2, this.dc);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.eIz / 2, this.dd);
  }
  
  public void bx(float paramFloat)
  {
    if (paramFloat == this.mProgress)
    {
      this.dxb = true;
      if (this.aV != null) {
        this.aV.start();
      }
    }
  }
  
  public void cancelAnimation()
  {
    if ((this.aV != null) && (this.aV.isRunning()))
    {
      this.dxb = false;
      this.aV.cancel();
    }
    if ((this.aW != null) && (this.aW.isRunning())) {
      this.aW.cancel();
    }
  }
  
  public void ePf()
  {
    if (this.aV == null)
    {
      this.aV = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aV.setDuration(150L);
      this.aV.setRepeatCount(3);
      this.aV.setRepeatMode(2);
      this.aV.addUpdateListener(new axxf(this));
      this.aV.addListener(new axxg(this));
    }
    if (this.aW == null)
    {
      this.aW = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aW.setDuration(400L);
      this.aW.setRepeatCount(-1);
      this.aW.setRepeatMode(2);
      this.aW.addUpdateListener(new axxh(this));
      this.aW.addListener(new axxi(this));
    }
  }
  
  public void ePg()
  {
    if ((this.aV != null) && (this.aV.isRunning()))
    {
      this.dxb = false;
      this.aV.cancel();
    }
    if ((this.aW != null) && (!this.aW.isRunning())) {
      this.aW.start();
    }
  }
  
  public int getMode()
  {
    return this.mMode;
  }
  
  public List<Float> hW()
  {
    return this.Nr;
  }
  
  protected void init()
  {
    setLayerType(1, null);
    this.mDensity = getResources().getDisplayMetrics().density;
    this.mBgColor = getResources().getColor(2131165822);
    this.mProgressColor = getResources().getColor(2131166534);
    this.bjX = 51;
    this.efi = 100;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(this.mProgressColor);
    this.aX = new Paint();
    this.aX.setAntiAlias(true);
    this.aX.setStyle(Paint.Style.STROKE);
    this.aX.setColor(getResources().getColor(2131167654));
    this.dd = new Paint();
    this.dd.setAntiAlias(true);
    this.dd.setStyle(Paint.Style.FILL);
    this.dd.setColor(this.mProgressColor);
    this.eIy = -1;
    this.dc = new Paint();
    this.dc.setAntiAlias(true);
    this.dc.setStyle(Paint.Style.FILL);
    this.dc.setColor(this.eIy);
  }
  
  public void notifyChange()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    if (this.mWidth <= 0) {}
    for (;;)
    {
      return;
      this.oval.set(this.mStrokeWidth * 1.38F + this.Fp, this.mStrokeWidth * 1.38F + this.Fp, this.mWidth - this.mStrokeWidth * 1.38F - this.Fp, this.mHeight - this.mStrokeWidth * 1.38F - this.Fp);
      float f1 = bCb;
      int i = 0;
      f1 *= -0.005555556F;
      if (i < this.Nr.size())
      {
        f2 = ((Float)this.Nr.get(i)).floatValue();
        float f3 = -90.0F + 360.0F * f1 / bCb + 2.0F;
        f1 = 360.0F * (f2 - f1) / bCb - 4.0F;
        if (f1 > 0.0F)
        {
          if ((!this.dwZ) || (i != this.Nr.size() - 1)) {
            break label372;
          }
          this.mPaint.setStrokeWidth((int)(this.mStrokeWidth * (1.0D - 0.38D * this.Fn)));
          this.aX.setStrokeWidth((int)(this.mStrokeWidth * (1.0D - 0.38D * this.Fn)));
          this.aX.setAlpha((int)(255.0F * this.Fn));
          if (Build.VERSION.SDK_INT >= 21) {
            this.aX.setShadowLayer(this.Fo * this.Fn, 0.0F, 0.0F, getResources().getColor(2131167654));
          }
          paramCanvas.drawArc(this.oval, f3, f1, false, this.mPaint);
          paramCanvas.drawArc(this.oval, f3, f1, false, this.aX);
          this.mPaint.setStrokeWidth(this.mStrokeWidth);
        }
        for (;;)
        {
          i += 1;
          f1 = f2;
          break;
          label372:
          paramCanvas.drawArc(this.oval, f3, f1, false, this.mPaint);
        }
      }
      float f2 = 360.0F * (this.mProgress - f1) / bCb - 4.0F;
      if (f2 > 0.0F) {
        paramCanvas.drawArc(this.oval, 2.0F + (-90.0F + 360.0F * f1 / bCb), f2, false, this.mPaint);
      }
      while (this.mMode != 2)
      {
        bZ(paramCanvas);
        return;
        if (this.dxa)
        {
          this.mPaint.setAlpha((int)(255.0F * this.Fn));
          paramCanvas.drawArc(this.oval, 2.0F + (-90.0F + 360.0F * f1 / bCb), 5.0F, false, this.mPaint);
          this.mPaint.setAlpha(255);
        }
      }
    }
  }
  
  public void setCenterCircleColor(int paramInt)
  {
    this.eIy = paramInt;
    this.dc.setColor(this.eIy);
    invalidate();
  }
  
  public void setCenterScaleValue(float paramFloat)
  {
    this.Fm = paramFloat;
    invalidate();
  }
  
  public void setCenterView()
  {
    this.eIz = aqnm.dip2px(24.0F);
    this.eIA = aqnm.dip2px(54.0F);
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat > bCb) {}
    for (float f = bCb;; f = paramFloat)
    {
      this.mProgress = f;
      f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      this.mProgress = f;
      invalidate();
      return;
    }
  }
  
  public void setProgressColor(int paramInt)
  {
    this.mProgressColor = paramInt;
    this.mPaint.setColor(this.mProgressColor);
    this.dd.setColor(this.mProgressColor);
    invalidate();
  }
  
  public void setProgressOffset(float paramFloat)
  {
    this.Fp = paramFloat;
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = ((int)(this.mDensity * paramFloat + 0.5D));
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
    this.aX.setStrokeWidth(this.mStrokeWidth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMCircleProgress
 * JD-Core Version:    0.7.0.1
 */