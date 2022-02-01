import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tim.call.qcall.PstnSessionInfo;

public final class atdd
  implements Parcelable.Creator<PstnSessionInfo>
{
  public PstnSessionInfo a(Parcel paramParcel)
  {
    return new PstnSessionInfo(paramParcel);
  }
  
  public PstnSessionInfo[] a(int paramInt)
  {
    return new PstnSessionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdd
 * JD-Core Version:    0.7.0.1
 */