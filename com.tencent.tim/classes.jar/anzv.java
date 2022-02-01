import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.teamwork.ReSendCmd;

public final class anzv
  implements Parcelable.Creator<ReSendCmd>
{
  public ReSendCmd a(Parcel paramParcel)
  {
    return new ReSendCmd(paramParcel);
  }
  
  public ReSendCmd[] a(int paramInt)
  {
    return new ReSendCmd[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzv
 * JD-Core Version:    0.7.0.1
 */