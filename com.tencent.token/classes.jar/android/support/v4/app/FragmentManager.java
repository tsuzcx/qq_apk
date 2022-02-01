package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager
{
  public static final int POP_BACK_STACK_INCLUSIVE = 1;
  
  public static void enableDebugLogging(boolean paramBoolean)
  {
    FragmentManagerImpl.DEBUG = paramBoolean;
  }
  
  public abstract void addOnBackStackChangedListener(OnBackStackChangedListener paramOnBackStackChangedListener);
  
  public abstract FragmentTransaction beginTransaction();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract boolean executePendingTransactions();
  
  public abstract Fragment findFragmentById(@IdRes int paramInt);
  
  public abstract Fragment findFragmentByTag(String paramString);
  
  public abstract BackStackEntry getBackStackEntryAt(int paramInt);
  
  public abstract int getBackStackEntryCount();
  
  public abstract Fragment getFragment(Bundle paramBundle, String paramString);
  
  public abstract List<Fragment> getFragments();
  
  public abstract Fragment getPrimaryNavigationFragment();
  
  public abstract boolean isDestroyed();
  
  public abstract boolean isStateSaved();
  
  @Deprecated
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public FragmentTransaction openTransaction()
  {
    return beginTransaction();
  }
  
  public abstract void popBackStack();
  
  public abstract void popBackStack(int paramInt1, int paramInt2);
  
  public abstract void popBackStack(String paramString, int paramInt);
  
  public abstract boolean popBackStackImmediate();
  
  public abstract boolean popBackStackImmediate(int paramInt1, int paramInt2);
  
  public abstract boolean popBackStackImmediate(String paramString, int paramInt);
  
  public abstract void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment);
  
  public abstract void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean);
  
  public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener paramOnBackStackChangedListener);
  
  public abstract Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment);
  
  public abstract void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks);
  
  public static abstract interface BackStackEntry
  {
    public abstract CharSequence getBreadCrumbShortTitle();
    
    @StringRes
    public abstract int getBreadCrumbShortTitleRes();
    
    public abstract CharSequence getBreadCrumbTitle();
    
    @StringRes
    public abstract int getBreadCrumbTitleRes();
    
    public abstract int getId();
    
    public abstract String getName();
  }
  
  public static abstract class FragmentLifecycleCallbacks
  {
    public void onFragmentActivityCreated(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onFragmentAttached(FragmentManager paramFragmentManager, Fragment paramFragment, Context paramContext) {}
    
    public void onFragmentCreated(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onFragmentDestroyed(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void onFragmentDetached(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void onFragmentPaused(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void onFragmentPreAttached(FragmentManager paramFragmentManager, Fragment paramFragment, Context paramContext) {}
    
    public void onFragmentPreCreated(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onFragmentResumed(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void onFragmentSaveInstanceState(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle) {}
    
    public void onFragmentStarted(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void onFragmentStopped(FragmentManager paramFragmentManager, Fragment paramFragment) {}
    
    public void onFragmentViewCreated(FragmentManager paramFragmentManager, Fragment paramFragment, View paramView, Bundle paramBundle) {}
    
    public void onFragmentViewDestroyed(FragmentManager paramFragmentManager, Fragment paramFragment) {}
  }
  
  public static abstract interface OnBackStackChangedListener
  {
    public abstract void onBackStackChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManager
 * JD-Core Version:    0.7.0.1
 */