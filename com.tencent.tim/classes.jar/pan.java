import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;

class pan
  implements View.OnClickListener
{
  pan(pam.a parama, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StTagInfo paramStTagInfo) {}
  
  public void onClick(View paramView)
  {
    pcp.a(16, 2, this.e, 2, 0);
    oux.ce(this.c.tagId.get(), this.c.tagName.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pan
 * JD-Core Version:    0.7.0.1
 */