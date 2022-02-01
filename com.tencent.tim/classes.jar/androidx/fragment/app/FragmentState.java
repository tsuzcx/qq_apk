package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.State;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new FragmentState.1();
  final Bundle mArguments;
  final String mClassName;
  final int mContainerId;
  final boolean mDetached;
  final int mFragmentId;
  final boolean mFromLayout;
  final boolean mHidden;
  Fragment mInstance;
  final int mMaxLifecycleState;
  final boolean mRemoving;
  final boolean mRetainInstance;
  Bundle mSavedFragmentState;
  final String mTag;
  final String mWho;
  
  FragmentState(Parcel paramParcel)
  {
    this.mClassName = paramParcel.readString();
    this.mWho = paramParcel.readString();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.mFromLayout = bool1;
      this.mFragmentId = paramParcel.readInt();
      this.mContainerId = paramParcel.readInt();
      this.mTag = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label146;
      }
      bool1 = true;
      label69:
      this.mRetainInstance = bool1;
      if (paramParcel.readInt() == 0) {
        break label151;
      }
      bool1 = true;
      label83:
      this.mRemoving = bool1;
      if (paramParcel.readInt() == 0) {
        break label156;
      }
      bool1 = true;
      label97:
      this.mDetached = bool1;
      this.mArguments = paramParcel.readBundle();
      if (paramParcel.readInt() == 0) {
        break label161;
      }
    }
    label146:
    label151:
    label156:
    label161:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mHidden = bool1;
      this.mSavedFragmentState = paramParcel.readBundle();
      this.mMaxLifecycleState = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
      bool1 = false;
      break label83;
      bool1 = false;
      break label97;
    }
  }
  
  FragmentState(Fragment paramFragment)
  {
    this.mClassName = paramFragment.getClass().getName();
    this.mWho = paramFragment.mWho;
    this.mFromLayout = paramFragment.mFromLayout;
    this.mFragmentId = paramFragment.mFragmentId;
    this.mContainerId = paramFragment.mContainerId;
    this.mTag = paramFragment.mTag;
    this.mRetainInstance = paramFragment.mRetainInstance;
    this.mRemoving = paramFragment.mRemoving;
    this.mDetached = paramFragment.mDetached;
    this.mArguments = paramFragment.mArguments;
    this.mHidden = paramFragment.mHidden;
    this.mMaxLifecycleState = paramFragment.mMaxState.ordinal();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Fragment instantiate(@NonNull ClassLoader paramClassLoader, @NonNull FragmentFactory paramFragmentFactory)
  {
    if (this.mInstance == null)
    {
      if (this.mArguments != null) {
        this.mArguments.setClassLoader(paramClassLoader);
      }
      this.mInstance = paramFragmentFactory.instantiate(paramClassLoader, this.mClassName);
      this.mInstance.setArguments(this.mArguments);
      if (this.mSavedFragmentState == null) {
        break label233;
      }
      this.mSavedFragmentState.setClassLoader(paramClassLoader);
    }
    label233:
    for (this.mInstance.mSavedFragmentState = this.mSavedFragmentState;; this.mInstance.mSavedFragmentState = new Bundle())
    {
      this.mInstance.mWho = this.mWho;
      this.mInstance.mFromLayout = this.mFromLayout;
      this.mInstance.mRestored = true;
      this.mInstance.mFragmentId = this.mFragmentId;
      this.mInstance.mContainerId = this.mContainerId;
      this.mInstance.mTag = this.mTag;
      this.mInstance.mRetainInstance = this.mRetainInstance;
      this.mInstance.mRemoving = this.mRemoving;
      this.mInstance.mDetached = this.mDetached;
      this.mInstance.mHidden = this.mHidden;
      this.mInstance.mMaxState = Lifecycle.State.values()[this.mMaxLifecycleState];
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Instantiated fragment " + this.mInstance);
      }
      return this.mInstance;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentState{");
    localStringBuilder.append(this.mClassName);
    localStringBuilder.append(" (");
    localStringBuilder.append(this.mWho);
    localStringBuilder.append(")}:");
    if (this.mFromLayout) {
      localStringBuilder.append(" fromLayout");
    }
    if (this.mContainerId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.mContainerId));
    }
    if ((this.mTag != null) && (!this.mTag.isEmpty()))
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(this.mTag);
    }
    if (this.mRetainInstance) {
      localStringBuilder.append(" retainInstance");
    }
    if (this.mRemoving) {
      localStringBuilder.append(" removing");
    }
    if (this.mDetached) {
      localStringBuilder.append(" detached");
    }
    if (this.mHidden) {
      localStringBuilder.append(" hidden");
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.mClassName);
    paramParcel.writeString(this.mWho);
    if (this.mFromLayout)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mFragmentId);
      paramParcel.writeInt(this.mContainerId);
      paramParcel.writeString(this.mTag);
      if (!this.mRetainInstance) {
        break label142;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!this.mRemoving) {
        break label147;
      }
      paramInt = 1;
      label79:
      paramParcel.writeInt(paramInt);
      if (!this.mDetached) {
        break label152;
      }
      paramInt = 1;
      label93:
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.mArguments);
      if (!this.mHidden) {
        break label157;
      }
    }
    label142:
    label147:
    label152:
    label157:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.mSavedFragmentState);
      paramParcel.writeInt(this.mMaxLifecycleState);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
      paramInt = 0;
      break label79;
      paramInt = 0;
      break label93;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.fragment.app.FragmentState
 * JD-Core Version:    0.7.0.1
 */