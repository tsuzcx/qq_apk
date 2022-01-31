import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.GpsInfo4LocalImage;

public final class ihf
  implements Parcelable.Creator
{
  public GpsInfo4LocalImage a(Parcel paramParcel)
  {
    return new GpsInfo4LocalImage(paramParcel.readFloat(), paramParcel.readFloat());
  }
  
  public GpsInfo4LocalImage[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ihf
 * JD-Core Version:    0.7.0.1
 */