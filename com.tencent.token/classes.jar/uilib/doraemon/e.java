package uilib.doraemon;

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
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.token.gi;
import com.tencent.token.gj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import taiji.as;
import taiji.cs.a;
import taiji.y;
import taiji.z;

@TargetApi(11)
public class e
  extends Drawable
  implements Drawable.Callback
{
  private static final String d = "e";
  f a;
  d b;
  gi c;
  private final Matrix e = new Matrix();
  private final Matrix f = new Matrix();
  private a g;
  private final gj h = new gj();
  private float i = 1.0F;
  private float j = 0.0F;
  private float k = 1.0F;
  private final Set<a> l = new HashSet();
  private final ArrayList<b> m = new ArrayList();
  private z n;
  private String o;
  private c p;
  private y q;
  private boolean r;
  private boolean s;
  private as t;
  private int u = 255;
  private boolean v;
  private DoraemonAnimationView.a w = DoraemonAnimationView.a.a;
  private View x;
  
  @TargetApi(11)
  public e(View paramView)
  {
    this.x = paramView;
    this.h.setRepeatCount(0);
    this.h.setInterpolator(new LinearInterpolator());
    this.h.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (e.a(e.this))
        {
          e.b(e.this).cancel();
          e.this.d(1.0F);
          return;
        }
        e.this.d(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
      }
    });
  }
  
  private boolean a(Canvas paramCanvas)
  {
    float f6 = this.g.b().width() * this.k;
    float f7 = this.g.b().height() * this.k;
    View localView = this.x;
    float f4 = 0.0F;
    float f1;
    float f3;
    if (localView != null)
    {
      f1 = localView.getWidth() / f6;
      f3 = this.x.getHeight() / f7;
    }
    else
    {
      f1 = 0.0F;
      f3 = 0.0F;
    }
    float f9 = Math.min(f1, f3);
    float f8 = Math.max(f1, f3);
    if (((f1 == 1.0F) && (f3 == 1.0F)) || (f9 == 0.0F)) {
      return false;
    }
    paramCanvas.save();
    float f2 = f6 / 2.0F;
    float f5 = f7 / 2.0F;
    if (f1 > f3)
    {
      if (this.w == DoraemonAnimationView.a.b)
      {
        f1 = 0.0F;
        f3 = 0.0F;
      }
      else if (this.w == DoraemonAnimationView.a.c)
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
    else if (this.w == DoraemonAnimationView.a.d)
    {
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = f5;
    }
    else
    {
      if (this.w == DoraemonAnimationView.a.e)
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
    this.f.reset();
    this.f.setTranslate(f4, f1);
    this.f.preScale(f8, f8);
    return true;
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.t == null)
    {
      this.m.add(new b()
      {
        public void a(a paramAnonymousa)
        {
          e.this.g();
        }
      });
      return;
    }
    long l1;
    if (paramBoolean) {
      l1 = (this.j * (float)this.h.getDuration());
    } else {
      l1 = 0L;
    }
    this.h.start();
    if (paramBoolean) {
      this.h.setCurrentPlayTime(l1);
    }
  }
  
  private void o()
  {
    a locala = this.g;
    if (locala != null) {
      this.t = new as(this, cs.a.a(locala), this.g.e(), this.g);
    }
  }
  
  private void p()
  {
    if (this.t == null) {
      return;
    }
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      this.t.a(locala.a, locala.b, locala.c);
    }
  }
  
  private void q()
  {
    c();
    this.t = null;
    this.n = null;
    invalidateSelf();
  }
  
  private void r()
  {
    if (this.g == null) {
      return;
    }
    float f1 = l();
    setBounds(0, 0, (int)(this.g.b().width() * f1), (int)(this.g.b().height() * f1));
  }
  
  private z s()
  {
    if (getCallback() == null) {
      return null;
    }
    z localz = this.n;
    if ((localz != null) && (!localz.a(t())))
    {
      this.n.a();
      this.n = null;
    }
    if (this.n == null) {
      this.n = new z(getCallback(), this.o, this.p, this.g.h());
    }
    return this.n;
  }
  
  private Context t()
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
  
  public void a(float paramFloat)
  {
    this.h.a(paramFloat);
  }
  
  public void a(final int paramInt)
  {
    a locala = this.g;
    if (locala == null)
    {
      this.m.add(new b()
      {
        public void a(a paramAnonymousa)
        {
          e.this.a(paramInt / paramAnonymousa.i());
        }
      });
      return;
    }
    a(paramInt / locala.i());
  }
  
  public void a(gi paramgi)
  {
    this.c = paramgi;
  }
  
  public void a(String paramString)
  {
    this.o = paramString;
  }
  
  public void a(DoraemonAnimationView.a parama)
  {
    this.w = parama;
  }
  
  public void a(c paramc)
  {
    this.p = paramc;
    z localz = this.n;
    if (localz != null) {
      localz.a(paramc);
    }
  }
  
  public void a(d paramd)
  {
    this.b = paramd;
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
    y localy = this.q;
    if (localy != null) {
      localy.a(paramf);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 19)
    {
      Log.w(d, "Merge paths are not supported pre-Kit Kat.");
      return;
    }
    this.s = paramBoolean;
    if (this.g != null) {
      o();
    }
  }
  
  public boolean a()
  {
    return this.s;
  }
  
  public boolean a(a parama)
  {
    if (this.g == parama) {
      return false;
    }
    q();
    this.g = parama;
    c(this.i);
    r();
    o();
    p();
    d(this.j);
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      ((b)localIterator.next()).a(parama);
      localIterator.remove();
    }
    if (parama != null) {
      parama.a(this.v);
    }
    return true;
  }
  
  public Bitmap b(String paramString)
  {
    z localz = s();
    if (localz != null) {
      return localz.a(paramString);
    }
    return null;
  }
  
  public String b()
  {
    return this.o;
  }
  
  public void b(float paramFloat)
  {
    this.h.b(paramFloat);
  }
  
  public void b(final int paramInt)
  {
    a locala = this.g;
    if (locala == null)
    {
      this.m.add(new b()
      {
        public void a(a paramAnonymousa)
        {
          e.this.b(paramInt / paramAnonymousa.i());
        }
      });
      return;
    }
    b(paramInt / locala.i());
  }
  
  public void b(boolean paramBoolean)
  {
    this.v = paramBoolean;
    a locala = this.g;
    if (locala != null) {
      locala.a(paramBoolean);
    }
  }
  
  public void c()
  {
    z localz = this.n;
    if (localz != null) {
      localz.a();
    }
  }
  
  public void c(float paramFloat)
  {
    this.i = paramFloat;
    Object localObject = this.h;
    boolean bool;
    if (paramFloat < 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    ((gj)localObject).a(bool);
    localObject = this.g;
    if (localObject != null) {
      this.h.setDuration(((float)((a)localObject).c() / Math.abs(paramFloat)));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    gj localgj = this.h;
    int i1;
    if (paramBoolean) {
      i1 = -1;
    } else {
      i1 = 0;
    }
    localgj.setRepeatCount(i1);
  }
  
  public h d()
  {
    a locala = this.g;
    if (locala != null) {
      return locala.a();
    }
    return null;
  }
  
  public void d(float paramFloat)
  {
    this.j = paramFloat;
    as localas = this.t;
    if (localas != null) {
      localas.a(paramFloat);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    g.a("Drawable#draw");
    if (this.t == null) {
      return;
    }
    boolean bool = a(paramCanvas);
    this.e.reset();
    Matrix localMatrix = this.e;
    float f1 = this.k;
    localMatrix.preScale(f1, f1);
    this.t.a(paramCanvas, this.e, this.u);
    g.b("Drawable#draw");
    if (bool) {
      paramCanvas.restore();
    }
  }
  
  void e()
  {
    this.r = true;
  }
  
  public void e(float paramFloat)
  {
    this.k = paramFloat;
    r();
  }
  
  public boolean f()
  {
    return this.h.isRunning();
  }
  
  public void g()
  {
    float f1 = this.j;
    boolean bool;
    if ((f1 > 0.0D) && (f1 < 1.0D)) {
      bool = true;
    } else {
      bool = false;
    }
    d(bool);
  }
  
  public int getAlpha()
  {
    return this.u;
  }
  
  public int getIntrinsicHeight()
  {
    a locala = this.g;
    if (locala == null) {
      return -1;
    }
    return (int)(locala.b().height() * this.k);
  }
  
  public int getIntrinsicWidth()
  {
    a locala = this.g;
    if (locala == null) {
      return -1;
    }
    return (int)(locala.b().width() * this.k);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public float h()
  {
    return this.j;
  }
  
  public d i()
  {
    return this.b;
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
  
  public boolean j()
  {
    return (this.b == null) && (this.g.f().size() > 0);
  }
  
  public gi k()
  {
    return this.c;
  }
  
  public float l()
  {
    return this.k;
  }
  
  public a m()
  {
    return this.g;
  }
  
  public void n()
  {
    this.m.clear();
    this.h.cancel();
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
    this.u = paramInt;
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
  
  private static class a
  {
    final String a;
    final String b;
    final ColorFilter c;
    
    public boolean equals(Object paramObject)
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
    
    public int hashCode()
    {
      String str = this.a;
      int i;
      if (str != null) {
        i = 527 * str.hashCode();
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
  
  private static abstract interface b
  {
    public abstract void a(a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.e
 * JD-Core Version:    0.7.0.1
 */