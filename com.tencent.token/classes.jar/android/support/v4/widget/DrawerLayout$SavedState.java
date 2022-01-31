package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.AbsSavedState;

public class DrawerLayout$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator CREATOR = new DrawerLayout.SavedState.1();
  int lockModeEnd;
  int lockModeLeft;
  int lockModeRight;
  int lockModeStart;
  int openDrawerGravity = 0;
  
  public DrawerLayout$SavedState(@NonNull Parcel paramParcel, @Nullable ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.openDrawerGravity = paramParcel.readInt();
    this.lockModeLeft = paramParcel.readInt();
    this.lockModeRight = paramParcel.readInt();
    this.lockModeStart = paramParcel.readInt();
    this.lockModeEnd = paramParcel.readInt();
  }
  
  public DrawerLayout$SavedState(@NonNull Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.openDrawerGravity);
    paramParcel.writeInt(this.lockModeLeft);
    paramParcel.writeInt(this.lockModeRight);
    paramParcel.writeInt(this.lockModeStart);
    paramParcel.writeInt(this.lockModeEnd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout.SavedState
 * JD-Core Version:    0.7.0.1
 */