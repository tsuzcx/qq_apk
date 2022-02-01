import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.VideoAdInfo;

public final class kby
  implements Parcelable.Creator<VideoAdInfo>
{
  public VideoAdInfo a(Parcel paramParcel)
  {
    return new VideoAdInfo(paramParcel);
  }
  
  public VideoAdInfo[] a(int paramInt)
  {
    return new VideoAdInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kby
 * JD-Core Version:    0.7.0.1
 */