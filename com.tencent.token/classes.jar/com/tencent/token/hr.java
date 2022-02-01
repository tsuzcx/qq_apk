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

public class hr
{
  protected View a;
  protected int b = 8388611;
  PopupWindow.OnDismissListener c;
  private final Context d;
  private final hl e;
  private final boolean f;
  private final int g;
  private final int h;
  private boolean i;
  private hs.a j;
  private hq k;
  private final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      hr.this.d();
    }
  };
  
  public hr(Context paramContext, hl paramhl, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramhl, paramView, paramBoolean, paramInt, 0);
  }
  
  public hr(Context paramContext, hl paramhl, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.e = paramhl;
    this.a = paramView;
    this.f = paramBoolean;
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public final hq a()
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
      if (Math.min(localPoint.x, localPoint.y) >= this.d.getResources().getDimensionPixelSize(go.d.abc_cascading_menus_min_smallest_width)) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0) {
        localObject = new hi(this.d, this.a, this.g, this.h, this.f);
      } else {
        localObject = new hx(this.d, this.e, this.a, this.g, this.h, this.f);
      }
      ((hq)localObject).a(this.e);
      ((hq)localObject).a(this.l);
      ((hq)localObject).a(this.a);
      ((hq)localObject).a(this.j);
      ((hq)localObject).a(this.i);
      ((hq)localObject).a(this.b);
      this.k = ((hq)localObject);
    }
    return this.k;
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    hq localhq = a();
    localhq.c(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((ej.a(this.b, ew.c(this.a)) & 0x7) == 5) {
        m = paramInt1 + this.a.getWidth();
      }
      localhq.b(m);
      localhq.c(paramInt2);
      paramInt1 = (int)(this.d.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localhq.e = new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt2 + paramInt1);
    }
    localhq.b();
  }
  
  public final void a(hs.a parama)
  {
    this.j = parama;
    hq localhq = this.k;
    if (localhq != null) {
      localhq.a(parama);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    hq localhq = this.k;
    if (localhq != null) {
      localhq.a(paramBoolean);
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
    hq localhq = this.k;
    return (localhq != null) && (localhq.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hr
 * JD-Core Version:    0.7.0.1
 */