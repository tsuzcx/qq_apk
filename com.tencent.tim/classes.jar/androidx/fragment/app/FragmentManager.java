package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class FragmentManager
{
  static final FragmentFactory DEFAULT_FACTORY = new FragmentFactory();
  public static final int POP_BACK_STACK_INCLUSIVE = 1;
  private FragmentFactory mFragmentFactory = null;
  
  public static void enableDebugLogging(boolean paramBoolean)
  {
    FragmentManagerImpl.DEBUG = paramBoolean;
  }
  
  public abstract void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener paramOnBackStackChangedListener);
  
  @NonNull
  public abstract FragmentTransaction beginTransaction();
  
  public abstract void dump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString);
  
  public abstract boolean executePendingTransactions();
  
  @Nullable
  public abstract Fragment findFragmentById(@IdRes int paramInt);
  
  @Nullable
  public abstract Fragment findFragmentByTag(@Nullable String paramString);
  
  @NonNull
  public abstract BackStackEntry getBackStackEntryAt(int paramInt);
  
  public abstract int getBackStackEntryCount();
  
  @Nullable
  public abstract Fragment getFragment(@NonNull Bundle paramBundle, @NonNull String paramString);
  
  @NonNull
  public FragmentFactory getFragmentFactory()
  {
    if (this.mFragmentFactory == null) {
      this.mFragmentFactory = DEFAULT_FACTORY;
    }
    return this.mFragmentFactory;
  }
  
  @NonNull
  public abstract List<Fragment> getFragments();
  
  @Nullable
  public abstract Fragment getPrimaryNavigationFragment();
  
  public abstract boolean isDestroyed();
  
  public abstract boolean isStateSaved();
  
  @Deprecated
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public FragmentTransaction openTransaction()
  {
    return beginTransaction();
  }
  
  public abstract void popBackStack();
  
  public abstract void popBackStack(int paramInt1, int paramInt2);
  
  public abstract void popBackStack(@Nullable String paramString, int paramInt);
  
  public abstract boolean popBackStackImmediate();
  
  public abstract boolean popBackStackImmediate(int paramInt1, int paramInt2);
  
  public abstract boolean popBackStackImmediate(@Nullable String paramString, int paramInt);
  
  public abstract void putFragment(@NonNull Bundle paramBundle, @NonNull String paramString, @NonNull Fragment paramFragment);
  
  public abstract void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean);
  
  public abstract void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener paramOnBackStackChangedListener);
  
  @Nullable
  public abstract Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment paramFragment);
  
  public void setFragmentFactory(@NonNull FragmentFactory paramFragmentFactory)
  {
    this.mFragmentFactory = paramFragmentFactory;
  }
  
  public abstract void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks);
  
  public static abstract interface BackStackEntry
  {
    @Nullable
    public abstract CharSequence getBreadCrumbShortTitle();
    
    @StringRes
    public abstract int getBreadCrumbShortTitleRes();
    
    @Nullable
    public abstract CharSequence getBreadCrumbTitle();
    
    @StringRes
    public abstract int getBreadCrumbTitleRes();
    
    public abstract int getId();
    
    @Nullable
    public abstract String getName();
  }
  
  public static abstract class FragmentLifecycleCallbacks
  {
    public void onFragmentActivityCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @Nullable Bundle paramBundle) {}
    
    public void onFragmentAttached(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull Context paramContext) {}
    
    public void onFragmentCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @Nullable Bundle paramBundle) {}
    
    public void onFragmentDestroyed(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
    
    public void onFragmentDetached(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
    
    public void onFragmentPaused(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
    
    public void onFragmentPreAttached(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull Context paramContext) {}
    
    public void onFragmentPreCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @Nullable Bundle paramBundle) {}
    
    public void onFragmentResumed(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
    
    public void onFragmentSaveInstanceState(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull Bundle paramBundle) {}
    
    public void onFragmentStarted(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
    
    public void onFragmentStopped(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
    
    public void onFragmentViewCreated(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment, @NonNull View paramView, @Nullable Bundle paramBundle) {}
    
    public void onFragmentViewDestroyed(@NonNull FragmentManager paramFragmentManager, @NonNull Fragment paramFragment) {}
  }
  
  public static abstract interface OnBackStackChangedListener
  {
    public abstract void onBackStackChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager
 * JD-Core Version:    0.7.0.1
 */