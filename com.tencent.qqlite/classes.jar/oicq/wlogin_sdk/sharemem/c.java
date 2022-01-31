package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<WloginSimpleInfo>
{
  public WloginSimpleInfo a(Parcel paramParcel)
  {
    return new WloginSimpleInfo(paramParcel, null);
  }
  
  public WloginSimpleInfo[] a(int paramInt)
  {
    return new WloginSimpleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.c
 * JD-Core Version:    0.7.0.1
 */