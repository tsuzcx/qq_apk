package com.tencent.mobileqq.portal;

import akzw;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class ImageSwitchAnimView
  extends View
{
  private akzw a = new akzw(getContext(), 0, 0, 0, 0, 0, 0, 0, 0);
  
  public ImageSwitchAnimView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageSwitchAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void aa(Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.aa(paramBitmap);
    }
    if (this.a != null) {
      this.a.startAnim();
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool = false;
    super.onDraw(paramCanvas);
    int j;
    int k;
    if ((this.a != null) && (this.a.getWidth() == 0))
    {
      j = getWidth();
      k = getHeight();
      if (j >= k) {
        break label109;
      }
    }
    label109:
    for (int i = (int)(j / 1.35F);; i = (int)(k / 1.35F))
    {
      int m = (j - i) / 2;
      int n = (k - i) / 2;
      this.a.b(j, k, 0, 0, m, n, i, i);
      if (this.a != null) {
        bool = this.a.draw(paramCanvas);
      }
      if (bool) {
        invalidate();
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i;
    if ((getWidth() > 0) && (this.a != null))
    {
      paramInt2 = getWidth();
      i = getHeight();
      if (paramInt2 >= i) {
        break label74;
      }
    }
    label74:
    for (paramInt1 = (int)(paramInt2 / 1.35F);; paramInt1 = (int)(i / 1.35F))
    {
      int j = (paramInt2 - paramInt1) / 2;
      int k = (i - paramInt1) / 2;
      this.a.b(paramInt2, i, 0, 0, j, k, paramInt1, paramInt1);
      return;
    }
  }
  
  public void setLogo(Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.setLogo(paramBitmap);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ImageSwitchAnimView
 * JD-Core Version:    0.7.0.1
 */