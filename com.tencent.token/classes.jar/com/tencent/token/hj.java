package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class hj
  extends hr
  implements View.OnKeyListener, PopupWindow.OnDismissListener, ht
{
  private PopupWindow.OnDismissListener A;
  final Handler a;
  final List<a> b = new ArrayList();
  View c;
  boolean d;
  private final Context f;
  private final int g;
  private final int h;
  private final int i;
  private final boolean j;
  private final List<hm> k = new ArrayList();
  private final ViewTreeObserver.OnGlobalLayoutListener l = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      if ((hj.this.d()) && (hj.this.b.size() > 0) && (!((hj.a)hj.this.b.get(0)).a.p))
      {
        Object localObject = hj.this.c;
        if ((localObject != null) && (((View)localObject).isShown())) {
          localObject = hj.this.b.iterator();
        }
        while (((Iterator)localObject).hasNext())
        {
          ((hj.a)((Iterator)localObject).next()).a.b();
          continue;
          hj.this.c();
          return;
        }
      }
    }
  };
  private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener()
  {
    public final void onViewAttachedToWindow(View paramAnonymousView) {}
    
    public final void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (hj.a(hj.this) != null)
      {
        if (!hj.a(hj.this).isAlive()) {
          hj.a(hj.this, paramAnonymousView.getViewTreeObserver());
        }
        hj.a(hj.this).removeGlobalOnLayoutListener(hj.b(hj.this));
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final iv n = new iv()
  {
    public final void a(hm paramAnonymoushm, MenuItem paramAnonymousMenuItem)
    {
      hj.this.a.removeCallbacksAndMessages(paramAnonymoushm);
    }
    
    public final void b(final hm paramAnonymoushm, final MenuItem paramAnonymousMenuItem)
    {
      Handler localHandler = hj.this.a;
      final hj.a locala = null;
      localHandler.removeCallbacksAndMessages(null);
      int j = hj.this.b.size();
      int i = 0;
      while (i < j)
      {
        if (paramAnonymoushm == ((hj.a)hj.this.b.get(i)).b) {
          break label75;
        }
        i += 1;
      }
      i = -1;
      label75:
      if (i == -1) {
        return;
      }
      i += 1;
      if (i < hj.this.b.size()) {
        locala = (hj.a)hj.this.b.get(i);
      }
      paramAnonymousMenuItem = new Runnable()
      {
        public final void run()
        {
          if (locala != null)
          {
            hj.this.d = true;
            locala.b.a(false);
            hj.this.d = false;
          }
          if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu())) {
            paramAnonymoushm.a(paramAnonymousMenuItem, null, 4);
          }
        }
      };
      long l = SystemClock.uptimeMillis();
      hj.this.a.postAtTime(paramAnonymousMenuItem, paramAnonymoushm, l + 200L);
    }
  };
  private int o = 0;
  private int p = 0;
  private View q;
  private int r;
  private boolean s;
  private boolean t;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private ht.a y;
  private ViewTreeObserver z;
  
  public hj(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.f = paramContext;
    this.q = paramView;
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramBoolean;
    this.w = false;
    this.r = h();
    paramContext = paramContext.getResources();
    this.g = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(gp.d.abc_config_prefDialogWidth));
    this.a = new Handler();
  }
  
  private static MenuItem a(hm paramhm1, hm paramhm2)
  {
    int i2 = paramhm1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = paramhm1.getItem(i1);
      if ((localMenuItem.hasSubMenu()) && (paramhm2 == localMenuItem.getSubMenu())) {
        return localMenuItem;
      }
      i1 += 1;
    }
    return null;
  }
  
  private static View a(a parama, hm paramhm)
  {
    paramhm = a(parama.b, paramhm);
    if (paramhm == null) {
      return null;
    }
    is localis = parama.a.e;
    parama = localis.getAdapter();
    boolean bool = parama instanceof HeaderViewListAdapter;
    int i1 = 0;
    int i2;
    if (bool)
    {
      parama = (HeaderViewListAdapter)parama;
      i2 = parama.getHeadersCount();
      parama = (hl)parama.getWrappedAdapter();
    }
    else
    {
      parama = (hl)parama;
      i2 = 0;
    }
    int i3 = parama.getCount();
    while (i1 < i3)
    {
      if (paramhm == parama.a(i1)) {
        break label104;
      }
      i1 += 1;
    }
    i1 = -1;
    label104:
    if (i1 == -1) {
      return null;
    }
    i1 = i1 + i2 - localis.getFirstVisiblePosition();
    if (i1 >= 0)
    {
      if (i1 >= localis.getChildCount()) {
        return null;
      }
      return localis.getChildAt(i1);
    }
    return null;
  }
  
  private void c(hm paramhm)
  {
    Object localObject3 = LayoutInflater.from(this.f);
    Object localObject1 = new hl(paramhm, (LayoutInflater)localObject3, this.j);
    if ((!d()) && (this.w)) {
      ((hl)localObject1).c = true;
    } else if (d()) {
      ((hl)localObject1).c = hr.b(paramhm);
    }
    int i4 = a((ListAdapter)localObject1, null, this.f, this.g);
    iw localiw = g();
    localiw.a((ListAdapter)localObject1);
    localiw.b(i4);
    localiw.h = this.p;
    if (this.b.size() > 0)
    {
      localObject1 = this.b;
      localObject1 = (a)((List)localObject1).get(((List)localObject1).size() - 1);
      localObject2 = a((a)localObject1, paramhm);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      localiw.l();
      localiw.a();
      int i2 = d(i4);
      int i1;
      if (i2 == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.r = i2;
      int i3;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localiw.k = ((View)localObject2);
        i2 = 0;
        i3 = 0;
      }
      else
      {
        int[] arrayOfInt1 = new int[2];
        this.q.getLocationOnScreen(arrayOfInt1);
        int[] arrayOfInt2 = new int[2];
        ((View)localObject2).getLocationOnScreen(arrayOfInt2);
        if ((this.p & 0x7) == 5)
        {
          arrayOfInt1[0] += this.q.getWidth();
          arrayOfInt2[0] += ((View)localObject2).getWidth();
        }
        i3 = arrayOfInt2[0] - arrayOfInt1[0];
        i2 = arrayOfInt2[1] - arrayOfInt1[1];
      }
      if ((this.p & 0x5) == 5)
      {
        if (i1 != 0) {
          i1 = i3 + i4;
        } else {
          i1 = i3 - ((View)localObject2).getWidth();
        }
      }
      else if (i1 != 0) {
        i1 = i3 + ((View)localObject2).getWidth();
      } else {
        i1 = i3 - i4;
      }
      localiw.g = i1;
      localiw.k();
      localiw.a(i2);
    }
    else
    {
      if (this.s) {
        localiw.g = this.u;
      }
      if (this.t) {
        localiw.a(this.v);
      }
      localiw.o = this.e;
    }
    Object localObject2 = new a(localiw, paramhm, this.r);
    this.b.add(localObject2);
    localiw.b();
    localObject2 = localiw.e;
    ((ListView)localObject2).setOnKeyListener(this);
    if ((localObject1 == null) && (this.x) && (paramhm.f != null))
    {
      localObject1 = (FrameLayout)((LayoutInflater)localObject3).inflate(gp.g.abc_popup_menu_header_item_layout, (ViewGroup)localObject2, false);
      localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
      ((FrameLayout)localObject1).setEnabled(false);
      ((TextView)localObject3).setText(paramhm.f);
      ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
      localiw.b();
    }
  }
  
  private int d(int paramInt)
  {
    Object localObject = this.b;
    localObject = ((a)((List)localObject).get(((List)localObject).size() - 1)).a.e;
    int[] arrayOfInt = new int[2];
    ((ListView)localObject).getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.c.getWindowVisibleDisplayFrame(localRect);
    if (this.r == 1)
    {
      if (arrayOfInt[0] + ((ListView)localObject).getWidth() + paramInt > localRect.right) {
        return 0;
      }
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0) {
      return 1;
    }
    return 0;
  }
  
  private iw g()
  {
    iw localiw = new iw(this.f, this.h, this.i);
    localiw.a = this.n;
    localiw.l = this;
    localiw.a(this);
    localiw.k = this.q;
    localiw.h = this.p;
    localiw.f();
    localiw.h();
    return localiw;
  }
  
  private int h()
  {
    if (ex.c(this.q) == 1) {
      return 0;
    }
    return 1;
  }
  
  public final void a(int paramInt)
  {
    if (this.o != paramInt)
    {
      this.o = paramInt;
      this.p = ek.a(paramInt, ex.c(this.q));
    }
  }
  
  public final void a(View paramView)
  {
    if (this.q != paramView)
    {
      this.q = paramView;
      this.p = ek.a(this.o, ex.c(this.q));
    }
  }
  
  public final void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.A = paramOnDismissListener;
  }
  
  public final void a(hm paramhm)
  {
    paramhm.a(this, this.f);
    if (d())
    {
      c(paramhm);
      return;
    }
    this.k.add(paramhm);
  }
  
  public final void a(hm paramhm, boolean paramBoolean)
  {
    int i2 = this.b.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramhm == ((a)this.b.get(i1)).b) {
        break label51;
      }
      i1 += 1;
    }
    i1 = -1;
    label51:
    if (i1 < 0) {
      return;
    }
    i2 = i1 + 1;
    if (i2 < this.b.size()) {
      ((a)this.b.get(i2)).b.a(false);
    }
    Object localObject = (a)this.b.remove(i1);
    ((a)localObject).b.b(this);
    if (this.d)
    {
      iw localiw = ((a)localObject).a;
      if (Build.VERSION.SDK_INT >= 23) {
        localiw.q.setExitTransition(null);
      }
      ((a)localObject).a.q.setAnimationStyle(0);
    }
    ((a)localObject).a.c();
    i1 = this.b.size();
    if (i1 > 0) {
      this.r = ((a)this.b.get(i1 - 1)).c;
    } else {
      this.r = h();
    }
    if (i1 == 0)
    {
      c();
      localObject = this.y;
      if (localObject != null) {
        ((ht.a)localObject).a(paramhm, true);
      }
      paramhm = this.z;
      if (paramhm != null)
      {
        if (paramhm.isAlive()) {
          this.z.removeGlobalOnLayoutListener(this.l);
        }
        this.z = null;
      }
      this.c.removeOnAttachStateChangeListener(this.m);
      this.A.onDismiss();
      return;
    }
    if (paramBoolean) {
      ((a)this.b.get(0)).b.a(false);
    }
  }
  
  public final void a(ht.a parama)
  {
    this.y = parama;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(hz paramhz)
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (paramhz == locala.b)
      {
        locala.a.e.requestFocus();
        return true;
      }
    }
    if (paramhz.hasVisibleItems())
    {
      a(paramhz);
      localObject = this.y;
      if (localObject != null) {
        ((ht.a)localObject).a(paramhz);
      }
      return true;
    }
    return false;
  }
  
  public final void b()
  {
    if (d()) {
      return;
    }
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      c((hm)localIterator.next());
    }
    this.k.clear();
    this.c = this.q;
    if (this.c != null)
    {
      int i1;
      if (this.z == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.z = this.c.getViewTreeObserver();
      if (i1 != 0) {
        this.z.addOnGlobalLayoutListener(this.l);
      }
      this.c.addOnAttachStateChangeListener(this.m);
    }
  }
  
  public final void b(int paramInt)
  {
    this.s = true;
    this.u = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      a(((a)localIterator.next()).a.e.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final void c()
  {
    int i1 = this.b.size();
    if (i1 > 0)
    {
      a[] arrayOfa = (a[])this.b.toArray(new a[i1]);
      i1 -= 1;
      while (i1 >= 0)
      {
        a locala = arrayOfa[i1];
        if (locala.a.q.isShowing()) {
          locala.a.c();
        }
        i1 -= 1;
      }
    }
  }
  
  public final void c(int paramInt)
  {
    this.t = true;
    this.v = paramInt;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public final boolean d()
  {
    return (this.b.size() > 0) && (((a)this.b.get(0)).a.q.isShowing());
  }
  
  public final ListView e()
  {
    if (this.b.isEmpty()) {
      return null;
    }
    List localList = this.b;
    return ((a)localList.get(localList.size() - 1)).a.e;
  }
  
  protected final boolean f()
  {
    return false;
  }
  
  public final void onDismiss()
  {
    int i2 = this.b.size();
    int i1 = 0;
    while (i1 < i2)
    {
      locala = (a)this.b.get(i1);
      if (!locala.a.q.isShowing()) {
        break label56;
      }
      i1 += 1;
    }
    a locala = null;
    label56:
    if (locala != null) {
      locala.b.a(false);
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
  
  static final class a
  {
    public final iw a;
    public final hm b;
    public final int c;
    
    public a(iw paramiw, hm paramhm, int paramInt)
    {
      this.a = paramiw;
      this.b = paramhm;
      this.c = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hj
 * JD-Core Version:    0.7.0.1
 */