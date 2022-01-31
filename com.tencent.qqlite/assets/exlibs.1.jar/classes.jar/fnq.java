import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsData.QzoneGpsInfo;

public final class fnq
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fnq
 * JD-Core Version:    0.7.0.1
 */