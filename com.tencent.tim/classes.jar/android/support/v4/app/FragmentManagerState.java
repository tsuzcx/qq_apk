package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new FragmentManagerState.1();
  FragmentState[] mActive;
  int[] mAdded;
  BackStackState[] mBackStack;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.mActive = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.mAdded = paramParcel.createIntArray();
    try
    {
      this.mBackStack = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
      return;
    }
    catch (OutOfMemoryError paramParcel)
    {
      this.mBackStack = null;
    }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerState
 * JD-Core Version:    0.7.0.1
 */