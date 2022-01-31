package com.tencent.token.utils.bugscanuitl;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.token.m;
import com.tencent.token.utils.s;

public class TitleBar
  extends View
  implements e
{
  protected Paint a;
  private String b;
  private Bitmap c;
  private Bitmap d;
  private int e;
  private int f;
  private Bitmap g;
  private Bitmap h;
  private p i;
  private p j;
  private Bitmap k;
  private int l;
  private int m;
  private String n;
  private String o;
  private q p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private boolean v;
  private int w;
  private Context x;
  
  public TitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.x = paramContext;
    this.a = new Paint(32);
    this.a.setAntiAlias(true);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, m.b);
    this.b = paramAttributeSet.getString(0);
    this.s = paramAttributeSet.getDimensionPixelSize(1, 0);
    this.l = paramAttributeSet.getColor(2, -16777216);
    this.m = paramAttributeSet.getColor(3, -1);
    this.t = paramAttributeSet.getDimensionPixelSize(4, 0);
    this.u = paramAttributeSet.getDimensionPixelSize(5, 0);
    this.v = paramAttributeSet.getBoolean(6, true);
    paramAttributeSet.recycle();
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130837536);
    if (this.v)
    {
      this.c = paramContext;
      this.d = paramContext;
    }
  }
  
  public final void a()
  {
    Object localObject;
    if (this.k != null)
    {
      localObject = this.k;
      float f1 = this.q;
      float f2 = this.r;
      float f3 = ((Bitmap)localObject).getWidth();
      float f4 = ((Bitmap)localObject).getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1 / f3, f2 / f4);
      this.k = Bitmap.createBitmap((Bitmap)localObject, 0, 0, (int)f3, (int)f4, localMatrix, true);
    }
    if (this.c != null)
    {
      this.e = this.c.getWidth();
      this.i = new p(this);
      this.i.a(this);
      this.i.a(0);
      this.i.a(this.c, this.d);
      int i2 = s.a(this.x, this.x.getResources().getDimension(2131230741));
      localObject = this.i;
      int i1 = i2;
      if (this.e > i2) {
        i1 = this.e;
      }
      ((p)localObject).a(i1, this.r);
      this.i.b(this.t);
      if (this.o != null) {
        this.i.a(this.o);
      }
      if (this.g == null) {
        break label356;
      }
      this.f = this.g.getWidth();
      this.j = new p(this);
      this.j.a(1);
      this.j.a(this);
      this.j.a(this.g, this.h);
      this.j.a(this.f, this.r);
      this.j.b(this.q - this.e - this.u);
      if (this.n != null) {
        this.j.a(this.n);
      }
    }
    for (;;)
    {
      postInvalidate();
      return;
      this.i = null;
      break;
      label356:
      this.j = null;
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 0) {
      if (this.p != null) {
        this.p.a();
      }
    }
    while ((paramInt != 1) || (this.p == null)) {
      return;
    }
    this.p.a();
  }
  
  public final void a(q paramq)
  {
    this.p = paramq;
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.k != null) {
      paramCanvas.drawBitmap(this.k, 0.0F, 0.0F, this.a);
    }
    for (;;)
    {
      this.a.setTextSize(this.s);
      if (this.i != null) {
        this.i.a(paramCanvas, this.a);
      }
      if (this.b != null)
      {
        this.a.setFakeBoldText(false);
        String str = this.b;
        int i1 = this.q;
        Object localObject = this.b;
        if (this.w == 0) {
          this.w = ((int)this.a.measureText((String)localObject));
        }
        float f1 = i1 - this.w >> 1;
        localObject = this.a.getFontMetrics();
        float f2 = ((Paint.FontMetrics)localObject).bottom;
        float f3 = ((Paint.FontMetrics)localObject).top;
        paramCanvas.drawText(str, f1, this.r - (this.r - (f2 - f3)) / 2.0F - ((Paint.FontMetrics)localObject).bottom, this.a);
      }
      if (this.j != null) {
        this.j.a(paramCanvas, this.a);
      }
      return;
      this.a.setColor(this.l);
      paramCanvas.drawRect(0.0F, 0.0F, this.q, this.r, this.a);
      this.a.setColor(this.m);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.q = getMeasuredWidth();
    this.r = getMeasuredHeight();
    a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.j != null) {
      this.j.a(paramMotionEvent);
    }
    if (this.i != null) {
      this.i.a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.TitleBar
 * JD-Core Version:    0.7.0.1
 */