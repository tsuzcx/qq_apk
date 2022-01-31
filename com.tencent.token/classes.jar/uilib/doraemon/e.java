package uilib.doraemon;

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
import com.tencent.token.io;
import com.tencent.token.ip;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import taiji.ab;
import taiji.ac;
import taiji.bg;
import taiji.bk;

@TargetApi(11)
public class e
  extends Drawable
  implements Drawable.Callback
{
  private static final String d = e.class.getSimpleName();
  l a;
  d b;
  io c;
  private final Matrix e = new Matrix();
  private final Matrix f = new Matrix();
  private a g;
  private final ip h = new ip();
  private float i = 1.0F;
  private float j = 0.0F;
  private float k = 1.0F;
  private final Set l = new HashSet();
  private final ArrayList m = new ArrayList();
  private ac n;
  private String o;
  private c p;
  private ab q;
  private boolean r;
  private boolean s;
  private bg t;
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
    this.h.addUpdateListener(new f(this));
  }
  
  private boolean a(Canvas paramCanvas)
  {
    float f5 = 0.0F;
    float f7 = this.g.b().width() * this.k;
    float f6 = this.g.b().height() * this.k;
    float f4;
    float f3;
    if (this.x != null)
    {
      f4 = this.x.getWidth() / f7;
      f3 = this.x.getHeight() / f6;
    }
    for (;;)
    {
      float f8 = Math.min(f4, f3);
      float f9 = Math.max(f4, f3);
      if (((f4 == 1.0F) && (f3 == 1.0F)) || (f8 == 0.0F)) {
        return false;
      }
      paramCanvas.save();
      float f1 = f7 / 2.0F;
      float f2 = f6 / 2.0F;
      if (f4 > f3) {
        if (this.w == DoraemonAnimationView.a.b)
        {
          f6 = 0.0F;
          f2 = 0.0F;
          f3 = f1;
          f4 = f5;
          f1 = f6;
        }
      }
      for (;;)
      {
        paramCanvas.scale(f9 / f8, f9 / f8, f3, f2);
        this.f.reset();
        this.f.setTranslate(f1, f4);
        this.f.preScale(f9, f9);
        return true;
        if (this.w == DoraemonAnimationView.a.c)
        {
          f4 = paramCanvas.getHeight();
          f2 = f6;
          f3 = f1;
          f1 = 0.0F;
          f4 -= f6 * f9;
        }
        else
        {
          f4 = (paramCanvas.getHeight() - f6 * f9) / 2.0F;
          f3 = f1;
          f1 = 0.0F;
          continue;
          if (this.w == DoraemonAnimationView.a.d)
          {
            f1 = 0.0F;
            f3 = 0.0F;
            f4 = f5;
          }
          else if (this.w == DoraemonAnimationView.a.e)
          {
            f1 = paramCanvas.getWidth() - f7 * f9;
            f3 = f7;
            f4 = f5;
          }
          else
          {
            f4 = (paramCanvas.getWidth() - f7 * f9) / 2.0F;
            f3 = f1;
            f1 = f4;
            f4 = f5;
          }
        }
      }
      f3 = 0.0F;
      f4 = 0.0F;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.t == null)
    {
      this.m.add(new g(this));
      return;
    }
    if (paramBoolean) {}
    for (long l1 = (this.j * (float)this.h.getDuration());; l1 = 0L)
    {
      this.h.start();
      if (!paramBoolean) {
        break;
      }
      this.h.setCurrentPlayTime(l1);
      return;
    }
  }
  
  private void o()
  {
    if (this.g != null) {
      this.t = new bg(this, bk.a(this.g), this.g.e(), this.g);
    }
  }
  
  private void p()
  {
    if (this.t == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        this.t.a(localj.a, localj.b, localj.c);
      }
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
    setBounds(0, 0, (int)(this.g.b().width() * f1), (int)(f1 * this.g.b().height()));
  }
  
  private ac s()
  {
    if (getCallback() == null) {
      return null;
    }
    if ((this.n != null) && (!this.n.a(t())))
    {
      this.n.a();
      this.n = null;
    }
    if (this.n == null) {
      this.n = new ac(getCallback(), this.o, this.p, this.g.h());
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
  
  public void a(int paramInt)
  {
    if (this.g == null)
    {
      this.m.add(new h(this, paramInt));
      return;
    }
    a(paramInt / this.g.i());
  }
  
  public void a(io paramio)
  {
    this.c = paramio;
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
    if (this.n != null) {
      this.n.a(paramc);
    }
  }
  
  public void a(d paramd)
  {
    this.b = paramd;
  }
  
  public void a(l paraml)
  {
    this.a = paraml;
    if (this.q != null) {
      this.q.a(paraml);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 19) {
      Log.w(d, "Merge paths are not supported pre-Kit Kat.");
    }
    do
    {
      return;
      this.s = paramBoolean;
    } while (this.g == null);
    o();
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
      ((k)localIterator.next()).a(parama);
      localIterator.remove();
    }
    if (parama != null) {
      parama.a(this.v);
    }
    return true;
  }
  
  public Bitmap b(String paramString)
  {
    ac localac = s();
    if (localac != null) {
      return localac.a(paramString);
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
  
  public void b(int paramInt)
  {
    if (this.g == null)
    {
      this.m.add(new i(this, paramInt));
      return;
    }
    b(paramInt / this.g.i());
  }
  
  public void b(boolean paramBoolean)
  {
    this.v = paramBoolean;
    if (this.g != null) {
      this.g.a(paramBoolean);
    }
  }
  
  public void c()
  {
    if (this.n != null) {
      this.n.a();
    }
  }
  
  public void c(float paramFloat)
  {
    this.i = paramFloat;
    ip localip = this.h;
    if (paramFloat < 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      localip.a(bool);
      if (this.g != null) {
        this.h.setDuration(((float)this.g.c() / Math.abs(paramFloat)));
      }
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    ip localip = this.h;
    if (paramBoolean) {}
    for (int i1 = -1;; i1 = 0)
    {
      localip.setRepeatCount(i1);
      return;
    }
  }
  
  public n d()
  {
    if (this.g != null) {
      return this.g.a();
    }
    return null;
  }
  
  public void d(float paramFloat)
  {
    this.j = paramFloat;
    if (this.t != null) {
      this.t.a(paramFloat);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    m.a("Drawable#draw");
    if (this.t == null) {}
    boolean bool;
    do
    {
      return;
      bool = a(paramCanvas);
      this.e.reset();
      this.e.preScale(this.k, this.k);
      this.t.a(paramCanvas, this.e, this.u);
      m.b("Drawable#draw");
    } while (!bool);
    paramCanvas.restore();
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
    if ((this.j > 0.0D) && (this.j < 1.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      d(bool);
      return;
    }
  }
  
  public int getAlpha()
  {
    return this.u;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.g == null) {
      return -1;
    }
    return (int)(this.g.b().height() * this.k);
  }
  
  public int getIntrinsicWidth()
  {
    if (this.g == null) {
      return -1;
    }
    return (int)(this.g.b().width() * this.k);
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
  
  public io k()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     uilib.doraemon.e
 * JD-Core Version:    0.7.0.1
 */