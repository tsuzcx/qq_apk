package android.support.v4.os;

import android.os.Parcel;

@Deprecated
public abstract interface ParcelableCompatCreatorCallbacks
{
  public abstract Object createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader);
  
  public abstract Object[] newArray(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.ParcelableCompatCreatorCallbacks
 * JD-Core Version:    0.7.0.1
 */