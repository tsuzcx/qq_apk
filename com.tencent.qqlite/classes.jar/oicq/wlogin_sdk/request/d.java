package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator<TransReqContext>
{
  public TransReqContext a(Parcel paramParcel)
  {
    return new TransReqContext(paramParcel, null);
  }
  
  public TransReqContext[] a(int paramInt)
  {
    return new TransReqContext[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */