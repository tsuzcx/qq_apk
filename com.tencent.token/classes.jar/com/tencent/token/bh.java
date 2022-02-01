package com.tencent.token;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public final class bh
  extends Fragment
{
  a a;
  
  public static void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new bh(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  private void a(av.a parama)
  {
    Object localObject = getActivity();
    if ((localObject instanceof ba))
    {
      ((ba)localObject).a().a(parama);
      return;
    }
    if ((localObject instanceof ay))
    {
      localObject = ((ay)localObject).getLifecycle();
      if ((localObject instanceof az)) {
        ((az)localObject).a(parama);
      }
    }
  }
  
  static bh b(Activity paramActivity)
  {
    return (bh)paramActivity.getFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(av.a.ON_CREATE);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    a(av.a.ON_DESTROY);
    this.a = null;
  }
  
  public final void onPause()
  {
    super.onPause();
    a(av.a.ON_PAUSE);
  }
  
  public final void onResume()
  {
    super.onResume();
    a locala = this.a;
    if (locala != null) {
      locala.b();
    }
    a(av.a.ON_RESUME);
  }
  
  public final void onStart()
  {
    super.onStart();
    a locala = this.a;
    if (locala != null) {
      locala.a();
    }
    a(av.a.ON_START);
  }
  
  public final void onStop()
  {
    super.onStop();
    a(av.a.ON_STOP);
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bh
 * JD-Core Version:    0.7.0.1
 */