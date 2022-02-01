package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class hx
  extends hq
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, hs
{
  final iv a;
  View b;
  private final Context c;
  private final hl d;
  private final hk f;
  private final boolean g;
  private final int h;
  private final int i;
  private final int j;
  private final ViewTreeObserver.OnGlobalLayoutListener k = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if ((hx.this.d()) && (!hx.this.a.p))
      {
        View localView = hx.this.b;
        if ((localView != null) && (localView.isShown()))
        {
          hx.this.a.b();
          return;
        }
        hx.this.c();
        return;
      }
    }
  };
  private final View.OnAttachStateChangeListener l = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (hx.a(hx.this) != null)
      {
        if (!hx.a(hx.this).isAlive()) {
          hx.a(hx.this, paramAnonymousView.getViewTreeObserver());
        }
        hx.a(hx.this).removeGlobalOnLayoutListener(hx.b(hx.this));
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private PopupWindow.OnDismissListener m;
  private View n;
  private hs.a o;
  private ViewTreeObserver p;
  private boolean q;
  private boolean r;
  private int s;
  private int t = 0;
  private boolean u;
  
  public hx(Context paramContext, hl paramhl, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.c = paramContext;
    this.d = paramhl;
    this.g = paramBoolean;
    this.f = new hk(paramhl, LayoutInflater.from(paramContext), this.g);
    this.i = paramInt1;
    this.j = paramInt2;
    Resources localResources = paramContext.getResources();
    this.h = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(go.d.abc_config_prefDialogWidth));
    this.n = paramView;
    this.a = new iv(this.c, this.i, this.j);
    paramhl.a(this, paramContext);
  }
  
  public final void a(int paramInt)
  {
    this.t = paramInt;
  }
  
  public final void a(View paramView)
  {
    this.n = paramView;
  }
  
  public final void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.m = paramOnDismissListener;
  }
  
  public final void a(hl paramhl) {}
  
  public final void a(hl paramhl, boolean paramBoolean)
  {
    if (paramhl != this.d) {
      return;
    }
    c();
    hs.a locala = this.o;
    if (locala != null) {
      locala.a(paramhl, paramBoolean);
    }
  }
  
  public final void a(hs.a parama)
  {
    this.o = parama;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f.c = paramBoolean;
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(hy paramhy)
  {
    if (paramhy.hasVisibleItems())
    {
      Object localObject = new hr(this.c, paramhy, this.b, this.g, this.i, this.j);
      ((hr)localObject).a(this.o);
      ((hr)localObject).a(hq.b(paramhy));
      ((hr)localObject).b = this.t;
      ((hr)localObject).c = this.m;
      this.m = null;
      this.d.a(false);
      int i1 = this.a.g;
      int i2 = this.a.g();
      if (((hr)localObject).e())
      {
        i1 = 1;
      }
      else if (((hr)localObject).a == null)
      {
        i1 = 0;
      }
      else
      {
        ((hr)localObject).a(i1, i2, true, true);
        i1 = 1;
      }
      if (i1 != 0)
      {
        localObject = this.o;
        if (localObject != null) {
          ((hs.a)localObject).a(paramhy);
        }
        return true;
      }
    }
    return false;
  }
  
  public final void b()
  {
    boolean bool = d();
    int i2 = 1;
    int i1;
    if (bool)
    {
      i1 = i2;
    }
    else
    {
      if (!this.q)
      {
        Object localObject1 = this.n;
        if (localObject1 != null)
        {
          this.b = ((View)localObject1);
          this.a.a(this);
          localObject1 = this.a;
          ((ListPopupWindow)localObject1).l = this;
          ((iv)localObject1).f();
          localObject1 = this.b;
          if (this.p == null) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          this.p = ((View)localObject1).getViewTreeObserver();
          if (i1 != 0) {
            this.p.addOnGlobalLayoutListener(this.k);
          }
          ((View)localObject1).addOnAttachStateChangeListener(this.l);
          Object localObject2 = this.a;
          ((ListPopupWindow)localObject2).k = ((View)localObject1);
          ((ListPopupWindow)localObject2).h = this.t;
          if (!this.r)
          {
            this.s = a(this.f, null, this.c, this.h);
            this.r = true;
          }
          this.a.b(this.s);
          this.a.h();
          this.a.o = this.e;
          this.a.b();
          localObject1 = this.a.e;
          ((ListView)localObject1).setOnKeyListener(this);
          if ((this.u) && (this.d.f != null))
          {
            localObject2 = (FrameLayout)LayoutInflater.from(this.c).inflate(go.g.abc_popup_menu_header_item_layout, (ViewGroup)localObject1, false);
            TextView localTextView = (TextView)((FrameLayout)localObject2).findViewById(16908310);
            if (localTextView != null) {
              localTextView.setText(this.d.f);
            }
            ((FrameLayout)localObject2).setEnabled(false);
            ((ListView)localObject1).addHeaderView((View)localObject2, null, false);
          }
          this.a.a(this.f);
          this.a.b();
          i1 = i2;
          break label334;
        }
      }
      i1 = 0;
    }
    label334:
    if (i1 != 0) {
      return;
    }
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public final void b(int paramInt)
  {
    this.a.g = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.r = false;
    hk localhk = this.f;
    if (localhk != null) {
      localhk.notifyDataSetChanged();
    }
  }
  
  public final void c()
  {
    if (d()) {
      this.a.c();
    }
  }
  
  public final void c(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public final void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public final boolean d()
  {
    return (!this.q) && (this.a.q.isShowing());
  }
  
  public final ListView e()
  {
    return this.a.e;
  }
  
  public final void onDismiss()
  {
    this.q = true;
    this.d.close();
    Object localObject = this.p;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        this.p = this.b.getViewTreeObserver();
      }
      this.p.removeGlobalOnLayoutListener(this.k);
      this.p = null;
    }
    this.b.removeOnAttachStateChangeListener(this.l);
    localObject = this.m;
    if (localObject != null) {
      ((PopupWindow.OnDismissListener)localObject).onDismiss();
    }
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      c();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hx
 * JD-Core Version:    0.7.0.1
 */