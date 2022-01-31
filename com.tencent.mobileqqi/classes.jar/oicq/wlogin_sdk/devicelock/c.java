package oicq.wlogin_sdk.devicelock;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<DevlockInfo>
{
  public DevlockInfo a(Parcel paramParcel)
  {
    return new DevlockInfo(paramParcel, null);
  }
  
  public DevlockInfo[] a(int paramInt)
  {
    return new DevlockInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.c
 * JD-Core Version:    0.7.0.1
 */