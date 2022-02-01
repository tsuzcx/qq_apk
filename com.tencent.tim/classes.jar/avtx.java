import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.feed.CertifiedFakeFeed;

public final class avtx
  implements Parcelable.Creator<CertifiedFakeFeed>
{
  public CertifiedFakeFeed a(Parcel paramParcel)
  {
    return new CertifiedFakeFeed(paramParcel);
  }
  
  public CertifiedFakeFeed[] a(int paramInt)
  {
    return new CertifiedFakeFeed[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtx
 * JD-Core Version:    0.7.0.1
 */