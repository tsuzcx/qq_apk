import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;

public final class aoss
  implements Parcelable.Creator<MediaPreviewInfo>
{
  public MediaPreviewInfo a(Parcel paramParcel)
  {
    MediaPreviewInfo localMediaPreviewInfo = new MediaPreviewInfo();
    localMediaPreviewInfo.type = paramParcel.readInt();
    localMediaPreviewInfo.imageUrl = paramParcel.readString();
    localMediaPreviewInfo.videoUrl = paramParcel.readString();
    localMediaPreviewInfo.videoLocalPath = paramParcel.readString();
    return localMediaPreviewInfo;
  }
  
  public MediaPreviewInfo[] a(int paramInt)
  {
    return new MediaPreviewInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoss
 * JD-Core Version:    0.7.0.1
 */