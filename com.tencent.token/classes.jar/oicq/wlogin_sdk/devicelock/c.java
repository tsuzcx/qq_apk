package oicq.wlogin_sdk.devicelock;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<DevlockInfo>
{
  public final DevlockInfo a(Parcel paramParcel)
  {
    return new DevlockInfo(paramParcel, null);
  }
  
  public final DevlockInfo[] a(int paramInt)
  {
    return new DevlockInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.c
 * JD-Core Version:    0.7.0.1
 */