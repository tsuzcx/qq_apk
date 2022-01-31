package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class ActionBarView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new ActionBarView.SavedState.1();
  int expandedMenuItemId;
  boolean isOverflowOpen;
  
  private ActionBarView$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.expandedMenuItemId = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isOverflowOpen = bool;
      return;
    }
  }
  
  ActionBarView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.expandedMenuItemId);
    if (this.isOverflowOpen) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarView.SavedState
 * JD-Core Version:    0.7.0.1
 */