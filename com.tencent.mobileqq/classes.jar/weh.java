import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;

public class weh
  extends GridLayoutManager.SpanSizeLookup
{
  public weh(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView) {}
  
  public int getSpanSize(int paramInt)
  {
    if (((this.a.a() instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)this.a.a()).type.get() == 2) && (((FeedCloudMeta.StFeed)this.a.a()).images.size() > 1)) {
      return 1;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     weh
 * JD-Core Version:    0.7.0.1
 */