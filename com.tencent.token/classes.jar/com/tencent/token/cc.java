package com.tencent.token;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.c;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.support.v4.app.LoaderManagerImpl;
import android.support.v4.app.LoaderManagerImpl.LoaderViewModel;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class cc
  extends cb
  implements LayoutInflater.Factory2
{
  static final Interpolator F = new DecelerateInterpolator(2.5F);
  static final Interpolator G = new DecelerateInterpolator(1.5F);
  static final Interpolator H = new AccelerateInterpolator(2.5F);
  static final Interpolator I = new AccelerateInterpolator(1.5F);
  public static boolean a = false;
  static Field q;
  Bundle A = null;
  SparseArray<Parcelable> B = null;
  ArrayList<h> C;
  public cd D;
  Runnable E = new Runnable()
  {
    public final void run()
    {
      cc.this.h();
    }
  };
  private final CopyOnWriteArrayList<ed<Object, Boolean>> J = new CopyOnWriteArrayList();
  ArrayList<g> b;
  boolean c;
  int d = 0;
  final ArrayList<Fragment> e = new ArrayList();
  public SparseArray<Fragment> f;
  ArrayList<bv> g;
  ArrayList<Fragment> h;
  ArrayList<bv> i;
  ArrayList<Integer> j;
  ArrayList<Object> k;
  public int l = 0;
  public ca m;
  by n;
  Fragment o;
  Fragment p;
  boolean r;
  boolean s;
  boolean t;
  boolean u;
  String v;
  boolean w;
  ArrayList<bv> x;
  ArrayList<Boolean> y;
  ArrayList<Fragment> z;
  
  private void A()
  {
    SparseArray localSparseArray = this.f;
    if (localSparseArray != null)
    {
      int i1 = localSparseArray.size() - 1;
      while (i1 >= 0)
      {
        if (this.f.valueAt(i1) == null)
        {
          localSparseArray = this.f;
          localSparseArray.delete(localSparseArray.keyAt(i1));
        }
        i1 -= 1;
      }
    }
  }
  
  private int a(ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, dw<Fragment> paramdw)
  {
    int i1 = paramInt2 - 1;
    int i3;
    for (int i2 = paramInt2; i1 >= paramInt1; i2 = i3)
    {
      bv localbv = (bv)paramArrayList.get(i1);
      boolean bool = ((Boolean)paramArrayList1.get(i1)).booleanValue();
      i3 = 0;
      int i4;
      for (;;)
      {
        int i5 = localbv.b.size();
        i4 = 1;
        if (i3 >= i5) {
          break;
        }
        if (bv.b((bv.a)localbv.b.get(i3)))
        {
          i3 = 1;
          break label101;
        }
        i3 += 1;
      }
      i3 = 0;
      label101:
      if ((i3 == 0) || (localbv.a(paramArrayList, i1 + 1, paramInt2))) {
        i4 = 0;
      }
      i3 = i2;
      if (i4 != 0)
      {
        if (this.C == null) {
          this.C = new ArrayList();
        }
        h localh = new h(localbv, bool);
        this.C.add(localh);
        localbv.a(localh);
        if (bool) {
          localbv.c();
        } else {
          localbv.a(false);
        }
        i3 = i2 - 1;
        if (i1 != i3)
        {
          paramArrayList.remove(i1);
          paramArrayList.add(i3, localbv);
        }
        b(paramdw);
      }
      i1 -= 1;
    }
    return i2;
  }
  
  private Fragment a(Bundle paramBundle, String paramString)
  {
    int i1 = paramBundle.getInt(paramString, -1);
    if (i1 == -1) {
      return null;
    }
    paramBundle = (Fragment)this.f.get(i1);
    if (paramBundle == null)
    {
      StringBuilder localStringBuilder = new StringBuilder("Fragment no longer exists for key ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": index ");
      localStringBuilder.append(i1);
      a(new IllegalStateException(localStringBuilder.toString()));
    }
    return paramBundle;
  }
  
  private static Animation.AnimationListener a(Animation paramAnimation)
  {
    try
    {
      if (q == null)
      {
        Field localField = Animation.class.getDeclaredField("mListener");
        q = localField;
        localField.setAccessible(true);
      }
      paramAnimation = (Animation.AnimationListener)q.get(paramAnimation);
      return paramAnimation;
    }
    catch (NoSuchFieldException|IllegalAccessException paramAnimation)
    {
      label38:
      break label38;
    }
    return null;
  }
  
  private static c a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(G);
    localAlphaAnimation.setDuration(220L);
    return new c(localAlphaAnimation, (byte)0);
  }
  
  private static c a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(F);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(G);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return new c(localAnimationSet, (byte)0);
  }
  
  private c a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i2 = paramFragment.s();
    boolean bool;
    if (i2 != 0)
    {
      bool = "anim".equals(this.m.c.getResources().getResourceTypeName(i2));
      if (!bool) {}
    }
    try
    {
      try
      {
        paramFragment = AnimationUtils.loadAnimation(this.m.c, i2);
        if (paramFragment != null)
        {
          paramFragment = new c(paramFragment, (byte)0);
          return paramFragment;
        }
        i1 = 1;
      }
      catch (Resources.NotFoundException paramFragment)
      {
        throw paramFragment;
      }
    }
    catch (RuntimeException paramFragment)
    {
      int i1;
      label77:
      break label77;
    }
    i1 = 0;
    if (i1 == 0) {
      try
      {
        paramFragment = AnimatorInflater.loadAnimator(this.m.c, i2);
        if (paramFragment != null)
        {
          paramFragment = new c(paramFragment, (byte)0);
          return paramFragment;
        }
      }
      catch (RuntimeException paramFragment)
      {
        if (!bool)
        {
          paramFragment = AnimationUtils.loadAnimation(this.m.c, i2);
          if (paramFragment != null) {
            return new c(paramFragment, (byte)0);
          }
        }
        else
        {
          throw paramFragment;
        }
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    i1 = -1;
    if (paramInt1 != 4097)
    {
      if (paramInt1 != 4099)
      {
        if (paramInt1 != 8194) {
          paramInt1 = i1;
        } else if (paramBoolean) {
          paramInt1 = 3;
        } else {
          paramInt1 = 4;
        }
      }
      else if (paramBoolean) {
        paramInt1 = 5;
      } else {
        paramInt1 = 6;
      }
    }
    else if (paramBoolean) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    if (paramInt1 < 0) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.m.e()) {
          paramInt1 = this.m.f();
        }
      }
      break;
    case 6: 
      return a(1.0F, 0.0F);
    case 5: 
      return a(0.0F, 1.0F);
    case 4: 
      return a(1.0F, 1.075F, 1.0F, 0.0F);
    case 3: 
      return a(0.975F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return a(1.0F, 0.975F, 1.0F, 0.0F);
    case 1: 
      return a(1.125F, 1.0F, 0.0F, 1.0F);
    }
    if (paramInt1 == 0) {
      return null;
    }
    return null;
  }
  
  private void a(int paramInt, bv parambv)
  {
    try
    {
      if (this.i == null) {
        this.i = new ArrayList();
      }
      int i2 = this.i.size();
      int i1 = i2;
      StringBuilder localStringBuilder;
      if (paramInt < i2)
      {
        if (a)
        {
          localStringBuilder = new StringBuilder("Setting back stack index ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" to ");
          localStringBuilder.append(parambv);
        }
        this.i.set(paramInt, parambv);
      }
      else
      {
        while (i1 < paramInt)
        {
          this.i.add(null);
          if (this.j == null) {
            this.j = new ArrayList();
          }
          this.j.add(Integer.valueOf(i1));
          i1 += 1;
        }
        if (a)
        {
          localStringBuilder = new StringBuilder("Adding back stack index ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" with ");
          localStringBuilder.append(parambv);
        }
        this.i.add(parambv);
      }
      return;
    }
    finally {}
  }
  
  private void a(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.f < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not currently in the FragmentManager");
      a(new IllegalStateException(localStringBuilder.toString()));
    }
    paramBundle.putInt(paramString, paramFragment.f);
  }
  
  private void a(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).a(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      paramContext = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramContext.b).booleanValue();
      }
    }
  }
  
  private void a(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).a(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.b).booleanValue();
      }
    }
  }
  
  private void a(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).a(paramFragment, paramView, paramBundle, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      paramView = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramView.b).booleanValue();
      }
    }
  }
  
  private static void a(View paramView, c paramc)
  {
    if (paramView != null)
    {
      if (paramc == null) {
        return;
      }
      int i2 = 0;
      int i1 = i2;
      Object localObject;
      if (paramView != null) {
        if (paramc == null)
        {
          i1 = i2;
        }
        else
        {
          i1 = i2;
          if (Build.VERSION.SDK_INT >= 19)
          {
            i1 = i2;
            if (paramView.getLayerType() == 0)
            {
              i1 = i2;
              if (ex.l(paramView))
              {
                boolean bool;
                if ((paramc.a instanceof AlphaAnimation))
                {
                  bool = true;
                }
                else if ((paramc.a instanceof AnimationSet))
                {
                  localObject = ((AnimationSet)paramc.a).getAnimations();
                  i1 = 0;
                  while (i1 < ((List)localObject).size())
                  {
                    if ((((List)localObject).get(i1) instanceof AlphaAnimation))
                    {
                      bool = true;
                      break label147;
                    }
                    i1 += 1;
                  }
                  bool = false;
                }
                else
                {
                  bool = a(paramc.b);
                }
                label147:
                i1 = i2;
                if (bool) {
                  i1 = 1;
                }
              }
            }
          }
        }
      }
      if (i1 != 0)
      {
        if (paramc.b != null)
        {
          paramc.b.addListener(new d(paramView));
          return;
        }
        localObject = a(paramc.a);
        paramView.setLayerType(2, null);
        paramc.a.setAnimationListener(new a(paramView, (Animation.AnimationListener)localObject));
      }
      return;
    }
  }
  
  public static void a(cd paramcd)
  {
    if (paramcd == null) {
      return;
    }
    Object localObject = paramcd.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Fragment)((Iterator)localObject).next()).E = true;
      }
    }
    paramcd = paramcd.b;
    if (paramcd != null)
    {
      paramcd = paramcd.iterator();
      while (paramcd.hasNext()) {
        a((cd)paramcd.next());
      }
    }
  }
  
  private static void a(dw<Fragment> paramdw)
  {
    int i2 = paramdw.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Fragment localFragment = (Fragment)paramdw.a[i1];
      if (!localFragment.l)
      {
        View localView = localFragment.J;
        localFragment.R = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i1 += 1;
    }
  }
  
  private void a(RuntimeException paramRuntimeException)
  {
    paramRuntimeException.getMessage();
    PrintWriter localPrintWriter = new PrintWriter(new dz("FragmentManager"));
    ca localca = this.m;
    if (localca != null) {}
    try
    {
      localca.a("  ", localPrintWriter, new String[0]);
    }
    catch (Exception localException)
    {
      break label60;
    }
    a("  ", null, localPrintWriter, new String[0]);
    label60:
    throw paramRuntimeException;
  }
  
  private void a(ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    Object localObject = this.C;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((ArrayList)localObject).size();
    }
    int i3 = 0;
    int i2 = i1;
    int i1 = i3;
    while (i1 < i2)
    {
      localObject = (h)this.C.get(i1);
      int i4;
      if ((paramArrayList != null) && (!((h)localObject).a))
      {
        i3 = paramArrayList.indexOf(((h)localObject).b);
        if ((i3 != -1) && (((Boolean)paramArrayList1.get(i3)).booleanValue()))
        {
          ((h)localObject).d();
          i4 = i1;
          i3 = i2;
          break label240;
        }
      }
      if (((h)localObject).c == 0) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if (i3 == 0)
      {
        i4 = i1;
        i3 = i2;
        if (paramArrayList != null)
        {
          i4 = i1;
          i3 = i2;
          if (!((h)localObject).b.a(paramArrayList, 0, paramArrayList.size())) {}
        }
      }
      else
      {
        this.C.remove(i1);
        i4 = i1 - 1;
        i3 = i2 - 1;
        if ((paramArrayList != null) && (!((h)localObject).a))
        {
          i1 = paramArrayList.indexOf(((h)localObject).b);
          if ((i1 != -1) && (((Boolean)paramArrayList1.get(i1)).booleanValue()))
          {
            ((h)localObject).d();
            break label240;
          }
        }
        ((h)localObject).c();
      }
      label240:
      i1 = i4 + 1;
      i2 = i3;
    }
  }
  
  private void a(ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    boolean bool = ((bv)paramArrayList.get(i1)).t;
    Object localObject = this.z;
    if (localObject == null) {
      this.z = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    this.z.addAll(this.e);
    localObject = this.p;
    int i3 = i1;
    int i2 = 0;
    while (i3 < paramInt2)
    {
      bv localbv = (bv)paramArrayList.get(i3);
      if (!((Boolean)paramArrayList1.get(i3)).booleanValue()) {
        localObject = localbv.a(this.z, (Fragment)localObject);
      } else {
        localObject = localbv.b(this.z, (Fragment)localObject);
      }
      if ((i2 == 0) && (!localbv.i)) {
        i2 = 0;
      } else {
        i2 = 1;
      }
      i3 += 1;
    }
    this.z.clear();
    if (!bool) {
      cf.a(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false);
    }
    b(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    int i4;
    if (bool)
    {
      localObject = new dw();
      b((dw)localObject);
      i4 = a(paramArrayList, paramArrayList1, paramInt1, paramInt2, (dw)localObject);
      a((dw)localObject);
    }
    else
    {
      i4 = paramInt2;
    }
    i3 = i1;
    if (i4 != i1)
    {
      i3 = i1;
      if (bool)
      {
        cf.a(this, paramArrayList, paramArrayList1, paramInt1, i4, true);
        a(this.l, true);
        i3 = i1;
      }
    }
    while (i3 < paramInt2)
    {
      localObject = (bv)paramArrayList.get(i3);
      if ((((Boolean)paramArrayList1.get(i3)).booleanValue()) && (((bv)localObject).m >= 0))
      {
        paramInt1 = ((bv)localObject).m;
        try
        {
          this.i.set(paramInt1, null);
          if (this.j == null) {
            this.j = new ArrayList();
          }
          this.j.add(Integer.valueOf(paramInt1));
          ((bv)localObject).m = -1;
        }
        finally {}
      }
      ((bv)localObject).a();
      i3 += 1;
    }
    if (i2 != 0) {
      y();
    }
  }
  
  private static boolean a(Animator paramAnimator)
  {
    if (paramAnimator == null) {
      return false;
    }
    int i1;
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = ((ValueAnimator)paramAnimator).getValues();
      i1 = 0;
      while (i1 < paramAnimator.length)
      {
        if ("alpha".equals(paramAnimator[i1].getPropertyName())) {
          return true;
        }
        i1 += 1;
      }
    }
    if ((paramAnimator instanceof AnimatorSet))
    {
      paramAnimator = ((AnimatorSet)paramAnimator).getChildAnimations();
      i1 = 0;
      while (i1 < paramAnimator.size())
      {
        if (a((Animator)paramAnimator.get(i1))) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    int i1 = 8194;
    if (paramInt != 4097)
    {
      if (paramInt != 4099)
      {
        if (paramInt != 8194) {
          return 0;
        }
        return 4097;
      }
      i1 = 4099;
    }
    return i1;
  }
  
  private void b(Fragment paramFragment, Context paramContext, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).b(paramFragment, paramContext, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      paramContext = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramContext.b).booleanValue();
      }
    }
  }
  
  private void b(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).b(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.b).booleanValue();
      }
    }
  }
  
  private void b(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).b(paramFragment, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((ed)localObject).b).booleanValue();
      }
    }
  }
  
  private void b(dw<Fragment> paramdw)
  {
    int i1 = this.l;
    if (i1 <= 0) {
      return;
    }
    int i2 = Math.min(i1, 4);
    int i3 = this.e.size();
    i1 = 0;
    while (i1 < i3)
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if (localFragment.b < i2)
      {
        a(localFragment, i2, localFragment.s(), localFragment.t(), false);
        if ((localFragment.J != null) && (!localFragment.B) && (localFragment.P)) {
          paramdw.add(localFragment);
        }
      }
      i1 += 1;
    }
  }
  
  private void b(ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      if ((paramArrayList1 != null) && (paramArrayList.size() == paramArrayList1.size()))
      {
        a(paramArrayList, paramArrayList1);
        int i5 = paramArrayList.size();
        int i1 = 0;
        int i2;
        for (int i3 = 0; i1 < i5; i3 = i2)
        {
          int i4 = i1;
          i2 = i3;
          if (!((bv)paramArrayList.get(i1)).t)
          {
            if (i3 != i1) {
              a(paramArrayList, paramArrayList1, i3, i1);
            }
            i3 = i1 + 1;
            i2 = i3;
            if (((Boolean)paramArrayList1.get(i1)).booleanValue()) {
              for (;;)
              {
                i2 = i3;
                if (i3 >= i5) {
                  break;
                }
                i2 = i3;
                if (!((Boolean)paramArrayList1.get(i3)).booleanValue()) {
                  break;
                }
                i2 = i3;
                if (((bv)paramArrayList.get(i3)).t) {
                  break;
                }
                i3 += 1;
              }
            }
            a(paramArrayList, paramArrayList1, i1, i2);
            i4 = i2 - 1;
          }
          i1 = i4 + 1;
        }
        if (i3 != i5) {
          a(paramArrayList, paramArrayList1, i3, i5);
        }
        return;
      }
      throw new IllegalStateException("Internal error with the back stack records");
    }
  }
  
  private static void b(ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      bv localbv = (bv)paramArrayList.get(paramInt1);
      boolean bool2 = ((Boolean)paramArrayList1.get(paramInt1)).booleanValue();
      boolean bool1 = true;
      if (bool2)
      {
        localbv.a(-1);
        if (paramInt1 != paramInt2 - 1) {
          bool1 = false;
        }
        localbv.a(bool1);
      }
      else
      {
        localbv.a(1);
        localbv.c();
      }
      paramInt1 += 1;
    }
  }
  
  private Fragment c(int paramInt)
  {
    int i1 = this.e.size() - 1;
    while (i1 >= 0)
    {
      localObject = (Fragment)this.e.get(i1);
      if ((localObject != null) && (((Fragment)localObject).y == paramInt)) {
        return localObject;
      }
      i1 -= 1;
    }
    Object localObject = this.f;
    if (localObject != null)
    {
      i1 = ((SparseArray)localObject).size() - 1;
      while (i1 >= 0)
      {
        localObject = (Fragment)this.f.valueAt(i1);
        if ((localObject != null) && (((Fragment)localObject).y == paramInt)) {
          return localObject;
        }
        i1 -= 1;
      }
    }
    return null;
  }
  
  private void c(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).c(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.b).booleanValue();
      }
    }
  }
  
  private void c(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).c(paramFragment, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((ed)localObject).b).booleanValue();
      }
    }
  }
  
  private boolean c(ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    try
    {
      ArrayList localArrayList = this.b;
      int i1 = 0;
      if ((localArrayList != null) && (this.b.size() != 0))
      {
        int i2 = this.b.size();
        boolean bool = false;
        while (i1 < i2)
        {
          bool |= ((g)this.b.get(i1)).a(paramArrayList, paramArrayList1);
          i1 += 1;
        }
        this.b.clear();
        this.m.d.removeCallbacks(this.E);
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public static void d(Fragment paramFragment)
  {
    if (a) {
      new StringBuilder("hide: ").append(paramFragment);
    }
    if (!paramFragment.B)
    {
      paramFragment.B = true;
      paramFragment.Q = (true ^ paramFragment.Q);
    }
  }
  
  private void d(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).d(paramFragment, paramBundle, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      paramBundle = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)paramBundle.b).booleanValue();
      }
    }
  }
  
  private void d(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).d(paramFragment, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((ed)localObject).b).booleanValue();
      }
    }
  }
  
  public static void e(Fragment paramFragment)
  {
    if (a) {
      new StringBuilder("show: ").append(paramFragment);
    }
    if (paramFragment.B)
    {
      paramFragment.B = false;
      paramFragment.Q ^= true;
    }
  }
  
  private void e(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).e(paramFragment, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((ed)localObject).b).booleanValue();
      }
    }
  }
  
  private void f(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).f(paramFragment, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((ed)localObject).b).booleanValue();
      }
    }
  }
  
  private void g(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).g(paramFragment, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((ed)localObject).b).booleanValue();
      }
    }
  }
  
  private void h(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).s;
      if ((localObject instanceof cc)) {
        ((cc)localObject).h(paramFragment, true);
      }
    }
    paramFragment = this.J.iterator();
    while (paramFragment.hasNext())
    {
      localObject = (ed)paramFragment.next();
      if (paramBoolean) {
        ((Boolean)((ed)localObject).b).booleanValue();
      }
    }
  }
  
  private void i(Fragment paramFragment)
  {
    a(paramFragment, this.l, 0, 0, false);
  }
  
  private void j(final Fragment paramFragment)
  {
    if (paramFragment.J != null)
    {
      c localc = a(paramFragment, paramFragment.t(), paramFragment.B ^ true, paramFragment.u());
      if ((localc != null) && (localc.b != null))
      {
        localc.b.setTarget(paramFragment.J);
        if (paramFragment.B)
        {
          if (paramFragment.B())
          {
            paramFragment.c(false);
          }
          else
          {
            final ViewGroup localViewGroup = paramFragment.I;
            final View localView = paramFragment.J;
            localViewGroup.startViewTransition(localView);
            localc.b.addListener(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                localViewGroup.endViewTransition(localView);
                paramAnonymousAnimator.removeListener(this);
                if (paramFragment.J != null) {
                  paramFragment.J.setVisibility(8);
                }
              }
            });
          }
        }
        else {
          paramFragment.J.setVisibility(0);
        }
        a(paramFragment.J, localc);
        localc.b.start();
      }
      else
      {
        if (localc != null)
        {
          a(paramFragment.J, localc);
          paramFragment.J.startAnimation(localc.a);
          localc.a.start();
        }
        int i1;
        if ((paramFragment.B) && (!paramFragment.B())) {
          i1 = 8;
        } else {
          i1 = 0;
        }
        paramFragment.J.setVisibility(i1);
        if (paramFragment.B()) {
          paramFragment.c(false);
        }
      }
    }
    if ((paramFragment.l) && (paramFragment.F) && (paramFragment.G)) {
      this.r = true;
    }
    paramFragment.Q = false;
  }
  
  private Fragment k(Fragment paramFragment)
  {
    ViewGroup localViewGroup = paramFragment.I;
    View localView = paramFragment.J;
    if (localViewGroup != null)
    {
      if (localView == null) {
        return null;
      }
      int i1 = this.e.indexOf(paramFragment) - 1;
      while (i1 >= 0)
      {
        paramFragment = (Fragment)this.e.get(i1);
        if ((paramFragment.I == localViewGroup) && (paramFragment.J != null)) {
          return paramFragment;
        }
        i1 -= 1;
      }
      return null;
    }
    return null;
  }
  
  private void l(Fragment paramFragment)
  {
    if (paramFragment.K == null) {
      return;
    }
    SparseArray localSparseArray = this.B;
    if (localSparseArray == null) {
      this.B = new SparseArray();
    } else {
      localSparseArray.clear();
    }
    paramFragment.K.saveHierarchyState(this.B);
    if (this.B.size() > 0)
    {
      paramFragment.d = this.B;
      this.B = null;
    }
  }
  
  private Bundle m(Fragment paramFragment)
  {
    if (this.A == null) {
      this.A = new Bundle();
    }
    paramFragment.c(this.A);
    d(paramFragment, this.A, false);
    if (!this.A.isEmpty())
    {
      localObject2 = this.A;
      this.A = null;
    }
    else
    {
      localObject2 = null;
    }
    if (paramFragment.J != null) {
      l(paramFragment);
    }
    Object localObject1 = localObject2;
    if (paramFragment.d != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.d);
    }
    Object localObject2 = localObject1;
    if (!paramFragment.M)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.M);
    }
    return localObject2;
  }
  
  private boolean r()
  {
    h();
    t();
    Object localObject1 = this.p;
    if (localObject1 != null)
    {
      localObject1 = ((Fragment)localObject1).u;
      if ((localObject1 != null) && (((cb)localObject1).c())) {
        return true;
      }
    }
    localObject1 = this.x;
    ArrayList localArrayList1 = this.y;
    ArrayList localArrayList2 = this.g;
    boolean bool = false;
    if (localArrayList2 != null)
    {
      int i1 = localArrayList2.size() - 1;
      if (i1 >= 0)
      {
        ((ArrayList)localObject1).add(this.g.remove(i1));
        localArrayList1.add(Boolean.TRUE);
        bool = true;
      }
    }
    if (bool) {
      this.c = true;
    }
    try
    {
      b(this.x, this.y);
      u();
    }
    finally
    {
      u();
    }
    A();
    return bool;
  }
  
  private void s()
  {
    if (this.f == null) {
      return;
    }
    int i1 = 0;
    while (i1 < this.f.size())
    {
      Fragment localFragment = (Fragment)this.f.valueAt(i1);
      if ((localFragment != null) && (localFragment.L)) {
        if (this.c)
        {
          this.w = true;
        }
        else
        {
          localFragment.L = false;
          a(localFragment, this.l, 0, 0, false);
        }
      }
      i1 += 1;
    }
  }
  
  private void t()
  {
    if (!this.c)
    {
      if (this.m != null)
      {
        if (Looper.myLooper() == this.m.d.getLooper())
        {
          if (this.x == null)
          {
            this.x = new ArrayList();
            this.y = new ArrayList();
          }
          this.c = true;
          try
          {
            a(null, null);
            return;
          }
          finally
          {
            this.c = false;
          }
        }
        throw new IllegalStateException("Must be called from main thread of fragment host");
      }
      throw new IllegalStateException("Fragment host has been destroyed");
    }
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  private void u()
  {
    this.c = false;
    this.y.clear();
    this.x.clear();
  }
  
  private void v()
  {
    if (this.C != null) {
      while (!this.C.isEmpty()) {
        ((h)this.C.remove(0)).c();
      }
    }
  }
  
  private void w()
  {
    Object localObject = this.f;
    int i2 = 0;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((SparseArray)localObject).size();
    }
    while (i2 < i1)
    {
      localObject = (Fragment)this.f.valueAt(i2);
      if (localObject != null) {
        if (((Fragment)localObject).x() != null)
        {
          int i3 = ((Fragment)localObject).z();
          View localView = ((Fragment)localObject).x();
          Animation localAnimation = localView.getAnimation();
          if (localAnimation != null)
          {
            localAnimation.cancel();
            localView.clearAnimation();
          }
          ((Fragment)localObject).a(null);
          a((Fragment)localObject, i3, 0, 0, false);
        }
        else if (((Fragment)localObject).y() != null)
        {
          ((Fragment)localObject).y().end();
        }
      }
      i2 += 1;
    }
  }
  
  private void x()
  {
    if (this.w)
    {
      this.w = false;
      s();
    }
  }
  
  private void y()
  {
    if (this.k != null)
    {
      int i1 = 0;
      while (i1 < this.k.size())
      {
        this.k.get(i1);
        i1 += 1;
      }
    }
  }
  
  private void z()
  {
    if (this.f != null)
    {
      localObject1 = null;
      Object localObject3 = localObject1;
      Object localObject2 = localObject3;
      int i1 = 0;
      for (;;)
      {
        localObject6 = localObject1;
        localObject5 = localObject3;
        localObject4 = localObject2;
        if (i1 >= this.f.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.f.valueAt(i1);
        localObject5 = localObject1;
        localObject6 = localObject3;
        Object localObject7 = localObject2;
        if (localFragment != null)
        {
          localObject4 = localObject1;
          int i2;
          if (localFragment.D)
          {
            localObject5 = localObject1;
            if (localObject1 == null) {
              localObject5 = new ArrayList();
            }
            ((ArrayList)localObject5).add(localFragment);
            if (localFragment.i != null) {
              i2 = localFragment.i.f;
            } else {
              i2 = -1;
            }
            localFragment.j = i2;
            localObject4 = localObject5;
            if (a)
            {
              new StringBuilder("retainNonConfig: keeping retained ").append(localFragment);
              localObject4 = localObject5;
            }
          }
          if (localFragment.u != null)
          {
            localFragment.u.z();
            localObject5 = localFragment.u.D;
          }
          else
          {
            localObject5 = localFragment.v;
          }
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = localObject3;
            if (localObject5 != null)
            {
              localObject3 = new ArrayList(this.f.size());
              i2 = 0;
              for (;;)
              {
                localObject1 = localObject3;
                if (i2 >= i1) {
                  break;
                }
                ((ArrayList)localObject3).add(null);
                i2 += 1;
              }
            }
          }
          if (localObject1 != null) {
            localObject1.add(localObject5);
          }
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = localObject2;
            if (localFragment.w != null)
            {
              localObject2 = new ArrayList(this.f.size());
              i2 = 0;
              for (;;)
              {
                localObject3 = localObject2;
                if (i2 >= i1) {
                  break;
                }
                ((ArrayList)localObject2).add(null);
                i2 += 1;
              }
            }
          }
          localObject5 = localObject4;
          localObject6 = localObject1;
          localObject7 = localObject3;
          if (localObject3 != null)
          {
            ((ArrayList)localObject3).add(localFragment.w);
            localObject7 = localObject3;
            localObject6 = localObject1;
            localObject5 = localObject4;
          }
        }
        i1 += 1;
        localObject1 = localObject5;
        localObject3 = localObject6;
        localObject2 = localObject7;
      }
    }
    Object localObject6 = null;
    Object localObject1 = localObject6;
    Object localObject4 = localObject1;
    Object localObject5 = localObject1;
    if ((localObject6 == null) && (localObject5 == null) && (localObject4 == null))
    {
      this.D = null;
      return;
    }
    this.D = new cd(localObject6, (List)localObject5, localObject4);
  }
  
  public final int a(bv parambv)
  {
    try
    {
      StringBuilder localStringBuilder;
      if ((this.j != null) && (this.j.size() > 0))
      {
        i1 = ((Integer)this.j.remove(this.j.size() - 1)).intValue();
        if (a)
        {
          localStringBuilder = new StringBuilder("Adding back stack index ");
          localStringBuilder.append(i1);
          localStringBuilder.append(" with ");
          localStringBuilder.append(parambv);
        }
        this.i.set(i1, parambv);
        return i1;
      }
      if (this.i == null) {
        this.i = new ArrayList();
      }
      int i1 = this.i.size();
      if (a)
      {
        localStringBuilder = new StringBuilder("Setting back stack index ");
        localStringBuilder.append(i1);
        localStringBuilder.append(" to ");
        localStringBuilder.append(parambv);
      }
      this.i.add(parambv);
      return i1;
    }
    finally {}
  }
  
  public final Fragment a(String paramString)
  {
    int i1;
    if (paramString != null)
    {
      i1 = this.e.size() - 1;
      while (i1 >= 0)
      {
        localObject = (Fragment)this.e.get(i1);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).A))) {
          return localObject;
        }
        i1 -= 1;
      }
    }
    Object localObject = this.f;
    if ((localObject != null) && (paramString != null))
    {
      i1 = ((SparseArray)localObject).size() - 1;
      while (i1 >= 0)
      {
        localObject = (Fragment)this.f.valueAt(i1);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).A))) {
          return localObject;
        }
        i1 -= 1;
      }
    }
    return null;
  }
  
  public final ce a()
  {
    return new bv(this);
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.c = true;
      a(paramInt, false);
      this.c = false;
      h();
      return;
    }
    finally
    {
      this.c = false;
    }
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    if ((this.m == null) && (paramInt != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.l)) {
      return;
    }
    this.l = paramInt;
    if (this.f != null)
    {
      int i1 = this.e.size();
      paramInt = 0;
      while (paramInt < i1)
      {
        a((Fragment)this.e.get(paramInt));
        paramInt += 1;
      }
      i1 = this.f.size();
      paramInt = 0;
      Object localObject;
      while (paramInt < i1)
      {
        localObject = (Fragment)this.f.valueAt(paramInt);
        if ((localObject != null) && ((((Fragment)localObject).m) || (((Fragment)localObject).C)) && (!((Fragment)localObject).P)) {
          a((Fragment)localObject);
        }
        paramInt += 1;
      }
      s();
      if (this.r)
      {
        localObject = this.m;
        if ((localObject != null) && (this.l == 5))
        {
          ((ca)localObject).d();
          this.r = false;
        }
      }
    }
  }
  
  public final void a(Configuration paramConfiguration)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if (localFragment != null) {
        localFragment.a(paramConfiguration);
      }
      i1 += 1;
    }
  }
  
  public final void a(Parcelable paramParcelable, cd arg2)
  {
    if (paramParcelable == null) {
      return;
    }
    FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
    if (localFragmentManagerState.a == null) {
      return;
    }
    Object localObject4;
    Object localObject2;
    Object localObject3;
    int i2;
    if (??? != null)
    {
      localObject4 = ???.a;
      localObject2 = ???.b;
      localObject3 = ???.c;
      if (localObject4 != null) {
        i1 = ((List)localObject4).size();
      } else {
        i1 = 0;
      }
      i2 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        paramParcelable = (Parcelable)localObject3;
        if (i2 >= i1) {
          break;
        }
        paramParcelable = (Fragment)((List)localObject4).get(i2);
        if (a) {
          new StringBuilder("restoreAllState: re-attaching retained ").append(paramParcelable);
        }
        int i3 = 0;
        while ((i3 < localFragmentManagerState.a.length) && (localFragmentManagerState.a[i3].b != paramParcelable.f)) {
          i3 += 1;
        }
        if (i3 == localFragmentManagerState.a.length)
        {
          localObject1 = new StringBuilder("Could not find active fragment with index ");
          ((StringBuilder)localObject1).append(paramParcelable.f);
          a(new IllegalStateException(((StringBuilder)localObject1).toString()));
        }
        localObject1 = localFragmentManagerState.a[i3];
        ((FragmentState)localObject1).l = paramParcelable;
        paramParcelable.d = null;
        paramParcelable.r = 0;
        paramParcelable.o = false;
        paramParcelable.l = false;
        paramParcelable.i = null;
        if (((FragmentState)localObject1).k != null)
        {
          ((FragmentState)localObject1).k.setClassLoader(this.m.c.getClassLoader());
          paramParcelable.d = ((FragmentState)localObject1).k.getSparseParcelableArray("android:view_state");
          paramParcelable.c = ((FragmentState)localObject1).k;
        }
        i2 += 1;
      }
    }
    Object localObject1 = null;
    paramParcelable = (Parcelable)localObject1;
    this.f = new SparseArray(localFragmentManagerState.a.length);
    int i1 = 0;
    while (i1 < localFragmentManagerState.a.length)
    {
      localObject4 = localFragmentManagerState.a[i1];
      if (localObject4 != null)
      {
        if ((localObject1 != null) && (i1 < ((List)localObject1).size())) {
          localObject2 = (cd)((List)localObject1).get(i1);
        } else {
          localObject2 = null;
        }
        if ((paramParcelable != null) && (i1 < paramParcelable.size())) {
          localObject3 = (bh)paramParcelable.get(i1);
        } else {
          localObject3 = null;
        }
        localObject2 = ((FragmentState)localObject4).a(this.m, this.n, this.o, (cd)localObject2, (bh)localObject3);
        if (a)
        {
          localObject3 = new StringBuilder("restoreAllState: active #");
          ((StringBuilder)localObject3).append(i1);
          ((StringBuilder)localObject3).append(": ");
          ((StringBuilder)localObject3).append(localObject2);
        }
        this.f.put(((Fragment)localObject2).f, localObject2);
        ((FragmentState)localObject4).l = null;
      }
      i1 += 1;
    }
    if (??? != null)
    {
      paramParcelable = ???.a;
      if (paramParcelable != null) {
        i1 = paramParcelable.size();
      } else {
        i1 = 0;
      }
      i2 = 0;
      while (i2 < i1)
      {
        ??? = (Fragment)paramParcelable.get(i2);
        if (???.j >= 0)
        {
          ???.i = ((Fragment)this.f.get(???.j));
          if (???.i == null)
          {
            localObject1 = new StringBuilder("Re-attaching retained fragment ");
            ((StringBuilder)localObject1).append(???);
            ((StringBuilder)localObject1).append(" target no longer exists: ");
            ((StringBuilder)localObject1).append(???.j);
          }
        }
        i2 += 1;
      }
    }
    this.e.clear();
    if (localFragmentManagerState.b != null)
    {
      i1 = 0;
      for (;;)
      {
        if (i1 >= localFragmentManagerState.b.length) {
          break label814;
        }
        paramParcelable = (Fragment)this.f.get(localFragmentManagerState.b[i1]);
        if (paramParcelable == null)
        {
          ??? = new StringBuilder("No instantiated fragment for index #");
          ???.append(localFragmentManagerState.b[i1]);
          a(new IllegalStateException(???.toString()));
        }
        paramParcelable.l = true;
        if (a)
        {
          ??? = new StringBuilder("restoreAllState: added #");
          ???.append(i1);
          ???.append(": ");
          ???.append(paramParcelable);
        }
        if (!this.e.contains(paramParcelable)) {
          synchronized (this.e)
          {
            this.e.add(paramParcelable);
            i1 += 1;
          }
        }
      }
      throw new IllegalStateException("Already added!");
    }
    label814:
    if (localFragmentManagerState.c != null)
    {
      this.g = new ArrayList(localFragmentManagerState.c.length);
      i1 = 0;
      while (i1 < localFragmentManagerState.c.length)
      {
        paramParcelable = localFragmentManagerState.c[i1].a(this);
        if (a)
        {
          ??? = new StringBuilder("restoreAllState: back stack #");
          ???.append(i1);
          ???.append(" (index ");
          ???.append(paramParcelable.m);
          ???.append("): ");
          ???.append(paramParcelable);
          ??? = new PrintWriter(new dz("FragmentManager"));
          paramParcelable.a("  ", ???, false);
          ???.close();
        }
        this.g.add(paramParcelable);
        if (paramParcelable.m >= 0) {
          a(paramParcelable.m, paramParcelable);
        }
        i1 += 1;
      }
    }
    this.g = null;
    if (localFragmentManagerState.d >= 0) {
      this.p = ((Fragment)this.f.get(localFragmentManagerState.d));
    }
    this.d = localFragmentManagerState.e;
  }
  
  final void a(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    int i1 = this.l;
    if (paramFragment.m) {
      if (paramFragment.a()) {
        i1 = Math.min(i1, 1);
      } else {
        i1 = Math.min(i1, 0);
      }
    }
    a(paramFragment, i1, paramFragment.t(), paramFragment.u(), false);
    if (paramFragment.J != null)
    {
      Object localObject = k(paramFragment);
      if (localObject != null)
      {
        localObject = ((Fragment)localObject).J;
        ViewGroup localViewGroup = paramFragment.I;
        i1 = localViewGroup.indexOfChild((View)localObject);
        int i2 = localViewGroup.indexOfChild(paramFragment.J);
        if (i2 < i1)
        {
          localViewGroup.removeViewAt(i2);
          localViewGroup.addView(paramFragment.J, i1);
        }
      }
      if ((paramFragment.P) && (paramFragment.I != null))
      {
        if (paramFragment.R > 0.0F) {
          paramFragment.J.setAlpha(paramFragment.R);
        }
        paramFragment.R = 0.0F;
        paramFragment.P = false;
        localObject = a(paramFragment, paramFragment.t(), true, paramFragment.u());
        if (localObject != null)
        {
          a(paramFragment.J, (c)localObject);
          if (((c)localObject).a != null)
          {
            paramFragment.J.startAnimation(((c)localObject).a);
          }
          else
          {
            ((c)localObject).b.setTarget(paramFragment.J);
            ((c)localObject).b.start();
          }
        }
      }
    }
    if (paramFragment.Q) {
      j(paramFragment);
    }
  }
  
  final void a(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = paramFragment.l;
    int i2 = 1;
    if ((bool) && (!paramFragment.C)) {
      break label41;
    }
    int i1 = paramInt1;
    paramInt1 = i1;
    if (i1 > 1) {
      paramInt1 = 1;
    }
    label41:
    i1 = paramInt1;
    if (paramFragment.m)
    {
      i1 = paramInt1;
      if (paramInt1 > paramFragment.b) {
        if ((paramFragment.b == 0) && (paramFragment.a())) {
          i1 = 1;
        } else {
          i1 = paramFragment.b;
        }
      }
    }
    if ((paramFragment.L) && (paramFragment.b < 4) && (i1 > 3)) {
      paramInt1 = 3;
    } else {
      paramInt1 = i1;
    }
    Object localObject2;
    if (paramFragment.b <= paramInt1)
    {
      if ((paramFragment.n) && (!paramFragment.o)) {
        return;
      }
      if ((paramFragment.x() != null) || (paramFragment.y() != null))
      {
        paramFragment.a(null);
        paramFragment.a(null);
        a(paramFragment, paramFragment.z(), 0, 0, true);
      }
      paramInt2 = paramInt1;
      paramInt3 = paramInt1;
      i1 = paramInt1;
      i2 = paramInt1;
      switch (paramFragment.b)
      {
      default: 
        break;
      case 0: 
        paramInt2 = paramInt1;
        if (paramInt1 > 0)
        {
          if (a) {
            new StringBuilder("moveto CREATED: ").append(paramFragment);
          }
          paramInt2 = paramInt1;
          if (paramFragment.c != null)
          {
            paramFragment.c.setClassLoader(this.m.c.getClassLoader());
            paramFragment.d = paramFragment.c.getSparseParcelableArray("android:view_state");
            paramFragment.i = a(paramFragment.c, "android:target_state");
            if (paramFragment.i != null) {
              paramFragment.k = paramFragment.c.getInt("android:target_req_state", 0);
            }
            if (paramFragment.e != null)
            {
              paramFragment.M = paramFragment.e.booleanValue();
              paramFragment.e = null;
            }
            else
            {
              paramFragment.M = paramFragment.c.getBoolean("android:user_visible_hint", true);
            }
            paramInt2 = paramInt1;
            if (!paramFragment.M)
            {
              paramFragment.L = true;
              paramInt2 = paramInt1;
              if (paramInt1 > 3) {
                paramInt2 = 3;
              }
            }
          }
          localObject1 = this.m;
          paramFragment.t = ((ca)localObject1);
          localObject2 = this.o;
          paramFragment.x = ((Fragment)localObject2);
          if (localObject2 != null) {
            localObject1 = ((Fragment)localObject2).u;
          } else {
            localObject1 = ((ca)localObject1).f;
          }
          paramFragment.s = ((cc)localObject1);
          if (paramFragment.i != null) {
            if (this.f.get(paramFragment.i.f) == paramFragment.i)
            {
              if (paramFragment.i.b <= 0) {
                a(paramFragment.i, 1, 0, 0, true);
              }
            }
            else
            {
              localObject1 = new StringBuilder("Fragment ");
              ((StringBuilder)localObject1).append(paramFragment);
              ((StringBuilder)localObject1).append(" declared target fragment ");
              ((StringBuilder)localObject1).append(paramFragment.i);
              ((StringBuilder)localObject1).append(" that does not belong to this FragmentManager!");
              throw new IllegalStateException(((StringBuilder)localObject1).toString());
            }
          }
          a(paramFragment, this.m.c, false);
          paramFragment.H = false;
          paramFragment.H = true;
          if (paramFragment.t == null) {
            localObject1 = null;
          } else {
            localObject1 = paramFragment.t.b;
          }
          if (localObject1 != null)
          {
            paramFragment.H = false;
            paramFragment.H = true;
          }
          if (paramFragment.H)
          {
            if (paramFragment.x == null) {
              this.m.a(paramFragment);
            }
            b(paramFragment, this.m.c, false);
            if (!paramFragment.T)
            {
              a(paramFragment, paramFragment.c, false);
              paramFragment.b(paramFragment.c);
              b(paramFragment, paramFragment.c, false);
            }
            else
            {
              paramFragment.a(paramFragment.c);
              paramFragment.b = 1;
            }
            paramFragment.E = false;
          }
          else
          {
            localObject1 = new StringBuilder("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" did not call through to super.onAttach()");
            throw new cq(((StringBuilder)localObject1).toString());
          }
        }
      case 1: 
        if ((paramFragment.n) && (!paramFragment.q))
        {
          paramFragment.b();
          paramFragment.J = paramFragment.m();
          if (paramFragment.J != null)
          {
            paramFragment.K = paramFragment.J;
            paramFragment.J.setSaveFromParentEnabled(false);
            if (paramFragment.B) {
              paramFragment.J.setVisibility(8);
            }
            a(paramFragment, paramFragment.J, paramFragment.c, false);
          }
          else
          {
            paramFragment.K = null;
          }
        }
        paramInt3 = paramInt2;
        if (paramInt2 > 1)
        {
          if (a) {
            new StringBuilder("moveto ACTIVITY_CREATED: ").append(paramFragment);
          }
          if (!paramFragment.n) {
            if (paramFragment.z != 0)
            {
              if (paramFragment.z == -1)
              {
                localObject1 = new StringBuilder("Cannot create fragment ");
                ((StringBuilder)localObject1).append(paramFragment);
                ((StringBuilder)localObject1).append(" for a container view with no id");
                a(new IllegalArgumentException(((StringBuilder)localObject1).toString()));
              }
              localObject2 = (ViewGroup)this.n.a(paramFragment.z);
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label1148;
              }
              localObject1 = localObject2;
              if (paramFragment.p) {
                break label1148;
              }
            }
          }
        }
        break;
      }
    }
    try
    {
      if (paramFragment.t == null) {
        localObject1 = null;
      } else {
        localObject1 = paramFragment.t.c;
      }
      if (localObject1 != null)
      {
        localObject1 = ((Context)localObject1).getResources().getResourceName(paramFragment.z);
        break label1064;
      }
      localObject1 = new StringBuilder("Fragment ");
      ((StringBuilder)localObject1).append(paramFragment);
      ((StringBuilder)localObject1).append(" not attached to a context.");
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label1059:
      label1064:
      Object localObject3;
      break label1059;
    }
    Object localObject1 = "unknown";
    localObject3 = new StringBuilder("No view found for id 0x");
    ((StringBuilder)localObject3).append(Integer.toHexString(paramFragment.z));
    ((StringBuilder)localObject3).append(" (");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(") for fragment ");
    ((StringBuilder)localObject3).append(paramFragment);
    a(new IllegalArgumentException(((StringBuilder)localObject3).toString()));
    localObject1 = localObject2;
    break label1148;
    localObject1 = null;
    label1148:
    paramFragment.I = ((ViewGroup)localObject1);
    paramFragment.b();
    paramFragment.J = paramFragment.m();
    if (paramFragment.J != null)
    {
      paramFragment.K = paramFragment.J;
      paramFragment.J.setSaveFromParentEnabled(false);
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView(paramFragment.J);
      }
      if (paramFragment.B) {
        paramFragment.J.setVisibility(8);
      }
      a(paramFragment, paramFragment.J, paramFragment.c, false);
      if ((paramFragment.J.getVisibility() == 0) && (paramFragment.I != null)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramFragment.P = paramBoolean;
    }
    else
    {
      paramFragment.K = null;
    }
    paramFragment.n();
    c(paramFragment, paramFragment.c, false);
    if (paramFragment.J != null)
    {
      if (paramFragment.d != null)
      {
        paramFragment.K.restoreHierarchyState(paramFragment.d);
        paramFragment.d = null;
      }
      paramFragment.H = false;
      paramFragment.H = true;
      if (!paramFragment.H)
      {
        localObject1 = new StringBuilder("Fragment ");
        ((StringBuilder)localObject1).append(paramFragment);
        ((StringBuilder)localObject1).append(" did not call through to super.onViewStateRestored()");
        throw new cq(((StringBuilder)localObject1).toString());
      }
    }
    paramFragment.c = null;
    paramInt3 = paramInt2;
    i1 = paramInt3;
    if (paramInt3 > 2)
    {
      paramFragment.b = 3;
      i1 = paramInt3;
    }
    i2 = i1;
    if (i1 > 3)
    {
      if (a) {
        new StringBuilder("moveto STARTED: ").append(paramFragment);
      }
      paramFragment.o();
      b(paramFragment, false);
      i2 = i1;
    }
    if (i2 > 4)
    {
      if (a) {
        new StringBuilder("moveto RESUMED: ").append(paramFragment);
      }
      paramFragment.p();
      c(paramFragment, false);
      paramFragment.c = null;
      paramFragment.d = null;
    }
    paramInt1 = i2;
    break label2839;
    if (paramFragment.b > paramInt1)
    {
      switch (paramFragment.b)
      {
      default: 
        break;
      case 5: 
        if (paramInt1 < 5)
        {
          if (a) {
            new StringBuilder("movefrom RESUMED: ").append(paramFragment);
          }
          paramFragment.U.a(au.a.ON_PAUSE);
          if (paramFragment.u != null) {
            paramFragment.u.a(4);
          }
          paramFragment.b = 4;
          paramFragment.H = false;
          paramFragment.H = true;
          if (paramFragment.H)
          {
            d(paramFragment, false);
          }
          else
          {
            localObject1 = new StringBuilder("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" did not call through to super.onPause()");
            throw new cq(((StringBuilder)localObject1).toString());
          }
        }
      case 4: 
        if (paramInt1 < 4)
        {
          if (a) {
            new StringBuilder("movefrom STARTED: ").append(paramFragment);
          }
          paramFragment.U.a(au.a.ON_STOP);
          if (paramFragment.u != null) {
            paramFragment.u.o();
          }
          paramFragment.b = 3;
          paramFragment.H = false;
          paramFragment.H = true;
          if (paramFragment.H)
          {
            e(paramFragment, false);
          }
          else
          {
            localObject1 = new StringBuilder("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" did not call through to super.onStop()");
            throw new cq(((StringBuilder)localObject1).toString());
          }
        }
      case 3: 
        if (paramInt1 < 3)
        {
          if (a) {
            new StringBuilder("movefrom STOPPED: ").append(paramFragment);
          }
          if (paramFragment.u != null) {
            paramFragment.u.a(2);
          }
          paramFragment.b = 2;
        }
      case 2: 
        if (paramInt1 < 2)
        {
          if (a) {
            new StringBuilder("movefrom ACTIVITY_CREATED: ").append(paramFragment);
          }
          if ((paramFragment.J != null) && (this.m.b()) && (paramFragment.d == null)) {
            l(paramFragment);
          }
          if (paramFragment.u != null) {
            paramFragment.u.a(1);
          }
          paramFragment.b = 1;
          paramFragment.H = false;
          paramFragment.H = true;
          if (paramFragment.H)
          {
            if (paramFragment.N != null) {
              paramFragment.N.b.b();
            }
            paramFragment.q = false;
            f(paramFragment, false);
            if ((paramFragment.J != null) && (paramFragment.I != null))
            {
              paramFragment.I.endViewTransition(paramFragment.J);
              paramFragment.J.clearAnimation();
              if ((this.l > 0) && (!this.u) && (paramFragment.J.getVisibility() == 0) && (paramFragment.R >= 0.0F)) {
                localObject1 = a(paramFragment, paramInt2, false, paramInt3);
              } else {
                localObject1 = null;
              }
              paramFragment.R = 0.0F;
              if (localObject1 != null)
              {
                localObject2 = paramFragment.J;
                localObject3 = paramFragment.I;
                ((ViewGroup)localObject3).startViewTransition((View)localObject2);
                paramFragment.b(paramInt1);
                Object localObject4;
                if (((c)localObject1).a != null)
                {
                  localObject4 = new e(((c)localObject1).a, (ViewGroup)localObject3, (View)localObject2);
                  paramFragment.a(paramFragment.J);
                  ((Animation)localObject4).setAnimationListener(new b(a((Animation)localObject4), (ViewGroup)localObject3)
                  {
                    public final void onAnimationEnd(Animation paramAnonymousAnimation)
                    {
                      super.onAnimationEnd(paramAnonymousAnimation);
                      this.a.post(new Runnable()
                      {
                        public final void run()
                        {
                          if (cc.2.this.b.x() != null)
                          {
                            cc.2.this.b.a(null);
                            cc.this.a(cc.2.this.b, cc.2.this.b.z(), 0, 0, false);
                          }
                        }
                      });
                    }
                  });
                  a((View)localObject2, (c)localObject1);
                  paramFragment.J.startAnimation((Animation)localObject4);
                }
                else
                {
                  localObject4 = ((c)localObject1).b;
                  paramFragment.a(((c)localObject1).b);
                  ((Animator)localObject4).addListener(new AnimatorListenerAdapter()
                  {
                    public final void onAnimationEnd(Animator paramAnonymousAnimator)
                    {
                      this.a.endViewTransition(this.b);
                      paramAnonymousAnimator = paramFragment.y();
                      paramFragment.a(null);
                      if ((paramAnonymousAnimator != null) && (this.a.indexOfChild(this.b) < 0))
                      {
                        paramAnonymousAnimator = cc.this;
                        Fragment localFragment = paramFragment;
                        paramAnonymousAnimator.a(localFragment, localFragment.z(), 0, 0, false);
                      }
                    }
                  });
                  ((Animator)localObject4).setTarget(paramFragment.J);
                  a(paramFragment.J, (c)localObject1);
                  ((Animator)localObject4).start();
                }
              }
              paramFragment.I.removeView(paramFragment.J);
            }
            paramFragment.I = null;
            paramFragment.J = null;
            paramFragment.K = null;
            paramFragment.o = false;
          }
          else
          {
            localObject1 = new StringBuilder("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" did not call through to super.onDestroyView()");
            throw new cq(((StringBuilder)localObject1).toString());
          }
        }
        break;
      }
      if (paramInt1 <= 0)
      {
        if (this.u) {
          if (paramFragment.x() != null)
          {
            localObject1 = paramFragment.x();
            paramFragment.a(null);
            ((View)localObject1).clearAnimation();
          }
          else if (paramFragment.y() != null)
          {
            localObject1 = paramFragment.y();
            paramFragment.a(null);
            ((Animator)localObject1).cancel();
          }
        }
        if ((paramFragment.x() == null) && (paramFragment.y() == null))
        {
          if (a) {
            new StringBuilder("movefrom CREATED: ").append(paramFragment);
          }
          if (!paramFragment.E)
          {
            paramFragment.U.a(au.a.ON_DESTROY);
            if (paramFragment.u != null) {
              paramFragment.u.p();
            }
            paramFragment.b = 0;
            paramFragment.H = false;
            paramFragment.T = false;
            paramFragment.H = true;
            if ((paramFragment.w != null) && (!paramFragment.t.f.s)) {
              paramFragment.w.a();
            }
            if (paramFragment.H)
            {
              paramFragment.u = null;
              g(paramFragment, false);
            }
            else
            {
              localObject1 = new StringBuilder("Fragment ");
              ((StringBuilder)localObject1).append(paramFragment);
              ((StringBuilder)localObject1).append(" did not call through to super.onDestroy()");
              throw new cq(((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            paramFragment.b = 0;
          }
          paramFragment.H = false;
          paramFragment.H = true;
          paramFragment.S = null;
          if (paramFragment.H)
          {
            if (paramFragment.u != null) {
              if (paramFragment.E)
              {
                paramFragment.u.p();
                paramFragment.u = null;
              }
              else
              {
                localObject1 = new StringBuilder("Child FragmentManager of ");
                ((StringBuilder)localObject1).append(paramFragment);
                ((StringBuilder)localObject1).append(" was not  destroyed and this fragment is not retaining instance");
                throw new IllegalStateException(((StringBuilder)localObject1).toString());
              }
            }
            h(paramFragment, false);
            if (!paramBoolean) {
              if (!paramFragment.E)
              {
                if (paramFragment.f >= 0)
                {
                  if (a) {
                    new StringBuilder("Freeing fragment index ").append(paramFragment);
                  }
                  this.f.put(paramFragment.f, null);
                  paramFragment.f = -1;
                  paramFragment.g = null;
                  paramFragment.l = false;
                  paramFragment.m = false;
                  paramFragment.n = false;
                  paramFragment.o = false;
                  paramFragment.p = false;
                  paramFragment.r = 0;
                  paramFragment.s = null;
                  paramFragment.u = null;
                  paramFragment.t = null;
                  paramFragment.y = 0;
                  paramFragment.z = 0;
                  paramFragment.A = null;
                  paramFragment.B = false;
                  paramFragment.C = false;
                  paramFragment.E = false;
                }
              }
              else
              {
                paramFragment.t = null;
                paramFragment.x = null;
                paramFragment.s = null;
              }
            }
          }
          else
          {
            localObject1 = new StringBuilder("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" did not call through to super.onDetach()");
            throw new cq(((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          paramFragment.b(paramInt1);
          paramInt1 = i2;
        }
      }
    }
    label2839:
    if (paramFragment.b != paramInt1)
    {
      localObject1 = new StringBuilder("moveToState: Fragment state for ");
      ((StringBuilder)localObject1).append(paramFragment);
      ((StringBuilder)localObject1).append(" not updated inline; expected state ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" found ");
      ((StringBuilder)localObject1).append(paramFragment.b);
      paramFragment.b = paramInt1;
    }
  }
  
  public final void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (a) {
      new StringBuilder("add: ").append(paramFragment);
    }
    b(paramFragment);
    if (!paramFragment.C)
    {
      if (!this.e.contains(paramFragment)) {
        synchronized (this.e)
        {
          this.e.add(paramFragment);
          paramFragment.l = true;
          paramFragment.m = false;
          if (paramFragment.J == null) {
            paramFragment.Q = false;
          }
          if ((paramFragment.F) && (paramFragment.G)) {
            this.r = true;
          }
          if (!paramBoolean) {
            return;
          }
          i(paramFragment);
          return;
        }
      }
      throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
    }
  }
  
  public final void a(ca paramca, by paramby, Fragment paramFragment)
  {
    if (this.m == null)
    {
      this.m = paramca;
      this.n = paramby;
      this.o = paramFragment;
      return;
    }
    throw new IllegalStateException("Already attached");
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("    ");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.f;
    int i2 = 0;
    int i1;
    if (localObject2 != null)
    {
      i3 = ((SparseArray)localObject2).size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i1 = 0;
        while (i1 < i3)
        {
          localObject2 = (Fragment)this.f.valueAt(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localObject2);
          if (localObject2 != null)
          {
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mFragmentId=#");
            paramPrintWriter.print(Integer.toHexString(((Fragment)localObject2).y));
            paramPrintWriter.print(" mContainerId=#");
            paramPrintWriter.print(Integer.toHexString(((Fragment)localObject2).z));
            paramPrintWriter.print(" mTag=");
            paramPrintWriter.println(((Fragment)localObject2).A);
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mState=");
            paramPrintWriter.print(((Fragment)localObject2).b);
            paramPrintWriter.print(" mIndex=");
            paramPrintWriter.print(((Fragment)localObject2).f);
            paramPrintWriter.print(" mWho=");
            paramPrintWriter.print(((Fragment)localObject2).g);
            paramPrintWriter.print(" mBackStackNesting=");
            paramPrintWriter.println(((Fragment)localObject2).r);
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mAdded=");
            paramPrintWriter.print(((Fragment)localObject2).l);
            paramPrintWriter.print(" mRemoving=");
            paramPrintWriter.print(((Fragment)localObject2).m);
            paramPrintWriter.print(" mFromLayout=");
            paramPrintWriter.print(((Fragment)localObject2).n);
            paramPrintWriter.print(" mInLayout=");
            paramPrintWriter.println(((Fragment)localObject2).o);
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mHidden=");
            paramPrintWriter.print(((Fragment)localObject2).B);
            paramPrintWriter.print(" mDetached=");
            paramPrintWriter.print(((Fragment)localObject2).C);
            paramPrintWriter.print(" mMenuVisible=");
            paramPrintWriter.print(((Fragment)localObject2).G);
            paramPrintWriter.print(" mHasMenu=");
            paramPrintWriter.println(((Fragment)localObject2).F);
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mRetainInstance=");
            paramPrintWriter.print(((Fragment)localObject2).D);
            paramPrintWriter.print(" mRetaining=");
            paramPrintWriter.print(((Fragment)localObject2).E);
            paramPrintWriter.print(" mUserVisibleHint=");
            paramPrintWriter.println(((Fragment)localObject2).M);
            if (((Fragment)localObject2).s != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mFragmentManager=");
              paramPrintWriter.println(((Fragment)localObject2).s);
            }
            if (((Fragment)localObject2).t != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mHost=");
              paramPrintWriter.println(((Fragment)localObject2).t);
            }
            if (((Fragment)localObject2).x != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mParentFragment=");
              paramPrintWriter.println(((Fragment)localObject2).x);
            }
            if (((Fragment)localObject2).h != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mArguments=");
              paramPrintWriter.println(((Fragment)localObject2).h);
            }
            if (((Fragment)localObject2).c != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mSavedFragmentState=");
              paramPrintWriter.println(((Fragment)localObject2).c);
            }
            if (((Fragment)localObject2).d != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mSavedViewState=");
              paramPrintWriter.println(((Fragment)localObject2).d);
            }
            if (((Fragment)localObject2).i != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mTarget=");
              paramPrintWriter.print(((Fragment)localObject2).i);
              paramPrintWriter.print(" mTargetRequestCode=");
              paramPrintWriter.println(((Fragment)localObject2).k);
            }
            if (((Fragment)localObject2).s() != 0)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mNextAnim=");
              paramPrintWriter.println(((Fragment)localObject2).s());
            }
            if (((Fragment)localObject2).I != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mContainer=");
              paramPrintWriter.println(((Fragment)localObject2).I);
            }
            if (((Fragment)localObject2).J != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mView=");
              paramPrintWriter.println(((Fragment)localObject2).J);
            }
            if (((Fragment)localObject2).K != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mInnerView=");
              paramPrintWriter.println(((Fragment)localObject2).J);
            }
            if (((Fragment)localObject2).x() != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mAnimatingAway=");
              paramPrintWriter.println(((Fragment)localObject2).x());
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.print("mStateAfterAnimating=");
              paramPrintWriter.println(((Fragment)localObject2).z());
            }
            Object localObject3;
            if (((Fragment)localObject2).N != null)
            {
              paramPrintWriter.print((String)localObject1);
              paramPrintWriter.println("Loader Manager:");
              localObject3 = ((Fragment)localObject2).N;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append("  ");
              ((LoaderManagerImpl)localObject3).a(localStringBuilder.toString(), paramPrintWriter);
            }
            if (((Fragment)localObject2).u != null)
            {
              paramPrintWriter.print((String)localObject1);
              localObject3 = new StringBuilder("Child ");
              ((StringBuilder)localObject3).append(((Fragment)localObject2).u);
              ((StringBuilder)localObject3).append(":");
              paramPrintWriter.println(((StringBuilder)localObject3).toString());
              localObject2 = ((Fragment)localObject2).u;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append("  ");
              ((cc)localObject2).a(((StringBuilder)localObject3).toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
            }
          }
          i1 += 1;
        }
      }
    }
    int i3 = this.e.size();
    if (i3 > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i1 = 0;
      while (i1 < i3)
      {
        paramFileDescriptor = (Fragment)this.e.get(i1);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i1);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i1 += 1;
      }
    }
    paramFileDescriptor = this.h;
    if (paramFileDescriptor != null)
    {
      i3 = paramFileDescriptor.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i1 = 0;
        while (i1 < i3)
        {
          paramFileDescriptor = (Fragment)this.h.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i1 += 1;
        }
      }
    }
    paramFileDescriptor = this.g;
    if (paramFileDescriptor != null)
    {
      i3 = paramFileDescriptor.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i1 = 0;
        while (i1 < i3)
        {
          paramFileDescriptor = (bv)this.g.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.a((String)localObject1, paramPrintWriter);
          i1 += 1;
        }
      }
    }
    try
    {
      if (this.i != null)
      {
        i3 = this.i.size();
        if (i3 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i1 = 0;
          while (i1 < i3)
          {
            paramFileDescriptor = (bv)this.i.get(i1);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i1);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i1 += 1;
          }
        }
      }
      if ((this.j != null) && (this.j.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.j.toArray()));
      }
      paramFileDescriptor = this.b;
      if (paramFileDescriptor != null)
      {
        i3 = paramFileDescriptor.size();
        if (i3 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i1 = i2;
          while (i1 < i3)
          {
            paramFileDescriptor = (g)this.b.get(i1);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i1);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i1 += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("FragmentManager misc state:");
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mHost=");
      paramPrintWriter.println(this.m);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mContainer=");
      paramPrintWriter.println(this.n);
      if (this.o != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mParent=");
        paramPrintWriter.println(this.o);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mCurState=");
      paramPrintWriter.print(this.l);
      paramPrintWriter.print(" mStateSaved=");
      paramPrintWriter.print(this.s);
      paramPrintWriter.print(" mStopped=");
      paramPrintWriter.print(this.t);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(this.u);
      if (this.r)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mNeedMenuInvalidate=");
        paramPrintWriter.println(this.r);
      }
      if (this.v != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mNoTransactionsBecause=");
        paramPrintWriter.println(this.v);
      }
      return;
    }
    finally {}
  }
  
  public final void a(boolean paramBoolean)
  {
    int i1 = this.e.size() - 1;
    while (i1 >= 0)
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if (localFragment != null) {
        localFragment.a(paramBoolean);
      }
      i1 -= 1;
    }
  }
  
  public final boolean a(Menu paramMenu)
  {
    int i2 = this.l;
    int i1 = 0;
    if (i2 <= 0) {
      return false;
    }
    boolean bool2;
    for (boolean bool1 = false; i1 < this.e.size(); bool1 = bool2)
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      bool2 = bool1;
      if (localFragment != null)
      {
        bool2 = bool1;
        if (localFragment.a(paramMenu)) {
          bool2 = true;
        }
      }
      i1 += 1;
    }
    return bool1;
  }
  
  public final boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i1 = this.l;
    int i2 = 0;
    if (i1 <= 0) {
      return false;
    }
    Object localObject1 = null;
    i1 = 0;
    boolean bool2;
    for (boolean bool1 = false; i1 < this.e.size(); bool1 = bool2)
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      Object localObject2 = localObject1;
      bool2 = bool1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment.a(paramMenu, paramMenuInflater))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localFragment);
          bool2 = true;
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    if (this.h != null)
    {
      i1 = i2;
      while (i1 < this.h.size())
      {
        paramMenu = (Fragment)this.h.get(i1);
        if (localObject1 != null) {
          localObject1.contains(paramMenu);
        }
        i1 += 1;
      }
    }
    this.h = localObject1;
    return bool1;
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    if (this.l <= 0) {
      return false;
    }
    int i1 = 0;
    while (i1 < this.e.size())
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if ((localFragment != null) && (localFragment.a(paramMenuItem))) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public final Fragment b(String paramString)
  {
    Object localObject = this.f;
    if ((localObject != null) && (paramString != null))
    {
      int i1 = ((SparseArray)localObject).size() - 1;
      while (i1 >= 0)
      {
        localObject = (Fragment)this.f.valueAt(i1);
        if (localObject != null)
        {
          localObject = ((Fragment)localObject).a(paramString);
          if (localObject != null) {
            return localObject;
          }
        }
        i1 -= 1;
      }
    }
    return null;
  }
  
  final void b(Fragment paramFragment)
  {
    if (paramFragment.f >= 0) {
      return;
    }
    int i1 = this.d;
    this.d = (i1 + 1);
    paramFragment.a(i1, this.o);
    if (this.f == null) {
      this.f = new SparseArray();
    }
    this.f.put(paramFragment.f, paramFragment);
    if (a) {
      new StringBuilder("Allocated fragment index ").append(paramFragment);
    }
  }
  
  public final void b(Menu paramMenu)
  {
    if (this.l <= 0) {
      return;
    }
    int i1 = 0;
    while (i1 < this.e.size())
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if (localFragment != null) {
        localFragment.b(paramMenu);
      }
      i1 += 1;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    int i1 = this.e.size() - 1;
    while (i1 >= 0)
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if (localFragment != null) {
        localFragment.b(paramBoolean);
      }
      i1 -= 1;
    }
  }
  
  public final boolean b()
  {
    boolean bool = h();
    v();
    return bool;
  }
  
  public final boolean b(MenuItem paramMenuItem)
  {
    if (this.l <= 0) {
      return false;
    }
    int i1 = 0;
    while (i1 < this.e.size())
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if ((localFragment != null) && (localFragment.b(paramMenuItem))) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public final void c(Fragment paramFragment)
  {
    if (a)
    {
      ??? = new StringBuilder("remove: ");
      ((StringBuilder)???).append(paramFragment);
      ((StringBuilder)???).append(" nesting=");
      ((StringBuilder)???).append(paramFragment.r);
    }
    boolean bool = paramFragment.a();
    if ((!paramFragment.C) || ((bool ^ true))) {}
    synchronized (this.e)
    {
      this.e.remove(paramFragment);
      if ((paramFragment.F) && (paramFragment.G)) {
        this.r = true;
      }
      paramFragment.l = false;
      paramFragment.m = true;
      return;
    }
  }
  
  public final boolean c()
  {
    f();
    return r();
  }
  
  public final List<Fragment> d()
  {
    if (this.e.isEmpty()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.e)
    {
      List localList = (List)this.e.clone();
      return localList;
    }
  }
  
  public final boolean e()
  {
    return (this.s) || (this.t);
  }
  
  final void f()
  {
    if (!e())
    {
      if (this.v == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("Can not perform this action inside of ");
      localStringBuilder.append(this.v);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  public final void f(Fragment paramFragment)
  {
    if (a) {
      new StringBuilder("detach: ").append(paramFragment);
    }
    if (!paramFragment.C)
    {
      paramFragment.C = true;
      if (paramFragment.l)
      {
        if (a) {
          new StringBuilder("remove from detach: ").append(paramFragment);
        }
        synchronized (this.e)
        {
          this.e.remove(paramFragment);
          if ((paramFragment.F) && (paramFragment.G)) {
            this.r = true;
          }
          paramFragment.l = false;
          return;
        }
      }
    }
  }
  
  final void g()
  {
    for (;;)
    {
      int i2;
      try
      {
        ArrayList localArrayList = this.C;
        int i3 = 0;
        if ((localArrayList == null) || (this.C.isEmpty())) {
          break label96;
        }
        i1 = 1;
        i2 = i3;
        if (this.b == null) {
          break label101;
        }
        i2 = i3;
        if (this.b.size() != 1) {
          break label101;
        }
        i2 = 1;
      }
      finally {}
      this.m.d.removeCallbacks(this.E);
      this.m.d.post(this.E);
      return;
      label96:
      int i1 = 0;
      continue;
      label101:
      if (i1 == 0) {
        if (i2 == 0) {}
      }
    }
  }
  
  public final void g(Fragment paramFragment)
  {
    if (a) {
      new StringBuilder("attach: ").append(paramFragment);
    }
    if (paramFragment.C)
    {
      paramFragment.C = false;
      if (!paramFragment.l)
      {
        if (!this.e.contains(paramFragment))
        {
          if (a) {
            new StringBuilder("add from attach: ").append(paramFragment);
          }
          synchronized (this.e)
          {
            this.e.add(paramFragment);
            paramFragment.l = true;
            if ((!paramFragment.F) || (!paramFragment.G)) {
              return;
            }
            this.r = true;
            return;
          }
        }
        throw new IllegalStateException("Fragment already added: ".concat(String.valueOf(paramFragment)));
      }
    }
  }
  
  public final void h(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((this.f.get(paramFragment.f) != paramFragment) || ((paramFragment.t != null) && (paramFragment.s != this))))
    {
      StringBuilder localStringBuilder = new StringBuilder("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not an active fragment of FragmentManager ");
      localStringBuilder.append(this);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.p = paramFragment;
  }
  
  public final boolean h()
  {
    t();
    boolean bool = false;
    for (;;)
    {
      if (c(this.x, this.y)) {
        this.c = true;
      }
      try
      {
        b(this.x, this.y);
        u();
        bool = true;
      }
      finally
      {
        u();
      }
    }
    A();
    return bool;
  }
  
  public final Parcelable i()
  {
    v();
    w();
    h();
    this.s = true;
    Object localObject3 = null;
    this.D = null;
    Object localObject1 = this.f;
    if (localObject1 != null)
    {
      if (((SparseArray)localObject1).size() <= 0) {
        return null;
      }
      int i4 = this.f.size();
      FragmentState[] arrayOfFragmentState = new FragmentState[i4];
      int i3 = 0;
      int i1 = 0;
      int i2 = 0;
      while (i1 < i4)
      {
        localObject1 = (Fragment)this.f.valueAt(i1);
        if (localObject1 != null)
        {
          if (((Fragment)localObject1).f < 0)
          {
            localObject2 = new StringBuilder("Failure saving state: active ");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append(" has cleared index: ");
            ((StringBuilder)localObject2).append(((Fragment)localObject1).f);
            a(new IllegalStateException(((StringBuilder)localObject2).toString()));
          }
          localObject2 = new FragmentState((Fragment)localObject1);
          arrayOfFragmentState[i1] = localObject2;
          if ((((Fragment)localObject1).b > 0) && (((FragmentState)localObject2).k == null))
          {
            ((FragmentState)localObject2).k = m((Fragment)localObject1);
            if (((Fragment)localObject1).i != null)
            {
              if (((Fragment)localObject1).i.f < 0)
              {
                localObject4 = new StringBuilder("Failure saving state: ");
                ((StringBuilder)localObject4).append(localObject1);
                ((StringBuilder)localObject4).append(" has target not in fragment manager: ");
                ((StringBuilder)localObject4).append(((Fragment)localObject1).i);
                a(new IllegalStateException(((StringBuilder)localObject4).toString()));
              }
              if (((FragmentState)localObject2).k == null) {
                ((FragmentState)localObject2).k = new Bundle();
              }
              a(((FragmentState)localObject2).k, "android:target_state", ((Fragment)localObject1).i);
              if (((Fragment)localObject1).k != 0) {
                ((FragmentState)localObject2).k.putInt("android:target_req_state", ((Fragment)localObject1).k);
              }
            }
          }
          else
          {
            ((FragmentState)localObject2).k = ((Fragment)localObject1).c;
          }
          if (a)
          {
            localObject4 = new StringBuilder("Saved state of ");
            ((StringBuilder)localObject4).append(localObject1);
            ((StringBuilder)localObject4).append(": ");
            ((StringBuilder)localObject4).append(((FragmentState)localObject2).k);
          }
          i2 = 1;
        }
        i1 += 1;
      }
      if (i2 == 0) {
        return null;
      }
      i2 = this.e.size();
      if (i2 > 0)
      {
        localObject2 = new int[i2];
        i1 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i1 >= i2) {
            break;
          }
          localObject2[i1] = ((Fragment)this.e.get(i1)).f;
          if (localObject2[i1] < 0)
          {
            localObject1 = new StringBuilder("Failure saving state: active ");
            ((StringBuilder)localObject1).append(this.e.get(i1));
            ((StringBuilder)localObject1).append(" has cleared index: ");
            ((StringBuilder)localObject1).append(localObject2[i1]);
            a(new IllegalStateException(((StringBuilder)localObject1).toString()));
          }
          if (a)
          {
            localObject1 = new StringBuilder("saveAllState: adding fragment #");
            ((StringBuilder)localObject1).append(i1);
            ((StringBuilder)localObject1).append(": ");
            ((StringBuilder)localObject1).append(this.e.get(i1));
          }
          i1 += 1;
        }
      }
      localObject1 = null;
      Object localObject4 = this.g;
      Object localObject2 = localObject3;
      if (localObject4 != null)
      {
        i2 = ((ArrayList)localObject4).size();
        localObject2 = localObject3;
        if (i2 > 0)
        {
          localObject3 = new BackStackState[i2];
          i1 = i3;
          for (;;)
          {
            localObject2 = localObject3;
            if (i1 >= i2) {
              break;
            }
            localObject3[i1] = new BackStackState((bv)this.g.get(i1));
            if (a)
            {
              localObject2 = new StringBuilder("saveAllState: adding back stack #");
              ((StringBuilder)localObject2).append(i1);
              ((StringBuilder)localObject2).append(": ");
              ((StringBuilder)localObject2).append(this.g.get(i1));
            }
            i1 += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).a = arrayOfFragmentState;
      ((FragmentManagerState)localObject3).b = ((int[])localObject1);
      ((FragmentManagerState)localObject3).c = ((BackStackState[])localObject2);
      localObject1 = this.p;
      if (localObject1 != null) {
        ((FragmentManagerState)localObject3).d = ((Fragment)localObject1).f;
      }
      ((FragmentManagerState)localObject3).e = this.d;
      z();
      return localObject3;
    }
    return null;
  }
  
  public final void j()
  {
    this.D = null;
    int i1 = 0;
    this.s = false;
    this.t = false;
    int i2 = this.e.size();
    while (i1 < i2)
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if (localFragment != null) {
        localFragment.q();
      }
      i1 += 1;
    }
  }
  
  public final void k()
  {
    this.s = false;
    this.t = false;
    a(1);
  }
  
  public final void l()
  {
    this.s = false;
    this.t = false;
    a(2);
  }
  
  public final void m()
  {
    this.s = false;
    this.t = false;
    a(4);
  }
  
  public final void n()
  {
    this.s = false;
    this.t = false;
    a(5);
  }
  
  public final void o()
  {
    this.t = true;
    a(3);
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, f.a);
    int i1 = 0;
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    int i3 = paramString.getResourceId(1, -1);
    String str2 = paramString.getString(2);
    paramString.recycle();
    if (!Fragment.a(this.m.c, str1)) {
      return null;
    }
    if (paramView != null) {
      i1 = paramView.getId();
    }
    if ((i1 == -1) && (i3 == -1) && (str2 == null))
    {
      paramView = new StringBuilder();
      paramView.append(paramAttributeSet.getPositionDescription());
      paramView.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
      paramView.append(str1);
      throw new IllegalArgumentException(paramView.toString());
    }
    if (i3 != -1) {
      paramString = c(i3);
    } else {
      paramString = null;
    }
    paramView = paramString;
    if (paramString == null)
    {
      paramView = paramString;
      if (str2 != null) {
        paramView = a(str2);
      }
    }
    paramString = paramView;
    if (paramView == null)
    {
      paramString = paramView;
      if (i1 != -1) {
        paramString = c(i1);
      }
    }
    if (a)
    {
      paramView = new StringBuilder("onCreateView: id=0x");
      paramView.append(Integer.toHexString(i3));
      paramView.append(" fname=");
      paramView.append(str1);
      paramView.append(" existing=");
      paramView.append(paramString);
    }
    if (paramString == null)
    {
      paramView = this.n.a(paramContext, str1, null);
      paramView.n = true;
      int i2;
      if (i3 != 0) {
        i2 = i3;
      } else {
        i2 = i1;
      }
      paramView.y = i2;
      paramView.z = i1;
      paramView.A = str2;
      paramView.o = true;
      paramView.s = this;
      paramView.t = this.m;
      paramView.c();
      a(paramView, true);
    }
    else
    {
      if (paramString.o) {
        break label514;
      }
      paramString.o = true;
      paramString.t = this.m;
      if (!paramString.E) {
        paramString.c();
      }
      paramView = paramString;
    }
    if ((this.l <= 0) && (paramView.n)) {
      a(paramView, 1, 0, 0, false);
    } else {
      i(paramView);
    }
    if (paramView.J != null)
    {
      if (i3 != 0) {
        paramView.J.setId(i3);
      }
      if (paramView.J.getTag() == null) {
        paramView.J.setTag(str2);
      }
      return paramView.J;
    }
    paramView = new StringBuilder("Fragment ");
    paramView.append(str1);
    paramView.append(" did not create a view.");
    throw new IllegalStateException(paramView.toString());
    label514:
    paramView = new StringBuilder();
    paramView.append(paramAttributeSet.getPositionDescription());
    paramView.append(": Duplicate id 0x");
    paramView.append(Integer.toHexString(i3));
    paramView.append(", tag ");
    paramView.append(str2);
    paramView.append(", or parent id 0x");
    paramView.append(Integer.toHexString(i1));
    paramView.append(" with another fragment for ");
    paramView.append(str1);
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final void p()
  {
    this.u = true;
    h();
    a(0);
    this.m = null;
    this.n = null;
    this.o = null;
  }
  
  public final void q()
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      Fragment localFragment = (Fragment)this.e.get(i1);
      if (localFragment != null) {
        localFragment.r();
      }
      i1 += 1;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    Fragment localFragment = this.o;
    if (localFragment != null) {
      dy.a(localFragment, localStringBuilder);
    } else {
      dy.a(this.m, localStringBuilder);
    }
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  static final class a
    extends cc.b
  {
    View a;
    
    a(View paramView, Animation.AnimationListener paramAnimationListener)
    {
      super((byte)0);
      this.a = paramView;
    }
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      if ((!ex.s(this.a)) && (Build.VERSION.SDK_INT < 24)) {
        this.a.setLayerType(0, null);
      } else {
        this.a.post(new Runnable()
        {
          public final void run()
          {
            cc.a.this.a.setLayerType(0, null);
          }
        });
      }
      super.onAnimationEnd(paramAnimation);
    }
  }
  
  static class b
    implements Animation.AnimationListener
  {
    private final Animation.AnimationListener a;
    
    private b(Animation.AnimationListener paramAnimationListener)
    {
      this.a = paramAnimationListener;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      Animation.AnimationListener localAnimationListener = this.a;
      if (localAnimationListener != null) {
        localAnimationListener.onAnimationEnd(paramAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation)
    {
      Animation.AnimationListener localAnimationListener = this.a;
      if (localAnimationListener != null) {
        localAnimationListener.onAnimationRepeat(paramAnimation);
      }
    }
    
    public void onAnimationStart(Animation paramAnimation)
    {
      Animation.AnimationListener localAnimationListener = this.a;
      if (localAnimationListener != null) {
        localAnimationListener.onAnimationStart(paramAnimation);
      }
    }
  }
  
  static final class c
  {
    public final Animation a;
    public final Animator b;
    
    private c(Animator paramAnimator)
    {
      this.a = null;
      this.b = paramAnimator;
      if (paramAnimator != null) {
        return;
      }
      throw new IllegalStateException("Animator cannot be null");
    }
    
    private c(Animation paramAnimation)
    {
      this.a = paramAnimation;
      this.b = null;
      if (paramAnimation != null) {
        return;
      }
      throw new IllegalStateException("Animation cannot be null");
    }
  }
  
  static final class d
    extends AnimatorListenerAdapter
  {
    View a;
    
    d(View paramView)
    {
      this.a = paramView;
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      this.a.setLayerType(0, null);
      paramAnimator.removeListener(this);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      this.a.setLayerType(2, null);
    }
  }
  
  static final class e
    extends AnimationSet
    implements Runnable
  {
    private final ViewGroup a;
    private final View b;
    private boolean c;
    private boolean d;
    
    e(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
    {
      super();
      this.a = paramViewGroup;
      this.b = paramView;
      addAnimation(paramAnimation);
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation)
    {
      if (this.c) {
        return !this.d;
      }
      if (!super.getTransformation(paramLong, paramTransformation))
      {
        this.c = true;
        cn.a(this.a, this);
      }
      return true;
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
    {
      if (this.c) {
        return !this.d;
      }
      if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        this.c = true;
        cn.a(this.a, this);
      }
      return true;
    }
    
    public final void run()
    {
      this.a.endViewTransition(this.b);
      this.d = true;
    }
  }
  
  static final class f
  {
    public static final int[] a = { 16842755, 16842960, 16842961 };
  }
  
  static abstract interface g
  {
    public abstract boolean a(ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1);
  }
  
  static final class h
    implements Fragment.c
  {
    final boolean a;
    final bv b;
    int c;
    
    h(bv parambv, boolean paramBoolean)
    {
      this.a = paramBoolean;
      this.b = parambv;
    }
    
    public final void a()
    {
      this.c -= 1;
      if (this.c != 0) {
        return;
      }
      cc.a(this.b.a);
    }
    
    public final void b()
    {
      this.c += 1;
    }
    
    public final void c()
    {
      int i = this.c;
      int j = 0;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      cc localcc = this.b.a;
      int k = localcc.e.size();
      while (j < k)
      {
        Fragment localFragment = (Fragment)localcc.e.get(j);
        localFragment.a(null);
        if ((i != 0) && (localFragment.A())) {
          localFragment.l();
        }
        j += 1;
      }
      cc.a(this.b.a, this.b, this.a, i ^ 0x1, true);
    }
    
    public final void d()
    {
      cc.a(this.b.a, this.b, this.a, false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cc
 * JD-Core Version:    0.7.0.1
 */