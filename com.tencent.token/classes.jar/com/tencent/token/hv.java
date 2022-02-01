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

public class hv
{
  protected View a;
  protected int b = 8388611;
  PopupWindow.OnDismissListener c;
  private final Context d;
  private final hp e;
  private final boolean f;
  private final int g;
  private final int h;
  private boolean i;
  private hw.a j;
  private hu k;
  private final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      hv.this.d();
    }
  };
  
  public hv(Context paramContext, hp paramhp, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramhp, paramView, paramBoolean, paramInt, 0);
  }
  
  public hv(Context paramContext, hp paramhp, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.e = paramhp;
    this.a = paramView;
    this.f = paramBoolean;
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public final hu a()
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
      if (Math.min(localPoint.x, localPoint.y) >= this.d.getResources().getDimensionPixelSize(gs.d.abc_cascading_menus_min_smallest_width)) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0) {
        localObject = new hm(this.d, this.a, this.g, this.h, this.f);
      } else {
        localObject = new ib(this.d, this.e, this.a, this.g, this.h, this.f);
      }
      ((hu)localObject).a(this.e);
      ((hu)localObject).a(this.l);
      ((hu)localObject).a(this.a);
      ((hu)localObject).a(this.j);
      ((hu)localObject).a(this.i);
      ((hu)localObject).a(this.b);
      this.k = ((hu)localObject);
    }
    return this.k;
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    hu localhu = a();
    localhu.c(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((en.a(this.b, fa.c(this.a)) & 0x7) == 5) {
        m = paramInt1 + this.a.getWidth();
      }
      localhu.b(m);
      localhu.c(paramInt2);
      paramInt1 = (int)(this.d.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localhu.e = new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt2 + paramInt1);
    }
    localhu.b();
  }
  
  public final void a(hw.a parama)
  {
    this.j = parama;
    hu localhu = this.k;
    if (localhu != null) {
      localhu.a(parama);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    hu localhu = this.k;
    if (localhu != null) {
      localhu.a(paramBoolean);
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
    hu localhu = this.k;
    return (localhu != null) && (localhu.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hv
 * JD-Core Version:    0.7.0.1
 */