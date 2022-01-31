import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsData.QzoneGpsInfo;

public final class ibt
  implements Parcelable.Creator
{
  public LbsData.QzoneGpsInfo a(Parcel paramParcel)
  {
    return new LbsData.QzoneGpsInfo(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public LbsData.QzoneGpsInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ibt
 * JD-Core Version:    0.7.0.1
 */