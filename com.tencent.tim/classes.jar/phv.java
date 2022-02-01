import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;

public class phv
  extends phl
{
  private QCircleDoublePraiseView c;
  private float lT = 1.777778F;
  private float lU = 0.75F;
  private int mWidth = ImmersiveUtils.getScreenWidth();
  
  private void q(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.type.get() != 3) {
      return;
    }
    int m = paramStFeed.video.width.get();
    int n = paramStFeed.video.height.get();
    int k = this.mWidth;
    int j = this.mWidth;
    int i = j;
    float f;
    if (m != 0)
    {
      i = j;
      if (n != 0)
      {
        f = m / n;
        if (f < this.lT) {
          break label129;
        }
        i = (int)(k / this.lT);
      }
    }
    for (;;)
    {
      this.c.getLayoutParams().width = k;
      this.c.getLayoutParams().height = i;
      this.c.setLayoutParams(this.c.getLayoutParams());
      return;
      label129:
      if ((f > this.lU) && (f <= this.lT)) {
        i = (int)(k / f);
      } else {
        i = (int)(k / this.lU);
      }
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mContainer = paramViewStub.inflate();
      this.c = ((QCircleDoublePraiseView)this.mContainer.findViewById(2131373877));
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
      if (this.c != null)
      {
        this.c.setFeed(localStFeed);
        this.c.setPageType(this.mExtraTypeInfo.pageType);
        q(localStFeed);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phv
 * JD-Core Version:    0.7.0.1
 */