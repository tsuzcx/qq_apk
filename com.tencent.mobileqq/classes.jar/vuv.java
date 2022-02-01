import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class vuv
  extends vui
{
  private int b;
  
  public vuv(int paramInt)
  {
    this.b = paramInt;
  }
  
  private void a(View paramView, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    String str;
    if ((paramView instanceof BaseWidgetView))
    {
      localStFeed = (FeedCloudMeta.StFeed)((BaseWidgetView)paramView).a();
      if (localStFeed != null)
      {
        str = localStFeed.poster.id.get();
        if (!uzg.a(localStFeed.poster.id.get())) {
          break label82;
        }
      }
    }
    label82:
    for (paramView = "1";; paramView = "2")
    {
      vtq.a(str, 11, 19, paramInt, paramView, localStFeed.id.get(), "", "", "", this.b);
      return;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    QLog.d("QCircleTimeLineReportScroller", 4, "onViewAttachedToWindow" + paramViewHolder);
    if ((paramViewHolder.itemView instanceof QCircleGridFeedItemView)) {
      a(paramViewHolder.itemView, 4);
    }
    while (!(paramViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) {
      return;
    }
    a(paramViewHolder.itemView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuv
 * JD-Core Version:    0.7.0.1
 */