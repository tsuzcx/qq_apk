package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WUserSigInfo$1
  implements Parcelable.Creator<WUserSigInfo>
{
  public WUserSigInfo createFromParcel(Parcel paramParcel)
  {
    return new WUserSigInfo(paramParcel, null);
  }
  
  public WUserSigInfo[] newArray(int paramInt)
  {
    return new WUserSigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WUserSigInfo.1
 * JD-Core Version:    0.7.0.1
 */