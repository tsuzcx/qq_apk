package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

public class hs
{
  protected View a;
  protected int b = 8388611;
  PopupWindow.OnDismissListener c;
  private final Context d;
  private final hm e;
  private final boolean f;
  private final int g;
  private final int h;
  private boolean i;
  private ht.a j;
  private hr k;
  private final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      hs.this.d();
    }
  };
  
  public hs(Context paramContext, hm paramhm, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramhm, paramView, paramBoolean, paramInt, 0);
  }
  
  public hs(Context paramContext, hm paramhm, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.e = paramhm;
    this.a = paramView;
    this.f = paramBoolean;
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public final hr a()
  {
    if (this.k == null)
    {
      Object localObject = ((WindowManager)this.d.getSystemService("window")).getDefaultDisplay();
      Point localPoint = new Point();
      if (Build.VERSION.SDK_INT >= 17) {
        ((Display)localObject).getRealSize(localPoint);
      } else {
        ((Display)localObject).getSize(localPoint);
      }
      int m;
      if (Math.min(localPoint.x, localPoint.y) >= this.d.getResources().getDimensionPixelSize(gp.d.abc_cascading_menus_min_smallest_width)) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0) {
        localObject = new hj(this.d, this.a, this.g, this.h, this.f);
      } else {
        localObject = new hy(this.d, this.e, this.a, this.g, this.h, this.f);
      }
      ((hr)localObject).a(this.e);
      ((hr)localObject).a(this.l);
      ((hr)localObject).a(this.a);
      ((hr)localObject).a(this.j);
      ((hr)localObject).a(this.i);
      ((hr)localObject).a(this.b);
      this.k = ((hr)localObject);
    }
    return this.k;
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    hr localhr = a();
    localhr.c(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((ek.a(this.b, ex.c(this.a)) & 0x7) == 5) {
        m = paramInt1 + this.a.getWidth();
      }
      localhr.b(m);
      localhr.c(paramInt2);
      paramInt1 = (int)(this.d.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localhr.e = new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt2 + paramInt1);
    }
    localhr.b();
  }
  
  public final void a(ht.a parama)
  {
    this.j = parama;
    hr localhr = this.k;
    if (localhr != null) {
      localhr.a(parama);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    hr localhr = this.k;
    if (localhr != null) {
      localhr.a(paramBoolean);
    }
  }
  
  public final boolean b()
  {
    if (e()) {
      return true;
    }
    if (this.a == null) {
      return false;
    }
    a(0, 0, false, false);
    return true;
  }
  
  public final void c()
  {
    if (e()) {
      this.k.c();
    }
  }
  
  protected void d()
  {
    this.k = null;
    PopupWindow.OnDismissListener localOnDismissListener = this.c;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss();
    }
  }
  
  public final boolean e()
  {
    hr localhr = this.k;
    return (localhr != null) && (localhr.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hs
 * JD-Core Version:    0.7.0.1
 */