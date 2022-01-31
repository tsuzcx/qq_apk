package android.support.v4.app;

import android.support.annotation.AnimRes;
import android.support.annotation.AnimatorRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.view.View;

public abstract class FragmentTransaction
{
  public static final int TRANSIT_ENTER_MASK = 4096;
  public static final int TRANSIT_EXIT_MASK = 8192;
  public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
  public static final int TRANSIT_FRAGMENT_FADE = 4099;
  public static final int TRANSIT_FRAGMENT_OPEN = 4097;
  public static final int TRANSIT_NONE = 0;
  public static final int TRANSIT_UNSET = -1;
  
  public abstract FragmentTransaction add(@IdRes int paramInt, Fragment paramFragment);
  
  public abstract FragmentTransaction add(@IdRes int paramInt, Fragment paramFragment, @Nullable String paramString);
  
  public abstract FragmentTransaction add(Fragment paramFragment, String paramString);
  
  public abstract FragmentTransaction addSharedElement(View paramView, String paramString);
  
  public abstract FragmentTransaction addToBackStack(@Nullable String paramString);
  
  public abstract FragmentTransaction attach(Fragment paramFragment);
  
  public abstract int commit();
  
  public abstract int commitAllowingStateLoss();
  
  public abstract void commitNow();
  
  public abstract void commitNowAllowingStateLoss();
  
  public abstract FragmentTransaction detach(Fragment paramFragment);
  
  public abstract FragmentTransaction disallowAddToBackStack();
  
  public abstract FragmentTransaction hide(Fragment paramFragment);
  
  public abstract boolean isAddToBackStackAllowed();
  
  public abstract boolean isEmpty();
  
  public abstract FragmentTransaction remove(Fragment paramFragment);
  
  public abstract FragmentTransaction replace(@IdRes int paramInt, Fragment paramFragment);
  
  public abstract FragmentTransaction replace(@IdRes int paramInt, Fragment paramFragment, @Nullable String paramString);
  
  public abstract FragmentTransaction runOnCommit(Runnable paramRunnable);
  
  @Deprecated
  public abstract FragmentTransaction setAllowOptimization(boolean paramBoolean);
  
  public abstract FragmentTransaction setBreadCrumbShortTitle(@StringRes int paramInt);
  
  public abstract FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence);
  
  public abstract FragmentTransaction setBreadCrumbTitle(@StringRes int paramInt);
  
  public abstract FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence);
  
  public abstract FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int paramInt1, @AnimRes @AnimatorRes int paramInt2);
  
  public abstract FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int paramInt1, @AnimRes @AnimatorRes int paramInt2, @AnimRes @AnimatorRes int paramInt3, @AnimRes @AnimatorRes int paramInt4);
  
  public abstract FragmentTransaction setPrimaryNavigationFragment(Fragment paramFragment);
  
  public abstract FragmentTransaction setReorderingAllowed(boolean paramBoolean);
  
  public abstract FragmentTransaction setTransition(int paramInt);
  
  public abstract FragmentTransaction setTransitionStyle(@StyleRes int paramInt);
  
  public abstract FragmentTransaction show(Fragment paramFragment);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransaction
 * JD-Core Version:    0.7.0.1
 */