package moai.fragment.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collection;

class FragmentTransition
{
  private static final int[] INVERSE_OPS = { 0, 3, 0, 1, 5, 4, 7, 6 };
  
  private static void addSharedElementsWithMatchingNames(ArrayList<View> paramArrayList, ArrayMap<String, View> paramArrayMap, Collection<String> paramCollection)
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
  
  private static void addToFirstInLastOut(BackStackRecord paramBackStackRecord, BackStackRecord.Op paramOp, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = paramOp.fragment;
    int n = localFragment.mContainerId;
    if (n == 0) {
      return;
    }
    int i;
    label33:
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
        paramOp = (FragmentContainerTransition)paramSparseArray.get(n);
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
        if ((localFragment.mState < 1) && (localFragmentManagerImpl.mCurState >= 1) && (!paramBackStackRecord.mAllowOptimization))
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
        break label33;
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
  
  public static void calculateFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean)
  {
    int j = paramBackStackRecord.mOps.size();
    int i = 0;
    while (i < j)
    {
      addToFirstInLastOut(paramBackStackRecord, (BackStackRecord.Op)paramBackStackRecord.mOps.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static ArrayMap<String, String> calculateNameOverrides(int paramInt1, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    ArrayMap localArrayMap = new ArrayMap();
    paramInt3 -= 1;
    if (paramInt3 >= paramInt2)
    {
      Object localObject = (BackStackRecord)paramArrayList.get(paramInt3);
      if (!((BackStackRecord)localObject).interactsWith(paramInt1)) {}
      boolean bool;
      do
      {
        paramInt3 -= 1;
        break;
        bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
      } while (((BackStackRecord)localObject).mSharedElementSourceNames == null);
      int j = ((BackStackRecord)localObject).mSharedElementSourceNames.size();
      ArrayList localArrayList2;
      ArrayList localArrayList1;
      label101:
      int i;
      label104:
      String str1;
      if (bool)
      {
        localArrayList2 = ((BackStackRecord)localObject).mSharedElementSourceNames;
        localArrayList1 = ((BackStackRecord)localObject).mSharedElementTargetNames;
        i = 0;
        if (i < j)
        {
          localObject = (String)localArrayList1.get(i);
          str1 = (String)localArrayList2.get(i);
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
        localArrayList1 = ((BackStackRecord)localObject).mSharedElementSourceNames;
        localArrayList2 = ((BackStackRecord)localObject).mSharedElementTargetNames;
        break label101;
        label188:
        localArrayMap.put(localObject, str1);
      }
    }
    return localArrayMap;
  }
  
  public static void calculatePopFragments(BackStackRecord paramBackStackRecord, SparseArray<FragmentContainerTransition> paramSparseArray, boolean paramBoolean)
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
  
  private static void callSharedElementStartEnd(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, ArrayMap<String, View> paramArrayMap, boolean paramBoolean2)
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
  
  private static ArrayMap<String, View> captureInSharedElements(ArrayMap<String, String> paramArrayMap, Object paramObject, FragmentContainerTransition paramFragmentContainerTransition)
  {
    Object localObject = paramFragmentContainerTransition.lastIn;
    View localView = ((Fragment)localObject).getView();
    if ((paramArrayMap.isEmpty()) || (paramObject == null) || (localView == null))
    {
      paramArrayMap.clear();
      return null;
    }
    ArrayMap localArrayMap = new ArrayMap();
    FragmentTransitionCompat21.findNamedViews(localArrayMap, localView);
    paramObject = paramFragmentContainerTransition.lastInTransaction;
    int i;
    if (paramFragmentContainerTransition.lastInIsPop)
    {
      paramFragmentContainerTransition = ((Fragment)localObject).getExitTransitionCallback();
      paramObject = paramObject.mSharedElementSourceNames;
      if (paramObject != null) {
        localArrayMap.retainAll(paramObject);
      }
      if (paramFragmentContainerTransition == null) {
        break label209;
      }
      paramFragmentContainerTransition.onMapSharedElements(paramObject, localArrayMap);
      i = paramObject.size() - 1;
      label103:
      if (i < 0) {
        break label215;
      }
      localObject = (String)paramObject.get(i);
      paramFragmentContainerTransition = (View)localArrayMap.get(localObject);
      if (paramFragmentContainerTransition != null) {
        break label170;
      }
      paramFragmentContainerTransition = findKeyForValue(paramArrayMap, (String)localObject);
      if (paramFragmentContainerTransition != null) {
        paramArrayMap.remove(paramFragmentContainerTransition);
      }
    }
    for (;;)
    {
      i -= 1;
      break label103;
      paramFragmentContainerTransition = ((Fragment)localObject).getEnterTransitionCallback();
      paramObject = paramObject.mSharedElementTargetNames;
      break;
      label170:
      if (!((String)localObject).equals(ViewCompat.getTransitionName(paramFragmentContainerTransition)))
      {
        localObject = findKeyForValue(paramArrayMap, (String)localObject);
        if (localObject != null) {
          paramArrayMap.put(localObject, ViewCompat.getTransitionName(paramFragmentContainerTransition));
        }
      }
    }
    label209:
    retainValues(paramArrayMap, localArrayMap);
    label215:
    return localArrayMap;
  }
  
  private static ArrayMap<String, View> captureOutSharedElements(ArrayMap<String, String> paramArrayMap, Object paramObject, FragmentContainerTransition paramFragmentContainerTransition)
  {
    if ((paramArrayMap.isEmpty()) || (paramObject == null))
    {
      paramArrayMap.clear();
      return null;
    }
    Object localObject = paramFragmentContainerTransition.firstOut;
    ArrayMap localArrayMap = new ArrayMap();
    FragmentTransitionCompat21.findNamedViews(localArrayMap, ((Fragment)localObject).getView());
    paramObject = paramFragmentContainerTransition.firstOutTransaction;
    int i;
    if (paramFragmentContainerTransition.firstOutIsPop)
    {
      paramFragmentContainerTransition = ((Fragment)localObject).getEnterTransitionCallback();
      paramObject = paramObject.mSharedElementTargetNames;
      localArrayMap.retainAll(paramObject);
      if (paramFragmentContainerTransition == null) {
        break label184;
      }
      paramFragmentContainerTransition.onMapSharedElements(paramObject, localArrayMap);
      i = paramObject.size() - 1;
      label90:
      if (i < 0) {
        break label194;
      }
      localObject = (String)paramObject.get(i);
      paramFragmentContainerTransition = (View)localArrayMap.get(localObject);
      if (paramFragmentContainerTransition != null) {
        break label147;
      }
      paramArrayMap.remove(localObject);
    }
    for (;;)
    {
      i -= 1;
      break label90;
      paramFragmentContainerTransition = ((Fragment)localObject).getExitTransitionCallback();
      paramObject = paramObject.mSharedElementSourceNames;
      break;
      label147:
      if (!((String)localObject).equals(ViewCompat.getTransitionName(paramFragmentContainerTransition)))
      {
        localObject = (String)paramArrayMap.remove(localObject);
        paramArrayMap.put(ViewCompat.getTransitionName(paramFragmentContainerTransition), localObject);
      }
    }
    label184:
    paramArrayMap.retainAll(localArrayMap.keySet());
    label194:
    return localArrayMap;
  }
  
  private static ArrayList<View> configureEnteringExitingViews(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    Object localObject = null;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.getView();
      if (paramFragment != null) {
        FragmentTransitionCompat21.captureTransitioningViews(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      localObject = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        FragmentTransitionCompat21.addTargets(paramObject, localArrayList);
        localObject = localArrayList;
      }
    }
    return localObject;
  }
  
  private static Object configureSharedElementsOptimized(ViewGroup paramViewGroup, View paramView, ArrayMap<String, String> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2)
  {
    Object localObject2 = null;
    Fragment localFragment1 = paramFragmentContainerTransition.lastIn;
    Fragment localFragment2 = paramFragmentContainerTransition.firstOut;
    if (localFragment1 != null) {
      localFragment1.getView().setVisibility(0);
    }
    if ((localFragment1 == null) || (localFragment2 == null)) {}
    label283:
    label286:
    for (;;)
    {
      return null;
      boolean bool = paramFragmentContainerTransition.lastInIsPop;
      Object localObject1;
      ArrayMap localArrayMap2;
      ArrayMap localArrayMap1;
      if (paramArrayMap.isEmpty())
      {
        localObject1 = null;
        localArrayMap2 = captureOutSharedElements(paramArrayMap, localObject1, paramFragmentContainerTransition);
        localArrayMap1 = captureInSharedElements(paramArrayMap, localObject1, paramFragmentContainerTransition);
        if (!paramArrayMap.isEmpty()) {
          break label247;
        }
        if (localArrayMap2 != null) {
          localArrayMap2.clear();
        }
        if (localArrayMap1 == null) {
          break label283;
        }
        localArrayMap1.clear();
        paramArrayMap = null;
      }
      for (;;)
      {
        label104:
        if ((paramObject1 == null) && (paramObject2 == null) && (paramArrayMap == null)) {
          break label286;
        }
        callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap2, true);
        if (paramArrayMap != null)
        {
          paramArrayList2.add(paramView);
          FragmentTransitionCompat21.setSharedElementTargets(paramArrayMap, paramView, paramArrayList1);
          setOutEpicenter(paramArrayMap, paramObject2, localArrayMap2, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
          paramArrayList1 = new Rect();
          paramArrayList2 = getInEpicenterView(localArrayMap1, paramFragmentContainerTransition, paramObject1, bool);
          paramView = paramArrayList2;
          paramFragmentContainerTransition = paramArrayList1;
          if (paramArrayList2 != null)
          {
            FragmentTransitionCompat21.setEpicenter(paramObject1, paramArrayList1);
            paramFragmentContainerTransition = paramArrayList1;
          }
        }
        for (paramView = paramArrayList2;; paramView = localObject2)
        {
          OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.3(localFragment1, localFragment2, bool, localArrayMap1, paramView, paramFragmentContainerTransition));
          return paramArrayMap;
          localObject1 = getSharedElementTransition(localFragment1, localFragment2, bool);
          break;
          label247:
          addSharedElementsWithMatchingNames(paramArrayList1, localArrayMap2, paramArrayMap.keySet());
          addSharedElementsWithMatchingNames(paramArrayList2, localArrayMap1, paramArrayMap.values());
          paramArrayMap = localObject1;
          break label104;
          paramFragmentContainerTransition = null;
        }
        paramArrayMap = null;
      }
    }
  }
  
  private static Object configureSharedElementsUnoptimized(ViewGroup paramViewGroup, View paramView, ArrayMap<String, String> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Object paramObject1, Object paramObject2)
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
      localArrayMap = captureOutSharedElements(paramArrayMap, localObject, paramFragmentContainerTransition);
      if (!paramArrayMap.isEmpty()) {
        break label90;
      }
      localObject = null;
    }
    for (;;)
    {
      if ((paramObject1 != null) || (paramObject2 != null) || (localObject != null)) {
        break label104;
      }
      return null;
      localObject = getSharedElementTransition(localFragment1, localFragment2, bool);
      break;
      label90:
      paramArrayList1.addAll(localArrayMap.values());
    }
    label104:
    callSharedElementStartEnd(localFragment1, localFragment2, bool, localArrayMap, true);
    Rect localRect;
    if (localObject != null)
    {
      localRect = new Rect();
      FragmentTransitionCompat21.setSharedElementTargets(localObject, paramView, paramArrayList1);
      setOutEpicenter(localObject, paramObject2, localArrayMap, paramFragmentContainerTransition.firstOutIsPop, paramFragmentContainerTransition.firstOutTransaction);
      paramObject2 = localRect;
      if (paramObject1 != null) {
        FragmentTransitionCompat21.setEpicenter(paramObject1, localRect);
      }
    }
    for (paramObject2 = localRect;; paramObject2 = null)
    {
      OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.4(paramArrayMap, localObject, paramFragmentContainerTransition, paramArrayList2, paramView, localFragment1, localFragment2, bool, paramArrayList1, paramObject1, paramObject2));
      return localObject;
    }
  }
  
  private static void configureTransitionsOptimized(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap)
  {
    ViewGroup localViewGroup = null;
    if (paramFragmentManagerImpl.mContainer.onHasView()) {
      localViewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(paramInt);
    }
    if (localViewGroup == null) {}
    Object localObject4;
    ArrayList localArrayList1;
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList2;
    do
    {
      boolean bool1;
      do
      {
        return;
        localObject4 = paramFragmentContainerTransition.lastIn;
        localObject3 = paramFragmentContainerTransition.firstOut;
        bool1 = paramFragmentContainerTransition.lastInIsPop;
        boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
        paramFragmentManagerImpl = new ArrayList();
        localArrayList1 = new ArrayList();
        localObject1 = getEnterTransition((Fragment)localObject4, bool1);
        localObject2 = getExitTransition((Fragment)localObject3, bool2);
        paramFragmentContainerTransition = configureSharedElementsOptimized(localViewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, localArrayList1, paramFragmentManagerImpl, localObject1, localObject2);
      } while ((localObject1 == null) && (paramFragmentContainerTransition == null) && (localObject2 == null));
      localArrayList2 = configureEnteringExitingViews(localObject2, (Fragment)localObject3, localArrayList1, paramView);
      paramView = configureEnteringExitingViews(localObject1, (Fragment)localObject4, paramFragmentManagerImpl, paramView);
      setViewVisibility(paramView, 4);
      localObject4 = mergeTransitions(localObject1, localObject2, paramFragmentContainerTransition, (Fragment)localObject4, bool1);
    } while (localObject4 == null);
    replaceHide(localObject2, (Fragment)localObject3, localArrayList2);
    Object localObject3 = FragmentTransitionCompat21.prepareSetNameOverridesOptimized(paramFragmentManagerImpl);
    FragmentTransitionCompat21.scheduleRemoveTargets(localObject4, localObject1, paramView, localObject2, localArrayList2, paramFragmentContainerTransition, paramFragmentManagerImpl);
    FragmentTransitionCompat21.beginDelayedTransition(localViewGroup, localObject4);
    FragmentTransitionCompat21.setNameOverridesOptimized(localViewGroup, localArrayList1, paramFragmentManagerImpl, (ArrayList)localObject3, paramArrayMap);
    setViewVisibility(paramView, 0);
    FragmentTransitionCompat21.swapSharedElementTargets(paramFragmentContainerTransition, localArrayList1, paramFragmentManagerImpl);
  }
  
  private static void configureTransitionsUnoptimized(FragmentManagerImpl paramFragmentManagerImpl, int paramInt, FragmentContainerTransition paramFragmentContainerTransition, View paramView, ArrayMap<String, String> paramArrayMap)
  {
    ViewGroup localViewGroup = null;
    if (paramFragmentManagerImpl.mContainer.onHasView()) {
      localViewGroup = (ViewGroup)paramFragmentManagerImpl.mContainer.onFindViewById(paramInt);
    }
    if (localViewGroup == null) {}
    Fragment localFragment;
    Object localObject1;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    Object localObject2;
    do
    {
      return;
      localFragment = paramFragmentContainerTransition.lastIn;
      localObject3 = paramFragmentContainerTransition.firstOut;
      boolean bool1 = paramFragmentContainerTransition.lastInIsPop;
      boolean bool2 = paramFragmentContainerTransition.firstOutIsPop;
      localObject1 = getEnterTransition(localFragment, bool1);
      paramFragmentManagerImpl = getExitTransition((Fragment)localObject3, bool2);
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      localObject2 = configureSharedElementsUnoptimized(localViewGroup, paramView, paramArrayMap, paramFragmentContainerTransition, localArrayList2, localArrayList1, localObject1, paramFragmentManagerImpl);
    } while ((localObject1 == null) && (localObject2 == null) && (paramFragmentManagerImpl == null));
    Object localObject3 = configureEnteringExitingViews(paramFragmentManagerImpl, (Fragment)localObject3, localArrayList2, paramView);
    if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
      paramFragmentManagerImpl = null;
    }
    for (;;)
    {
      FragmentTransitionCompat21.addTarget(localObject1, paramView);
      paramFragmentContainerTransition = mergeTransitions(localObject1, paramFragmentManagerImpl, localObject2, localFragment, paramFragmentContainerTransition.lastInIsPop);
      if (paramFragmentContainerTransition == null) {
        break;
      }
      localArrayList2 = new ArrayList();
      FragmentTransitionCompat21.scheduleRemoveTargets(paramFragmentContainerTransition, localObject1, localArrayList2, paramFragmentManagerImpl, (ArrayList)localObject3, localObject2, localArrayList1);
      scheduleTargetChange(localViewGroup, localFragment, paramView, localArrayList1, localObject1, localArrayList2, paramFragmentManagerImpl, (ArrayList)localObject3);
      FragmentTransitionCompat21.setNameOverridesUnoptimized(localViewGroup, localArrayList1, paramArrayMap);
      FragmentTransitionCompat21.beginDelayedTransition(localViewGroup, paramFragmentContainerTransition);
      FragmentTransitionCompat21.scheduleNameReset(localViewGroup, localArrayList1, paramArrayMap);
      return;
    }
  }
  
  private static FragmentContainerTransition ensureContainer(FragmentContainerTransition paramFragmentContainerTransition, SparseArray<FragmentContainerTransition> paramSparseArray, int paramInt)
  {
    FragmentContainerTransition localFragmentContainerTransition = paramFragmentContainerTransition;
    if (paramFragmentContainerTransition == null)
    {
      localFragmentContainerTransition = new FragmentContainerTransition();
      paramSparseArray.put(paramInt, localFragmentContainerTransition);
    }
    return localFragmentContainerTransition;
  }
  
  private static String findKeyForValue(ArrayMap<String, String> paramArrayMap, String paramString)
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
  
  private static Object getEnterTransition(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReenterTransition();; paramFragment = paramFragment.getEnterTransition()) {
      return FragmentTransitionCompat21.cloneTransition(paramFragment);
    }
  }
  
  private static Object getExitTransition(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReturnTransition();; paramFragment = paramFragment.getExitTransition()) {
      return FragmentTransitionCompat21.cloneTransition(paramFragment);
    }
  }
  
  private static View getInEpicenterView(ArrayMap<String, View> paramArrayMap, FragmentContainerTransition paramFragmentContainerTransition, Object paramObject, boolean paramBoolean)
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
  
  private static Object getSharedElementTransition(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 == null) || (paramFragment2 == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.getSharedElementReturnTransition();; paramFragment1 = paramFragment1.getSharedElementEnterTransition()) {
      return FragmentTransitionCompat21.wrapTransitionInSet(FragmentTransitionCompat21.cloneTransition(paramFragment1));
    }
  }
  
  private static Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
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
            break label50;
          }
        }
      }
    }
    label50:
    for (bool1 = paramFragment.getAllowReturnTransitionOverlap(); bool1; bool1 = paramFragment.getAllowEnterTransitionOverlap()) {
      return FragmentTransitionCompat21.mergeTransitionsTogether(paramObject2, paramObject1, paramObject3);
    }
    return FragmentTransitionCompat21.mergeTransitionsInSequence(paramObject2, paramObject1, paramObject3);
  }
  
  private static void replaceHide(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList)
  {
    if ((paramFragment != null) && (paramObject != null) && (paramFragment.mAdded) && (paramFragment.mHidden) && (paramFragment.mHiddenChanged))
    {
      paramFragment.setHideReplaced(true);
      FragmentTransitionCompat21.scheduleHideFragmentView(paramObject, paramFragment.getView(), paramArrayList);
      OneShotPreDrawListener.add(paramFragment.mContainer, new FragmentTransition.1(paramArrayList));
    }
  }
  
  private static void retainValues(ArrayMap<String, String> paramArrayMap, ArrayMap<String, View> paramArrayMap1)
  {
    int i = paramArrayMap.size() - 1;
    while (i >= 0)
    {
      if (!paramArrayMap1.containsKey((String)paramArrayMap.valueAt(i))) {
        paramArrayMap.removeAt(i);
      }
      i -= 1;
    }
  }
  
  private static void scheduleTargetChange(ViewGroup paramViewGroup, Fragment paramFragment, View paramView, ArrayList<View> paramArrayList1, Object paramObject1, ArrayList<View> paramArrayList2, Object paramObject2, ArrayList<View> paramArrayList3)
  {
    OneShotPreDrawListener.add(paramViewGroup, new FragmentTransition.2(paramObject1, paramView, paramFragment, paramArrayList1, paramArrayList2, paramArrayList3, paramObject2));
  }
  
  private static void setOutEpicenter(Object paramObject1, Object paramObject2, ArrayMap<String, View> paramArrayMap, boolean paramBoolean, BackStackRecord paramBackStackRecord)
  {
    if ((paramBackStackRecord.mSharedElementSourceNames != null) && (!paramBackStackRecord.mSharedElementSourceNames.isEmpty())) {
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (paramBackStackRecord = (String)paramBackStackRecord.mSharedElementTargetNames.get(0);; paramBackStackRecord = (String)paramBackStackRecord.mSharedElementSourceNames.get(0))
    {
      paramArrayMap = (View)paramArrayMap.get(paramBackStackRecord);
      FragmentTransitionCompat21.setEpicenter(paramObject1, paramArrayMap);
      if (paramObject2 != null) {
        FragmentTransitionCompat21.setEpicenter(paramObject2, paramArrayMap);
      }
      return;
    }
  }
  
  private static void setViewVisibility(ArrayList<View> paramArrayList, int paramInt)
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
  
  static void startTransitions(FragmentManagerImpl paramFragmentManagerImpl, ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramFragmentManagerImpl.mCurState < 1) || (Build.VERSION.SDK_INT < 21)) {}
    SparseArray localSparseArray;
    do
    {
      return;
      localSparseArray = new SparseArray();
      i = paramInt1;
      if (i < paramInt2)
      {
        localObject = (BackStackRecord)paramArrayList.get(i);
        if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
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
    label126:
    int k;
    ArrayMap localArrayMap;
    FragmentContainerTransition localFragmentContainerTransition;
    if (i < j)
    {
      k = localSparseArray.keyAt(i);
      localArrayMap = calculateNameOverrides(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
      localFragmentContainerTransition = (FragmentContainerTransition)localSparseArray.valueAt(i);
      if (!paramBoolean) {
        break label192;
      }
      configureTransitionsOptimized(paramFragmentManagerImpl, k, localFragmentContainerTransition, (View)localObject, localArrayMap);
    }
    for (;;)
    {
      i += 1;
      break label126;
      break;
      label192:
      configureTransitionsUnoptimized(paramFragmentManagerImpl, k, localFragmentContainerTransition, (View)localObject, localArrayMap);
    }
  }
  
  static class FragmentContainerTransition
  {
    public Fragment firstOut;
    public boolean firstOutIsPop;
    public BackStackRecord firstOutTransaction;
    public Fragment lastIn;
    public boolean lastInIsPop;
    public BackStackRecord lastInTransaction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentTransition
 * JD-Core Version:    0.7.0.1
 */