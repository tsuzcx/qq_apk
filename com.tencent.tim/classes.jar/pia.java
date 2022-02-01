import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.QCircleInitBean.a;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter.MultiPicAdapter;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class pia
  implements View.OnClickListener
{
  public pia(QCircleFeedItemPicPresenter.MultiPicAdapter paramMultiPicAdapter, int paramInt, View paramView, FeedCloudMeta.StImage paramStImage) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.b.mExtraTypeInfo != null) && (!this.b.b.HW()) && (this.b.b.a != null))
    {
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      localStFeedListBusiReqData.tabAttachInfo.set(this.b.b.a.lT());
      Object localObject = this.b.b.a.b();
      if (localObject != null)
      {
        localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
        localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
      }
      localObject = new QCircleInitBean.a();
      ((QCircleInitBean.a)localObject).a((FeedCloudMeta.StFeed)this.b.b.mData);
      ((QCircleInitBean.a)localObject).a(this.b.b.mExtraTypeInfo.pageType);
      ((QCircleInitBean.a)localObject).a(localStFeedListBusiReqData);
      ((QCircleInitBean.a)localObject).b(this.biR);
      oux.a(this.val$itemView.getContext(), ((QCircleInitBean.a)localObject).a(), pdk.a((URLImageView)this.val$itemView, this.a.width.get(), this.a.height.get()));
      pcl.a(7, 2, this.b.b.b);
    }
    rwv.a().a(this.b.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pia
 * JD-Core Version:    0.7.0.1
 */