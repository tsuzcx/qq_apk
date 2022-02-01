package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.tencent.image.URLImageView;

public class EmoticonImageView
  extends URLImageView
{
  private static Rect bT;
  private static Rect bU;
  private static boolean bYP;
  private static Bitmap fg;
  private boolean bYO;
  private Paint mPaint;
  
  public EmoticonImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmoticonImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void HS(boolean paramBoolean)
  {
    bYP = paramBoolean;
  }
  
  public static boolean ajv()
  {
    return bYP;
  }
  
  public boolean aju()
  {
    return this.bYO;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((bYP) || (!this.bYO)) {}
    for (;;)
    {
      return;
      if (fg == null) {}
      try
      {
        fg = BitmapFactory.decodeResource(super.getResources(), 2130838565);
        label37:
        if (fg == null) {
          continue;
        }
        if (bT == null)
        {
          int i = fg.getWidth();
          int j = fg.getHeight();
          int m = super.getWidth();
          int k = super.getHeight();
          bT = new Rect(0, 0, i, j);
          m = (m - i) / 2;
          k = (int)(k - super.getResources().getDisplayMetrics().density * 13.0F);
          bU = new Rect(m, k, i + m, j + k);
        }
        if (this.mPaint == null) {
          this.mPaint = new Paint();
        }
        paramCanvas.drawBitmap(fg, bT, bU, this.mPaint);
        return;
      }
      catch (Exception localException)
      {
        break label37;
      }
    }
  }
  
  public void setNewIconVisible(boolean paramBoolean)
  {
    this.bYO = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonImageView
 * JD-Core Version:    0.7.0.1
 */