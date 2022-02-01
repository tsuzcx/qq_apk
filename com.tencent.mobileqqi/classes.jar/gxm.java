import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyBar;

public final class gxm
  implements Parcelable.Creator
{
  public TroopBarUtils.MyBar a(Parcel paramParcel)
  {
    return new TroopBarUtils.MyBar(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
  }
  
  public TroopBarUtils.MyBar[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxm
 * JD-Core Version:    0.7.0.1
 */