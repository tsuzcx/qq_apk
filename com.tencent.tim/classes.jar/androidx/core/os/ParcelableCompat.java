package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

@Deprecated
public final class ParcelableCompat
{
  @Deprecated
  public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    return new ParcelableCompatCreatorHoneycombMR2(paramParcelableCompatCreatorCallbacks);
  }
  
  static class ParcelableCompatCreatorHoneycombMR2<T>
    implements Parcelable.ClassLoaderCreator<T>
  {
    private final ParcelableCompatCreatorCallbacks<T> mCallbacks;
    
    ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
    {
      this.mCallbacks = paramParcelableCompatCreatorCallbacks;
    }
    
    public T createFromParcel(Parcel paramParcel)
    {
      return this.mCallbacks.createFromParcel(paramParcel, null);
    }
    
    public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return this.mCallbacks.createFromParcel(paramParcel, paramClassLoader);
    }
    
    public T[] newArray(int paramInt)
    {
      return this.mCallbacks.newArray(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.os.ParcelableCompat
 * JD-Core Version:    0.7.0.1
 */