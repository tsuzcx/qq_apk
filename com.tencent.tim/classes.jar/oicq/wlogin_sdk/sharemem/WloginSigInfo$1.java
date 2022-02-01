package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WloginSigInfo$1
  implements Parcelable.Creator<WloginSigInfo>
{
  public WloginSigInfo createFromParcel(Parcel paramParcel)
  {
    return new WloginSigInfo(paramParcel, null);
  }
  
  public WloginSigInfo[] newArray(int paramInt)
  {
    return new WloginSigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.sharemem.WloginSigInfo.1
 * JD-Core Version:    0.7.0.1
 */