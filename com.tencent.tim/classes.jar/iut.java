import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvMsg;

public final class iut
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iut
 * JD-Core Version:    0.7.0.1
 */