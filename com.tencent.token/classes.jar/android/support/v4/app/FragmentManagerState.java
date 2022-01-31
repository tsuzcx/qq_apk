package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new FragmentManagerState.1();
  FragmentState[] mActive;
  int[] mAdded;
  BackStackState[] mBackStack;
  int mNextFragmentIndex;
  int mPrimaryNavActiveIndex = -1;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.mActive = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.mAdded = paramParcel.createIntArray();
    this.mBackStack = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.mPrimaryNavActiveIndex = paramParcel.readInt();
    this.mNextFragmentIndex = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.mActive, paramInt);
    paramParcel.writeIntArray(this.mAdded);
    paramParcel.writeTypedArray(this.mBackStack, paramInt);
    paramParcel.writeInt(this.mPrimaryNavActiveIndex);
    paramParcel.writeInt(this.mNextFragmentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */