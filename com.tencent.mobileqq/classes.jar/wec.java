import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
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

public class wec
  extends wcz
  implements aaam, View.OnClickListener
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
      this.b = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373948));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373938));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373939));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369206));
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
      if (((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!c()) && (this.jdField_a_of_type_Var != null)) {
        if (QCircleFakeAdapter.a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject))
        {
          QQToast.a(paramView.getContext(), 0, 2131697318, 0).a();
        }
        else
        {
          QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
          localStFeedListBusiReqData.tabAttachInfo.set(this.jdField_a_of_type_Var.a());
          Object localObject = this.jdField_a_of_type_Var.a();
          if (localObject != null)
          {
            localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
            localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
          }
          localObject = new QCircleLayerBean();
          ((QCircleLayerBean)localObject).setFeed((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
          ((QCircleLayerBean)localObject).setSourceType(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
          ((QCircleLayerBean)localObject).setFeedListBusiReqData(localStFeedListBusiReqData);
          if (this.jdField_a_of_type_Vup != null)
          {
            ((QCircleLayerBean)localObject).setDataPosInList(0);
            ((QCircleLayerBean)localObject).setVideoCurrentPosition(this.jdField_a_of_type_Vup.a());
          }
          vvh.a(this.jdField_a_of_type_ComTencentImageURLImageView, ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.width.get(), ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.height.get(), (QCircleLayerBean)localObject);
          uyx.a(paramView.getContext(), (QCircleLayerBean)localObject);
          vtn.a(8, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
          aaak.a().a(this);
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedVideoPositionLinkEvent)) && (this.jdField_a_of_type_Vup != null)) {
      this.jdField_a_of_type_Vup.a(((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mFeedUrl, ((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mCurrentPlayPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wec
 * JD-Core Version:    0.7.0.1
 */