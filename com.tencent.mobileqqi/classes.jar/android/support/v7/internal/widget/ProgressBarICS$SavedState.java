package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class ProgressBarICS$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new ProgressBarICS.SavedState.1();
  int progress;
  int secondaryProgress;
  
  private ProgressBarICS$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.progress = paramParcel.readInt();
    this.secondaryProgress = paramParcel.readInt();
  }
  
  ProgressBarICS$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.progress);
    paramParcel.writeInt(this.secondaryProgress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ProgressBarICS.SavedState
 * JD-Core Version:    0.7.0.1
 */