package com.tencent.token;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public final class aw
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(Context paramContext)
  {
    if (a.getAndSet(true)) {
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new b());
  }
  
  private static void a(ce paramce, av.b paramb)
  {
    paramce = paramce.d();
    if (paramce == null) {
      return;
    }
    paramce = paramce.iterator();
    while (paramce.hasNext())
    {
      Fragment localFragment = (Fragment)paramce.next();
      if (localFragment != null)
      {
        a(localFragment, paramb);
        int i;
        if ((localFragment.t != null) && (localFragment.l)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          a(localFragment.e(), paramb);
        }
      }
    }
  }
  
  private static void a(Object paramObject, av.b paramb)
  {
    if ((paramObject instanceof ba)) {
      ((ba)paramObject).a().a(paramb);
    }
  }
  
  public static final class a
    extends Fragment
  {
    private void a(av.a parama)
    {
      aw.a(this.x, parama);
    }
    
    public final void a()
    {
      super.a();
      a(av.a.ON_PAUSE);
    }
    
    public final void b()
    {
      super.b();
      a(av.a.ON_STOP);
    }
    
    public final void c()
    {
      super.c();
      a(av.a.ON_DESTROY);
    }
  }
  
  static final class b
    extends at
  {
    private final aw.c a = new aw.c();
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        ((FragmentActivity)paramActivity).getSupportFragmentManager().a(this.a);
      }
      bh.a(paramActivity);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        aw.a((FragmentActivity)paramActivity, av.b.c);
      }
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        aw.a((FragmentActivity)paramActivity, av.b.c);
      }
    }
  }
  
  static final class c
    extends ce.a
  {
    public final void a(Fragment paramFragment)
    {
      aw.a(paramFragment, av.a.ON_CREATE);
      if (!(paramFragment instanceof ba)) {
        return;
      }
      if (paramFragment.e().a("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
        paramFragment.e().a().a(new aw.a(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").b();
      }
    }
    
    public final void b(Fragment paramFragment)
    {
      aw.a(paramFragment, av.a.ON_START);
    }
    
    public final void c(Fragment paramFragment)
    {
      aw.a(paramFragment, av.a.ON_RESUME);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aw
 * JD-Core Version:    0.7.0.1
 */