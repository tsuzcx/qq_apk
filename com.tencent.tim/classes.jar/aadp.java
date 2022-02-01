import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;

public final class aadp
  implements Parcelable.Creator<RedPacketInfoBase>
{
  public RedPacketInfoBase a(Parcel paramParcel)
  {
    return new RedPacketInfoBase(paramParcel);
  }
  
  public RedPacketInfoBase[] a(int paramInt)
  {
    return new RedPacketInfoBase[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadp
 * JD-Core Version:    0.7.0.1
 */