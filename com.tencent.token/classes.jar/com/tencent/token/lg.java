package com.tencent.token;

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

public final class lg
  extends WebView
{
  float a;
  int b;
  int c;
  private Paint d = new Paint();
  private Paint e;
  private int f;
  private int g;
  
  public lg(Context paramContext)
  {
    super(paramContext);
    this.d.setColor(-1);
    this.d.setAntiAlias(true);
    this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.e = new Paint();
    this.e.setXfermode(null);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    this.f = getScrollX();
    this.g = getScrollY();
    Bitmap localBitmap = Bitmap.createBitmap(this.f + this.b, this.g + this.c, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    super.draw(localCanvas);
    Path localPath = new Path();
    localPath.moveTo(this.f, this.a);
    localPath.lineTo(this.f, this.g);
    localPath.lineTo(this.a, this.g);
    int i = this.f;
    float f1 = i;
    int j = this.g;
    float f2 = j;
    float f3 = i;
    float f4 = this.a;
    localPath.arcTo(new RectF(f1, f2, f3 + f4 * 2.0F, j + f4 * 2.0F), -90.0F, -90.0F);
    localPath.close();
    localCanvas.drawPath(localPath, this.d);
    localPath = new Path();
    localPath.moveTo(this.f + this.b, this.g + this.a);
    localPath.lineTo(this.f + this.b, this.g);
    localPath.lineTo(this.f + this.b - this.a, this.g);
    i = this.f;
    j = this.b;
    f1 = i + j;
    f2 = this.a;
    int k = this.g;
    localPath.arcTo(new RectF(f1 - f2 * 2.0F, k, i + j, k + f2 * 2.0F), -90.0F, 90.0F);
    localPath.close();
    localCanvas.drawPath(localPath, this.d);
    localPath = new Path();
    localPath.moveTo(this.f, this.g + this.c - this.a);
    localPath.lineTo(this.f, this.g + this.c);
    localPath.lineTo(this.f + this.a, this.g + this.c);
    i = this.f;
    f1 = i;
    j = this.g;
    k = this.c;
    f2 = j + k;
    f3 = this.a;
    localPath.arcTo(new RectF(f1, f2 - f3 * 2.0F, i + f3 * 2.0F, j + k), 90.0F, 90.0F);
    localPath.close();
    localCanvas.drawPath(localPath, this.d);
    localPath = new Path();
    localPath.moveTo(this.f + this.b - this.a, this.g + this.c);
    localPath.lineTo(this.f + this.b, this.g + this.c);
    localPath.lineTo(this.f + this.b, this.g + this.c - this.a);
    i = this.f;
    j = this.b;
    f1 = i + j;
    f2 = this.a;
    k = this.g;
    int m = this.c;
    localPath.arcTo(new RectF(f1 - f2 * 2.0F, k + m - f2 * 2.0F, i + j, k + m), 0.0F, 90.0F);
    localPath.close();
    localCanvas.drawPath(localPath, this.d);
    paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, this.e);
    localBitmap.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lg
 * JD-Core Version:    0.7.0.1
 */