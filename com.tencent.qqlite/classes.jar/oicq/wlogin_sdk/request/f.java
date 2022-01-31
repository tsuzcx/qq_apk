package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator<WUserSigInfo>
{
  public WUserSigInfo a(Parcel paramParcel)
  {
    return new WUserSigInfo(paramParcel, null);
  }
  
  public WUserSigInfo[] a(int paramInt)
  {
    return new WUserSigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.f
 * JD-Core Version:    0.7.0.1
 */