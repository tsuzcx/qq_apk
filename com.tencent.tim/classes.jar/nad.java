import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryInfo.TopicVideoCard;

public final class nad
  implements Parcelable.Creator<DiscoveryInfo.TopicVideoCard>
{
  public DiscoveryInfo.TopicVideoCard a(Parcel paramParcel)
  {
    return new DiscoveryInfo.TopicVideoCard(paramParcel);
  }
  
  public DiscoveryInfo.TopicVideoCard[] a(int paramInt)
  {
    return new DiscoveryInfo.TopicVideoCard[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nad
 * JD-Core Version:    0.7.0.1
 */