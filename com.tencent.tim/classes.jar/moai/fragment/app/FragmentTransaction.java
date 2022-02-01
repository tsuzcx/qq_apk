package moai.fragment.app;

import android.view.View;
import androidx.annotation.AnimRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

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
  
  public abstract FragmentTransaction setAllowOptimization(boolean paramBoolean);
  
  public abstract FragmentTransaction setBreadCrumbShortTitle(@StringRes int paramInt);
  
  public abstract FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence);
  
  public abstract FragmentTransaction setBreadCrumbTitle(@StringRes int paramInt);
  
  public abstract FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence);
  
  public abstract FragmentTransaction setCustomAnimations(@AnimRes int paramInt1, @AnimRes int paramInt2);
  
  public abstract FragmentTransaction setCustomAnimations(@AnimRes int paramInt1, @AnimRes int paramInt2, @AnimRes int paramInt3, @AnimRes int paramInt4);
  
  public abstract FragmentTransaction setTransition(int paramInt);
  
  public abstract FragmentTransaction setTransitionStyle(@StyleRes int paramInt);
  
  public abstract FragmentTransaction show(Fragment paramFragment);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentTransaction
 * JD-Core Version:    0.7.0.1
 */