package com.tencent.token;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public final class bv
  extends Fragment
{
  a a;
  
  public static void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new bv(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  private void a(bj.a parama)
  {
    Object localObject = getActivity();
    if ((localObject instanceof bo))
    {
      ((bo)localObject).a().a(parama);
      return;
    }
    if ((localObject instanceof bm))
    {
      localObject = ((bm)localObject).getLifecycle();
      if ((localObject instanceof bn)) {
        ((bn)localObject).a(parama);
      }
    }
  }
  
  static bv b(Activity paramActivity)
  {
    return (bv)paramActivity.getFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(bj.a.ON_CREATE);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    a(bj.a.ON_DESTROY);
    this.a = null;
  }
  
  public final void onPause()
  {
    super.onPause();
    a(bj.a.ON_PAUSE);
  }
  
  public final void onResume()
  {
    super.onResume();
    a locala = this.a;
    if (locala != null) {
      locala.b();
    }
    a(bj.a.ON_RESUME);
  }
  
  public final void onStart()
  {
    super.onStart();
    a locala = this.a;
    if (locala != null) {
      locala.a();
    }
    a(bj.a.ON_START);
  }
  
  public final void onStop()
  {
    super.onStop();
    a(bj.a.ON_STOP);
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bv
 * JD-Core Version:    0.7.0.1
 */