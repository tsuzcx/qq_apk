import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry.BannerInfo;

public final class pru
  implements Parcelable.Creator<DiscoverBannerVideoEntry.BannerInfo>
{
  public DiscoverBannerVideoEntry.BannerInfo a(Parcel paramParcel)
  {
    return new DiscoverBannerVideoEntry.BannerInfo(paramParcel);
  }
  
  public DiscoverBannerVideoEntry.BannerInfo[] a(int paramInt)
  {
    return new DiscoverBannerVideoEntry.BannerInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pru
 * JD-Core Version:    0.7.0.1
 */