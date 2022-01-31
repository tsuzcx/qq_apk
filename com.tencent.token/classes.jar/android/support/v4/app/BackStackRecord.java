package android.support.v4.app;

import android.content.Context;
import android.support.v4.util.LogWriter;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator
{
  static final int OP_ADD = 1;
  static final int OP_ATTACH = 7;
  static final int OP_DETACH = 6;
  static final int OP_HIDE = 4;
  static final int OP_NULL = 0;
  static final int OP_REMOVE = 3;
  static final int OP_REPLACE = 2;
  static final int OP_SET_PRIMARY_NAV = 8;
  static final int OP_SHOW = 5;
  static final int OP_UNSET_PRIMARY_NAV = 9;
  static final String TAG = "FragmentManager";
  boolean mAddToBackStack;
  boolean mAllowAddToBackStack = true;
  int mBreadCrumbShortTitleRes;
  CharSequence mBreadCrumbShortTitleText;
  int mBreadCrumbTitleRes;
  CharSequence mBreadCrumbTitleText;
  ArrayList mCommitRunnables;
  boolean mCommitted;
  int mEnterAnim;
  int mExitAnim;
  int mIndex = -1;
  final FragmentManagerImpl mManager;
  String mName;
  ArrayList mOps = new ArrayList();
  int mPopEnterAnim;
  int mPopExitAnim;
  boolean mReorderingAllowed = false;
  ArrayList mSharedElementSourceNames;
  ArrayList mSharedElementTargetNames;
  int mTransition;
  int mTransitionStyle;
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Class localClass = paramFragment.getClass();
    int i = localClass.getModifiers();
    if ((localClass.isAnonymousClass()) || (!Modifier.isPublic(i)) || ((localClass.isMemberClass()) && (!Modifier.isStatic(i)))) {
      throw new IllegalStateException("Fragment " + localClass.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
    }
    paramFragment.mFragmentManager = this.mManager;
    if (paramString != null)
    {
      if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
      }
      paramFragment.mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == -1) {
        throw new IllegalArgumentException("Can't add fragment " + paramFragment + " with tag " + paramString + " to container view with no id");
      }
      if ((paramFragment.mFragmentId != 0) && (paramFragment.mFragmentId != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1);
      }
      paramFragment.mFragmentId = paramInt1;
      paramFragment.mContainerId = paramInt1;
    }
    addOp(new BackStackRecord.Op(paramInt2, paramFragment));
  }
  
  private static boolean isFragmentPostponed(BackStackRecord.Op paramOp)
  {
    paramOp = paramOp.fragment;
    return (paramOp != null) && (paramOp.mAdded) && (paramOp.mView != null) && (!paramOp.mDetached) && (!paramOp.mHidden) && (paramOp.isPostponed());
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment)
  {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString)
  {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString)
  {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  void addOp(BackStackRecord.Op paramOp)
  {
    this.mOps.add(paramOp);
    paramOp.enterAnim = this.mEnterAnim;
    paramOp.exitAnim = this.mExitAnim;
    paramOp.popEnterAnim = this.mPopEnterAnim;
    paramOp.popExitAnim = this.mPopExitAnim;
  }
  
  public FragmentTransaction addSharedElement(View paramView, String paramString)
  {
    if (FragmentTransition.supportsTransition())
    {
      paramView = ViewCompat.getTransitionName(paramView);
      if (paramView == null) {
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
      }
      if (this.mSharedElementSourceNames != null) {
        break label74;
      }
      this.mSharedElementSourceNames = new ArrayList();
      this.mSharedElementTargetNames = new ArrayList();
    }
    label74:
    do
    {
      this.mSharedElementSourceNames.add(paramView);
      this.mSharedElementTargetNames.add(paramString);
      return this;
      if (this.mSharedElementTargetNames.contains(paramString)) {
        throw new IllegalArgumentException("A shared element with the target name '" + paramString + "' has already been added to the transaction.");
      }
    } while (!this.mSharedElementSourceNames.contains(paramView));
    throw new IllegalArgumentException("A shared element with the source name '" + paramView + " has already been added to the transaction.");
  }
  
  public FragmentTransaction addToBackStack(String paramString)
  {
    if (!this.mAllowAddToBackStack) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    this.mAddToBackStack = true;
    this.mName = paramString;
    return this;
  }
  
  public FragmentTransaction attach(Fragment paramFragment)
  {
    addOp(new BackStackRecord.Op(7, paramFragment));
    return this;
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
        BackStackRecord.Op localOp = (BackStackRecord.Op)this.mOps.get(i);
        if (localOp.fragment != null)
        {
          Fragment localFragment = localOp.fragment;
          localFragment.mBackStackNesting += paramInt;
          if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Bump nesting of " + localOp.fragment + " to " + localOp.fragment.mBackStackNesting);
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
      dump("  ", null, localPrintWriter, null);
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
  
  public FragmentTransaction detach(Fragment paramFragment)
  {
    addOp(new BackStackRecord.Op(6, paramFragment));
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack()
  {
    if (this.mAddToBackStack) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    this.mAllowAddToBackStack = false;
    return this;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
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
      new StringBuilder().append(paramString).append("    ").toString();
      int j = this.mOps.size();
      int i = 0;
      if (i < j)
      {
        BackStackRecord.Op localOp = (BackStackRecord.Op)this.mOps.get(i);
        String str;
        switch (localOp.cmd)
        {
        default: 
          str = "cmd=" + localOp.cmd;
        }
        for (;;)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(localOp.fragment);
          if (paramBoolean)
          {
            if ((localOp.enterAnim != 0) || (localOp.exitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp.enterAnim));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp.exitAnim));
            }
            if ((localOp.popEnterAnim != 0) || (localOp.popExitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(localOp.popEnterAnim));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(localOp.popExitAnim));
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
      BackStackRecord.Op localOp = (BackStackRecord.Op)this.mOps.get(i);
      Fragment localFragment = localOp.fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(this.mTransition, this.mTransitionStyle);
      }
      switch (localOp.cmd)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
      case 1: 
        localFragment.setNextAnim(localOp.enterAnim);
        this.mManager.addFragment(localFragment, false);
      }
      for (;;)
      {
        if ((!this.mReorderingAllowed) && (localOp.cmd != 1) && (localFragment != null)) {
          this.mManager.moveFragmentToExpectedState(localFragment);
        }
        i += 1;
        break;
        localFragment.setNextAnim(localOp.exitAnim);
        this.mManager.removeFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.exitAnim);
        this.mManager.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.enterAnim);
        this.mManager.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.exitAnim);
        this.mManager.detachFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.enterAnim);
        this.mManager.attachFragment(localFragment);
        continue;
        this.mManager.setPrimaryNavigationFragment(localFragment);
        continue;
        this.mManager.setPrimaryNavigationFragment(null);
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
      BackStackRecord.Op localOp = (BackStackRecord.Op)this.mOps.get(i);
      Fragment localFragment = localOp.fragment;
      if (localFragment != null) {
        localFragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
      }
      switch (localOp.cmd)
      {
      case 2: 
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
      case 1: 
        localFragment.setNextAnim(localOp.popExitAnim);
        this.mManager.removeFragment(localFragment);
      }
      for (;;)
      {
        if ((!this.mReorderingAllowed) && (localOp.cmd != 3) && (localFragment != null)) {
          this.mManager.moveFragmentToExpectedState(localFragment);
        }
        i -= 1;
        break;
        localFragment.setNextAnim(localOp.popEnterAnim);
        this.mManager.addFragment(localFragment, false);
        continue;
        localFragment.setNextAnim(localOp.popEnterAnim);
        this.mManager.showFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.popExitAnim);
        this.mManager.hideFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.popEnterAnim);
        this.mManager.attachFragment(localFragment);
        continue;
        localFragment.setNextAnim(localOp.popExitAnim);
        this.mManager.detachFragment(localFragment);
        continue;
        this.mManager.setPrimaryNavigationFragment(null);
        continue;
        this.mManager.setPrimaryNavigationFragment(localFragment);
      }
    }
    if ((!this.mReorderingAllowed) && (paramBoolean)) {
      this.mManager.moveToState(this.mManager.mCurState, true);
    }
  }
  
  Fragment expandOps(ArrayList paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    Fragment localFragment1 = paramFragment;
    BackStackRecord.Op localOp;
    int j;
    Fragment localFragment2;
    int k;
    label210:
    Fragment localFragment3;
    if (i < this.mOps.size())
    {
      localOp = (BackStackRecord.Op)this.mOps.get(i);
      j = i;
      paramFragment = localFragment1;
      switch (localOp.cmd)
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
          paramArrayList.add(localOp.fragment);
          j = i;
          paramFragment = localFragment1;
          continue;
          paramArrayList.remove(localOp.fragment);
          j = i;
          paramFragment = localFragment1;
          if (localOp.fragment == localFragment1)
          {
            this.mOps.add(i, new BackStackRecord.Op(9, localOp.fragment));
            j = i + 1;
            paramFragment = null;
          }
        }
      case 2: 
        localFragment2 = localOp.fragment;
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
        this.mOps.add(i, new BackStackRecord.Op(9, localFragment3));
        m = i + 1;
        localFragment1 = null;
      }
      paramFragment = new BackStackRecord.Op(3, localFragment3);
      paramFragment.enterAnim = localOp.enterAnim;
      paramFragment.popEnterAnim = localOp.popEnterAnim;
      paramFragment.exitAnim = localOp.exitAnim;
      paramFragment.popExitAnim = localOp.popExitAnim;
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
        localOp.cmd = 1;
        paramArrayList.add(localFragment2);
      }
      this.mOps.add(i, new BackStackRecord.Op(9, localFragment1));
      j = i + 1;
      paramFragment = localOp.fragment;
      break;
      return localFragment1;
    }
  }
  
  public boolean generateOps(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "Run: " + this);
    }
    paramArrayList1.add(this);
    paramArrayList2.add(Boolean.valueOf(false));
    if (this.mAddToBackStack) {
      this.mManager.addBackStackState(this);
    }
    return true;
  }
  
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
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getTransition()
  {
    return this.mTransition;
  }
  
  public int getTransitionStyle()
  {
    return this.mTransitionStyle;
  }
  
  public FragmentTransaction hide(Fragment paramFragment)
  {
    addOp(new BackStackRecord.Op(4, paramFragment));
    return this;
  }
  
  boolean interactsWith(int paramInt)
  {
    int k = this.mOps.size();
    int i = 0;
    while (i < k)
    {
      BackStackRecord.Op localOp = (BackStackRecord.Op)this.mOps.get(i);
      if (localOp.fragment != null) {}
      for (int j = localOp.fragment.mContainerId; (j != 0) && (j == paramInt); j = 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean interactsWith(ArrayList paramArrayList, int paramInt1, int paramInt2)
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
      Object localObject = (BackStackRecord.Op)this.mOps.get(k);
      if (((BackStackRecord.Op)localObject).fragment != null)
      {
        i = ((BackStackRecord.Op)localObject).fragment.mContainerId;
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
          BackStackRecord.Op localOp = (BackStackRecord.Op)((BackStackRecord)localObject).mOps.get(m);
          if (localOp.fragment != null) {}
          for (int n = localOp.fragment.mContainerId;; n = 0)
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
  
  public boolean isAddToBackStackAllowed()
  {
    return this.mAllowAddToBackStack;
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
        if (isFragmentPostponed((BackStackRecord.Op)this.mOps.get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public FragmentTransaction remove(Fragment paramFragment)
  {
    addOp(new BackStackRecord.Op(3, paramFragment));
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment)
  {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    doAddOp(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public FragmentTransaction runOnCommit(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("runnable cannot be null");
    }
    disallowAddToBackStack();
    if (this.mCommitRunnables == null) {
      this.mCommitRunnables = new ArrayList();
    }
    this.mCommitRunnables.add(paramRunnable);
    return this;
  }
  
  public void runOnCommitRunnables()
  {
    if (this.mCommitRunnables != null)
    {
      int j = this.mCommitRunnables.size();
      int i = 0;
      while (i < j)
      {
        ((Runnable)this.mCommitRunnables.get(i)).run();
        i += 1;
      }
      this.mCommitRunnables = null;
    }
  }
  
  public FragmentTransaction setAllowOptimization(boolean paramBoolean)
  {
    return setReorderingAllowed(paramBoolean);
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt)
  {
    this.mBreadCrumbShortTitleRes = paramInt;
    this.mBreadCrumbShortTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbShortTitleRes = 0;
    this.mBreadCrumbShortTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt)
  {
    this.mBreadCrumbTitleRes = paramInt;
    this.mBreadCrumbTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbTitleRes = 0;
    this.mBreadCrumbTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2)
  {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEnterAnim = paramInt1;
    this.mExitAnim = paramInt2;
    this.mPopEnterAnim = paramInt3;
    this.mPopExitAnim = paramInt4;
    return this;
  }
  
  void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener paramOnStartEnterTransitionListener)
  {
    int i = 0;
    while (i < this.mOps.size())
    {
      BackStackRecord.Op localOp = (BackStackRecord.Op)this.mOps.get(i);
      if (isFragmentPostponed(localOp)) {
        localOp.fragment.setOnStartEnterTransitionListener(paramOnStartEnterTransitionListener);
      }
      i += 1;
    }
  }
  
  public FragmentTransaction setPrimaryNavigationFragment(Fragment paramFragment)
  {
    addOp(new BackStackRecord.Op(8, paramFragment));
    return this;
  }
  
  public FragmentTransaction setReorderingAllowed(boolean paramBoolean)
  {
    this.mReorderingAllowed = paramBoolean;
    return this;
  }
  
  public FragmentTransaction setTransition(int paramInt)
  {
    this.mTransition = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt)
  {
    this.mTransitionStyle = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment)
  {
    addOp(new BackStackRecord.Op(5, paramFragment));
    return this;
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
  
  Fragment trackAddedFragmentsInPop(ArrayList paramArrayList, Fragment paramFragment)
  {
    int i = 0;
    Fragment localFragment = paramFragment;
    if (i < this.mOps.size())
    {
      BackStackRecord.Op localOp = (BackStackRecord.Op)this.mOps.get(i);
      paramFragment = localFragment;
      switch (localOp.cmd)
      {
      default: 
        paramFragment = localFragment;
      }
      for (;;)
      {
        i += 1;
        localFragment = paramFragment;
        break;
        paramArrayList.remove(localOp.fragment);
        paramFragment = localFragment;
        continue;
        paramArrayList.add(localOp.fragment);
        paramFragment = localFragment;
        continue;
        paramFragment = localOp.fragment;
        continue;
        paramFragment = null;
      }
    }
    return localFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackRecord
 * JD-Core Version:    0.7.0.1
 */