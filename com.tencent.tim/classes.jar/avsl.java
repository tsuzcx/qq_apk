import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.album.QzonePhotoInfo;

public final class avsl
  implements Parcelable.Creator<QzonePhotoInfo>
{
  public QzonePhotoInfo a(Parcel paramParcel)
  {
    return new QzonePhotoInfo(paramParcel);
  }
  
  public QzonePhotoInfo[] a(int paramInt)
  {
    return new QzonePhotoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsl
 * JD-Core Version:    0.7.0.1
 */