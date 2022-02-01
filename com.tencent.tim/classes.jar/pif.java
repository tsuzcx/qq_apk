import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

public class pif
  extends phl
{
  private static final String TAG = pif.class.getSimpleName();
  private QCircleRockeyPopupView a;
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mContainer = paramViewStub.inflate();
      this.a = ((QCircleRockeyPopupView)this.mContainer.findViewById(2131373903));
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.mData;
      this.b.mDataPosition = this.mPos;
      this.b.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.b.mPlayScene = 1;
      if (this.a != null)
      {
        this.a.setFeedId(localStFeed.id.get());
        this.a.setPageType(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pif
 * JD-Core Version:    0.7.0.1
 */