package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle.State;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new BackStackState.1();
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int[] mCurrentMaxLifecycleStates;
  final ArrayList<String> mFragmentWhos;
  final int mIndex;
  final String mName;
  final int[] mOldMaxLifecycleStates;
  final int[] mOps;
  final boolean mReorderingAllowed;
  final ArrayList<String> mSharedElementSourceNames;
  final ArrayList<String> mSharedElementTargetNames;
  final int mTransition;
  final int mTransitionStyle;
  
  public BackStackState(Parcel paramParcel)
  {
    this.mOps = paramParcel.createIntArray();
    this.mFragmentWhos = paramParcel.createStringArrayList();
    this.mOldMaxLifecycleStates = paramParcel.createIntArray();
    this.mCurrentMaxLifecycleStates = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mTransitionStyle = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mSharedElementSourceNames = paramParcel.createStringArrayList();
    this.mSharedElementTargetNames = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mReorderingAllowed = bool;
      return;
    }
  }
  
  public BackStackState(BackStackRecord paramBackStackRecord)
  {
    int k = paramBackStackRecord.mOps.size();
    this.mOps = new int[k * 5];
    if (!paramBackStackRecord.mAddToBackStack) {
      throw new IllegalStateException("Not on back stack");
    }
    this.mFragmentWhos = new ArrayList(k);
    this.mOldMaxLifecycleStates = new int[k];
    this.mCurrentMaxLifecycleStates = new int[k];
    int i = 0;
    int j = 0;
    if (i < k)
    {
      FragmentTransaction.Op localOp = (FragmentTransaction.Op)paramBackStackRecord.mOps.get(i);
      Object localObject = this.mOps;
      int m = j + 1;
      localObject[j] = localOp.mCmd;
      ArrayList localArrayList = this.mFragmentWhos;
      if (localOp.mFragment != null) {}
      for (localObject = localOp.mFragment.mWho;; localObject = null)
      {
        localArrayList.add(localObject);
        localObject = this.mOps;
        j = m + 1;
        localObject[m] = localOp.mEnterAnim;
        localObject = this.mOps;
        m = j + 1;
        localObject[j] = localOp.mExitAnim;
        localObject = this.mOps;
        int n = m + 1;
        localObject[m] = localOp.mPopEnterAnim;
        localObject = this.mOps;
        j = n + 1;
        localObject[n] = localOp.mPopExitAnim;
        this.mOldMaxLifecycleStates[i] = localOp.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[i] = localOp.mCurrentMaxState.ordinal();
        i += 1;
        break;
      }
    }
    this.mTransition = paramBackStackRecord.mTransition;
    this.mTransitionStyle = paramBackStackRecord.mTransitionStyle;
    this.mName = paramBackStackRecord.mName;
    this.mIndex = paramBackStackRecord.mIndex;
    this.mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
    this.mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
    this.mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
    this.mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
    this.mSharedElementSourceNames = paramBackStackRecord.mSharedElementSourceNames;
    this.mSharedElementTargetNames = paramBackStackRecord.mSharedElementTargetNames;
    this.mReorderingAllowed = paramBackStackRecord.mReorderingAllowed;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl)
  {
    int j = 0;
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int i = 0;
    if (j < this.mOps.length)
    {
      FragmentTransaction.Op localOp = new FragmentTransaction.Op();
      Object localObject = this.mOps;
      int k = j + 1;
      localOp.mCmd = localObject[j];
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " op #" + i + " base fragment #" + this.mOps[k]);
      }
      localObject = (String)this.mFragmentWhos.get(i);
      if (localObject != null) {}
      for (localOp.mFragment = ((Fragment)paramFragmentManagerImpl.mActive.get(localObject));; localOp.mFragment = null)
      {
        localOp.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i]];
        localOp.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i]];
        localObject = this.mOps;
        j = k + 1;
        localOp.mEnterAnim = localObject[k];
        localObject = this.mOps;
        k = j + 1;
        localOp.mExitAnim = localObject[j];
        localObject = this.mOps;
        j = k + 1;
        localOp.mPopEnterAnim = localObject[k];
        localOp.mPopExitAnim = this.mOps[j];
        localBackStackRecord.mEnterAnim = localOp.mEnterAnim;
        localBackStackRecord.mExitAnim = localOp.mExitAnim;
        localBackStackRecord.mPopEnterAnim = localOp.mPopEnterAnim;
        localBackStackRecord.mPopExitAnim = localOp.mPopExitAnim;
        localBackStackRecord.addOp(localOp);
        i += 1;
        j += 1;
        break;
      }
    }
    localBackStackRecord.mTransition = this.mTransition;
    localBackStackRecord.mTransitionStyle = this.mTransitionStyle;
    localBackStackRecord.mName = this.mName;
    localBackStackRecord.mIndex = this.mIndex;
    localBackStackRecord.mAddToBackStack = true;
    localBackStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
    localBackStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
    localBackStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
    localBackStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
    localBackStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
    localBackStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
    localBackStackRecord.mReorderingAllowed = this.mReorderingAllowed;
    localBackStackRecord.bumpBackStackNesting(1);
    return localBackStackRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = 0;
    paramParcel.writeIntArray(this.mOps);
    paramParcel.writeStringList(this.mFragmentWhos);
    paramParcel.writeIntArray(this.mOldMaxLifecycleStates);
    paramParcel.writeIntArray(this.mCurrentMaxLifecycleStates);
    paramParcel.writeInt(this.mTransition);
    paramParcel.writeInt(this.mTransitionStyle);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.mBreadCrumbTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(this.mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, paramParcel, 0);
    paramParcel.writeStringList(this.mSharedElementSourceNames);
    paramParcel.writeStringList(this.mSharedElementTargetNames);
    if (this.mReorderingAllowed) {
      paramInt = 1;
    }
    paramParcel.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */