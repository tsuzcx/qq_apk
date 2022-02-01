package com.tencent.captchasdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.webkit.WebView;

class b
  extends WebView
{
  private Paint a;
  private Paint b;
  private float c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public b(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new Paint();
    this.a.setColor(-1);
    this.a.setAntiAlias(true);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.b = new Paint();
    this.b.setXfermode(null);
  }
  
  private void a(Canvas paramCanvas)
  {
    Path localPath = new Path();
    localPath.moveTo(this.f, this.c);
    localPath.lineTo(this.f, this.g);
    localPath.lineTo(this.c, this.g);
    localPath.arcTo(new RectF(this.f, this.g, this.f + this.c * 2.0F, this.g + this.c * 2.0F), -90.0F, -90.0F);
    localPath.close();
    paramCanvas.drawPath(localPath, this.a);
  }
  
  private void b(Canvas paramCanvas)
  {
    Path localPath = new Path();
    localPath.moveTo(this.f, this.g + this.e - this.c);
    localPath.lineTo(this.f, this.g + this.e);
    localPath.lineTo(this.f + this.c, this.g + this.e);
    localPath.arcTo(new RectF(this.f, this.g + this.e - this.c * 2.0F, this.f + this.c * 2.0F, this.g + this.e), 90.0F, 90.0F);
    localPath.close();
    paramCanvas.drawPath(localPath, this.a);
  }
  
  private void c(Canvas paramCanvas)
  {
    Path localPath = new Path();
    localPath.moveTo(this.f + this.d - this.c, this.g + this.e);
    localPath.lineTo(this.f + this.d, this.g + this.e);
    localPath.lineTo(this.f + this.d, this.g + this.e - this.c);
    localPath.arcTo(new RectF(this.f + this.d - this.c * 2.0F, this.g + this.e - this.c * 2.0F, this.f + this.d, this.g + this.e), 0.0F, 90.0F);
    localPath.close();
    paramCanvas.drawPath(localPath, this.a);
  }
  
  private void d(Canvas paramCanvas)
  {
    Path localPath = new Path();
    localPath.moveTo(this.f + this.d, this.g + this.c);
    localPath.lineTo(this.f + this.d, this.g);
    localPath.lineTo(this.f + this.d - this.c, this.g);
    localPath.arcTo(new RectF(this.f + this.d - this.c * 2.0F, this.g, this.f + this.d, this.g + this.c * 2.0F), -90.0F, 90.0F);
    localPath.close();
    paramCanvas.drawPath(localPath, this.a);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.c = paramFloat;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.f = getScrollX();
    this.g = getScrollY();
    Bitmap localBitmap = Bitmap.createBitmap(this.f + this.d, this.g + this.e, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    super.draw(localCanvas);
    a(localCanvas);
    d(localCanvas);
    b(localCanvas);
    c(localCanvas);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.b);
    localBitmap.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.b
 * JD-Core Version:    0.7.0.1
 */