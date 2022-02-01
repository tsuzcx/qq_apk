package com.tencent.token;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.a;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class gn
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator t = new AccelerateInterpolator();
  private static final Interpolator u = new DecelerateInterpolator();
  private boolean A;
  private boolean B;
  private ArrayList<Object> C = new ArrayList();
  private boolean D;
  private int E = 0;
  private boolean F;
  private boolean G = true;
  private boolean H;
  Context a;
  ActionBarOverlayLayout b;
  ActionBarContainer c;
  ip d;
  ActionBarContextView e;
  View f;
  iy g;
  a h;
  gw i;
  gw.a j;
  boolean k = true;
  boolean l;
  boolean m;
  hc n;
  boolean o;
  final fa p = new fb()
  {
    public final void b(View paramAnonymousView)
    {
      if ((gn.this.k) && (gn.this.f != null))
      {
        gn.this.f.setTranslationY(0.0F);
        gn.this.c.setTranslationY(0.0F);
      }
      gn.this.c.setVisibility(8);
      gn.this.c.setTransitioning(false);
      paramAnonymousView = gn.this;
      paramAnonymousView.n = null;
      if (paramAnonymousView.j != null)
      {
        paramAnonymousView.j.a(paramAnonymousView.i);
        paramAnonymousView.i = null;
        paramAnonymousView.j = null;
      }
      if (gn.this.b != null) {
        ew.j(gn.this.b);
      }
    }
  };
  final fa q = new fb()
  {
    public final void b(View paramAnonymousView)
    {
      paramAnonymousView = gn.this;
      paramAnonymousView.n = null;
      paramAnonymousView.c.requestLayout();
    }
  };
  final fc r = new fc()
  {
    public final void a()
    {
      ((View)gn.this.c.getParent()).invalidate();
    }
  };
  private Context v;
  private Activity w;
  private Dialog x;
  private ArrayList<Object> y = new ArrayList();
  private int z = -1;
  
  public gn(Activity paramActivity, boolean paramBoolean)
  {
    this.w = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    a(paramActivity);
    if (!paramBoolean) {
      this.f = paramActivity.findViewById(16908290);
    }
  }
  
  public gn(Dialog paramDialog)
  {
    this.x = paramDialog;
    a(paramDialog.getWindow().getDecorView());
  }
  
  private void a(View paramView)
  {
    this.b = ((ActionBarOverlayLayout)paramView.findViewById(go.f.decor_content_parent));
    ActionBarOverlayLayout localActionBarOverlayLayout = this.b;
    if (localActionBarOverlayLayout != null) {
      localActionBarOverlayLayout.setActionBarVisibilityCallback(this);
    }
    this.d = b(paramView.findViewById(go.f.action_bar));
    this.e = ((ActionBarContextView)paramView.findViewById(go.f.action_context_bar));
    this.c = ((ActionBarContainer)paramView.findViewById(go.f.action_bar_container));
    paramView = this.d;
    if ((paramView != null) && (this.e != null) && (this.c != null))
    {
      this.a = paramView.b();
      if ((this.d.m() & 0x4) != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        this.A = true;
      }
      paramView = gv.a(this.a);
      paramView.c();
      f(paramView.b());
      paramView = this.a.obtainStyledAttributes(null, go.j.ActionBar, go.a.actionBarStyle, 0);
      if (paramView.getBoolean(go.j.ActionBar_hideOnContentScroll, false)) {
        c();
      }
      int i1 = paramView.getDimensionPixelSize(go.j.ActionBar_elevation, 0);
      if (i1 != 0) {
        a(i1);
      }
      paramView.recycle();
      return;
    }
    paramView = new StringBuilder();
    paramView.append(getClass().getSimpleName());
    paramView.append(" can only be used with a compatible window decor layout");
    throw new IllegalStateException(paramView.toString());
  }
  
  static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {
      return true;
    }
    return (!paramBoolean1) && (!paramBoolean2);
  }
  
  private static ip b(View paramView)
  {
    if ((paramView instanceof ip)) {
      return (ip)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    if ("Can't make a decor toolbar out of ".concat(String.valueOf(paramView)) != null) {
      paramView = paramView.getClass().getSimpleName();
    } else {
      paramView = "null";
    }
    throw new IllegalStateException(paramView);
  }
  
  private void f(boolean paramBoolean)
  {
    this.D = paramBoolean;
    if (!this.D)
    {
      this.d.a(null);
      this.c.setTabContainer(this.g);
    }
    else
    {
      this.c.setTabContainer(null);
      this.d.a(this.g);
    }
    int i1 = l();
    boolean bool = true;
    if (i1 == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = this.g;
    if (localObject != null) {
      if (i1 != 0)
      {
        ((iy)localObject).setVisibility(0);
        localObject = this.b;
        if (localObject != null) {
          ew.j((View)localObject);
        }
      }
      else
      {
        ((iy)localObject).setVisibility(8);
      }
    }
    localObject = this.d;
    if ((!this.D) && (i1 != 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((ip)localObject).a(paramBoolean);
    localObject = this.b;
    if ((!this.D) && (i1 != 0)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
  }
  
  private void g(boolean paramBoolean)
  {
    if (a(this.l, this.m, this.F))
    {
      if (!this.G)
      {
        this.G = true;
        h(paramBoolean);
      }
    }
    else if (this.G)
    {
      this.G = false;
      i(paramBoolean);
    }
  }
  
  private void h(boolean paramBoolean)
  {
    Object localObject1 = this.n;
    if (localObject1 != null) {
      ((hc)localObject1).b();
    }
    this.c.setVisibility(0);
    if ((this.E == 0) && ((this.H) || (paramBoolean)))
    {
      this.c.setTranslationY(0.0F);
      float f2 = -this.c.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject1 = new int[2];
        Object tmp73_71 = localObject1;
        tmp73_71[0] = 0;
        Object tmp77_73 = tmp73_71;
        tmp77_73[1] = 0;
        tmp77_73;
        this.c.getLocationInWindow((int[])localObject1);
        f1 = f2 - localObject1[1];
      }
      this.c.setTranslationY(f1);
      localObject1 = new hc();
      Object localObject2 = ew.f(this.c).b(0.0F);
      ((ez)localObject2).a(this.r);
      ((hc)localObject1).a((ez)localObject2);
      if (this.k)
      {
        localObject2 = this.f;
        if (localObject2 != null)
        {
          ((View)localObject2).setTranslationY(f1);
          ((hc)localObject1).a(ew.f(this.f).b(0.0F));
        }
      }
      ((hc)localObject1).a(u);
      ((hc)localObject1).c();
      ((hc)localObject1).a(this.q);
      this.n = ((hc)localObject1);
      ((hc)localObject1).a();
    }
    else
    {
      this.c.setAlpha(1.0F);
      this.c.setTranslationY(0.0F);
      if (this.k)
      {
        localObject1 = this.f;
        if (localObject1 != null) {
          ((View)localObject1).setTranslationY(0.0F);
        }
      }
      this.q.b(null);
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ew.j((View)localObject1);
    }
  }
  
  private void i(boolean paramBoolean)
  {
    hc localhc = this.n;
    if (localhc != null) {
      localhc.b();
    }
    if ((this.E == 0) && ((this.H) || (paramBoolean)))
    {
      this.c.setAlpha(1.0F);
      this.c.setTransitioning(true);
      localhc = new hc();
      float f2 = -this.c.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp82_80 = localObject;
        tmp82_80[0] = 0;
        Object tmp86_82 = tmp82_80;
        tmp86_82[1] = 0;
        tmp86_82;
        this.c.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = ew.f(this.c).b(f1);
      ((ez)localObject).a(this.r);
      localhc.a((ez)localObject);
      if (this.k)
      {
        localObject = this.f;
        if (localObject != null) {
          localhc.a(ew.f((View)localObject).b(f1));
        }
      }
      localhc.a(t);
      localhc.c();
      localhc.a(this.p);
      this.n = localhc;
      localhc.a();
      return;
    }
    this.p.b(null);
  }
  
  private int l()
  {
    return this.d.n();
  }
  
  private void m()
  {
    if (!this.F)
    {
      this.F = true;
      ActionBarOverlayLayout localActionBarOverlayLayout = this.b;
      if (localActionBarOverlayLayout != null) {
        localActionBarOverlayLayout.setShowingForActionMode(true);
      }
      g(false);
    }
  }
  
  private void n()
  {
    if (this.F)
    {
      this.F = false;
      ActionBarOverlayLayout localActionBarOverlayLayout = this.b;
      if (localActionBarOverlayLayout != null) {
        localActionBarOverlayLayout.setShowingForActionMode(false);
      }
      g(false);
    }
  }
  
  public final int a()
  {
    return this.d.m();
  }
  
  public final gw a(gw.a parama)
  {
    a locala = this.h;
    if (locala != null) {
      locala.c();
    }
    this.b.setHideOnContentScrollEnabled(false);
    this.e.c();
    parama = new a(this.e.getContext(), parama);
    if (parama.e())
    {
      this.h = parama;
      parama.d();
      this.e.a(parama);
      e(true);
      this.e.sendAccessibilityEvent(32);
      return parama;
    }
    return null;
  }
  
  public final void a(float paramFloat)
  {
    ew.a(this.c, paramFloat);
  }
  
  public final void a(int paramInt)
  {
    this.d.d(paramInt);
  }
  
  public final void a(Configuration paramConfiguration)
  {
    f(gv.a(this.a).b());
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.d.a(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!this.A)
    {
      int i1;
      if (paramBoolean) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      int i2 = this.d.m();
      this.A = true;
      this.d.c(i1 & 0x4 | i2 & 0xFFFFFFFB);
    }
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = this.h;
    if (localObject == null) {
      return false;
    }
    localObject = ((a)localObject).a;
    if (localObject != null)
    {
      if (paramKeyEvent != null) {
        i1 = paramKeyEvent.getDeviceId();
      } else {
        i1 = -1;
      }
      int i1 = KeyCharacterMap.load(i1).getKeyboardType();
      boolean bool = true;
      if (i1 == 1) {
        bool = false;
      }
      ((Menu)localObject).setQwertyMode(bool);
      return ((Menu)localObject).performShortcut(paramInt, paramKeyEvent, 0);
    }
    return false;
  }
  
  public final Context b()
  {
    if (this.v == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.a.getTheme().resolveAttribute(go.a.actionBarWidgetTheme, localTypedValue, true);
      int i1 = localTypedValue.resourceId;
      if (i1 != 0) {
        this.v = new ContextThemeWrapper(this.a, i1);
      } else {
        this.v = this.a;
      }
    }
    return this.v;
  }
  
  public final void b(int paramInt)
  {
    this.E = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.H = paramBoolean;
    if (!paramBoolean)
    {
      hc localhc = this.n;
      if (localhc != null) {
        localhc.b();
      }
    }
  }
  
  public final void c()
  {
    if (this.b.b)
    {
      this.o = true;
      this.b.setHideOnContentScrollEnabled(true);
      return;
    }
    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
  }
  
  public final void c(boolean paramBoolean)
  {
    if (paramBoolean == this.B) {
      return;
    }
    this.B = paramBoolean;
    int i2 = this.C.size();
    int i1 = 0;
    while (i1 < i2)
    {
      this.C.get(i1);
      i1 += 1;
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public final void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      m();
    } else {
      n();
    }
    if (ew.q(this.c))
    {
      ez localez2;
      ez localez1;
      if (paramBoolean)
      {
        localez2 = this.d.a(4, 100L);
        localez1 = this.e.a(0, 200L);
      }
      else
      {
        localez1 = this.d.a(0, 200L);
        localez2 = this.e.a(8, 100L);
      }
      hc localhc = new hc();
      localhc.a(localez2, localez1);
      localhc.a();
      return;
    }
    if (paramBoolean)
    {
      this.d.e(4);
      this.e.setVisibility(0);
      return;
    }
    this.d.e(0);
    this.e.setVisibility(8);
  }
  
  public final boolean g()
  {
    ip localip = this.d;
    if ((localip != null) && (localip.c()))
    {
      this.d.d();
      return true;
    }
    return false;
  }
  
  public final void i()
  {
    if (this.m)
    {
      this.m = false;
      g(true);
    }
  }
  
  public final void j()
  {
    if (!this.m)
    {
      this.m = true;
      g(true);
    }
  }
  
  public final void k()
  {
    hc localhc = this.n;
    if (localhc != null)
    {
      localhc.b();
      this.n = null;
    }
  }
  
  public final class a
    extends gw
    implements hl.a
  {
    final hl a;
    private final Context e;
    private gw.a f;
    private WeakReference<View> g;
    
    public a(Context paramContext, gw.a parama)
    {
      this.e = paramContext;
      this.f = parama;
      this$1 = new hl(paramContext);
      gn.this.e = 1;
      this.a = gn.this;
      this.a.a(this);
    }
    
    public final MenuInflater a()
    {
      return new hb(this.e);
    }
    
    public final void a(int paramInt)
    {
      b(gn.this.a.getResources().getString(paramInt));
    }
    
    public final void a(View paramView)
    {
      gn.this.e.setCustomView(paramView);
      this.g = new WeakReference(paramView);
    }
    
    public final void a(hl paramhl)
    {
      if (this.f == null) {
        return;
      }
      d();
      gn.this.e.a();
    }
    
    public final void a(CharSequence paramCharSequence)
    {
      gn.this.e.setSubtitle(paramCharSequence);
    }
    
    public final void a(boolean paramBoolean)
    {
      super.a(paramBoolean);
      gn.this.e.setTitleOptional(paramBoolean);
    }
    
    public final boolean a(hl paramhl, MenuItem paramMenuItem)
    {
      paramhl = this.f;
      if (paramhl != null) {
        return paramhl.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final Menu b()
    {
      return this.a;
    }
    
    public final void b(int paramInt)
    {
      a(gn.this.a.getResources().getString(paramInt));
    }
    
    public final void b(CharSequence paramCharSequence)
    {
      gn.this.e.setTitle(paramCharSequence);
    }
    
    public final void c()
    {
      if (gn.this.h != this) {
        return;
      }
      if (!gn.a(gn.this.l, gn.this.m, false))
      {
        gn localgn = gn.this;
        localgn.i = this;
        localgn.j = this.f;
      }
      else
      {
        this.f.a(this);
      }
      this.f = null;
      gn.this.e(false);
      gn.this.e.b();
      gn.this.d.a().sendAccessibilityEvent(32);
      gn.this.b.setHideOnContentScrollEnabled(gn.this.o);
      gn.this.h = null;
    }
    
    public final void d()
    {
      if (gn.this.h != this) {
        return;
      }
      this.a.d();
      try
      {
        this.f.b(this, this.a);
        return;
      }
      finally
      {
        this.a.e();
      }
    }
    
    public final boolean e()
    {
      this.a.d();
      try
      {
        boolean bool = this.f.a(this, this.a);
        return bool;
      }
      finally
      {
        this.a.e();
      }
    }
    
    public final CharSequence f()
    {
      return gn.this.e.getTitle();
    }
    
    public final CharSequence g()
    {
      return gn.this.e.getSubtitle();
    }
    
    public final boolean h()
    {
      return gn.this.e.g;
    }
    
    public final View i()
    {
      WeakReference localWeakReference = this.g;
      if (localWeakReference != null) {
        return (View)localWeakReference.get();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gn
 * JD-Core Version:    0.7.0.1
 */