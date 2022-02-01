import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qappcenter.remote.RecvMsg;

public final class avgw
  implements Parcelable.Creator<RecvMsg>
{
  public RecvMsg a(Parcel paramParcel)
  {
    return new RecvMsg(paramParcel);
  }
  
  public RecvMsg[] a(int paramInt)
  {
    return new RecvMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avgw
 * JD-Core Version:    0.7.0.1
 */