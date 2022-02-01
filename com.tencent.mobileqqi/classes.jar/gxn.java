import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyLBSApiPOI;

public final class gxn
  implements Parcelable.Creator
{
  public TroopBarUtils.MyLBSApiPOI a(Parcel paramParcel)
  {
    return new TroopBarUtils.MyLBSApiPOI(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString(), paramParcel.readInt(), paramParcel.readString());
  }
  
  public TroopBarUtils.MyLBSApiPOI[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gxn
 * JD-Core Version:    0.7.0.1
 */