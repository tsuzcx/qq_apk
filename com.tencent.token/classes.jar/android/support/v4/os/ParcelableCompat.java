package android.support.v4.os;

import android.os.Parcelable.Creator;

@Deprecated
public final class ParcelableCompat
{
  @Deprecated
  public static Parcelable.Creator newCreator(ParcelableCompatCreatorCallbacks paramParcelableCompatCreatorCallbacks)
  {
    return new ParcelableCompat.ParcelableCompatCreatorHoneycombMR2(paramParcelableCompatCreatorCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.ParcelableCompat
 * JD-Core Version:    0.7.0.1
 */