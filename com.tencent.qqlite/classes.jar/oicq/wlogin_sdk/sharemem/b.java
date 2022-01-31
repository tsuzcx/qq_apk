package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<WloginSigInfo>
{
  public WloginSigInfo a(Parcel paramParcel)
  {
    return new WloginSigInfo(paramParcel, null);
  }
  
  public WloginSigInfo[] a(int paramInt)
  {
    return new WloginSigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.b
 * JD-Core Version:    0.7.0.1
 */