package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class WFastLoginInfo$1
  implements Parcelable.Creator<WFastLoginInfo>
{
  public WFastLoginInfo createFromParcel(Parcel paramParcel)
  {
    return new WFastLoginInfo(paramParcel, null);
  }
  
  public WFastLoginInfo[] newArray(int paramInt)
  {
    return new WFastLoginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WFastLoginInfo.1
 * JD-Core Version:    0.7.0.1
 */