import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qlink.SendMsg;

public final class avik
  implements Parcelable.Creator<SendMsg>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avik
 * JD-Core Version:    0.7.0.1
 */