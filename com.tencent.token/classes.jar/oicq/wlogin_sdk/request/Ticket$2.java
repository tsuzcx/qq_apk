package oicq.wlogin_sdk.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Ticket$2
  implements Parcelable.Creator<Ticket>
{
  public final Ticket createFromParcel(Parcel paramParcel)
  {
    return new Ticket(paramParcel, null);
  }
  
  public final Ticket[] newArray(int paramInt)
  {
    return new Ticket[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.Ticket.2
 * JD-Core Version:    0.7.0.1
 */