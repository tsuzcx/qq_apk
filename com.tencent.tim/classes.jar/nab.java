import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryBannerInfo;

public final class nab
  implements Parcelable.Creator<DiscoveryBannerInfo>
{
  public DiscoveryBannerInfo a(Parcel paramParcel)
  {
    return new DiscoveryBannerInfo(paramParcel);
  }
  
  public DiscoveryBannerInfo[] a(int paramInt)
  {
    return new DiscoveryBannerInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nab
 * JD-Core Version:    0.7.0.1
 */