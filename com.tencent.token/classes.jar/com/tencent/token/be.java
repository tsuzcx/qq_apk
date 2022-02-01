package com.tencent.token;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public final class be
  extends Fragment
{
  private a a;
  
  public static void a(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new be(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  private void a(au.a parama)
  {
    Object localObject = getActivity();
    if ((localObject instanceof ay))
    {
      ((ay)localObject).a().a(parama);
      return;
    }
    if ((localObject instanceof aw))
    {
      localObject = ((aw)localObject).getLifecycle();
      if ((localObject instanceof ax)) {
        ((ax)localObject).a(parama);
      }
    }
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a(au.a.ON_CREATE);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    a(au.a.ON_DESTROY);
    this.a = null;
  }
  
  public final void onPause()
  {
    super.onPause();
    a(au.a.ON_PAUSE);
  }
  
  public final void onResume()
  {
    super.onResume();
    a(au.a.ON_RESUME);
  }
  
  public final void onStart()
  {
    super.onStart();
    a(au.a.ON_START);
  }
  
  public final void onStop()
  {
    super.onStop();
    a(au.a.ON_STOP);
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.be
 * JD-Core Version:    0.7.0.1
 */