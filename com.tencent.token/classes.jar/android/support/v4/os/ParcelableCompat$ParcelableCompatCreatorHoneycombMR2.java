package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class ParcelableCompat$ParcelableCompatCreatorHoneycombMR2
  implements Parcelable.ClassLoaderCreator
{
  private final ParcelableCompatCreatorCallbacks mCallbacks;
  
  ParcelableCompat$ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks paramParcelableCompatCreatorCallbacks)
  {
    this.mCallbacks = paramParcelableCompatCreatorCallbacks;
  }
  
  public Object createFromParcel(Parcel paramParcel)
  {
    return this.mCallbacks.createFromParcel(paramParcel, null);
  }
  
  public Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return this.mCallbacks.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public Object[] newArray(int paramInt)
  {
    return this.mCallbacks.newArray(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.ParcelableCompat.ParcelableCompatCreatorHoneycombMR2
 * JD-Core Version:    0.7.0.1
 */