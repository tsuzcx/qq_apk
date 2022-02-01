import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.model.VideoUrl;

public final class avvb
  implements Parcelable.Creator<VideoUrl>
{
  public VideoUrl a(Parcel paramParcel)
  {
    VideoUrl localVideoUrl = new VideoUrl();
    localVideoUrl.url = paramParcel.readString();
    localVideoUrl.decoderType = paramParcel.readInt();
    localVideoUrl.videoRate = paramParcel.readInt();
    return localVideoUrl;
  }
  
  public VideoUrl[] a(int paramInt)
  {
    return new VideoUrl[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avvb
 * JD-Core Version:    0.7.0.1
 */