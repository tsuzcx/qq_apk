package com.facebook.stetho.common.android;

import android.app.Activity;
import android.view.View;
import java.util.List;
import javax.annotation.Nullable;

public final class FragmentCompatUtil
{
  @Nullable
  public static Object findFragmentForView(View paramView)
  {
    Activity localActivity = ViewUtil.tryGetActivity(paramView);
    if (localActivity == null) {
      return null;
    }
    return findFragmentForViewInActivity(localActivity, paramView);
  }
  
  @Nullable
  private static Object findFragmentForViewInActivity(Activity paramActivity, View paramView)
  {
    Object localObject1 = FragmentCompat.getMoaiLibInstance();
    if ((localObject1 != null) && (((FragmentCompat)localObject1).getFragmentActivityClass().isInstance(paramActivity)))
    {
      localObject1 = findFragmentForViewInActivity((FragmentCompat)localObject1, paramActivity, paramView);
      if (localObject1 == null) {}
    }
    do
    {
      Object localObject2;
      do
      {
        return localObject1;
        localObject1 = FragmentCompat.getSupportLibInstance();
        if ((localObject1 == null) || (!((FragmentCompat)localObject1).getFragmentActivityClass().isInstance(paramActivity))) {
          break;
        }
        localObject2 = findFragmentForViewInActivity((FragmentCompat)localObject1, paramActivity, paramView);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = FragmentCompat.getFrameworkInstance();
      if (localObject1 == null) {
        break;
      }
      paramActivity = findFragmentForViewInActivity((FragmentCompat)localObject1, paramActivity, paramView);
      localObject1 = paramActivity;
    } while (paramActivity != null);
    return null;
  }
  
  private static Object findFragmentForViewInActivity(FragmentCompat paramFragmentCompat, Activity paramActivity, View paramView)
  {
    paramActivity = paramFragmentCompat.forFragmentActivity().getFragmentManager(paramActivity);
    if (paramActivity != null) {
      return findFragmentForViewInFragmentManager(paramFragmentCompat, paramActivity, paramView);
    }
    return null;
  }
  
  @Nullable
  private static Object findFragmentForViewInFragment(FragmentCompat paramFragmentCompat, Object paramObject, View paramView)
  {
    FragmentAccessor localFragmentAccessor = paramFragmentCompat.forFragment();
    if (localFragmentAccessor.getView(paramObject) == paramView) {
      return paramObject;
    }
    paramObject = localFragmentAccessor.getChildFragmentManager(paramObject);
    if (paramObject != null) {
      return findFragmentForViewInFragmentManager(paramFragmentCompat, paramObject, paramView);
    }
    return null;
  }
  
  @Nullable
  private static Object findFragmentForViewInFragmentManager(FragmentCompat paramFragmentCompat, Object paramObject, View paramView)
  {
    paramObject = paramFragmentCompat.forFragmentManager().getAddedFragments(paramObject);
    if (paramObject != null)
    {
      int j = paramObject.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = findFragmentForViewInFragment(paramFragmentCompat, paramObject.get(i), paramView);
        if (localObject != null) {
          return localObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static boolean isDialogFragment(Object paramObject)
  {
    FragmentCompat localFragmentCompat = FragmentCompat.getMoaiLibInstance();
    if ((localFragmentCompat != null) && (localFragmentCompat.getDialogFragmentClass().isInstance(paramObject))) {}
    do
    {
      do
      {
        return true;
        localFragmentCompat = FragmentCompat.getSupportLibInstance();
      } while ((localFragmentCompat != null) && (localFragmentCompat.getDialogFragmentClass().isInstance(paramObject)));
      localFragmentCompat = FragmentCompat.getFrameworkInstance();
    } while ((localFragmentCompat != null) && (localFragmentCompat.getDialogFragmentClass().isInstance(paramObject)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.FragmentCompatUtil
 * JD-Core Version:    0.7.0.1
 */