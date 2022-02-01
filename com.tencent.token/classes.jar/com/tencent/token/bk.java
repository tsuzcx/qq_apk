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

public final class bk
{
  private static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(Context paramContext)
  {
    if (a.getAndSet(true)) {
      return;
    }
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new b());
  }
  
  private static void a(cs paramcs, bj.b paramb)
  {
    paramcs = paramcs.d();
    if (paramcs == null) {
      return;
    }
    paramcs = paramcs.iterator();
    while (paramcs.hasNext())
    {
      Fragment localFragment = (Fragment)paramcs.next();
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
  
  private static void a(Object paramObject, bj.b paramb)
  {
    if ((paramObject instanceof bo)) {
      ((bo)paramObject).a().a(paramb);
    }
  }
  
  public static final class a
    extends Fragment
  {
    private void a(bj.a parama)
    {
      bk.a(this.x, parama);
    }
    
    public final void a()
    {
      super.a();
      a(bj.a.ON_PAUSE);
    }
    
    public final void b()
    {
      super.b();
      a(bj.a.ON_STOP);
    }
    
    public final void c()
    {
      super.c();
      a(bj.a.ON_DESTROY);
    }
  }
  
  static final class b
    extends bh
  {
    private final bk.c a = new bk.c();
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        ((FragmentActivity)paramActivity).getSupportFragmentManager().a(this.a);
      }
      bv.a(paramActivity);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        bk.a((FragmentActivity)paramActivity, bj.b.c);
      }
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      if ((paramActivity instanceof FragmentActivity)) {
        bk.a((FragmentActivity)paramActivity, bj.b.c);
      }
    }
  }
  
  static final class c
    extends cs.a
  {
    public final void a(Fragment paramFragment)
    {
      bk.a(paramFragment, bj.a.ON_CREATE);
      if (!(paramFragment instanceof bo)) {
        return;
      }
      if (paramFragment.e().a("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
        paramFragment.e().a().a(new bk.a(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").b();
      }
    }
    
    public final void b(Fragment paramFragment)
    {
      bk.a(paramFragment, bj.a.ON_START);
    }
    
    public final void c(Fragment paramFragment)
    {
      bk.a(paramFragment, bj.a.ON_RESUME);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bk
 * JD-Core Version:    0.7.0.1
 */