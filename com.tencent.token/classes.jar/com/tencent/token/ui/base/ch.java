package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.token.global.e;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.t;
import java.util.ArrayList;

public final class ch
  extends Drawable
{
  private String[] a;
  private int[] b;
  private int[] c;
  private Bitmap d;
  private Bitmap e;
  private int f;
  private Paint g = new Paint();
  private Rect h;
  private float i;
  private final int j = 233;
  private final int k = 191;
  private ArrayList l;
  
  public ch(Context paramContext, String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfString == null) || (paramArrayOfInt1 == null) || (paramArrayOfInt2 == null) || (paramArrayOfInt1.length == 0) || (paramArrayOfInt1.length != paramArrayOfInt2.length) || (paramArrayOfString.length != paramArrayOfInt2.length)) {
      throw new RuntimeException();
    }
    this.a = new String[paramArrayOfString.length];
    this.b = new int[paramArrayOfString.length];
    this.c = new int[paramArrayOfString.length];
    this.l = new ArrayList();
    int m = 0;
    while (m < paramArrayOfString.length)
    {
      this.a[m] = paramArrayOfString[m];
      this.b[m] = paramArrayOfInt1[m];
      this.c[m] = paramArrayOfInt2[m];
      if ((paramArrayOfInt1[m] == 0) && (paramArrayOfInt2[m] == 0) && (this.l.size() < 3)) {
        this.l.add(paramArrayOfString[m]);
      }
      m += 1;
    }
    if (IndexActivity.S_DENSITY <= 1.6F) {}
    for (this.d = t.a(paramContext.getResources(), 2130837738, 0.9F, 0.9F);; this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2130837738))
    {
      this.i = (IndexActivity.S_DENSITY / 3.0F);
      this.e = BitmapFactory.decodeResource(paramContext.getResources(), 2130837739);
      this.f = paramContext.getResources().getColor(2131165295);
      return;
    }
  }
  
  private static String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString.length() > paramInt) {
      str = paramString.substring(0, paramInt) + "...";
    }
    return str;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int n = 0;
    this.g.setAntiAlias(true);
    int i1 = this.h.width() / 2 - this.d.getWidth() / 2;
    int i2 = this.h.height() / 2 - this.d.getHeight() / 2;
    paramCanvas.drawBitmap(this.d, i1, i2, this.g);
    int m = 0;
    float f1;
    float f2;
    float f3;
    float f4;
    while (m < this.b.length)
    {
      if ((this.b[m] != 0) || (this.c[m] != 0))
      {
        f1 = i1;
        f2 = this.b[m] / 233.0F;
        f3 = this.d.getWidth();
        f4 = i2;
        float f5 = this.c[m] / 191.0F;
        float f6 = this.d.getHeight();
        paramCanvas.drawBitmap(this.e, f1 + f2 * f3 - this.e.getWidth() / 2, f4 + f5 * f6 - this.e.getHeight() / 2, null);
      }
      m += 1;
    }
    if (this.l.size() > 0)
    {
      this.g.setColor(this.f);
      this.g.setStyle(Paint.Style.FILL);
      f2 = 170.0F * this.i;
      f1 = 184.0F * this.i;
      f3 = this.h.right - f2;
      f4 = this.h.height() - f1;
      paramCanvas.drawRect(f3, f4, this.h.right, this.h.bottom, this.g);
      this.g.setColor(-1);
      if (IndexActivity.S_DENSITY > 2.1F) {
        break label465;
      }
      this.g.setTextSize(30.0F * this.i);
      if (this.l.size() != 1) {
        break label482;
      }
      paramCanvas.drawBitmap(this.e, (f2 - this.e.getWidth()) / 2.0F + f3, (f1 - this.e.getHeight()) / 2.0F + f4 - 20.0F * this.i, this.g);
      this.g.setTextAlign(Paint.Align.CENTER);
      paramCanvas.drawText(a((String)this.l.get(0), 4), f3 + f2 / 2.0F, f4 + f1 / 2.0F - this.g.ascent() + this.g.descent(), this.g);
    }
    for (;;)
    {
      return;
      label465:
      this.g.setTextSize(35.0F * this.i);
      break;
      label482:
      f2 = this.g.descent() - this.g.ascent();
      this.g.setTextAlign(Paint.Align.LEFT);
      f3 += this.i * 10.0F;
      f1 = (f1 - this.l.size() * f2 - (this.l.size() - 1) * 13 * this.i) / 2.0F + f4;
      m = n;
      while (m < this.l.size())
      {
        paramCanvas.drawBitmap(this.e, f3, (f2 - this.e.getHeight()) / 2.0F + f1, this.g);
        paramCanvas.drawText(a((String)this.l.get(m), 3), this.e.getWidth() + f3 + this.i * 10.0F, f1 - this.g.ascent(), this.g);
        f4 = this.i;
        m += 1;
        f1 = 13.0F * f4 + f2 + f1;
      }
    }
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    e.a("mapdrawable left=" + paramInt1 + ",top=" + paramInt2 + ", right=" + paramInt3 + ", bottom=" + paramInt4);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ch
 * JD-Core Version:    0.7.0.1
 */