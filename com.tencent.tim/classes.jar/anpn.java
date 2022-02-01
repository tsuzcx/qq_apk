import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.statistics.UEC.UECItem;

public final class anpn
  implements Parcelable.Creator<UEC.UECItem>
{
  public UEC.UECItem a(Parcel paramParcel)
  {
    UEC.UECItem localUECItem = new UEC.UECItem();
    localUECItem.mKey = paramParcel.readString();
    localUECItem.dLa = paramParcel.readInt();
    localUECItem.anB = paramParcel.readLong();
    localUECItem.dLb = paramParcel.readInt();
    localUECItem.cgf = paramParcel.readString();
    localUECItem.cgg = paramParcel.readString();
    localUECItem.mDomain = paramParcel.readString();
    localUECItem.mVersion = paramParcel.readString();
    localUECItem.aKU = paramParcel.readString();
    return localUECItem;
  }
  
  public UEC.UECItem[] a(int paramInt)
  {
    return new UEC.UECItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anpn
 * JD-Core Version:    0.7.0.1
 */