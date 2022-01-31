package com.tencent.token.ui.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.token.ag;
import com.tencent.token.ui.IndexActivity;

public final class e
  extends Drawable
{
  public boolean a = true;
  private Paint b = new Paint();
  private float c = IndexActivity.S_RES_WIDTH - 176.0F * IndexActivity.S_DENSITY;
  private float d = 3.0F * IndexActivity.S_DENSITY;
  
  public e()
  {
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(-1);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis() + ag.c().p();
    int i = (int)(l / 1000L);
    paramCanvas.drawRect(((int)(l % 1000L) + i % 30 * 1000) * this.c / 30000.0F, 0.0F, 3.0F + this.c, this.d, this.b);
    if (this.a) {
      invalidateSelf();
    }
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.e
 * JD-Core Version:    0.7.0.1
 */