package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ReportFragment
  extends Fragment
{
  private static final String REPORT_FRAGMENT_TAG = "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag";
  private ActivityInitializationListener mProcessListener;
  
  private void dispatch(Lifecycle.Event paramEvent)
  {
    Object localObject = getActivity();
    if ((localObject instanceof LifecycleRegistryOwner))
    {
      ((LifecycleRegistryOwner)localObject).getLifecycle().handleLifecycleEvent(paramEvent);
      return;
    }
    if ((localObject instanceof LifecycleOwner))
    {
      localObject = ((LifecycleOwner)localObject).getLifecycle();
      if ((localObject instanceof LifecycleRegistry)) {
        ((LifecycleRegistry)localObject).handleLifecycleEvent(paramEvent);
      }
    }
  }
  
  private void dispatchCreate(ActivityInitializationListener paramActivityInitializationListener)
  {
    if (paramActivityInitializationListener != null) {
      paramActivityInitializationListener.onCreate();
    }
  }
  
  private void dispatchResume(ActivityInitializationListener paramActivityInitializationListener)
  {
    if (paramActivityInitializationListener != null) {
      paramActivityInitializationListener.onResume();
    }
  }
  
  private void dispatchStart(ActivityInitializationListener paramActivityInitializationListener)
  {
    if (paramActivityInitializationListener != null) {
      paramActivityInitializationListener.onStart();
    }
  }
  
  static ReportFragment get(Activity paramActivity)
  {
    return (ReportFragment)paramActivity.getFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }
  
  public static void injectIfNeededIn(Activity paramActivity)
  {
    paramActivity = paramActivity.getFragmentManager();
    if (paramActivity.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      paramActivity.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      paramActivity.executePendingTransactions();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    dispatchCreate(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    dispatch(Lifecycle.Event.ON_DESTROY);
    this.mProcessListener = null;
  }
  
  public void onPause()
  {
    super.onPause();
    dispatch(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    dispatchResume(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_RESUME);
  }
  
  public void onStart()
  {
    super.onStart();
    dispatchStart(this.mProcessListener);
    dispatch(Lifecycle.Event.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    dispatch(Lifecycle.Event.ON_STOP);
  }
  
  void setProcessListener(ActivityInitializationListener paramActivityInitializationListener)
  {
    this.mProcessListener = paramActivityInitializationListener;
  }
  
  static abstract interface ActivityInitializationListener
  {
    public abstract void onCreate();
    
    public abstract void onResume();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReportFragment
 * JD-Core Version:    0.7.0.1
 */