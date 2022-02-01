package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

public class VolumeIndicateView
  extends ImageView
{
  private int bQR;
  private Rect bf = new Rect();
  private Bitmap dV;
  private int mLevel;
  
  public VolumeIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = 0;
    int k;
    int j;
    int i;
    if (this.dV != null)
    {
      k = getWidth();
      j = getHeight();
      if (this.bQR != 3) {
        break label79;
      }
      i = k - this.mLevel * k / 10000 - 1;
    }
    for (;;)
    {
      this.bf.set(i, m, k, j);
      paramCanvas.drawBitmap(this.dV, null, this.bf, null);
      super.onDraw(paramCanvas);
      return;
      label79:
      if (this.bQR == 4)
      {
        k = k * this.mLevel / 10000 + 1;
        i = 0;
      }
      else if (this.bQR == 1)
      {
        m = this.mLevel * j / 10000;
        i = 0;
        m = j - m - 1;
      }
      else if (this.bQR == 2)
      {
        j = j * this.mLevel / 10000 + 1;
        i = 0;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void setIndicateVolumeBitmap(Bitmap paramBitmap, int paramInt)
  {
    this.dV = paramBitmap;
    this.bQR = paramInt;
  }
  
  public void setLevel(int paramInt)
  {
    this.mLevel = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateView
 * JD-Core Version:    0.7.0.1
 */