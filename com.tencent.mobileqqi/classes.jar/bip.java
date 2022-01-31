import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.service.RecvMsg;

public final class bip
  implements Parcelable.Creator
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bip
 * JD-Core Version:    0.7.0.1
 */