package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class RefreshEyeView
  extends ImageView
{
  private PaintFlagsDrawFilter a;
  private boolean atY;
  private int bbd;
  private double bc = 0.0D;
  private double bd = 0.0D;
  private Bitmap cj;
  private Bitmap[] h = new Bitmap[19];
  private Bitmap mBackgroundBitmap;
  private long mCurrentTime;
  private Paint mPaint = new Paint();
  private double mSpeed = 0.2000000029802322D;
  
  public RefreshEyeView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RefreshEyeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RefreshEyeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int a(Context paramContext, double paramDouble)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramDouble + 0.5D);
  }
  
  private Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return this.cj;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private Bitmap g(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.mPaint.reset();
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    double d1 = this.bd;
    int i = 0;
    while (i < paramInt1)
    {
      double d2 = (float)(15.0D * Math.sin(2.827433388230814D / paramInt1 * i + this.bc) + paramInt2 * ((1.0D - d1) * 2.5D - 0.2D));
      localCanvas.drawLine(i, paramInt2 * 4, i, (float)d2, this.mPaint);
      i += 1;
    }
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, this.mPaint);
    return localBitmap;
  }
  
  public void init()
  {
    this.mCurrentTime = System.currentTimeMillis();
    this.a = new PaintFlagsDrawFilter(0, 3);
    setWillNotDraw(false);
    this.mBackgroundBitmap = drawableToBitmap(getResources().getDrawable(2130850317));
    this.mPaint.setAntiAlias(true);
    this.h[0] = drawableToBitmap(getResources().getDrawable(2130850298));
    this.h[1] = drawableToBitmap(getResources().getDrawable(2130850299));
    this.h[2] = drawableToBitmap(getResources().getDrawable(2130850300));
    this.h[3] = drawableToBitmap(getResources().getDrawable(2130850301));
    this.h[4] = drawableToBitmap(getResources().getDrawable(2130850302));
    this.h[5] = drawableToBitmap(getResources().getDrawable(2130850303));
    this.h[6] = drawableToBitmap(getResources().getDrawable(2130850304));
    this.h[7] = drawableToBitmap(getResources().getDrawable(2130850305));
    this.h[8] = drawableToBitmap(getResources().getDrawable(2130850306));
    this.h[9] = drawableToBitmap(getResources().getDrawable(2130850307));
    this.h[10] = drawableToBitmap(getResources().getDrawable(2130850308));
    this.h[11] = drawableToBitmap(getResources().getDrawable(2130850309));
    this.h[12] = drawableToBitmap(getResources().getDrawable(2130850310));
    this.h[13] = drawableToBitmap(getResources().getDrawable(2130850311));
    this.h[14] = drawableToBitmap(getResources().getDrawable(2130850312));
    this.h[15] = drawableToBitmap(getResources().getDrawable(2130850313));
    this.h[16] = drawableToBitmap(getResources().getDrawable(2130850314));
    this.h[17] = drawableToBitmap(getResources().getDrawable(2130850315));
    this.h[18] = drawableToBitmap(getResources().getDrawable(2130850316));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawBitmap(this.mBackgroundBitmap, 0.0F, 0.0F, null);
    if (!this.atY)
    {
      paramCanvas.setDrawFilter(this.a);
      if (this.cj != null) {
        paramCanvas.drawBitmap(g(this.cj, this.cj.getWidth(), this.cj.getHeight()), 0.0F, 0.0F, null);
      }
      if (this.bc > 999999999.0D) {
        this.bc = 0.0D;
      }
      this.bc += this.mSpeed;
    }
    for (;;)
    {
      postDelayed(new RefreshEyeView.1(this), 10L);
      return;
      long l = System.currentTimeMillis();
      paramCanvas.drawBitmap(this.cj, 0.0F, 0.0F, null);
      if (l >= this.mCurrentTime + 55L)
      {
        this.bbd = ((this.bbd + 1) % 19);
        paramCanvas.drawBitmap(this.h[this.bbd], a(getContext(), 11.0D), a(getContext(), 8.0D), null);
        this.mCurrentTime = l;
      }
      else
      {
        paramCanvas.drawBitmap(this.h[this.bbd], a(getContext(), 11.0D), a(getContext(), 8.0D), null);
      }
    }
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    this.cj = drawableToBitmap(paramDrawable);
    super.setImageDrawable(paramDrawable);
  }
  
  public void setWaveHeightPercent(double paramDouble)
  {
    this.bd = paramDouble;
  }
  
  public void startLoading()
  {
    this.atY = true;
    this.bbd = 0;
  }
  
  public void stopLoading()
  {
    this.atY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshEyeView
 * JD-Core Version:    0.7.0.1
 */