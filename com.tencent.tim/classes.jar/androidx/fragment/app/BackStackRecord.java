package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.lifecycle.Lifecycle.State;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator
{
  static final String TAG = "FragmentManager";
  boolean mCommitted;
  int mIndex = -1;
  final FragmentManagerImpl mManager;
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private static boolean isFragmentPostponed(FragmentTransaction.Op paramOp)
  {
    paramOp = paramOp.mFragment;
    return (paramOp != null) && (paramOp.mAdded) && (paramOp.mView != null) && (!paramOp.mDetached) && (!paramOp.mHidden) && (paramOp.isPostponed());
  }
  
  void bumpBackStackNesting(int paramInt)
  {
    if (!this.mAddToBackStack) {}
    for (;;)
    {
      return;
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      }
      int j = this.mOps.size();
      int i = 0;
      while (i < j)
      {
        FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
        if (localOp.mFragment != null)
        {
          Fragment localFragment = localOp.mFragment;
          localFragment.mBackStackNesting += paramInt;
          if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Bump nesting of " + localOp.mFragment + " to " + localOp.mFragment.mBackStackNesting);
          }
        }
        i += 1;
      }
    }
  }
  
  public int commit()
  {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss()
  {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean)
  {
    if (this.mCommitted) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.DEBUG)
    {
      Log.v("FragmentManager", "Commit: " + this);
      PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
      dump("  ", localPrintWriter);
      localPrintWriter.close();
    }
    this.mCommitted = true;
    if (this.mAddToBackStack) {}
    for (this.mIndex = this.mManager.allocBackStackIndex(this);; this.mIndex = -1)
    {
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    }
  }
  
  public void commitNow()
  {
    disallowAddToBackStack();
    this.mManager.execSingleAction(this, false);
  }
  
  public void commitNowAllowingStateLoss()
  {
    disallowAddToBackStack();
    this.mManager.execSingleAction(this, true);
  }
  
  @NonNull
  public FragmentTransaction detach(@NonNull Fragment paramFragment)
  {
    if ((paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.mManager)) {
      throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
    }
    return super.detach(paramFragment);
  }
  
  void doAddOp(int paramInt1, Fragment paramFragment, @Nullable String paramString, int paramInt2)
  {
    super.doAddOp(paramInt1, paramFragment, paramString, paramInt2);
    paramFragment.mFragmentManager = this.mManager;
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter)
  {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.mCommitted);
      if (this.mTransition != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.mTransition));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.mTransitionStyle));
      }
      if ((this.mEnterAnim != 0) || (this.mExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mEnterAnim));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mExitAnim));
      }
      if ((this.mPopEnterAnim != 0) || (this.mPopExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.mPopEnterAnim));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.mPopExitAnim));
      }
      if ((this.mBreadCrumbTitleRes != 0) || (this.mBreadCrumbTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.mBreadCrumbTitleText);
      }
      if ((this.mBreadCrumbShortTitleRes != 0) || (this.mBreadCrumbShortTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.mBreadCrumbShortTitleText);
      }
    }
    if (!this.mOps.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      int j = this.mOps.size();
      int i = 0;
      if (i < j)
      {
        FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
        String str;
        switch (localOp.mCmd)
        {
        default: 
          str = "cmd=" + localOp.mCmd;
        }
        for (;;)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(localOp.mFragment);
          if (paramBoolean)
          {
            if ((localOp.mEnterAnim != 0) || (localOp.mExitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp.mEnterAnim));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp.mExitAnim));
            }
            if ((localOp.mPopEnterAnim != 0) || (localOp.mPopExitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp.mPopEnterAnim));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp.mPopExitAnim));
            }
          }
          i += 1;
          break;
          str = "NULL";
          continue;
          str = "ADD";
          continue;
          str = "REPLACE";
          continue;
          str = "REMOVE";
          continue;
          str = "HIDE";
          continue;
          str = "SHOW";
          continue;
          str = "DETACH";
          continue;
          str = "ATTACH";
          continue;
          str = "SET_PRIMARY_NAV";
          continue;
          str = "UNSET_PRIMARY_NAV";
          continue;
          str = "OP_SET_MAX_LIFECYCLE";
        }
      }
    }
  }
  
  void executeOps()
  {
    int j = this.mOps.size();
    int i = 0;
    if (i < j)
    {
      FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
      Fragment localFragment = localOp.mFragment;
      if (localFragment != null) {
        localFragment.setNextTransition(this.mTransition, this.mTransitionStyle);
      }
      switch (localOp.mCmd)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localOp.mCmd);
      case 1: 
        localFragment.setNextAnim(localOp.mEnterAnim);
        this.mManager.addFragment(localFragment, false);
      }
      for (;;)
      {
        if ((!this.mReorderingAllowed) && (localOp.mCmd != 1) && (localFragment != null)) {
          this.mManager.moveFragmentToExpectedState(localFragment);
        }
        i += 1;
        break;
        localFragment.setNextAnim(localOp.mExitAnim);
        this.mManager.removeFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.mExitAnim);
        this.mManager.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.mEnterAnim);
        this.mManager.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.mExitAnim);
        this.mManager.detachFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.mEnterAnim);
        this.mManager.attachFragment(localFragment);
        continue;
        this.mManager.setPrimaryNavigationFragment(localFragment);
        continue;
        this.mManager.setPrimaryNavigationFragment(null);
        continue;
        this.mManager.setMaxLifecycle(localFragment, localOp.mCurrentMaxState);
      }
    }
    if (!this.mReorderingAllowed) {
      this.mManager.moveToState(this.mManager.mCurState, true);
    }
  }
  
  void executePopOps(boolean paramBoolean)
  {
    int i = this.mOps.size() - 1;
    if (i >= 0)
    {
      FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
      Fragment localFragment = localOp.mFragment;
      if (localFragment != null) {
        localFragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
      }
      switch (localOp.mCmd)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localOp.mCmd);
      case 1: 
        localFragment.setNextAnim(localOp.mPopExitAnim);
        this.mManager.removeFragment(localFragment);
      }
      for (;;)
      {
        if ((!this.mReorderingAllowed) && (localOp.mCmd != 3) && (localFragment != null)) {
          this.mManager.moveFragmentToExpectedState(localFragment);
        }
        i -= 1;
        break;
        localFragment.setNextAnim(localOp.mPopEnterAnim);
        this.mManager.addFragment(localFragment, false);
        continue;
        localFragment.setNextAnim(localOp.mPopEnterAnim);
        this.mManager.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.mPopExitAnim);
        this.mManager.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.mPopEnterAnim);
        this.mManager.attachFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.mPopExitAnim);
        this.mManager.detachFragment(localFragment);
        continue;
        this.mManager.setPrimaryNavigationFragment(null);
        continue;
        this.mManager.setPrimaryNavigationFragment(localFragment);
        continue;
        this.mManager.setMaxLifecycle(localFragment, localOp.mOldMaxState);
      }
    }
    if ((!this.mReorderingAllowed) && (paramBoolean)) {
      this.mManager.moveToState(this.mManager.mCurState, true);
    }
  }
  
  Fragment expandOps(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    Fragment localFragment1 = paramFragment;
    FragmentTransaction.Op localOp;
    int j;
    Fragment localFragment2;
    int k;
    label210:
    Fragment localFragment3;
    if (i < this.mOps.size())
    {
      localOp = (FragmentTransaction.Op)this.mOps.get(i);
      j = i;
      paramFragment = localFragment1;
      switch (localOp.mCmd)
      {
      default: 
        paramFragment = localFragment1;
        j = i;
      case 4: 
      case 5: 
      case 1: 
      case 7: 
      case 3: 
      case 6: 
        for (;;)
        {
          i = j + 1;
          localFragment1 = paramFragment;
          break;
          paramArrayList.add(localOp.mFragment);
          j = i;
          paramFragment = localFragment1;
          continue;
          paramArrayList.remove(localOp.mFragment);
          j = i;
          paramFragment = localFragment1;
          if (localOp.mFragment == localFragment1)
          {
            this.mOps.add(i, new FragmentTransaction.Op(9, localOp.mFragment));
            j = i + 1;
            paramFragment = null;
          }
        }
      case 2: 
        localFragment2 = localOp.mFragment;
        int n = localFragment2.mContainerId;
        j = 0;
        k = paramArrayList.size() - 1;
        paramFragment = localFragment1;
        if (k >= 0)
        {
          localFragment3 = (Fragment)paramArrayList.get(k);
          if (localFragment3.mContainerId != n) {
            break label445;
          }
          if (localFragment3 == localFragment2) {
            j = 1;
          }
        }
        break;
      }
    }
    label445:
    for (;;)
    {
      k -= 1;
      break label210;
      int m = i;
      localFragment1 = paramFragment;
      if (localFragment3 == paramFragment)
      {
        this.mOps.add(i, new FragmentTransaction.Op(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new FragmentTransaction.Op(3, localFragment3);
      paramFragment.mEnterAnim = localOp.mEnterAnim;
      paramFragment.mPopEnterAnim = localOp.mPopEnterAnim;
      paramFragment.mExitAnim = localOp.mExitAnim;
      paramFragment.mPopExitAnim = localOp.mPopExitAnim;
      this.mOps.add(m, paramFragment);
      paramArrayList.remove(localFragment3);
      i = m + 1;
      paramFragment = localFragment1;
      continue;
      if (j != 0)
      {
        this.mOps.remove(i);
        i -= 1;
      }
      for (;;)
      {
        j = i;
        break;
        localOp.mCmd = 1;
        paramArrayList.add(localFragment2);
      }
      this.mOps.add(i, new FragmentTransaction.Op(9, localFragment1));
      j = i + 1;
      paramFragment = localOp.mFragment;
      break;
      return localFragment1;
    }
  }
  
  public boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "Run: " + this);
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.valueOf(false));
    if (this.mAddToBackStack) {
      this.mManager.addBackStackState(this);
    }
    return true;
  }
  
  @Nullable
  public CharSequence getBreadCrumbShortTitle()
  {
    if (this.mBreadCrumbShortTitleRes != 0) {
      return this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes);
    }
    return this.mBreadCrumbShortTitleText;
  }
  
  public int getBreadCrumbShortTitleRes()
  {
    return this.mBreadCrumbShortTitleRes;
  }
  
  @Nullable
  public CharSequence getBreadCrumbTitle()
  {
    if (this.mBreadCrumbTitleRes != 0) {
      return this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes);
    }
    return this.mBreadCrumbTitleText;
  }
  
  public int getBreadCrumbTitleRes()
  {
    return this.mBreadCrumbTitleRes;
  }
  
  public int getId()
  {
    return this.mIndex;
  }
  
  @Nullable
  public String getName()
  {
    return this.mName;
  }
  
  @NonNull
  public FragmentTransaction hide(@NonNull Fragment paramFragment)
  {
    if ((paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.mManager)) {
      throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
    }
    return super.hide(paramFragment);
  }
  
  boolean interactsWith(int paramInt)
  {
    int k = this.mOps.size();
    int i = 0;
    while (i < k)
    {
      FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
      if (localOp.mFragment != null) {}
      for (int j = localOp.mFragment.mContainerId; (j != 0) && (j == paramInt); j = 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean interactsWith(ArrayList<BackStackRecord> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return false;
    }
    int i1 = this.mOps.size();
    int j = -1;
    int k = 0;
    int i;
    if (k < i1)
    {
      Object localObject = (FragmentTransaction.Op)this.mOps.get(k);
      if (((FragmentTransaction.Op)localObject).mFragment != null)
      {
        i = ((FragmentTransaction.Op)localObject).mFragment.mContainerId;
        if ((i == 0) || (i == j)) {
          break label200;
        }
        j = paramInt1;
      }
      for (;;)
      {
        if (j >= paramInt2) {
          break label185;
        }
        localObject = (BackStackRecord)paramArrayList.get(j);
        int i2 = ((BackStackRecord)localObject).mOps.size();
        int m = 0;
        for (;;)
        {
          if (m >= i2) {
            break label176;
          }
          FragmentTransaction.Op localOp = (FragmentTransaction.Op)((BackStackRecord)localObject).mOps.get(m);
          if (localOp.mFragment != null) {}
          for (int n = localOp.mFragment.mContainerId;; n = 0)
          {
            if (n != i) {
              break label167;
            }
            return true;
            i = 0;
            break;
          }
          label167:
          m += 1;
        }
        label176:
        j += 1;
      }
    }
    for (;;)
    {
      label185:
      k += 1;
      j = i;
      break;
      return false;
      label200:
      i = j;
    }
  }
  
  public boolean isEmpty()
  {
    return this.mOps.isEmpty();
  }
  
  boolean isPostponed()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mOps.size())
      {
        if (isFragmentPostponed((FragmentTransaction.Op)this.mOps.get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  @NonNull
  public FragmentTransaction remove(@NonNull Fragment paramFragment)
  {
    if ((paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.mManager)) {
      throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
    }
    return super.remove(paramFragment);
  }
  
  public void runOnCommitRunnables()
  {
    if (this.mCommitRunnables != null)
    {
      int i = 0;
      while (i < this.mCommitRunnables.size())
      {
        ((Runnable)this.mCommitRunnables.get(i)).run();
        i += 1;
      }
      this.mCommitRunnables = null;
    }
  }
  
  @NonNull
  public FragmentTransaction setMaxLifecycle(@NonNull Fragment paramFragment, @NonNull Lifecycle.State paramState)
  {
    if (paramFragment.mFragmentManager != this.mManager) {
      throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
    }
    if (!paramState.isAtLeast(Lifecycle.State.CREATED)) {
      throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + Lifecycle.State.CREATED);
    }
    return super.setMaxLifecycle(paramFragment, paramState);
  }
  
  void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener paramOnStartEnterTransitionListener)
  {
    int i = 0;
    while (i < this.mOps.size())
    {
      FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
      if (isFragmentPostponed(localOp)) {
        localOp.mFragment.setOnStartEnterTransitionListener(paramOnStartEnterTransitionListener);
      }
      i += 1;
    }
  }
  
  @NonNull
  public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment paramFragment)
  {
    if ((paramFragment != null) && (paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.mManager)) {
      throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
    }
    return super.setPrimaryNavigationFragment(paramFragment);
  }
  
  @NonNull
  public FragmentTransaction show(@NonNull Fragment paramFragment)
  {
    if ((paramFragment.mFragmentManager != null) && (paramFragment.mFragmentManager != this.mManager)) {
      throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + paramFragment.toString() + " is already attached to a FragmentManager.");
    }
    return super.show(paramFragment);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  Fragment trackAddedFragmentsInPop(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = this.mOps.size() - 1;
    if (i >= 0)
    {
      FragmentTransaction.Op localOp = (FragmentTransaction.Op)this.mOps.get(i);
      switch (localOp.mCmd)
      {
      }
      for (;;)
      {
        i -= 1;
        break;
        paramArrayList.remove(localOp.mFragment);
        continue;
        paramArrayList.add(localOp.mFragment);
        continue;
        paramFragment = localOp.mFragment;
        continue;
        paramFragment = null;
        continue;
        localOp.mCurrentMaxState = localOp.mOldMaxState;
      }
    }
    return paramFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.BackStackRecord
 * JD-Core Version:    0.7.0.1
 */