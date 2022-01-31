package android.support.v4.app;

import android.graphics.Rect;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract class FragmentTransitionImpl
{
  protected static void bfsAddViewChildren(List paramList, View paramView)
  {
    int k = paramList.size();
    if (containedBeforeIndex(paramList, paramView, k)) {}
    for (;;)
    {
      return;
      paramList.add(paramView);
      int i = k;
      while (i < paramList.size())
      {
        paramView = (View)paramList.get(i);
        if ((paramView instanceof ViewGroup))
        {
          paramView = (ViewGroup)paramView;
          int m = paramView.getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView = paramView.getChildAt(j);
            if (!containedBeforeIndex(paramList, localView, k)) {
              paramList.add(localView);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private static boolean containedBeforeIndex(List paramList, View paramView, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramInt)
      {
        if (paramList.get(i) == paramView) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  static String findKeyForValue(Map paramMap, String paramString)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (paramString.equals(localEntry.getValue())) {
        return (String)localEntry.getKey();
      }
    }
    return null;
  }
  
  protected static boolean isNullOrEmpty(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public abstract void addTarget(Object paramObject, View paramView);
  
  public abstract void addTargets(Object paramObject, ArrayList paramArrayList);
  
  public abstract void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract boolean canHandle(Object paramObject);
  
  void captureTransitioningViews(ArrayList paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup)) {
        break label64;
      }
      paramView = (ViewGroup)paramView;
      if (!ViewGroupCompat.isTransitionGroup(paramView)) {
        break label33;
      }
      paramArrayList.add(paramView);
    }
    for (;;)
    {
      return;
      label33:
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        captureTransitioningViews(paramArrayList, paramView.getChildAt(i));
        i += 1;
      }
    }
    label64:
    paramArrayList.add(paramView);
  }
  
  public abstract Object cloneTransition(Object paramObject);
  
  void findNamedViews(Map paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = ViewCompat.getTransitionName(paramView);
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          findNamedViews(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  protected void getBoundsOnScreen(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  public abstract Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3);
  
  ArrayList prepareSetNameOverridesReordered(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      localArrayList.add(ViewCompat.getTransitionName(localView));
      ViewCompat.setTransitionName(localView, null);
      i += 1;
    }
    return localArrayList;
  }
  
  public abstract void removeTarget(Object paramObject, View paramView);
  
  public abstract void replaceTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public abstract void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList paramArrayList);
  
  void scheduleNameReset(ViewGroup paramViewGroup, ArrayList paramArrayList, Map paramMap)
  {
    OneShotPreDrawListener.add(paramViewGroup, new FragmentTransitionImpl.3(this, paramArrayList, paramMap));
  }
  
  public abstract void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3);
  
  public abstract void setEpicenter(Object paramObject, Rect paramRect);
  
  public abstract void setEpicenter(Object paramObject, View paramView);
  
  void setNameOverridesOrdered(View paramView, ArrayList paramArrayList, Map paramMap)
  {
    OneShotPreDrawListener.add(paramView, new FragmentTransitionImpl.2(this, paramArrayList, paramMap));
  }
  
  void setNameOverridesReordered(View paramView, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Map paramMap)
  {
    int k = paramArrayList2.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      Object localObject = (View)paramArrayList1.get(i);
      String str = ViewCompat.getTransitionName((View)localObject);
      localArrayList.add(str);
      if (str == null) {}
      label134:
      for (;;)
      {
        i += 1;
        break;
        ViewCompat.setTransitionName((View)localObject, null);
        localObject = (String)paramMap.get(str);
        int j = 0;
        for (;;)
        {
          if (j >= k) {
            break label134;
          }
          if (((String)localObject).equals(paramArrayList3.get(j)))
          {
            ViewCompat.setTransitionName((View)paramArrayList2.get(j), str);
            break;
          }
          j += 1;
        }
      }
    }
    OneShotPreDrawListener.add(paramView, new FragmentTransitionImpl.1(this, k, paramArrayList2, paramArrayList3, paramArrayList1, localArrayList));
  }
  
  public abstract void setSharedElementTargets(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public abstract void swapSharedElementTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public abstract Object wrapTransitionInSet(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionImpl
 * JD-Core Version:    0.7.0.1
 */