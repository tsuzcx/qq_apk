package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class AbsSavedState$2
  implements Parcelable.ClassLoaderCreator<AbsSavedState>
{
  public AbsSavedState createFromParcel(Parcel paramParcel)
  {
    return createFromParcel(paramParcel, null);
  }
  
  public AbsSavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    if (paramParcel.readParcelable(paramClassLoader) != null) {
      throw new IllegalStateException("superState must be null");
    }
    return AbsSavedState.EMPTY_STATE;
  }
  
  public AbsSavedState[] newArray(int paramInt)
  {
    return new AbsSavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.customview.view.AbsSavedState.2
 * JD-Core Version:    0.7.0.1
 */