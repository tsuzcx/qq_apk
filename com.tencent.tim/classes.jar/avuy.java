import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.QCirclePublishPictureTagInfo;

public final class avuy
  implements Parcelable.Creator<QCirclePublishPictureTagInfo>
{
  public QCirclePublishPictureTagInfo a(Parcel paramParcel)
  {
    QCirclePublishPictureTagInfo localQCirclePublishPictureTagInfo = new QCirclePublishPictureTagInfo();
    localQCirclePublishPictureTagInfo.picId = paramParcel.readString();
    localQCirclePublishPictureTagInfo.picTags = paramParcel.readArrayList(String.class.getClassLoader());
    return localQCirclePublishPictureTagInfo;
  }
  
  public QCirclePublishPictureTagInfo[] a(int paramInt)
  {
    return new QCirclePublishPictureTagInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avuy
 * JD-Core Version:    0.7.0.1
 */