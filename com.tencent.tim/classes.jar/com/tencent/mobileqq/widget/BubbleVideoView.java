package com.tencent.mobileqq.widget;

import aeif;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.util.VersionUtils;

public class BubbleVideoView
  extends BubbleImageView
{
  private static a a;
  private boolean cZz;
  private Bitmap gE;
  
  public BubbleVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BubbleVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bo(Canvas paramCanvas)
  {
    if (a != null) {
      a.a(this, paramCanvas);
    }
  }
  
  public static void setDrawListener(a parama)
  {
    a = parama;
  }
  
  public boolean aGq()
  {
    return this.cZz;
  }
  
  protected void bl(Canvas paramCanvas)
  {
    if (aGq())
    {
      if ((this.gE != null) && ((this.gE.getWidth() != getWidth()) || (this.gE.getHeight() != getHeight())))
      {
        this.gE.recycle();
        this.gE = null;
      }
      if (this.gE == null) {}
      try
      {
        this.gE = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        if (this.gE != null)
        {
          Canvas localCanvas = new Canvas(this.gE);
          localCanvas.setDensity(getResources().getDisplayMetrics().densityDpi);
          Paint localPaint = new Paint(1);
          localPaint.setColor(-16777216);
          localCanvas.drawPath(this.mPath, localPaint);
          if (this.gE.getPixel(this.gE.getWidth() >> 1, this.gE.getHeight() >> 1) != -16777216)
          {
            localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            localCanvas.drawRect(0.0F, 0.0F, this.gE.getWidth(), this.gE.getHeight(), localPaint);
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          }
        }
        if (this.gE != null) {
          paramCanvas.drawBitmap(this.gE, 0.0F, 0.0F, this.mPaint);
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          try
          {
            this.gE = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            try
            {
              this.gE = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
            }
            catch (OutOfMemoryError localOutOfMemoryError3) {}
          }
        }
      }
    }
    super.bl(paramCanvas);
  }
  
  protected void cei()
  {
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("M821")) || (str.contains("A0001"))) {
      this.mDrawMode = 2;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    bo(paramCanvas);
    super.draw(paramCanvas);
  }
  
  protected void init()
  {
    this.aAu = aAv;
    int i;
    if (VersionUtils.isHoneycomb())
    {
      this.mDrawMode = 1;
      cei();
      this.mRes = getResources();
      if (Build.VERSION.SDK_INT >= 28)
      {
        this.flag = true;
        Object localObject = (String)aeif.a().o(462);
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          localObject = ((String)localObject).split("\\|");
          if ((localObject != null) && (localObject.length > 0))
          {
            String str = Build.MODEL.toUpperCase();
            int j = localObject.length;
            i = 0;
            label96:
            if (i < j)
            {
              CharSequence localCharSequence = localObject[i];
              if ((localCharSequence == null) || (localCharSequence.length() <= 0) || (!str.contains(localCharSequence))) {
                break label252;
              }
              this.flag = false;
            }
          }
        }
      }
      if (this.mDrawMode != 1) {
        break label280;
      }
      this.mPaint = new Paint();
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setFilterBitmap(true);
      this.mPaint.setColor(-16777216);
      if (!this.flag) {
        break label259;
      }
      this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      this.mPath = new Path();
      this.mRect = new RectF();
      this.aC = new float[8];
    }
    label252:
    while (this.mDrawMode != 2) {
      for (;;)
      {
        return;
        this.mDrawMode = 2;
        break;
        i += 1;
        break label96;
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      }
    }
    label259:
    label280:
    this.mMaskPaint = new Paint();
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setFilterBitmap(true);
    this.aU = new RectF();
    this.aV = new RectF();
    this.mPath = new Path();
    this.mRect = new RectF();
    this.aC = new float[8];
  }
  
  public void setUseXfermodeBitmap(boolean paramBoolean)
  {
    this.cZz = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void a(BubbleVideoView paramBubbleVideoView, Canvas paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BubbleVideoView
 * JD-Core Version:    0.7.0.1
 */