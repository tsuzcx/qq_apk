package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

public class Toolbar$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator CREATOR = new Toolbar.SavedState.1();
  int expandedMenuItemId;
  boolean isOverflowOpen;
  
  public Toolbar$SavedState(Parcel paramParcel)
  {
    this(paramParcel, null);
  }
  
  public Toolbar$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.expandedMenuItemId = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isOverflowOpen = bool;
      return;
    }
  }
  
  public Toolbar$SavedState(Parcelable paramParcelable)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.Toolbar.SavedState
 * JD-Core Version:    0.7.0.1
 */