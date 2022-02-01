import com.tencent.biz.qqcircle.widgets.QCircleFollowView.b;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class phx
  implements QCircleFollowView.b
{
  phx(phw paramphw) {}
  
  public void bky() {}
  
  public void onClick(int paramInt)
  {
    if ((this.b.mData instanceof FeedCloudMeta.StFeed))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.b.mData;
      pcl.a(localStFeed.poster.id.get(), 17, 2, this.b.mPos, localStFeed, null);
    }
  }
  
  public void vu(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phx
 * JD-Core Version:    0.7.0.1
 */