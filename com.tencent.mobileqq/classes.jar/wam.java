import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class wam
  extends vzj
  implements View.OnClickListener, zwr
{
  public FrameLayout b;
  
  protected String a()
  {
    return "QCircleTimeLineFeedItemVideoPresenter";
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.b = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373818));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373810));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373811));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369116));
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      paramObject = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      this.b.getLayoutParams().width = (QCircleTimeLineFeedItemView.jdField_a_of_type_Int * 2);
      this.b.getLayoutParams().height = (QCircleTimeLineFeedItemView.jdField_a_of_type_Int * 2);
      this.b.setLayoutParams(this.b.getLayoutParams());
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = (QCircleTimeLineFeedItemView.jdField_a_of_type_Int * 2);
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = (QCircleTimeLineFeedItemView.jdField_a_of_type_Int * 2);
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedVideoPositionLinkEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!c()) && (this.jdField_a_of_type_Uzb != null)) {
        if (QCircleFakeAdapter.a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject))
        {
          QQToast.a(paramView.getContext(), 0, 2131697243, 0).a();
        }
        else
        {
          Object localObject1 = new QQCircleFeedBase.StFeedListBusiReqData();
          ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tabAttachInfo.set(this.jdField_a_of_type_Uzb.a());
          Object localObject2 = this.jdField_a_of_type_Uzb.a();
          if (localObject2 != null)
          {
            ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagId.set(((QCircleInitBean)localObject2).getTagInfo().tagId.get());
            ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagName.set(((QCircleInitBean)localObject2).getTagInfo().tagName.get());
          }
          localObject2 = new uxk();
          ((uxk)localObject2).a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
          ((uxk)localObject2).a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
          ((uxk)localObject2).a((QQCircleFeedBase.StFeedListBusiReqData)localObject1);
          localObject1 = ((uxk)localObject2).a();
          if (this.jdField_a_of_type_Vsc != null)
          {
            ((QCircleInitBean)localObject1).mDataPosInList = 0;
            ((QCircleInitBean)localObject1).mVideoCurrentPosition = this.jdField_a_of_type_Vsc.a();
          }
          uxo.a(paramView.getContext(), (QCircleInitBean)localObject1, vsn.a(this.jdField_a_of_type_ComTencentImageURLImageView, ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.width.get(), ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.height.get()));
          vrc.a(8, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
          zwp.a().a(this);
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedVideoPositionLinkEvent)) && (this.jdField_a_of_type_Vsc != null)) {
      this.jdField_a_of_type_Vsc.a(((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mFeedUrl, ((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mCurrentPlayPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wam
 * JD-Core Version:    0.7.0.1
 */