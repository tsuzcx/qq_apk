import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;

public final class kci
  implements Parcelable.Creator<VideoInfo.GameAdComData>
{
  public VideoInfo.GameAdComData a(Parcel paramParcel)
  {
    return new VideoInfo.GameAdComData(paramParcel);
  }
  
  public VideoInfo.GameAdComData[] a(int paramInt)
  {
    return new VideoInfo.GameAdComData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kci
 * JD-Core Version:    0.7.0.1
 */