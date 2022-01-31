package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ErrMsg$1
  implements Parcelable.Creator<ErrMsg>
{
  public ErrMsg createFromParcel(Parcel paramParcel)
  {
    return new ErrMsg(paramParcel, null);
  }
  
  public ErrMsg[] newArray(int paramInt)
  {
    return new ErrMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.ErrMsg.1
 * JD-Core Version:    0.7.0.1
 */