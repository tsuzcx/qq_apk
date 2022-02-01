package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.DisplayMetrics;
import android.view.View;

public class TransCircleMaskView
  extends View
{
  private Paint cI;
  private int cQI;
  private int cQJ;
  private boolean dbN = true;
  private int eiE;
  private int eiF;
  private Bitmap gQ;
  private int mMaskColor;
  private Paint mPaint;
  private int mTopOffset = -1;
  private Canvas u;
  
  public TransCircleMaskView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public static int bv(Context paramContext)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * 11.0F + 0.5F);
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setColor(-16777216);
    this.mMaskColor = getResources().getColor(2131167415);
    this.cI = new Paint();
    this.cI.setStyle(Paint.Style.FILL);
    this.cI.setAntiAlias(true);
    this.cI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.cQI = getWidth();
    this.cQJ = getHeight();
    if (this.gQ == null) {
      return;
    }
    this.gQ.eraseColor(0);
    this.u.drawColor(this.mMaskColor);
    if (this.mTopOffset == -1) {}
    for (int i = bv(getContext());; i = this.mTopOffset)
    {
      this.u.drawCircle(this.cQI / 2, i + this.cQJ / 2, this.eiE, this.cI);
      paramCanvas.drawBitmap(this.gQ, 0.0F, 0.0F, this.mPaint);
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != paramInt3)) || (paramInt2 != paramInt4)) {}
    try
    {
      this.gQ = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      if (this.gQ != null) {
        this.u = new Canvas(this.gQ);
      }
      if (this.dbN)
      {
        this.eiE = ((int)(paramInt2 * 0.5F * 0.83F));
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.gQ = null;
        continue;
        this.eiE = ((int)(paramInt2 * 0.5F) - this.eiF);
      }
    }
  }
  
  public void setIsUseMaskRadiusRatios(boolean paramBoolean)
  {
    this.dbN = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    this.mMaskColor = paramInt;
    invalidate();
  }
  
  public void setMaskRadius(int paramInt)
  {
    this.eiE = paramInt;
    invalidate();
  }
  
  public void setUITopOffset(int paramInt)
  {
    this.mTopOffset = paramInt;
  }
  
  public void setmMaskRadiusBless(int paramInt)
  {
    this.eiF = paramInt;
    this.mMaskColor = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TransCircleMaskView
 * JD-Core Version:    0.7.0.1
 */