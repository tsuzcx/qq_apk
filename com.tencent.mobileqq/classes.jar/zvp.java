import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.ARRelationShipAIOMsg;

public final class zvp
  implements Parcelable.Creator
{
  public ARRelationShipAIOMsg a(Parcel paramParcel)
  {
    return new ARRelationShipAIOMsg(paramParcel);
  }
  
  public ARRelationShipAIOMsg[] a(int paramInt)
  {
    return new ARRelationShipAIOMsg[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zvp
 * JD-Core Version:    0.7.0.1
 */