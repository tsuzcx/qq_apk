import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleTimeLineCreateTimeEvent;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class vsj
  extends vrw
{
  private void a(View paramView)
  {
    if ((paramView instanceof QCircleTimeLineFeedItemView))
    {
      paramView = (QCircleTimeLineFeedItemView)paramView;
      if ((paramView.a() instanceof FeedCloudMeta.StFeed))
      {
        paramView = (FeedCloudMeta.StFeed)paramView.a();
        QLog.d("QCircleTimeLineAndGridScroller", 1, "sendFirstItemViewData feedId:" + paramView.id.get() + "   createTime:" + paramView.createTime.get());
        zwp.a().a(new QCircleTimeLineCreateTimeEvent(paramView.createTime.get()));
      }
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof GridLayoutManager))
      {
        paramRecyclerView = (GridLayoutManager)paramRecyclerView;
        if (paramRecyclerView.getSpanCount() == 1) {
          a(paramRecyclerView.findViewByPosition(paramRecyclerView.findFirstVisibleItemPosition()));
        }
      }
      return;
    }
    catch (Exception paramRecyclerView)
    {
      QLog.d("QCircleTimeLineAndGridScroller", 1, paramRecyclerView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsj
 * JD-Core Version:    0.7.0.1
 */