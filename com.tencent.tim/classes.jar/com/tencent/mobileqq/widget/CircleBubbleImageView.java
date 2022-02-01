package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;

public class CircleBubbleImageView
  extends ChatThumbView
{
  protected Path R;
  protected Path S;
  protected int cQI;
  protected int cQJ;
  public boolean cZB = true;
  protected boolean cZC;
  protected boolean cZx;
  protected Paint cs;
  protected BitmapShader e;
  protected int eeY = 1610612736;
  protected Bitmap gF;
  public boolean mIsSend;
  protected Bitmap mMaskBitmap;
  protected Paint mMaskPaint;
  protected Resources mRes;
  protected Canvas p;
  protected Canvas q;
  
  public CircleBubbleImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void bn(Canvas paramCanvas)
  {
    Resources localResources = this.mRes;
    int i = this.cQI;
    int j = this.cQJ;
    j = this.cQI / 2;
    Path localPath;
    float f1;
    float f2;
    if (this.mIsSend) {
      if (this.R != null)
      {
        localPath = this.R;
        localPath.reset();
        localPath.moveTo(i - dp2px(23.0F, localResources), dp2px(26.0F, localResources));
        f1 = i - dp2px(9.0F, localResources);
        f2 = dp2px(23.0F, localResources);
        localPath.quadTo(i - dp2px(13.0F, localResources), dp2px(28.0F, localResources), f1, f2);
        f1 = i - dp2px(19.0F, localResources);
        f2 = dp2px(34.0F, localResources);
        localPath.quadTo(i - dp2px(10.0F, localResources), dp2px(32.0F, localResources), f1, f2);
        localPath.close();
        this.R = localPath;
      }
    }
    do
    {
      while (this.mIsSend)
      {
        paramCanvas.drawCircle(j, j, j, this.mMaskPaint);
        if ((this.cZB) && (this.R != null)) {
          paramCanvas.drawPath(this.R, this.mMaskPaint);
        }
        return;
        if (this.S != null)
        {
          localPath = this.S;
          localPath.reset();
          localPath.moveTo(dp2px(23.0F, localResources), dp2px(26.0F, localResources));
          f1 = dp2px(9.0F, localResources);
          f2 = dp2px(23.0F, localResources);
          localPath.quadTo(dp2px(13.0F, localResources), dp2px(28.0F, localResources), f1, f2);
          f1 = dp2px(19.0F, localResources);
          f2 = dp2px(34.0F, localResources);
          localPath.quadTo(dp2px(10.0F, localResources), dp2px(32.0F, localResources), f1, f2);
          localPath.close();
          this.S = localPath;
        }
      }
      paramCanvas.drawCircle(j, j, j, this.mMaskPaint);
    } while (!this.cZB);
    paramCanvas.drawPath(this.S, this.mMaskPaint);
  }
  
  private void init()
  {
    this.mRes = getResources();
    this.mMaskPaint = new Paint();
    this.mMaskPaint.setAntiAlias(true);
    this.mMaskPaint.setFilterBitmap(true);
    this.mMaskPaint.setStyle(Paint.Style.FILL);
    this.R = new Path();
    this.S = new Path();
  }
  
  public void TG(boolean paramBoolean)
  {
    this.cZC = paramBoolean;
  }
  
  public int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.cQI = getWidth();
    this.cQJ = getHeight();
    if ((this.cQI <= 0) || (this.cQJ <= 0))
    {
      super.draw(paramCanvas);
      return;
    }
    if (this.mMaskBitmap == null) {}
    try
    {
      this.mMaskBitmap = Bitmap.createBitmap(this.cQI, this.cQJ, Bitmap.Config.ARGB_8888);
      if (this.p != null) {
        this.p.setBitmap(this.mMaskBitmap);
      }
      if (this.mMaskBitmap == null)
      {
        super.draw(paramCanvas);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        try
        {
          this.mMaskBitmap = Bitmap.createBitmap(this.cQI, this.cQJ, Bitmap.Config.ARGB_4444);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          URLDrawable.clearMemoryCache();
          try
          {
            this.mMaskBitmap = Bitmap.createBitmap(this.cQI, this.cQJ, Bitmap.Config.ARGB_4444);
          }
          catch (OutOfMemoryError localOutOfMemoryError3) {}
        }
      }
      if (this.p == null)
      {
        this.p = new Canvas(this.mMaskBitmap);
        this.p.setBitmap(this.mMaskBitmap);
      }
      if (this.e == null)
      {
        this.e = new BitmapShader(this.mMaskBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.mMaskPaint.setShader(this.e);
      }
      this.mMaskBitmap.eraseColor(16711680);
      super.draw(this.p);
      if (this.cZx) {
        this.p.drawColor(this.eeY);
      }
      if (!this.cZC) {
        break label301;
      }
    }
    if (this.gF == null) {}
    try
    {
      this.gF = Bitmap.createBitmap(this.cQI, this.cQJ, Bitmap.Config.ARGB_8888);
      label283:
      if (this.q != null) {
        this.q.setBitmap(this.gF);
      }
      label301:
      if ((this.cZC) && (this.gF != null))
      {
        if (this.q == null) {
          this.q = new Canvas(this.gF);
        }
        this.gF.eraseColor(0);
        bn(this.q);
        paramCanvas.drawBitmap(this.gF, 0.0F, 0.0F, this.cs);
        return;
      }
      bn(paramCanvas);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError4)
    {
      break label283;
    }
  }
  
  public void setColorMask(int paramInt)
  {
    this.eeY = paramInt;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    if (paramDrawable == getDrawable()) {
      super.setImageDrawable(null);
    }
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleBubbleImageView
 * JD-Core Version:    0.7.0.1
 */