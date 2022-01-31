package com.tencent.token.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImageView
  extends ImageView
{
  Path a = new Path();
  private int b;
  private int c;
  private int d;
  private Paint e = new Paint();
  private Bitmap f;
  private Bitmap g;
  private RectF h;
  private int i;
  private PorterDuffXfermode j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
  
  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {}
    label241:
    for (;;)
    {
      return;
      if ((localDrawable instanceof BitmapDrawable)) {}
      for (Bitmap localBitmap1 = ((BitmapDrawable)localDrawable).getBitmap();; localBitmap1 = null)
      {
        if (localDrawable.getCurrent() == null) {
          break label241;
        }
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap2 = localBitmap1;
          if ((localDrawable.getCurrent() instanceof BitmapDrawable)) {
            localBitmap2 = ((BitmapDrawable)localDrawable.getCurrent()).getBitmap();
          }
        }
        if ((localBitmap2 != null) && ((this.f == null) || (this.g == null) || (this.f != localBitmap2)))
        {
          this.f = localBitmap2;
          if ((this.c > 0) && (this.d > 0)) {
            this.g = Bitmap.createScaledBitmap(localBitmap2, this.c, this.d, true);
          }
        }
        if (this.g == null) {
          break;
        }
        paramCanvas.saveLayerAlpha(this.h, 255, 31);
        this.e.reset();
        this.e.setAntiAlias(true);
        paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        paramCanvas.drawCircle(this.i, this.i, this.i, this.e);
        this.e.setXfermode(this.j);
        paramCanvas.drawBitmap(this.g, 0.0F, 0.0F, this.e);
        this.e.setXfermode(null);
        return;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.reset();
    float f1 = getMeasuredWidth() * 0.5F;
    this.a.addCircle(f1, f1, f1 - this.b, Path.Direction.CW);
    this.c = getMeasuredWidth();
    this.d = getMeasuredHeight();
    this.h = new RectF(0.0F, 0.0F, this.c, this.d);
    this.i = (this.c / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.RoundImageView
 * JD-Core Version:    0.7.0.1
 */