package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e
  implements Parcelable.Creator<WFastLoginInfo>
{
  public WFastLoginInfo a(Parcel paramParcel)
  {
    return new WFastLoginInfo(paramParcel, null);
  }
  
  public WFastLoginInfo[] a(int paramInt)
  {
    return new WFastLoginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.e
 * JD-Core Version:    0.7.0.1
 */