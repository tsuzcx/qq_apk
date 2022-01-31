package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WloginSimpleInfo$1
  implements Parcelable.Creator<WloginSimpleInfo>
{
  public WloginSimpleInfo createFromParcel(Parcel paramParcel)
  {
    return new WloginSimpleInfo(paramParcel, null);
  }
  
  public WloginSimpleInfo[] newArray(int paramInt)
  {
    return new WloginSimpleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginSimpleInfo.1
 * JD-Core Version:    0.7.0.1
 */