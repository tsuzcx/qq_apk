import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.vip.jsoninflate.model.AlumBasicData;

public final class awlt
  implements Parcelable.Creator<AlumBasicData>
{
  public AlumBasicData a(Parcel paramParcel)
  {
    return new AlumBasicData(paramParcel);
  }
  
  public AlumBasicData[] a(int paramInt)
  {
    return new AlumBasicData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlt
 * JD-Core Version:    0.7.0.1
 */