package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class FragmentManagerImpl
  extends FragmentManager
  implements LayoutInflater.Factory2
{
  static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  static final Interpolator ACCELERATE_QUINT;
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  static Field sAnimationListenerField = null;
  SparseArray mActive;
  final ArrayList mAdded = new ArrayList();
  ArrayList mAvailBackStackIndices;
  ArrayList mBackStack;
  ArrayList mBackStackChangeListeners;
  ArrayList mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new FragmentManagerImpl.1(this);
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  FragmentHostCallback mHost;
  private final CopyOnWriteArrayList mLifecycleCallbacks = new CopyOnWriteArrayList();
  boolean mNeedMenuInvalidate;
  int mNextFragmentIndex = 0;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList mPendingActions;
  ArrayList mPostponedTransactions;
  Fragment mPrimaryNav;
  FragmentManagerNonConfig mSavedNonConfig;
  SparseArray mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  boolean mStopped;
  ArrayList mTmpAddedFragments;
  ArrayList mTmpIsPop;
  ArrayList mTmpRecords;
  
  static
  {
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  private void addAddedFragments(ArraySet paramArraySet)
  {
    if (this.mCurState < 1) {}
    for (;;)
    {
      return;
      int j = Math.min(this.mCurState, 4);
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
  
  private void animateRemoveFragment(@NonNull Fragment paramFragment, @NonNull FragmentManagerImpl.AnimationOrAnimator paramAnimationOrAnimator, int paramInt)
  {
    View localView = paramFragment.mView;
    ViewGroup localViewGroup = paramFragment.mContainer;
    localViewGroup.startViewTransition(localView);
    paramFragment.setStateAfterAnimating(paramInt);
    if (paramAnimationOrAnimator.animation != null)
    {
      localObject = new FragmentManagerImpl.EndViewTransitionAnimator(paramAnimationOrAnimator.animation, localViewGroup, localView);
      paramFragment.setAnimatingAway(paramFragment.mView);
      ((Animation)localObject).setAnimationListener(new FragmentManagerImpl.2(this, getAnimationListener((Animation)localObject), localViewGroup, paramFragment));
      setHWLayerAnimListenerIfAlpha(localView, paramAnimationOrAnimator);
      paramFragment.mView.startAnimation((Animation)localObject);
      return;
    }
    Object localObject = paramAnimationOrAnimator.animator;
    paramFragment.setAnimator(paramAnimationOrAnimator.animator);
    ((Animator)localObject).addListener(new FragmentManagerImpl.3(this, localViewGroup, localView, paramFragment));
    ((Animator)localObject).setTarget(paramFragment.mView);
    setHWLayerAnimListenerIfAlpha(paramFragment.mView, paramAnimationOrAnimator);
    ((Animator)localObject).start();
  }
  
  private void burpActive()
  {
    if (this.mActive != null)
    {
      int i = this.mActive.size() - 1;
      while (i >= 0)
      {
        if (this.mActive.valueAt(i) == null) {
          this.mActive.delete(this.mActive.keyAt(i));
        }
        i -= 1;
      }
    }
  }
  
  private void checkStateLoss()
  {
    if (isStateSaved()) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.mNoTransactionsBecause != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
    }
  }
  
  private void cleanupExec()
  {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void completeExecute(BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject;
    int i;
    if (paramBoolean1)
    {
      paramBackStackRecord.executePopOps(paramBoolean3);
      localObject = new ArrayList(1);
      ArrayList localArrayList = new ArrayList(1);
      ((ArrayList)localObject).add(paramBackStackRecord);
      localArrayList.add(Boolean.valueOf(paramBoolean1));
      if (paramBoolean2) {
        FragmentTransition.startTransitions(this, (ArrayList)localObject, localArrayList, 0, 1, true);
      }
      if (paramBoolean3) {
        moveToState(this.mCurState, true);
      }
      if (this.mActive == null) {
        return;
      }
      int j = this.mActive.size();
      i = 0;
      label95:
      if (i >= j) {
        return;
      }
      localObject = (Fragment)this.mActive.valueAt(i);
      if ((localObject != null) && (((Fragment)localObject).mView != null) && (((Fragment)localObject).mIsNewlyAdded) && (paramBackStackRecord.interactsWith(((Fragment)localObject).mContainerId)))
      {
        if (((Fragment)localObject).mPostponedAlpha > 0.0F) {
          ((Fragment)localObject).mView.setAlpha(((Fragment)localObject).mPostponedAlpha);
        }
        if (!paramBoolean3) {
          break label199;
        }
        ((Fragment)localObject).mPostponedAlpha = 0.0F;
      }
    }
    for (;;)
    {
      i += 1;
      break label95;
      paramBackStackRecord.executeOps();
      break;
      label199:
      ((Fragment)localObject).mPostponedAlpha = -1.0F;
      ((Fragment)localObject).mIsNewlyAdded = false;
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
    int i;
    int j;
    label11:
    Fragment localFragment;
    if (this.mActive == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localFragment = (Fragment)this.mActive.valueAt(j);
      if (localFragment != null)
      {
        if (localFragment.getAnimatingAway() == null) {
          break label111;
        }
        int k = localFragment.getStateAfterAnimating();
        View localView = localFragment.getAnimatingAway();
        Animation localAnimation = localView.getAnimation();
        if (localAnimation != null)
        {
          localAnimation.cancel();
          localView.clearAnimation();
        }
        localFragment.setAnimatingAway(null);
        moveToState(localFragment, k, 0, 0, false);
      }
    }
    for (;;)
    {
      j += 1;
      break label11;
      i = this.mActive.size();
      break;
      label111:
      if (localFragment.getAnimator() != null) {
        localFragment.getAnimator().end();
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
  
  private static void executeOps(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList1.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList2.get(paramInt1)).booleanValue())
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
  
  private void executeOpsTogether(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    boolean bool = ((BackStackRecord)paramArrayList1.get(paramInt1)).mReorderingAllowed;
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
      localBackStackRecord = (BackStackRecord)paramArrayList1.get(j);
      if (((Boolean)paramArrayList2.get(j)).booleanValue()) {
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
      FragmentTransition.startTransitions(this, paramArrayList1, paramArrayList2, paramInt1, paramInt2, false);
    }
    executeOps(paramArrayList1, paramArrayList2, paramInt1, paramInt2);
    if (bool)
    {
      localObject = new ArraySet();
      addAddedFragments((ArraySet)localObject);
      j = postponePostponableTransactions(paramArrayList1, paramArrayList2, paramInt1, paramInt2, (ArraySet)localObject);
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
          FragmentTransition.startTransitions(this, paramArrayList1, paramArrayList2, paramInt1, j, true);
          moveToState(this.mCurState, true);
          k = paramInt1;
        }
      }
      while (k < paramInt2)
      {
        localObject = (BackStackRecord)paramArrayList1.get(k);
        if ((((Boolean)paramArrayList2.get(k)).booleanValue()) && (((BackStackRecord)localObject).mIndex >= 0))
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
  
  private void executePostponedTransaction(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int i;
    int j;
    label12:
    FragmentManagerImpl.StartEnterTransitionListener localStartEnterTransitionListener;
    int k;
    if (this.mPostponedTransactions == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localStartEnterTransitionListener = (FragmentManagerImpl.StartEnterTransitionListener)this.mPostponedTransactions.get(j);
      if ((paramArrayList1 == null) || (FragmentManagerImpl.StartEnterTransitionListener.access$300(localStartEnterTransitionListener))) {
        break label101;
      }
      k = paramArrayList1.indexOf(FragmentManagerImpl.StartEnterTransitionListener.access$400(localStartEnterTransitionListener));
      if ((k == -1) || (!((Boolean)paramArrayList2.get(k)).booleanValue())) {
        break label101;
      }
      localStartEnterTransitionListener.cancelTransaction();
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = this.mPostponedTransactions.size();
      break;
      label101:
      int m;
      if (!localStartEnterTransitionListener.isReady())
      {
        m = j;
        k = i;
        if (paramArrayList1 != null)
        {
          m = j;
          k = i;
          if (!FragmentManagerImpl.StartEnterTransitionListener.access$400(localStartEnterTransitionListener).interactsWith(paramArrayList1, 0, paramArrayList1.size())) {}
        }
      }
      else
      {
        this.mPostponedTransactions.remove(j);
        m = j - 1;
        k = i - 1;
        if ((paramArrayList1 != null) && (!FragmentManagerImpl.StartEnterTransitionListener.access$300(localStartEnterTransitionListener)))
        {
          i = paramArrayList1.indexOf(FragmentManagerImpl.StartEnterTransitionListener.access$400(localStartEnterTransitionListener));
          if ((i != -1) && (((Boolean)paramArrayList2.get(i)).booleanValue()))
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
        ((FragmentManagerImpl.StartEnterTransitionListener)this.mPostponedTransactions.remove(0)).completeTransaction();
      }
    }
  }
  
  private boolean generateOpsForPendingActions(ArrayList paramArrayList1, ArrayList paramArrayList2)
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
        bool |= ((FragmentManagerImpl.OpGenerator)this.mPendingActions.get(i)).generateOps(paramArrayList1, paramArrayList2);
        i += 1;
      }
      this.mPendingActions.clear();
      this.mHost.getHandler().removeCallbacks(this.mExecCommit);
      return bool;
    }
    finally {}
  }
  
  private static Animation.AnimationListener getAnimationListener(Animation paramAnimation)
  {
    try
    {
      if (sAnimationListenerField == null)
      {
        sAnimationListenerField = Animation.class.getDeclaredField("mListener");
        sAnimationListenerField.setAccessible(true);
      }
      paramAnimation = (Animation.AnimationListener)sAnimationListenerField.get(paramAnimation);
      return paramAnimation;
    }
    catch (NoSuchFieldException paramAnimation)
    {
      Log.e("FragmentManager", "No field with the name mListener is found in Animation class", paramAnimation);
      return null;
    }
    catch (IllegalAccessException paramAnimation)
    {
      Log.e("FragmentManager", "Cannot access Animation's mListener field", paramAnimation);
    }
    return null;
  }
  
  static FragmentManagerImpl.AnimationOrAnimator makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(DECELERATE_CUBIC);
    paramContext.setDuration(220L);
    return new FragmentManagerImpl.AnimationOrAnimator(paramContext, null);
  }
  
  static FragmentManagerImpl.AnimationOrAnimator makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    return new FragmentManagerImpl.AnimationOrAnimator(paramContext, null);
  }
  
  private void makeRemovedFragmentsInvisible(ArraySet paramArraySet)
  {
    int j = paramArraySet.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramArraySet.valueAt(i);
      if (!localFragment.mAdded)
      {
        View localView = localFragment.getView();
        localFragment.mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  static boolean modifiesAlpha(Animator paramAnimator)
  {
    if (paramAnimator == null) {}
    for (;;)
    {
      return false;
      int i;
      if ((paramAnimator instanceof ValueAnimator))
      {
        paramAnimator = ((ValueAnimator)paramAnimator).getValues();
        i = 0;
        while (i < paramAnimator.length)
        {
          if ("alpha".equals(paramAnimator[i].getPropertyName())) {
            return true;
          }
          i += 1;
        }
      }
      else if ((paramAnimator instanceof AnimatorSet))
      {
        paramAnimator = ((AnimatorSet)paramAnimator).getChildAnimations();
        i = 0;
        while (i < paramAnimator.size())
        {
          if (modifiesAlpha((Animator)paramAnimator.get(i))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  static boolean modifiesAlpha(FragmentManagerImpl.AnimationOrAnimator paramAnimationOrAnimator)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramAnimationOrAnimator.animation instanceof AlphaAnimation))
    {
      bool1 = true;
      return bool1;
    }
    if ((paramAnimationOrAnimator.animation instanceof AnimationSet))
    {
      paramAnimationOrAnimator = ((AnimationSet)paramAnimationOrAnimator.animation).getAnimations();
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= paramAnimationOrAnimator.size()) {
          break;
        }
        if ((paramAnimationOrAnimator.get(i) instanceof AlphaAnimation)) {
          return true;
        }
        i += 1;
      }
    }
    return modifiesAlpha(paramAnimationOrAnimator.animator);
  }
  
  private boolean popBackStackImmediate(String paramString, int paramInt1, int paramInt2)
  {
    execPendingActions();
    ensureExecReady(true);
    if ((this.mPrimaryNav != null) && (paramInt1 < 0) && (paramString == null))
    {
      FragmentManager localFragmentManager = this.mPrimaryNav.peekChildFragmentManager();
      if ((localFragmentManager != null) && (localFragmentManager.popBackStackImmediate())) {
        return true;
      }
    }
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
      doPendingDeferredStart();
      return bool;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  private int postponePostponableTransactions(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, ArraySet paramArraySet)
  {
    int j = paramInt2 - 1;
    int i = paramInt2;
    BackStackRecord localBackStackRecord;
    int k;
    if (j >= paramInt1)
    {
      localBackStackRecord = (BackStackRecord)paramArrayList1.get(j);
      boolean bool = ((Boolean)paramArrayList2.get(j)).booleanValue();
      if ((localBackStackRecord.isPostponed()) && (!localBackStackRecord.interactsWith(paramArrayList1, j + 1, paramInt2)))
      {
        k = 1;
        label67:
        if (k == 0) {
          break label191;
        }
        if (this.mPostponedTransactions == null) {
          this.mPostponedTransactions = new ArrayList();
        }
        FragmentManagerImpl.StartEnterTransitionListener localStartEnterTransitionListener = new FragmentManagerImpl.StartEnterTransitionListener(localBackStackRecord, bool);
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
          paramArrayList1.remove(j);
          paramArrayList1.add(i, localBackStackRecord);
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
  
  private void removeRedundantOperationsAndExecute(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int i = 0;
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty())) {
      return;
    }
    if ((paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
      throw new IllegalStateException("Internal error with the back stack records");
    }
    executePostponedTransaction(paramArrayList1, paramArrayList2);
    int m = paramArrayList1.size();
    int j = 0;
    label55:
    if (i < m)
    {
      if (((BackStackRecord)paramArrayList1.get(i)).mReorderingAllowed) {
        break label220;
      }
      if (j != i) {
        executeOpsTogether(paramArrayList1, paramArrayList2, j, i);
      }
      int k = i + 1;
      j = k;
      if (((Boolean)paramArrayList2.get(i)).booleanValue()) {
        for (;;)
        {
          j = k;
          if (k >= m) {
            break;
          }
          j = k;
          if (!((Boolean)paramArrayList2.get(k)).booleanValue()) {
            break;
          }
          j = k;
          if (((BackStackRecord)paramArrayList1.get(k)).mReorderingAllowed) {
            break;
          }
          k += 1;
        }
      }
      executeOpsTogether(paramArrayList1, paramArrayList2, i, j);
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
      executeOpsTogether(paramArrayList1, paramArrayList2, j, m);
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
  
  private void scheduleCommit()
  {
    int j = 1;
    label44:
    label73:
    label92:
    label97:
    label100:
    for (;;)
    {
      int i;
      try
      {
        if ((this.mPostponedTransactions == null) || (this.mPostponedTransactions.isEmpty())) {
          break label92;
        }
        i = 1;
        if ((this.mPendingActions == null) || (this.mPendingActions.size() != 1)) {
          break label97;
        }
      }
      finally {}
      this.mHost.getHandler().removeCallbacks(this.mExecCommit);
      this.mHost.getHandler().post(this.mExecCommit);
      return;
      for (;;)
      {
        if (i != 0) {
          break label100;
        }
        if (j == 0) {
          break label73;
        }
        break label44;
        i = 0;
        break;
        j = 0;
      }
    }
  }
  
  private static void setHWLayerAnimListenerIfAlpha(View paramView, FragmentManagerImpl.AnimationOrAnimator paramAnimationOrAnimator)
  {
    if ((paramView == null) || (paramAnimationOrAnimator == null)) {}
    while (!shouldRunOnHWLayer(paramView, paramAnimationOrAnimator)) {
      return;
    }
    if (paramAnimationOrAnimator.animator != null)
    {
      paramAnimationOrAnimator.animator.addListener(new FragmentManagerImpl.AnimatorOnHWLayerIfNeededListener(paramView));
      return;
    }
    Animation.AnimationListener localAnimationListener = getAnimationListener(paramAnimationOrAnimator.animation);
    paramView.setLayerType(2, null);
    paramAnimationOrAnimator.animation.setAnimationListener(new FragmentManagerImpl.AnimateOnHWLayerIfNeededListener(paramView, localAnimationListener));
  }
  
  private static void setRetaining(FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    if (paramFragmentManagerNonConfig == null) {}
    for (;;)
    {
      return;
      Object localObject = paramFragmentManagerNonConfig.getFragments();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Fragment)((Iterator)localObject).next()).mRetaining = true;
        }
      }
      paramFragmentManagerNonConfig = paramFragmentManagerNonConfig.getChildNonConfigs();
      if (paramFragmentManagerNonConfig != null)
      {
        paramFragmentManagerNonConfig = paramFragmentManagerNonConfig.iterator();
        while (paramFragmentManagerNonConfig.hasNext()) {
          setRetaining((FragmentManagerNonConfig)paramFragmentManagerNonConfig.next());
        }
      }
    }
  }
  
  static boolean shouldRunOnHWLayer(View paramView, FragmentManagerImpl.AnimationOrAnimator paramAnimationOrAnimator)
  {
    if ((paramView == null) || (paramAnimationOrAnimator == null)) {}
    while ((Build.VERSION.SDK_INT < 19) || (paramView.getLayerType() != 0) || (!ViewCompat.hasOverlappingRendering(paramView)) || (!modifiesAlpha(paramAnimationOrAnimator))) {
      return false;
    }
    return true;
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
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
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
  
  public void attachController(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (this.mHost != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mHost = paramFragmentHostCallback;
    this.mContainer = paramFragmentContainer;
    this.mParent = paramFragment;
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
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      return;
    }
  }
  
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  void completeShowHideFragment(Fragment paramFragment)
  {
    boolean bool;
    FragmentManagerImpl.AnimationOrAnimator localAnimationOrAnimator;
    if (paramFragment.mView != null)
    {
      i = paramFragment.getNextTransition();
      if (paramFragment.mHidden) {
        break label135;
      }
      bool = true;
      localAnimationOrAnimator = loadAnimation(paramFragment, i, bool, paramFragment.getNextTransitionStyle());
      if ((localAnimationOrAnimator == null) || (localAnimationOrAnimator.animator == null)) {
        break label194;
      }
      localAnimationOrAnimator.animator.setTarget(paramFragment.mView);
      if (!paramFragment.mHidden) {
        break label183;
      }
      if (!paramFragment.isHideReplaced()) {
        break label140;
      }
      paramFragment.setHideReplaced(false);
    }
    for (;;)
    {
      setHWLayerAnimListenerIfAlpha(paramFragment.mView, localAnimationOrAnimator);
      localAnimationOrAnimator.animator.start();
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mHiddenChanged = false;
      paramFragment.onHiddenChanged(paramFragment.mHidden);
      return;
      label135:
      bool = false;
      break;
      label140:
      ViewGroup localViewGroup = paramFragment.mContainer;
      View localView = paramFragment.mView;
      localViewGroup.startViewTransition(localView);
      localAnimationOrAnimator.animator.addListener(new FragmentManagerImpl.4(this, localViewGroup, localView, paramFragment));
      continue;
      label183:
      paramFragment.mView.setVisibility(0);
    }
    label194:
    if (localAnimationOrAnimator != null)
    {
      setHWLayerAnimListenerIfAlpha(paramFragment.mView, localAnimationOrAnimator);
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
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
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
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
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
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
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
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
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
  
  void dispatchOnFragmentActivityCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentActivityCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentAttached(this, paramFragment, paramContext);
      }
    }
  }
  
  void dispatchOnFragmentCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentDestroyed(Fragment paramFragment, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentDestroyed(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentDetached(Fragment paramFragment, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentDetached(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentPaused(Fragment paramFragment, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentPaused(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentPreAttached(Fragment paramFragment, Context paramContext, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentPreAttached(this, paramFragment, paramContext);
      }
    }
  }
  
  void dispatchOnFragmentPreCreated(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentPreCreated(this, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentResumed(Fragment paramFragment, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentResumed(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentSaveInstanceState(Fragment paramFragment, Bundle paramBundle, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentSaveInstanceState(this, paramFragment, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentStarted(Fragment paramFragment, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentStarted(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentStopped(Fragment paramFragment, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentStopped(this, paramFragment);
      }
    }
  }
  
  void dispatchOnFragmentViewCreated(Fragment paramFragment, View paramView, Bundle paramBundle, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentViewCreated(this, paramFragment, paramView, paramBundle);
      }
    }
  }
  
  void dispatchOnFragmentViewDestroyed(Fragment paramFragment, boolean paramBoolean)
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
      Pair localPair = (Pair)((Iterator)localObject).next();
      if ((!paramBoolean) || (((Boolean)localPair.second).booleanValue())) {
        ((FragmentManager.FragmentLifecycleCallbacks)localPair.first).onFragmentViewDestroyed(this, paramFragment);
      }
    }
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
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
  
  public void dispatchOptionsMenuClosed(Menu paramMenu)
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
    dispatchStateChange(4);
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
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
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
  
  public void dispatchReallyStop()
  {
    dispatchStateChange(2);
  }
  
  public void dispatchResume()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(5);
  }
  
  public void dispatchStart()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(4);
  }
  
  public void dispatchStop()
  {
    this.mStopped = true;
    dispatchStateChange(3);
  }
  
  void doPendingDeferredStart()
  {
    if (this.mHavePendingDeferredStart)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    int i;
    Object localObject;
    if (this.mActive != null)
    {
      k = this.mActive.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < k)
        {
          localObject = (Fragment)this.mActive.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localObject);
          if (localObject != null) {
            ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    int k = this.mAdded.size();
    if (k > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i = 0;
      while (i < k)
      {
        localObject = (Fragment)this.mAdded.get(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(((Fragment)localObject).toString());
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
          localObject = (Fragment)this.mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
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
          localObject = (BackStackRecord)this.mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((BackStackRecord)localObject).toString());
          ((BackStackRecord)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
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
            paramFileDescriptor = (FragmentManagerImpl.OpGenerator)this.mPendingActions.get(i);
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
    if (this.mNoTransactionsBecause != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.mNoTransactionsBecause);
    }
  }
  
  public void enqueueAction(FragmentManagerImpl.OpGenerator paramOpGenerator, boolean paramBoolean)
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
      paramFragment.mView = paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
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
    burpActive();
    return bool;
  }
  
  public void execSingleAction(FragmentManagerImpl.OpGenerator paramOpGenerator, boolean paramBoolean)
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
  
  public Fragment findFragmentById(int paramInt)
  {
    int i = this.mAdded.size() - 1;
    Object localObject;
    while (i >= 0)
    {
      localObject = (Fragment)this.mAdded.get(i);
      if ((localObject != null) && (((Fragment)localObject).mFragmentId == paramInt)) {
        return localObject;
      }
      i -= 1;
    }
    if (this.mActive != null)
    {
      i = this.mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label105;
        }
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (localFragment.mFragmentId == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label105:
    return null;
  }
  
  public Fragment findFragmentByTag(String paramString)
  {
    int i;
    Object localObject;
    if (paramString != null)
    {
      i = this.mAdded.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.mAdded.get(i);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).mTag))) {
          return localObject;
        }
        i -= 1;
      }
    }
    if ((this.mActive != null) && (paramString != null))
    {
      i = this.mActive.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label119;
        }
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(localFragment.mTag)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label119:
    return null;
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    if ((this.mActive != null) && (paramString != null))
    {
      int i = this.mActive.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment != null) {
            return localFragment;
          }
        }
        i -= 1;
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
    if (this.mActive == null) {
      return 0;
    }
    return this.mActive.size();
  }
  
  List getActiveFragments()
  {
    Object localObject;
    if (this.mActive == null)
    {
      localObject = null;
      return localObject;
    }
    int j = this.mActive.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(this.mActive.valueAt(i));
      i += 1;
    }
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
  
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      localFragment = (Fragment)this.mActive.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  public List getFragments()
  {
    if (this.mAdded.isEmpty()) {
      return Collections.EMPTY_LIST;
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
  
  public Fragment getPrimaryNavigationFragment()
  {
    return this.mPrimaryNav;
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
  
  boolean isStateAtLeast(int paramInt)
  {
    return this.mCurState >= paramInt;
  }
  
  public boolean isStateSaved()
  {
    return (this.mStateSaved) || (this.mStopped);
  }
  
  FragmentManagerImpl.AnimationOrAnimator loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int j = paramFragment.getNextAnim();
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, j);
    if (localAnimation != null) {
      return new FragmentManagerImpl.AnimationOrAnimator(localAnimation, null);
    }
    paramFragment = paramFragment.onCreateAnimator(paramInt1, paramBoolean, j);
    if (paramFragment != null) {
      return new FragmentManagerImpl.AnimationOrAnimator(paramFragment, null);
    }
    boolean bool;
    if (j != 0)
    {
      bool = "anim".equals(this.mHost.getContext().getResources().getResourceTypeName(j));
      if (!bool) {
        break label387;
      }
    }
    for (;;)
    {
      try
      {
        paramFragment = AnimationUtils.loadAnimation(this.mHost.getContext(), j);
        if (paramFragment != null)
        {
          paramFragment = new FragmentManagerImpl.AnimationOrAnimator(paramFragment, null);
          return paramFragment;
        }
      }
      catch (Resources.NotFoundException paramFragment)
      {
        throw paramFragment;
        i = 1;
        if (i == 0)
        {
          try
          {
            paramFragment = AnimatorInflater.loadAnimator(this.mHost.getContext(), j);
            if (paramFragment == null) {
              break label199;
            }
            paramFragment = new FragmentManagerImpl.AnimationOrAnimator(paramFragment, null);
            return paramFragment;
          }
          catch (RuntimeException paramFragment)
          {
            if (!bool) {
              continue;
            }
          }
          throw paramFragment;
        }
      }
      catch (RuntimeException paramFragment)
      {
        i = 0;
        continue;
        paramFragment = AnimationUtils.loadAnimation(this.mHost.getContext(), j);
        if (paramFragment != null) {
          return new FragmentManagerImpl.AnimationOrAnimator(paramFragment, null);
        }
      }
      label199:
      if (paramInt1 == 0) {
        return null;
      }
      paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
      if (paramInt1 < 0) {
        return null;
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
        if (paramInt1 == 0) {
          return null;
        }
        break;
      case 1: 
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.125F, 1.0F, 0.0F, 1.0F);
      case 2: 
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.0F, 0.975F, 1.0F, 0.0F);
      case 3: 
        return makeOpenCloseAnimation(this.mHost.getContext(), 0.975F, 1.0F, 0.0F, 1.0F);
      case 4: 
        return makeOpenCloseAnimation(this.mHost.getContext(), 1.0F, 1.075F, 1.0F, 0.0F);
      case 5: 
        return makeFadeAnimation(this.mHost.getContext(), 0.0F, 1.0F);
      case 6: 
        return makeFadeAnimation(this.mHost.getContext(), 1.0F, 0.0F);
      }
      return null;
      label387:
      int i = 0;
    }
  }
  
  void makeActive(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {}
    do
    {
      return;
      int i = this.mNextFragmentIndex;
      this.mNextFragmentIndex = (i + 1);
      paramFragment.setIndex(i, this.mParent);
      if (this.mActive == null) {
        this.mActive = new SparseArray();
      }
      this.mActive.put(paramFragment.mIndex, paramFragment);
    } while (!DEBUG);
    Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
  }
  
  void makeInactive(Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      return;
    }
    if (DEBUG) {
      Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
    }
    this.mActive.put(paramFragment.mIndex, null);
    paramFragment.initState();
  }
  
  void moveFragmentToExpectedState(Fragment paramFragment)
  {
    if (paramFragment == null) {}
    label234:
    label255:
    for (;;)
    {
      return;
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
              setHWLayerAnimListenerIfAlpha(paramFragment.mView, (FragmentManagerImpl.AnimationOrAnimator)localObject);
              if (((FragmentManagerImpl.AnimationOrAnimator)localObject).animation == null) {
                break label234;
              }
              paramFragment.mView.startAnimation(((FragmentManagerImpl.AnimationOrAnimator)localObject).animation);
            }
          }
        }
      }
      for (;;)
      {
        if (!paramFragment.mHiddenChanged) {
          break label255;
        }
        completeShowHideFragment(paramFragment);
        return;
        i = Math.min(j, 0);
        break;
        ((FragmentManagerImpl.AnimationOrAnimator)localObject).animator.setTarget(paramFragment.mView);
        ((FragmentManagerImpl.AnimationOrAnimator)localObject).animator.start();
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
      do
      {
        return;
        this.mCurState = paramInt;
      } while (this.mActive == null);
      int i = this.mAdded.size();
      paramInt = 0;
      while (paramInt < i)
      {
        moveFragmentToExpectedState((Fragment)this.mAdded.get(paramInt));
        paramInt += 1;
      }
      i = this.mActive.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Fragment localFragment = (Fragment)this.mActive.valueAt(paramInt);
        if ((localFragment != null) && ((localFragment.mRemoving) || (localFragment.mDetached)) && (!localFragment.mIsNewlyAdded)) {
          moveFragmentToExpectedState(localFragment);
        }
        paramInt += 1;
      }
      startPendingDeferredFragments();
    } while ((!this.mNeedMenuInvalidate) || (this.mHost == null) || (this.mCurState != 5));
    this.mHost.onSupportInvalidateOptionsMenu();
    this.mNeedMenuInvalidate = false;
  }
  
  void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = true;
    int j;
    if (paramFragment.mAdded)
    {
      j = paramInt1;
      if (!paramFragment.mDetached) {}
    }
    else
    {
      j = paramInt1;
      if (paramInt1 > 1) {
        j = 1;
      }
    }
    int i = j;
    if (paramFragment.mRemoving)
    {
      i = j;
      if (j > paramFragment.mState)
      {
        if ((paramFragment.mState != 0) || (!paramFragment.isInBackStack())) {
          break label127;
        }
        i = 1;
      }
    }
    paramInt1 = i;
    if (paramFragment.mDeferStart)
    {
      paramInt1 = i;
      if (paramFragment.mState < 4)
      {
        paramInt1 = i;
        if (i > 3) {
          paramInt1 = 3;
        }
      }
    }
    label127:
    Object localObject1;
    label571:
    label600:
    label623:
    ViewGroup localViewGroup;
    if (paramFragment.mState <= paramInt1)
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {}
      do
      {
        return;
        i = paramFragment.mState;
        break;
        if ((paramFragment.getAnimatingAway() != null) || (paramFragment.getAnimator() != null))
        {
          paramFragment.setAnimatingAway(null);
          paramFragment.setAnimator(null);
          moveToState(paramFragment, paramFragment.getStateAfterAnimating(), 0, 0, true);
        }
        paramInt3 = paramInt1;
        i = paramInt1;
        j = paramInt1;
        paramInt2 = paramInt1;
        switch (paramFragment.mState)
        {
        default: 
          i = paramInt1;
        }
      } while (paramFragment.mState == i);
      Log.w("FragmentManager", "moveToState: Fragment state for " + paramFragment + " not updated inline; " + "expected state " + i + " found " + paramFragment.mState);
      paramFragment.mState = i;
      return;
      paramInt3 = paramInt1;
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
          paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
          if (paramFragment.mTarget != null) {
            paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
          }
          if (paramFragment.mSavedUserVisibleHint == null) {
            break label571;
          }
          paramFragment.mUserVisibleHint = paramFragment.mSavedUserVisibleHint.booleanValue();
          paramFragment.mSavedUserVisibleHint = null;
          paramInt3 = paramInt1;
          if (!paramFragment.mUserVisibleHint)
          {
            paramFragment.mDeferStart = true;
            paramInt3 = paramInt1;
            if (paramInt1 > 3) {
              paramInt3 = 3;
            }
          }
        }
        paramFragment.mHost = this.mHost;
        paramFragment.mParentFragment = this.mParent;
        if (this.mParent != null) {}
        for (localObject1 = this.mParent.mChildFragmentManager;; localObject1 = this.mHost.getFragmentManagerImpl())
        {
          paramFragment.mFragmentManager = ((FragmentManagerImpl)localObject1);
          if (paramFragment.mTarget == null) {
            break label623;
          }
          if (this.mActive.get(paramFragment.mTarget.mIndex) == paramFragment.mTarget) {
            break label600;
          }
          throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.mTarget + " that does not belong to this FragmentManager!");
          paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
          break;
        }
        if (paramFragment.mTarget.mState < 1) {
          moveToState(paramFragment.mTarget, 1, 0, 0, true);
        }
        dispatchOnFragmentPreAttached(paramFragment, this.mHost.getContext(), false);
        paramFragment.mCalled = false;
        paramFragment.onAttach(this.mHost.getContext());
        if (!paramFragment.mCalled) {
          throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
        }
        if (paramFragment.mParentFragment == null)
        {
          this.mHost.onAttachFragment(paramFragment);
          label708:
          dispatchOnFragmentAttached(paramFragment, this.mHost.getContext(), false);
          if (paramFragment.mIsCreated) {
            break label1304;
          }
          dispatchOnFragmentPreCreated(paramFragment, paramFragment.mSavedFragmentState, false);
          paramFragment.performCreate(paramFragment.mSavedFragmentState);
          dispatchOnFragmentCreated(paramFragment, paramFragment.mSavedFragmentState, false);
          paramFragment.mRetaining = false;
        }
      }
      else
      {
        ensureInflatedFragmentView(paramFragment);
        i = paramInt3;
        if (paramInt3 > 1)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!paramFragment.mFromLayout)
          {
            if (paramFragment.mContainerId == 0) {
              break label1947;
            }
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
    for (;;)
    {
      label1304:
      Object localObject2;
      try
      {
        localObject1 = paramFragment.getResources().getResourceName(paramFragment.mContainerId);
        throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + (String)localObject1 + ") for fragment " + paramFragment));
        localObject1 = localViewGroup;
        paramFragment.mContainer = ((ViewGroup)localObject1);
        paramFragment.mView = paramFragment.performCreateView(paramFragment.performGetLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject1, paramFragment.mSavedFragmentState);
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
            paramBoolean = bool;
            paramFragment.mIsNewlyAdded = paramBoolean;
            paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
            dispatchOnFragmentActivityCreated(paramFragment, paramFragment.mSavedFragmentState, false);
            if (paramFragment.mView != null) {
              paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
            }
            paramFragment.mSavedFragmentState = null;
            i = paramInt3;
            j = i;
            if (i > 2)
            {
              paramFragment.mState = 3;
              j = i;
            }
            paramInt2 = j;
            if (j > 3)
            {
              if (DEBUG) {
                Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
              }
              paramFragment.performStart();
              dispatchOnFragmentStarted(paramFragment, false);
              paramInt2 = j;
            }
            i = paramInt2;
            if (paramInt2 <= 4) {
              break;
            }
            if (DEBUG) {
              Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
            }
            paramFragment.performResume();
            dispatchOnFragmentResumed(paramFragment, false);
            paramFragment.mSavedFragmentState = null;
            paramFragment.mSavedViewState = null;
            i = paramInt2;
            break;
            paramFragment.mParentFragment.onAttachFragment(paramFragment);
            break label708;
            paramFragment.restoreChildFragmentState(paramFragment.mSavedFragmentState);
            paramFragment.mState = 1;
          }
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        localObject2 = "unknown";
        continue;
        paramBoolean = false;
        continue;
        paramFragment.mInnerView = null;
        continue;
      }
      i = paramInt1;
      if (paramFragment.mState <= paramInt1) {
        break;
      }
      switch (paramFragment.mState)
      {
      default: 
        i = paramInt1;
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        label1398:
        do
        {
          i = paramInt1;
          if (paramInt1 >= 1) {
            break;
          }
          if (this.mDestroyed)
          {
            if (paramFragment.getAnimatingAway() == null) {
              break label1801;
            }
            localObject2 = paramFragment.getAnimatingAway();
            paramFragment.setAnimatingAway(null);
            ((View)localObject2).clearAnimation();
          }
          if ((paramFragment.getAnimatingAway() == null) && (paramFragment.getAnimator() == null)) {
            break label1827;
          }
          paramFragment.setStateAfterAnimating(paramInt1);
          i = 1;
          break;
          if (paramInt1 < 5)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
            }
            paramFragment.performPause();
            dispatchOnFragmentPaused(paramFragment, false);
          }
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
            }
            paramFragment.performStop();
            dispatchOnFragmentStopped(paramFragment, false);
          }
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
            }
            paramFragment.performReallyStop();
          }
        } while (paramInt1 >= 2);
        label1436:
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
          if ((this.mCurState <= 0) || (this.mDestroyed) || (paramFragment.mView.getVisibility() != 0) || (paramFragment.mPostponedAlpha < 0.0F)) {
            break label1941;
          }
        }
        label1801:
        label1941:
        for (localObject2 = loadAnimation(paramFragment, paramInt2, false, paramInt3);; localObject2 = null)
        {
          paramFragment.mPostponedAlpha = 0.0F;
          if (localObject2 != null) {
            animateRemoveFragment(paramFragment, (FragmentManagerImpl.AnimationOrAnimator)localObject2, paramInt1);
          }
          paramFragment.mContainer.removeView(paramFragment.mView);
          paramFragment.mContainer = null;
          paramFragment.mView = null;
          paramFragment.mInnerView = null;
          paramFragment.mInLayout = false;
          break label1398;
          if (paramFragment.getAnimator() == null) {
            break label1436;
          }
          localObject2 = paramFragment.getAnimator();
          paramFragment.setAnimator(null);
          ((Animator)localObject2).cancel();
          break label1436;
          label1827:
          if (DEBUG) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          if (!paramFragment.mRetaining)
          {
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
            if (paramFragment.mRetaining) {
              break label1920;
            }
            makeInactive(paramFragment);
            i = paramInt1;
            break;
            paramFragment.mState = 0;
          }
          paramFragment.mHost = null;
          paramFragment.mParentFragment = null;
          paramFragment.mFragmentManager = null;
          i = paramInt1;
          break;
        }
        label1920:
        label1947:
        localObject2 = null;
      }
    }
  }
  
  public void noteStateNotSaved()
  {
    this.mSavedNonConfig = null;
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
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentManagerImpl.FragmentTag.Fragment);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int k = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if (!Fragment.isSupportFragmentClass(this.mHost.getContext(), str1)) {
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
          break label433;
        }
        paramView = this.mContainer.instantiate(paramContext, str1, null);
        paramView.mFromLayout = true;
        if (k == 0) {
          break label426;
        }
        j = k;
        label296:
        paramView.mFragmentId = j;
        paramView.mContainerId = i;
        paramView.mTag = str2;
        paramView.mInLayout = true;
        paramView.mFragmentManager = this;
        paramView.mHost = this.mHost;
        paramView.onInflate(this.mHost.getContext(), paramAttributeSet, paramView.mSavedFragmentState);
        addFragment(paramView, true);
        label355:
        if ((this.mCurState >= 1) || (!paramView.mFromLayout)) {
          break label560;
        }
        moveToState(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (paramView.mView != null) {
          break label568;
        }
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        paramString = null;
        break;
        label426:
        j = i;
        break label296;
        label433:
        if (paramString.mInLayout) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
        }
        paramString.mInLayout = true;
        paramString.mHost = this.mHost;
        if (!paramString.mRetaining) {
          paramString.onInflate(this.mHost.getContext(), paramAttributeSet, paramString.mSavedFragmentState);
        }
        paramView = paramString;
        break label355;
        label560:
        moveToState(paramView);
      }
      label568:
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
    enqueueAction(new FragmentManagerImpl.PopBackStackState(this, null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    enqueueAction(new FragmentManagerImpl.PopBackStackState(this, null, paramInt1, paramInt2), false);
  }
  
  public void popBackStack(String paramString, int paramInt)
  {
    enqueueAction(new FragmentManagerImpl.PopBackStackState(this, paramString, -1, paramInt), false);
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
  
  public boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString, int paramInt1, int paramInt2)
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
      paramArrayList1.add(this.mBackStack.remove(paramInt1));
      paramArrayList2.add(Boolean.valueOf(true));
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
        paramArrayList1.add(this.mBackStack.remove(paramInt1));
        paramArrayList2.add(Boolean.valueOf(true));
        paramInt1 -= 1;
      }
    }
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean)
  {
    this.mLifecycleCallbacks.add(new Pair(paramFragmentLifecycleCallbacks, Boolean.valueOf(paramBoolean)));
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
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
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
  
  void restoreAllState(Parcelable arg1, FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    if (??? == null) {}
    FragmentManagerState localFragmentManagerState;
    do
    {
      return;
      localFragmentManagerState = (FragmentManagerState)???;
    } while (localFragmentManagerState.mActive == null);
    Object localObject1;
    List localList;
    int i;
    int j;
    Object localObject2;
    FragmentState localFragmentState;
    if (paramFragmentManagerNonConfig != null)
    {
      localObject1 = paramFragmentManagerNonConfig.getFragments();
      localList = paramFragmentManagerNonConfig.getChildNonConfigs();
      ??? = paramFragmentManagerNonConfig.getViewModelStores();
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        j = 0;
      }
      for (;;)
      {
        if (j >= i) {
          break label309;
        }
        localObject2 = (Fragment)((List)localObject1).get(j);
        if (DEBUG) {
          Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localObject2);
        }
        int k = 0;
        for (;;)
        {
          if ((k < localFragmentManagerState.mActive.length) && (localFragmentManagerState.mActive[k].mIndex != ((Fragment)localObject2).mIndex))
          {
            k += 1;
            continue;
            i = 0;
            break;
          }
        }
        if (k == localFragmentManagerState.mActive.length) {
          throwException(new IllegalStateException("Could not find active fragment with index " + ((Fragment)localObject2).mIndex));
        }
        localFragmentState = localFragmentManagerState.mActive[k];
        localFragmentState.mInstance = ((Fragment)localObject2);
        ((Fragment)localObject2).mSavedViewState = null;
        ((Fragment)localObject2).mBackStackNesting = 0;
        ((Fragment)localObject2).mInLayout = false;
        ((Fragment)localObject2).mAdded = false;
        ((Fragment)localObject2).mTarget = null;
        if (localFragmentState.mSavedFragmentState != null)
        {
          localFragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
          ((Fragment)localObject2).mSavedViewState = localFragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
          ((Fragment)localObject2).mSavedFragmentState = localFragmentState.mSavedFragmentState;
        }
        j += 1;
      }
    }
    for (;;)
    {
      label309:
      this.mActive = new SparseArray(localFragmentManagerState.mActive.length);
      i = 0;
      if (i < localFragmentManagerState.mActive.length)
      {
        localFragmentState = localFragmentManagerState.mActive[i];
        if (localFragmentState != null) {
          if ((localList == null) || (i >= localList.size())) {
            break label1025;
          }
        }
      }
      label1025:
      for (localObject1 = (FragmentManagerNonConfig)localList.get(i);; localObject1 = null)
      {
        if ((??? != null) && (i < ???.size())) {}
        for (localObject2 = (ViewModelStore)???.get(i);; localObject2 = null)
        {
          localObject1 = localFragmentState.instantiate(this.mHost, this.mContainer, this.mParent, (FragmentManagerNonConfig)localObject1, (ViewModelStore)localObject2);
          if (DEBUG) {
            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + localObject1);
          }
          this.mActive.put(((Fragment)localObject1).mIndex, localObject1);
          localFragmentState.mInstance = null;
          i += 1;
          break;
          if (paramFragmentManagerNonConfig != null)
          {
            ??? = paramFragmentManagerNonConfig.getFragments();
            if (??? != null) {}
            for (i = ???.size();; i = 0)
            {
              j = 0;
              while (j < i)
              {
                paramFragmentManagerNonConfig = (Fragment)???.get(j);
                if (paramFragmentManagerNonConfig.mTargetIndex >= 0)
                {
                  paramFragmentManagerNonConfig.mTarget = ((Fragment)this.mActive.get(paramFragmentManagerNonConfig.mTargetIndex));
                  if (paramFragmentManagerNonConfig.mTarget == null) {
                    Log.w("FragmentManager", "Re-attaching retained fragment " + paramFragmentManagerNonConfig + " target no longer exists: " + paramFragmentManagerNonConfig.mTargetIndex);
                  }
                }
                j += 1;
              }
            }
          }
          this.mAdded.clear();
          if (localFragmentManagerState.mAdded != null)
          {
            i = 0;
            while (i < localFragmentManagerState.mAdded.length)
            {
              paramFragmentManagerNonConfig = (Fragment)this.mActive.get(localFragmentManagerState.mAdded[i]);
              if (paramFragmentManagerNonConfig == null) {
                throwException(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.mAdded[i]));
              }
              paramFragmentManagerNonConfig.mAdded = true;
              if (DEBUG) {
                Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + paramFragmentManagerNonConfig);
              }
              if (this.mAdded.contains(paramFragmentManagerNonConfig)) {
                throw new IllegalStateException("Already added!");
              }
              synchronized (this.mAdded)
              {
                this.mAdded.add(paramFragmentManagerNonConfig);
                i += 1;
              }
            }
          }
          if (localFragmentManagerState.mBackStack != null)
          {
            this.mBackStack = new ArrayList(localFragmentManagerState.mBackStack.length);
            i = 0;
            while (i < localFragmentManagerState.mBackStack.length)
            {
              ??? = localFragmentManagerState.mBackStack[i].instantiate(this);
              if (DEBUG)
              {
                Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + ???.mIndex + "): " + ???);
                paramFragmentManagerNonConfig = new PrintWriter(new LogWriter("FragmentManager"));
                ???.dump("  ", paramFragmentManagerNonConfig, false);
                paramFragmentManagerNonConfig.close();
              }
              this.mBackStack.add(???);
              if (???.mIndex >= 0) {
                setBackStackIndex(???.mIndex, ???);
              }
              i += 1;
            }
          }
          this.mBackStack = null;
          if (localFragmentManagerState.mPrimaryNavActiveIndex >= 0) {
            this.mPrimaryNav = ((Fragment)this.mActive.get(localFragmentManagerState.mPrimaryNavActiveIndex));
          }
          this.mNextFragmentIndex = localFragmentManagerState.mNextFragmentIndex;
          return;
        }
      }
      ??? = null;
      localList = null;
    }
  }
  
  FragmentManagerNonConfig retainNonConfig()
  {
    setRetaining(this.mSavedNonConfig);
    return this.mSavedNonConfig;
  }
  
  Parcelable saveAllState()
  {
    Object localObject3 = null;
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions();
    this.mStateSaved = true;
    this.mSavedNonConfig = null;
    if ((this.mActive == null) || (this.mActive.size() <= 0)) {
      return null;
    }
    int k = this.mActive.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[k];
    int j = 0;
    int i = 0;
    label63:
    Object localObject1;
    Object localObject2;
    if (j < k)
    {
      localObject1 = (Fragment)this.mActive.valueAt(j);
      if (localObject1 == null) {
        break label748;
      }
      if (((Fragment)localObject1).mIndex < 0) {
        throwException(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).mIndex));
      }
      localObject2 = new FragmentState((Fragment)localObject1);
      arrayOfFragmentState[j] = localObject2;
      if ((((Fragment)localObject1).mState > 0) && (((FragmentState)localObject2).mSavedFragmentState == null))
      {
        ((FragmentState)localObject2).mSavedFragmentState = saveFragmentBasicState((Fragment)localObject1);
        if (((Fragment)localObject1).mTarget != null)
        {
          if (((Fragment)localObject1).mTarget.mIndex < 0) {
            throwException(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).mTarget));
          }
          if (((FragmentState)localObject2).mSavedFragmentState == null) {
            ((FragmentState)localObject2).mSavedFragmentState = new Bundle();
          }
          putFragment(((FragmentState)localObject2).mSavedFragmentState, "android:target_state", ((Fragment)localObject1).mTarget);
          if (((Fragment)localObject1).mTargetRequestCode != 0) {
            ((FragmentState)localObject2).mSavedFragmentState.putInt("android:target_req_state", ((Fragment)localObject1).mTargetRequestCode);
          }
        }
        label308:
        if (DEBUG) {
          Log.v("FragmentManager", "Saved state of " + localObject1 + ": " + ((FragmentState)localObject2).mSavedFragmentState);
        }
        i = 1;
      }
    }
    label748:
    for (;;)
    {
      j += 1;
      break label63;
      ((FragmentState)localObject2).mSavedFragmentState = ((Fragment)localObject1).mSavedFragmentState;
      break label308;
      if (i == 0)
      {
        if (!DEBUG) {
          break;
        }
        Log.v("FragmentManager", "saveAllState: no fragments!");
        return null;
      }
      j = this.mAdded.size();
      if (j > 0)
      {
        localObject2 = new int[j];
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject2[i] = ((Fragment)this.mAdded.get(i)).mIndex;
          if (localObject2[i] < 0) {
            throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i) + " has cleared index: " + localObject2[i]));
          }
          if (DEBUG) {
            Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + this.mAdded.get(i));
          }
          i += 1;
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (this.mBackStack != null)
      {
        j = this.mBackStack.size();
        localObject2 = localObject3;
        if (j > 0)
        {
          localObject3 = new BackStackState[j];
          i = 0;
          for (;;)
          {
            localObject2 = localObject3;
            if (i >= j) {
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
      ((FragmentManagerState)localObject3).mActive = arrayOfFragmentState;
      ((FragmentManagerState)localObject3).mAdded = ((int[])localObject1);
      ((FragmentManagerState)localObject3).mBackStack = ((BackStackState[])localObject2);
      if (this.mPrimaryNav != null) {
        ((FragmentManagerState)localObject3).mPrimaryNavActiveIndex = this.mPrimaryNav.mIndex;
      }
      ((FragmentManagerState)localObject3).mNextFragmentIndex = this.mNextFragmentIndex;
      saveNonConfig();
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
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (paramFragment.mIndex < 0) {
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
  
  void saveNonConfig()
  {
    if (this.mActive != null)
    {
      int i = 0;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject1 = null;
      for (;;)
      {
        localObject6 = localObject2;
        localObject5 = localObject3;
        localObject4 = localObject1;
        if (i >= this.mActive.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        localObject5 = localObject2;
        localObject6 = localObject3;
        Object localObject7 = localObject1;
        if (localFragment != null)
        {
          localObject4 = localObject1;
          int j;
          if (localFragment.mRetainInstance)
          {
            localObject5 = localObject1;
            if (localObject1 == null) {
              localObject5 = new ArrayList();
            }
            ((ArrayList)localObject5).add(localFragment);
            if (localFragment.mTarget == null) {
              break label249;
            }
            j = localFragment.mTarget.mIndex;
            localFragment.mTargetIndex = j;
            localObject4 = localObject5;
            if (DEBUG)
            {
              Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
              localObject4 = localObject5;
            }
          }
          if (localFragment.mChildFragmentManager != null) {
            localFragment.mChildFragmentManager.saveNonConfig();
          }
          for (localObject5 = localFragment.mChildFragmentManager.mSavedNonConfig;; localObject5 = localFragment.mChildNonConfig)
          {
            localObject1 = localObject3;
            if (localObject3 != null) {
              break label264;
            }
            localObject1 = localObject3;
            if (localObject5 == null) {
              break label264;
            }
            localObject3 = new ArrayList(this.mActive.size());
            j = 0;
            for (;;)
            {
              localObject1 = localObject3;
              if (j >= i) {
                break;
              }
              ((ArrayList)localObject3).add(null);
              j += 1;
            }
            label249:
            j = -1;
            break;
          }
          label264:
          if (localObject1 != null) {
            localObject1.add(localObject5);
          }
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            localObject3 = localObject2;
            if (localFragment.mViewModelStore != null)
            {
              localObject2 = new ArrayList(this.mActive.size());
              j = 0;
              for (;;)
              {
                localObject3 = localObject2;
                if (j >= i) {
                  break;
                }
                ((ArrayList)localObject2).add(null);
                j += 1;
              }
            }
          }
          localObject5 = localObject3;
          localObject6 = localObject1;
          localObject7 = localObject4;
          if (localObject3 != null)
          {
            ((ArrayList)localObject3).add(localFragment.mViewModelStore);
            localObject7 = localObject4;
            localObject6 = localObject1;
            localObject5 = localObject3;
          }
        }
        i += 1;
        localObject1 = localObject7;
        localObject3 = localObject6;
        localObject2 = localObject5;
      }
    }
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    if ((localObject4 == null) && (localObject5 == null) && (localObject6 == null))
    {
      this.mSavedNonConfig = null;
      return;
    }
    this.mSavedNonConfig = new FragmentManagerNonConfig(localObject4, (List)localObject5, localObject6);
  }
  
  /* Error */
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 852	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 118	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 119	java/util/ArrayList:<init>	()V
    //   17: putfield 852	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 852	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   24: invokevirtual 161	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +58 -> 93
    //   38: getstatic 90	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   41: ifeq +39 -> 80
    //   44: ldc 33
    //   46: new 310	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 854
    //   56: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iload_1
    //   60: invokevirtual 857	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc_w 859
    //   66: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual 811	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 814	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 852	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   84: iload_1
    //   85: aload_2
    //   86: invokevirtual 872	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: iload_3
    //   94: iload_1
    //   95: if_icmpge +81 -> 176
    //   98: aload_0
    //   99: getfield 852	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   102: aconst_null
    //   103: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_0
    //   108: getfield 850	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   111: ifnonnull +14 -> 125
    //   114: aload_0
    //   115: new 118	java/util/ArrayList
    //   118: dup
    //   119: invokespecial 119	java/util/ArrayList:<init>	()V
    //   122: putfield 850	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   125: getstatic 90	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   128: ifeq +29 -> 157
    //   131: ldc 33
    //   133: new 310	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 1851
    //   143: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: iload_3
    //   147: invokevirtual 857	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   150: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 814	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: aload_0
    //   158: getfield 850	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   161: iload_3
    //   162: invokestatic 1227	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: iload_3
    //   170: iconst_1
    //   171: iadd
    //   172: istore_3
    //   173: goto -80 -> 93
    //   176: getstatic 90	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   179: ifeq +39 -> 218
    //   182: ldc 33
    //   184: new 310	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 866
    //   194: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: iload_1
    //   198: invokevirtual 857	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc_w 868
    //   204: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 811	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 814	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload_0
    //   219: getfield 852	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   222: aload_2
    //   223: invokevirtual 340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
  
  public void setPrimaryNavigationFragment(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((this.mActive.get(paramFragment.mIndex) != paramFragment) || ((paramFragment.mHost != null) && (paramFragment.getFragmentManager() != this)))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    this.mPrimaryNav = paramFragment;
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
    if (this.mActive == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mActive.size())
      {
        Fragment localFragment = (Fragment)this.mActive.valueAt(i);
        if (localFragment != null) {
          performPendingDeferredStart(localFragment);
        }
        i += 1;
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
  
  public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks)
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
          if (((Pair)this.mLifecycleCallbacks.get(i)).first == paramFragmentLifecycleCallbacks) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl
 * JD-Core Version:    0.7.0.1
 */