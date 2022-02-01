package com.tencent.token;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import uilib.doraemon.DoraemonAnimationView.a;

@TargetApi(11)
public class avt
  extends Drawable
  implements Drawable.Callback
{
  private static final String p = "avt";
  public avq a;
  public final avy b = new avy();
  public float c = 0.0F;
  public float d = 1.0F;
  public final ArrayList<b> e = new ArrayList();
  public apf f;
  public String g;
  public avr h;
  public ape i;
  public avu j;
  public avs k;
  public avx l;
  public boolean m;
  public boolean n;
  public DoraemonAnimationView.a o = DoraemonAnimationView.a.a;
  private final Matrix q = new Matrix();
  private final Matrix r = new Matrix();
  private float s = 1.0F;
  private final Set<a> t = new HashSet();
  private boolean u;
  private aqa v;
  private int w = 255;
  private View x;
  
  @TargetApi(11)
  public avt(View paramView)
  {
    this.x = paramView;
    this.b.setRepeatCount(0);
    this.b.setInterpolator(new LinearInterpolator());
    this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (avt.a(avt.this))
        {
          avt.b(avt.this).cancel();
          avt.this.d(1.0F);
          return;
        }
        avt.this.d(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.v == null)
    {
      this.e.add(new b()
      {
        public final void a(avq paramAnonymousavq)
        {
          avt.this.c();
        }
      });
      return;
    }
    long l1;
    if (paramBoolean) {
      l1 = (this.c * (float)this.b.getDuration());
    } else {
      l1 = 0L;
    }
    this.b.start();
    if (paramBoolean) {
      this.b.setCurrentPlayTime(l1);
    }
  }
  
  private void f()
  {
    avq localavq = this.a;
    if (localavq != null) {
      this.v = new aqa(this, aqc.a.a(localavq), this.a.e, this.a);
    }
  }
  
  private apf g()
  {
    if (getCallback() == null) {
      return null;
    }
    apf localapf = this.f;
    if ((localapf != null) && (!localapf.a(h()))) {
      this.f = null;
    }
    if (this.f == null) {
      this.f = new apf(getCallback(), this.g, this.h, this.a.b);
    }
    return this.f;
  }
  
  private Context h()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback == null) {
      return null;
    }
    if ((localCallback instanceof View)) {
      return ((View)localCallback).getContext();
    }
    return null;
  }
  
  public final Bitmap a(String paramString)
  {
    apf localapf = g();
    if (localapf != null) {
      return localapf.a(paramString);
    }
    return null;
  }
  
  public final void a()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    this.u = false;
    if (this.a != null) {
      f();
    }
  }
  
  public final void a(float paramFloat)
  {
    this.b.a(paramFloat);
  }
  
  public final boolean a(avq paramavq)
  {
    if (this.a == paramavq) {
      return false;
    }
    this.v = null;
    this.f = null;
    invalidateSelf();
    this.a = paramavq;
    c(this.s);
    e();
    f();
    if (this.v != null)
    {
      localIterator = this.t.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        this.v.a(locala.a, locala.b, locala.c);
      }
    }
    d(this.c);
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      ((b)localIterator.next()).a(paramavq);
      localIterator.remove();
    }
    if (paramavq != null) {
      paramavq.a(this.n);
    }
    return true;
  }
  
  public final void b()
  {
    this.b.setRepeatCount(0);
  }
  
  public final void b(float paramFloat)
  {
    this.b.b(paramFloat);
  }
  
  public final void c()
  {
    float f1 = this.c;
    boolean bool;
    if ((f1 > 0.0D) && (f1 < 1.0D)) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
  }
  
  public final void c(float paramFloat)
  {
    this.s = paramFloat;
    Object localObject = this.b;
    boolean bool;
    if (paramFloat < 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    ((avy)localObject).a(bool);
    localObject = this.a;
    if (localObject != null) {
      this.b.setDuration(((float)((avq)localObject).a() / Math.abs(paramFloat)));
    }
  }
  
  public final void d(float paramFloat)
  {
    this.c = paramFloat;
    aqa localaqa = this.v;
    if (localaqa != null) {
      localaqa.a(paramFloat);
    }
  }
  
  public final boolean d()
  {
    return (this.k == null) && (this.a.d.size() > 0);
  }
  
  public void draw(Canvas paramCanvas)
  {
    avv.a("Drawable#draw");
    if (this.v == null) {
      return;
    }
    float f6 = this.a.g.width() * this.d;
    float f7 = this.a.g.height() * this.d;
    Object localObject = this.x;
    float f4 = 0.0F;
    float f3;
    if (localObject != null)
    {
      f1 = ((View)localObject).getWidth() / f6;
      f3 = this.x.getHeight() / f7;
    }
    else
    {
      f1 = 0.0F;
      f3 = 0.0F;
    }
    float f9 = Math.min(f1, f3);
    float f8 = Math.max(f1, f3);
    int i1;
    if (((f1 == 1.0F) && (f3 == 1.0F)) || (f9 == 0.0F))
    {
      i1 = 0;
    }
    else
    {
      paramCanvas.save();
      float f2 = f6 / 2.0F;
      float f5 = f7 / 2.0F;
      if (f1 > f3)
      {
        if (this.o == DoraemonAnimationView.a.b)
        {
          f1 = 0.0F;
          f3 = 0.0F;
        }
        else if (this.o == DoraemonAnimationView.a.c)
        {
          f1 = paramCanvas.getHeight() - f7 * f8;
          f3 = f7;
        }
        else
        {
          f1 = (paramCanvas.getHeight() - f7 * f8) / 2.0F;
          f3 = f5;
        }
      }
      else if (this.o == DoraemonAnimationView.a.d)
      {
        f1 = 0.0F;
        f2 = 0.0F;
        f3 = f5;
      }
      else
      {
        if (this.o == DoraemonAnimationView.a.e)
        {
          f1 = paramCanvas.getWidth();
          f2 = f6;
          f1 -= f6 * f8;
        }
        else
        {
          f1 = (paramCanvas.getWidth() - f6 * f8) / 2.0F;
        }
        f6 = 0.0F;
        f3 = f5;
        f4 = f1;
        f1 = f6;
      }
      f5 = f8 / f9;
      paramCanvas.scale(f5, f5, f2, f3);
      this.r.reset();
      this.r.setTranslate(f4, f1);
      this.r.preScale(f8, f8);
      i1 = 1;
    }
    this.q.reset();
    localObject = this.q;
    float f1 = this.d;
    ((Matrix)localObject).preScale(f1, f1);
    this.v.a(paramCanvas, this.q, this.w);
    avv.b("Drawable#draw");
    if (i1 != 0) {
      paramCanvas.restore();
    }
  }
  
  public final void e()
  {
    avq localavq = this.a;
    if (localavq == null) {
      return;
    }
    float f1 = this.d;
    setBounds(0, 0, (int)(localavq.g.width() * f1), (int)(this.a.g.height() * f1));
  }
  
  public int getAlpha()
  {
    return this.w;
  }
  
  public int getIntrinsicHeight()
  {
    avq localavq = this.a;
    if (localavq == null) {
      return -1;
    }
    return (int)(localavq.g.height() * this.d);
  }
  
  public int getIntrinsicWidth()
  {
    avq localavq = this.a;
    if (localavq == null) {
      return -1;
    }
    return (int)(localavq.g.width() * this.d);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.invalidateDrawable(this);
  }
  
  public void invalidateSelf()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.invalidateDrawable(this);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.unscheduleDrawable(this, paramRunnable);
  }
  
  static final class a
  {
    final String a;
    final String b;
    final ColorFilter c;
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      return (hashCode() == paramObject.hashCode()) && (this.c == paramObject.c);
    }
    
    public final int hashCode()
    {
      String str = this.a;
      int i;
      if (str != null) {
        i = str.hashCode() * 527;
      } else {
        i = 17;
      }
      str = this.b;
      int j = i;
      if (str != null) {
        j = i * 31 * str.hashCode();
      }
      return j;
    }
  }
  
  static abstract interface b
  {
    public abstract void a(avq paramavq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.avt
 * JD-Core Version:    0.7.0.1
 */