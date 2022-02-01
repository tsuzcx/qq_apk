package com.tencent.mobileqq.microapp.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class RoundImageView
  extends ImageView
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private final RectF c;
  private final RectF d;
  private final Matrix e;
  private final Paint f;
  private final Paint g;
  private int h;
  private int i;
  private Bitmap j;
  private BitmapShader k;
  private int l;
  private int m;
  private float n;
  private float o;
  private boolean p;
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(1, 1, b);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), b))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  private void a()
  {
    if (!this.p) {}
    while (this.j == null) {
      return;
    }
    this.k = new BitmapShader(this.j, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.f.setAntiAlias(true);
    this.f.setShader(this.k);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setColor(this.h);
    this.g.setStrokeWidth(this.i);
    this.m = this.j.getHeight();
    this.l = this.j.getWidth();
    this.d.set(0.0F, 0.0F, getWidth(), getHeight());
    this.o = Math.min((this.d.height() - this.i) / 2.0F, (this.d.width() - this.i) / 2.0F);
    this.c.set(this.i, this.i, this.d.width() - this.i, this.d.height() - this.i);
    this.n = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
    b();
    invalidate();
  }
  
  private void b()
  {
    float f2 = 0.0F;
    this.e.set(null);
    float f1;
    float f3;
    if (this.l * this.c.height() > this.c.width() * this.m)
    {
      f1 = this.c.height() / this.m;
      f3 = (this.c.width() - this.l * f1) * 0.5F;
    }
    for (;;)
    {
      this.e.setScale(f1, f1);
      this.e.postTranslate((int)(f3 + 0.5F) + this.i, (int)(f2 + 0.5F) + this.i);
      this.k.setLocalMatrix(this.e);
      return;
      f1 = this.c.width() / this.l;
      f2 = this.c.height();
      float f4 = this.m;
      f3 = 0.0F;
      f2 = (f2 - f4 * f1) * 0.5F;
    }
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.n, this.f);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.o, this.g);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.j = paramBitmap;
    a();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.j = a(paramDrawable);
    a();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.j = a(getDrawable());
    a();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != a) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ui.RoundImageView
 * JD-Core Version:    0.7.0.1
 */