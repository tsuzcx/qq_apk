package com.tencent.gdtad.api.motivevideo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

public class GdtMvButtonHighLight
  extends Button
{
  private ValueAnimator a;
  private boolean aPj;
  private int bBR;
  private Button cK;
  private Bitmap di;
  private Paint paint;
  
  public GdtMvButtonHighLight(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtMvButtonHighLight(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.di = BitmapFactory.decodeResource(getResources(), 2130840587);
    this.paint = getPaint();
  }
  
  public GdtMvButtonHighLight(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.a.cancel();
      this.aPj = false;
      invalidate();
    }
    clearAnimation();
    if ((this.cK != null) && (this.cK.getVisibility() != 4)) {
      this.cK.setVisibility(4);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.aPj) && (this.di != null)) {
      paramCanvas.drawBitmap(this.di, this.bBR, 0.0F, this.paint);
    }
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvButtonHighLight
 * JD-Core Version:    0.7.0.1
 */