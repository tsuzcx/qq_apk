import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;

public class vap
  extends RecyclerView.ViewHolder
{
  public vap(van paramvan, View paramView)
  {
    super(paramView);
  }
  
  private boolean a(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((BaseWidgetView)this.itemView).a();
      if ((localStFeed != null) && (paramStFeed != null) && (!TextUtils.isEmpty(localStFeed.id.get())) && (!TextUtils.isEmpty(localStFeed.id.get()))) {
        return (localStFeed.id.get().equals(paramStFeed.id.get())) && (localStFeed.likeInfo.count.get() == paramStFeed.likeInfo.count.get());
      }
    }
    return false;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo, int paramInt)
  {
    if (a(paramStFeed)) {
      return;
    }
    ((QCircleWaterfallFeedItemView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
    ((QCircleWaterfallFeedItemView)this.itemView).setData(paramStFeed, paramInt);
    ((QCircleWaterfallFeedItemView)this.itemView).setDataPosInList(paramInt);
    ((QCircleWaterfallFeedItemView)this.itemView).setExtraTypeInfo(van.a(this.a));
    ((QCircleWaterfallFeedItemView)this.itemView).setInteractor(this.a.getInteractor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vap
 * JD-Core Version:    0.7.0.1
 */