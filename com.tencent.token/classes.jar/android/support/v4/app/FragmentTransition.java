package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FragmentTransition
{
  private static final int[] INVERSE_OPS = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  private static final FragmentTransitionImpl PLATFORM_IMPL;
  private static final FragmentTransitionImpl SUPPORT_IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (FragmentTransitionCompat21 localFragmentTransitionCompat21 = new FragmentTransitionCompat21();; localFragmentTransitionCompat21 = null)
    {
      PLATFORM_IMPL = localFragmentTransitionCompat21;
      SUPPORT_IMPL = resolveSupportImpl();
      return;
    }
  }
  
  private static void addSharedElementsWithMatchingNames(ArrayList paramArrayList, ArrayMap paramArrayMap, Collection paramCollection)
  {
    int i = paramArrayMap.size() - 1;
    while (i >= 0)
    {
      View localView = (View)paramArrayMap.valueAt(i);
      if (paramCollection.contains(ViewCompat.getTransitionName(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static void addToFirstInLastOut(BackStackRecord paramBackStackRecord, BackStackRecord.Op paramOp, SparseArray paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = paramOp.fragment;
    if (localFragment == null) {}
    int n;
    do
    {
      return;
      n = localFragment.mContainerId;
    } while (n == 0);
    int i;
    label38:
    int j;
    int k;
    boolean bool;
    if (paramBoolean1)
    {
      i = INVERSE_OPS[paramOp.cmd];
      switch (i)
      {
      case 2: 
      default: 
        i = 0;
        j = 0;
        k = 0;
        bool = false;
        paramOp = (FragmentTransition.FragmentContainerTransition)paramSparseArray.get(n);
        if (bool)
        {
          paramOp = ensureContainer(paramOp, paramSparseArray, n);
          paramOp.lastIn = localFragment;
          paramOp.lastInIsPop = paramBoolean1;
          paramOp.lastInTransaction = paramBackStackRecord;
        }
        break;
      }
    }
    for (;;)
    {
      if ((!paramBoolean2) && (i != 0))
      {
        if ((paramOp != null) && (paramOp.firstOut == localFragment)) {
          paramOp.firstOut = null;
        }
        FragmentManagerImpl localFragmentManagerImpl = paramBackStackRecord.mManager;
        if ((localFragment.mState < 1) && (localFragmentManagerImpl.mCurState >= 1) && (!paramBackStackRecord.mReorderingAllowed))
        {
          localFragmentManagerImpl.makeActive(localFragment);
          localFragmentManagerImpl.moveToState(localFragment, 1, 0, 0, false);
        }
      }
      if ((j != 0) && ((paramOp == null) || (paramOp.firstOut == null)))
      {
        paramOp = ensureContainer(paramOp, paramSparseArray, n);
        paramOp.firstOut = localFragment;
        paramOp.firstOutIsPop = paramBoolean1;
        paramOp.firstOutTransaction = paramBackStackRecord;
      }
      for (paramBackStackRecord = paramOp; (!paramBoolean2) && (k != 0) && (paramBackStackRecord != null) && (paramBackStackRecord.lastIn == localFragment); paramBackStackRecord = paramOp)
      {
        paramBackStackRecord.lastIn = null;
        return;
        i = paramOp.cmd;
        break label38;
        if (paramBoolean2) {
          if ((localFragment.mHiddenChanged) && (!localFragment.mHidden) && (localFragment.mAdded)) {
            bool = true;
          }
        }
        for (;;)
        {
          i = 1;
          j = 0;
          k = 0;
          break;
          bool = false;
          continue;
          bool = localFragment.mHidden;
        }
        if (paramBoolean2) {
          bool = localFragment.mIsNewlyAdded;
        }
        for (;;)
        {
          i = 1;
          j = 0;
          k = 0;
          break;
          if ((!localFragment.mAdded) && (!localFragment.mHidden)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        if (paramBoolean2) {
          if ((localFragment.mHiddenChanged) && (localFragment.mAdded) && (localFragment.mHidden)) {
            i = 1;
          }
        }
        int m;
        for (;;)
        {
          m = 0;
          j = i;
          k = 1;
          bool = false;
          i = m;
          break;
          i = 0;
          continue;
          if ((localFragment.mAdded) && (!localFragment.mHidden)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        if (paramBoolean2) {
          if ((!localFragment.mAdded) && (localFragment.mView != null) && (localFragment.mView.getVisibility() == 0) && (localFragment.mPostponedAlpha >= 0.0F)) {
            i = 1;
          }
        }
        for (;;)
        {
          m = 0;
          j = i;
          k = 1;
          bool = false;
          i = m;
          break;
          i = 0;
          continue;
          if ((localFragment.mAdded) && (!localFragment.mHidden)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  public static void calculateFragments(BackStackRecord paramBackStackRecord, SparseArray paramSparseArray, boolean paramBoolean)
  {
    int j = paramBackStackRecord.mOps.size();
    int i = 0;
    while (i < j)
    {
      addToFirstInLastOut(paramBackStackRecord, (BackStackRecord.Op)paramBackStackRecord.mOps.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static ArrayMap calculateNameOverrides(int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt2, int paramInt3)
  {
    ArrayMap localArrayMap = new ArrayMap();
    paramInt3 -= 1;
    if (paramInt3 >= paramInt2)
    {
      Object localObject = (BackStackRecord)paramArrayList1.get(paramInt3);
      if (!((BackStackRecord)localObject).interactsWith(paramInt1)) {}
      boolean bool;
      do
      {
        paramInt3 -= 1;
        break;
        bool = ((Boolean)paramArrayList2.get(paramInt3)).booleanValue();
      } while (((BackStackRecord)localObject).mSharedElementSourceNames == null);
      int j = ((BackStackRecord)localObject).mSharedElementSourceNames.size();
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      label101:
      int i;
      label104:
      String str1;
      if (bool)
      {
        localArrayList1 = ((BackStackRecord)localObject).mSharedElementSourceNames;
        localArrayList2 = ((BackStackRecord)localObject).mSharedElementTargetNames;
        i = 0;
        if (i < j)
        {
          localObject = (String)localArrayList2.get(i);
          str1 = (String)localArrayList1.get(i);
          String str2 = (String)localArrayMap.remove(str1);
          if (str2 == null) {
            break label188;
          }
          localArrayMap.put(localObject, str2);
        }
      }
      for (;;)
      {
        i += 1;
        break label104;
        break;
        localArrayList2 = ((BackStackRecord)localObject).mSharedElementSourceNames;
        localArrayList1 = ((BackStackRecord)localObject).mSharedElementTargetNames;
        break label101;
        label188:
        localArrayMap.put(localObject, str1);
      }
    }
    return localArrayMap;
  }
  
  public static void calculatePopFragments(BackStackRecord paramBackStackRecord, SparseArray paramSparseArray, boolean paramBoolean)
  {
    if (!paramBackStackRecord.mManager.mContainer.onHasView()) {}
    for (;;)
    {
      return;
      int i = paramBackStackRecord.mOps.size() - 1;
      while (i >= 0)
      {
        addToFirstInLastOut(paramBackStackRecord, (BackStackRecord.Op)paramBackStackRecord.mOps.get(i), paramSparseArray, true, paramBoolean);
        i -= 1;
      }
    }
  }
  
  private static void callSharedElementStartEnd(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, ArrayMap paramArrayMap, boolean paramBoolean2)
  {
    int j = 0;
    ArrayList localArrayList;
    int i;
    if (paramBoolean1)
    {
      paramFragment1 = paramFragment2.getEnterTransitionCallback();
      if (paramFragment1 == null) {
        break label109;
      }
      paramFragment2 = new ArrayList();
      localArrayList = new ArrayList();
      if (paramArrayMap != null) {
        break label87;
      }
      i = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label96;
      }
      localArrayList.add(paramArrayMap.keyAt(j));
      paramFragment2.add(paramArrayMap.valueAt(j));
      j += 1;
      continue;
      paramFragment1 = paramFragment1.getEnterTransitionCallback();
      break;
      label87:
      i = paramArrayMap.size();
    }
    label96:
    if (paramBoolean2)
    {
      paramFragment1.onSharedElementStart(localArrayList, paramFragment2, null);
      label109:
      return;
    }
    paramFragment1.onSharedElementEnd(localArrayList, paramFragment2, null);
  }
  
  private static boolean canHandleAll(FragmentTransitionImpl paramFragmentTransitionImpl, List paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramFragmentTransitionImpl.canHandle(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static ArrayMap captureInSharedElements(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap paramArrayMap, Object paramObject, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition)
  {
    Fragment localFragment = paramFragmentContainerTransition.lastIn;
    View localView = localFragment.getView();
    if ((paramArrayMap.isEmpty()) || (paramObject == null) || (localView == null))
    {
      paramArrayMap.clear();
      return null;
    }
    ArrayMap localArrayMap = new ArrayMap();
    paramFragmentTransitionImpl.findNamedViews(localArrayMap, localView);
    paramFragmentTransitionImpl = paramFragmentContainerTransition.lastInTransaction;
    int i;
    if (paramFragmentContainerTransition.lastInIsPop)
    {
      paramObject = localFragment.getExitTransitionCallback();
      paramFragmentTransitionImpl = paramFragmentTransitionImpl.mSharedElementSourceNames;
      if (paramFragmentTransitionImpl != null)
      {
        localArrayMap.retainAll(paramFragmentTransitionImpl);
        localArrayMap.retainAll(paramArrayMap.values());
      }
      if (paramObject == null) {
        break label217;
      }
      paramObject.onMapSharedElements(paramFragmentTransitionImpl, localArrayMap);
      i = paramFragmentTransitionImpl.size() - 1;
      label115:
      if (i < 0) {
        break label223;
      }
      paramFragmentContainerTransition = (String)paramFragmentTransitionImpl.get(i);
      paramObject = (View)localArrayMap.get(paramFragmentContainerTransition);
      if (paramObject != null) {
        break label183;
      }
      paramObject = findKeyForValue(paramArrayMap, paramFragmentContainerTransition);
      if (paramObject != null) {
        paramArrayMap.remove(paramObject);
      }
    }
    for (;;)
    {
      i -= 1;
      break label115;
      paramObject = localFragment.getEnterTransitionCallback();
      paramFragmentTransitionImpl = paramFragmentTransitionImpl.mSharedElementTargetNames;
      break;
      label183:
      if (!paramFragmentContainerTransition.equals(ViewCompat.getTransitionName(paramObject)))
      {
        paramFragmentContainerTransition = findKeyForValue(paramArrayMap, paramFragmentContainerTransition);
        if (paramFragmentContainerTransition != null) {
          paramArrayMap.put(paramFragmentContainerTransition, ViewCompat.getTransitionName(paramObject));
        }
      }
    }
    label217:
    retainValues(paramArrayMap, localArrayMap);
    label223:
    return localArrayMap;
  }
  
  private static ArrayMap captureOutSharedElements(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayMap paramArrayMap, Object paramObject, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition)
  {
    if ((paramArrayMap.isEmpty()) || (paramObject == null))
    {
      paramArrayMap.clear();
      return null;
    }
    paramObject = paramFragmentContainerTransition.firstOut;
    ArrayMap localArrayMap = new ArrayMap();
    paramFragmentTransitionImpl.findNamedViews(localArrayMap, paramObject.getView());
    paramFragmentTransitionImpl = paramFragmentContainerTransition.firstOutTransaction;
    int i;
    if (paramFragmentContainerTransition.firstOutIsPop)
    {
      paramObject = paramObject.getEnterTransitionCallback();
      paramFragmentTransitionImpl = paramFragmentTransitionImpl.mSharedElementTargetNames;
      localArrayMap.retainAll(paramFragmentTransitionImpl);
      if (paramObject == null) {
        break label179;
      }
      paramObject.onMapSharedElements(paramFragmentTransitionImpl, localArrayMap);
      i = paramFragmentTransitionImpl.size() - 1;
      label89:
      if (i < 0) {
        break label189;
      }
      paramFragmentContainerTransition = (String)paramFragmentTransitionImpl.get(i);
      paramObject = (View)localArrayMap.get(paramFragmentContainerTransition);
      if (paramObject != null) {
        break label146;
      }
      paramArrayMap.remove(paramFragmentContainerTransition);
    }
    for (;;)
    {
      i -= 1;
      break label89;
      paramObject = paramObject.getExitTransitionCallback();
      paramFragmentTransitionImpl = paramFragmentTransitionImpl.mSharedElementSourceNames;
      break;
      label146:
      if (!paramFragmentContainerTransition.equals(ViewCompat.getTransitionName(paramObject)))
      {
        paramFragmentContainerTransition = (String)paramArrayMap.remove(paramFragmentContainerTransition);
        paramArrayMap.put(ViewCompat.getTransitionName(paramObject), paramFragmentContainerTransition);
      }
    }
    label179:
    paramArrayMap.retainAll(localArrayMap.keySet());
    label189:
    return localArrayMap;
  }
  
  private static FragmentTransitionImpl chooseImpl(Fragment paramFragment1, Fragment paramFragment2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject = paramFragment1.getExitTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramFragment1.getReturnTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramFragment1 = paramFragment1.getSharedElementReturnTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.getEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getReenterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getSharedElementEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (localArrayList.isEmpty()) {}
    do
    {
      return null;
      if ((PLATFORM_IMPL != null) && (canHandleAll(PLATFORM_IMPL, localArrayList))) {
        return PLATFORM_IMPL;
      }
      if ((SUPPORT_IMPL != null) && (canHandleAll(SUPPORT_IMPL, localArrayList))) {
        return SUPPORT_IMPL;
      }
    } while ((PLATFORM_IMPL == null) && (SUPPORT_IMPL == null));
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  private static ArrayList configureEnteringExitingViews(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject, Fragment paramFragment, ArrayList paramArrayList, View paramView)
  {
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.getView();
      if (paramFragment != null) {
        paramFragmentTransitionImpl.captureTransitioningViews(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      localObject = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramFragmentTransitionImpl.addTargets(paramObject, localArrayList);
        localObject = localArrayList;
      }
    }
    return localObject;
  }
  
  private static Object configureSharedElementsOrdered(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, View paramView, ArrayMap paramArrayMap, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, ArrayList paramArrayList1, ArrayList paramArrayList2, Object paramObject1, Object paramObject2)
  {
    Fragment localFragment1 = paramFragmentContainerTransition.lastIn;
    Fragment localFragment2 = paramFragmentContainerTransition.firstOut;
    if ((localFragment1 == null) || (localFragment2 == null)) {
      return null;
    }
    boolean bool = paramFragmentContainerTransition.lastInIsPop;
    Object localObject;
    ArrayMap localArrayMap;
    if (paramArrayMap.isEmpty())
    {
      localObject = null;
      localArrayMap = captureOutSharedElements(paramFragmentTransitionImpl, paramArrayMap, localObject, paramFragmentContainerTransition);
      if (!paramArrayMap.isEmpty()) {
        break label96;
      }
      localObject = null;
    }
    for (;;)
    {
      if ((paramObject1 != null) || (paramObject2 != null) || (localObject != null)) {
        break label110;
      }
      return null;
      localObject = getSharedElementTransition(paramFragmentTransitionImpl, localFragment1, localFragment2, bool);
      break;
      label96:
      paramArrayList1.addAll(localArrayMap.values());
    }
    label110:
    callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap, true);
    Rect localRect;
    if (localObject != null)
    {
      localRect = new Rect();
      paramFragmentTransitionImpl.setSharedElementTargets(localObject, paramView, paramArrayList1);
      setOutEpicenter(paramFragmentTransitionImpl, localObject, paramObject2, localArrayMap, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
      paramObject2 = localRect;
      if (paramObject1 != null) {
        paramFragmentTransitionImpl.setEpicenter(paramObject1, localRect);
      }
    }
    for (paramObject2 = localRect;; paramObject2 = null)
    {
      OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.4(paramFragmentTransitionImpl, paramArrayMap, localObject, paramFragmentContainerTransition, paramArrayList2, paramView, localFragment1, localFragment2, bool, paramArrayList1, paramObject1, paramObject2));
      return localObject;
    }
  }
  
  private static Object configureSharedElementsReordered(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, View paramView, ArrayMap paramArrayMap, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, ArrayList paramArrayList1, ArrayList paramArrayList2, Object paramObject1, Object paramObject2)
  {
    Fragment localFragment1 = paramFragmentContainerTransition.lastIn;
    Fragment localFragment2 = paramFragmentContainerTransition.firstOut;
    if (localFragment1 != null) {
      localFragment1.getView().setVisibility(0);
    }
    if ((localFragment1 == null) || (localFragment2 == null)) {
      return null;
    }
    boolean bool = paramFragmentContainerTransition.lastInIsPop;
    Object localObject;
    ArrayMap localArrayMap2;
    ArrayMap localArrayMap1;
    if (paramArrayMap.isEmpty())
    {
      localObject = null;
      localArrayMap2 = captureOutSharedElements(paramFragmentTransitionImpl, paramArrayMap, localObject, paramFragmentContainerTransition);
      localArrayMap1 = captureInSharedElements(paramFragmentTransitionImpl, paramArrayMap, localObject, paramFragmentContainerTransition);
      if (!paramArrayMap.isEmpty()) {
        break label146;
      }
      localObject = null;
      if (localArrayMap2 != null) {
        localArrayMap2.clear();
      }
      paramArrayMap = localObject;
      if (localArrayMap1 != null) {
        localArrayMap1.clear();
      }
    }
    for (paramArrayMap = localObject;; paramArrayMap = localObject)
    {
      if ((paramObject1 != null) || (paramObject2 != null) || (paramArrayMap != null)) {
        break label174;
      }
      return null;
      localObject = getSharedElementTransition(paramFragmentTransitionImpl, localFragment1, localFragment2, bool);
      break;
      label146:
      addSharedElementsWithMatchingNames(paramArrayList1, localArrayMap2, paramArrayMap.keySet());
      addSharedElementsWithMatchingNames(paramArrayList2, localArrayMap1, paramArrayMap.values());
    }
    label174:
    callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap2, true);
    if (paramArrayMap != null)
    {
      paramArrayList2.add(paramView);
      paramFragmentTransitionImpl.setSharedElementTargets(paramArrayMap, paramView, paramArrayList1);
      setOutEpicenter(paramFragmentTransitionImpl, paramArrayMap, paramObject2, localArrayMap2, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
      paramArrayList1 = new Rect();
      paramArrayList2 = getInEpicenterView(localArrayMap1, paramFragmentContainerTransition, paramObject1, bool);
      paramView = paramArrayList2;
      paramFragmentContainerTransition = paramArrayList1;
      if (paramArrayList2 != null)
      {
        paramFragmentTransitionImpl.setEpicenter(paramObject1, paramArrayList1);
        paramFragmentContainerTransition = paramArrayList1;
      }
    }
    for (paramView = paramArrayList2;; paramView = null)
    {
      OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.3(localFragment1, localFragment2, bool, localArrayMap1, paramView, paramFragmentTransitionImpl, paramFragmentContainerTransition));
      return paramArrayMap;
      paramFragmentContainerTransition = null;
    }
  }
  
  private static void configureTransitionsOrdered(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap paramArrayMap)
  {
    ViewGroup localViewGroup = null;
    if (paramFragmentManagerImpl.mContainer.onHasView()) {
      localViewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(paramInt);
    }
    if (localViewGroup == null) {}
    Fragment localFragment;
    FragmentTransitionImpl localFragmentTransitionImpl;
    Object localObject1;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localFragment = paramFragmentContainerTransition.lastIn;
        localObject3 = paramFragmentContainerTransition.firstOut;
        localFragmentTransitionImpl = chooseImpl((Fragment)localObject3, localFragment);
      } while (localFragmentTransitionImpl == null);
      boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
      boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
      localObject1 = getEnterTransition(localFragmentTransitionImpl, localFragment, bool1);
      paramFragmentManagerImpl = getExitTransition(localFragmentTransitionImpl, (Fragment)localObject3, bool2);
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      localObject2 = configureSharedElementsOrdered(localFragmentTransitionImpl, localViewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, localArrayList2, localArrayList1, localObject1, paramFragmentManagerImpl);
    } while ((localObject1 == null) && (localObject2 == null) && (paramFragmentManagerImpl == null));
    Object localObject3 = configureEnteringExitingViews(localFragmentTransitionImpl, paramFragmentManagerImpl, (Fragment)localObject3, localArrayList2, paramView);
    if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
      paramFragmentManagerImpl = null;
    }
    for (;;)
    {
      localFragmentTransitionImpl.addTarget(localObject1, paramView);
      paramFragmentContainerTransition = mergeTransitions(localFragmentTransitionImpl, localObject1, paramFragmentManagerImpl, localObject2, localFragment, paramFragmentContainerTransition.lastInIsPop);
      if (paramFragmentContainerTransition == null) {
        break;
      }
      localArrayList2 = new ArrayList();
      localFragmentTransitionImpl.scheduleRemoveTargets(paramFragmentContainerTransition, localObject1, localArrayList2, paramFragmentManagerImpl, (ArrayList)localObject3, localObject2, localArrayList1);
      scheduleTargetChange(localFragmentTransitionImpl, localViewGroup, localFragment, paramView, localArrayList1, localObject1, localArrayList2, paramFragmentManagerImpl, (ArrayList)localObject3);
      localFragmentTransitionImpl.setNameOverridesOrdered(localViewGroup, localArrayList1, paramArrayMap);
      localFragmentTransitionImpl.beginDelayedTransition(localViewGroup, paramFragmentContainerTransition);
      localFragmentTransitionImpl.scheduleNameReset(localViewGroup, localArrayList1, paramArrayMap);
      return;
    }
  }
  
  private static void configureTransitionsReordered(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap paramArrayMap)
  {
    ViewGroup localViewGroup = null;
    if (paramFragmentManagerImpl.mContainer.onHasView()) {
      localViewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(paramInt);
    }
    if (localViewGroup == null) {}
    Object localObject4;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList3;
    do
    {
      boolean bool1;
      do
      {
        do
        {
          return;
          localObject4 = paramFragmentContainerTransition.lastIn;
          localObject3 = paramFragmentContainerTransition.firstOut;
          paramFragmentManagerImpl = chooseImpl((Fragment)localObject3, (Fragment)localObject4);
        } while (paramFragmentManagerImpl == null);
        bool1 = paramFragmentContainerTransition.lastInIsPop;
        boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localObject1 = getEnterTransition(paramFragmentManagerImpl, (Fragment)localObject4, bool1);
        localObject2 = getExitTransition(paramFragmentManagerImpl, (Fragment)localObject3, bool2);
        paramFragmentContainerTransition = configureSharedElementsReordered(paramFragmentManagerImpl, localViewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, localArrayList2, localArrayList1, localObject1, localObject2);
      } while ((localObject1 == null) && (paramFragmentContainerTransition == null) && (localObject2 == null));
      localArrayList3 = configureEnteringExitingViews(paramFragmentManagerImpl, localObject2, (Fragment)localObject3, localArrayList2, paramView);
      paramView = configureEnteringExitingViews(paramFragmentManagerImpl, localObject1, (Fragment)localObject4, localArrayList1, paramView);
      setViewVisibility(paramView, 4);
      localObject4 = mergeTransitions(paramFragmentManagerImpl, localObject1, localObject2, paramFragmentContainerTransition, (Fragment)localObject4, bool1);
    } while (localObject4 == null);
    replaceHide(paramFragmentManagerImpl, localObject2, (Fragment)localObject3, localArrayList3);
    Object localObject3 = paramFragmentManagerImpl.prepareSetNameOverridesReordered(localArrayList1);
    paramFragmentManagerImpl.scheduleRemoveTargets(localObject4, localObject1, paramView, localObject2, localArrayList3, paramFragmentContainerTransition, localArrayList1);
    paramFragmentManagerImpl.beginDelayedTransition(localViewGroup, localObject4);
    paramFragmentManagerImpl.setNameOverridesReordered(localViewGroup, localArrayList2, localArrayList1, (ArrayList)localObject3, paramArrayMap);
    setViewVisibility(paramView, 0);
    paramFragmentManagerImpl.swapSharedElementTargets(paramFragmentContainerTransition, localArrayList2, localArrayList1);
  }
  
  private static FragmentTransition.FragmentContainerTransition ensureContainer(FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, SparseArray paramSparseArray, int paramInt)
  {
    FragmentTransition.FragmentContainerTransition localFragmentContainerTransition = paramFragmentContainerTransition;
    if (paramFragmentContainerTransition == null)
    {
      localFragmentContainerTransition = new FragmentTransition.FragmentContainerTransition();
      paramSparseArray.put(paramInt, localFragmentContainerTransition);
    }
    return localFragmentContainerTransition;
  }
  
  private static String findKeyForValue(ArrayMap paramArrayMap, String paramString)
  {
    int j = paramArrayMap.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramArrayMap.valueAt(i))) {
        return (String)paramArrayMap.keyAt(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static Object getEnterTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReenterTransition();; paramFragment = paramFragment.getEnterTransition()) {
      return paramFragmentTransitionImpl.cloneTransition(paramFragment);
    }
  }
  
  private static Object getExitTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReturnTransition();; paramFragment = paramFragment.getExitTransition()) {
      return paramFragmentTransitionImpl.cloneTransition(paramFragment);
    }
  }
  
  private static View getInEpicenterView(ArrayMap paramArrayMap, FragmentTransition.FragmentContainerTransition paramFragmentContainerTransition, Object paramObject, boolean paramBoolean)
  {
    paramFragmentContainerTransition = paramFragmentContainerTransition.lastInTransaction;
    if ((paramObject != null) && (paramArrayMap != null) && (paramFragmentContainerTransition.mSharedElementSourceNames != null) && (!paramFragmentContainerTransition.mSharedElementSourceNames.isEmpty()))
    {
      if (paramBoolean) {}
      for (paramFragmentContainerTransition = (String)paramFragmentContainerTransition.mSharedElementSourceNames.get(0);; paramFragmentContainerTransition = (String)paramFragmentContainerTransition.mSharedElementTargetNames.get(0)) {
        return (View)paramArrayMap.get(paramFragmentContainerTransition);
      }
    }
    return null;
  }
  
  private static Object getSharedElementTransition(FragmentTransitionImpl paramFragmentTransitionImpl, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 == null) || (paramFragment2 == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.getSharedElementReturnTransition();; paramFragment1 = paramFragment1.getSharedElementEnterTransition()) {
      return paramFragmentTransitionImpl.wrapTransitionInSet(paramFragmentTransitionImpl.cloneTransition(paramFragment1));
    }
  }
  
  private static Object mergeTransitions(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramObject1 != null)
    {
      bool1 = bool2;
      if (paramObject2 != null)
      {
        bool1 = bool2;
        if (paramFragment != null) {
          if (!paramBoolean) {
            break label53;
          }
        }
      }
    }
    label53:
    for (bool1 = paramFragment.getAllowReturnTransitionOverlap(); bool1; bool1 = paramFragment.getAllowEnterTransitionOverlap()) {
      return paramFragmentTransitionImpl.mergeTransitionsTogether(paramObject2, paramObject1, paramObject3);
    }
    return paramFragmentTransitionImpl.mergeTransitionsInSequence(paramObject2, paramObject1, paramObject3);
  }
  
  private static void replaceHide(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject, Fragment paramFragment, ArrayList paramArrayList)
  {
    if ((paramFragment != null) && (paramObject != null) && (paramFragment.mAdded) && (paramFragment.mHidden) && (paramFragment.mHiddenChanged))
    {
      paramFragment.setHideReplaced(true);
      paramFragmentTransitionImpl.scheduleHideFragmentView(paramObject, paramFragment.getView(), paramArrayList);
      OneShotPreDrawListener.add(paramFragment.mContainer, new FragmentTransition.1(paramArrayList));
    }
  }
  
  private static FragmentTransitionImpl resolveSupportImpl()
  {
    try
    {
      FragmentTransitionImpl localFragmentTransitionImpl = (FragmentTransitionImpl)Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localFragmentTransitionImpl;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static void retainValues(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2)
  {
    int i = paramArrayMap1.size() - 1;
    while (i >= 0)
    {
      if (!paramArrayMap2.containsKey((String)paramArrayMap1.valueAt(i))) {
        paramArrayMap1.removeAt(i);
      }
      i -= 1;
    }
  }
  
  private static void scheduleTargetChange(FragmentTransitionImpl paramFragmentTransitionImpl, ViewGroup paramViewGroup, Fragment paramFragment, View paramView, ArrayList paramArrayList1, Object paramObject1, ArrayList paramArrayList2, Object paramObject2, ArrayList paramArrayList3)
  {
    OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.2(paramObject1, paramFragmentTransitionImpl, paramView, paramFragment, paramArrayList1, paramArrayList2, paramArrayList3, paramObject2));
  }
  
  private static void setOutEpicenter(FragmentTransitionImpl paramFragmentTransitionImpl, Object paramObject1, Object paramObject2, ArrayMap paramArrayMap, boolean paramBoolean, BackStackRecord paramBackStackRecord)
  {
    if ((paramBackStackRecord.mSharedElementSourceNames != null) && (!paramBackStackRecord.mSharedElementSourceNames.isEmpty())) {
      if (!paramBoolean) {
        break label65;
      }
    }
    label65:
    for (paramBackStackRecord = (String)paramBackStackRecord.mSharedElementTargetNames.get(0);; paramBackStackRecord = (String)paramBackStackRecord.mSharedElementSourceNames.get(0))
    {
      paramArrayMap = (View)paramArrayMap.get(paramBackStackRecord);
      paramFragmentTransitionImpl.setEpicenter(paramObject1, paramArrayMap);
      if (paramObject2 != null) {
        paramFragmentTransitionImpl.setEpicenter(paramObject2, paramArrayMap);
      }
      return;
    }
  }
  
  private static void setViewVisibility(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        ((View)paramArrayList.get(i)).setVisibility(paramInt);
        i -= 1;
      }
    }
  }
  
  static void startTransitions(FragmentManagerImpl paramFragmentManagerImpl, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramFragmentManagerImpl.mCurState < 1) {}
    SparseArray localSparseArray;
    do
    {
      return;
      localSparseArray = new SparseArray();
      i = paramInt1;
      if (i < paramInt2)
      {
        localObject = (BackStackRecord)paramArrayList1.get(i);
        if (((Boolean)paramArrayList2.get(i)).booleanValue()) {
          calculatePopFragments((BackStackRecord)localObject, localSparseArray, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          calculateFragments((BackStackRecord)localObject, localSparseArray, paramBoolean);
        }
      }
    } while (localSparseArray.size() == 0);
    Object localObject = new View(paramFragmentManagerImpl.mHost.getContext());
    int j = localSparseArray.size();
    int i = 0;
    label118:
    int k;
    ArrayMap localArrayMap;
    FragmentTransition.FragmentContainerTransition localFragmentContainerTransition;
    if (i < j)
    {
      k = localSparseArray.keyAt(i);
      localArrayMap = calculateNameOverrides(k, paramArrayList1, paramArrayList2, paramInt1, paramInt2);
      localFragmentContainerTransition = (FragmentTransition.FragmentContainerTransition)localSparseArray.valueAt(i);
      if (!paramBoolean) {
        break label184;
      }
      configureTransitionsReordered(paramFragmentManagerImpl, k, localFragmentContainerTransition, (View)localObject, localArrayMap);
    }
    for (;;)
    {
      i += 1;
      break label118;
      break;
      label184:
      configureTransitionsOrdered(paramFragmentManagerImpl, k, localFragmentContainerTransition, (View)localObject, localArrayMap);
    }
  }
  
  static boolean supportsTransition()
  {
    return (PLATFORM_IMPL != null) || (SUPPORT_IMPL != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransition
 * JD-Core Version:    0.7.0.1
 */