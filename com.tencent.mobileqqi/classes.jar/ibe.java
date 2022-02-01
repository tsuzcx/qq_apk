import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qlink.SendMsg;

public final class ibe
  implements Parcelable.Creator
{
  public SendMsg a(Parcel paramParcel)
  {
    return new SendMsg(paramParcel);
  }
  
  public SendMsg[] a(int paramInt)
  {
    return new SendMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ibe
 * JD-Core Version:    0.7.0.1
 */