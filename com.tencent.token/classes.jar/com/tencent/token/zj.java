package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.token.ui.IndexActivity;

public final class zj
  extends Drawable
{
  public boolean a = true;
  public ImageView b;
  public ImageView c;
  private Paint d;
  private float e;
  private float f;
  
  public zj(Context paramContext)
  {
    int i = IndexActivity.S_RES_WIDTH;
    paramContext.getResources().getDimension(2131034279);
    this.e = paramContext.getResources().getDimension(2131034278);
    this.f = (IndexActivity.S_DENSITY * 3.5F);
    this.d = new Paint();
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(-1);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    long l = System.currentTimeMillis() + rt.a().g();
    float f1 = (int)(l / 1000L) % 30 * 1000 + (int)(l % 1000L);
    float f2 = this.e;
    paramCanvas.drawRect(f1 * f2 / 30000.0F, 0.0F, f2 + 3.0F, this.f, this.d);
    if (this.a) {
      invalidateSelf();
    }
  }
  
  public final int getOpacity()
  {
    return -1;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zj
 * JD-Core Version:    0.7.0.1
 */