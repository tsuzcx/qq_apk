package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import com.tencent.token.cb;
import com.tencent.token.ui.IndexActivity;

public class a
  extends Drawable
{
  public boolean a = true;
  private Paint b;
  private float c;
  private float d;
  
  public a(Context paramContext)
  {
    float f1 = IndexActivity.S_RES_WIDTH - paramContext.getResources().getDimension(2131296303);
    float f2 = paramContext.getResources().getDimension(2131296302);
    if (f1 > f2) {
      f1 = f2;
    }
    for (;;)
    {
      this.c = f1;
      this.d = (3.5F * IndexActivity.S_DENSITY);
      this.b = new Paint();
      this.b.setStyle(Paint.Style.FILL);
      this.b.setColor(-1);
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis() + cb.c().q();
    int i = (int)(l / 1000L);
    paramCanvas.drawRect(((int)(l % 1000L) + i % 30 * 1000) * this.c / 30000.0F, 0.0F, 3.0F + this.c, this.d, this.b);
    if (this.a) {
      invalidateSelf();
    }
  }
  
  public int getOpacity()
  {
    return -1;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.a
 * JD-Core Version:    0.7.0.1
 */