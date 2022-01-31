package android.support.v7.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class AppCompatDelegateImplV9$PanelFeatureState$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new AppCompatDelegateImplV9.PanelFeatureState.SavedState.1();
  int featureId;
  boolean isOpen;
  Bundle menuState;
  
  static SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    boolean bool = true;
    SavedState localSavedState = new SavedState();
    localSavedState.featureId = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      localSavedState.isOpen = bool;
      if (localSavedState.isOpen) {
        localSavedState.menuState = paramParcel.readBundle(paramClassLoader);
      }
      return localSavedState;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.featureId);
    if (this.isOpen) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (this.isOpen) {
        paramParcel.writeBundle(this.menuState);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV9.PanelFeatureState.SavedState
 * JD-Core Version:    0.7.0.1
 */