package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator
{
  public WloginLoginInfo a(Parcel paramParcel)
  {
    return new WloginLoginInfo(paramParcel, null);
  }
  
  public WloginLoginInfo[] a(int paramInt)
  {
    return new WloginLoginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.a
 * JD-Core Version:    0.7.0.1
 */