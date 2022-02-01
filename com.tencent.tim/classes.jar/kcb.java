import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo;

public final class kcb
  implements Parcelable.Creator<VideoInfo>
{
  public VideoInfo a(Parcel paramParcel)
  {
    return new VideoInfo(paramParcel);
  }
  
  public VideoInfo[] a(int paramInt)
  {
    return new VideoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kcb
 * JD-Core Version:    0.7.0.1
 */