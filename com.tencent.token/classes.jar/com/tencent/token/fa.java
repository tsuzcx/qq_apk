package com.tencent.token;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class fa
{
  static final j a = new j();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      a = new i();
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      a = new h();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      a = new g();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new f();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new e();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      a = new d();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new a();
      return;
    }
  }
  
  public static fh a(View paramView, fh paramfh)
  {
    return a.a(paramView, paramfh);
  }
  
  public static void a(View paramView)
  {
    a.b(paramView);
  }
  
  public static void a(View paramView, float paramFloat)
  {
    a.a(paramView, paramFloat);
  }
  
  public static void a(View paramView, int paramInt)
  {
    a.a(paramView, paramInt);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, ColorStateList paramColorStateList)
  {
    a.a(paramView, paramColorStateList);
  }
  
  public static void a(View paramView, Paint paramPaint)
  {
    a.a(paramView, paramPaint);
  }
  
  public static void a(View paramView, PorterDuff.Mode paramMode)
  {
    a.a(paramView, paramMode);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    a.a(paramView, paramDrawable);
  }
  
  public static void a(View paramView, el paramel)
  {
    j.a(paramView, paramel);
  }
  
  public static void a(View paramView, ex paramex)
  {
    a.a(paramView, paramex);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    a.a(paramView, paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    a.a(paramView, paramRunnable, paramLong);
  }
  
  public static void a(View paramView, String paramString)
  {
    a.a(paramView, paramString);
  }
  
  public static int b(View paramView)
  {
    return a.c(paramView);
  }
  
  public static fh b(View paramView, fh paramfh)
  {
    return a.b(paramView, paramfh);
  }
  
  public static void b(View paramView, int paramInt)
  {
    a.c(paramView, paramInt);
  }
  
  public static int c(View paramView)
  {
    return a.i(paramView);
  }
  
  public static void c(View paramView, int paramInt)
  {
    a.b(paramView, paramInt);
  }
  
  public static ViewParent d(View paramView)
  {
    return a.d(paramView);
  }
  
  public static void d(View paramView, int paramInt)
  {
    a.d(paramView, paramInt);
  }
  
  public static int e(View paramView)
  {
    return a.e(paramView);
  }
  
  public static fd f(View paramView)
  {
    j localj = a;
    if (localj.a == null) {
      localj.a = new WeakHashMap();
    }
    fd localfd2 = (fd)localj.a.get(paramView);
    fd localfd1 = localfd2;
    if (localfd2 == null)
    {
      localfd1 = new fd(paramView);
      localj.a.put(paramView, localfd1);
    }
    return localfd1;
  }
  
  public static float g(View paramView)
  {
    return a.n(paramView);
  }
  
  public static String h(View paramView)
  {
    return a.m(paramView);
  }
  
  public static int i(View paramView)
  {
    return a.j(paramView);
  }
  
  public static void j(View paramView)
  {
    a.f(paramView);
  }
  
  public static boolean k(View paramView)
  {
    return a.g(paramView);
  }
  
  public static boolean l(View paramView)
  {
    return a.h(paramView);
  }
  
  public static ColorStateList m(View paramView)
  {
    return a.r(paramView);
  }
  
  public static PorterDuff.Mode n(View paramView)
  {
    return a.s(paramView);
  }
  
  public static boolean o(View paramView)
  {
    return a.p(paramView);
  }
  
  public static void p(View paramView)
  {
    a.q(paramView);
  }
  
  public static boolean q(View paramView)
  {
    return a.k(paramView);
  }
  
  public static float r(View paramView)
  {
    return a.t(paramView);
  }
  
  public static boolean s(View paramView)
  {
    return a.l(paramView);
  }
  
  public static boolean t(View paramView)
  {
    return a.a(paramView);
  }
  
  static class a
    extends fa.j
  {
    public final boolean a(View paramView)
    {
      return paramView.hasOnClickListeners();
    }
  }
  
  static class b
    extends fa.a
  {
    public void a(View paramView, int paramInt)
    {
      int i = paramInt;
      if (paramInt == 4) {
        i = 2;
      }
      paramView.setImportantForAccessibility(i);
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public final void a(View paramView, Drawable paramDrawable)
    {
      paramView.setBackground(paramDrawable);
    }
    
    public final void a(View paramView, Runnable paramRunnable)
    {
      paramView.postOnAnimation(paramRunnable);
    }
    
    public final void a(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
    }
    
    public final void b(View paramView)
    {
      paramView.postInvalidateOnAnimation();
    }
    
    public final int c(View paramView)
    {
      return paramView.getImportantForAccessibility();
    }
    
    public final ViewParent d(View paramView)
    {
      return paramView.getParentForAccessibility();
    }
    
    public final int e(View paramView)
    {
      return paramView.getMinimumHeight();
    }
    
    public void f(View paramView)
    {
      paramView.requestFitSystemWindows();
    }
    
    public final boolean g(View paramView)
    {
      return paramView.getFitsSystemWindows();
    }
    
    public final boolean h(View paramView)
    {
      return paramView.hasOverlappingRendering();
    }
  }
  
  static class c
    extends fa.b
  {
    public final void a(View paramView, Paint paramPaint)
    {
      paramView.setLayerPaint(paramPaint);
    }
    
    public final int i(View paramView)
    {
      return paramView.getLayoutDirection();
    }
    
    public final int j(View paramView)
    {
      return paramView.getWindowSystemUiVisibility();
    }
  }
  
  static class d
    extends fa.c
  {}
  
  static class e
    extends fa.d
  {
    public final void a(View paramView, int paramInt)
    {
      paramView.setImportantForAccessibility(paramInt);
    }
    
    public final boolean k(View paramView)
    {
      return paramView.isLaidOut();
    }
    
    public final boolean l(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
  }
  
  static class f
    extends fa.e
  {
    private static ThreadLocal<Rect> c;
    
    private static Rect a()
    {
      if (c == null) {
        c = new ThreadLocal();
      }
      Rect localRect2 = (Rect)c.get();
      Rect localRect1 = localRect2;
      if (localRect2 == null)
      {
        localRect1 = new Rect();
        c.set(localRect1);
      }
      localRect1.setEmpty();
      return localRect1;
    }
    
    public final fh a(View paramView, fh paramfh)
    {
      paramfh = (WindowInsets)fh.a(paramfh);
      WindowInsets localWindowInsets = paramView.onApplyWindowInsets(paramfh);
      paramView = paramfh;
      if (localWindowInsets != paramfh) {
        paramView = new WindowInsets(localWindowInsets);
      }
      return fh.a(paramView);
    }
    
    public final void a(View paramView, float paramFloat)
    {
      paramView.setElevation(paramFloat);
    }
    
    public final void a(View paramView, ColorStateList paramColorStateList)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramView.getBackground();
        int i;
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramColorStateList);
        }
      }
    }
    
    public final void a(View paramView, PorterDuff.Mode paramMode)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramView.getBackground();
        int i;
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramView.getDrawableState());
          }
          paramView.setBackground(paramMode);
        }
      }
    }
    
    public final void a(View paramView, final ex paramex)
    {
      if (paramex == null)
      {
        paramView.setOnApplyWindowInsetsListener(null);
        return;
      }
      paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          paramAnonymousWindowInsets = fh.a(paramAnonymousWindowInsets);
          return (WindowInsets)fh.a(paramex.a(paramAnonymousView, paramAnonymousWindowInsets));
        }
      });
    }
    
    public final void a(View paramView, String paramString)
    {
      paramView.setTransitionName(paramString);
    }
    
    public final fh b(View paramView, fh paramfh)
    {
      paramfh = (WindowInsets)fh.a(paramfh);
      WindowInsets localWindowInsets = paramView.dispatchApplyWindowInsets(paramfh);
      paramView = paramfh;
      if (localWindowInsets != paramfh) {
        paramView = new WindowInsets(localWindowInsets);
      }
      return fh.a(paramView);
    }
    
    public void b(View paramView, int paramInt)
    {
      Rect localRect = a();
      ViewParent localViewParent = paramView.getParent();
      boolean bool;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
      }
      else
      {
        bool = false;
      }
      super.b(paramView, paramInt);
      if ((bool) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
    }
    
    public void c(View paramView, int paramInt)
    {
      Rect localRect = a();
      ViewParent localViewParent = paramView.getParent();
      boolean bool;
      if ((localViewParent instanceof View))
      {
        View localView = (View)localViewParent;
        localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        bool = localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()) ^ true;
      }
      else
      {
        bool = false;
      }
      super.c(paramView, paramInt);
      if ((bool) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
    }
    
    public final void f(View paramView)
    {
      paramView.requestApplyInsets();
    }
    
    public final String m(View paramView)
    {
      return paramView.getTransitionName();
    }
    
    public final float n(View paramView)
    {
      return paramView.getElevation();
    }
    
    public final float o(View paramView)
    {
      return paramView.getTranslationZ();
    }
    
    public final boolean p(View paramView)
    {
      return paramView.isNestedScrollingEnabled();
    }
    
    public final void q(View paramView)
    {
      paramView.stopNestedScroll();
    }
    
    public final ColorStateList r(View paramView)
    {
      return paramView.getBackgroundTintList();
    }
    
    public final PorterDuff.Mode s(View paramView)
    {
      return paramView.getBackgroundTintMode();
    }
    
    public final float t(View paramView)
    {
      return paramView.getZ();
    }
  }
  
  static class g
    extends fa.f
  {
    public final void b(View paramView, int paramInt)
    {
      paramView.offsetLeftAndRight(paramInt);
    }
    
    public final void c(View paramView, int paramInt)
    {
      paramView.offsetTopAndBottom(paramInt);
    }
    
    public final void d(View paramView, int paramInt)
    {
      paramView.setScrollIndicators(paramInt, 3);
    }
  }
  
  static class h
    extends fa.g
  {}
  
  static final class i
    extends fa.h
  {}
  
  static class j
  {
    static boolean b = false;
    private static Field c;
    private static boolean d;
    private static WeakHashMap<View, String> e;
    private static final AtomicInteger f = new AtomicInteger(1);
    WeakHashMap<View, fd> a = null;
    
    public static void a(View paramView, el paramel)
    {
      if (paramel == null) {
        paramel = null;
      } else {
        paramel = paramel.a;
      }
      paramView.setAccessibilityDelegate(paramel);
    }
    
    private static void u(View paramView)
    {
      float f1 = paramView.getTranslationY();
      paramView.setTranslationY(1.0F + f1);
      paramView.setTranslationY(f1);
    }
    
    public fh a(View paramView, fh paramfh)
    {
      return paramfh;
    }
    
    public void a(View paramView, float paramFloat) {}
    
    public void a(View paramView, int paramInt) {}
    
    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void a(View paramView, ColorStateList paramColorStateList)
    {
      if ((paramView instanceof ez)) {
        ((ez)paramView).setSupportBackgroundTintList(paramColorStateList);
      }
    }
    
    public void a(View paramView, Paint paramPaint)
    {
      paramView.setLayerType(paramView.getLayerType(), paramPaint);
      paramView.invalidate();
    }
    
    public void a(View paramView, PorterDuff.Mode paramMode)
    {
      if ((paramView instanceof ez)) {
        ((ez)paramView).setSupportBackgroundTintMode(paramMode);
      }
    }
    
    public void a(View paramView, Drawable paramDrawable)
    {
      paramView.setBackgroundDrawable(paramDrawable);
    }
    
    public void a(View paramView, ex paramex) {}
    
    public void a(View paramView, Runnable paramRunnable)
    {
      paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
    }
    
    public void a(View paramView, Runnable paramRunnable, long paramLong)
    {
      paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay() + paramLong);
    }
    
    public void a(View paramView, String paramString)
    {
      if (e == null) {
        e = new WeakHashMap();
      }
      e.put(paramView, paramString);
    }
    
    public boolean a(View paramView)
    {
      return false;
    }
    
    public fh b(View paramView, fh paramfh)
    {
      return paramfh;
    }
    
    public void b(View paramView)
    {
      paramView.postInvalidate();
    }
    
    public void b(View paramView, int paramInt)
    {
      paramView.offsetLeftAndRight(paramInt);
      if (paramView.getVisibility() == 0)
      {
        u(paramView);
        paramView = paramView.getParent();
        if ((paramView instanceof View)) {
          u((View)paramView);
        }
      }
    }
    
    public int c(View paramView)
    {
      return 0;
    }
    
    public void c(View paramView, int paramInt)
    {
      paramView.offsetTopAndBottom(paramInt);
      if (paramView.getVisibility() == 0)
      {
        u(paramView);
        paramView = paramView.getParent();
        if ((paramView instanceof View)) {
          u((View)paramView);
        }
      }
    }
    
    public ViewParent d(View paramView)
    {
      return paramView.getParent();
    }
    
    public void d(View paramView, int paramInt) {}
    
    public int e(View paramView)
    {
      if (!d) {}
      try
      {
        Field localField = View.class.getDeclaredField("mMinHeight");
        c = localField;
        localField.setAccessible(true);
        label23:
        d = true;
        localField = c;
        if (localField != null) {}
        try
        {
          int i = ((Integer)localField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView)
        {
          label49:
          break label49;
        }
        return 0;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label23;
      }
    }
    
    public void f(View paramView) {}
    
    public boolean g(View paramView)
    {
      return false;
    }
    
    public boolean h(View paramView)
    {
      return true;
    }
    
    public int i(View paramView)
    {
      return 0;
    }
    
    public int j(View paramView)
    {
      return 0;
    }
    
    public boolean k(View paramView)
    {
      return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
    }
    
    public boolean l(View paramView)
    {
      return paramView.getWindowToken() != null;
    }
    
    public String m(View paramView)
    {
      WeakHashMap localWeakHashMap = e;
      if (localWeakHashMap == null) {
        return null;
      }
      return (String)localWeakHashMap.get(paramView);
    }
    
    public float n(View paramView)
    {
      return 0.0F;
    }
    
    public float o(View paramView)
    {
      return 0.0F;
    }
    
    public boolean p(View paramView)
    {
      if ((paramView instanceof er)) {
        return ((er)paramView).isNestedScrollingEnabled();
      }
      return false;
    }
    
    public void q(View paramView)
    {
      if ((paramView instanceof er)) {
        ((er)paramView).stopNestedScroll();
      }
    }
    
    public ColorStateList r(View paramView)
    {
      if ((paramView instanceof ez)) {
        return ((ez)paramView).getSupportBackgroundTintList();
      }
      return null;
    }
    
    public PorterDuff.Mode s(View paramView)
    {
      if ((paramView instanceof ez)) {
        return ((ez)paramView).getSupportBackgroundTintMode();
      }
      return null;
    }
    
    public float t(View paramView)
    {
      return o(paramView) + n(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fa
 * JD-Core Version:    0.7.0.1
 */