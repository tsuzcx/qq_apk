import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;

public final class kch
  implements Parcelable.Creator<VideoInfo.EntranceDownloadInfo>
{
  public VideoInfo.EntranceDownloadInfo a(Parcel paramParcel)
  {
    return new VideoInfo.EntranceDownloadInfo(paramParcel);
  }
  
  public VideoInfo.EntranceDownloadInfo[] a(int paramInt)
  {
    return new VideoInfo.EntranceDownloadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kch
 * JD-Core Version:    0.7.0.1
 */