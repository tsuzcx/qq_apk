import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.AdTagInfo;

public final class kcc
  implements Parcelable.Creator<VideoInfo.AdTagInfo>
{
  public VideoInfo.AdTagInfo a(Parcel paramParcel)
  {
    return new VideoInfo.AdTagInfo(paramParcel);
  }
  
  public VideoInfo.AdTagInfo[] a(int paramInt)
  {
    return new VideoInfo.AdTagInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kcc
 * JD-Core Version:    0.7.0.1
 */