package oicq.wlogin_sdk.tools;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<ErrMsg>
{
  public ErrMsg a(Parcel paramParcel)
  {
    return new ErrMsg(paramParcel, null);
  }
  
  public ErrMsg[] a(int paramInt)
  {
    return new ErrMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.b
 * JD-Core Version:    0.7.0.1
 */