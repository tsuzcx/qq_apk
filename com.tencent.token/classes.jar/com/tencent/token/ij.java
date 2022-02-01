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

public class ij
{
  protected View a;
  protected int b = 8388611;
  PopupWindow.OnDismissListener c;
  private final Context d;
  private final id e;
  private final boolean f;
  private final int g;
  private final int h;
  private boolean i;
  private ik.a j;
  private ii k;
  private final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener()
  {
    public final void onDismiss()
    {
      ij.this.d();
    }
  };
  
  public ij(Context paramContext, id paramid, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramid, paramView, paramBoolean, paramInt, 0);
  }
  
  public ij(Context paramContext, id paramid, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.e = paramid;
    this.a = paramView;
    this.f = paramBoolean;
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public final ii a()
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
      if (Math.min(localPoint.x, localPoint.y) >= this.d.getResources().getDimensionPixelSize(hg.d.abc_cascading_menus_min_smallest_width)) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0) {
        localObject = new ia(this.d, this.a, this.g, this.h, this.f);
      } else {
        localObject = new ip(this.d, this.e, this.a, this.g, this.h, this.f);
      }
      ((ii)localObject).a(this.e);
      ((ii)localObject).a(this.l);
      ((ii)localObject).a(this.a);
      ((ii)localObject).a(this.j);
      ((ii)localObject).a(this.i);
      ((ii)localObject).a(this.b);
      this.k = ((ii)localObject);
    }
    return this.k;
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ii localii = a();
    localii.c(paramBoolean2);
    if (paramBoolean1)
    {
      int m = paramInt1;
      if ((fb.a(this.b, fo.c(this.a)) & 0x7) == 5) {
        m = paramInt1 + this.a.getWidth();
      }
      localii.b(m);
      localii.c(paramInt2);
      paramInt1 = (int)(this.d.getResources().getDisplayMetrics().density * 48.0F / 2.0F);
      localii.e = new Rect(m - paramInt1, paramInt2 - paramInt1, m + paramInt1, paramInt2 + paramInt1);
    }
    localii.b();
  }
  
  public final void a(ik.a parama)
  {
    this.j = parama;
    ii localii = this.k;
    if (localii != null) {
      localii.a(parama);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    ii localii = this.k;
    if (localii != null) {
      localii.a(paramBoolean);
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
    ii localii = this.k;
    return (localii != null) && (localii.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ij
 * JD-Core Version:    0.7.0.1
 */