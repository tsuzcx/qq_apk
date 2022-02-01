package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.util.DebugUtils;
import androidx.core.util.LogWriter;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl
  extends FragmentManager
  implements LayoutInflater.Factory2
{
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
  static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  final HashMap<String, Fragment> mActive = new HashMap();
  final ArrayList<Fragment> mAdded = new ArrayList();
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<BackStackRecord> mBackStack;
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  ArrayList<BackStackRecord> mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new FragmentManagerImpl.2(this);
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  FragmentHostCallback mHost;
  private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks = new CopyOnWriteArrayList();
  boolean mNeedMenuInvalidate;
  int mNextFragmentIndex = 0;
  private FragmentManagerViewModel mNonConfig;
  private final OnBackPressedCallback mOnBackPressedCallback = new FragmentManagerImpl.1(this, false);
  private OnBackPressedDispatcher mOnBackPressedDispatcher;
  Fragment mParent;
  ArrayList<OpGenerator> mPendingActions;
  ArrayList<StartEnterTransitionListener> mPostponedTransactions;
  @Nullable
  Fragment mPrimaryNav;
  SparseArray<Parcelable> mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  boolean mStopped;
  ArrayList<Fragment> mTmpAddedFragments;
  ArrayList<Boolean> mTmpIsPop;
  ArrayList<BackStackRecord> mTmpRecords;
  
  private void addAddedFragments(ArraySet<Fragment> paramArraySet)
  {
    if (this.mCurState < 1) {}
    for (;;)
    {
      return;
      int j = Math.min(this.mCurState, 3);
      int k = this.mAdded.size();
      int i = 0;
      while (i < k)
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment.mState < j)
        {
          moveToState(localFragment, j, localFragment.getNextAnim(), localFragment.getNextTransition(), false);
          if ((localFragment.mView != null) && (!localFragment.mHidden) && (localFragment.mIsNewlyAdded)) {
            paramArraySet.add(localFragment);
          }
        }
        i += 1;
      }
    }
  }
  
  private void animateRemoveFragment(@NonNull Fragment paramFragment, @NonNull AnimationOrAnimator paramAnimationOrAnimator, int paramInt)
  {
    View localView = paramFragment.mView;
    ViewGroup localViewGroup = paramFragment.mContainer;
    localViewGroup.startViewTransition(localView);
    paramFragment.setStateAfterAnimating(paramInt);
    if (paramAnimationOrAnimator.animation != null)
    {
      paramAnimationOrAnimator = new EndViewTransitionAnimation(paramAnimationOrAnimator.animation, localViewGroup, localView);
      paramFragment.setAnimatingAway(paramFragment.mView);
      paramAnimationOrAnimator.setAnimationListener(new FragmentManagerImpl.3(this, localViewGroup, paramFragment));
      paramFragment.mView.startAnimation(paramAnimationOrAnimator);
      return;
    }
    Animator localAnimator = paramAnimationOrAnimator.animator;
    paramFragment.setAnimator(paramAnimationOrAnimator.animator);
    localAnimator.addListener(new FragmentManagerImpl.4(this, localViewGroup, localView, paramFragment));
    localAnimator.setTarget(paramFragment.mView);
    localAnimator.start();
  }
  
  private void burpActive()
  {
    this.mActive.values().removeAll(Collections.singleton(null));
  }
  
  private void checkStateLoss()
  {
    if (isStateSaved()) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
  }
  
  private void cleanupExec()
  {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment paramFragment)
  {
    if ((paramFragment != null) && (this.mActive.get(paramFragment.mWho) == paramFragment)) {
      paramFragment.performPrimaryNavigationFragmentChanged();
    }
  }
  
  private void dispatchStateChange(int paramInt)
  {
    try
    {
      this.mExecutingActions = true;
      moveToState(paramInt, false);
      this.mExecutingActions = false;
      execPendingActions();
      return;
    }
    finally
    {
      this.mExecutingActions = false;
    }
  }
  
  private void endAnimatingAwayFragments()
  {
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        if (localFragment.getAnimatingAway() != null)
        {
          int i = localFragment.getStateAfterAnimating();
          View localView = localFragment.getAnimatingAway();
          Animation localAnimation = localView.getAnimation();
          if (localAnimation != null)
          {
            localAnimation.cancel();
            localView.clearAnimation();
          }
          localFragment.setAnimatingAway(null);
          moveToState(localFragment, i, 0, 0, false);
        }
        else if (localFragment.getAnimator() != null)
        {
          localFragment.getAnimator().end();
        }
      }
    }
  }
  
  private void ensureExecReady(boolean paramBoolean)
  {
    if (this.mExecutingActions) {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    if (this.mHost == null) {
      throw new IllegalStateException("Fragment host has been destroyed");
    }
    if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    if (!paramBoolean) {
      checkStateLoss();
    }
    if (this.mTmpRecords == null)
    {
      this.mTmpRecords = new ArrayList();
      this.mTmpIsPop = new ArrayList();
    }
    this.mExecutingActions = true;
    try
    {
      executePostponedTransaction(null, null);
      return;
    }
    finally
    {
      this.mExecutingActions = false;
    }
  }
  
  private static void executeOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue())
      {
        localBackStackRecord.bumpBackStackNesting(-1);
        if (paramInt1 == paramInt2 - 1)
        {
          bool = true;
          label45:
          localBackStackRecord.executePopOps(bool);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        bool = false;
        break label45;
        localBackStackRecord.bumpBackStackNesting(1);
        localBackStackRecord.executeOps();
      }
    }
  }
  
  private void executeOpsTogether(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool = ((BackStackRecord)paramArrayList.get(paramInt1)).mReorderingAllowed;
    Object localObject;
    int j;
    label55:
    BackStackRecord localBackStackRecord;
    if (this.mTmpAddedFragments == null)
    {
      this.mTmpAddedFragments = new ArrayList();
      this.mTmpAddedFragments.addAll(this.mAdded);
      localObject = getPrimaryNavigationFragment();
      j = paramInt1;
      i = 0;
      if (j >= paramInt2) {
        break label158;
      }
      localBackStackRecord = (BackStackRecord)paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
        break label136;
      }
      localObject = localBackStackRecord.expandOps(this.mTmpAddedFragments, (Fragment)localObject);
      label101:
      if ((i == 0) && (!localBackStackRecord.mAddToBackStack)) {
        break label152;
      }
    }
    label136:
    label152:
    for (int i = 1;; i = 0)
    {
      j += 1;
      break label55;
      this.mTmpAddedFragments.clear();
      break;
      localObject = localBackStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, (Fragment)localObject);
      break label101;
    }
    label158:
    this.mTmpAddedFragments.clear();
    if (!bool) {
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false);
    }
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    if (bool)
    {
      localObject = new ArraySet();
      addAddedFragments((ArraySet)localObject);
      j = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, (ArraySet)localObject);
      makeRemovedFragmentsInvisible((ArraySet)localObject);
    }
    for (;;)
    {
      int k = paramInt1;
      if (j != paramInt1)
      {
        k = paramInt1;
        if (bool)
        {
          FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, j, true);
          moveToState(this.mCurState, true);
          k = paramInt1;
        }
      }
      while (k < paramInt2)
      {
        localObject = (BackStackRecord)paramArrayList.get(k);
        if ((((Boolean)paramArrayList1.get(k)).booleanValue()) && (((BackStackRecord)localObject).mIndex >= 0))
        {
          freeBackStackIndex(((BackStackRecord)localObject).mIndex);
          ((BackStackRecord)localObject).mIndex = -1;
        }
        ((BackStackRecord)localObject).runOnCommitRunnables();
        k += 1;
      }
      if (i != 0) {
        reportBackStackChanged();
      }
      return;
      j = paramInt2;
    }
  }
  
  private void executePostponedTransaction(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i;
    int j;
    label12:
    StartEnterTransitionListener localStartEnterTransitionListener;
    int k;
    if (this.mPostponedTransactions == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localStartEnterTransitionListener = (StartEnterTransitionListener)this.mPostponedTransactions.get(j);
      if ((paramArrayList == null) || (localStartEnterTransitionListener.mIsBack)) {
        break label121;
      }
      k = paramArrayList.indexOf(localStartEnterTransitionListener.mRecord);
      if ((k == -1) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label121;
      }
      this.mPostponedTransactions.remove(j);
      localStartEnterTransitionListener.cancelTransaction();
      j -= 1;
      i -= 1;
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = this.mPostponedTransactions.size();
      break;
      label121:
      int m;
      if (!localStartEnterTransitionListener.isReady())
      {
        m = j;
        k = i;
        if (paramArrayList != null)
        {
          m = j;
          k = i;
          if (!localStartEnterTransitionListener.mRecord.interactsWith(paramArrayList, 0, paramArrayList.size())) {}
        }
      }
      else
      {
        this.mPostponedTransactions.remove(j);
        m = j - 1;
        k = i - 1;
        if ((paramArrayList != null) && (!localStartEnterTransitionListener.mIsBack))
        {
          i = paramArrayList.indexOf(localStartEnterTransitionListener.mRecord);
          if ((i != -1) && (((Boolean)paramArrayList1.get(i)).booleanValue()))
          {
            localStartEnterTransitionListener.cancelTransaction();
            j = m;
            i = k;
            continue;
          }
        }
        localStartEnterTransitionListener.completeTransaction();
      }
      j = m;
      i = k;
    }
  }
  
  private Fragment findFragmentUnder(Fragment paramFragment)
  {
    ViewGroup localViewGroup = paramFragment.mContainer;
    Object localObject = paramFragment.mView;
    if ((localViewGroup == null) || (localObject == null))
    {
      paramFragment = null;
      return paramFragment;
    }
    int i = this.mAdded.indexOf(paramFragment) - 1;
    for (;;)
    {
      if (i < 0) {
        break label76;
      }
      localObject = (Fragment)this.mAdded.get(i);
      if (((Fragment)localObject).mContainer == localViewGroup)
      {
        paramFragment = (Fragment)localObject;
        if (((Fragment)localObject).mView != null) {
          break;
        }
      }
      i -= 1;
    }
    label76:
    return null;
  }
  
  private void forcePostponedTransactions()
  {
    if (this.mPostponedTransactions != null) {
      while (!this.mPostponedTransactions.isEmpty()) {
        ((StartEnterTransitionListener)this.mPostponedTransactions.remove(0)).completeTransaction();
      }
    }
  }
  
  private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    try
    {
      if ((this.mPendingActions == null) || (this.mPendingActions.size() == 0)) {
        return false;
      }
      int j = this.mPendingActions.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= ((OpGenerator)this.mPendingActions.get(i)).generateOps(paramArrayList, paramArrayList1);
        i += 1;
      }
      this.mPendingActions.clear();
      this.mHost.getHandler().removeCallbacks(this.mExecCommit);
      return bool;
    }
    finally {}
  }
  
  private boolean isMenuAvailable(Fragment paramFragment)
  {
    return ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) || (paramFragment.mChildFragmentManager.checkForMenus());
  }
  
  static AnimationOrAnimator makeFadeAnimation(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(DECELERATE_CUBIC);
    localAlphaAnimation.setDuration(220L);
    return new AnimationOrAnimator(localAlphaAnimation);
  }
  
  static AnimationOrAnimator makeOpenCloseAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return new AnimationOrAnimator(localAnimationSet);
  }
  
  private void makeRemovedFragmentsInvisible(ArraySet<Fragment> paramArraySet)
  {
    int j = paramArraySet.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramArraySet.valueAt(i);
      if (!localFragment.mAdded)
      {
        View localView = localFragment.requireView();
        localFragment.mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2)
  {
    execPendingActions();
    ensureExecReady(true);
    if ((this.mPrimaryNav != null) && (paramInt1 < 0) && (paramString == null) && (this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate())) {
      return true;
    }
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
      updateOnBackPressedCallbackEnabled();
      doPendingDeferredStart();
      return bool;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  private int postponePostponableTransactions(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, ArraySet<Fragment> paramArraySet)
  {
    int j = paramInt2 - 1;
    int i = paramInt2;
    BackStackRecord localBackStackRecord;
    int k;
    if (j >= paramInt1)
    {
      localBackStackRecord = (BackStackRecord)paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      if ((localBackStackRecord.isPostponed()) && (!localBackStackRecord.interactsWith(paramArrayList, j + 1, paramInt2)))
      {
        k = 1;
        label67:
        if (k == 0) {
          break label191;
        }
        if (this.mPostponedTransactions == null) {
          this.mPostponedTransactions = new ArrayList();
        }
        StartEnterTransitionListener localStartEnterTransitionListener = new StartEnterTransitionListener(localBackStackRecord, bool);
        this.mPostponedTransactions.add(localStartEnterTransitionListener);
        localBackStackRecord.setOnStartPostponedListener(localStartEnterTransitionListener);
        if (!bool) {
          break label179;
        }
        localBackStackRecord.executeOps();
        label130:
        i -= 1;
        if (j != i)
        {
          paramArrayList.remove(j);
          paramArrayList.add(i, localBackStackRecord);
        }
        addAddedFragments(paramArraySet);
      }
    }
    label179:
    label191:
    for (;;)
    {
      j -= 1;
      break;
      k = 0;
      break label67;
      localBackStackRecord.executePopOps(false);
      break label130;
      return i;
    }
  }
  
  private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i = 0;
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    if ((paramArrayList1 == null) || (paramArrayList.size() != paramArrayList1.size())) {
      throw new IllegalStateException("Internal error with the back stack records");
    }
    executePostponedTransaction(paramArrayList, paramArrayList1);
    int m = paramArrayList.size();
    int j = 0;
    label55:
    if (i < m)
    {
      if (((BackStackRecord)paramArrayList.get(i)).mReorderingAllowed) {
        break label220;
      }
      if (j != i) {
        executeOpsTogether(paramArrayList, paramArrayList1, j, i);
      }
      int k = i + 1;
      j = k;
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        for (;;)
        {
          j = k;
          if (k >= m) {
            break;
          }
          j = k;
          if (!((Boolean)paramArrayList1.get(k)).booleanValue()) {
            break;
          }
          j = k;
          if (((BackStackRecord)paramArrayList.get(k)).mReorderingAllowed) {
            break;
          }
          k += 1;
        }
      }
      executeOpsTogether(paramArrayList, paramArrayList1, i, j);
      i = j;
      k = j - 1;
      j = i;
      i = k;
    }
    label220:
    for (;;)
    {
      i += 1;
      break label55;
      if (j == m) {
        break;
      }
      executeOpsTogether(paramArrayList, paramArrayList1, j, m);
      return;
    }
  }
  
  public static int reverseTransit(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    if (this.mHost != null) {}
    for (;;)
    {
      try
      {
        this.mHost.onDump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 4097: 
      if (paramBoolean) {
        return 1;
      }
      return 2;
    case 8194: 
      if (paramBoolean) {
        return 3;
      }
      return 4;
    }
    if (paramBoolean) {
      return 5;
    }
    return 6;
  }
  
  private void updateOnBackPressedCallbackEnabled()
  {
    boolean bool = true;
    if ((this.mPendingActions != null) && (!this.mPendingActions.isEmpty()))
    {
      this.mOnBackPressedCallback.setEnabled(true);
      return;
    }
    OnBackPressedCallback localOnBackPressedCallback = this.mOnBackPressedCallback;
    if ((getBackStackEntryCount() > 0) && (isPrimaryNavigation(this.mParent))) {}
    for (;;)
    {
      localOnBackPressedCallback.setEnabled(bool);
      return;
      bool = false;
    }
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(paramBackStackRecord);
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "add: " + paramFragment);
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached) {
      if (this.mAdded.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
    }
    synchronized (this.mAdded)
    {
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if (paramFragment.mView == null) {
        paramFragment.mHiddenChanged = false;
      }
      if (isMenuAvailable(paramFragment)) {
        this.mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
      return;
    }
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  void addRetainedFragment(@NonNull Fragment paramFragment)
  {
    if (isStateSaved()) {
      if (DEBUG) {
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
      }
    }
    while ((!this.mNonConfig.addRetainedFragment(paramFragment)) || (!DEBUG)) {
      return;
    }
    Log.v("FragmentManager", "Updating retained Fragments: Added " + paramFragment);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    try
    {
      if ((this.mAvailBackStackIndices == null) || (this.mAvailBackStackIndices.size() <= 0))
      {
        if (this.mBackStackIndices == null) {
          this.mBackStackIndices = new ArrayList();
        }
        i = this.mBackStackIndices.size();
        if (DEBUG) {
          Log.v("FragmentManager", "Setting back stack index " + i + " to " + paramBackStackRecord);
        }
        this.mBackStackIndices.add(paramBackStackRecord);
        return i;
      }
      int i = ((Integer)this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
      if (DEBUG) {
        Log.v("FragmentManager", "Adding back stack index " + i + " with " + paramBackStackRecord);
      }
      this.mBackStackIndices.set(i, paramBackStackRecord);
      return i;
    }
    finally {}
  }
  
  public void attachController(@NonNull FragmentHostCallback paramFragmentHostCallback, @NonNull FragmentContainer paramFragmentContainer, @Nullable Fragment paramFragment)
  {
    if (this.mHost != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mHost = paramFragmentHostCallback;
    this.mContainer = paramFragmentContainer;
    this.mParent = paramFragment;
    if (this.mParent != null) {
      updateOnBackPressedCallbackEnabled();
    }
    if ((paramFragmentHostCallback instanceof OnBackPressedDispatcherOwner))
    {
      paramFragmentContainer = (OnBackPressedDispatcherOwner)paramFragmentHostCallback;
      this.mOnBackPressedDispatcher = paramFragmentContainer.getOnBackPressedDispatcher();
      if (paramFragment != null) {
        paramFragmentContainer = paramFragment;
      }
      this.mOnBackPressedDispatcher.addCallback(paramFragmentContainer, this.mOnBackPressedCallback);
    }
    if (paramFragment != null)
    {
      this.mNonConfig = paramFragment.mFragmentManager.getChildNonConfig(paramFragment);
      return;
    }
    if ((paramFragmentHostCallback instanceof ViewModelStoreOwner))
    {
      this.mNonConfig = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner)paramFragmentHostCallback).getViewModelStore());
      return;
    }
    this.mNonConfig = new FragmentManagerViewModel(false);
  }
  
  public void attachFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.mAdded.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        }
      }
    }
    synchronized (this.mAdded)
    {
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      if (isMenuAvailable(paramFragment)) {
        this.mNeedMenuInvalidate = true;
      }
      return;
    }
  }
  
  @NonNull
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  boolean checkForMenus()
  {
    boolean bool3 = false;
    Iterator localIterator = this.mActive.values().iterator();
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment == null) {
        break label65;
      }
      bool1 = isMenuAvailable(localFragment);
    }
    label65:
    for (;;)
    {
      if (bool1)
      {
        bool2 = true;
        return bool2;
      }
      break;
    }
  }
  
  void completeExecute(BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      paramBackStackRecord.executePopOps(paramBoolean3);
      localObject1 = new ArrayList(1);
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject1).add(paramBackStackRecord);
      ((ArrayList)localObject2).add(Boolean.valueOf(paramBoolean1));
      if (paramBoolean2) {
        FragmentTransition.startTransitions(this, (ArrayList)localObject1, (ArrayList)localObject2, 0, 1, true);
      }
      if (paramBoolean3) {
        moveToState(this.mCurState, true);
      }
      localObject1 = this.mActive.values().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      localObject2 = (Fragment)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((Fragment)localObject2).mView != null) && (((Fragment)localObject2).mIsNewlyAdded) && (paramBackStackRecord.interactsWith(((Fragment)localObject2).mContainerId)))
      {
        if (((Fragment)localObject2).mPostponedAlpha > 0.0F) {
          ((Fragment)localObject2).mView.setAlpha(((Fragment)localObject2).mPostponedAlpha);
        }
        if (paramBoolean3)
        {
          ((Fragment)localObject2).mPostponedAlpha = 0.0F;
          continue;
          paramBackStackRecord.executeOps();
          break;
        }
        ((Fragment)localObject2).mPostponedAlpha = -1.0F;
        ((Fragment)localObject2).mIsNewlyAdded = false;
      }
    }
  }
  
  void completeShowHideFragment(Fragment paramFragment)
  {
    boolean bool;
    AnimationOrAnimator localAnimationOrAnimator;
    if (paramFragment.mView != null)
    {
      i = paramFragment.getNextTransition();
      if (paramFragment.mHidden) {
        break label120;
      }
      bool = true;
      localAnimationOrAnimator = loadAnimation(paramFragment, i, bool, paramFragment.getNextTransitionStyle());
      if ((localAnimationOrAnimator == null) || (localAnimationOrAnimator.animator == null)) {
        break label179;
      }
      localAnimationOrAnimator.animator.setTarget(paramFragment.mView);
      if (!paramFragment.mHidden) {
        break label168;
      }
      if (!paramFragment.isHideReplaced()) {
        break label125;
      }
      paramFragment.setHideReplaced(false);
    }
    for (;;)
    {
      localAnimationOrAnimator.animator.start();
      if ((paramFragment.mAdded) && (isMenuAvailable(paramFragment))) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mHiddenChanged = false;
      paramFragment.onHiddenChanged(paramFragment.mHidden);
      return;
      label120:
      bool = false;
      break;
      label125:
      ViewGroup localViewGroup = paramFragment.mContainer;
      View localView = paramFragment.mView;
      localViewGroup.startViewTransition(localView);
      localAnimationOrAnimator.animator.addListener(new FragmentManagerImpl.5(this, localViewGroup, localView, paramFragment));
      continue;
      label168:
      paramFragment.mView.setVisibility(0);
    }
    label179:
    if (localAnimationOrAnimator != null)
    {
      paramFragment.mView.startAnimation(localAnimationOrAnimator.animation);
      localAnimationOrAnimator.animation.start();
    }
    if ((paramFragment.mHidden) && (!paramFragment.isHideReplaced())) {}
    for (int i = 8;; i = 0)
    {
      paramFragment.mView.setVisibility(i);
      if (!paramFragment.isHideReplaced()) {
        break;
      }
      paramFragment.setHideReplaced(false);
      break;
    }
  }
  
  public void detachFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded) {
        if (DEBUG) {
          Log.v("FragmentManager", "remove from detach: " + paramFragment);
        }
      }
    }
    synchronized (this.mAdded)
    {
      this.mAdded.remove(paramFragment);
      if (isMenuAvailable(paramFragment)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mAdded = false;
      return;
    }
  }
  
  public void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(2);
  }
  
  public void dispatchConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
      i += 1;
    }
  }
  
  public boolean dispatchContextItemSelected(@NonNull MenuItem paramMenuItem)
  {
    if (this.mCurState < 1) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void dispatchCreate()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(1);
  }
  
  public boolean dispatchCreateOptionsMenu(@NonNull Menu paramMenu, @NonNull MenuInflater paramMenuInflater)
  {
    int j = 0;
    if (this.mCurState < 1) {
      return false;
    }
    Object localObject1 = null;
    int i = 0;
    boolean bool = false;
    if (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment == null) || (!localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))) {
        break label167;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((ArrayList)localObject2).add(localFragment);
      bool = true;
      localObject1 = localObject2;
    }
    label167:
    for (;;)
    {
      i += 1;
      break;
      if (this.mCreatedMenus != null)
      {
        i = j;
        while (i < this.mCreatedMenus.size())
        {
          paramMenu = (Fragment)this.mCreatedMenus.get(i);
          if ((localObject1 == null) || (!localObject1.contains(paramMenu))) {
            paramMenu.onDestroyOptionsMenu();
          }
          i += 1;
        }
      }
      this.mCreatedMenus = localObject1;
      return bool;
    }
  }
  
  public void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions();
    dispatchStateChange(0);
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
    if (this.mOnBackPressedDispatcher != null)
    {
      this.mOnBackPressedCallback.remove();
      this.mOnBackPressedDispatcher = null;
    }
  }
  
  public void dispatchDestroyView()
  {
    dispatchStateChange(1);
  }
  
  public void dispatchLowMemory()
  {
    int i = 0;
    while (i < this.mAdded.size())
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
      i += 1;
    }
  }
  
  public void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    int i = this.mAdded.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  void dispatchOnFragmentActivityCreated(@NonNull Fragment paramFragment, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentActivityCreated(paramFragment, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentActivityCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentAttached(@NonNull Fragment paramFragment, @NonNull Context paramContext, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentAttached(paramFragment, paramContext, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentAttached(this, paramFragment, paramContext);
      }
    }
  }
  
  void dispatchOnFragmentCreated(@NonNull Fragment paramFragment, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentCreated(paramFragment, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentDestroyed(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentDestroyed(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentDestroyed(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentDetached(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentDetached(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentDetached(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentPaused(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPaused(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentPaused(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentPreAttached(@NonNull Fragment paramFragment, @NonNull Context paramContext, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPreAttached(paramFragment, paramContext, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentPreAttached(this, paramFragment, paramContext);
      }
    }
  }
  
  void dispatchOnFragmentPreCreated(@NonNull Fragment paramFragment, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentPreCreated(paramFragment, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentPreCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentResumed(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentResumed(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentResumed(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentSaveInstanceState(@NonNull Fragment paramFragment, @NonNull Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentSaveInstanceState(paramFragment, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentSaveInstanceState(this, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentStarted(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentStarted(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentStarted(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentStopped(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentStopped(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentStopped(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentViewCreated(@NonNull Fragment paramFragment, @NonNull View paramView, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentViewCreated(paramFragment, paramView, paramBundle, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentViewCreated(this, paramFragment, paramView, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentViewDestroyed(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mParent != null)
    {
      localObject = this.mParent.getFragmentManager();
      if ((localObject instanceof FragmentManagerImpl)) {
        ((FragmentManagerImpl)localObject).dispatchOnFragmentViewDestroyed(paramFragment, true);
      }
    }
    Object localObject = this.mLifecycleCallbacks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FragmentLifecycleCallbacksHolder localFragmentLifecycleCallbacksHolder = (FragmentLifecycleCallbacksHolder)((Iterator)localObject).next();
      if ((!paramBoolean) || (localFragmentLifecycleCallbacksHolder.mRecursive)) {
        localFragmentLifecycleCallbacksHolder.mCallback.onFragmentViewDestroyed(this, paramFragment);
      }
    }
  }
  
  public boolean dispatchOptionsItemSelected(@NonNull MenuItem paramMenuItem)
  {
    if (this.mCurState < 1) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void dispatchOptionsMenuClosed(@NonNull Menu paramMenu)
  {
    if (this.mCurState < 1) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
        i += 1;
      }
    }
  }
  
  public void dispatchPause()
  {
    dispatchStateChange(3);
  }
  
  public void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    int i = this.mAdded.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
      i -= 1;
    }
  }
  
  public boolean dispatchPrepareOptionsMenu(@NonNull Menu paramMenu)
  {
    if (this.mCurState < 1) {
      return false;
    }
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < this.mAdded.size(); bool1 = bool2)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      bool2 = bool1;
      if (localFragment != null)
      {
        bool2 = bool1;
        if (localFragment.performPrepareOptionsMenu(paramMenu)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  void dispatchPrimaryNavigationFragmentChanged()
  {
    updateOnBackPressedCallbackEnabled();
    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
  }
  
  public void dispatchResume()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(4);
  }
  
  public void dispatchStart()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(3);
  }
  
  public void dispatchStop()
  {
    this.mStopped = true;
    dispatchStateChange(2);
  }
  
  void doPendingDeferredStart()
  {
    if (this.mHavePendingDeferredStart)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
  }
  
  public void dump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    if (!this.mActive.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Active Fragments in ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
      paramPrintWriter.println(":");
      Iterator localIterator = this.mActive.values().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        paramPrintWriter.print(paramString);
        paramPrintWriter.println(localFragment);
        if (localFragment != null) {
          localFragment.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }
    int k = this.mAdded.size();
    int i;
    if (k > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i = 0;
      while (i < k)
      {
        paramFileDescriptor = (Fragment)this.mAdded.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i += 1;
      }
    }
    if (this.mCreatedMenus != null)
    {
      k = this.mCreatedMenus.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (Fragment)this.mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    if (this.mBackStack != null)
    {
      k = this.mBackStack.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (BackStackRecord)this.mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.dump(str, paramPrintWriter);
          i += 1;
        }
      }
    }
    try
    {
      if (this.mBackStackIndices != null)
      {
        k = this.mBackStackIndices.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < k)
          {
            paramFileDescriptor = (BackStackRecord)this.mBackStackIndices.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
      }
      if (this.mPendingActions != null)
      {
        k = this.mPendingActions.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = j;
          while (i < k)
          {
            paramFileDescriptor = (OpGenerator)this.mPendingActions.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mHost=");
    paramPrintWriter.println(this.mHost);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.mContainer);
    if (this.mParent != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.mParent);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.mCurState);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.mStateSaved);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.mDestroyed);
    if (this.mNeedMenuInvalidate)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.mNeedMenuInvalidate);
    }
  }
  
  public void enqueueAction(OpGenerator paramOpGenerator, boolean paramBoolean)
  {
    if (!paramBoolean) {
      checkStateLoss();
    }
    try
    {
      if ((this.mDestroyed) || (this.mHost == null))
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally {}
    if (this.mPendingActions == null) {
      this.mPendingActions = new ArrayList();
    }
    this.mPendingActions.add(paramOpGenerator);
    scheduleCommit();
  }
  
  void ensureInflatedFragmentView(Fragment paramFragment)
  {
    if ((paramFragment.mFromLayout) && (!paramFragment.mPerformedCreateView))
    {
      paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
      if (paramFragment.mView != null)
      {
        paramFragment.mInnerView = paramFragment.mView;
        paramFragment.mView.setSaveFromParentEnabled(false);
        if (paramFragment.mHidden) {
          paramFragment.mView.setVisibility(8);
        }
        paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
        dispatchOnFragmentViewCreated(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
      }
    }
    else
    {
      return;
    }
    paramFragment.mInnerView = null;
  }
  
  public boolean execPendingActions()
  {
    ensureExecReady(true);
    boolean bool = false;
    for (;;)
    {
      if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
        this.mExecutingActions = true;
      }
      try
      {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
        bool = true;
      }
      finally
      {
        cleanupExec();
      }
    }
    doPendingDeferredStart();
    burpActive();
    return bool;
  }
  
  public void execSingleAction(OpGenerator paramOpGenerator, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.mHost == null) || (this.mDestroyed))) {
      return;
    }
    ensureExecReady(paramBoolean);
    if (paramOpGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
      updateOnBackPressedCallbackEnabled();
      doPendingDeferredStart();
      return;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  public boolean executePendingTransactions()
  {
    boolean bool = execPendingActions();
    forcePostponedTransactions();
    return bool;
  }
  
  @Nullable
  public Fragment findFragmentById(int paramInt)
  {
    int i = this.mAdded.size() - 1;
    while (i >= 0)
    {
      localObject = (Fragment)this.mAdded.get(i);
      if ((localObject != null) && (((Fragment)localObject).mFragmentId == paramInt)) {
        return localObject;
      }
      i -= 1;
    }
    Object localObject = this.mActive.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Fragment localFragment = (Fragment)((Iterator)localObject).next();
      if ((localFragment != null) && (localFragment.mFragmentId == paramInt)) {
        return localFragment;
      }
    }
    return null;
  }
  
  @Nullable
  public Fragment findFragmentByTag(@Nullable String paramString)
  {
    Object localObject;
    if (paramString != null)
    {
      int i = this.mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.mAdded.get(i);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).mTag))) {
          return localObject;
        }
        i -= 1;
      }
    }
    if (paramString != null)
    {
      localObject = this.mActive.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Fragment localFragment = (Fragment)((Iterator)localObject).next();
        if ((localFragment != null) && (paramString.equals(localFragment.mTag))) {
          return localFragment;
        }
      }
    }
    return null;
  }
  
  public Fragment findFragmentByWho(@NonNull String paramString)
  {
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null)
      {
        localFragment = localFragment.findFragmentByWho(paramString);
        if (localFragment != null) {
          return localFragment;
        }
      }
    }
    return null;
  }
  
  public void freeBackStackIndex(int paramInt)
  {
    try
    {
      this.mBackStackIndices.set(paramInt, null);
      if (this.mAvailBackStackIndices == null) {
        this.mAvailBackStackIndices = new ArrayList();
      }
      if (DEBUG) {
        Log.v("FragmentManager", "Freeing back stack index " + paramInt);
      }
      this.mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  int getActiveFragmentCount()
  {
    return this.mActive.size();
  }
  
  @NonNull
  List<Fragment> getActiveFragments()
  {
    return new ArrayList(this.mActive.values());
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    if (this.mBackStack != null) {
      return this.mBackStack.size();
    }
    return 0;
  }
  
  @NonNull
  FragmentManagerViewModel getChildNonConfig(@NonNull Fragment paramFragment)
  {
    return this.mNonConfig.getChildNonConfig(paramFragment);
  }
  
  @Nullable
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    String str = paramBundle.getString(paramString);
    if (str == null) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      localFragment = (Fragment)this.mActive.get(str);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": unique id " + str));
    return localFragment;
  }
  
  @NonNull
  public FragmentFactory getFragmentFactory()
  {
    if (super.getFragmentFactory() == DEFAULT_FACTORY)
    {
      if (this.mParent != null) {
        return this.mParent.mFragmentManager.getFragmentFactory();
      }
      setFragmentFactory(new FragmentManagerImpl.6(this));
    }
    return super.getFragmentFactory();
  }
  
  public List<Fragment> getFragments()
  {
    if (this.mAdded.isEmpty()) {
      return Collections.emptyList();
    }
    synchronized (this.mAdded)
    {
      List localList = (List)this.mAdded.clone();
      return localList;
    }
  }
  
  LayoutInflater.Factory2 getLayoutInflaterFactory()
  {
    return this;
  }
  
  @Nullable
  public Fragment getPrimaryNavigationFragment()
  {
    return this.mPrimaryNav;
  }
  
  @NonNull
  ViewModelStore getViewModelStore(@NonNull Fragment paramFragment)
  {
    return this.mNonConfig.getViewModelStore(paramFragment);
  }
  
  void handleOnBackPressed()
  {
    execPendingActions();
    if (this.mOnBackPressedCallback.isEnabled())
    {
      popBackStackImmediate();
      return;
    }
    this.mOnBackPressedDispatcher.onBackPressed();
  }
  
  public void hideFragment(Fragment paramFragment)
  {
    boolean bool = true;
    if (DEBUG) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mHiddenChanged) {
        break label59;
      }
    }
    for (;;)
    {
      paramFragment.mHiddenChanged = bool;
      return;
      label59:
      bool = false;
    }
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  boolean isPrimaryNavigation(@Nullable Fragment paramFragment)
  {
    if (paramFragment == null) {}
    FragmentManagerImpl localFragmentManagerImpl;
    do
    {
      return true;
      localFragmentManagerImpl = paramFragment.mFragmentManager;
    } while ((paramFragment == localFragmentManagerImpl.getPrimaryNavigationFragment()) && (isPrimaryNavigation(localFragmentManagerImpl.mParent)));
    return false;
  }
  
  boolean isStateAtLeast(int paramInt)
  {
    return this.mCurState >= paramInt;
  }
  
  public boolean isStateSaved()
  {
    return (this.mStateSaved) || (this.mStopped);
  }
  
  AnimationOrAnimator loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int j = paramFragment.getNextAnim();
    paramFragment.setNextAnim(0);
    if ((paramFragment.mContainer != null) && (paramFragment.mContainer.getLayoutTransition() != null)) {
      return null;
    }
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, j);
    if (localAnimation != null) {
      return new AnimationOrAnimator(localAnimation);
    }
    paramFragment = paramFragment.onCreateAnimator(paramInt1, paramBoolean, j);
    if (paramFragment != null) {
      return new AnimationOrAnimator(paramFragment);
    }
    boolean bool;
    if (j != 0)
    {
      bool = "anim".equals(this.mHost.getContext().getResources().getResourceTypeName(j));
      if (!bool) {
        break label359;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramFragment = AnimationUtils.loadAnimation(this.mHost.getContext(), j);
        if (paramFragment != null)
        {
          paramFragment = new AnimationOrAnimator(paramFragment);
          return paramFragment;
        }
        i = 1;
      }
      catch (Resources.NotFoundException paramFragment)
      {
        try
        {
          paramFragment = AnimatorInflater.loadAnimator(this.mHost.getContext(), j);
          if (paramFragment == null) {
            break label218;
          }
          paramFragment = new AnimationOrAnimator(paramFragment);
          return paramFragment;
        }
        catch (RuntimeException paramFragment)
        {
          if (!bool) {
            break label192;
          }
          throw paramFragment;
          paramFragment = AnimationUtils.loadAnimation(this.mHost.getContext(), j);
          if (paramFragment == null) {
            break label218;
          }
          return new AnimationOrAnimator(paramFragment);
        }
        paramFragment = paramFragment;
        throw paramFragment;
      }
      catch (RuntimeException paramFragment)
      {
        i = 0;
        continue;
      }
      if (i == 0) {}
      label192:
      label218:
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
      if (paramInt1 < 0) {
        break;
      }
      switch (paramInt1)
      {
      default: 
        paramInt1 = paramInt2;
        if (paramInt2 == 0)
        {
          paramInt1 = paramInt2;
          if (this.mHost.onHasWindowAnimations()) {
            paramInt1 = this.mHost.onGetWindowAnimations();
          }
        }
        if (paramInt1 != 0) {
          break;
        }
        return null;
      case 1: 
        return makeOpenCloseAnimation(1.125F, 1.0F, 0.0F, 1.0F);
      case 2: 
        return makeOpenCloseAnimation(1.0F, 0.975F, 1.0F, 0.0F);
      case 3: 
        return makeOpenCloseAnimation(0.975F, 1.0F, 0.0F, 1.0F);
      case 4: 
        return makeOpenCloseAnimation(1.0F, 1.075F, 1.0F, 0.0F);
      case 5: 
        return makeFadeAnimation(0.0F, 1.0F);
      case 6: 
        return makeFadeAnimation(1.0F, 0.0F);
        label359:
        i = 0;
      }
    }
  }
  
  void makeActive(Fragment paramFragment)
  {
    if (this.mActive.get(paramFragment.mWho) != null) {
      return;
    }
    this.mActive.put(paramFragment.mWho, paramFragment);
    if (paramFragment.mRetainInstanceChangedWhileDetached)
    {
      if (!paramFragment.mRetainInstance) {
        break label85;
      }
      addRetainedFragment(paramFragment);
    }
    for (;;)
    {
      paramFragment.mRetainInstanceChangedWhileDetached = false;
      if (!DEBUG) {
        break;
      }
      Log.v("FragmentManager", "Added fragment to active set " + paramFragment);
      return;
      label85:
      removeRetainedFragment(paramFragment);
    }
  }
  
  void makeInactive(Fragment paramFragment)
  {
    if (this.mActive.get(paramFragment.mWho) == null) {
      return;
    }
    if (DEBUG) {
      Log.v("FragmentManager", "Removed fragment from active set " + paramFragment);
    }
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (paramFragment.mWho.equals(localFragment.mTargetWho)))
      {
        localFragment.mTarget = paramFragment;
        localFragment.mTargetWho = null;
      }
    }
    this.mActive.put(paramFragment.mWho, null);
    removeRetainedFragment(paramFragment);
    if (paramFragment.mTargetWho != null) {
      paramFragment.mTarget = ((Fragment)this.mActive.get(paramFragment.mTargetWho));
    }
    paramFragment.initState();
  }
  
  void moveFragmentToExpectedState(Fragment paramFragment)
  {
    if (paramFragment == null) {}
    label295:
    label316:
    for (;;)
    {
      return;
      if (!this.mActive.containsKey(paramFragment.mWho))
      {
        if (DEBUG) {
          Log.v("FragmentManager", "Ignoring moving " + paramFragment + " to state " + this.mCurState + "since it is not added to " + this);
        }
      }
      else
      {
        int j = this.mCurState;
        int i = j;
        Object localObject;
        if (paramFragment.mRemoving)
        {
          if (paramFragment.isInBackStack()) {
            i = Math.min(j, 1);
          }
        }
        else
        {
          moveToState(paramFragment, i, paramFragment.getNextTransition(), paramFragment.getNextTransitionStyle(), false);
          if (paramFragment.mView != null)
          {
            localObject = findFragmentUnder(paramFragment);
            if (localObject != null)
            {
              localObject = ((Fragment)localObject).mView;
              ViewGroup localViewGroup = paramFragment.mContainer;
              i = localViewGroup.indexOfChild((View)localObject);
              j = localViewGroup.indexOfChild(paramFragment.mView);
              if (j < i)
              {
                localViewGroup.removeViewAt(j);
                localViewGroup.addView(paramFragment.mView, i);
              }
            }
            if ((paramFragment.mIsNewlyAdded) && (paramFragment.mContainer != null))
            {
              if (paramFragment.mPostponedAlpha > 0.0F) {
                paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha);
              }
              paramFragment.mPostponedAlpha = 0.0F;
              paramFragment.mIsNewlyAdded = false;
              localObject = loadAnimation(paramFragment, paramFragment.getNextTransition(), true, paramFragment.getNextTransitionStyle());
              if (localObject != null)
              {
                if (((AnimationOrAnimator)localObject).animation == null) {
                  break label295;
                }
                paramFragment.mView.startAnimation(((AnimationOrAnimator)localObject).animation);
              }
            }
          }
        }
        for (;;)
        {
          if (!paramFragment.mHiddenChanged) {
            break label316;
          }
          completeShowHideFragment(paramFragment);
          return;
          i = Math.min(j, 0);
          break;
          ((AnimationOrAnimator)localObject).animator.setTarget(paramFragment.mView);
          ((AnimationOrAnimator)localObject).animator.start();
        }
      }
    }
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    if ((this.mHost == null) && (paramInt != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.mCurState)) {}
    do
    {
      return;
      this.mCurState = paramInt;
      int i = this.mAdded.size();
      paramInt = 0;
      while (paramInt < i)
      {
        moveFragmentToExpectedState((Fragment)this.mAdded.get(paramInt));
        paramInt += 1;
      }
      Iterator localIterator = this.mActive.values().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if ((localFragment != null) && ((localFragment.mRemoving) || (localFragment.mDetached)) && (!localFragment.mIsNewlyAdded)) {
          moveFragmentToExpectedState(localFragment);
        }
      }
      startPendingDeferredFragments();
    } while ((!this.mNeedMenuInvalidate) || (this.mHost == null) || (this.mCurState != 4));
    this.mHost.onSupportInvalidateOptionsMenu();
    this.mNeedMenuInvalidate = false;
  }
  
  void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramFragment.mAdded)
    {
      i = paramInt1;
      if (!paramFragment.mDetached) {}
    }
    else
    {
      i = paramInt1;
      if (paramInt1 > 1) {
        i = 1;
      }
    }
    paramInt1 = i;
    if (paramFragment.mRemoving)
    {
      paramInt1 = i;
      if (i > paramFragment.mState)
      {
        if ((paramFragment.mState != 0) || (!paramFragment.isInBackStack())) {
          break label138;
        }
        paramInt1 = 1;
      }
    }
    int i = paramInt1;
    if (paramFragment.mDeferStart)
    {
      i = paramInt1;
      if (paramFragment.mState < 3)
      {
        i = paramInt1;
        if (paramInt1 > 2) {
          i = 2;
        }
      }
    }
    if (paramFragment.mMaxState == Lifecycle.State.CREATED) {
      paramInt1 = Math.min(i, 1);
    }
    for (;;)
    {
      if (paramFragment.mState <= paramInt1)
      {
        if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout))
        {
          return;
          label138:
          paramInt1 = paramFragment.mState;
          break;
          paramInt1 = Math.min(i, paramFragment.mMaxState.ordinal());
          continue;
        }
        if ((paramFragment.getAnimatingAway() != null) || (paramFragment.getAnimator() != null))
        {
          paramFragment.setAnimatingAway(null);
          paramFragment.setAnimator(null);
          moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
        }
        paramInt3 = paramInt1;
        i = paramInt1;
        paramInt2 = paramInt1;
        switch (paramFragment.mState)
        {
        default: 
          i = paramInt1;
        }
      }
    }
    while (paramFragment.mState != i)
    {
      Log.w("FragmentManager", "moveToState: Fragment state for " + paramFragment + " not updated inline; expected state " + i + " found " + paramFragment.mState);
      paramFragment.mState = i;
      return;
      paramInt3 = paramInt1;
      Object localObject1;
      label462:
      label601:
      label607:
      label636:
      ViewGroup localViewGroup;
      if (paramInt1 > 0)
      {
        if (DEBUG) {
          Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
        }
        paramInt3 = paramInt1;
        if (paramFragment.mSavedFragmentState != null)
        {
          paramFragment.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
          paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
          localObject1 = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
          if (localObject1 == null) {
            break label601;
          }
          localObject1 = ((Fragment)localObject1).mWho;
          paramFragment.mTargetWho = ((String)localObject1);
          if (paramFragment.mTargetWho != null) {
            paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
          }
          if (paramFragment.mSavedUserVisibleHint == null) {
            break label607;
          }
          paramFragment.mUserVisibleHint = paramFragment.mSavedUserVisibleHint.booleanValue();
          paramFragment.mSavedUserVisibleHint = null;
          paramInt3 = paramInt1;
          if (!paramFragment.mUserVisibleHint)
          {
            paramFragment.mDeferStart = true;
            paramInt3 = paramInt1;
            if (paramInt1 > 2) {
              paramInt3 = 2;
            }
          }
        }
        paramFragment.mHost = this.mHost;
        paramFragment.mParentFragment = this.mParent;
        if (this.mParent != null) {}
        for (localObject1 = this.mParent.mChildFragmentManager;; localObject1 = this.mHost.mFragmentManager)
        {
          paramFragment.mFragmentManager = ((FragmentManagerImpl)localObject1);
          if (paramFragment.mTarget == null) {
            break label675;
          }
          if (this.mActive.get(paramFragment.mTarget.mWho) == paramFragment.mTarget) {
            break label636;
          }
          throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.mTarget + " that does not belong to this FragmentManager!");
          localObject1 = null;
          break;
          paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
          break label462;
        }
        if (paramFragment.mTarget.mState < 1) {
          moveToState(paramFragment.mTarget, 1, 0, 0, true);
        }
        paramFragment.mTargetWho = paramFragment.mTarget.mWho;
        paramFragment.mTarget = null;
        label675:
        if (paramFragment.mTargetWho != null)
        {
          localObject1 = (Fragment)this.mActive.get(paramFragment.mTargetWho);
          if (localObject1 == null) {
            throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.mTargetWho + " that does not belong to this FragmentManager!");
          }
          if (((Fragment)localObject1).mState < 1) {
            moveToState((Fragment)localObject1, 1, 0, 0, true);
          }
        }
        dispatchOnFragmentPreAttached(paramFragment, this.mHost.getContext(), false);
        paramFragment.performAttach();
        if (paramFragment.mParentFragment == null)
        {
          this.mHost.onAttachFragment(paramFragment);
          label801:
          dispatchOnFragmentAttached(paramFragment, this.mHost.getContext(), false);
          if (paramFragment.mIsCreated) {
            break label1376;
          }
          dispatchOnFragmentPreCreated(paramFragment, paramFragment.mSavedFragmentState, false);
          paramFragment.performCreate(paramFragment.mSavedFragmentState);
          dispatchOnFragmentCreated(paramFragment, paramFragment.mSavedFragmentState, false);
        }
      }
      else
      {
        if (paramInt3 > 0) {
          ensureInflatedFragmentView(paramFragment);
        }
        i = paramInt3;
        if (paramInt3 > 1)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!paramFragment.mFromLayout)
          {
            localObject1 = null;
            if (paramFragment.mContainerId != 0)
            {
              if (paramFragment.mContainerId == -1) {
                throwException(new IllegalArgumentException("Cannot create fragment " + paramFragment + " for a container view with no id"));
              }
              localViewGroup = (ViewGroup)this.mContainer.onFindViewById(paramFragment.mContainerId);
              localObject1 = localViewGroup;
              if (localViewGroup == null)
              {
                localObject1 = localViewGroup;
                if (paramFragment.mRestored) {}
              }
            }
          }
        }
      }
      label1376:
      Object localObject2;
      try
      {
        localObject1 = paramFragment.getResources().getResourceName(paramFragment.mContainerId);
        throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + (String)localObject1 + ") for fragment " + paramFragment));
        localObject1 = localViewGroup;
        paramFragment.mContainer = ((ViewGroup)localObject1);
        paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject1, paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null)
        {
          paramFragment.mInnerView = paramFragment.mView;
          paramFragment.mView.setSaveFromParentEnabled(false);
          if (localObject1 != null) {
            ((ViewGroup)localObject1).addView(paramFragment.mView);
          }
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          dispatchOnFragmentViewCreated(paramFragment, paramFragment.mView, paramFragment.mSavedFragmentState, false);
          if ((paramFragment.mView.getVisibility() == 0) && (paramFragment.mContainer != null))
          {
            paramBoolean = true;
            paramFragment.mIsNewlyAdded = paramBoolean;
            paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
            dispatchOnFragmentActivityCreated(paramFragment, paramFragment.mSavedFragmentState, false);
            if (paramFragment.mView != null) {
              paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
            }
            paramFragment.mSavedFragmentState = null;
            i = paramInt3;
            paramInt2 = i;
            if (i > 2)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
              }
              paramFragment.performStart();
              dispatchOnFragmentStarted(paramFragment, false);
              paramInt2 = i;
            }
            i = paramInt2;
            if (paramInt2 <= 3) {
              continue;
            }
            if (DEBUG) {
              Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
            }
            paramFragment.performResume();
            dispatchOnFragmentResumed(paramFragment, false);
            paramFragment.mSavedFragmentState = null;
            paramFragment.mSavedViewState = null;
            i = paramInt2;
            continue;
            paramFragment.mParentFragment.onAttachFragment(paramFragment);
            break label801;
            paramFragment.restoreChildFragmentState(paramFragment.mSavedFragmentState);
            paramFragment.mState = 1;
          }
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          localObject2 = "unknown";
          continue;
          paramBoolean = false;
          continue;
          paramFragment.mInnerView = null;
        }
      }
      i = paramInt1;
      if (paramFragment.mState > paramInt1) {
        switch (paramFragment.mState)
        {
        default: 
          i = paramInt1;
          break;
        case 1: 
          i = paramInt1;
          if (paramInt1 < 1) {
            if (this.mDestroyed)
            {
              if (paramFragment.getAnimatingAway() == null) {
                break label1877;
              }
              localObject2 = paramFragment.getAnimatingAway();
              paramFragment.setAnimatingAway(null);
              ((View)localObject2).clearAnimation();
            }
          }
          break;
        case 4: 
        case 3: 
        case 2: 
          for (;;)
          {
            label1466:
            if ((paramFragment.getAnimatingAway() == null) && (paramFragment.getAnimator() == null)) {
              break label1903;
            }
            paramFragment.setStateAfterAnimating(paramInt1);
            i = 1;
            break;
            if (paramInt1 < 4)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
              }
              paramFragment.performPause();
              dispatchOnFragmentPaused(paramFragment, false);
            }
            if (paramInt1 < 3)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
              }
              paramFragment.performStop();
              dispatchOnFragmentStopped(paramFragment, false);
            }
            if (paramInt1 >= 2) {
              break label1466;
            }
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
            }
            if ((paramFragment.mView != null) && (this.mHost.onShouldSaveFragmentState(paramFragment)) && (paramFragment.mSavedViewState == null)) {
              saveFragmentViewState(paramFragment);
            }
            paramFragment.performDestroyView();
            dispatchOnFragmentViewDestroyed(paramFragment, false);
            if ((paramFragment.mView != null) && (paramFragment.mContainer != null))
            {
              paramFragment.mContainer.endViewTransition(paramFragment.mView);
              paramFragment.mView.clearAnimation();
              localViewGroup = null;
              if ((paramFragment.getParentFragment() == null) || (!paramFragment.getParentFragment().mRemoving))
              {
                localObject2 = localViewGroup;
                if (this.mCurState > 0)
                {
                  localObject2 = localViewGroup;
                  if (!this.mDestroyed)
                  {
                    localObject2 = localViewGroup;
                    if (paramFragment.mView.getVisibility() == 0)
                    {
                      localObject2 = localViewGroup;
                      if (paramFragment.mPostponedAlpha >= 0.0F) {
                        localObject2 = loadAnimation(paramFragment, paramInt2, false, paramInt3);
                      }
                    }
                  }
                }
                paramFragment.mPostponedAlpha = 0.0F;
                if (localObject2 != null) {
                  animateRemoveFragment(paramFragment, (AnimationOrAnimator)localObject2, paramInt1);
                }
                paramFragment.mContainer.removeView(paramFragment.mView);
              }
            }
            paramFragment.mContainer = null;
            paramFragment.mView = null;
            paramFragment.mViewLifecycleOwner = null;
            paramFragment.mViewLifecycleOwnerLiveData.setValue(null);
            paramFragment.mInnerView = null;
            paramFragment.mInLayout = false;
            break label1466;
            label1877:
            if (paramFragment.getAnimator() != null)
            {
              localObject2 = paramFragment.getAnimator();
              paramFragment.setAnimator(null);
              ((Animator)localObject2).cancel();
            }
          }
          label1903:
          if (DEBUG) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          label1951:
          boolean bool;
          if ((paramFragment.mRemoving) && (!paramFragment.isInBackStack()))
          {
            paramInt2 = 1;
            if ((paramInt2 == 0) && (!this.mNonConfig.shouldDestroy(paramFragment))) {
              break label2108;
            }
            if (!(this.mHost instanceof ViewModelStoreOwner)) {
              break label2061;
            }
            bool = this.mNonConfig.isCleared();
            label1985:
            if ((paramInt2 != 0) || (bool)) {
              this.mNonConfig.clearNonConfigState(paramFragment);
            }
            paramFragment.performDestroy();
            dispatchOnFragmentDestroyed(paramFragment, false);
          }
          for (;;)
          {
            paramFragment.performDetach();
            dispatchOnFragmentDetached(paramFragment, false);
            i = paramInt1;
            if (paramBoolean) {
              break;
            }
            if ((paramInt2 == 0) && (!this.mNonConfig.shouldDestroy(paramFragment))) {
              break label2116;
            }
            makeInactive(paramFragment);
            i = paramInt1;
            break;
            paramInt2 = 0;
            break label1951;
            label2061:
            if ((this.mHost.getContext() instanceof Activity))
            {
              if (!((Activity)this.mHost.getContext()).isChangingConfigurations())
              {
                bool = true;
                break label1985;
              }
              bool = false;
              break label1985;
            }
            bool = true;
            break label1985;
            label2108:
            paramFragment.mState = 0;
          }
          label2116:
          paramFragment.mHost = null;
          paramFragment.mParentFragment = null;
          paramFragment.mFragmentManager = null;
          i = paramInt1;
          if (paramFragment.mTargetWho != null)
          {
            localObject2 = (Fragment)this.mActive.get(paramFragment.mTargetWho);
            i = paramInt1;
            if (localObject2 != null)
            {
              i = paramInt1;
              if (((Fragment)localObject2).getRetainInstance())
              {
                paramFragment.mTarget = ((Fragment)localObject2);
                i = paramInt1;
              }
            }
          }
          break;
        }
      }
    }
  }
  
  public void noteStateNotSaved()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    int j = this.mAdded.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
      i += 1;
    }
  }
  
  @Nullable
  public View onCreateView(@Nullable View paramView, @NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int k = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if ((str1 == null) || (!FragmentFactory.isFragmentClass(paramContext.getClassLoader(), str1))) {
        return null;
      }
      if (paramView != null) {}
      for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      }
      int j;
      if (k != -1)
      {
        paramString = findFragmentById(k);
        paramView = paramString;
        if (paramString == null)
        {
          paramView = paramString;
          if (str2 != null) {
            paramView = findFragmentByTag(str2);
          }
        }
        paramString = paramView;
        if (paramView == null)
        {
          paramString = paramView;
          if (i != -1) {
            paramString = findFragmentById(i);
          }
        }
        if (DEBUG) {
          Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(k) + " fname=" + str1 + " existing=" + paramString);
        }
        if (paramString != null) {
          break label437;
        }
        paramView = getFragmentFactory().instantiate(paramContext.getClassLoader(), str1);
        paramView.mFromLayout = true;
        if (k == 0) {
          break label430;
        }
        j = k;
        label300:
        paramView.mFragmentId = j;
        paramView.mContainerId = i;
        paramView.mTag = str2;
        paramView.mInLayout = true;
        paramView.mFragmentManager = this;
        paramView.mHost = this.mHost;
        paramView.onInflate(this.mHost.getContext(), paramAttributeSet, paramView.mSavedFragmentState);
        addFragment(paramView, true);
        label359:
        if ((this.mCurState >= 1) || (!paramView.mFromLayout)) {
          break label557;
        }
        moveToState(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (paramView.mView != null) {
          break label565;
        }
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        paramString = null;
        break;
        label430:
        j = i;
        break label300;
        label437:
        if (paramString.mInLayout) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
        }
        paramString.mInLayout = true;
        paramString.mHost = this.mHost;
        paramString.onInflate(this.mHost.getContext(), paramAttributeSet, paramString.mSavedFragmentState);
        paramView = paramString;
        break label359;
        label557:
        moveToState(paramView);
      }
      label565:
      if (k != 0) {
        paramView.mView.setId(k);
      }
      if (paramView.mView.getTag() == null) {
        paramView.mView.setTag(str2);
      }
      return paramView.mView;
    }
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void performPendingDeferredStart(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
      }
    }
    else {
      return;
    }
    paramFragment.mDeferStart = false;
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  public void popBackStack()
  {
    enqueueAction(new PopBackStackState(null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    enqueueAction(new PopBackStackState(null, paramInt1, paramInt2), false);
  }
  
  public void popBackStack(@Nullable String paramString, int paramInt)
  {
    enqueueAction(new PopBackStackState(paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate()
  {
    checkStateLoss();
    return popBackStackImmediate(null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    execPendingActions();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    return popBackStackImmediate(null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(@Nullable String paramString, int paramInt)
  {
    checkStateLoss();
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1, String paramString, int paramInt1, int paramInt2)
  {
    if (this.mBackStack == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = this.mBackStack.size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(this.mBackStack.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
    }
    for (;;)
    {
      return true;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int j = this.mBackStack.size() - 1;
        BackStackRecord localBackStackRecord;
        for (;;)
        {
          if (j >= 0)
          {
            localBackStackRecord = (BackStackRecord)this.mBackStack.get(j);
            if ((paramString == null) || (!paramString.equals(localBackStackRecord.getName()))) {
              break label133;
            }
          }
          label133:
          while ((paramInt1 >= 0) && (paramInt1 == localBackStackRecord.mIndex))
          {
            if (j >= 0) {
              break;
            }
            return false;
          }
          j -= 1;
        }
        i = j;
        if ((paramInt2 & 0x1) != 0)
        {
          paramInt2 = j - 1;
          for (;;)
          {
            i = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            localBackStackRecord = (BackStackRecord)this.mBackStack.get(paramInt2);
            if ((paramString == null) || (!paramString.equals(localBackStackRecord.getName())))
            {
              i = paramInt2;
              if (paramInt1 < 0) {
                break;
              }
              i = paramInt2;
              if (paramInt1 != localBackStackRecord.mIndex) {
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
      }
      if (i == this.mBackStack.size() - 1) {
        return false;
      }
      paramInt1 = this.mBackStack.size() - 1;
      while (paramInt1 > i)
      {
        paramArrayList.add(this.mBackStack.remove(paramInt1));
        paramArrayList1.add(Boolean.valueOf(true));
        paramInt1 -= 1;
      }
    }
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mFragmentManager != this) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putString(paramString, paramFragment.mWho);
  }
  
  public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean)
  {
    this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(paramFragmentLifecycleCallbacks, paramBoolean));
  }
  
  public void removeFragment(Fragment paramFragment)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.mBackStackNesting);
    }
    int i;
    if (!paramFragment.isInBackStack()) {
      i = 1;
    }
    for (;;)
    {
      if ((!paramFragment.mDetached) || (i != 0)) {}
      synchronized (this.mAdded)
      {
        this.mAdded.remove(paramFragment);
        if (isMenuAvailable(paramFragment)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        return;
        i = 0;
      }
    }
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener);
    }
  }
  
  void removeRetainedFragment(@NonNull Fragment paramFragment)
  {
    if (isStateSaved()) {
      if (DEBUG) {
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
      }
    }
    while ((!this.mNonConfig.removeRetainedFragment(paramFragment)) || (!DEBUG)) {
      return;
    }
    Log.v("FragmentManager", "Updating retained Fragments: Removed " + paramFragment);
  }
  
  void reportBackStackChanged()
  {
    if (this.mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < this.mBackStackChangeListeners.size())
      {
        ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
  }
  
  void restoreAllState(Parcelable paramParcelable, FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    if ((this.mHost instanceof ViewModelStoreOwner)) {
      throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    }
    this.mNonConfig.restoreFromSnapshot(paramFragmentManagerNonConfig);
    restoreSaveState(paramParcelable);
  }
  
  void restoreSaveState(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {}
    FragmentManagerState localFragmentManagerState;
    do
    {
      return;
      localFragmentManagerState = (FragmentManagerState)paramParcelable;
    } while (localFragmentManagerState.mActive == null);
    ??? = this.mNonConfig.getRetainedFragments().iterator();
    Fragment localFragment;
    Object localObject1;
    if (((Iterator)???).hasNext())
    {
      localFragment = (Fragment)((Iterator)???).next();
      if (DEBUG) {
        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + localFragment);
      }
      localObject1 = localFragmentManagerState.mActive.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        paramParcelable = (FragmentState)((Iterator)localObject1).next();
      } while (!paramParcelable.mWho.equals(localFragment.mWho));
    }
    for (;;)
    {
      if (paramParcelable == null)
      {
        if (DEBUG) {
          Log.v("FragmentManager", "Discarding retained Fragment " + localFragment + " that was not found in the set of active Fragments " + localFragmentManagerState.mActive);
        }
        moveToState(localFragment, 1, 0, 0, false);
        localFragment.mRemoving = true;
        moveToState(localFragment, 0, 0, 0, false);
        break;
      }
      paramParcelable.mInstance = localFragment;
      localFragment.mSavedViewState = null;
      localFragment.mBackStackNesting = 0;
      localFragment.mInLayout = false;
      localFragment.mAdded = false;
      if (localFragment.mTarget != null) {}
      for (localObject1 = localFragment.mTarget.mWho;; localObject1 = null)
      {
        localFragment.mTargetWho = ((String)localObject1);
        localFragment.mTarget = null;
        if (paramParcelable.mSavedFragmentState == null) {
          break;
        }
        paramParcelable.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
        localFragment.mSavedViewState = paramParcelable.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        localFragment.mSavedFragmentState = paramParcelable.mSavedFragmentState;
        break;
      }
      this.mActive.clear();
      paramParcelable = localFragmentManagerState.mActive.iterator();
      while (paramParcelable.hasNext())
      {
        localObject1 = (FragmentState)paramParcelable.next();
        if (localObject1 != null)
        {
          ??? = ((FragmentState)localObject1).instantiate(this.mHost.getContext().getClassLoader(), getFragmentFactory());
          ((Fragment)???).mFragmentManager = this;
          if (DEBUG) {
            Log.v("FragmentManager", "restoreSaveState: active (" + ((Fragment)???).mWho + "): " + ???);
          }
          this.mActive.put(((Fragment)???).mWho, ???);
          ((FragmentState)localObject1).mInstance = null;
        }
      }
      this.mAdded.clear();
      if (localFragmentManagerState.mAdded != null)
      {
        paramParcelable = localFragmentManagerState.mAdded.iterator();
        while (paramParcelable.hasNext())
        {
          ??? = (String)paramParcelable.next();
          localObject1 = (Fragment)this.mActive.get(???);
          if (localObject1 == null) {
            throwException(new IllegalStateException("No instantiated fragment for (" + (String)??? + ")"));
          }
          ((Fragment)localObject1).mAdded = true;
          if (DEBUG) {
            Log.v("FragmentManager", "restoreSaveState: added (" + (String)??? + "): " + localObject1);
          }
          if (this.mAdded.contains(localObject1)) {
            throw new IllegalStateException("Already added " + localObject1);
          }
          synchronized (this.mAdded)
          {
            this.mAdded.add(localObject1);
          }
        }
      }
      if (localFragmentManagerState.mBackStack != null)
      {
        this.mBackStack = new ArrayList(localFragmentManagerState.mBackStack.length);
        int i = 0;
        while (i < localFragmentManagerState.mBackStack.length)
        {
          paramParcelable = localFragmentManagerState.mBackStack[i].instantiate(this);
          if (DEBUG)
          {
            Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + paramParcelable.mIndex + "): " + paramParcelable);
            localObject1 = new PrintWriter(new LogWriter("FragmentManager"));
            paramParcelable.dump("  ", (PrintWriter)localObject1, false);
            ((PrintWriter)localObject1).close();
          }
          this.mBackStack.add(paramParcelable);
          if (paramParcelable.mIndex >= 0) {
            setBackStackIndex(paramParcelable.mIndex, paramParcelable);
          }
          i += 1;
        }
      }
      this.mBackStack = null;
      if (localFragmentManagerState.mPrimaryNavActiveWho != null)
      {
        this.mPrimaryNav = ((Fragment)this.mActive.get(localFragmentManagerState.mPrimaryNavActiveWho));
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
      }
      this.mNextFragmentIndex = localFragmentManagerState.mNextFragmentIndex;
      return;
      paramParcelable = null;
    }
  }
  
  @Deprecated
  FragmentManagerNonConfig retainNonConfig()
  {
    if ((this.mHost instanceof ViewModelStoreOwner)) {
      throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    }
    return this.mNonConfig.getSnapshot();
  }
  
  Parcelable saveAllState()
  {
    int j = 0;
    Object localObject3 = null;
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions();
    this.mStateSaved = true;
    if (this.mActive.isEmpty()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(this.mActive.size());
    Object localObject1 = this.mActive.values().iterator();
    int i = 0;
    label67:
    Object localObject2;
    Object localObject4;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Fragment)((Iterator)localObject1).next();
      if (localObject2 == null) {
        break label756;
      }
      if (((Fragment)localObject2).mFragmentManager != this) {
        throwException(new IllegalStateException("Failure saving state: active " + localObject2 + " was removed from the FragmentManager"));
      }
      localObject4 = new FragmentState((Fragment)localObject2);
      localArrayList.add(localObject4);
      if ((((Fragment)localObject2).mState > 0) && (((FragmentState)localObject4).mSavedFragmentState == null))
      {
        ((FragmentState)localObject4).mSavedFragmentState = saveFragmentBasicState((Fragment)localObject2);
        if (((Fragment)localObject2).mTargetWho != null)
        {
          Fragment localFragment = (Fragment)this.mActive.get(((Fragment)localObject2).mTargetWho);
          if (localFragment == null) {
            throwException(new IllegalStateException("Failure saving state: " + localObject2 + " has target not in fragment manager: " + ((Fragment)localObject2).mTargetWho));
          }
          if (((FragmentState)localObject4).mSavedFragmentState == null) {
            ((FragmentState)localObject4).mSavedFragmentState = new Bundle();
          }
          putFragment(((FragmentState)localObject4).mSavedFragmentState, "android:target_state", localFragment);
          if (((Fragment)localObject2).mTargetRequestCode != 0) {
            ((FragmentState)localObject4).mSavedFragmentState.putInt("android:target_req_state", ((Fragment)localObject2).mTargetRequestCode);
          }
        }
        label319:
        if (DEBUG) {
          Log.v("FragmentManager", "Saved state of " + localObject2 + ": " + ((FragmentState)localObject4).mSavedFragmentState);
        }
        i = 1;
      }
    }
    label756:
    for (;;)
    {
      break label67;
      ((FragmentState)localObject4).mSavedFragmentState = ((Fragment)localObject2).mSavedFragmentState;
      break label319;
      if (i == 0)
      {
        if (!DEBUG) {
          break;
        }
        Log.v("FragmentManager", "saveAllState: no fragments!");
        return null;
      }
      i = this.mAdded.size();
      if (i > 0)
      {
        localObject2 = new ArrayList(i);
        localObject4 = this.mAdded.iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject1 = (Fragment)((Iterator)localObject4).next();
          ((ArrayList)localObject2).add(((Fragment)localObject1).mWho);
          if (((Fragment)localObject1).mFragmentManager != this) {
            throwException(new IllegalStateException("Failure saving state: active " + localObject1 + " was removed from the FragmentManager"));
          }
          if (DEBUG) {
            Log.v("FragmentManager", "saveAllState: adding fragment (" + ((Fragment)localObject1).mWho + "): " + localObject1);
          }
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (this.mBackStack != null)
      {
        int k = this.mBackStack.size();
        localObject2 = localObject3;
        if (k > 0)
        {
          localObject3 = new BackStackState[k];
          i = j;
          for (;;)
          {
            localObject2 = localObject3;
            if (i >= k) {
              break;
            }
            localObject3[i] = new BackStackState((BackStackRecord)this.mBackStack.get(i));
            if (DEBUG) {
              Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.mBackStack.get(i));
            }
            i += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).mActive = localArrayList;
      ((FragmentManagerState)localObject3).mAdded = ((ArrayList)localObject1);
      ((FragmentManagerState)localObject3).mBackStack = ((BackStackState[])localObject2);
      if (this.mPrimaryNav != null) {
        ((FragmentManagerState)localObject3).mPrimaryNavActiveWho = this.mPrimaryNav.mWho;
      }
      ((FragmentManagerState)localObject3).mNextFragmentIndex = this.mNextFragmentIndex;
      return localObject3;
    }
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    if (this.mStateBundle == null) {
      this.mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.mStateBundle);
    dispatchOnFragmentSaveInstanceState(paramFragment, this.mStateBundle, false);
    Object localObject2;
    if (!this.mStateBundle.isEmpty())
    {
      localObject2 = this.mStateBundle;
      this.mStateBundle = null;
    }
    for (;;)
    {
      if (paramFragment.mView != null) {
        saveFragmentViewState(paramFragment);
      }
      Object localObject1 = localObject2;
      if (paramFragment.mSavedViewState != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
      }
      localObject2 = localObject1;
      if (!paramFragment.mUserVisibleHint)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
      }
      return localObject2;
      localObject2 = null;
    }
  }
  
  @Nullable
  public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment paramFragment)
  {
    Object localObject2 = null;
    if (paramFragment.mFragmentManager != this) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (paramFragment.mState > 0)
    {
      paramFragment = saveFragmentBasicState(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return localObject1;
  }
  
  void saveFragmentViewState(Fragment paramFragment)
  {
    if (paramFragment.mInnerView == null) {
      return;
    }
    if (this.mStateArray == null) {
      this.mStateArray = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() <= 0) {
        break;
      }
      paramFragment.mSavedViewState = this.mStateArray;
      this.mStateArray = null;
      return;
      this.mStateArray.clear();
    }
  }
  
  void scheduleCommit()
  {
    int j = 1;
    label44:
    label77:
    label96:
    label101:
    label104:
    for (;;)
    {
      int i;
      try
      {
        if ((this.mPostponedTransactions == null) || (this.mPostponedTransactions.isEmpty())) {
          break label96;
        }
        i = 1;
        if ((this.mPendingActions == null) || (this.mPendingActions.size() != 1)) {
          break label101;
        }
      }
      finally {}
      this.mHost.getHandler().removeCallbacks(this.mExecCommit);
      this.mHost.getHandler().post(this.mExecCommit);
      updateOnBackPressedCallbackEnabled();
      return;
      for (;;)
      {
        if (i != 0) {
          break label104;
        }
        if (j == 0) {
          break label77;
        }
        break label44;
        i = 0;
        break;
        j = 0;
      }
    }
  }
  
  /* Error */
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 786	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 141	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 142	java/util/ArrayList:<init>	()V
    //   17: putfield 786	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 786	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   24: invokevirtual 186	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +58 -> 93
    //   38: getstatic 122	androidx/fragment/app/FragmentManagerImpl:DEBUG	Z
    //   41: ifeq +39 -> 80
    //   44: ldc 52
    //   46: new 726	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 727	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 788
    //   56: invokevirtual 733	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iload_1
    //   60: invokevirtual 791	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc_w 793
    //   66: invokevirtual 733	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 739	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 742	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 786	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   84: iload_1
    //   85: aload_2
    //   86: invokevirtual 806	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: iload_3
    //   94: iload_1
    //   95: if_icmpge +81 -> 176
    //   98: aload_0
    //   99: getfield 786	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   102: aconst_null
    //   103: invokevirtual 647	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_0
    //   108: getfield 784	androidx/fragment/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   111: ifnonnull +14 -> 125
    //   114: aload_0
    //   115: new 141	java/util/ArrayList
    //   118: dup
    //   119: invokespecial 142	java/util/ArrayList:<init>	()V
    //   122: putfield 784	androidx/fragment/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   125: getstatic 122	androidx/fragment/app/FragmentManagerImpl:DEBUG	Z
    //   128: ifeq +29 -> 157
    //   131: ldc 52
    //   133: new 726	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 727	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 1924
    //   143: invokevirtual 733	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_3
    //   147: invokevirtual 791	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 739	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 742	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: aload_0
    //   158: getfield 784	androidx/fragment/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   161: iload_3
    //   162: invokestatic 1216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokevirtual 647	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: iload_3
    //   170: iconst_1
    //   171: iadd
    //   172: istore_3
    //   173: goto -80 -> 93
    //   176: getstatic 122	androidx/fragment/app/FragmentManagerImpl:DEBUG	Z
    //   179: ifeq +39 -> 218
    //   182: ldc 52
    //   184: new 726	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 727	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 800
    //   194: invokevirtual 733	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload_1
    //   198: invokevirtual 791	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc_w 802
    //   204: invokevirtual 733	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 739	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 742	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload_0
    //   219: getfield 786	androidx/fragment/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   222: aload_2
    //   223: invokevirtual 647	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: goto -137 -> 90
    //   230: astore_2
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_2
    //   234: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	FragmentManagerImpl
    //   0	235	1	paramInt	int
    //   0	235	2	paramBackStackRecord	BackStackRecord
    //   31	142	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	230	finally
    //   20	29	230	finally
    //   38	80	230	finally
    //   80	90	230	finally
    //   90	92	230	finally
    //   98	125	230	finally
    //   125	157	230	finally
    //   157	169	230	finally
    //   176	218	230	finally
    //   218	227	230	finally
    //   231	233	230	finally
  }
  
  public void setMaxLifecycle(Fragment paramFragment, Lifecycle.State paramState)
  {
    if ((this.mActive.get(paramFragment.mWho) != paramFragment) || ((paramFragment.mHost != null) && (paramFragment.getFragmentManager() != this))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    paramFragment.mMaxState = paramState;
  }
  
  public void setPrimaryNavigationFragment(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((this.mActive.get(paramFragment.mWho) != paramFragment) || ((paramFragment.mHost != null) && (paramFragment.getFragmentManager() != this)))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    Fragment localFragment = this.mPrimaryNav;
    this.mPrimaryNav = paramFragment;
    dispatchParentPrimaryNavigationFragmentChanged(localFragment);
    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
  }
  
  public void showFragment(Fragment paramFragment)
  {
    boolean bool = false;
    if (DEBUG) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (!paramFragment.mHiddenChanged) {
        bool = true;
      }
      paramFragment.mHiddenChanged = bool;
    }
  }
  
  void startPendingDeferredFragments()
  {
    Iterator localIterator = this.mActive.values().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        performPendingDeferredStart(localFragment);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent != null) {
      DebugUtils.buildShortClassTag(this.mParent, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      DebugUtils.buildShortClassTag(this.mHost, localStringBuilder);
    }
  }
  
  public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks)
  {
    for (;;)
    {
      int i;
      synchronized (this.mLifecycleCallbacks)
      {
        int j = this.mLifecycleCallbacks.size();
        i = 0;
        if (i < j)
        {
          if (((FragmentLifecycleCallbacksHolder)this.mLifecycleCallbacks.get(i)).mCallback == paramFragmentLifecycleCallbacks) {
            this.mLifecycleCallbacks.remove(i);
          }
        }
        else {
          return;
        }
      }
      i += 1;
    }
  }
  
  static class AnimationOrAnimator
  {
    public final Animation animation;
    public final Animator animator;
    
    AnimationOrAnimator(Animator paramAnimator)
    {
      this.animation = null;
      this.animator = paramAnimator;
      if (paramAnimator == null) {
        throw new IllegalStateException("Animator cannot be null");
      }
    }
    
    AnimationOrAnimator(Animation paramAnimation)
    {
      this.animation = paramAnimation;
      this.animator = null;
      if (paramAnimation == null) {
        throw new IllegalStateException("Animation cannot be null");
      }
    }
  }
  
  static class EndViewTransitionAnimation
    extends AnimationSet
    implements Runnable
  {
    private boolean mAnimating = true;
    private final View mChild;
    private boolean mEnded;
    private final ViewGroup mParent;
    private boolean mTransitionEnded;
    
    EndViewTransitionAnimation(@NonNull Animation paramAnimation, @NonNull ViewGroup paramViewGroup, @NonNull View paramView)
    {
      super();
      this.mParent = paramViewGroup;
      this.mChild = paramView;
      addAnimation(paramAnimation);
      this.mParent.post(this);
    }
    
    public boolean getTransformation(long paramLong, Transformation paramTransformation)
    {
      this.mAnimating = true;
      if (this.mEnded) {
        if (this.mTransitionEnded) {}
      }
      while (super.getTransformation(paramLong, paramTransformation))
      {
        return true;
        return false;
      }
      this.mEnded = true;
      OneShotPreDrawListener.add(this.mParent, this);
      return true;
    }
    
    public boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
    {
      this.mAnimating = true;
      if (this.mEnded) {
        if (this.mTransitionEnded) {}
      }
      while (super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        return true;
        return false;
      }
      this.mEnded = true;
      OneShotPreDrawListener.add(this.mParent, this);
      return true;
    }
    
    public void run()
    {
      if ((!this.mEnded) && (this.mAnimating))
      {
        this.mAnimating = false;
        this.mParent.post(this);
        return;
      }
      this.mParent.endViewTransition(this.mChild);
      this.mTransitionEnded = true;
    }
  }
  
  static final class FragmentLifecycleCallbacksHolder
  {
    final FragmentManager.FragmentLifecycleCallbacks mCallback;
    final boolean mRecursive;
    
    FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean)
    {
      this.mCallback = paramFragmentLifecycleCallbacks;
      this.mRecursive = paramBoolean;
    }
  }
  
  static class FragmentTag
  {
    public static final int[] Fragment = { 16842755, 16842960, 16842961 };
    public static final int Fragment_id = 1;
    public static final int Fragment_name = 0;
    public static final int Fragment_tag = 2;
  }
  
  static abstract interface OpGenerator
  {
    public abstract boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1);
  }
  
  class PopBackStackState
    implements FragmentManagerImpl.OpGenerator
  {
    final int mFlags;
    final int mId;
    final String mName;
    
    PopBackStackState(String paramString, int paramInt1, int paramInt2)
    {
      this.mName = paramString;
      this.mId = paramInt1;
      this.mFlags = paramInt2;
    }
    
    public boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
    {
      if ((FragmentManagerImpl.this.mPrimaryNav != null) && (this.mId < 0) && (this.mName == null) && (FragmentManagerImpl.this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate())) {
        return false;
      }
      return FragmentManagerImpl.this.popBackStackState(paramArrayList, paramArrayList1, this.mName, this.mId, this.mFlags);
    }
  }
  
  static class StartEnterTransitionListener
    implements Fragment.OnStartEnterTransitionListener
  {
    final boolean mIsBack;
    private int mNumPostponed;
    final BackStackRecord mRecord;
    
    StartEnterTransitionListener(BackStackRecord paramBackStackRecord, boolean paramBoolean)
    {
      this.mIsBack = paramBoolean;
      this.mRecord = paramBackStackRecord;
    }
    
    public void cancelTransaction()
    {
      this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
    }
    
    public void completeTransaction()
    {
      boolean bool1 = false;
      if (this.mNumPostponed > 0) {}
      for (int i = 1;; i = 0)
      {
        localFragmentManagerImpl = this.mRecord.mManager;
        int k = localFragmentManagerImpl.mAdded.size();
        int j = 0;
        while (j < k)
        {
          localObject = (Fragment)localFragmentManagerImpl.mAdded.get(j);
          ((Fragment)localObject).setOnStartEnterTransitionListener(null);
          if ((i != 0) && (((Fragment)localObject).isPostponed())) {
            ((Fragment)localObject).startPostponedEnterTransition();
          }
          j += 1;
        }
      }
      FragmentManagerImpl localFragmentManagerImpl = this.mRecord.mManager;
      Object localObject = this.mRecord;
      boolean bool2 = this.mIsBack;
      if (i == 0) {
        bool1 = true;
      }
      localFragmentManagerImpl.completeExecute((BackStackRecord)localObject, bool2, bool1, true);
    }
    
    public boolean isReady()
    {
      return this.mNumPostponed == 0;
    }
    
    public void onStartEnterTransition()
    {
      this.mNumPostponed -= 1;
      if (this.mNumPostponed != 0) {
        return;
      }
      this.mRecord.mManager.scheduleCommit();
    }
    
    public void startListening()
    {
      this.mNumPostponed += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentManagerImpl
 * JD-Core Version:    0.7.0.1
 */