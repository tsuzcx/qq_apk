import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.ARRelationShipAIOMsg;

public final class adcx
  implements Parcelable.Creator<ARRelationShipAIOMsg>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcx
 * JD-Core Version:    0.7.0.1
 */