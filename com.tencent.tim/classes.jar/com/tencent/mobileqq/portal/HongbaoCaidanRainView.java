package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HongbaoCaidanRainView
  extends View
{
  private long HN;
  private long Jo;
  private int bWA = 1000;
  private int bWB;
  private float jV = 1.0F;
  private float jW = 10.0F;
  private boolean mIsAnimating;
  private boolean mIsPause;
  private long mLastUpdateTime;
  private Matrix mMatrix = new Matrix();
  private int mMaxY;
  private Random mRandom = new Random(System.currentTimeMillis());
  private float qA;
  private float qy;
  private float qz;
  private List<Bitmap> rU = new ArrayList(5);
  private List<a> sh = new ArrayList();
  private List<a> si = new ArrayList();
  
  public HongbaoCaidanRainView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongbaoCaidanRainView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HongbaoCaidanRainView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Dp(int paramInt)
  {
    if (this.rU.size() == 0) {
      return;
    }
    int i = 0;
    label16:
    a locala;
    float f1;
    float f2;
    if (i < paramInt)
    {
      locala = new a(null);
      locala.x = this.mRandom.nextInt(this.bWA);
      locala.rotate = this.mRandom.nextInt(360);
      f1 = this.mRandom.nextFloat();
      f2 = this.qz;
      if (this.mRandom.nextFloat() <= 0.5D) {
        break label285;
      }
      j = 1;
      label95:
      locala.qD = (j * (f2 * f1));
      locala.bitmap = ((Bitmap)this.rU.get(this.mRandom.nextInt(this.rU.size())));
      locala.scale = (this.bWB * 1.0F / locala.bitmap.getWidth() * (this.mRandom.nextFloat() * this.qy + 1.0F));
      locala.qC = (this.mRandom.nextFloat() * this.qA + this.jW);
      f1 = this.mRandom.nextFloat();
      f2 = this.jV;
      if (this.mRandom.nextFloat() <= 0.5D) {
        break label291;
      }
    }
    label285:
    label291:
    for (int j = 1;; j = -1)
    {
      locala.qB = (j * (f2 * f1));
      locala.y = ((int)(-locala.bitmap.getHeight() * locala.scale));
      this.sh.add(locala);
      i += 1;
      break label16;
      break;
      j = -1;
      break label95;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    if ((this.mIsPause) || (!this.mIsAnimating)) {
      return;
    }
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    if ((l - this.HN < 1300L) && (l - this.Jo > 40L))
    {
      Dp(1);
      this.Jo = l;
    }
    float f = (float)((l - this.mLastUpdateTime) * 1.0D / 1000.0D);
    this.mLastUpdateTime = l;
    int k = this.sh.size();
    int i = 0;
    a locala;
    if (i < k)
    {
      locala = (a)this.sh.get(i);
      locala.y = ((int)(locala.y + locala.qC * f));
      if (locala.y > this.mMaxY) {
        this.si.add(locala);
      }
      for (;;)
      {
        i += 1;
        break;
        locala.x = ((int)(locala.x + locala.qB * f));
        locala.rotate += locala.qD * f;
      }
    }
    this.sh.removeAll(this.si);
    this.si.clear();
    k = this.sh.size();
    i = j;
    if (k == 0)
    {
      this.mIsAnimating = false;
      return;
    }
    while (i < k)
    {
      locala = (a)this.sh.get(i);
      this.mMatrix.reset();
      this.mMatrix.setTranslate(-locala.bitmap.getWidth() / 2, -locala.bitmap.getHeight() / 2);
      this.mMatrix.postRotate(locala.rotate);
      this.mMatrix.preScale(locala.scale, locala.scale);
      this.mMatrix.postTranslate(locala.x, locala.y);
      paramCanvas.drawBitmap(locala.bitmap, this.mMatrix, null);
      i += 1;
    }
    invalidate();
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.mIsPause = paramBoolean;
    if (this.mIsPause) {
      this.sh.clear();
    }
  }
  
  static class a
  {
    Bitmap bitmap;
    float qB = 0.0F;
    float qC = 0.0F;
    float qD = 0.0F;
    float rotate = 0.0F;
    float scale;
    int x = 0;
    int y = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView
 * JD-Core Version:    0.7.0.1
 */