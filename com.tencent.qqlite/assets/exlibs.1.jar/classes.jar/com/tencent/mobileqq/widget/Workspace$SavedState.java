package com.tencent.mobileqq.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import fcd;

public class Workspace$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new fcd();
  int currentScreen = -1;
  
  private Workspace$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.currentScreen = paramParcel.readInt();
  }
  
  Workspace$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.currentScreen);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.Workspace.SavedState
 * JD-Core Version:    0.7.0.1
 */