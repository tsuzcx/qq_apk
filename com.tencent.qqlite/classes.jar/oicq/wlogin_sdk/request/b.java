package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<Ticket>
{
  public Ticket a(Parcel paramParcel)
  {
    return new Ticket(paramParcel, null);
  }
  
  public Ticket[] a(int paramInt)
  {
    return new Ticket[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.b
 * JD-Core Version:    0.7.0.1
 */